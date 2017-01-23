package com.xiaomi.channel.commonutils.file;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C4302b;
import java.io.File;

/* renamed from: com.xiaomi.channel.commonutils.file.c */
public class C4300c {
    public static boolean m17638a() {
        try {
            return Environment.getExternalStorageState().equals("removed");
        } catch (Throwable e) {
            C4302b.m17651a(e);
            return true;
        }
    }

    public static boolean m17639b() {
        try {
            return !Environment.getExternalStorageState().equals("mounted");
        } catch (Throwable e) {
            C4302b.m17651a(e);
            return true;
        }
    }

    public static boolean m17640c() {
        return C4300c.m17642e() <= 102400;
    }

    public static boolean m17641d() {
        return (C4300c.m17639b() || C4300c.m17640c() || C4300c.m17638a()) ? false : true;
    }

    public static long m17642e() {
        long j = 0;
        if (C4300c.m17639b()) {
            return j;
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null || TextUtils.isEmpty(externalStorageDirectory.getPath())) {
            return j;
        }
        try {
            StatFs statFs = new StatFs(externalStorageDirectory.getPath());
            return (((long) statFs.getAvailableBlocks()) - 4) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            return j;
        }
    }
}
