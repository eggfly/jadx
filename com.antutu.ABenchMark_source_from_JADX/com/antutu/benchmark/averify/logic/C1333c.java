package com.antutu.benchmark.averify.logic;

import android.content.Context;
import com.antutu.benchmark.p043g.C1505d;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.antutu.benchmark.averify.logic.c */
public class C1333c {
    public static String m5390a(Context context) {
        return C1505d.m5977a(context, "antutu_sp_verify").m5987b("verify_result_content", BuildConfig.FLAVOR);
    }

    public static void m5391a(Context context, String str) {
        C1505d.m5977a(context, "antutu_sp_verify").m5984a("verify_result_content", str);
    }
}
