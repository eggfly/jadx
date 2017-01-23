package com.igexin.push.p174c;

import android.text.TextUtils;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.core.C3855g;

/* renamed from: com.igexin.push.c.r */
public class C3740r extends C3734m implements C3735o {
    private static final String f12625e;
    private static C3740r f12626f;

    static {
        f12625e = C3740r.class.getName();
    }

    private C3740r() {
        super(C3855g.ax, C3855g.az);
    }

    public static synchronized C3740r m15374a() {
        C3740r c3740r;
        synchronized (C3740r.class) {
            if (f12626f == null) {
                f12626f = new C3740r();
            }
            c3740r = f12626f;
        }
        return c3740r;
    }

    public void m15375a(C3728g c3728g, C3731j c3731j) {
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
                    C3688a.m15097b(f12625e + "|detect" + m15324c(c3731j) + "failed --------------");
                    if (m15338q()) {
                        a.m15370g();
                    } else {
                        a.m15366a(false);
                    }
                }
            }
        }
    }

    public void m15376a(C3731j c3731j) {
    }

    public C3729h m15377b() {
        return C3729h.WIFI;
    }

    public C3735o m15378c() {
        return this;
    }
}
