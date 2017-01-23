package com.google.android.gms.ads.internal.reward.mediation.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.ads.internal.reward.mediation.client.c */
public class C2967c implements Creator<RewardItemParcel> {
    static void m11517a(RewardItemParcel rewardItemParcel, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, rewardItemParcel.f10011a);
        C3508b.m14565a(parcel, 2, rewardItemParcel.f10012b, false);
        C3508b.m14557a(parcel, 3, rewardItemParcel.f10013c);
        C3508b.m14555a(parcel, a);
    }

    public RewardItemParcel m11518a(Parcel parcel) {
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
                    str = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    i = C3507a.m14531d(parcel, a);
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new RewardItemParcel(i2, str, i);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public RewardItemParcel[] m11519a(int i) {
        return new RewardItemParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11518a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11519a(i);
    }
}
