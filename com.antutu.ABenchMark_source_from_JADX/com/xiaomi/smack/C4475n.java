package com.xiaomi.smack;

import com.xiaomi.push.service.XMPushService.C4385g;

/* renamed from: com.xiaomi.smack.n */
class C4475n extends C4385g {
    final /* synthetic */ int f15365b;
    final /* synthetic */ Exception f15366c;
    final /* synthetic */ C4473l f15367d;

    C4475n(C4473l c4473l, int i, int i2, Exception exception) {
        this.f15367d = c4473l;
        this.f15365b = i2;
        this.f15366c = exception;
        super(i);
    }

    public void m18564a() {
        this.f15367d.f15361y.m18079a(this.f15365b, this.f15366c);
    }

    public String m18565b() {
        return "shutdown the connection. " + this.f15365b + ", " + this.f15366c;
    }
}
