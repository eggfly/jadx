package com.igexin.push.config;

import com.igexin.push.core.C3855g;

/* renamed from: com.igexin.push.config.k */
public class C3752k {
    private static C3752k f12645a;

    private C3752k() {
    }

    public static synchronized C3752k m15410a() {
        C3752k c3752k;
        synchronized (C3752k.class) {
            if (f12645a == null) {
                f12645a = new C3752k();
            }
            c3752k = f12645a;
        }
        return c3752k;
    }

    public boolean m15411b() {
        C3757p.m15418a();
        C3755n.m15412a();
        C3755n.m15413a(C3855g.f12969g);
        return true;
    }
}
