package com.ijinshan.cloudconfig.deepcloudconfig;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: com.ijinshan.cloudconfig.deepcloudconfig.c */
public class C3959c extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("com.ijinshan.krcmd.deepcloudconfig.CloudDataChangeReceiver.datachange")) {
            C3957a.m16278a().m16283b();
        }
    }
}
