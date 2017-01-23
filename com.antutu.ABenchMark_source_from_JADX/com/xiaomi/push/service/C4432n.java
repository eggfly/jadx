package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.push.service.XMPushService.C4385g;
import com.xiaomi.xmpush.thrift.C4542p;
import org.android.agoo.message.MessageService;

/* renamed from: com.xiaomi.push.service.n */
final class C4432n extends C4385g {
    final /* synthetic */ XMPushService f15131b;
    final /* synthetic */ C4542p f15132c;

    C4432n(int i, XMPushService xMPushService, C4542p c4542p) {
        this.f15131b = xMPushService;
        this.f15132c = c4542p;
        super(i);
    }

    public void m18314a() {
        try {
            C4542p a = C4422k.m18251a(this.f15131b, this.f15132c);
            a.m19025m().m18860a("message_obsleted", MessageService.MSG_DB_NOTIFY_REACHED);
            this.f15131b.m18087a(a);
        } catch (Exception e) {
            C4302b.m17651a((Throwable) e);
            this.f15131b.m18079a(10, e);
        }
    }

    public String m18315b() {
        return "send ack message for obsleted message.";
    }
}
