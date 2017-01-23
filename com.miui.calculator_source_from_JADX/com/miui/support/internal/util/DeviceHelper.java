package com.miui.support.internal.util;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.miui.support.os.SystemProperties;

public class DeviceHelper {
    public static final boolean f2549a;
    public static final boolean f2550b;
    public static final boolean f2551c;
    public static final boolean f2552d;
    public static final boolean f2553e;
    public static final boolean f2554f;
    public static final boolean f2555g;
    public static final boolean f2556h;
    public static final boolean f2557i;
    public static final boolean f2558j;
    public static final boolean f2559k;
    public static final boolean f2560l;

    static {
        boolean z = true;
        boolean z2 = "cancro".equals(Build.DEVICE) && Build.MODEL.startsWith("MI 4");
        f2549a = z2;
        f2550b = SystemProperties.m5189a("ro.product.mod_device", "").endsWith("_alpha");
        f2551c = "1".equals(SystemProperties.m5188a("ro.miui.cta"));
        String str = "persist.sys.miui_optimization";
        if ("1".equals(SystemProperties.m5188a("ro.miui.cts"))) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (SystemProperties.m5191a(str, z2)) {
            z2 = false;
        } else {
            z2 = true;
        }
        f2552d = z2;
        f2553e = SystemProperties.m5191a("ro.sys.ft_whole_anim", true);
        f2554f = SystemProperties.m5189a("ro.product.mod_device", "").endsWith("_global");
        f2555g = m4220b();
        z2 = !TextUtils.isEmpty(VERSION.INCREMENTAL) && VERSION.INCREMENTAL.matches("\\d+.\\d+.\\d+(-internal)?");
        f2556h = z2;
        if (!"user".equals(Build.TYPE) || f2556h) {
            z2 = false;
        } else {
            z2 = true;
        }
        f2557i = z2;
        if (SystemProperties.m5187a("ro.debuggable", 0) != 1) {
            z = false;
        }
        f2558j = z;
        f2559k = SystemProperties.m5191a("ro.miui.has_cust_partition", false);
        f2560l = "oled".equals(SystemProperties.m5188a("ro.display.type"));
    }

    private static boolean m4220b() {
        return SystemProperties.m5188a("ro.build.characteristics").contains("tablet");
    }

    public static String m4219a() {
        return SystemProperties.m5189a("ro.miui.region", "CN");
    }
}
