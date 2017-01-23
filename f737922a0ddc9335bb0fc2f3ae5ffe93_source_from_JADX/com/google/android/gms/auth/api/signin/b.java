package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.ArrayList;

public class b implements Creator<GoogleSignInOptions> {
    static void j6(GoogleSignInOptions googleSignInOptions, Parcel parcel, int i) {
        int j6 = com.google.android.gms.common.internal.safeparcel.b.j6(parcel);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 1, googleSignInOptions.v5);
        com.google.android.gms.common.internal.safeparcel.b.DW(parcel, 2, googleSignInOptions.j6(), false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 3, googleSignInOptions.DW(), i, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 4, googleSignInOptions.FH());
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 5, googleSignInOptions.Hw());
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 6, googleSignInOptions.v5());
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 7, googleSignInOptions.Zo(), false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 8, googleSignInOptions.VH(), false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public GoogleSignInOptions j6(Parcel parcel) {
        String str = null;
        boolean z = false;
        int DW = a.DW(parcel);
        String str2 = null;
        boolean z2 = false;
        boolean z3 = false;
        Account account = null;
        ArrayList arrayList = null;
        int i = 0;
        while (parcel.dataPosition() < DW) {
            int j6 = a.j6(parcel);
            switch (a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    i = a.Hw(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    arrayList = a.FH(parcel, j6, Scope.CREATOR);
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    account = (Account) a.j6(parcel, j6, Account.CREATOR);
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    z3 = a.FH(parcel, j6);
                    break;
                case 5:
                    z2 = a.FH(parcel, j6);
                    break;
                case 6:
                    z = a.FH(parcel, j6);
                    break;
                case 7:
                    str2 = a.J8(parcel, j6);
                    break;
                case 8:
                    str = a.J8(parcel, j6);
                    break;
                default:
                    a.DW(parcel, j6);
                    break;
            }
        }
        if (parcel.dataPosition() == DW) {
            return new GoogleSignInOptions(i, arrayList, account, z3, z2, z, str2, str);
        }
        throw new a.a("Overread allowed size end=" + DW, parcel);
    }

    public GoogleSignInOptions[] j6(int i) {
        return new GoogleSignInOptions[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
