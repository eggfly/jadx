package com.antutu.redacc.p067f;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

/* renamed from: com.antutu.redacc.f.a */
public class C1744a {
    public static void m6735a(Context context, int i) {
        LocalBroadcastManager instance = LocalBroadcastManager.getInstance(context);
        Intent intent = new Intent();
        intent.setAction("action.infoc.report");
        intent.putExtra("table", "antutu_temp_finish");
        intent.putExtra("temp_finish", i);
        instance.sendBroadcast(intent);
    }

    public static void m6736a(Context context, int i, int i2) {
        LocalBroadcastManager instance = LocalBroadcastManager.getInstance(context);
        Intent intent = new Intent();
        intent.setAction("action.infoc.report");
        intent.putExtra("table", "antutu_temp_main");
        intent.putExtra("temp_main", i);
        intent.putExtra("app_select", i2);
        instance.sendBroadcast(intent);
    }
}
