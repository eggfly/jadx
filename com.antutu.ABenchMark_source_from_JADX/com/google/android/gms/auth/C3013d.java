package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import java.util.List;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.auth.d */
public class C3013d implements Creator<TokenData> {
    static void m11717a(TokenData tokenData, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, tokenData.f10118a);
        C3508b.m14565a(parcel, 2, tokenData.m11639a(), false);
        C3508b.m14564a(parcel, 3, tokenData.m11640b(), false);
        C3508b.m14567a(parcel, 4, tokenData.m11641c());
        C3508b.m14567a(parcel, 5, tokenData.m11642d());
        C3508b.m14566a(parcel, 6, tokenData.m11643e(), false);
        C3508b.m14555a(parcel, a);
    }

    public TokenData m11718a(Parcel parcel) {
        List list = null;
        boolean z = false;
        int b = C3507a.m14526b(parcel);
        boolean z2 = false;
        Long l = null;
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C3507a.m14521a(parcel);
            switch (C3507a.m14520a(a)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    i = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    str = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    l = C3507a.m14534g(parcel, a);
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    z2 = C3507a.m14530c(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    z = C3507a.m14530c(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    list = C3507a.m14551x(parcel, a);
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new TokenData(i, str, l, z2, z, list);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public TokenData[] m11719a(int i) {
        return new TokenData[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11718a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11719a(i);
    }
}
