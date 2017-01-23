package com.xiaomi.smack.util;

import com.xiaomi.channel.commonutils.misc.C4312f.C4311b;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.xiaomi.smack.util.k */
final class C4501k extends C4311b {
    final /* synthetic */ XMPushService f15480a;

    C4501k(XMPushService xMPushService) {
        this.f15480a = xMPushService;
    }

    public void m18670b() {
        List arrayList;
        synchronized (C4500j.f15476c) {
            arrayList = new ArrayList(C4500j.f15477d);
            C4500j.f15477d.clear();
        }
        C4500j.m18667b(this.f15480a, arrayList);
    }
}
