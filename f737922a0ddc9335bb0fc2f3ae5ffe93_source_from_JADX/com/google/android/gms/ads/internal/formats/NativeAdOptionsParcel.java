package com.google.android.gms.ads.internal.formats;

import android.os.Parcel;
import com.google.android.gms.ads.formats.b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.eh;

@eh
public class NativeAdOptionsParcel extends AbstractSafeParcelable {
    public static final b CREATOR;
    public final boolean DW;
    public final int FH;
    public final boolean Hw;
    public final int j6;

    static {
        CREATOR = new b();
    }

    public NativeAdOptionsParcel(int i, boolean z, int i2, boolean z2) {
        this.j6 = i;
        this.DW = z;
        this.FH = i2;
        this.Hw = z2;
    }

    public NativeAdOptionsParcel(b bVar) {
        this(1, bVar.j6(), bVar.DW(), bVar.FH());
    }

    public void writeToParcel(Parcel parcel, int i) {
        b.j6(this, parcel, i);
    }
}
