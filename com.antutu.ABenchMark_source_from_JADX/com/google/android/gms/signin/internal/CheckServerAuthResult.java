package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class CheckServerAuthResult implements SafeParcelable {
    public static final Creator<CheckServerAuthResult> CREATOR;
    final int f12249a;
    final boolean f12250b;
    final List<Scope> f12251c;

    static {
        CREATOR = new C3547c();
    }

    CheckServerAuthResult(int i, boolean z, List<Scope> list) {
        this.f12249a = i;
        this.f12250b = z;
        this.f12251c = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C3547c.m14766a(this, parcel, i);
    }
}
