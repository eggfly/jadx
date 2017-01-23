package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class SignInResponse extends AbstractSafeParcelable {
    public static final Creator<SignInResponse> CREATOR;
    private final ConnectionResult DW;
    private final ResolveAccountResponse FH;
    final int j6;

    static {
        CREATOR = new h();
    }

    SignInResponse(int i, ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        this.j6 = i;
        this.DW = connectionResult;
        this.FH = resolveAccountResponse;
    }

    public ResolveAccountResponse DW() {
        return this.FH;
    }

    public ConnectionResult j6() {
        return this.DW;
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.j6(this, parcel, i);
    }
}
