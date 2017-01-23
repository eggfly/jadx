package com.google.android.gms.ads.internal.formats;

import agg;
import agh;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.internal.eh;

@eh
public class a extends com.google.android.gms.internal.bd.a {
    private final Uri DW;
    private final double FH;
    private final Drawable j6;

    public a(Drawable drawable, Uri uri, double d) {
        this.j6 = drawable;
        this.DW = uri;
        this.FH = d;
    }

    public Uri DW() {
        return this.DW;
    }

    public double FH() {
        return this.FH;
    }

    public agg j6() {
        return agh.j6(this.j6);
    }
}
