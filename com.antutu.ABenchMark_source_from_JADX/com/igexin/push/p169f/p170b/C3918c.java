package com.igexin.push.p169f.p170b;

import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.core.C3854f;
import com.igexin.push.core.C3855g;
import com.igexin.push.core.C3857i;
import com.igexin.push.core.p176a.C3777e;
import java.util.concurrent.TimeUnit;

/* renamed from: com.igexin.push.f.b.c */
public class C3918c extends C3732h {
    private static C3918c f13181a;

    public C3918c() {
        super(C3857i.m15894a().m15901b());
        this.o = true;
    }

    public static C3918c m16117g() {
        if (f13181a == null) {
            f13181a = new C3918c();
        }
        return f13181a;
    }

    protected void m16118a() {
        C3777e.m15491a().m15506B();
        C3855g.f12942F = System.currentTimeMillis();
        if (C3855g.f12976n) {
            C3688a.m15097b("heartbeatReq");
            C3854f.m15859a().m15879i().m15558g();
            return;
        }
        C3688a.m15097b("HeartBeatTimerTask doTaskMethod isOnline = false, refresh wait time !!!!!!");
        m16122h();
    }

    public final int m16119b() {
        return -2147483642;
    }

    public void m16120c() {
        super.m14960c();
        if (!this.k) {
            m16122h();
        }
    }

    public void m16121d() {
    }

    public void m16122h() {
        m14954a(C3857i.m15894a().m15901b(), TimeUnit.MILLISECONDS);
    }

    public void m16123i() {
    }
}
