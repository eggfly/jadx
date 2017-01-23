package com.google.android.gms.ads.internal.reward.mediation.client;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.ads.p149d.C2718a;
import com.google.android.gms.common.internal.C3511t;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.p146b.gb;
import org.json.JSONArray;
import org.json.JSONException;

@gb
public final class RewardItemParcel implements SafeParcelable {
    public static final C2967c CREATOR;
    public final int f10011a;
    public final String f10012b;
    public final int f10013c;

    static {
        CREATOR = new C2967c();
    }

    public RewardItemParcel(int i, String str, int i2) {
        this.f10011a = i;
        this.f10012b = str;
        this.f10013c = i2;
    }

    public RewardItemParcel(C2718a c2718a) {
        this(1, c2718a.m10342a(), c2718a.m10343b());
    }

    public RewardItemParcel(String str, int i) {
        this(1, str, i);
    }

    public static RewardItemParcel m11486a(String str) {
        RewardItemParcel rewardItemParcel = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                rewardItemParcel = m11487a(new JSONArray(str));
            } catch (JSONException e) {
            }
        }
        return rewardItemParcel;
    }

    public static RewardItemParcel m11487a(JSONArray jSONArray) {
        return (jSONArray == null || jSONArray.length() == 0) ? null : new RewardItemParcel(jSONArray.getJSONObject(0).optString("rb_type"), jSONArray.getJSONObject(0).optInt("rb_amount"));
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof RewardItemParcel)) {
            return false;
        }
        RewardItemParcel rewardItemParcel = (RewardItemParcel) obj;
        return C3511t.m14579a(this.f10012b, rewardItemParcel.f10012b) && C3511t.m14579a(Integer.valueOf(this.f10013c), Integer.valueOf(rewardItemParcel.f10013c));
    }

    public int hashCode() {
        return C3511t.m14577a(this.f10012b, Integer.valueOf(this.f10013c));
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2967c.m11517a(this, parcel, i);
    }
}
