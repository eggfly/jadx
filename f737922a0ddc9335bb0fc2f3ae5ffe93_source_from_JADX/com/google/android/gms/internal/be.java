package com.google.android.gms.internal;

import agg;
import agh;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.ads.formats.a.a;
import com.google.android.gms.ads.internal.util.client.b;

@eh
public class be extends a {
    private final Drawable DW;
    private final Uri FH;
    private final double Hw;
    private final bd j6;

    public be(bd bdVar) {
        Drawable drawable;
        double d;
        Uri uri = null;
        this.j6 = bdVar;
        try {
            agg j6 = this.j6.j6();
            if (j6 != null) {
                drawable = (Drawable) agh.j6(j6);
                this.DW = drawable;
                uri = this.j6.DW();
                this.FH = uri;
                d = 1.0d;
                d = this.j6.FH();
                this.Hw = d;
            }
        } catch (Throwable e) {
            b.DW("Failed to get drawable.", e);
        }
        Object obj = uri;
        this.DW = drawable;
        try {
            uri = this.j6.DW();
        } catch (Throwable e2) {
            b.DW("Failed to get uri.", e2);
        }
        this.FH = uri;
        d = 1.0d;
        try {
            d = this.j6.FH();
        } catch (Throwable e3) {
            b.DW("Failed to get scale.", e3);
        }
        this.Hw = d;
    }

    public Uri DW() {
        return this.FH;
    }

    public double FH() {
        return this.Hw;
    }

    public Drawable j6() {
        return this.DW;
    }
}
