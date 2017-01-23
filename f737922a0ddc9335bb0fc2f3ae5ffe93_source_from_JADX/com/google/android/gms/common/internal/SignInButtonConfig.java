package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class SignInButtonConfig extends AbstractSafeParcelable {
    public static final Creator<SignInButtonConfig> CREATOR;
    private final int DW;
    private final int FH;
    private final Scope[] Hw;
    final int j6;

    static {
        CREATOR = new e();
    }

    SignInButtonConfig(int i, int i2, int i3, Scope[] scopeArr) {
        this.j6 = i;
        this.DW = i2;
        this.FH = i3;
        this.Hw = scopeArr;
    }

    public SignInButtonConfig(int i, int i2, Scope[] scopeArr) {
        this(1, i, i2, scopeArr);
    }

    public int DW() {
        return this.FH;
    }

    public Scope[] FH() {
        return this.Hw;
    }

    public int j6() {
        return this.DW;
    }

    public void writeToParcel(Parcel parcel, int i) {
        e.j6(this, parcel, i);
    }
}
