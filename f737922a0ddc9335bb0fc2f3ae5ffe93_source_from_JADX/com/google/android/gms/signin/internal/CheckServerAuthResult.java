package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;

public class CheckServerAuthResult extends AbstractSafeParcelable {
    public static final Creator<CheckServerAuthResult> CREATOR;
    final boolean DW;
    final List<Scope> FH;
    final int j6;

    static {
        CREATOR = new b();
    }

    CheckServerAuthResult(int i, boolean z, List<Scope> list) {
        this.j6 = i;
        this.DW = z;
        this.FH = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        b.j6(this, parcel, i);
    }
}
