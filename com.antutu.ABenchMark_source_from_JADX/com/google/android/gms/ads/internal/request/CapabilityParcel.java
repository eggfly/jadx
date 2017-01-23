package com.google.android.gms.ads.internal.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.p146b.gb;

@gb
public class CapabilityParcel implements SafeParcelable {
    public static final Creator<CapabilityParcel> CREATOR;
    public final int f9911a;
    public final boolean f9912b;
    public final boolean f9913c;
    public final boolean f9914d;

    static {
        CREATOR = new C2933i();
    }

    CapabilityParcel(int i, boolean z, boolean z2, boolean z3) {
        this.f9911a = i;
        this.f9912b = z;
        this.f9913c = z2;
        this.f9914d = z3;
    }

    public CapabilityParcel(boolean z, boolean z2, boolean z3) {
        this(2, z, z2, z3);
    }

    public Bundle m11298a() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("iap_supported", this.f9912b);
        bundle.putBoolean("default_iap_supported", this.f9913c);
        bundle.putBoolean("app_streaming_supported", this.f9914d);
        return bundle;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2933i.m11414a(this, parcel, i);
    }
}
