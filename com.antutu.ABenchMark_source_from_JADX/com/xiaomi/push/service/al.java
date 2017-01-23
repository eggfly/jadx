package com.xiaomi.push.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.xiaomi.channel.commonutils.logger.C4302b;

class al implements ServiceConnection {
    final /* synthetic */ XMPushService f15030a;

    al(XMPushService xMPushService) {
        this.f15030a = xMPushService;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        C4302b.m17652b("onServiceConnected " + iBinder);
        Service a = XMJobService.m18018a();
        if (a != null) {
            this.f15030a.startForeground(XMPushService.f14961f, XMPushService.m18043a(this.f15030a));
            a.startForeground(XMPushService.f14961f, XMPushService.m18043a(this.f15030a));
            a.stopForeground(true);
            this.f15030a.unbindService(this);
            return;
        }
        C4302b.m17649a("XMService connected but innerService is null " + iBinder);
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
