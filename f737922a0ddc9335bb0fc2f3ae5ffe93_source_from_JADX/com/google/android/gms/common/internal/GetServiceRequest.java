package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.i;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.v.a;
import java.util.Collection;

public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Creator<GetServiceRequest> CREATOR;
    final int DW;
    int FH;
    String Hw;
    Bundle VH;
    Scope[] Zo;
    Account gn;
    final int j6;
    long u7;
    IBinder v5;

    static {
        CREATOR = new q();
    }

    public GetServiceRequest(int i) {
        this.j6 = 3;
        this.FH = i.DW;
        this.DW = i;
    }

    GetServiceRequest(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, long j) {
        this.j6 = i;
        this.DW = i2;
        this.FH = i3;
        this.Hw = str;
        if (i < 2) {
            this.gn = j6(iBinder);
        } else {
            this.v5 = iBinder;
            this.gn = account;
        }
        this.Zo = scopeArr;
        this.VH = bundle;
        this.u7 = j;
    }

    private Account j6(IBinder iBinder) {
        return iBinder != null ? a.j6(a.j6(iBinder)) : null;
    }

    public GetServiceRequest j6(Account account) {
        this.gn = account;
        return this;
    }

    public GetServiceRequest j6(Bundle bundle) {
        this.VH = bundle;
        return this;
    }

    public GetServiceRequest j6(v vVar) {
        if (vVar != null) {
            this.v5 = vVar.asBinder();
        }
        return this;
    }

    public GetServiceRequest j6(String str) {
        this.Hw = str;
        return this;
    }

    public GetServiceRequest j6(Collection<Scope> collection) {
        this.Zo = (Scope[]) collection.toArray(new Scope[collection.size()]);
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        q.j6(this, parcel, i);
    }
}
