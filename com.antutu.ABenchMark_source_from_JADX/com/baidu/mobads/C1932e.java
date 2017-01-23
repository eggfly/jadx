package com.baidu.mobads;

import android.view.View;

/* renamed from: com.baidu.mobads.e */
class C1932e implements Runnable {
    final /* synthetic */ View f6770a;
    final /* synthetic */ View f6771b;
    final /* synthetic */ AppActivity f6772c;

    C1932e(AppActivity appActivity, View view, View view2) {
        this.f6772c = appActivity;
        this.f6770a = view;
        this.f6771b = view2;
    }

    public void run() {
        this.f6772c.m7135b(this.f6770a);
        this.f6772c.m7135b(this.f6771b);
    }
}
