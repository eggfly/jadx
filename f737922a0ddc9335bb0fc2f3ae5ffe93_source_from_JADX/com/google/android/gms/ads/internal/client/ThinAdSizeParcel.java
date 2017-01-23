package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.eh;

@eh
public class ThinAdSizeParcel extends AdSizeParcel {
    public void writeToParcel(Parcel parcel, int i) {
        int j6 = b.j6(parcel);
        b.j6(parcel, 1, this.j6);
        b.j6(parcel, 2, this.DW, false);
        b.j6(parcel, 3, this.FH);
        b.j6(parcel, 6, this.Zo);
        b.j6(parcel, j6);
    }
}
