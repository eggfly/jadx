package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.signin.internal.j */
public class C3556j implements Creator<SignInResponse> {
    static void m14813a(SignInResponse signInResponse, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, signInResponse.f12258a);
        C3508b.m14562a(parcel, 2, signInResponse.m14761a(), i, false);
        C3508b.m14562a(parcel, 3, signInResponse.m14762b(), i, false);
        C3508b.m14555a(parcel, a);
    }

    public SignInResponse m14814a(Parcel parcel) {
        ResolveAccountResponse resolveAccountResponse = null;
        int b = C3507a.m14526b(parcel);
        int i = 0;
        ConnectionResult connectionResult = null;
        while (parcel.dataPosition() < b) {
            ConnectionResult connectionResult2;
            int d;
            ResolveAccountResponse resolveAccountResponse2;
            int a = C3507a.m14521a(parcel);
            switch (C3507a.m14520a(a)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    ResolveAccountResponse resolveAccountResponse3 = resolveAccountResponse;
                    connectionResult2 = connectionResult;
                    d = C3507a.m14531d(parcel, a);
                    resolveAccountResponse2 = resolveAccountResponse3;
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    d = i;
                    ConnectionResult connectionResult3 = (ConnectionResult) C3507a.m14523a(parcel, a, ConnectionResult.CREATOR);
                    resolveAccountResponse2 = resolveAccountResponse;
                    connectionResult2 = connectionResult3;
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    resolveAccountResponse2 = (ResolveAccountResponse) C3507a.m14523a(parcel, a, ResolveAccountResponse.CREATOR);
                    connectionResult2 = connectionResult;
                    d = i;
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    resolveAccountResponse2 = resolveAccountResponse;
                    connectionResult2 = connectionResult;
                    d = i;
                    break;
            }
            i = d;
            connectionResult = connectionResult2;
            resolveAccountResponse = resolveAccountResponse2;
        }
        if (parcel.dataPosition() == b) {
            return new SignInResponse(i, connectionResult, resolveAccountResponse);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public SignInResponse[] m14815a(int i) {
        return new SignInResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m14814a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m14815a(i);
    }
}
