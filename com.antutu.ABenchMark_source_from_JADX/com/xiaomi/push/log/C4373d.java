package com.xiaomi.push.log;

import com.xiaomi.channel.commonutils.misc.C4312f.C4311b;
import com.xiaomi.push.log.C4371b.C4368b;

/* renamed from: com.xiaomi.push.log.d */
class C4373d extends C4311b {
    C4311b f14897a;
    final /* synthetic */ C4371b f14898b;

    C4373d(C4371b c4371b) {
        this.f14898b = c4371b;
    }

    public void m17969b() {
        C4368b c4368b = (C4368b) this.f14898b.f14887a.peek();
        if (c4368b != null && c4368b.m17949d()) {
            this.f14897a = (C4311b) this.f14898b.f14887a.remove();
            this.f14897a.m17677b();
        }
    }

    public void m17970c() {
        if (this.f14897a != null) {
            this.f14897a.m17678c();
        }
    }
}
