package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.push.service.XMPushService.C4385g;

class aq extends C4385g {
    final /* synthetic */ String f15047b;
    final /* synthetic */ byte[] f15048c;
    final /* synthetic */ XMPushService f15049d;

    aq(XMPushService xMPushService, int i, String str, byte[] bArr) {
        this.f15049d = xMPushService;
        this.f15047b = str;
        this.f15048c = bArr;
        super(i);
    }

    public void m18174a() {
        try {
            this.f15049d.m18089a(this.f15047b, this.f15048c);
        } catch (Exception e) {
            C4302b.m17651a((Throwable) e);
            this.f15049d.m18079a(10, e);
        }
    }

    public String m18175b() {
        return "send mi push message";
    }
}
