package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.push.service.XMPushService.C4385g;
import com.xiaomi.smack.packet.C4468d;

public class ag extends C4385g {
    private XMPushService f15019b;
    private C4468d f15020c;

    public ag(XMPushService xMPushService, C4468d c4468d) {
        super(4);
        this.f15019b = null;
        this.f15019b = xMPushService;
        this.f15020c = c4468d;
    }

    public void m18132a() {
        try {
            this.f15019b.m18086a(this.f15020c);
        } catch (Exception e) {
            C4302b.m17651a((Throwable) e);
            this.f15019b.m18079a(10, e);
        }
    }

    public String m18133b() {
        return "send a message.";
    }
}
