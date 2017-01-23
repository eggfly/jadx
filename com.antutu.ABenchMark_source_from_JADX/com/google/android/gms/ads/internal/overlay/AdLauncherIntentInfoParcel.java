package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.p146b.gb;

@gb
public final class AdLauncherIntentInfoParcel implements SafeParcelable {
    public static final C2846b CREATOR;
    public final int f9636a;
    public final String f9637b;
    public final String f9638c;
    public final String f9639d;
    public final String f9640e;
    public final String f9641f;
    public final String f9642g;
    public final String f9643h;
    public final Intent f9644i;

    static {
        CREATOR = new C2846b();
    }

    public AdLauncherIntentInfoParcel(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, Intent intent) {
        this.f9636a = i;
        this.f9637b = str;
        this.f9638c = str2;
        this.f9639d = str3;
        this.f9640e = str4;
        this.f9641f = str5;
        this.f9642g = str6;
        this.f9643h = str7;
        this.f9644i = intent;
    }

    public AdLauncherIntentInfoParcel(Intent intent) {
        this(2, null, null, null, null, null, null, null, intent);
    }

    public AdLauncherIntentInfoParcel(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this(2, str, str2, str3, str4, str5, str6, str7, null);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2846b.m11045a(this, parcel, i);
    }
}
