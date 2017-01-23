package com.baidu.mobads;

import android.view.ViewTreeObserver.OnPreDrawListener;

/* renamed from: com.baidu.mobads.r */
class C2068r implements OnPreDrawListener {
    final /* synthetic */ AppActivity f7200a;

    C2068r(AppActivity appActivity) {
        this.f7200a = appActivity;
    }

    public boolean onPreDraw() {
        this.f7200a.mBottomView.getViewTreeObserver().removeOnPreDrawListener(this);
        this.f7200a.runBottomViewEnterAnimation(this.f7200a.f6449B, this.f7200a.mBottomView);
        return true;
    }
}
