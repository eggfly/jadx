package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.C3457f;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C3468n.C3469a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collection;

public class GetServiceRequest implements SafeParcelable {
    public static final Creator<GetServiceRequest> CREATOR;
    final int f12028a;
    final int f12029b;
    int f12030c;
    String f12031d;
    IBinder f12032e;
    Scope[] f12033f;
    Bundle f12034g;
    Account f12035h;

    static {
        CREATOR = new C3478h();
    }

    public GetServiceRequest(int i) {
        this.f12028a = 2;
        this.f12030c = C3457f.f12001a;
        this.f12029b = i;
    }

    GetServiceRequest(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account) {
        this.f12028a = i;
        this.f12029b = i2;
        this.f12030c = i3;
        this.f12031d = str;
        if (i < 2) {
            this.f12035h = m14310a(iBinder);
        } else {
            this.f12032e = iBinder;
            this.f12035h = account;
        }
        this.f12033f = scopeArr;
        this.f12034g = bundle;
    }

    private Account m14310a(IBinder iBinder) {
        return iBinder != null ? C3470a.m14329a(C3469a.m14328a(iBinder)) : null;
    }

    public GetServiceRequest m14311a(Account account) {
        this.f12035h = account;
        return this;
    }

    public GetServiceRequest m14312a(Bundle bundle) {
        this.f12034g = bundle;
        return this;
    }

    public GetServiceRequest m14313a(C3468n c3468n) {
        if (c3468n != null) {
            this.f12032e = c3468n.asBinder();
        }
        return this;
    }

    public GetServiceRequest m14314a(String str) {
        this.f12031d = str;
        return this;
    }

    public GetServiceRequest m14315a(Collection<Scope> collection) {
        this.f12033f = (Scope[]) collection.toArray(new Scope[collection.size()]);
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C3478h.m14354a(this, parcel, i);
    }
}
