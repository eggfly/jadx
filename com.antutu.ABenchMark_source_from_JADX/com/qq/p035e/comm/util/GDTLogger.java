package com.qq.p035e.comm.util;

import android.util.Log;
import com.qq.p035e.comm.services.C4066a;

/* renamed from: com.qq.e.comm.util.GDTLogger */
public class GDTLogger {
    public static final boolean DEBUG_ENABLE = false;

    public static void m16599d(String str) {
    }

    public static void m16600e(String str) {
        Log.e("gdt_ad_mob", str);
    }

    public static void m16601e(String str, Throwable th) {
        if (th == null) {
            Log.e("gdt_ad_mob", str);
        } else {
            Log.e("gdt_ad_mob", str, th);
        }
    }

    public static void m16602i(String str) {
        Log.i("gdt_ad_mob", str);
    }

    public static void report(String str) {
        GDTLogger.report(str, null);
    }

    public static void report(String str, Throwable th) {
        GDTLogger.m16601e(str, th);
        C4066a.m16594a();
        C4066a.m16597a(str, th);
    }

    public static void m16603w(String str) {
        Log.e("gdt_ad_mob", str);
    }

    public static void m16604w(String str, Throwable th) {
        if (th == null) {
            Log.w("gdt_ad_mob", str);
        } else {
            Log.w("gdt_ad_mob", str, th);
        }
    }
}
