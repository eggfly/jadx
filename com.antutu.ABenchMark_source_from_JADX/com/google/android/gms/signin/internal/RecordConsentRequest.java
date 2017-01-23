package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class RecordConsentRequest implements SafeParcelable {
    public static final Creator<RecordConsentRequest> CREATOR;
    final int f12252a;
    private final Account f12253b;
    private final Scope[] f12254c;
    private final String f12255d;

    static {
        CREATOR = new C3552f();
    }

    RecordConsentRequest(int i, Account account, Scope[] scopeArr, String str) {
        this.f12252a = i;
        this.f12253b = account;
        this.f12254c = scopeArr;
        this.f12255d = str;
    }

    public Account m14757a() {
        return this.f12253b;
    }

    public Scope[] m14758b() {
        return this.f12254c;
    }

    public String m14759c() {
        return this.f12255d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C3552f.m14795a(this, parcel, i);
    }
}
