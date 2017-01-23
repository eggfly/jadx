package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class AuthAccountResult extends AbstractSafeParcelable implements e {
    public static final Creator<AuthAccountResult> CREATOR;
    private int DW;
    private Intent FH;
    final int j6;

    static {
        CREATOR = new a();
    }

    public AuthAccountResult() {
        this(0, null);
    }

    AuthAccountResult(int i, int i2, Intent intent) {
        this.j6 = i;
        this.DW = i2;
        this.FH = intent;
    }

    public AuthAccountResult(int i, Intent intent) {
        this(2, i, intent);
    }

    public Status DW() {
        return this.DW == 0 ? Status.j6 : Status.v5;
    }

    public Intent FH() {
        return this.FH;
    }

    public int j6() {
        return this.DW;
    }

    public void writeToParcel(Parcel parcel, int i) {
        a.j6(this, parcel, i);
    }
}
