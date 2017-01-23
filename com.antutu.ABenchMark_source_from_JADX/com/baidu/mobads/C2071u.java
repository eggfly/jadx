package com.baidu.mobads;

import android.view.View;

/* renamed from: com.baidu.mobads.u */
class C2071u implements Runnable {
    final /* synthetic */ View f7203a;
    final /* synthetic */ View f7204b;
    final /* synthetic */ AppActivity f7205c;

    C2071u(AppActivity appActivity, View view, View view2) {
        this.f7205c = appActivity;
        this.f7203a = view;
        this.f7204b = view2;
    }

    public void run() {
        this.f7205c.m7135b(this.f7203a);
        this.f7205c.m7135b(this.f7204b);
    }
}
