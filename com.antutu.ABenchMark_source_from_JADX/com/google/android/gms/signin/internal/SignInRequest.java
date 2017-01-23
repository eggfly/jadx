package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class SignInRequest implements SafeParcelable {
    public static final Creator<SignInRequest> CREATOR;
    final int f12256a;
    final ResolveAccountRequest f12257b;

    static {
        CREATOR = new C3555i();
    }

    SignInRequest(int i, ResolveAccountRequest resolveAccountRequest) {
        this.f12256a = i;
        this.f12257b = resolveAccountRequest;
    }

    public SignInRequest(ResolveAccountRequest resolveAccountRequest) {
        this(1, resolveAccountRequest);
    }

    public ResolveAccountRequest m14760a() {
        return this.f12257b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C3555i.m14810a(this, parcel, i);
    }
}
