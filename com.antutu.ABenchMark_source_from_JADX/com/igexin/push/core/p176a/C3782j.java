package com.igexin.push.core.p176a;

import com.igexin.p158b.p159a.p165d.C3666d;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.config.C3753l;
import com.igexin.push.core.C3857i;
import com.igexin.push.core.C3859k;
import com.igexin.push.p182d.C3875b;
import com.igexin.push.p182d.p185c.C3883h;

/* renamed from: com.igexin.push.core.a.j */
public class C3782j extends C3772a {
    private static final String f12712a;

    static {
        f12712a = C3753l.f12646a;
    }

    public boolean m15585a(C3666d c3666d) {
        return false;
    }

    public boolean m15586a(Object obj) {
        if (obj instanceof C3883h) {
            C3875b.m15932a().m15941e();
            C3688a.m15097b("heartbeatRsp");
            C3857i.m15894a().m15899a(C3859k.HEARTBEAT_OK);
        }
        return true;
    }
}
