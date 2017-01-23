package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class h implements Creator<ValidateAccountRequest> {
    static void j6(ValidateAccountRequest validateAccountRequest, Parcel parcel, int i) {
        int j6 = b.j6(parcel);
        b.j6(parcel, 1, validateAccountRequest.j6);
        b.j6(parcel, 2, validateAccountRequest.j6());
        b.j6(parcel, 3, validateAccountRequest.DW, false);
        b.j6(parcel, 4, validateAccountRequest.DW(), i, false);
        b.j6(parcel, 5, validateAccountRequest.Hw(), false);
        b.j6(parcel, 6, validateAccountRequest.FH(), false);
        b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public ValidateAccountRequest j6(Parcel parcel) {
        int i = 0;
        String str = null;
        int DW = a.DW(parcel);
        Bundle bundle = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        int i2 = 0;
        while (parcel.dataPosition() < DW) {
            int j6 = a.j6(parcel);
            switch (a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    i2 = a.Hw(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    i = a.Hw(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    iBinder = a.Ws(parcel, j6);
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    scopeArr = (Scope[]) a.DW(parcel, j6, Scope.CREATOR);
                    break;
                case 5:
                    bundle = a.QX(parcel, j6);
                    break;
                case 6:
                    str = a.J8(parcel, j6);
                    break;
                default:
                    a.DW(parcel, j6);
                    break;
            }
        }
        if (parcel.dataPosition() == DW) {
            return new ValidateAccountRequest(i2, i, iBinder, scopeArr, bundle, str);
        }
        throw new a.a("Overread allowed size end=" + DW, parcel);
    }

    public ValidateAccountRequest[] j6(int i) {
        return new ValidateAccountRequest[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
