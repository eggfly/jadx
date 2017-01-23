package com.xiaomi.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.channel.commonutils.network.C4321d;

public class NetworkStatusChangeReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (C4321d.m17711f(context)) {
            try {
                context.startService(new Intent(context, HostRefreshService.class));
            } catch (Throwable e) {
                C4302b.m17651a(e);
            }
        }
    }
}
