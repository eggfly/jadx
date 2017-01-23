package com.google.android.gms.ads.internal.request;

import com.google.android.gms.ads.internal.request.C2914c.C2910a;
import com.google.android.gms.ads.internal.request.C2929k.C2930a;
import com.google.android.gms.p146b.gb;
import java.lang.ref.WeakReference;

@gb
/* renamed from: com.google.android.gms.ads.internal.request.g */
public final class C2931g extends C2930a {
    private final WeakReference<C2910a> f9980a;

    public C2931g(C2910a c2910a) {
        this.f9980a = new WeakReference(c2910a);
    }

    public void m11410a(AdResponseParcel adResponseParcel) {
        C2910a c2910a = (C2910a) this.f9980a.get();
        if (c2910a != null) {
            c2910a.m11304a(adResponseParcel);
        }
    }
}
