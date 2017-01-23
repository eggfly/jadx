package com.igexin.push.p174c;

import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.core.C3855g;
import com.igexin.push.p169f.p170b.C3732h;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.igexin.push.c.k */
public class C3733k extends C3732h {
    public static final AtomicBoolean f12595a;
    private static final String f12596b;
    private static C3733k f12597c;
    private boolean f12598e;

    static {
        f12596b = C3733k.class.getName();
        f12595a = new AtomicBoolean(false);
    }

    private C3733k() {
        super(150);
        this.o = true;
    }

    public static synchronized C3733k b_() {
        C3733k c3733k;
        synchronized (C3733k.class) {
            if (f12597c == null) {
                f12597c = new C3733k();
            }
            c3733k = f12597c;
        }
        return c3733k;
    }

    protected void m15304a() {
        m14954a(C3727f.f12571a, TimeUnit.MILLISECONDS);
        if (this.f12598e) {
            C3688a.m15097b(f12596b + "|detect task already stop");
            return;
        }
        C3688a.m15097b(f12596b + "|" + (C3727f.f12571a / 1000) + "s passed, do task method, start redect ~~~~");
        if (C3855g.f12971i) {
            C3730i.m15273a().m15276d();
        } else {
            C3688a.m15097b(f12596b + "|" + (C3727f.f12571a / 1000) + "s passed, network is unavailable, stop ###");
        }
    }

    public void m15305a(long j) {
        m14954a(j, TimeUnit.MILLISECONDS);
    }

    public int m15306b() {
        return 20150607;
    }

    public void m15307g() {
        this.o = false;
        this.f12598e = true;
        m14966p();
    }
}
