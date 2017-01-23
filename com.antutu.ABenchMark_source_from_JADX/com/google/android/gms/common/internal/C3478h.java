package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.common.internal.h */
public class C3478h implements Creator<GetServiceRequest> {
    static void m14354a(GetServiceRequest getServiceRequest, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, getServiceRequest.f12028a);
        C3508b.m14557a(parcel, 2, getServiceRequest.f12029b);
        C3508b.m14557a(parcel, 3, getServiceRequest.f12030c);
        C3508b.m14565a(parcel, 4, getServiceRequest.f12031d, false);
        C3508b.m14560a(parcel, 5, getServiceRequest.f12032e, false);
        C3508b.m14570a(parcel, 6, getServiceRequest.f12033f, i, false);
        C3508b.m14559a(parcel, 7, getServiceRequest.f12034g, false);
        C3508b.m14562a(parcel, 8, getServiceRequest.f12035h, i, false);
        C3508b.m14555a(parcel, a);
    }

    public GetServiceRequest m14355a(Parcel parcel) {
        int i = 0;
        Account account = null;
        int b = C3507a.m14526b(parcel);
        Bundle bundle = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        String str = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = C3507a.m14521a(parcel);
            switch (C3507a.m14520a(a)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    i3 = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    i2 = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    i = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    str = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    iBinder = C3507a.m14540m(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    scopeArr = (Scope[]) C3507a.m14528b(parcel, a, Scope.CREATOR);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    bundle = C3507a.m14541n(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    account = (Account) C3507a.m14523a(parcel, a, Account.CREATOR);
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GetServiceRequest(i3, i2, i, str, iBinder, scopeArr, bundle, account);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public GetServiceRequest[] m14356a(int i) {
        return new GetServiceRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m14355a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m14356a(i);
    }
}
