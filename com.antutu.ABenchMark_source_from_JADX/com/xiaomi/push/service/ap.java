package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.misc.C4303a;
import com.xiaomi.push.service.XMPushService.C4385g;
import com.xiaomi.smack.C4403b;

class ap extends C4385g {
    final /* synthetic */ int f15043b;
    final /* synthetic */ byte[] f15044c;
    final /* synthetic */ String f15045d;
    final /* synthetic */ XMPushService f15046e;

    ap(XMPushService xMPushService, int i, int i2, byte[] bArr, String str) {
        this.f15046e = xMPushService;
        this.f15043b = i2;
        this.f15044c = bArr;
        this.f15045d = str;
        super(i);
    }

    public void m18172a() {
        C4418g.m18237b(this.f15046e);
        C4450y.m18390a().m18396a("5");
        C4303a.m17656a(this.f15043b);
        this.f15046e.f14962b.m18162c(C4403b.m18156b());
        this.f15046e.m18091a(this.f15044c, this.f15045d);
    }

    public String m18173b() {
        return "clear account cache.";
    }
}
