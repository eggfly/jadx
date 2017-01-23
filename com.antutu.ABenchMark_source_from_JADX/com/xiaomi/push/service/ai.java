package com.xiaomi.push.service;

import android.util.Base64;
import com.xiaomi.channel.commonutils.android.C4297i;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.channel.commonutils.misc.C4312f.C4311b;
import com.xiaomi.network.HttpUtils;
import com.xiaomi.push.protobuf.C4378a.C4377a;
import com.xiaomi.push.service.ah.C4402a;

class ai extends C4311b {
    boolean f15026a;
    final /* synthetic */ ah f15027b;

    ai(ah ahVar) {
        this.f15027b = ahVar;
        this.f15026a = false;
    }

    public void m18150b() {
        try {
            C4377a b = C4377a.m17976b(Base64.decode(HttpUtils.m17932a(C4297i.m17624a(), "http://resolver.msg.xiaomi.net/psc/?t=a", null), 10));
            if (b != null) {
                this.f15027b.f15024c = b;
                this.f15026a = true;
                this.f15027b.m18144i();
            }
        } catch (Exception e) {
            C4302b.m17649a("fetch config failure: " + e.getMessage());
        }
    }

    public void m18151c() {
        this.f15027b.f15025d = null;
        if (this.f15026a) {
            synchronized (this.f15027b) {
            }
            for (C4402a a : (C4402a[]) this.f15027b.f15023b.toArray(new C4402a[this.f15027b.f15023b.size()])) {
                a.m18109a(this.f15027b.f15024c);
            }
        }
    }
}
