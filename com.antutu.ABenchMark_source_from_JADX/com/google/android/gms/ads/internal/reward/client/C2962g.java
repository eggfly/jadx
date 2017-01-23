package com.google.android.gms.ads.internal.reward.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.ads.internal.reward.client.g */
public class C2962g implements Creator<RewardedVideoAdRequestParcel> {
    static void m11483a(RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, rewardedVideoAdRequestParcel.f10003a);
        C3508b.m14562a(parcel, 2, rewardedVideoAdRequestParcel.f10004b, i, false);
        C3508b.m14565a(parcel, 3, rewardedVideoAdRequestParcel.f10005c, false);
        C3508b.m14555a(parcel, a);
    }

    public RewardedVideoAdRequestParcel m11484a(Parcel parcel) {
        String str = null;
        int b = C3507a.m14526b(parcel);
        int i = 0;
        AdRequestParcel adRequestParcel = null;
        while (parcel.dataPosition() < b) {
            AdRequestParcel adRequestParcel2;
            int d;
            String str2;
            int a = C3507a.m14521a(parcel);
            switch (C3507a.m14520a(a)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    String str3 = str;
                    adRequestParcel2 = adRequestParcel;
                    d = C3507a.m14531d(parcel, a);
                    str2 = str3;
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    d = i;
                    AdRequestParcel adRequestParcel3 = (AdRequestParcel) C3507a.m14523a(parcel, a, AdRequestParcel.CREATOR);
                    str2 = str;
                    adRequestParcel2 = adRequestParcel3;
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    str2 = C3507a.m14539l(parcel, a);
                    adRequestParcel2 = adRequestParcel;
                    d = i;
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    str2 = str;
                    adRequestParcel2 = adRequestParcel;
                    d = i;
                    break;
            }
            i = d;
            adRequestParcel = adRequestParcel2;
            str = str2;
        }
        if (parcel.dataPosition() == b) {
            return new RewardedVideoAdRequestParcel(i, adRequestParcel, str);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public RewardedVideoAdRequestParcel[] m11485a(int i) {
        return new RewardedVideoAdRequestParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11484a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11485a(i);
    }
}
