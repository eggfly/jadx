package com.xiaomi.channel.commonutils.reflect;

import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.xiaomi.channel.commonutils.reflect.a */
public class C4323a {
    private static final Map<Class<?>, Class<?>> f14764a;

    /* renamed from: com.xiaomi.channel.commonutils.reflect.a.a */
    public static class C4322a<T> {
        public final Class<? extends T> f14762a;
        public final T f14763b;
    }

    static {
        f14764a = new HashMap();
        f14764a.put(Boolean.class, Boolean.TYPE);
        f14764a.put(Byte.class, Byte.TYPE);
        f14764a.put(Character.class, Character.TYPE);
        f14764a.put(Short.class, Short.TYPE);
        f14764a.put(Integer.class, Integer.TYPE);
        f14764a.put(Float.class, Float.TYPE);
        f14764a.put(Long.class, Long.TYPE);
        f14764a.put(Double.class, Double.TYPE);
        f14764a.put(Boolean.TYPE, Boolean.TYPE);
        f14764a.put(Byte.TYPE, Byte.TYPE);
        f14764a.put(Character.TYPE, Character.TYPE);
        f14764a.put(Short.TYPE, Short.TYPE);
        f14764a.put(Integer.TYPE, Integer.TYPE);
        f14764a.put(Float.TYPE, Float.TYPE);
        f14764a.put(Long.TYPE, Long.TYPE);
        f14764a.put(Double.TYPE, Double.TYPE);
    }

    public static <T> T m17713a(Class<? extends Object> cls, Object obj, String str) {
        Field field = null;
        while (field == null) {
            Class superclass;
            try {
                field = superclass.getDeclaredField(str);
                field.setAccessible(true);
                continue;
            } catch (NoSuchFieldException e) {
                superclass = superclass.getSuperclass();
                continue;
            }
            if (superclass == null) {
                throw new NoSuchFieldException();
            }
        }
        field.setAccessible(true);
        return field.get(obj);
    }

    public static <T> T m17714a(Class<? extends Object> cls, String str) {
        T t = null;
        try {
            t = C4323a.m17713a((Class) cls, null, str);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
        return t;
    }

    public static <T> T m17715a(Class<?> cls, String str, Object... objArr) {
        return C4323a.m17719a((Class) cls, str, C4323a.m17722a(objArr)).invoke(null, C4323a.m17724b(objArr));
    }

    public static <T> T m17716a(Object obj, String str) {
        try {
            return C4323a.m17713a(obj.getClass(), obj, str);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static <T> T m17717a(Object obj, String str, Object... objArr) {
        try {
            return C4323a.m17723b(obj, str, objArr);
        } catch (Throwable e) {
            Log.w("JavaCalls", "Meet exception when call Method '" + str + "' in " + obj, e);
            return null;
        }
    }

    public static <T> T m17718a(String str, String str2, Object... objArr) {
        try {
            return C4323a.m17715a(Class.forName(str), str2, objArr);
        } catch (Throwable e) {
            Log.w("JavaCalls", "Meet exception when call Method '" + str2 + "' in " + str, e);
            return null;
        }
    }

    private static Method m17719a(Class<?> cls, String str, Class<?>... clsArr) {
        Method a = C4323a.m17720a(cls.getDeclaredMethods(), str, (Class[]) clsArr);
        if (a != null) {
            a.setAccessible(true);
            return a;
        } else if (cls.getSuperclass() != null) {
            return C4323a.m17719a(cls.getSuperclass(), str, (Class[]) clsArr);
        } else {
            throw new NoSuchMethodException();
        }
    }

    private static Method m17720a(Method[] methodArr, String str, Class<?>[] clsArr) {
        if (str == null) {
            throw new NullPointerException("Method name must not be null.");
        }
        for (Method method : methodArr) {
            if (method.getName().equals(str) && C4323a.m17721a(method.getParameterTypes(), (Class[]) clsArr)) {
                return method;
            }
        }
        return null;
    }

    private static boolean m17721a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr == null) {
            boolean z = clsArr2 == null || clsArr2.length == 0;
            return z;
        } else if (clsArr2 == null) {
            return clsArr.length == 0;
        } else {
            if (clsArr.length != clsArr2.length) {
                return false;
            }
            int i = 0;
            while (i < clsArr.length) {
                if (!clsArr[i].isAssignableFrom(clsArr2[i]) && (!f14764a.containsKey(clsArr[i]) || !((Class) f14764a.get(clsArr[i])).equals(f14764a.get(clsArr2[i])))) {
                    return false;
                }
                i++;
            }
            return true;
        }
    }

    private static Class<?>[] m17722a(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj == null || !(obj instanceof C4322a)) {
                clsArr[i] = obj == null ? null : obj.getClass();
            } else {
                clsArr[i] = ((C4322a) obj).f14762a;
            }
        }
        return clsArr;
    }

    public static <T> T m17723b(Object obj, String str, Object... objArr) {
        return C4323a.m17719a(obj.getClass(), str, C4323a.m17722a(objArr)).invoke(obj, C4323a.m17724b(objArr));
    }

    private static Object[] m17724b(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Object[] objArr2 = new Object[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj == null || !(obj instanceof C4322a)) {
                objArr2[i] = obj;
            } else {
                objArr2[i] = ((C4322a) obj).f14763b;
            }
        }
        return objArr2;
    }
}
