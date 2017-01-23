package com.igexin.push.core.p176a;

import android.text.TextUtils;
import com.igexin.p158b.p159a.p165d.C3666d;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.config.C3753l;
import com.igexin.push.core.C3854f;
import com.igexin.push.core.C3855g;
import com.igexin.push.core.p175b.C3799f;
import com.igexin.push.p182d.p185c.C3876e;
import com.igexin.push.p182d.p185c.C3892q;

/* renamed from: com.igexin.push.core.a.r */
public class C3790r extends C3772a {
    private static final String f12718a;

    static {
        f12718a = C3753l.f12646a + "_RegisterResultAction";
    }

    public boolean m15601a(C3666d c3666d) {
        return false;
    }

    public boolean m15602a(Object obj) {
        boolean z = false;
        if (obj instanceof C3892q) {
            C3892q c3892q = (C3892q) obj;
            C3855g.f12941E = 0;
            C3688a.m15097b("register resp |" + c3892q.f13120a + "|" + C3855g.f12981s);
            C3688a.m15097b("register resp cid = " + c3892q.f13122c + " device id = " + c3892q.f13123d);
            if (c3892q.f13120a != C3855g.f12981s) {
                C3855g.f12977o = false;
                C3688a.m15097b(f12718a + " change session : from [" + C3855g.f12981s + "] to [" + c3892q.f13120a + "]");
                C3688a.m15097b(f12718a + " change cid : from [" + C3855g.f12982t + "] to [" + c3892q.f13122c + "]");
                if (TextUtils.isEmpty(c3892q.f13122c) || TextUtils.isEmpty(c3892q.f13123d)) {
                    C3799f.m15623a().m15643a(c3892q.f13120a);
                } else {
                    C3799f.m15623a().m15645a(c3892q.f13122c, c3892q.f13123d, c3892q.f13120a);
                }
                C3855g.f12943G = 0;
                z = true;
            }
            C3688a.m15097b("loginReqAfterRegister|new session:" + C3855g.f12981s + ", cid :" + C3855g.f12982t + ", devId :" + C3855g.f12937A);
            C3876e c = C3777e.m15491a().m15544c();
            C3854f.m15859a().m15877g().m16058a("S-" + c.f13093a, c, true);
            if (z) {
                return true;
            }
        }
        return true;
    }
}
