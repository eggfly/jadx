package com.xiaomi.measite.smack;

import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.smack.util.C4334l;
import java.util.Date;

/* renamed from: com.xiaomi.measite.smack.c */
class C4335c implements C4334l {
    final /* synthetic */ C4331a f14783a;

    C4335c(C4331a c4331a) {
        this.f14783a = c4331a;
    }

    public void m17766a(String str) {
        C4302b.m17653c("SMACK " + this.f14783a.f14774b.format(new Date()) + " SENT (" + this.f14783a.f14775c.hashCode() + "): " + str);
    }
}
