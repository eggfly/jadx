package com.google.android.gms.ads.internal.util.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.eh;

@eh
public final class VersionInfoParcel extends AbstractSafeParcelable {
    public static final d CREATOR;
    public String DW;
    public int FH;
    public int Hw;
    public final int j6;
    public boolean v5;

    static {
        CREATOR = new d();
    }

    VersionInfoParcel(int i, String str, int i2, int i3, boolean z) {
        this.j6 = i;
        this.DW = str;
        this.FH = i2;
        this.Hw = i3;
        this.v5 = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        d.j6(this, parcel, i);
    }
}
