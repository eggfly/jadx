package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.push.service.XMPushService.C4385g;
import com.xiaomi.xmpush.thrift.C4542p;
import org.android.agoo.message.MessageService;

/* renamed from: com.xiaomi.push.service.o */
final class C4433o extends C4385g {
    final /* synthetic */ XMPushService f15133b;
    final /* synthetic */ C4542p f15134c;

    C4433o(int i, XMPushService xMPushService, C4542p c4542p) {
        this.f15133b = xMPushService;
        this.f15134c = c4542p;
        super(i);
    }

    public void m18316a() {
        try {
            C4542p a = C4422k.m18251a(this.f15133b, this.f15134c);
            a.m19025m().m18860a("miui_message_unrecognized", MessageService.MSG_DB_NOTIFY_REACHED);
            this.f15133b.m18087a(a);
        } catch (Exception e) {
            C4302b.m17651a((Throwable) e);
            this.f15133b.m18079a(10, e);
        }
    }

    public String m18317b() {
        return "send ack message for unrecognized new miui message.";
    }
}
