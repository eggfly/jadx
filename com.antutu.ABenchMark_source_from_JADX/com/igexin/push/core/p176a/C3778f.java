package com.igexin.push.core.p176a;

import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.core.C3854f;
import com.igexin.push.core.C3855g;
import com.igexin.push.core.bean.C3821a;
import com.igexin.push.core.bean.C3830j;
import com.igexin.push.core.p175b.C3796c;
import com.igexin.push.p169f.C3716a;
import com.igexin.push.p182d.p185c.C3876e;
import com.igexin.push.p182d.p185c.C3880d;

/* renamed from: com.igexin.push.core.a.f */
class C3778f extends C3716a {
    final /* synthetic */ C3821a f12703a;
    final /* synthetic */ long f12704b;
    final /* synthetic */ C3777e f12705c;

    C3778f(C3777e c3777e, Object obj, C3821a c3821a, long j) {
        this.f12705c = c3777e;
        this.f12703a = c3821a;
        this.f12704b = j;
        super(obj);
    }

    protected Object m15578a(Object obj) {
        try {
            return C3821a.m15693a(this.f12703a);
        } catch (Throwable th) {
            return null;
        }
    }

    protected void m15579a(Object obj, Object obj2) {
        if (obj2 != null) {
            String str = (String) obj2;
            C3688a.m15097b("addphoneinfo");
            C3796c a = C3796c.m15612a();
            if (a != null) {
                a.m15616a(new C3830j(this.f12704b, str, (byte) 5, this.f12704b));
            }
            C3876e c3880d = new C3880d();
            c3880d.m15964a();
            c3880d.f13058a = (int) this.f12704b;
            c3880d.f13061d = "17258000";
            c3880d.f13062e = str;
            c3880d.f13064g = C3855g.f12982t;
            C3854f.m15859a().m15877g().m16057a("C-" + C3855g.f12982t, c3880d);
        }
    }
}
