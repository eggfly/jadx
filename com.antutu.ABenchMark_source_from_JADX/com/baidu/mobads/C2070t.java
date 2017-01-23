package com.baidu.mobads;

import com.baidu.mobads.p092g.C1944d.C1943b;
import com.baidu.mobads.vo.p104a.C2075c;

/* renamed from: com.baidu.mobads.t */
class C2070t implements C1943b {
    final /* synthetic */ AppActivity f7202a;

    C2070t(AppActivity appActivity) {
        this.f7202a = appActivity;
    }

    public void m7748a() {
        C2075c c = this.f7202a.f6479z;
        c.f7278D++;
        this.f7202a.m7149g();
        this.f7202a.runBottomViewExitAnimation(this.f7202a.f6449B, this.f7202a.mBottomView);
    }

    public void m7749b() {
        C2075c c = this.f7202a.f6479z;
        c.f7279E++;
        this.f7202a.copyCurrentPageUrl();
        this.f7202a.runBottomViewExitAnimation(this.f7202a.f6449B, this.f7202a.mBottomView);
    }

    public void m7750c() {
        C2075c c = this.f7202a.f6479z;
        c.f7280F++;
        this.f7202a.runBottomViewExitAnimation(this.f7202a.f6449B, this.f7202a.mBottomView);
    }
}
