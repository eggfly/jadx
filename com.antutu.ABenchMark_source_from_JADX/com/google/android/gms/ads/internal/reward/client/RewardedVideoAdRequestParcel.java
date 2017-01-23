package com.google.android.gms.ads.internal.reward.client;

import android.os.Parcel;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.p146b.gb;

@gb
public final class RewardedVideoAdRequestParcel implements SafeParcelable {
    public static final C2962g CREATOR;
    public final int f10003a;
    public final AdRequestParcel f10004b;
    public final String f10005c;

    static {
        CREATOR = new C2962g();
    }

    public RewardedVideoAdRequestParcel(int i, AdRequestParcel adRequestParcel, String str) {
        this.f10003a = i;
        this.f10004b = adRequestParcel;
        this.f10005c = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2962g.m11483a(this, parcel, i);
    }
}
