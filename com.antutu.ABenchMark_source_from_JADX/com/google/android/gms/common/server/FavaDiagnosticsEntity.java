package com.google.android.gms.common.server;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FavaDiagnosticsEntity implements SafeParcelable {
    public static final C3515a CREATOR;
    final int f12119a;
    public final String f12120b;
    public final int f12121c;

    static {
        CREATOR = new C3515a();
    }

    public FavaDiagnosticsEntity(int i, String str, int i2) {
        this.f12119a = i;
        this.f12120b = str;
        this.f12121c = i2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C3515a.m14597a(this, parcel, i);
    }
}
