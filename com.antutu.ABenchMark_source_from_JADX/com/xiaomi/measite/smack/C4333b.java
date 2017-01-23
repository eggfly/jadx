package com.xiaomi.measite.smack;

import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.smack.util.C4332f;
import java.util.Date;

/* renamed from: com.xiaomi.measite.smack.b */
class C4333b implements C4332f {
    final /* synthetic */ C4331a f14782a;

    C4333b(C4331a c4331a) {
        this.f14782a = c4331a;
    }

    public void m17764a(String str) {
        C4302b.m17653c("SMACK " + this.f14782a.f14774b.format(new Date()) + " RCV  (" + this.f14782a.f14775c.hashCode() + "): " + str);
    }
}
