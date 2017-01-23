package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.push.service.XMPushService.C4385g;
import com.xiaomi.xmpush.thrift.C4542p;

/* renamed from: com.xiaomi.push.service.p */
final class C4434p extends C4385g {
    final /* synthetic */ XMPushService f15135b;
    final /* synthetic */ C4542p f15136c;
    final /* synthetic */ String f15137d;

    C4434p(int i, XMPushService xMPushService, C4542p c4542p, String str) {
        this.f15135b = xMPushService;
        this.f15136c = c4542p;
        this.f15137d = str;
        super(i);
    }

    public void m18318a() {
        try {
            C4542p a = C4422k.m18251a(this.f15135b, this.f15136c);
            a.m19025m().m18860a("absent_target_package", this.f15137d);
            this.f15135b.m18087a(a);
        } catch (Exception e) {
            C4302b.m17651a((Throwable) e);
            this.f15135b.m18079a(10, e);
        }
    }

    public String m18319b() {
        return "send app absent ack message for message.";
    }
}
