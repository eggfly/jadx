package com.miui.support.internal.util;

public class DataUpdateUtils {
    public static final String f2547a;
    private static final String f2548b;

    static {
        f2548b = DeviceHelper.f2550b ? "http://trial.api.comm.miui.com" : "http://api.comm.miui.com";
        f2547a = f2548b + "/cspmisc/service/version";
    }
}
