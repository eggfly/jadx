package com.google.android.gms.ads.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.p146b.gb;

@gb
public final class InterstitialAdParameterParcel implements SafeParcelable {
    public static final C2837m CREATOR;
    public final int f9287a;
    public final boolean f9288b;
    public final boolean f9289c;
    public final String f9290d;
    public final boolean f9291e;
    public final float f9292f;

    static {
        CREATOR = new C2837m();
    }

    InterstitialAdParameterParcel(int i, boolean z, boolean z2, String str, boolean z3, float f) {
        this.f9287a = i;
        this.f9288b = z;
        this.f9289c = z2;
        this.f9290d = str;
        this.f9291e = z3;
        this.f9292f = f;
    }

    public InterstitialAdParameterParcel(boolean z, boolean z2, String str, boolean z3, float f) {
        this(2, z, z2, str, z3, f);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2837m.m11000a(this, parcel, i);
    }
}
