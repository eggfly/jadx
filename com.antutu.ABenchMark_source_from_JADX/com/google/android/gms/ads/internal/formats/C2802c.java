package com.google.android.gms.ads.internal.formats;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.p146b.bf.C2801a;
import com.google.android.gms.p146b.gb;
import com.google.android.gms.p151a.C2687a;
import com.google.android.gms.p151a.C2690b;

@gb
/* renamed from: com.google.android.gms.ads.internal.formats.c */
public class C2802c extends C2801a {
    private final Drawable f9502a;
    private final Uri f9503b;
    private final double f9504c;

    public C2802c(Drawable drawable, Uri uri, double d) {
        this.f9502a = drawable;
        this.f9503b = uri;
        this.f9504c = d;
    }

    public C2687a m10789a() {
        return C2690b.m10262a(this.f9502a);
    }

    public Uri m10790b() {
        return this.f9503b;
    }

    public double m10791c() {
        return this.f9504c;
    }
}
