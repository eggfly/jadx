package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.auth.firstparty.shared.b */
public class C3015b implements Creator<FACLData> {
    static void m11723a(FACLData fACLData, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, fACLData.f10188a);
        C3508b.m14562a(parcel, 2, fACLData.f10189b, i, false);
        C3508b.m14565a(parcel, 3, fACLData.f10190c, false);
        C3508b.m14567a(parcel, 4, fACLData.f10191d);
        C3508b.m14565a(parcel, 5, fACLData.f10192e, false);
        C3508b.m14555a(parcel, a);
    }

    public FACLData m11724a(Parcel parcel) {
        boolean z = false;
        String str = null;
        int b = C3507a.m14526b(parcel);
        String str2 = null;
        FACLConfig fACLConfig = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C3507a.m14521a(parcel);
            switch (C3507a.m14520a(a)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    i = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    fACLConfig = (FACLConfig) C3507a.m14523a(parcel, a, FACLConfig.CREATOR);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    str2 = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    z = C3507a.m14530c(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    str = C3507a.m14539l(parcel, a);
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new FACLData(i, fACLConfig, str2, z, str);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public FACLData[] m11725a(int i) {
        return new FACLData[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11724a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11725a(i);
    }
}
