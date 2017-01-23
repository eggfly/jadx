package com.igexin.push.p174c;

import com.igexin.p158b.p159a.p161b.C3685c;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.util.C3922a;

/* renamed from: com.igexin.push.c.i */
public class C3730i {
    public static boolean f12580a;
    private static final String f12581b;
    private static C3730i f12582c;
    private static C3729h f12583d;

    static {
        f12581b = C3730i.class.getName();
    }

    private C3730i() {
        m15274b();
        if (C3922a.m16148d()) {
            f12583d = C3729h.WIFI;
        } else {
            f12583d = C3729h.MOBILE;
        }
    }

    public static synchronized C3730i m15273a() {
        C3730i c3730i;
        synchronized (C3730i.class) {
            if (f12582c == null) {
                f12582c = new C3730i();
            }
            c3730i = f12582c;
        }
        return c3730i;
    }

    public void m15274b() {
        f12580a = SDKUrlConfig.realXfrListIsOnly();
    }

    public void m15275c() {
        if (f12580a) {
            C3688a.m15097b(f12581b + "|xfr len = 1, detect = false");
        } else {
            C3685c.m15060b().m15053a(C3733k.b_(), false, true);
        }
    }

    public void m15276d() {
        try {
            m15281i().m15325d();
        } catch (Throwable th) {
            C3688a.m15097b(f12581b + "|" + th.toString());
        }
    }

    public C3722a m15277e() {
        return m15281i().f12603d;
    }

    public boolean m15278f() {
        if (f12580a) {
            return false;
        }
        C3734m i = m15281i();
        if (i.m15334m()) {
            C3688a.m15097b(f12581b + "|network changed detect = true, reset detect delay");
            i.m15327f();
            return true;
        }
        C3688a.m15097b(f12581b + "|startDetect detect = false");
        return false;
    }

    public String m15279g() {
        if (f12580a) {
            return SDKUrlConfig.getXfrAddress()[0];
        }
        C3734m i = m15281i();
        if (i != null) {
            C3731j g = i.m15328g();
            if (g != null) {
                return g.m15299g();
            }
        }
        return null;
    }

    public void m15280h() {
        m15274b();
        if (f12580a) {
            C3733k.b_().m15307g();
            try {
                C3736l.m15341a().d.m15258a(null);
                C3740r.m15374a().d.m15258a(null);
                C3740r.m15374a().m15330i();
                C3736l.m15341a().m15330i();
                C3740r.m15374a().m15333l();
                return;
            } catch (Throwable th) {
                C3688a.m15097b(f12581b + "|" + th.toString());
                return;
            }
        }
        try {
            C3740r.m15374a().m15333l();
            C3740r.m15374a().m15329h();
            C3736l.m15341a().m15329h();
            C3734m i = m15281i();
            if (i != null) {
                i.m15331j();
            }
        } catch (Throwable th2) {
            C3688a.m15097b(f12581b + "|" + th2.toString());
        }
    }

    public C3734m m15281i() {
        C3734m a;
        if (C3922a.m16148d()) {
            C3688a.m15097b(f12581b + "|wifi state");
            a = C3740r.m15374a();
        } else {
            C3688a.m15097b(f12581b + "|mobile state");
            a = C3736l.m15341a();
        }
        C3729h b = a.m15321b();
        if (b != f12583d) {
            if (b == C3729h.WIFI) {
                C3736l.m15341a().m15326e();
            } else if (b == C3729h.MOBILE) {
                C3740r.m15374a().m15326e();
            }
        }
        f12583d = b;
        return a;
    }
}
