package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.ads.p154e.C2720a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.p146b.gb;

@gb
public final class SearchAdRequestParcel implements SafeParcelable {
    public static final C2768j CREATOR;
    public final int f9336a;
    public final int f9337b;
    public final int f9338c;
    public final int f9339d;
    public final int f9340e;
    public final int f9341f;
    public final int f9342g;
    public final int f9343h;
    public final int f9344i;
    public final String f9345j;
    public final int f9346k;
    public final String f9347l;
    public final int f9348m;
    public final int f9349n;
    public final String f9350o;

    static {
        CREATOR = new C2768j();
    }

    SearchAdRequestParcel(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str, int i10, String str2, int i11, int i12, String str3) {
        this.f9336a = i;
        this.f9337b = i2;
        this.f9338c = i3;
        this.f9339d = i4;
        this.f9340e = i5;
        this.f9341f = i6;
        this.f9342g = i7;
        this.f9343h = i8;
        this.f9344i = i9;
        this.f9345j = str;
        this.f9346k = i10;
        this.f9347l = str2;
        this.f9348m = i11;
        this.f9349n = i12;
        this.f9350o = str3;
    }

    public SearchAdRequestParcel(C2720a c2720a) {
        this.f9336a = 1;
        this.f9337b = c2720a.m10349a();
        this.f9338c = c2720a.m10350b();
        this.f9339d = c2720a.m10351c();
        this.f9340e = c2720a.m10352d();
        this.f9341f = c2720a.m10353e();
        this.f9342g = c2720a.m10354f();
        this.f9343h = c2720a.m10355g();
        this.f9344i = c2720a.m10356h();
        this.f9345j = c2720a.m10357i();
        this.f9346k = c2720a.m10358j();
        this.f9347l = c2720a.m10359k();
        this.f9348m = c2720a.m10360l();
        this.f9349n = c2720a.m10361m();
        this.f9350o = c2720a.m10362n();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2768j.m10695a(this, parcel, i);
    }
}
