package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.C3386f;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AuthAccountResult implements C3386f, SafeParcelable {
    public static final Creator<AuthAccountResult> CREATOR;
    final int f12246a;
    private int f12247b;
    private Intent f12248c;

    static {
        CREATOR = new C3546a();
    }

    public AuthAccountResult() {
        this(0, null);
    }

    AuthAccountResult(int i, int i2, Intent intent) {
        this.f12246a = i;
        this.f12247b = i2;
        this.f12248c = intent;
    }

    public AuthAccountResult(int i, Intent intent) {
        this(2, i, intent);
    }

    public Status m14754a() {
        return this.f12247b == 0 ? Status.f11821a : Status.f11825e;
    }

    public int m14755b() {
        return this.f12247b;
    }

    public Intent m14756c() {
        return this.f12248c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C3546a.m14763a(this, parcel, i);
    }
}
