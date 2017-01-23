package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.common.internal.c */
public class C3472c implements Creator<ValidateAccountRequest> {
    static void m14335a(ValidateAccountRequest validateAccountRequest, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, validateAccountRequest.f12045a);
        C3508b.m14557a(parcel, 2, validateAccountRequest.m14323a());
        C3508b.m14560a(parcel, 3, validateAccountRequest.f12046b, false);
        C3508b.m14570a(parcel, 4, validateAccountRequest.m14324b(), i, false);
        C3508b.m14559a(parcel, 5, validateAccountRequest.m14326d(), false);
        C3508b.m14565a(parcel, 6, validateAccountRequest.m14325c(), false);
        C3508b.m14555a(parcel, a);
    }

    public ValidateAccountRequest m14336a(Parcel parcel) {
        int i = 0;
        String str = null;
        int b = C3507a.m14526b(parcel);
        Bundle bundle = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C3507a.m14521a(parcel);
            switch (C3507a.m14520a(a)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    i2 = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    i = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    iBinder = C3507a.m14540m(parcel, a);
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    scopeArr = (Scope[]) C3507a.m14528b(parcel, a, Scope.CREATOR);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    bundle = C3507a.m14541n(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    str = C3507a.m14539l(parcel, a);
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ValidateAccountRequest(i2, i, iBinder, scopeArr, bundle, str);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public ValidateAccountRequest[] m14337a(int i) {
        return new ValidateAccountRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m14336a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m14337a(i);
    }
}
