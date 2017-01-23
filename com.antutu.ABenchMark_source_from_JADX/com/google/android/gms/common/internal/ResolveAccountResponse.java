package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.C3468n.C3469a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ResolveAccountResponse implements SafeParcelable {
    public static final Creator<ResolveAccountResponse> CREATOR;
    final int f12040a;
    IBinder f12041b;
    private ConnectionResult f12042c;
    private boolean f12043d;
    private boolean f12044e;

    static {
        CREATOR = new C3514w();
    }

    ResolveAccountResponse(int i, IBinder iBinder, ConnectionResult connectionResult, boolean z, boolean z2) {
        this.f12040a = i;
        this.f12041b = iBinder;
        this.f12042c = connectionResult;
        this.f12043d = z;
        this.f12044e = z2;
    }

    public C3468n m14319a() {
        return C3469a.m14328a(this.f12041b);
    }

    public ConnectionResult m14320b() {
        return this.f12042c;
    }

    public boolean m14321c() {
        return this.f12043d;
    }

    public boolean m14322d() {
        return this.f12044e;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResolveAccountResponse)) {
            return false;
        }
        ResolveAccountResponse resolveAccountResponse = (ResolveAccountResponse) obj;
        return this.f12042c.equals(resolveAccountResponse.f12042c) && m14319a().equals(resolveAccountResponse.m14319a());
    }

    public void writeToParcel(Parcel parcel, int i) {
        C3514w.m14594a(this, parcel, i);
    }
}
