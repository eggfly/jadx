package com.xiaomi.measite.smack;

import com.umeng.message.proguard.C4233j;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.smack.C4338d;
import com.xiaomi.smack.C4461a;
import java.util.Date;

/* renamed from: com.xiaomi.measite.smack.e */
class C4339e implements C4338d {
    final /* synthetic */ C4331a f14785a;

    C4339e(C4331a c4331a) {
        this.f14785a = c4331a;
    }

    public void m17773a(C4461a c4461a) {
        C4302b.m17653c("SMACK " + this.f14785a.f14774b.format(new Date()) + " Connection reconnected (" + this.f14785a.f14775c.hashCode() + C4233j.f14397t);
    }

    public void m17774a(C4461a c4461a, int i, Exception exception) {
        C4302b.m17653c("SMACK " + this.f14785a.f14774b.format(new Date()) + " Connection closed (" + this.f14785a.f14775c.hashCode() + C4233j.f14397t);
    }

    public void m17775a(C4461a c4461a, Exception exception) {
        C4302b.m17653c("SMACK " + this.f14785a.f14774b.format(new Date()) + " Reconnection failed due to an exception (" + this.f14785a.f14775c.hashCode() + C4233j.f14397t);
        exception.printStackTrace();
    }

    public void m17776b(C4461a c4461a) {
        C4302b.m17653c("SMACK " + this.f14785a.f14774b.format(new Date()) + " Connection started (" + this.f14785a.f14775c.hashCode() + C4233j.f14397t);
    }
}
