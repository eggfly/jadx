package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FACLData implements SafeParcelable {
    public static final C3015b CREATOR;
    final int f10188a;
    FACLConfig f10189b;
    String f10190c;
    boolean f10191d;
    String f10192e;

    static {
        CREATOR = new C3015b();
    }

    FACLData(int i, FACLConfig fACLConfig, String str, boolean z, String str2) {
        this.f10188a = i;
        this.f10189b = fACLConfig;
        this.f10190c = str;
        this.f10191d = z;
        this.f10192e = str2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C3015b.m11723a(this, parcel, i);
    }
}
