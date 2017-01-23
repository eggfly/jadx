package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.channel.commonutils.network.C4321d;
import com.xiaomi.mipush.sdk.C4343a;
import com.xiaomi.mipush.sdk.C4360o;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class NetworkStatusReceiver extends BroadcastReceiver {
    private static int f15144a;
    private static int f15145b;
    private static int f15146c;
    private static BlockingQueue<Runnable> f15147d;
    private static ThreadPoolExecutor f15148e;

    static {
        f15144a = 1;
        f15145b = 1;
        f15146c = 2;
        f15147d = new LinkedBlockingQueue();
        f15148e = new ThreadPoolExecutor(f15144a, f15145b, (long) f15146c, TimeUnit.SECONDS, f15147d);
    }

    private void m18343a(Context context) {
        if (!(C4360o.m17853a(context).m17874b() || !C4343a.m17800a(context).m17816i() || C4343a.m17800a(context).m17821n())) {
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context, "com.xiaomi.push.service.XMPushService"));
                intent.setAction("com.xiaomi.push.network_status_changed");
                context.startService(intent);
            } catch (Throwable e) {
                C4302b.m17651a(e);
            }
        }
        if (C4321d.m17709d(context) && C4360o.m17853a(context).m17878f()) {
            C4360o.m17853a(context).m17875c();
        }
    }

    public void onReceive(Context context, Intent intent) {
        f15148e.execute(new C4437a(this, context));
    }
}
