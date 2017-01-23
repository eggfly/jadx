package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.auth.b */
public class C3011b implements Creator<AccountChangeEventsRequest> {
    static void m11711a(AccountChangeEventsRequest accountChangeEventsRequest, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, accountChangeEventsRequest.f10112a);
        C3508b.m14557a(parcel, 2, accountChangeEventsRequest.f10113b);
        C3508b.m14565a(parcel, 3, accountChangeEventsRequest.f10114c, false);
        C3508b.m14562a(parcel, 4, accountChangeEventsRequest.f10115d, i, false);
        C3508b.m14555a(parcel, a);
    }

    public AccountChangeEventsRequest m11712a(Parcel parcel) {
        Account account = null;
        int i = 0;
        int b = C3507a.m14526b(parcel);
        String str = null;
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
                    str = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    account = (Account) C3507a.m14523a(parcel, a, Account.CREATOR);
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AccountChangeEventsRequest(i2, i, str, account);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public AccountChangeEventsRequest[] m11713a(int i) {
        return new AccountChangeEventsRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11712a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11713a(i);
    }
}
