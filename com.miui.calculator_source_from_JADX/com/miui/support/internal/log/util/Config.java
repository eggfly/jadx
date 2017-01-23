package com.miui.support.internal.log.util;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.miui.support.os.Environment;
import com.miui.support.os.ProcessUtils;
import com.miui.support.util.AppConstants;
import java.io.File;

public class Config {
    public static final String f2542a;
    public static final String f2543b;

    static {
        String c = m4216c();
        String a = ProcessUtils.m5186a(Process.myPid());
        if (c == null) {
            int indexOf = a.indexOf(58);
            if (indexOf < 0) {
                c = a;
            } else {
                c = a.substring(0, indexOf);
            }
        }
        f2542a = c;
        f2543b = a;
    }

    public static String m4211a() {
        return m4213a(f2542a);
    }

    public static String m4213a(String str) {
        Context a = AppConstants.m4227a();
        if (a == null) {
            return m4217c(str);
        }
        return m4212a(a);
    }

    public static String m4214b() {
        return m4215b(f2542a);
    }

    public static String m4215b(String str) {
        File a = Environment.m5175a();
        if (a != null) {
            return a.getPath() + "/debug_log/" + str + "/dump";
        }
        Log.e("Config", "Fail to getExternalStorageMiuiDirectory");
        return null;
    }

    private static String m4216c() {
        Application a = AppConstants.m4227a();
        return a == null ? null : a.getPackageName();
    }

    private static String m4217c(String str) {
        String str2 = "/cache/debug_log/" + str;
        File file = new File(str2);
        if (file.exists() || file.mkdirs() || file.exists()) {
            return str2;
        }
        Log.e("Config", "Fail to getSystemCacheLogDir");
        return null;
    }

    private static String m4212a(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            return cacheDir.getPath() + "/debug_log/";
        }
        Log.e("Config", "Fail to getCacheDir");
        return null;
    }
}
