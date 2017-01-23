package com.igexin.push.p169f.p170b;

import com.igexin.p158b.p159a.p161b.C3685c;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.core.C3854f;
import com.igexin.push.core.C3855g;
import com.igexin.push.core.p176a.C3777e;
import com.igexin.push.p174c.C3730i;
import com.igexin.push.p182d.p184b.C3871a;
import com.igexin.push.util.C3922a;
import com.umeng.analytics.C4156a;
import java.util.concurrent.TimeUnit;

/* renamed from: com.igexin.push.f.b.g */
public class C3921g extends C3732h {
    private static C3921g f13185a;

    private C3921g() {
        super(C4156a.f13949k);
        this.o = true;
    }

    public static synchronized C3921g m16131g() {
        C3921g c3921g;
        synchronized (C3921g.class) {
            if (f13185a == null) {
                f13185a = new C3921g();
            }
            c3921g = f13185a;
        }
        return c3921g;
    }

    protected void m16132a() {
        C3777e.m15491a().m15506B();
        boolean a = C3777e.m15491a().m15528a(System.currentTimeMillis());
        boolean b = C3922a.m16145b();
        C3688a.m15097b("ReconnectTimerTask|networkAvailable = " + C3855g.f12971i + "|,sdkOnline = " + C3855g.f12976n + ", " + "sdkOn= " + C3855g.f12972j + ", pushOn =" + C3855g.f12973k + ", isSilentTime= " + a + ", blockEndTime= " + b);
        if (C3855g.f12971i && C3855g.f12972j && C3855g.f12973k && !C3855g.f12976n && !a && b) {
            C3688a.m15097b("ReconnectTimerTask reconnect timer task isOnline = false, try login...");
            int d = C3854f.m15859a().m15879i().m15549d();
            if (d != 1 && d == 0) {
                C3685c.m15060b().m15055a((Object) new C3871a());
                C3685c.m15060b().m15070c();
            }
            m14954a(1800000, TimeUnit.MILLISECONDS);
            return;
        }
        C3688a.m15097b("ReconnectTimerTask reconnect timer task stop, connect interval= 1h #######");
        m14954a((long) C4156a.f13949k, TimeUnit.MILLISECONDS);
    }

    public final int m16133b() {
        return -2147483641;
    }

    public void m16134c() {
        super.m14960c();
    }

    public void m16135d() {
    }

    public void m16136h() {
        long j = C3855g.f12941E;
        C3688a.m15097b("ReconnectTimerTask|refreshDelayTime, delay = " + j);
        if (!C3730i.m15273a().m15277e().m15268j()) {
            C3688a.m15097b("ReconnectTimerTask|refreshDelayTime, already enter backup or trynormal #####");
            m14954a(j, TimeUnit.MILLISECONDS);
        } else if (C3730i.m15273a().m15279g() != null) {
            m14954a(j, TimeUnit.MILLISECONDS);
        } else {
            C3688a.m15097b("ReconnectTimerTask|detect ip = null and not enter backup,  wait for detect, delay = 3600000");
            m14954a((long) C4156a.f13949k, TimeUnit.MILLISECONDS);
        }
    }
}
