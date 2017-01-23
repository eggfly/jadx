package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.common.internal.w */
public class C3514w implements Creator<ResolveAccountResponse> {
    static void m14594a(ResolveAccountResponse resolveAccountResponse, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, resolveAccountResponse.f12040a);
        C3508b.m14560a(parcel, 2, resolveAccountResponse.f12041b, false);
        C3508b.m14562a(parcel, 3, resolveAccountResponse.m14320b(), i, false);
        C3508b.m14567a(parcel, 4, resolveAccountResponse.m14321c());
        C3508b.m14567a(parcel, 5, resolveAccountResponse.m14322d());
        C3508b.m14555a(parcel, a);
    }

    public ResolveAccountResponse m14595a(Parcel parcel) {
        ConnectionResult connectionResult = null;
        boolean z = false;
        int b = C3507a.m14526b(parcel);
        boolean z2 = false;
        IBinder iBinder = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C3507a.m14521a(parcel);
            switch (C3507a.m14520a(a)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    i = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    iBinder = C3507a.m14540m(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    connectionResult = (ConnectionResult) C3507a.m14523a(parcel, a, ConnectionResult.CREATOR);
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    z2 = C3507a.m14530c(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    z = C3507a.m14530c(parcel, a);
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ResolveAccountResponse(i, iBinder, connectionResult, z2, z);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public ResolveAccountResponse[] m14596a(int i) {
        return new ResolveAccountResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m14595a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m14596a(i);
    }
}
