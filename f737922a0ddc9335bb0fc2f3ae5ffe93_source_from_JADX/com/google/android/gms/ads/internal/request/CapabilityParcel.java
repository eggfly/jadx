package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.eh;

@eh
public class CapabilityParcel extends AbstractSafeParcelable {
    public static final Creator<CapabilityParcel> CREATOR;
    public final boolean DW;
    public final boolean FH;
    public final boolean Hw;
    public final int j6;

    static {
        CREATOR = new e();
    }

    CapabilityParcel(int i, boolean z, boolean z2, boolean z3) {
        this.j6 = i;
        this.DW = z;
        this.FH = z2;
        this.Hw = z3;
    }

    public void writeToParcel(Parcel parcel, int i) {
        e.j6(this, parcel, i);
    }
}
