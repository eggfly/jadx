package com.google.android.gms.p146b;

import com.google.android.gms.ads.internal.C2968s;

@gb
/* renamed from: com.google.android.gms.b.cl */
public class cl extends he {
    final ii f10452a;
    final cn f10453b;
    private final String f10454c;

    /* renamed from: com.google.android.gms.b.cl.1 */
    class C30751 implements Runnable {
        final /* synthetic */ cl f10451a;

        C30751(cl clVar) {
            this.f10451a = clVar;
        }

        public void run() {
            C2968s.m11540t().m12074b(this.f10451a);
        }
    }

    cl(ii iiVar, cn cnVar, String str) {
        this.f10452a = iiVar;
        this.f10453b = cnVar;
        this.f10454c = str;
        C2968s.m11540t().m12072a(this);
    }

    public void m12069a() {
        try {
            this.f10453b.m12085a(this.f10454c);
        } finally {
            hj.f11297a.post(new C30751(this));
        }
    }

    public void m12070b() {
        this.f10453b.m12087b();
    }
}
