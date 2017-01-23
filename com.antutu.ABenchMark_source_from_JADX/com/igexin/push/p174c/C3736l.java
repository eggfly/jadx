package com.igexin.push.p174c;

import android.text.TextUtils;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.core.C3855g;

/* renamed from: com.igexin.push.c.l */
public class C3736l extends C3734m implements C3735o {
    private static final String f12610e;
    private static C3736l f12611f;

    static {
        f12610e = C3736l.class.getName();
    }

    private C3736l() {
        super(C3855g.aw, C3855g.ay);
    }

    public static synchronized C3736l m15341a() {
        C3736l c3736l;
        synchronized (C3736l.class) {
            if (f12611f == null) {
                f12611f = new C3736l();
            }
            c3736l = f12611f;
        }
        return c3736l;
    }

    public void m15342a(C3728g c3728g, C3731j c3731j) {
        if (c3731j != null && !TextUtils.isEmpty(c3731j.m15284a())) {
            C3738p a = m15320a(c3731j.m15284a());
            if (a != null) {
                m15322b(c3731j);
                if (c3728g == C3728g.SUCCESS) {
                    a.m15370g();
                    a.m15373j();
                    m15332k();
                    m15335n();
                } else if (c3728g == C3728g.EXCEPTION || c3728g == C3728g.FAILED) {
                    m15336o();
                    C3688a.m15097b(f12610e + "|detect" + m15324c(c3731j) + "failed --------");
                    if (m15338q()) {
                        C3688a.m15097b(f12610e + "|pool is not empty, detect task " + m15324c(c3731j) + "stop");
                        a.m15370g();
                        return;
                    }
                    a.m15366a(false);
                }
            }
        }
    }

    public void m15343a(C3731j c3731j) {
    }

    public C3729h m15344b() {
        return C3729h.MOBILE;
    }

    public C3735o m15345c() {
        return this;
    }
}
