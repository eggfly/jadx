package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Deprecated
public class ValidateAccountRequest extends AbstractSafeParcelable {
    public static final Creator<ValidateAccountRequest> CREATOR;
    final IBinder DW;
    private final int FH;
    private final Scope[] Hw;
    private final String Zo;
    final int j6;
    private final Bundle v5;

    static {
        CREATOR = new h();
    }

    ValidateAccountRequest(int i, int i2, IBinder iBinder, Scope[] scopeArr, Bundle bundle, String str) {
        this.j6 = i;
        this.FH = i2;
        this.DW = iBinder;
        this.Hw = scopeArr;
        this.v5 = bundle;
        this.Zo = str;
    }

    public Scope[] DW() {
        return this.Hw;
    }

    public String FH() {
        return this.Zo;
    }

    public Bundle Hw() {
        return this.v5;
    }

    public int j6() {
        return this.FH;
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.j6(this, parcel, i);
    }
}
