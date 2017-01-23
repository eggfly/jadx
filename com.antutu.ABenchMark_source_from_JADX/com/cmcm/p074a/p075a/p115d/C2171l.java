package com.cmcm.p074a.p075a.p115d;

import com.cmcm.p074a.p075a.p112a.C2115i;
import com.cmcm.p074a.p075a.p112a.C2133z;

/* renamed from: com.cmcm.a.a.d.l */
class C2171l implements Runnable {
    final /* synthetic */ C2169j f7552a;

    C2171l(C2169j c2169j) {
        this.f7552a = c2169j;
    }

    public void run() {
        this.f7552a.f7547l.set(false);
        if (this.f7552a.f7541f == null) {
            return;
        }
        if (C2115i.m7980i(this.f7552a.f7537b)) {
            this.f7552a.m8178a(false);
        } else if (C2133z.f7482a) {
            C2169j.m8180b(10, "no wifi", new Object[0]);
        }
    }
}
