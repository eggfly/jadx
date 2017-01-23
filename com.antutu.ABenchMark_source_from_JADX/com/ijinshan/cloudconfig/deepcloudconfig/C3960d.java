package com.ijinshan.cloudconfig.deepcloudconfig;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.ijinshan.cloudconfig.deepcloudconfig.d */
public class C3960d extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().contentEquals("android.intent.action.LOCALE_CHANGED")) {
            C3961e.m16292a().m16303a(BuildConfig.FLAVOR);
        }
    }
}
