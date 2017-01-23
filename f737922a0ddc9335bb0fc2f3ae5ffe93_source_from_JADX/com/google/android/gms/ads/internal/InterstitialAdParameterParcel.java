package com.google.android.gms.ads.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.eh;

@eh
public final class InterstitialAdParameterParcel extends AbstractSafeParcelable {
    public static final c CREATOR;
    public final boolean DW;
    public final boolean FH;
    public final String Hw;
    public final int VH;
    public final float Zo;
    public final int j6;
    public final boolean v5;

    static {
        CREATOR = new c();
    }

    InterstitialAdParameterParcel(int i, boolean z, boolean z2, String str, boolean z3, float f, int i2) {
        this.j6 = i;
        this.DW = z;
        this.FH = z2;
        this.Hw = str;
        this.v5 = z3;
        this.Zo = f;
        this.VH = i2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        c.j6(this, parcel, i);
    }
}
