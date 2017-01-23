package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class j implements Creator<AuthAccountRequest> {
    static void j6(AuthAccountRequest authAccountRequest, Parcel parcel, int i) {
        int j6 = b.j6(parcel);
        b.j6(parcel, 1, authAccountRequest.j6);
        b.j6(parcel, 2, authAccountRequest.DW, false);
        b.j6(parcel, 3, authAccountRequest.FH, i, false);
        b.j6(parcel, 4, authAccountRequest.Hw, false);
        b.j6(parcel, 5, authAccountRequest.v5, false);
        b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public AuthAccountRequest j6(Parcel parcel) {
        Integer num = null;
        int DW = a.DW(parcel);
        int i = 0;
        Integer num2 = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        while (parcel.dataPosition() < DW) {
            int j6 = a.j6(parcel);
            switch (a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    i = a.Hw(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    iBinder = a.Ws(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    scopeArr = (Scope[]) a.DW(parcel, j6, Scope.CREATOR);
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    num2 = a.v5(parcel, j6);
                    break;
                case 5:
                    num = a.v5(parcel, j6);
                    break;
                default:
                    a.DW(parcel, j6);
                    break;
            }
        }
        if (parcel.dataPosition() == DW) {
            return new AuthAccountRequest(i, iBinder, scopeArr, num2, num);
        }
        throw new a.a("Overread allowed size end=" + DW, parcel);
    }

    public AuthAccountRequest[] j6(int i) {
        return new AuthAccountRequest[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
