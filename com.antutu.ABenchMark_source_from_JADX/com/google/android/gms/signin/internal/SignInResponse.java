package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class SignInResponse implements SafeParcelable {
    public static final Creator<SignInResponse> CREATOR;
    final int f12258a;
    private final ConnectionResult f12259b;
    private final ResolveAccountResponse f12260c;

    static {
        CREATOR = new C3556j();
    }

    public SignInResponse(int i) {
        this(new ConnectionResult(i, null), null);
    }

    SignInResponse(int i, ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        this.f12258a = i;
        this.f12259b = connectionResult;
        this.f12260c = resolveAccountResponse;
    }

    public SignInResponse(ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        this(1, connectionResult, resolveAccountResponse);
    }

    public ConnectionResult m14761a() {
        return this.f12259b;
    }

    public ResolveAccountResponse m14762b() {
        return this.f12260c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C3556j.m14813a(this, parcel, i);
    }
}
