package com.taobao.agoo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.taobao.accs.client.C4085a;

public class AgooCommondReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        try {
            intent.setClassName(context, C4085a.m16663b(context.getPackageName()));
            context.startService(intent);
        } catch (Throwable th) {
        }
    }
}
