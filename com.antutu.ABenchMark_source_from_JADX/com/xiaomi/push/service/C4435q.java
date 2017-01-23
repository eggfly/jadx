package com.xiaomi.push.service;

import com.umeng.message.proguard.C4233j;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.push.service.XMPushService.C4385g;
import com.xiaomi.xmpush.thrift.C4542p;

/* renamed from: com.xiaomi.push.service.q */
final class C4435q extends C4385g {
    final /* synthetic */ XMPushService f15138b;
    final /* synthetic */ C4542p f15139c;
    final /* synthetic */ String f15140d;
    final /* synthetic */ String f15141e;

    C4435q(int i, XMPushService xMPushService, C4542p c4542p, String str, String str2) {
        this.f15138b = xMPushService;
        this.f15139c = c4542p;
        this.f15140d = str;
        this.f15141e = str2;
        super(i);
    }

    public void m18320a() {
        try {
            C4542p a = C4422k.m18251a(this.f15138b, this.f15139c);
            a.f16048h.m18860a(C4233j.f14375B, this.f15140d);
            a.f16048h.m18860a("reason", this.f15141e);
            this.f15138b.m18087a(a);
        } catch (Exception e) {
            C4302b.m17651a((Throwable) e);
            this.f15138b.m18079a(10, e);
        }
    }

    public String m18321b() {
        return "send wrong message ack for message.";
    }
}
