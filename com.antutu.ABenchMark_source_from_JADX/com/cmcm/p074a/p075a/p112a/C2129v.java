package com.cmcm.p074a.p075a.p112a;

import com.cmcm.p074a.p075a.p115d.C2169j;
import java.util.Iterator;

/* renamed from: com.cmcm.a.a.a.v */
final class C2129v implements Runnable {
    C2129v() {
    }

    public void run() {
        C2169j a = C2169j.m8169a();
        a.m8199a((long) C2126s.m8026a("reporter", "interval_check_fast", 0));
        a.m8201b((long) C2126s.m8026a("reporter", "interval_check_batch", 0));
        if (C2126s.f7467i != null) {
            C2126s.f7467i.m7923b();
            try {
                Iterator a2 = C2126s.f7467i.m7921a();
                while (a2.hasNext()) {
                    C2114h c2114h = (C2114h) a2.next();
                    if (c2114h != null) {
                        c2114h.m7963a();
                    }
                }
            } finally {
                C2126s.f7467i.m7924c();
            }
        }
    }
}
