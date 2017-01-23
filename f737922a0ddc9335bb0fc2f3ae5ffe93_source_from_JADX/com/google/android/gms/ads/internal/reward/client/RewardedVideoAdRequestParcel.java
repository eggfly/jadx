package com.google.android.gms.ads.internal.reward.client;

import android.os.Parcel;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.eh;

@eh
public final class RewardedVideoAdRequestParcel extends AbstractSafeParcelable {
    public static final h CREATOR;
    public final AdRequestParcel DW;
    public final String FH;
    public final int j6;

    static {
        CREATOR = new h();
    }

    public RewardedVideoAdRequestParcel(int i, AdRequestParcel adRequestParcel, String str) {
        this.j6 = i;
        this.DW = adRequestParcel;
        this.FH = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.j6(this, parcel, i);
    }
}
