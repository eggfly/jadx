package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.v.a;

public class ResolveAccountResponse extends AbstractSafeParcelable {
    public static final Creator<ResolveAccountResponse> CREATOR;
    IBinder DW;
    private ConnectionResult FH;
    private boolean Hw;
    final int j6;
    private boolean v5;

    static {
        CREATOR = new d();
    }

    ResolveAccountResponse(int i, IBinder iBinder, ConnectionResult connectionResult, boolean z, boolean z2) {
        this.j6 = i;
        this.DW = iBinder;
        this.FH = connectionResult;
        this.Hw = z;
        this.v5 = z2;
    }

    public ConnectionResult DW() {
        return this.FH;
    }

    public boolean FH() {
        return this.Hw;
    }

    public boolean Hw() {
        return this.v5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResolveAccountResponse)) {
            return false;
        }
        ResolveAccountResponse resolveAccountResponse = (ResolveAccountResponse) obj;
        return this.FH.equals(resolveAccountResponse.FH) && j6().equals(resolveAccountResponse.j6());
    }

    public v j6() {
        return a.j6(this.DW);
    }

    public void writeToParcel(Parcel parcel, int i) {
        d.j6(this, parcel, i);
    }
}
