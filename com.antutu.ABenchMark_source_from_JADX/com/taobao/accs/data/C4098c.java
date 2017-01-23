package com.taobao.accs.data;

import com.taobao.accs.ut.monitor.TrafficsMonitor.C4129a;

/* renamed from: com.taobao.accs.data.c */
class C4098c implements Runnable {
    final /* synthetic */ C4129a f13703a;
    final /* synthetic */ C4097b f13704b;

    C4098c(C4097b c4097b, C4129a c4129a) {
        this.f13704b = c4097b;
        this.f13703a = c4129a;
    }

    public void run() {
        if (this.f13704b.f13693c != null) {
            this.f13704b.f13693c.m16894a(this.f13703a);
        }
    }
}
