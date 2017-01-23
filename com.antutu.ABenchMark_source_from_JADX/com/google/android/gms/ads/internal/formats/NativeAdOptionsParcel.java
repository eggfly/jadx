package com.google.android.gms.ads.internal.formats;

import android.os.Parcel;
import com.google.android.gms.ads.p124b.C2704b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.p146b.gb;

@gb
public class NativeAdOptionsParcel implements SafeParcelable {
    public static final C2820j CREATOR;
    public final int f9485a;
    public final boolean f9486b;
    public final int f9487c;
    public final boolean f9488d;

    static {
        CREATOR = new C2820j();
    }

    public NativeAdOptionsParcel(int i, boolean z, int i2, boolean z2) {
        this.f9485a = i;
        this.f9486b = z;
        this.f9487c = i2;
        this.f9488d = z2;
    }

    public NativeAdOptionsParcel(C2704b c2704b) {
        this(1, c2704b.m10285a(), c2704b.m10286b(), c2704b.m10287c());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2820j.m10902a(this, parcel, i);
    }
}
