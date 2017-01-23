package com.igexin.push.p182d;

import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.core.C3855g;
import com.igexin.push.core.p176a.C3777e;
import com.igexin.push.util.C3922a;
import com.umeng.analytics.C4156a;

/* renamed from: com.igexin.push.d.f */
public class C3897f implements C3896i {
    private long m15999a(long j) {
        long j2 = j / 10;
        return ((long) (((Math.random() * ((double) j2)) * 2.0d) - ((double) j2))) + j;
    }

    public long m16000a(boolean z) {
        C3688a.m15097b("NormalModel|resetDelay = " + z);
        if (z) {
            C3855g.f12941E = 0;
            C3688a.m15097b("NormalModel|isResetDelay = true, reconnect delayTime = 0");
        }
        boolean a = C3777e.m15491a().m15528a(System.currentTimeMillis());
        boolean b = C3922a.m16145b();
        C3688a.m15097b("NormalModel|isSdkOn = " + C3855g.f12972j + " isPushOn = " + C3855g.f12973k + " checkIsSilentTime = " + a + " isBlockEndTime = " + b + " isNetworkAvailable = " + C3855g.f12971i);
        if (C3855g.f12971i && C3855g.f12972j && C3855g.f12973k && !a && b) {
            if (C3855g.f12941E <= 0) {
                C3855g.f12941E = 200;
            } else if (C3855g.f12941E <= 10000) {
                C3855g.f12941E += 500;
            } else if (C3855g.f12941E <= 30000) {
                C3855g.f12941E += 1500;
            } else {
                C3855g.f12941E += 120000;
            }
            if (C3855g.f12941E > C4156a.f13949k) {
                C3855g.f12941E = C4156a.f13949k;
            }
            long a2 = m15999a(C3855g.f12941E);
            C3688a.m15097b("NormalModel|after add auto reconnect delay time = " + a2);
            return a2;
        }
        C3688a.m15097b("NormalModel|reconnect stop, interval= 1h ++++");
        return C4156a.f13949k;
    }
}
