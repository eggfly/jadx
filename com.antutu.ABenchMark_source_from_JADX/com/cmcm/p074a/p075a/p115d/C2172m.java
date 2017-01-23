package com.cmcm.p074a.p075a.p115d;

import com.cmcm.p074a.p075a.p112a.C2133z;
import com.cmcm.p074a.p075a.p112a.ad;

/* renamed from: com.cmcm.a.a.d.m */
class C2172m implements Runnable {
    final /* synthetic */ C2168i f7553a;
    final /* synthetic */ C2169j f7554b;

    C2172m(C2169j c2169j, C2168i c2168i) {
        this.f7554b = c2169j;
        this.f7553a = c2168i;
    }

    public void run() {
        if (this.f7554b.m8203c()) {
            this.f7554b.f7540e.m8165a(this.f7553a);
        } else if (C2133z.f7482a) {
            ad.m7931a("Reporter", "not init", new Object[0]);
        }
    }
}
