package com.xiaomi.push.service;

import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.service.C4450y.C4448b.C4405a;
import com.xiaomi.push.service.C4450y.C4449c;

class ar implements C4405a {
    final /* synthetic */ XMPushService f15050a;

    ar(XMPushService xMPushService) {
        this.f15050a = xMPushService;
    }

    public void m18177a(C4449c c4449c, C4449c c4449c2, int i) {
        if (c4449c2 == C4449c.binded) {
            C4421j.m18247a(this.f15050a);
            C4421j.m18249b(this.f15050a);
        } else if (c4449c2 == C4449c.unbind) {
            C4421j.m18245a(this.f15050a, ErrorCode.ERROR_SERVICE_UNAVAILABLE, " the push is not connected.");
        }
    }
}
