package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.auth.a */
public class C2996a implements Creator<AccountChangeEvent> {
    static void m11644a(AccountChangeEvent accountChangeEvent, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, accountChangeEvent.f10106a);
        C3508b.m14558a(parcel, 2, accountChangeEvent.f10107b);
        C3508b.m14565a(parcel, 3, accountChangeEvent.f10108c, false);
        C3508b.m14557a(parcel, 4, accountChangeEvent.f10109d);
        C3508b.m14557a(parcel, 5, accountChangeEvent.f10110e);
        C3508b.m14565a(parcel, 6, accountChangeEvent.f10111f, false);
        C3508b.m14555a(parcel, a);
    }

    public AccountChangeEvent m11645a(Parcel parcel) {
        String str = null;
        int i = 0;
        int b = C3507a.m14526b(parcel);
        long j = 0;
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = C3507a.m14521a(parcel);
            switch (C3507a.m14520a(a)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    i3 = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    j = C3507a.m14533f(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    str2 = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    i2 = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    i = C3507a.m14531d(parcel, a);
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
            return new AccountChangeEvent(i3, j, str2, i2, i, str);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public AccountChangeEvent[] m11646a(int i) {
        return new AccountChangeEvent[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11645a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11646a(i);
    }
}
