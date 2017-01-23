package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class ResolveAccountRequest extends AbstractSafeParcelable {
    public static final Creator<ResolveAccountRequest> CREATOR;
    private final Account DW;
    private final int FH;
    private final GoogleSignInAccount Hw;
    final int j6;

    static {
        CREATOR = new c();
    }

    ResolveAccountRequest(int i, Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this.j6 = i;
        this.DW = account;
        this.FH = i2;
        this.Hw = googleSignInAccount;
    }

    public int DW() {
        return this.FH;
    }

    public GoogleSignInAccount FH() {
        return this.Hw;
    }

    public Account j6() {
        return this.DW;
    }

    public void writeToParcel(Parcel parcel, int i) {
        c.j6(this, parcel, i);
    }
}
