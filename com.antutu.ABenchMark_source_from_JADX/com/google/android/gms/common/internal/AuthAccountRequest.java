package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AuthAccountRequest implements SafeParcelable {
    public static final Creator<AuthAccountRequest> CREATOR;
    final int f12018a;
    final IBinder f12019b;
    final Scope[] f12020c;
    Integer f12021d;
    Integer f12022e;

    static {
        CREATOR = new C3474e();
    }

    AuthAccountRequest(int i, IBinder iBinder, Scope[] scopeArr, Integer num, Integer num2) {
        this.f12018a = i;
        this.f12019b = iBinder;
        this.f12020c = scopeArr;
        this.f12021d = num;
        this.f12022e = num2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C3474e.m14339a(this, parcel, i);
    }
}
