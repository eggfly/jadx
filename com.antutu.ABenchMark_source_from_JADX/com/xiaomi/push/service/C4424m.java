package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.push.service.XMPushService.C4385g;
import com.xiaomi.xmpush.thrift.C4542p;

/* renamed from: com.xiaomi.push.service.m */
final class C4424m extends C4385g {
    final /* synthetic */ XMPushService f15095b;
    final /* synthetic */ C4542p f15096c;

    C4424m(int i, XMPushService xMPushService, C4542p c4542p) {
        this.f15095b = xMPushService;
        this.f15096c = c4542p;
        super(i);
    }

    public void m18268a() {
        try {
            this.f15095b.m18087a(C4422k.m18251a(this.f15095b, this.f15096c));
        } catch (Exception e) {
            C4302b.m17651a((Throwable) e);
            this.f15095b.m18079a(10, e);
        }
    }

    public String m18269b() {
        return "send ack message for message.";
    }
}
