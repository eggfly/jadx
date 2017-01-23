package com.google.android.gms.auth;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C3511t;
import com.google.android.gms.common.internal.C3512u;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class TokenData implements SafeParcelable {
    public static final C3013d CREATOR;
    final int f10118a;
    private final String f10119b;
    private final Long f10120c;
    private final boolean f10121d;
    private final boolean f10122e;
    private final List<String> f10123f;

    static {
        CREATOR = new C3013d();
    }

    TokenData(int i, String str, Long l, boolean z, boolean z2, List<String> list) {
        this.f10118a = i;
        this.f10119b = C3512u.m14582a(str);
        this.f10120c = l;
        this.f10121d = z;
        this.f10122e = z2;
        this.f10123f = list;
    }

    public String m11639a() {
        return this.f10119b;
    }

    public Long m11640b() {
        return this.f10120c;
    }

    public boolean m11641c() {
        return this.f10121d;
    }

    public boolean m11642d() {
        return this.f10122e;
    }

    public int describeContents() {
        return 0;
    }

    public List<String> m11643e() {
        return this.f10123f;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TokenData)) {
            return false;
        }
        TokenData tokenData = (TokenData) obj;
        return TextUtils.equals(this.f10119b, tokenData.f10119b) && C3511t.m14579a(this.f10120c, tokenData.f10120c) && this.f10121d == tokenData.f10121d && this.f10122e == tokenData.f10122e && C3511t.m14579a(this.f10123f, tokenData.f10123f);
    }

    public int hashCode() {
        return C3511t.m14577a(this.f10119b, this.f10120c, Boolean.valueOf(this.f10121d), Boolean.valueOf(this.f10122e), this.f10123f);
    }

    public void writeToParcel(Parcel parcel, int i) {
        C3013d.m11717a(this, parcel, i);
    }
}
