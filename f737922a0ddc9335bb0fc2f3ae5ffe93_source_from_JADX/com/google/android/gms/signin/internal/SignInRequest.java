package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class SignInRequest extends AbstractSafeParcelable {
    public static final Creator<SignInRequest> CREATOR;
    final ResolveAccountRequest DW;
    final int j6;

    static {
        CREATOR = new g();
    }

    SignInRequest(int i, ResolveAccountRequest resolveAccountRequest) {
        this.j6 = i;
        this.DW = resolveAccountRequest;
    }

    public ResolveAccountRequest j6() {
        return this.DW;
    }

    public void writeToParcel(Parcel parcel, int i) {
        g.j6(this, parcel, i);
    }
}
