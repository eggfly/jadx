package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.push.protobuf.C4380b.C4379a;
import com.xiaomi.smack.C4403b;
import com.xiaomi.smack.C4463e;
import java.util.Map;

class am extends C4403b {
    final /* synthetic */ XMPushService f15040a;

    am(XMPushService xMPushService, Map map, int i, String str, C4463e c4463e) {
        this.f15040a = xMPushService;
        super(map, i, str, c4463e);
    }

    public byte[] m18167a() {
        try {
            C4379a c4379a = new C4379a();
            c4379a.m18000a(ah.m18136a().m18148c());
            return c4379a.m14880b();
        } catch (Exception e) {
            C4302b.m17649a("getOBBString err: " + e.toString());
            return null;
        }
    }
}
