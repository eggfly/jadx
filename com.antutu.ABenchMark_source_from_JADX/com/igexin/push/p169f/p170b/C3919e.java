package com.igexin.push.p169f.p170b;

import com.igexin.p158b.p159a.p161b.C3685c;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.config.C3754m;
import com.igexin.push.core.C3855g;
import com.igexin.push.core.p176a.C3777e;
import com.igexin.push.p182d.C3875b;
import com.igexin.push.util.C3922a;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.igexin.push.f.b.e */
public class C3919e extends C3732h {
    private long f13182a;
    private AtomicBoolean f13183b;

    public C3919e() {
        super(604800000);
        this.f13182a = C3754m.f12655I;
        this.f13183b = new AtomicBoolean(false);
        this.o = true;
    }

    private void m16124a(long j) {
        m14954a(j, TimeUnit.MILLISECONDS);
    }

    public static C3919e m16125g() {
        return C3920f.f13184a;
    }

    protected void m16126a() {
        m14954a(this.f13182a, TimeUnit.MILLISECONDS);
        boolean a = C3777e.m15491a().m15528a(System.currentTimeMillis());
        if (!C3855g.f12976n && C3855g.f12971i && C3855g.f12972j && C3855g.f12973k && !C3855g.f12976n && !a && C3922a.m16145b()) {
            C3688a.m15097b("PollingTimerTask|run = true");
            C3875b.m15932a().m15943g();
            C3855g.f12941E = 100;
            C3921g.m16131g().m16136h();
        }
    }

    public int m16127b() {
        return 20160629;
    }

    public void m16128h() {
        if (!this.f13183b.get()) {
            C3685c.m15060b().m15053a(this, false, true);
            this.f13183b.set(true);
        }
        m16124a(this.f13182a);
    }

    public void m16129i() {
        m14954a(604800000, TimeUnit.MILLISECONDS);
    }
}
