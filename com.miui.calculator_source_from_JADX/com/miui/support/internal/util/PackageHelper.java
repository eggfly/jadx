package com.miui.support.internal.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import java.io.File;

public class PackageHelper {
    private static Class<?> f2568a;

    private PackageHelper() {
    }

    static {
        try {
            f2568a = Class.forName("com.miui.support.external.Application");
        } catch (ClassNotFoundException e) {
        }
    }

    public static boolean m4235a() {
        return (m4239b() || m4238b("miui") != null || m4232a("com.miui.core") == null) ? false : true;
    }

    public static boolean m4239b() {
        return f2568a != null && PackageHelper.class.getClassLoader().equals(f2568a.getClassLoader());
    }

    public static boolean m4236a(Context context) {
        return !m4239b() || new File(m4230a(null, context.getPackageName()) + "libmiuiclassproxy.so").exists();
    }

    public static String m4231a(Context context, String str, String str2) {
        if (context == null) {
            return m4233a(str, str2);
        }
        PackageInfo b = m4237b(context, str);
        if (b != null) {
            return b.applicationInfo.publicSourceDir;
        }
        return null;
    }

    private static String m4233a(String str, String str2) {
        String a = m4232a(str);
        if (a == null) {
            return m4238b(str2);
        }
        return a;
    }

    private static String m4232a(String str) {
        return m4234a(new String[]{"/data/app/" + str + "-1.apk", "/data/app/" + str + "-2.apk", "/data/app/" + str + "-1/base.apk", "/data/app/" + str + "-2/base.apk"});
    }

    private static String m4238b(String str) {
        return m4234a(new String[]{"/system/app/" + str + ".apk", "/system/priv-app/" + str + ".apk", "/system/app/" + str + "/" + str + ".apk", "/system/priv-app/" + str + "/" + str + ".apk"});
    }

    private static String m4234a(String[] strArr) {
        for (String str : strArr) {
            if (new File(str).exists()) {
                return str;
            }
        }
        return null;
    }

    public static String m4230a(Context context, String str) {
        if (context == null) {
            return m4240c(str);
        }
        PackageInfo b = m4237b(context, str);
        if (b != null) {
            return b.applicationInfo.nativeLibraryDir;
        }
        return null;
    }

    private static String m4240c(String str) {
        return "/data/data/" + str + "/lib/";
    }

    private static PackageInfo m4237b(Context context, String str) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 128);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return packageInfo;
    }
}
