package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C3511t;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FACLConfig implements SafeParcelable {
    public static final C3014a CREATOR;
    final int f10181a;
    boolean f10182b;
    String f10183c;
    boolean f10184d;
    boolean f10185e;
    boolean f10186f;
    boolean f10187g;

    static {
        CREATOR = new C3014a();
    }

    FACLConfig(int i, boolean z, String str, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.f10181a = i;
        this.f10182b = z;
        this.f10183c = str;
        this.f10184d = z2;
        this.f10185e = z3;
        this.f10186f = z4;
        this.f10187g = z5;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FACLConfig)) {
            return false;
        }
        FACLConfig fACLConfig = (FACLConfig) obj;
        return this.f10182b == fACLConfig.f10182b && TextUtils.equals(this.f10183c, fACLConfig.f10183c) && this.f10184d == fACLConfig.f10184d && this.f10185e == fACLConfig.f10185e && this.f10186f == fACLConfig.f10186f && this.f10187g == fACLConfig.f10187g;
    }

    public int hashCode() {
        return C3511t.m14577a(Boolean.valueOf(this.f10182b), this.f10183c, Boolean.valueOf(this.f10184d), Boolean.valueOf(this.f10185e), Boolean.valueOf(this.f10186f), Boolean.valueOf(this.f10187g));
    }

    public void writeToParcel(Parcel parcel, int i) {
        C3014a.m11720a(this, parcel, i);
    }
}
