package com.antutu.benchmark.averify.logic;

import android.os.Build.VERSION;
import android.os.StatFs;

/* renamed from: com.antutu.benchmark.averify.logic.a */
public class C1331a {
    public static int m5386a(String str) {
        if (VERSION.SDK_INT <= 17) {
            return 0;
        }
        StatFs statFs = new StatFs(str);
        return (int) ((statFs.getBlockSizeLong() * statFs.getBlockCountLong()) >> 10);
    }
}
