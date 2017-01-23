package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c implements Creator<ResolveAccountRequest> {
    static void j6(ResolveAccountRequest resolveAccountRequest, Parcel parcel, int i) {
        int j6 = b.j6(parcel);
        b.j6(parcel, 1, resolveAccountRequest.j6);
        b.j6(parcel, 2, resolveAccountRequest.j6(), i, false);
        b.j6(parcel, 3, resolveAccountRequest.DW());
        b.j6(parcel, 4, resolveAccountRequest.FH(), i, false);
        b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public ResolveAccountRequest j6(Parcel parcel) {
        GoogleSignInAccount googleSignInAccount = null;
        int i = 0;
        int DW = a.DW(parcel);
        Account account = null;
        int i2 = 0;
        while (parcel.dataPosition() < DW) {
            int i3;
            Account account2;
            int Hw;
            GoogleSignInAccount googleSignInAccount2;
            int j6 = a.j6(parcel);
            GoogleSignInAccount googleSignInAccount3;
            switch (a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    googleSignInAccount3 = googleSignInAccount;
                    i3 = i;
                    account2 = account;
                    Hw = a.Hw(parcel, j6);
                    googleSignInAccount2 = googleSignInAccount3;
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    Hw = i2;
                    int i4 = i;
                    account2 = (Account) a.j6(parcel, j6, Account.CREATOR);
                    googleSignInAccount2 = googleSignInAccount;
                    i3 = i4;
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    account2 = account;
                    Hw = i2;
                    googleSignInAccount3 = googleSignInAccount;
                    i3 = a.Hw(parcel, j6);
                    googleSignInAccount2 = googleSignInAccount3;
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    googleSignInAccount2 = (GoogleSignInAccount) a.j6(parcel, j6, GoogleSignInAccount.CREATOR);
                    i3 = i;
                    account2 = account;
                    Hw = i2;
                    break;
                default:
                    a.DW(parcel, j6);
                    googleSignInAccount2 = googleSignInAccount;
                    i3 = i;
                    account2 = account;
                    Hw = i2;
                    break;
            }
            i2 = Hw;
            account = account2;
            i = i3;
            googleSignInAccount = googleSignInAccount2;
        }
        if (parcel.dataPosition() == DW) {
            return new ResolveAccountRequest(i2, account, i, googleSignInAccount);
        }
        throw new a.a("Overread allowed size end=" + DW, parcel);
    }

    public ResolveAccountRequest[] j6(int i) {
        return new ResolveAccountRequest[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
