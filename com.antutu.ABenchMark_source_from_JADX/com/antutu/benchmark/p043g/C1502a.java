package com.antutu.benchmark.p043g;

import android.content.Context;

/* renamed from: com.antutu.benchmark.g.a */
public class C1502a {
    public static int m5906a(Context context) {
        return C1505d.m5976a(context).m5986b("app_overwrite_install_flag", 0);
    }

    public static void m5907a(Context context, int i) {
        C1505d.m5976a(context).m5982a("app_overwrite_install_flag", i);
    }

    public static void m5908a(Context context, boolean z) {
        C1505d.m5976a(context).m5985a("app_temperature_bar_status", z);
    }

    public static void m5909b(Context context) {
        C1505d.m5976a(context).m5983a("app_alive_service_start_time", Long.valueOf(System.currentTimeMillis()));
    }

    public static void m5910c(Context context) {
        C1505d.m5976a(context).m5983a("battery_report_time", Long.valueOf(System.currentTimeMillis()));
    }

    public static long m5911d(Context context) {
        return C1505d.m5976a(context).m5980a("battery_report_time", 0);
    }

    public static boolean m5912e(Context context) {
        return C1505d.m5976a(context).m5988b("app_temperature_bar_status", true);
    }
}
