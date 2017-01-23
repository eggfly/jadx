package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class h implements Creator<SignInResponse> {
    static void j6(SignInResponse signInResponse, Parcel parcel, int i) {
        int j6 = b.j6(parcel);
        b.j6(parcel, 1, signInResponse.j6);
        b.j6(parcel, 2, signInResponse.j6(), i, false);
        b.j6(parcel, 3, signInResponse.DW(), i, false);
        b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public SignInResponse j6(Parcel parcel) {
        ResolveAccountResponse resolveAccountResponse = null;
        int DW = a.DW(parcel);
        int i = 0;
        ConnectionResult connectionResult = null;
        while (parcel.dataPosition() < DW) {
            ConnectionResult connectionResult2;
            int Hw;
            ResolveAccountResponse resolveAccountResponse2;
            int j6 = a.j6(parcel);
            switch (a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    ResolveAccountResponse resolveAccountResponse3 = resolveAccountResponse;
                    connectionResult2 = connectionResult;
                    Hw = a.Hw(parcel, j6);
                    resolveAccountResponse2 = resolveAccountResponse3;
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    Hw = i;
                    ConnectionResult connectionResult3 = (ConnectionResult) a.j6(parcel, j6, ConnectionResult.CREATOR);
                    resolveAccountResponse2 = resolveAccountResponse;
                    connectionResult2 = connectionResult3;
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    resolveAccountResponse2 = (ResolveAccountResponse) a.j6(parcel, j6, ResolveAccountResponse.CREATOR);
                    connectionResult2 = connectionResult;
                    Hw = i;
                    break;
                default:
                    a.DW(parcel, j6);
                    resolveAccountResponse2 = resolveAccountResponse;
                    connectionResult2 = connectionResult;
                    Hw = i;
                    break;
            }
            i = Hw;
            connectionResult = connectionResult2;
            resolveAccountResponse = resolveAccountResponse2;
        }
        if (parcel.dataPosition() == DW) {
            return new SignInResponse(i, connectionResult, resolveAccountResponse);
        }
        throw new a.a("Overread allowed size end=" + DW, parcel);
    }

    public SignInResponse[] j6(int i) {
        return new SignInResponse[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
