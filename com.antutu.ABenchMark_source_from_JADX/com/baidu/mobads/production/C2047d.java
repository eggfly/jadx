package com.baidu.mobads.production;

import android.content.Context;

/* renamed from: com.baidu.mobads.production.d */
class C2047d implements Runnable {
    final /* synthetic */ Context f7151a;
    final /* synthetic */ C2028a f7152b;

    C2047d(C2028a c2028a, Context context) {
        this.f7152b = c2028a;
        this.f7151a = context;
    }

    public void run() {
        this.f7152b.m7565a(this.f7151a);
    }
}
