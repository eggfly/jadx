package com.xiaomi.push.service.receivers;

import android.content.Context;

/* renamed from: com.xiaomi.push.service.receivers.a */
class C4437a implements Runnable {
    final /* synthetic */ Context f15149a;
    final /* synthetic */ NetworkStatusReceiver f15150b;

    C4437a(NetworkStatusReceiver networkStatusReceiver, Context context) {
        this.f15150b = networkStatusReceiver;
        this.f15149a = context;
    }

    public void run() {
        this.f15150b.m18343a(this.f15149a);
    }
}
