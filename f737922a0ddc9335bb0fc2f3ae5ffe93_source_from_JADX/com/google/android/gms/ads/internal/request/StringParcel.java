package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.eh;

@eh
public class StringParcel extends AbstractSafeParcelable {
    public static final Creator<StringParcel> CREATOR;
    String DW;
    final int j6;

    static {
        CREATOR = new g();
    }

    StringParcel(int i, String str) {
        this.j6 = i;
        this.DW = str;
    }

    public StringParcel(String str) {
        this.j6 = 1;
        this.DW = str;
    }

    public String j6() {
        return this.DW;
    }

    public void writeToParcel(Parcel parcel, int i) {
        g.j6(this, parcel, i);
    }
}
