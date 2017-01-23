package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.auth.firstparty.shared.a */
public class C3014a implements Creator<FACLConfig> {
    static void m11720a(FACLConfig fACLConfig, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, fACLConfig.f10181a);
        C3508b.m14567a(parcel, 2, fACLConfig.f10182b);
        C3508b.m14565a(parcel, 3, fACLConfig.f10183c, false);
        C3508b.m14567a(parcel, 4, fACLConfig.f10184d);
        C3508b.m14567a(parcel, 5, fACLConfig.f10185e);
        C3508b.m14567a(parcel, 6, fACLConfig.f10186f);
        C3508b.m14567a(parcel, 7, fACLConfig.f10187g);
        C3508b.m14555a(parcel, a);
    }

    public FACLConfig m11721a(Parcel parcel) {
        boolean z = false;
        int b = C3507a.m14526b(parcel);
        String str = null;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C3507a.m14521a(parcel);
            switch (C3507a.m14520a(a)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    i = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    z5 = C3507a.m14530c(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    str = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    z4 = C3507a.m14530c(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    z3 = C3507a.m14530c(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    z2 = C3507a.m14530c(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    z = C3507a.m14530c(parcel, a);
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new FACLConfig(i, z5, str, z4, z3, z2, z);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public FACLConfig[] m11722a(int i) {
        return new FACLConfig[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11721a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11722a(i);
    }
}
