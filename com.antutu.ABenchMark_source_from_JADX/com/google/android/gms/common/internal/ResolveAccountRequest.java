package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ResolveAccountRequest implements SafeParcelable {
    public static final Creator<ResolveAccountRequest> CREATOR;
    final int f12036a;
    private final Account f12037b;
    private final int f12038c;
    private final GoogleSignInAccount f12039d;

    static {
        CREATOR = new C3513v();
    }

    ResolveAccountRequest(int i, Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this.f12036a = i;
        this.f12037b = account;
        this.f12038c = i2;
        this.f12039d = googleSignInAccount;
    }

    public ResolveAccountRequest(Account account, int i, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i, googleSignInAccount);
    }

    public Account m14316a() {
        return this.f12037b;
    }

    public int m14317b() {
        return this.f12038c;
    }

    public GoogleSignInAccount m14318c() {
        return this.f12039d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C3513v.m14591a(this, parcel, i);
    }
}
