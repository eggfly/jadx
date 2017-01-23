package com.aide.ui.build.android;

import android.content.Context;
import com.aide.ui.e;
import dalvik.system.DexClassLoader;
import java.lang.reflect.Method;

public class l {
    private static String DW;
    private static Method j6;

    public static String j6(Context context, String str, String str2, String[] strArr, String[] strArr2) {
        if (j6 == null) {
            try {
                j6 = new DexClassLoader(e.Ws().FH(), context.getDir("merger", 0).getPath(), null, ClassLoader.getSystemClassLoader()).loadClass("com.aide.merger.AndroidManifestMerger").getDeclaredMethod("merge", new Class[]{String.class, String.class, String[].class, String[].class});
            } catch (Throwable th) {
                th.printStackTrace();
                DW = th.getMessage();
            }
        }
        if (j6 == null) {
            return DW;
        }
        try {
            return (String) j6.invoke(null, new Object[]{str, str2, strArr, strArr2});
        } catch (Throwable th2) {
            th2.printStackTrace();
            return th2.getMessage() != null ? th2.getMessage() : th2.toString();
        }
    }
}
