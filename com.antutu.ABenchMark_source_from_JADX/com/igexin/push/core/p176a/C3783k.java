package com.igexin.push.core.p176a;

import com.igexin.p158b.p159a.p165d.C3666d;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.core.C3854f;
import com.igexin.push.p182d.p185c.C3885j;

/* renamed from: com.igexin.push.core.a.k */
public class C3783k extends C3772a {
    private static final String f12713a;

    static {
        f12713a = C3783k.class.getName();
    }

    public boolean m15587a(C3666d c3666d) {
        return false;
    }

    public boolean m15588a(Object obj) {
        if (obj instanceof C3885j) {
            C3885j c3885j = (C3885j) obj;
            boolean z = c3885j.f13091a == null;
            C3688a.m15097b(f12713a + "|KeyNego result = " + c3885j.f13091a);
            if (z) {
                C3688a.m15097b(f12713a + "|KeyNego success and login");
                C3854f.m15859a().m15879i().m15554e();
            }
        }
        return true;
    }
}
