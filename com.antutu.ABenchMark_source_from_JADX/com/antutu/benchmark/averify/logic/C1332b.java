package com.antutu.benchmark.averify.logic;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import java.lang.reflect.Array;
import java.lang.reflect.Method;

/* renamed from: com.antutu.benchmark.averify.logic.b */
public class C1332b {
    public static int m5387a(Context context) {
        String b = C1332b.m5389b(context);
        return b == null ? 0 : C1332b.m5388a(b);
    }

    public static int m5388a(String str) {
        if (VERSION.SDK_INT > 17) {
            return C1331a.m5386a(str);
        }
        StatFs statFs = new StatFs(Environment.getDataDirectory().getAbsolutePath());
        return (int) ((((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount())) >> 10);
    }

    private static String m5389b(Context context) {
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        try {
            Class cls = Class.forName("android.os.storage.StorageVolume");
            Method method = storageManager.getClass().getMethod("getVolumeList", new Class[0]);
            Method method2 = cls.getMethod("getPath", new Class[0]);
            Method method3 = cls.getMethod("isRemovable", new Class[0]);
            Object invoke = method.invoke(storageManager, new Object[0]);
            int length = Array.getLength(invoke);
            for (int i = 0; i < length; i++) {
                Object obj = Array.get(invoke, i);
                String str = (String) method2.invoke(obj, new Object[0]);
                if (!((Boolean) method3.invoke(obj, new Object[0])).booleanValue()) {
                    return str;
                }
            }
        } catch (Exception e) {
        }
        return null;
    }
}
