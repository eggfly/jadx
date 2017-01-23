package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.common.internal.e */
public class C3474e implements Creator<AuthAccountRequest> {
    static void m14339a(AuthAccountRequest authAccountRequest, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, authAccountRequest.f12018a);
        C3508b.m14560a(parcel, 2, authAccountRequest.f12019b, false);
        C3508b.m14570a(parcel, 3, authAccountRequest.f12020c, i, false);
        C3508b.m14563a(parcel, 4, authAccountRequest.f12021d, false);
        C3508b.m14563a(parcel, 5, authAccountRequest.f12022e, false);
        C3508b.m14555a(parcel, a);
    }

    public AuthAccountRequest m14340a(Parcel parcel) {
        Integer num = null;
        int b = C3507a.m14526b(parcel);
        int i = 0;
        Integer num2 = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
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
                    scopeArr = (Scope[]) C3507a.m14528b(parcel, a, Scope.CREATOR);
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    num2 = C3507a.m14532e(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    num = C3507a.m14532e(parcel, a);
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AuthAccountRequest(i, iBinder, scopeArr, num2, num);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public AuthAccountRequest[] m14341a(int i) {
        return new AuthAccountRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m14340a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m14341a(i);
    }
}
