package com.igexin.p158b.p159a.p161b.p162a.p163a;

import com.igexin.p158b.p159a.p161b.C3667e;
import com.igexin.p158b.p159a.p161b.p162a.p163a.p164a.C3660b;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.p182d.C3875b;

/* renamed from: com.igexin.b.a.b.a.a.f */
class C3673f implements C3660b {
    final /* synthetic */ C3671d f12387a;

    C3673f(C3671d c3671d) {
        this.f12387a = c3671d;
    }

    public void m15018a() {
    }

    public void m15019a(C3667e c3667e) {
        this.f12387a.f12383o.sendEmptyMessage(3);
    }

    public void m15020a(Exception exception) {
        C3688a.m15097b(C3671d.f12369e + "|r ex = " + exception.toString());
        if (exception.getMessage() != null && exception.getMessage().equals("end of stream")) {
            C3875b.m15932a().m15940d();
        }
        this.f12387a.m15011b();
    }
}
