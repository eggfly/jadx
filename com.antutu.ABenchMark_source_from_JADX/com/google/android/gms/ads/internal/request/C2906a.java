package com.google.android.gms.ads.internal.request;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel.C2904a;
import com.google.android.gms.p146b.C3326k;
import com.google.android.gms.p146b.gb;
import com.google.android.gms.p146b.gx.C3232a;
import com.google.android.gms.p146b.he;

@gb
/* renamed from: com.google.android.gms.ads.internal.request.a */
public class C2906a {

    /* renamed from: com.google.android.gms.ads.internal.request.a.a */
    public interface C2731a {
        void m10417a(C3232a c3232a);
    }

    public he m11302a(Context context, C2904a c2904a, C3326k c3326k, C2731a c2731a) {
        he c2948m = c2904a.f9819b.f9309c.getBundle("sdk_less_server_data") != null ? new C2948m(context, c2904a, c2731a) : new C2911b(context, c2904a, c3326k, c2731a);
        c2948m.m10975g();
        return c2948m;
    }
}
