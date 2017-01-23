package com.xiaomi.channel.commonutils.misc;

import com.xiaomi.channel.commonutils.misc.C4308d.C4306a;
import com.xiaomi.channel.commonutils.misc.C4308d.C4307b;

/* renamed from: com.xiaomi.channel.commonutils.misc.e */
class C4309e extends C4307b {
    final /* synthetic */ String f14738a;
    final /* synthetic */ C4308d f14739b;

    C4309e(C4308d c4308d, C4306a c4306a, String str) {
        this.f14739b = c4308d;
        this.f14738a = str;
        super(c4306a);
    }

    void m17673a() {
        super.m17664a();
    }

    void m17674b() {
        this.f14739b.f14737e.edit().putLong(this.f14738a, System.currentTimeMillis()).commit();
    }
}
