package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Deprecated
public class ValidateAccountRequest implements SafeParcelable {
    public static final Creator<ValidateAccountRequest> CREATOR;
    final int f12045a;
    final IBinder f12046b;
    private final int f12047c;
    private final Scope[] f12048d;
    private final Bundle f12049e;
    private final String f12050f;

    static {
        CREATOR = new C3472c();
    }

    ValidateAccountRequest(int i, int i2, IBinder iBinder, Scope[] scopeArr, Bundle bundle, String str) {
        this.f12045a = i;
        this.f12047c = i2;
        this.f12046b = iBinder;
        this.f12048d = scopeArr;
        this.f12049e = bundle;
        this.f12050f = str;
    }

    public int m14323a() {
        return this.f12047c;
    }

    public Scope[] m14324b() {
        return this.f12048d;
    }

    public String m14325c() {
        return this.f12050f;
    }

    public Bundle m14326d() {
        return this.f12049e;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C3472c.m14335a(this, parcel, i);
    }
}
