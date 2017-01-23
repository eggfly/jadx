package com.google.android.gms.common.server;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class FavaDiagnosticsEntity extends AbstractSafeParcelable {
    public static final a CREATOR;
    public final String DW;
    public final int FH;
    final int j6;

    static {
        CREATOR = new a();
    }

    public FavaDiagnosticsEntity(int i, String str, int i2) {
        this.j6 = i;
        this.DW = str;
        this.FH = i2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        a.j6(this, parcel, i);
    }
}
