package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class d implements Creator<ResolveAccountResponse> {
    static void j6(ResolveAccountResponse resolveAccountResponse, Parcel parcel, int i) {
        int j6 = b.j6(parcel);
        b.j6(parcel, 1, resolveAccountResponse.j6);
        b.j6(parcel, 2, resolveAccountResponse.DW, false);
        b.j6(parcel, 3, resolveAccountResponse.DW(), i, false);
        b.j6(parcel, 4, resolveAccountResponse.FH());
        b.j6(parcel, 5, resolveAccountResponse.Hw());
        b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public ResolveAccountResponse j6(Parcel parcel) {
        ConnectionResult connectionResult = null;
        boolean z = false;
        int DW = a.DW(parcel);
        boolean z2 = false;
        IBinder iBinder = null;
        int i = 0;
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
                    connectionResult = (ConnectionResult) a.j6(parcel, j6, ConnectionResult.CREATOR);
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    z2 = a.FH(parcel, j6);
                    break;
                case 5:
                    z = a.FH(parcel, j6);
                    break;
                default:
                    a.DW(parcel, j6);
                    break;
            }
        }
        if (parcel.dataPosition() == DW) {
            return new ResolveAccountResponse(i, iBinder, connectionResult, z2, z);
        }
        throw new a.a("Overread allowed size end=" + DW, parcel);
    }

    public ResolveAccountResponse[] j6(int i) {
        return new ResolveAccountResponse[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
