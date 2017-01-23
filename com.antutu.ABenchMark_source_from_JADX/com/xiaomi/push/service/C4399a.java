package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.push.service.XMPushService.C4385g;
import com.xiaomi.smack.packet.C4482c;

/* renamed from: com.xiaomi.push.service.a */
public class C4399a extends C4385g {
    private XMPushService f14972b;
    private C4482c[] f14973c;

    public C4399a(XMPushService xMPushService, C4482c[] c4482cArr) {
        super(4);
        this.f14972b = null;
        this.f14972b = xMPushService;
        this.f14973c = c4482cArr;
    }

    public void m18105a() {
        try {
            this.f14972b.m18092a(this.f14973c);
        } catch (Exception e) {
            C4302b.m17651a((Throwable) e);
            this.f14972b.m18079a(10, e);
        }
    }

    public String m18106b() {
        return "batch send message.";
    }
}
