package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.ads.g;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.eh;

@eh
public class VideoOptionsParcel extends AbstractSafeParcelable {
    public static final m CREATOR;
    public final boolean DW;
    public final int j6;

    static {
        CREATOR = new m();
    }

    public VideoOptionsParcel(int i, boolean z) {
        this.j6 = i;
        this.DW = z;
    }

    public VideoOptionsParcel(g gVar) {
        this(1, gVar.j6());
    }

    public void writeToParcel(Parcel parcel, int i) {
        m.j6(this, parcel, i);
    }
}
