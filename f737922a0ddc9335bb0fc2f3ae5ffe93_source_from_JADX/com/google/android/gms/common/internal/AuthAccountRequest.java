package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class AuthAccountRequest extends AbstractSafeParcelable {
    public static final Creator<AuthAccountRequest> CREATOR;
    final IBinder DW;
    final Scope[] FH;
    Integer Hw;
    final int j6;
    Integer v5;

    static {
        CREATOR = new j();
    }

    AuthAccountRequest(int i, IBinder iBinder, Scope[] scopeArr, Integer num, Integer num2) {
        this.j6 = i;
        this.DW = iBinder;
        this.FH = scopeArr;
        this.Hw = num;
        this.v5 = num2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        j.j6(this, parcel, i);
    }
}
