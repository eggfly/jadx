package com.taobao.accs.data;

import android.content.Context;
import android.content.Intent;

/* renamed from: com.taobao.accs.data.f */
final class C4100f implements Runnable {
    final /* synthetic */ Context f13706a;
    final /* synthetic */ Intent f13707b;

    C4100f(Context context, Intent intent) {
        this.f13706a = context;
        this.f13707b = intent;
    }

    public void run() {
        C4095e.m16718c().m16716b(this.f13706a, this.f13707b);
    }
}
