package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.p146b.gb;

@gb
public class StringParcel implements SafeParcelable {
    public static final Creator<StringParcel> CREATOR;
    final int f9922a;
    String f9923b;

    static {
        CREATOR = new C2949n();
    }

    StringParcel(int i, String str) {
        this.f9922a = i;
        this.f9923b = str;
    }

    public StringParcel(String str) {
        this.f9922a = 1;
        this.f9923b = str;
    }

    public String m11301a() {
        return this.f9923b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2949n.m11446a(this, parcel, i);
    }
}
