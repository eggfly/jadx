package com.xiaomi.smack;

import com.xiaomi.push.service.XMPushService.C4385g;

/* renamed from: com.xiaomi.smack.m */
class C4474m extends C4385g {
    final /* synthetic */ long f15363b;
    final /* synthetic */ C4473l f15364c;

    C4474m(C4473l c4473l, int i, long j) {
        this.f15364c = c4473l;
        this.f15363b = j;
        super(i);
    }

    public void m18562a() {
        Thread.yield();
        if (this.f15364c.m18476i() && !this.f15364c.m18465a(this.f15363b)) {
            this.f15364c.f15361y.m18079a(22, null);
            this.f15364c.f15361y.m18090a(true);
        }
    }

    public String m18563b() {
        return "check the ping-pong." + this.f15363b;
    }
}
