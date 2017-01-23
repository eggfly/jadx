package com.xiaomi.push.service;

import com.xiaomi.stats.C4512h;
import java.util.List;

/* renamed from: com.xiaomi.push.service.u */
final class C4444u implements Runnable {
    final /* synthetic */ List f15163a;
    final /* synthetic */ boolean f15164b;

    C4444u(List list, boolean z) {
        this.f15163a = list;
        this.f15164b = z;
    }

    public void run() {
        boolean a = C4439t.m18350b("www.baidu.com:80");
        boolean z = a;
        for (String a2 : this.f15163a) {
            a = z || C4439t.m18350b(a2);
            if (a && !this.f15164b) {
                break;
            }
            z = a;
        }
        a = z;
        C4512h.m18706a(a ? 1 : 2);
    }
}
