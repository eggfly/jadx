package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.C3511t;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.p146b.gb;
import java.util.List;

@gb
public final class AdRequestParcel implements SafeParcelable {
    public static final C2778p CREATOR;
    public final int f9307a;
    public final long f9308b;
    public final Bundle f9309c;
    public final int f9310d;
    public final List<String> f9311e;
    public final boolean f9312f;
    public final int f9313g;
    public final boolean f9314h;
    public final String f9315i;
    public final SearchAdRequestParcel f9316j;
    public final Location f9317k;
    public final String f9318l;
    public final Bundle f9319m;
    public final Bundle f9320n;
    public final List<String> f9321o;
    public final String f9322p;
    public final String f9323q;
    public final boolean f9324r;

    static {
        CREATOR = new C2778p();
    }

    public AdRequestParcel(int i, long j, Bundle bundle, int i2, List<String> list, boolean z, int i3, boolean z2, String str, SearchAdRequestParcel searchAdRequestParcel, Location location, String str2, Bundle bundle2, Bundle bundle3, List<String> list2, String str3, String str4, boolean z3) {
        this.f9307a = i;
        this.f9308b = j;
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.f9309c = bundle;
        this.f9310d = i2;
        this.f9311e = list;
        this.f9312f = z;
        this.f9313g = i3;
        this.f9314h = z2;
        this.f9315i = str;
        this.f9316j = searchAdRequestParcel;
        this.f9317k = location;
        this.f9318l = str2;
        this.f9319m = bundle2;
        this.f9320n = bundle3;
        this.f9321o = list2;
        this.f9322p = str3;
        this.f9323q = str4;
        this.f9324r = z3;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AdRequestParcel)) {
            return false;
        }
        AdRequestParcel adRequestParcel = (AdRequestParcel) obj;
        return this.f9307a == adRequestParcel.f9307a && this.f9308b == adRequestParcel.f9308b && C3511t.m14579a(this.f9309c, adRequestParcel.f9309c) && this.f9310d == adRequestParcel.f9310d && C3511t.m14579a(this.f9311e, adRequestParcel.f9311e) && this.f9312f == adRequestParcel.f9312f && this.f9313g == adRequestParcel.f9313g && this.f9314h == adRequestParcel.f9314h && C3511t.m14579a(this.f9315i, adRequestParcel.f9315i) && C3511t.m14579a(this.f9316j, adRequestParcel.f9316j) && C3511t.m14579a(this.f9317k, adRequestParcel.f9317k) && C3511t.m14579a(this.f9318l, adRequestParcel.f9318l) && C3511t.m14579a(this.f9319m, adRequestParcel.f9319m) && C3511t.m14579a(this.f9320n, adRequestParcel.f9320n) && C3511t.m14579a(this.f9321o, adRequestParcel.f9321o) && C3511t.m14579a(this.f9322p, adRequestParcel.f9322p) && C3511t.m14579a(this.f9323q, adRequestParcel.f9323q) && this.f9324r == adRequestParcel.f9324r;
    }

    public int hashCode() {
        return C3511t.m14577a(Integer.valueOf(this.f9307a), Long.valueOf(this.f9308b), this.f9309c, Integer.valueOf(this.f9310d), this.f9311e, Boolean.valueOf(this.f9312f), Integer.valueOf(this.f9313g), Boolean.valueOf(this.f9314h), this.f9315i, this.f9316j, this.f9317k, this.f9318l, this.f9319m, this.f9320n, this.f9321o, this.f9322p, this.f9323q, Boolean.valueOf(this.f9324r));
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2778p.m10723a(this, parcel, i);
    }
}
