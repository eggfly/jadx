package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.push.service.XMPushService.C4385g;
import com.xiaomi.xmpush.thrift.C4542p;

/* renamed from: com.xiaomi.push.service.l */
final class C4423l extends C4385g {
    final /* synthetic */ XMPushService f15093b;
    final /* synthetic */ C4542p f15094c;

    C4423l(int i, XMPushService xMPushService, C4542p c4542p) {
        this.f15093b = xMPushService;
        this.f15094c = c4542p;
        super(i);
    }

    public void m18266a() {
        try {
            this.f15093b.m18087a(this.f15093b.m18077a(this.f15094c.m19022j(), this.f15094c.m19020h()));
        } catch (Exception e) {
            C4302b.m17651a((Throwable) e);
            this.f15093b.m18079a(10, e);
        }
    }

    public String m18267b() {
        return "send app absent message.";
    }
}
