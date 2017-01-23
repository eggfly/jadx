package com.miui.support.external;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import java.io.File;

class SdkHelper {
    private static Class<?> f2004a;

    private SdkHelper() {
    }

    static {
        try {
            f2004a = Class.forName("com.miui.support.core.SdkManager");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static boolean m3470a() {
        return (m3473b() || m3472b("miui") != null || m3467a("com.miui.core") == null) ? false : true;
    }

    public static boolean m3473b() {
        return f2004a != null && SdkHelper.class.getClassLoader().equals(f2004a.getClassLoader());
    }

    public static String m3466a(Context context, String str, String str2) {
        if (context == null) {
            return m3468a(str, str2);
        }
        PackageInfo b = m3471b(context, str);
        if (b != null) {
            return b.applicationInfo.publicSourceDir;
        }
        return null;
    }

    private static String m3468a(String str, String str2) {
        String a = m3467a(str);
        if (a == null) {
            return m3472b(str2);
        }
        return a;
    }

    private static String m3467a(String str) {
        return m3469a(new String[]{"/data/app/" + str + "-1.apk", "/data/app/" + str + "-2.apk", "/data/app/" + str + "-1/base.apk", "/data/app/" + str + "-2/base.apk"});
    }

    private static String m3472b(String str) {
        return m3469a(new String[]{"/system/app/" + str + ".apk", "/system/priv-app/" + str + ".apk", "/system/app/" + str + "/" + str + ".apk", "/system/priv-app/" + str + "/" + str + ".apk"});
    }

    private static String m3469a(String[] strArr) {
        for (String str : strArr) {
            if (new File(str).exists()) {
                return str;
            }
        }
        return null;
    }

    public static String m3465a(Context context, String str) {
        if (context == null) {
            return m3474c(str);
        }
        PackageInfo b = m3471b(context, str);
        if (b != null) {
            return b.applicationInfo.nativeLibraryDir;
        }
        return null;
    }

    private static String m3474c(String str) {
        return "/data/data/" + str + "/lib/";
    }

    private static PackageInfo m3471b(Context context, String str) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 128);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return packageInfo;
    }
}
