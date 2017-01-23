package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class RecordConsentRequest extends AbstractSafeParcelable {
    public static final Creator<RecordConsentRequest> CREATOR;
    private final Account DW;
    private final Scope[] FH;
    private final String Hw;
    final int j6;

    static {
        CREATOR = new e();
    }

    RecordConsentRequest(int i, Account account, Scope[] scopeArr, String str) {
        this.j6 = i;
        this.DW = account;
        this.FH = scopeArr;
        this.Hw = str;
    }

    public Scope[] DW() {
        return this.FH;
    }

    public String FH() {
        return this.Hw;
    }

    public Account j6() {
        return this.DW;
    }

    public void writeToParcel(Parcel parcel, int i) {
        e.j6(this, parcel, i);
    }
}
