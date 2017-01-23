package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.d;
import com.google.android.gms.ads.h;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.eh;

@eh
public class AdSizeParcel extends AbstractSafeParcelable {
    public static final t CREATOR;
    public final String DW;
    public boolean EQ;
    public final int FH;
    public final int Hw;
    public final int VH;
    public final int Zo;
    public final AdSizeParcel[] gn;
    public final int j6;
    public final boolean tp;
    public final boolean u7;
    public final boolean v5;

    static {
        CREATOR = new t();
    }

    public AdSizeParcel() {
        this(5, "interstitial_mb", 0, 0, true, 0, 0, null, false, false, false);
    }

    AdSizeParcel(int i, String str, int i2, int i3, boolean z, int i4, int i5, AdSizeParcel[] adSizeParcelArr, boolean z2, boolean z3, boolean z4) {
        this.j6 = i;
        this.DW = str;
        this.FH = i2;
        this.Hw = i3;
        this.v5 = z;
        this.Zo = i4;
        this.VH = i5;
        this.gn = adSizeParcelArr;
        this.u7 = z2;
        this.tp = z3;
        this.EQ = z4;
    }

    public AdSizeParcel(Context context, d dVar) {
        this(context, new d[]{dVar});
    }

    public AdSizeParcel(Context context, d[] dVarArr) {
        int i;
        int i2;
        d dVar = dVarArr[0];
        this.j6 = 5;
        this.v5 = false;
        this.tp = dVar.FH();
        if (this.tp) {
            this.Zo = d.j6.DW();
            this.FH = d.j6.j6();
        } else {
            this.Zo = dVar.DW();
            this.FH = dVar.j6();
        }
        boolean z = this.Zo == -1;
        boolean z2 = this.FH == -2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (z) {
            if (w.j6().FH(context) && w.j6().Hw(context)) {
                this.VH = j6(displayMetrics) - w.j6().v5(context);
            } else {
                this.VH = j6(displayMetrics);
            }
            double d = (double) (((float) this.VH) / displayMetrics.density);
            i = (int) d;
            if (d - ((double) ((int) d)) >= 0.01d) {
                i++;
            }
            i2 = i;
        } else {
            i = this.Zo;
            this.VH = w.j6().j6(displayMetrics, this.Zo);
            i2 = i;
        }
        i = z2 ? FH(displayMetrics) : this.FH;
        this.Hw = w.j6().j6(displayMetrics, i);
        if (z || z2) {
            this.DW = i2 + "x" + i + "_as";
        } else if (this.tp) {
            this.DW = "320x50_mb";
        } else {
            this.DW = dVar.toString();
        }
        if (dVarArr.length > 1) {
            this.gn = new AdSizeParcel[dVarArr.length];
            for (int i3 = 0; i3 < dVarArr.length; i3++) {
                this.gn[i3] = new AdSizeParcel(context, dVarArr[i3]);
            }
        } else {
            this.gn = null;
        }
        this.u7 = false;
        this.EQ = false;
    }

    public static int DW(DisplayMetrics displayMetrics) {
        return (int) (((float) FH(displayMetrics)) * displayMetrics.density);
    }

    private static int FH(DisplayMetrics displayMetrics) {
        int i = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        return i <= 400 ? 32 : i <= 720 ? 50 : 90;
    }

    public static int j6(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    public static AdSizeParcel j6() {
        return new AdSizeParcel(5, "reward_mb", 0, 0, true, 0, 0, null, false, false, false);
    }

    public d DW() {
        return h.j6(this.Zo, this.FH, this.DW);
    }

    public void j6(boolean z) {
        this.EQ = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        t.j6(this, parcel, i);
    }
}
