package com.ijinshan.cloudconfig.p073a;

import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.ijinshan.cloudconfig.a.b */
public class C3950b {
    private static C1786a f13251a;

    static {
        f13251a = null;
    }

    public static String m16231a() {
        return f13251a != null ? f13251a.getApkVersion() : BuildConfig.FLAVOR;
    }

    public static void m16232a(C1786a c1786a) {
        if (f13251a == null) {
            f13251a = c1786a;
        }
    }

    public static String m16233b() {
        return f13251a != null ? f13251a.getPkgName() : BuildConfig.FLAVOR;
    }

    public static String m16234c() {
        return f13251a != null ? f13251a.getLanParams() : BuildConfig.FLAVOR;
    }

    public static String m16235d() {
        return f13251a != null ? f13251a.getChannelId() : BuildConfig.FLAVOR;
    }
}
