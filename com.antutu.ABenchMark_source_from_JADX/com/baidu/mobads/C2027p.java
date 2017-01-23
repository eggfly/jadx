package com.baidu.mobads;

import android.view.ViewTreeObserver.OnPreDrawListener;

/* renamed from: com.baidu.mobads.p */
class C2027p implements OnPreDrawListener {
    final /* synthetic */ AppActivity f7071a;

    C2027p(AppActivity appActivity) {
        this.f7071a = appActivity;
    }

    public boolean onPreDraw() {
        this.f7071a.f6458d.getViewTreeObserver().removeOnPreDrawListener(this);
        this.f7071a.m7127a(this.f7071a.f6458d);
        return true;
    }
}
