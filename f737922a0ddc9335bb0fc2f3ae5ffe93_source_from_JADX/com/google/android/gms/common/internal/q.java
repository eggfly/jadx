package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class q implements Creator<GetServiceRequest> {
    static void j6(GetServiceRequest getServiceRequest, Parcel parcel, int i) {
        int j6 = b.j6(parcel);
        b.j6(parcel, 1, getServiceRequest.j6);
        b.j6(parcel, 2, getServiceRequest.DW);
        b.j6(parcel, 3, getServiceRequest.FH);
        b.j6(parcel, 4, getServiceRequest.Hw, false);
        b.j6(parcel, 5, getServiceRequest.v5, false);
        b.j6(parcel, 6, getServiceRequest.Zo, i, false);
        b.j6(parcel, 7, getServiceRequest.VH, false);
        b.j6(parcel, 8, getServiceRequest.gn, i, false);
        b.j6(parcel, 9, getServiceRequest.u7);
        b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public GetServiceRequest j6(Parcel parcel) {
        int i = 0;
        Account account = null;
        int DW = a.DW(parcel);
        long j = 0;
        Bundle bundle = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        String str = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < DW) {
            int j6 = a.j6(parcel);
            switch (a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    i3 = a.Hw(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    i2 = a.Hw(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    i = a.Hw(parcel, j6);
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    str = a.J8(parcel, j6);
                    break;
                case 5:
                    iBinder = a.Ws(parcel, j6);
                    break;
                case 6:
                    scopeArr = (Scope[]) a.DW(parcel, j6, Scope.CREATOR);
                    break;
                case 7:
                    bundle = a.QX(parcel, j6);
                    break;
                case 8:
                    account = (Account) a.j6(parcel, j6, Account.CREATOR);
                    break;
                case 9:
                    j = a.Zo(parcel, j6);
                    break;
                default:
                    a.DW(parcel, j6);
                    break;
            }
        }
        if (parcel.dataPosition() == DW) {
            return new GetServiceRequest(i3, i2, i, str, iBinder, scopeArr, bundle, account, j);
        }
        throw new a.a("Overread allowed size end=" + DW, parcel);
    }

    public GetServiceRequest[] j6(int i) {
        return new GetServiceRequest[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
