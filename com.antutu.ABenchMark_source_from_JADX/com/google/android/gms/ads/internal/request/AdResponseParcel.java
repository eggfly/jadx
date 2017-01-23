package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.p146b.gb;
import java.util.Collections;
import java.util.List;

@gb
public final class AdResponseParcel implements SafeParcelable {
    public static final C2932h CREATOR;
    public String f9877A;
    public boolean f9878B;
    public boolean f9879C;
    public RewardItemParcel f9880D;
    public List<String> f9881E;
    public List<String> f9882F;
    public boolean f9883G;
    private AdRequestInfoParcel f9884H;
    public final int f9885a;
    public final String f9886b;
    public String f9887c;
    public final List<String> f9888d;
    public final int f9889e;
    public final List<String> f9890f;
    public final long f9891g;
    public final boolean f9892h;
    public final long f9893i;
    public final List<String> f9894j;
    public final long f9895k;
    public final int f9896l;
    public final String f9897m;
    public final long f9898n;
    public final String f9899o;
    public final boolean f9900p;
    public final String f9901q;
    public final String f9902r;
    public final boolean f9903s;
    public final boolean f9904t;
    public final boolean f9905u;
    public final boolean f9906v;
    public final boolean f9907w;
    public final int f9908x;
    public LargeParcelTeleporter f9909y;
    public String f9910z;

    static {
        CREATOR = new C2932h();
    }

    public AdResponseParcel(int i) {
        this(16, null, null, null, i, null, -1, false, -1, null, -1, -1, null, -1, null, false, null, null, false, false, false, true, false, 0, null, null, null, false, false, null, null, null, false);
    }

    public AdResponseParcel(int i, long j) {
        this(16, null, null, null, i, null, -1, false, -1, null, j, -1, null, -1, null, false, null, null, false, false, false, true, false, 0, null, null, null, false, false, null, null, null, false);
    }

    AdResponseParcel(int i, String str, String str2, List<String> list, int i2, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i3, String str3, long j4, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i4, LargeParcelTeleporter largeParcelTeleporter, String str7, String str8, boolean z8, boolean z9, RewardItemParcel rewardItemParcel, List<String> list4, List<String> list5, boolean z10) {
        this.f9885a = i;
        this.f9886b = str;
        this.f9887c = str2;
        this.f9888d = list != null ? Collections.unmodifiableList(list) : null;
        this.f9889e = i2;
        this.f9890f = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.f9891g = j;
        this.f9892h = z;
        this.f9893i = j2;
        this.f9894j = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.f9895k = j3;
        this.f9896l = i3;
        this.f9897m = str3;
        this.f9898n = j4;
        this.f9899o = str4;
        this.f9900p = z2;
        this.f9901q = str5;
        this.f9902r = str6;
        this.f9903s = z3;
        this.f9904t = z4;
        this.f9905u = z5;
        this.f9906v = z6;
        this.f9907w = z7;
        this.f9908x = i4;
        this.f9909y = largeParcelTeleporter;
        this.f9910z = str7;
        this.f9877A = str8;
        if (this.f9887c == null && this.f9909y != null) {
            StringParcel stringParcel = (StringParcel) this.f9909y.m11300a(StringParcel.CREATOR);
            if (!(stringParcel == null || TextUtils.isEmpty(stringParcel.m11301a()))) {
                this.f9887c = stringParcel.m11301a();
            }
        }
        this.f9878B = z8;
        this.f9879C = z9;
        this.f9880D = rewardItemParcel;
        this.f9881E = list4;
        this.f9882F = list5;
        this.f9883G = z10;
    }

    public AdResponseParcel(AdRequestInfoParcel adRequestInfoParcel, String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, String str5, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i2, String str6, boolean z7, boolean z8, RewardItemParcel rewardItemParcel, List<String> list4, List<String> list5, boolean z9) {
        this(16, str, str2, list, -2, list2, j, z, j2, list3, j3, i, str3, j4, str4, false, null, str5, z2, z3, z4, z5, z6, i2, null, null, str6, z7, z8, rewardItemParcel, list4, list5, z9);
        this.f9884H = adRequestInfoParcel;
    }

    public AdResponseParcel(AdRequestInfoParcel adRequestInfoParcel, String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i2, String str7, boolean z8, boolean z9, RewardItemParcel rewardItemParcel, List<String> list4, List<String> list5, boolean z10) {
        this(16, str, str2, list, -2, list2, j, z, j2, list3, j3, i, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6, z7, i2, null, null, str7, z8, z9, rewardItemParcel, list4, list5, z10);
        this.f9884H = adRequestInfoParcel;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (!(this.f9884H == null || this.f9884H.f9851a < 9 || TextUtils.isEmpty(this.f9887c))) {
            this.f9909y = new LargeParcelTeleporter(new StringParcel(this.f9887c));
            this.f9887c = null;
        }
        C2932h.m11411a(this, parcel, i);
    }
}
