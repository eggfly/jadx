package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.aa;
import com.xiaomi.push.service.timers.C4441a;

public class PingReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        C4441a.m18357a(false);
        C4302b.m17653c(intent.getPackage() + " is the package name");
        if (!aa.f14991o.equals(intent.getAction())) {
            C4302b.m17649a("cancel the old ping timer");
            C4441a.m18355a();
        } else if (TextUtils.equals(context.getPackageName(), intent.getPackage())) {
            C4302b.m17653c("Ping XMChannelService on timer");
            try {
                Intent intent2 = new Intent(context, XMPushService.class);
                intent2.putExtra("time_stamp", System.currentTimeMillis());
                intent2.setAction("com.xiaomi.push.timer");
                context.startService(intent2);
            } catch (Throwable e) {
                C4302b.m17651a(e);
            }
        }
    }
}
