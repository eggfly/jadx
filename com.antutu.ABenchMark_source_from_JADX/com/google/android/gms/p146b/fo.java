package com.google.android.gms.p146b;

import android.content.Context;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.p146b.fq.C2732a;
import com.google.android.gms.p146b.gx.C3232a;
import com.google.android.gms.p146b.ij.C2813a;

@gb
/* renamed from: com.google.android.gms.b.fo */
public class fo extends fm {
    private fn f10935g;

    fo(Context context, C3232a c3232a, ii iiVar, C2732a c2732a) {
        super(context, c3232a, iiVar, c2732a);
    }

    protected void m12733b() {
        int i;
        int i2;
        AdSizeParcel k = this.c.m13248k();
        if (k.f9329e) {
            DisplayMetrics displayMetrics = this.b.getResources().getDisplayMetrics();
            i = displayMetrics.widthPixels;
            i2 = displayMetrics.heightPixels;
        } else {
            i = k.f9331g;
            i2 = k.f9328d;
        }
        this.f10935g = new fn(this, this.c, i, i2);
        this.c.m13249l().m13285a((C2813a) this);
        this.f10935g.m12728a(this.e);
    }

    protected int m12734c() {
        if (!this.f10935g.m12731c()) {
            return !this.f10935g.m12732d() ? 2 : -2;
        } else {
            C2972b.m11576a("Ad-Network indicated no fill with passback URL.");
            return 3;
        }
    }
}
