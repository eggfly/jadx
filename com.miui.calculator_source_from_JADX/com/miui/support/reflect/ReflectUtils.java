package com.miui.support.reflect;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.WeakHashMap;

public class ReflectUtils {
    public static final String OBJECT_CONSTRUCTOR = "<init>";
    private static Class<?>[] PRIMITIVE_CLASSES = null;
    private static String[] SIGNATURE_OF_PRIMTIVE_CLASSES = null;
    private static final String SURROUNDING_THIS_POINTER = "this$0";
    private static final WeakHashMap<Object, HashMap<String, Object>> sAdditionalFields;

    static {
        PRIMITIVE_CLASSES = new Class[]{Boolean.TYPE, Byte.TYPE, Character.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Void.TYPE};
        SIGNATURE_OF_PRIMTIVE_CLASSES = new String[]{Field.BOOLEAN_SIGNATURE_PRIMITIVE, Field.BYTE_SIGNATURE_PRIMITIVE, Field.CHAR_SIGNATURE_PRIMITIVE, Field.SHORT_SIGNATURE_PRIMITIVE, Field.INT_SIGNATURE_PRIMITIVE, Field.LONG_SIGNATURE_PRIMITIVE, Field.FLOAT_SIGNATURE_PRIMITIVE, Field.DOUBLE_SIGNATURE_PRIMITIVE, Field.VOID_SIGNATURE_PRIMITIVE};
        sAdditionalFields = new WeakHashMap();
    }

    protected ReflectUtils() {
        throw new InstantiationException("Cannot instantiate utility class");
    }

    public static Object getSurroundingThis(Object obj) {
        return Field.of(obj.getClass(), SURROUNDING_THIS_POINTER, getSignature(obj.getClass())).get(obj);
    }

    public static String getSignature(Class<?> cls) {
        for (int i = 0; i < PRIMITIVE_CLASSES.length; i++) {
            if (cls == PRIMITIVE_CLASSES[i]) {
                return SIGNATURE_OF_PRIMTIVE_CLASSES[i];
            }
        }
        return getSignature(cls.getName());
    }

    public static String getSignature(String str) {
        for (int i = 0; i < PRIMITIVE_CLASSES.length; i++) {
            if (PRIMITIVE_CLASSES[i].getName().equals(str)) {
                str = SIGNATURE_OF_PRIMTIVE_CLASSES[i];
            }
        }
        String replace = str.replace(".", "/");
        return replace.startsWith("[") ? replace : "L" + replace + ";";
    }

    public static String getSignature(Class<?>[] clsArr, Class<?> cls) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('(');
        if (clsArr != null) {
            for (Class signature : clsArr) {
                stringBuilder.append(getSignature(signature));
            }
        }
        stringBuilder.append(')');
        stringBuilder.append(getSignature((Class) cls));
        return stringBuilder.toString();
    }

    public static void updateField(Class<?> cls, Object obj, Object obj2, Object obj3) {
        if (cls == null && obj == null) {
            throw new IllegalArgumentException("clazz and holder cannot be all null");
        }
        if (cls == null) {
            cls = obj.getClass();
        }
        while (cls != null) {
            Field[] declaredFields = cls.getDeclaredFields();
            int length = declaredFields.length;
            int i = 0;
            while (i < length) {
                Field field = declaredFields[i];
                field.setAccessible(true);
                try {
                    if (field.get(obj) == obj2) {
                        field.set(obj, obj3);
                    }
                    i++;
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
            cls = cls.getSuperclass();
        }
    }

    public static Object setAdditionalField(Object obj, String str, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("object must not be null");
        } else if (str == null) {
            throw new NullPointerException("fieldName must not be null");
        } else {
            HashMap hashMap;
            Object put;
            synchronized (sAdditionalFields) {
                HashMap hashMap2 = (HashMap) sAdditionalFields.get(obj);
                if (hashMap2 == null) {
                    hashMap2 = new HashMap();
                    sAdditionalFields.put(obj, hashMap2);
                    hashMap = hashMap2;
                } else {
                    hashMap = hashMap2;
                }
            }
            synchronized (hashMap) {
                put = hashMap.put(str, obj2);
            }
            return put;
        }
    }

    public static Object getAdditionalField(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException("object must not be null");
        } else if (str == null) {
            throw new NullPointerException("fieldName must not be null");
        } else {
            synchronized (sAdditionalFields) {
                HashMap hashMap = (HashMap) sAdditionalFields.get(obj);
                if (hashMap == null) {
                    return null;
                }
                Object obj2;
                synchronized (hashMap) {
                    obj2 = hashMap.get(str);
                }
                return obj2;
            }
        }
    }

    public static Object removeAdditionalField(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException("object must not be null");
        } else if (str == null) {
            throw new NullPointerException("fieldName must not be null");
        } else {
            synchronized (sAdditionalFields) {
                HashMap hashMap = (HashMap) sAdditionalFields.get(obj);
                if (hashMap == null) {
                    return null;
                }
                Object remove;
                synchronized (hashMap) {
                    remove = hashMap.remove(str);
                }
                return remove;
            }
        }
    }
}
