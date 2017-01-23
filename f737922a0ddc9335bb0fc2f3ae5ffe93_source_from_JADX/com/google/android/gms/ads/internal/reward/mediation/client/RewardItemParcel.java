package com.google.android.gms.ads.internal.reward.mediation.client;

import afe;
import android.os.Parcel;
import com.google.android.gms.common.internal.ae;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.eh;

@eh
public final class RewardItemParcel extends AbstractSafeParcelable {
    public static final c CREATOR;
    public final String DW;
    public final int FH;
    public final int j6;

    static {
        CREATOR = new c();
    }

    public RewardItemParcel(int i, String str, int i2) {
        this.j6 = i;
        this.DW = str;
        this.FH = i2;
    }

    public RewardItemParcel(afe afe) {
        this(1, afe.j6(), afe.DW());
    }

    public RewardItemParcel(String str, int i) {
        this(1, str, i);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof RewardItemParcel)) {
            return false;
        }
        RewardItemParcel rewardItemParcel = (RewardItemParcel) obj;
        return ae.j6(this.DW, rewardItemParcel.DW) && ae.j6(Integer.valueOf(this.FH), Integer.valueOf(rewardItemParcel.FH));
    }

    public int hashCode() {
        return ae.j6(this.DW, Integer.valueOf(this.FH));
    }

    public void writeToParcel(Parcel parcel, int i) {
        c.j6(this, parcel, i);
    }
}
