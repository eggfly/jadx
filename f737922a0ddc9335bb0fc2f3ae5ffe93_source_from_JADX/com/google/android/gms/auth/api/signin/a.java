package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class a implements Creator<GoogleSignInAccount> {
    static void j6(GoogleSignInAccount googleSignInAccount, Parcel parcel, int i) {
        int j6 = b.j6(parcel);
        b.j6(parcel, 1, googleSignInAccount.DW);
        b.j6(parcel, 2, googleSignInAccount.j6(), false);
        b.j6(parcel, 3, googleSignInAccount.DW(), false);
        b.j6(parcel, 4, googleSignInAccount.FH(), false);
        b.j6(parcel, 5, googleSignInAccount.Hw(), false);
        b.j6(parcel, 6, googleSignInAccount.VH(), i, false);
        b.j6(parcel, 7, googleSignInAccount.gn(), false);
        b.j6(parcel, 8, googleSignInAccount.u7());
        b.j6(parcel, 9, googleSignInAccount.tp(), false);
        b.DW(parcel, 10, googleSignInAccount.FH, false);
        b.j6(parcel, 11, googleSignInAccount.v5(), false);
        b.j6(parcel, 12, googleSignInAccount.Zo(), false);
        b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public GoogleSignInAccount j6(Parcel parcel) {
        int DW = com.google.android.gms.common.internal.safeparcel.a.DW(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        long j = 0;
        String str6 = null;
        List list = null;
        String str7 = null;
        String str8 = null;
        while (parcel.dataPosition() < DW) {
            int j6 = com.google.android.gms.common.internal.safeparcel.a.j6(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    i = com.google.android.gms.common.internal.safeparcel.a.Hw(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    str = com.google.android.gms.common.internal.safeparcel.a.J8(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    str2 = com.google.android.gms.common.internal.safeparcel.a.J8(parcel, j6);
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    str3 = com.google.android.gms.common.internal.safeparcel.a.J8(parcel, j6);
                    break;
                case 5:
                    str4 = com.google.android.gms.common.internal.safeparcel.a.J8(parcel, j6);
                    break;
                case 6:
                    uri = (Uri) com.google.android.gms.common.internal.safeparcel.a.j6(parcel, j6, Uri.CREATOR);
                    break;
                case 7:
                    str5 = com.google.android.gms.common.internal.safeparcel.a.J8(parcel, j6);
                    break;
                case 8:
                    j = com.google.android.gms.common.internal.safeparcel.a.Zo(parcel, j6);
                    break;
                case 9:
                    str6 = com.google.android.gms.common.internal.safeparcel.a.J8(parcel, j6);
                    break;
                case 10:
                    list = com.google.android.gms.common.internal.safeparcel.a.FH(parcel, j6, Scope.CREATOR);
                    break;
                case 11:
                    str7 = com.google.android.gms.common.internal.safeparcel.a.J8(parcel, j6);
                    break;
                case 12:
                    str8 = com.google.android.gms.common.internal.safeparcel.a.J8(parcel, j6);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.DW(parcel, j6);
                    break;
            }
        }
        if (parcel.dataPosition() == DW) {
            return new GoogleSignInAccount(i, str, str2, str3, str4, uri, str5, j, str6, list, str7, str8);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + DW, parcel);
    }

    public GoogleSignInAccount[] j6(int i) {
        return new GoogleSignInAccount[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
