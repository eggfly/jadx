package com.google.android.gms.p146b;

import android.content.Context;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.p146b.fq.C2732a;
import com.google.android.gms.p146b.gx.C3232a;
import com.google.android.gms.p146b.ij.C2813a;
import com.umeng.message.util.HttpRequest;

@gb
/* renamed from: com.google.android.gms.b.fr */
public class fr extends fm implements C2813a {
    fr(Context context, C3232a c3232a, ii iiVar, C2732a c2732a) {
        super(context, c3232a, iiVar, c2732a);
    }

    protected void m12742b() {
        if (this.e.f9889e == -2) {
            this.c.m13249l().m13285a((C2813a) this);
            m12743f();
            C2972b.m11576a("Loading HTML in WebView.");
            this.c.loadDataWithBaseURL(C2968s.m11525e().m13027a(this.e.f9886b), this.e.f9887c, "text/html", HttpRequest.f14548a, null);
        }
    }

    protected void m12743f() {
    }
}
