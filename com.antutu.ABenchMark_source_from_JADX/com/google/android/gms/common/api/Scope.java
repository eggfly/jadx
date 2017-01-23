package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C3512u;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class Scope implements SafeParcelable {
    public static final Creator<Scope> CREATOR;
    final int f11819a;
    private final String f11820b;

    static {
        CREATOR = new C3451l();
    }

    Scope(int i, String str) {
        C3512u.m14583a(str, (Object) "scopeUri must not be null or empty");
        this.f11819a = i;
        this.f11820b = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    public String m13956a() {
        return this.f11820b;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj ? true : !(obj instanceof Scope) ? false : this.f11820b.equals(((Scope) obj).f11820b);
    }

    public int hashCode() {
        return this.f11820b.hashCode();
    }

    public String toString() {
        return this.f11820b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C3451l.m14259a(this, parcel, i);
    }
}
