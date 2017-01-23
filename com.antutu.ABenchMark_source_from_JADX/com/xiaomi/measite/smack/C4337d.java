package com.xiaomi.measite.smack;

import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.smack.C4336f;
import com.xiaomi.smack.packet.C4468d;
import java.util.Date;

/* renamed from: com.xiaomi.measite.smack.d */
class C4337d implements C4336f {
    final /* synthetic */ C4331a f14784a;

    C4337d(C4331a c4331a) {
        this.f14784a = c4331a;
    }

    public void m17768a(C4468d c4468d) {
        if (C4331a.f14773a) {
            C4302b.m17653c("SMACK " + this.f14784a.f14774b.format(new Date()) + " RCV PKT (" + this.f14784a.f14775c.hashCode() + "): " + c4468d.m18510a());
        }
    }
}
