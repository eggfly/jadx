package com.xiaomi.mistatistic.sdk.network;

import java.util.regex.Pattern;

/* renamed from: com.xiaomi.mistatistic.sdk.network.b */
public class C0611b {
    private static final Pattern f4852a;
    private static final Pattern f4853b;
    private static final Pattern f4854c;

    static {
        f4852a = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
        f4853b = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
        f4854c = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");
    }

    public static boolean m6581a(String str) {
        return f4852a.matcher(str).matches();
    }

    public static boolean m6582b(String str) {
        return f4853b.matcher(str).matches();
    }

    public static boolean m6583c(String str) {
        return f4854c.matcher(str).matches();
    }

    public static boolean m6584d(String str) {
        return C0611b.m6582b(str) || C0611b.m6583c(str);
    }
}
