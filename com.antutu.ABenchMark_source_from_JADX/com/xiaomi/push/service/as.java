package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService.C4385g;
import com.xiaomi.smack.packet.C4485f;
import com.xiaomi.smack.packet.C4485f.C4484b;

class as extends C4385g {
    final /* synthetic */ XMPushService f15051b;

    as(XMPushService xMPushService, int i) {
        this.f15051b = xMPushService;
        super(i);
    }

    public void m18178a() {
        if (this.f15051b.f14967h != null) {
            this.f15051b.f14967h.m18461a(new C4485f(C4484b.unavailable), 15, null);
            this.f15051b.f14967h = null;
        }
    }

    public String m18179b() {
        return "disconnect for service destroy.";
    }
}
