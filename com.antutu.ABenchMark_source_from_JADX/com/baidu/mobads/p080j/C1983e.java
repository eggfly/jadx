package com.baidu.mobads.p080j;

import android.content.Context;
import android.content.Intent;

/* renamed from: com.baidu.mobads.j.e */
class C1983e implements Runnable {
    final /* synthetic */ Context f6925a;
    final /* synthetic */ Intent f6926b;
    final /* synthetic */ C1982d f6927c;

    C1983e(C1982d c1982d, Context context, Intent intent) {
        this.f6927c = c1982d;
        this.f6925a = context;
        this.f6926b = intent;
    }

    public void run() {
        this.f6925a.startActivity(this.f6926b);
    }
}
