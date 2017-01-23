package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class e implements Creator<RecordConsentRequest> {
    static void j6(RecordConsentRequest recordConsentRequest, Parcel parcel, int i) {
        int j6 = b.j6(parcel);
        b.j6(parcel, 1, recordConsentRequest.j6);
        b.j6(parcel, 2, recordConsentRequest.j6(), i, false);
        b.j6(parcel, 3, recordConsentRequest.DW(), i, false);
        b.j6(parcel, 4, recordConsentRequest.FH(), false);
        b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public RecordConsentRequest j6(Parcel parcel) {
        String str = null;
        int DW = a.DW(parcel);
        int i = 0;
        Scope[] scopeArr = null;
        Account account = null;
        while (parcel.dataPosition() < DW) {
            Scope[] scopeArr2;
            Account account2;
            int Hw;
            String str2;
            int j6 = a.j6(parcel);
            String str3;
            switch (a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    str3 = str;
                    scopeArr2 = scopeArr;
                    account2 = account;
                    Hw = a.Hw(parcel, j6);
                    str2 = str3;
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    Hw = i;
                    Scope[] scopeArr3 = scopeArr;
                    account2 = (Account) a.j6(parcel, j6, Account.CREATOR);
                    str2 = str;
                    scopeArr2 = scopeArr3;
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    account2 = account;
                    Hw = i;
                    str3 = str;
                    scopeArr2 = (Scope[]) a.DW(parcel, j6, Scope.CREATOR);
                    str2 = str3;
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    str2 = a.J8(parcel, j6);
                    scopeArr2 = scopeArr;
                    account2 = account;
                    Hw = i;
                    break;
                default:
                    a.DW(parcel, j6);
                    str2 = str;
                    scopeArr2 = scopeArr;
                    account2 = account;
                    Hw = i;
                    break;
            }
            i = Hw;
            account = account2;
            scopeArr = scopeArr2;
            str = str2;
        }
        if (parcel.dataPosition() == DW) {
            return new RecordConsentRequest(i, account, scopeArr, str);
        }
        throw new a.a("Overread allowed size end=" + DW, parcel);
    }

    public RecordConsentRequest[] j6(int i) {
        return new RecordConsentRequest[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
