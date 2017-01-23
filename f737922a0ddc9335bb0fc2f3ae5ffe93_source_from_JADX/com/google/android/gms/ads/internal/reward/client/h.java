package com.google.android.gms.ads.internal.reward.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class h implements Creator<RewardedVideoAdRequestParcel> {
    static void j6(RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel, Parcel parcel, int i) {
        int j6 = b.j6(parcel);
        b.j6(parcel, 1, rewardedVideoAdRequestParcel.j6);
        b.j6(parcel, 2, rewardedVideoAdRequestParcel.DW, i, false);
        b.j6(parcel, 3, rewardedVideoAdRequestParcel.FH, false);
        b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public RewardedVideoAdRequestParcel j6(Parcel parcel) {
        String str = null;
        int DW = a.DW(parcel);
        int i = 0;
        AdRequestParcel adRequestParcel = null;
        while (parcel.dataPosition() < DW) {
            AdRequestParcel adRequestParcel2;
            int Hw;
            String str2;
            int j6 = a.j6(parcel);
            switch (a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    String str3 = str;
                    adRequestParcel2 = adRequestParcel;
                    Hw = a.Hw(parcel, j6);
                    str2 = str3;
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    Hw = i;
                    AdRequestParcel adRequestParcel3 = (AdRequestParcel) a.j6(parcel, j6, AdRequestParcel.CREATOR);
                    str2 = str;
                    adRequestParcel2 = adRequestParcel3;
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    str2 = a.J8(parcel, j6);
                    adRequestParcel2 = adRequestParcel;
                    Hw = i;
                    break;
                default:
                    a.DW(parcel, j6);
                    str2 = str;
                    adRequestParcel2 = adRequestParcel;
                    Hw = i;
                    break;
            }
            i = Hw;
            adRequestParcel = adRequestParcel2;
            str = str2;
        }
        if (parcel.dataPosition() == DW) {
            return new RewardedVideoAdRequestParcel(i, adRequestParcel, str);
        }
        throw new a.a("Overread allowed size end=" + DW, parcel);
    }

    public RewardedVideoAdRequestParcel[] j6(int i) {
        return new RewardedVideoAdRequestParcel[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
