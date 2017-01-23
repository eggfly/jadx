package com.baidu.mobads;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: com.baidu.mobads.s */
class C2069s implements OnClickListener {
    final /* synthetic */ AppActivity f7201a;

    C2069s(AppActivity appActivity) {
        this.f7201a = appActivity;
    }

    public void onClick(View view) {
        this.f7201a.runBottomViewExitAnimation(this.f7201a.f6449B, this.f7201a.mBottomView);
    }
}
