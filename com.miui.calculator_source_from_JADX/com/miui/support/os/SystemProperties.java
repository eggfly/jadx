package com.miui.support.os;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SystemProperties {
    private static Class f3488a;
    private static Method f3489b;
    private static Method f3490c;
    private static Method f3491d;
    private static Method f3492e;
    private static Method f3493f;
    private static Method f3494g;
    private static Method f3495h;
    private static ArrayList<Runnable> f3496i;

    static {
        try {
            f3488a = Class.forName("android.os.SystemProperties");
            f3489b = f3488a.getDeclaredMethod("get", new Class[]{String.class});
            f3489b.setAccessible(true);
            f3490c = f3488a.getDeclaredMethod("get", new Class[]{String.class, String.class});
            f3490c.setAccessible(true);
            f3491d = f3488a.getDeclaredMethod("getInt", new Class[]{String.class, Integer.TYPE});
            f3491d.setAccessible(true);
            f3492e = f3488a.getDeclaredMethod("getLong", new Class[]{String.class, Long.TYPE});
            f3492e.setAccessible(true);
            f3493f = f3488a.getDeclaredMethod("getBoolean", new Class[]{String.class, Boolean.TYPE});
            f3493f.setAccessible(true);
            f3494g = f3488a.getDeclaredMethod("set", new Class[]{String.class, String.class});
            f3494g.setAccessible(true);
            f3495h = f3488a.getDeclaredMethod("addChangeCallback", new Class[]{Runnable.class});
            f3495h.setAccessible(true);
            Field declaredField = f3488a.getDeclaredField("sChangeCallbacks");
            declaredField.setAccessible(true);
            f3496i = (ArrayList) declaredField.get(null);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m5188a(java.lang.String r4) {
        /*
        r0 = f3489b;	 Catch:{ IllegalAccessException -> 0x0010, InvocationTargetException -> 0x0017 }
        r1 = 0;
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ IllegalAccessException -> 0x0010, InvocationTargetException -> 0x0017 }
        r3 = 0;
        r2[r3] = r4;	 Catch:{ IllegalAccessException -> 0x0010, InvocationTargetException -> 0x0017 }
        r0 = r0.invoke(r1, r2);	 Catch:{ IllegalAccessException -> 0x0010, InvocationTargetException -> 0x0017 }
        r0 = (java.lang.String) r0;	 Catch:{ IllegalAccessException -> 0x0010, InvocationTargetException -> 0x0017 }
    L_0x000f:
        return r0;
    L_0x0010:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0014:
        r0 = "";
        goto L_0x000f;
    L_0x0017:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0014;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.support.os.SystemProperties.a(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m5189a(java.lang.String r4, java.lang.String r5) {
        /*
        r0 = f3490c;	 Catch:{ IllegalAccessException -> 0x0013, InvocationTargetException -> 0x0019 }
        r1 = 0;
        r2 = 2;
        r2 = new java.lang.Object[r2];	 Catch:{ IllegalAccessException -> 0x0013, InvocationTargetException -> 0x0019 }
        r3 = 0;
        r2[r3] = r4;	 Catch:{ IllegalAccessException -> 0x0013, InvocationTargetException -> 0x0019 }
        r3 = 1;
        r2[r3] = r5;	 Catch:{ IllegalAccessException -> 0x0013, InvocationTargetException -> 0x0019 }
        r0 = r0.invoke(r1, r2);	 Catch:{ IllegalAccessException -> 0x0013, InvocationTargetException -> 0x0019 }
        r0 = (java.lang.String) r0;	 Catch:{ IllegalAccessException -> 0x0013, InvocationTargetException -> 0x0019 }
    L_0x0012:
        return r0;
    L_0x0013:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0017:
        r0 = r5;
        goto L_0x0012;
    L_0x0019:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0017;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.support.os.SystemProperties.a(java.lang.String, java.lang.String):java.lang.String");
    }

    public static int m5187a(String str, int i) {
        try {
            f3491d.invoke(null, new Object[]{str, Integer.valueOf(i)});
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
        }
        return i;
    }

    public static boolean m5191a(String str, boolean z) {
        try {
            f3493f.invoke(null, new Object[]{str, Boolean.valueOf(z)});
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
        }
        return z;
    }

    public static void m5190a(Runnable runnable) {
        try {
            f3495h.invoke(null, new Object[]{runnable});
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
        }
    }
}
