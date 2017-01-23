package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccountChangeEventsRequest implements SafeParcelable {
    public static final Creator<AccountChangeEventsRequest> CREATOR;
    final int f10112a;
    int f10113b;
    @Deprecated
    String f10114c;
    Account f10115d;

    static {
        CREATOR = new C3011b();
    }

    public AccountChangeEventsRequest() {
        this.f10112a = 1;
    }

    AccountChangeEventsRequest(int i, int i2, String str, Account account) {
        this.f10112a = i;
        this.f10113b = i2;
        this.f10114c = str;
        if (account != null || TextUtils.isEmpty(str)) {
            this.f10115d = account;
        } else {
            this.f10115d = new Account(str, "com.google");
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C3011b.m11711a(this, parcel, i);
    }
}
