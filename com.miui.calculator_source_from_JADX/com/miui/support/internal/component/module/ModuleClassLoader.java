package com.miui.support.internal.component.module;

import android.content.Context;
import android.os.Build.VERSION;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class ModuleClassLoader {
    static boolean m3889a(String str, String str2, String str3, ClassLoader classLoader, Context context) {
        if (str == null && (str3 == null || context == null)) {
            return false;
        }
        try {
            String str4;
            ClassLoader pathClassLoader;
            Object a = m3884a(classLoader);
            if (str != null) {
                str4 = str;
            } else if (VERSION.SDK_INT < 23) {
                m3891b(a, str3);
                return true;
            } else {
                str2 = null;
                str4 = context.getApplicationInfo().sourceDir;
            }
            if (str2 == null) {
                pathClassLoader = new PathClassLoader(str4, str3, classLoader.getParent());
            } else {
                pathClassLoader = new DexClassLoader(str4, str2, str3, classLoader.getParent());
            }
            Object a2 = m3884a(pathClassLoader);
            if (str != null) {
                m3887a(a, a2);
            }
            if (str3 != null) {
                m3888a(a, a2, str3);
            }
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        } catch (IllegalAccessException e2) {
            return false;
        } catch (ClassNotFoundException e3) {
            return false;
        } catch (NoSuchFieldException e4) {
            return false;
        }
    }

    private static Object m3884a(ClassLoader classLoader) {
        if (classLoader instanceof BaseDexClassLoader) {
            Field[] declaredFields = BaseDexClassLoader.class.getDeclaredFields();
            int length = declaredFields.length;
            int i = 0;
            while (i < length) {
                Field field = declaredFields[i];
                if ("dalvik.system.DexPathList".equals(field.getType().getName())) {
                    field.setAccessible(true);
                    try {
                        return field.get(classLoader);
                    } catch (IllegalArgumentException e) {
                    } catch (IllegalAccessException e2) {
                    }
                } else {
                    i++;
                }
            }
        }
        throw new NoSuchFieldException("dexPathList field not found.");
    }

    private static void m3887a(Object obj, Object obj2) {
        m3890b(obj, obj2, "dexElements");
    }

    private static void m3888a(Object obj, Object obj2, String str) {
        if (VERSION.SDK_INT >= 23) {
            m3890b(obj, obj2, "nativeLibraryPathElements");
        } else {
            m3891b(obj, str);
        }
    }

    private static void m3890b(Object obj, Object obj2, String str) {
        Object[] objArr = (Object[]) m3886a(obj2, str).get(obj2);
        Field a = m3886a(obj, str);
        Object[] objArr2 = (Object[]) a.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(Class.forName("dalvik.system.DexPathList$Element"), objArr2.length + 1);
        objArr3[0] = objArr[0];
        System.arraycopy(objArr2, 0, objArr3, 1, objArr2.length);
        a.set(obj, objArr3);
    }

    private static Field m3886a(Object obj, String str) {
        for (Field field : obj.getClass().getDeclaredFields()) {
            if (field.getName().equals(str)) {
                Class type = field.getType();
                if (type.isArray() && "dalvik.system.DexPathList$Element".equals(type.getComponentType().getName())) {
                    field.setAccessible(true);
                    return field;
                }
            }
        }
        throw new NoSuchFieldException(str + " field not found.");
    }

    private static void m3891b(Object obj, String str) {
        Field a = m3885a(obj);
        File[] fileArr = (File[]) a.get(obj);
        Object obj2 = new File[(fileArr.length + 1)];
        obj2[0] = new File(str);
        System.arraycopy(fileArr, 0, obj2, 1, fileArr.length);
        a.set(obj, obj2);
    }

    private static Field m3885a(Object obj) {
        for (Field field : obj.getClass().getDeclaredFields()) {
            Class type = field.getType();
            if (type.isArray() && type.getComponentType() == File.class) {
                field.setAccessible(true);
                return field;
            }
        }
        throw new NoSuchFieldException("nativeLibraryDirectories field not found.");
    }
}
