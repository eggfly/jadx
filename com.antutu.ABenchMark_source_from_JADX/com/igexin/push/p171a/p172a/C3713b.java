package com.igexin.push.p171a.p172a;

import com.igexin.push.core.p176a.C3777e;
import com.igexin.push.p169f.p170b.C3711d;
import com.umeng.analytics.C4156a;

/* renamed from: com.igexin.push.a.a.b */
public class C3713b implements C3711d {
    public static final String f12522a;
    private long f12523b;

    static {
        f12522a = C3713b.class.getName();
    }

    public C3713b() {
        this.f12523b = 0;
    }

    public void m15215a() {
        C3777e.m15491a().m15577z();
        C3777e.m15491a().m15569r();
        C3777e.m15491a().m15570s();
        C3777e.m15491a().m15505A();
    }

    public void m15216a(long j) {
        this.f12523b = j;
    }

    public boolean m15217b() {
        return System.currentTimeMillis() - this.f12523b > C4156a.f13949k;
    }
}
