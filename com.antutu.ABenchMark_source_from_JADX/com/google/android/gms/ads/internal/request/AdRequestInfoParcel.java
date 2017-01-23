package com.google.android.gms.ads.internal.request;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Parcel;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.p146b.gb;
import java.util.Collections;
import java.util.List;

@gb
public final class AdRequestInfoParcel implements SafeParcelable {
    public static final C2928f CREATOR;
    public final List<String> f9844A;
    public final long f9845B;
    public final CapabilityParcel f9846C;
    public final String f9847D;
    public final float f9848E;
    public final int f9849F;
    public final int f9850G;
    public final int f9851a;
    public final Bundle f9852b;
    public final AdRequestParcel f9853c;
    public final AdSizeParcel f9854d;
    public final String f9855e;
    public final ApplicationInfo f9856f;
    public final PackageInfo f9857g;
    public final String f9858h;
    public final String f9859i;
    public final String f9860j;
    public final VersionInfoParcel f9861k;
    public final Bundle f9862l;
    public final int f9863m;
    public final List<String> f9864n;
    public final Bundle f9865o;
    public final boolean f9866p;
    public final Messenger f9867q;
    public final int f9868r;
    public final int f9869s;
    public final float f9870t;
    public final String f9871u;
    public final long f9872v;
    public final String f9873w;
    public final List<String> f9874x;
    public final String f9875y;
    public final NativeAdOptionsParcel f9876z;

    @gb
    /* renamed from: com.google.android.gms.ads.internal.request.AdRequestInfoParcel.a */
    public static final class C2904a {
        public final String f9814A;
        public final float f9815B;
        public final int f9816C;
        public final int f9817D;
        public final Bundle f9818a;
        public final AdRequestParcel f9819b;
        public final AdSizeParcel f9820c;
        public final String f9821d;
        public final ApplicationInfo f9822e;
        public final PackageInfo f9823f;
        public final String f9824g;
        public final String f9825h;
        public final Bundle f9826i;
        public final VersionInfoParcel f9827j;
        public final int f9828k;
        public final List<String> f9829l;
        public final List<String> f9830m;
        public final Bundle f9831n;
        public final boolean f9832o;
        public final Messenger f9833p;
        public final int f9834q;
        public final int f9835r;
        public final float f9836s;
        public final String f9837t;
        public final long f9838u;
        public final String f9839v;
        public final List<String> f9840w;
        public final String f9841x;
        public final NativeAdOptionsParcel f9842y;
        public final CapabilityParcel f9843z;

        public C2904a(Bundle bundle, AdRequestParcel adRequestParcel, AdSizeParcel adSizeParcel, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, VersionInfoParcel versionInfoParcel, Bundle bundle2, List<String> list, List<String> list2, Bundle bundle3, boolean z, Messenger messenger, int i, int i2, float f, String str4, long j, String str5, List<String> list3, String str6, NativeAdOptionsParcel nativeAdOptionsParcel, CapabilityParcel capabilityParcel, String str7, float f2, int i3, int i4) {
            this.f9818a = bundle;
            this.f9819b = adRequestParcel;
            this.f9820c = adSizeParcel;
            this.f9821d = str;
            this.f9822e = applicationInfo;
            this.f9823f = packageInfo;
            this.f9824g = str2;
            this.f9825h = str3;
            this.f9827j = versionInfoParcel;
            this.f9826i = bundle2;
            this.f9832o = z;
            this.f9833p = messenger;
            this.f9834q = i;
            this.f9835r = i2;
            this.f9836s = f;
            if (list == null || list.size() <= 0) {
                if (adSizeParcel.f9335k) {
                    this.f9828k = 4;
                } else {
                    this.f9828k = 0;
                }
                this.f9829l = null;
                this.f9830m = null;
            } else {
                this.f9828k = 3;
                this.f9829l = list;
                this.f9830m = list2;
            }
            this.f9831n = bundle3;
            this.f9837t = str4;
            this.f9838u = j;
            this.f9839v = str5;
            this.f9840w = list3;
            this.f9841x = str6;
            this.f9842y = nativeAdOptionsParcel;
            this.f9843z = capabilityParcel;
            this.f9814A = str7;
            this.f9815B = f2;
            this.f9816C = i3;
            this.f9817D = i4;
        }
    }

    static {
        CREATOR = new C2928f();
    }

    AdRequestInfoParcel(int i, Bundle bundle, AdRequestParcel adRequestParcel, AdSizeParcel adSizeParcel, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, VersionInfoParcel versionInfoParcel, Bundle bundle2, int i2, List<String> list, Bundle bundle3, boolean z, Messenger messenger, int i3, int i4, float f, String str5, long j, String str6, List<String> list2, String str7, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list3, long j2, CapabilityParcel capabilityParcel, String str8, float f2, int i5, int i6) {
        this.f9851a = i;
        this.f9852b = bundle;
        this.f9853c = adRequestParcel;
        this.f9854d = adSizeParcel;
        this.f9855e = str;
        this.f9856f = applicationInfo;
        this.f9857g = packageInfo;
        this.f9858h = str2;
        this.f9859i = str3;
        this.f9860j = str4;
        this.f9861k = versionInfoParcel;
        this.f9862l = bundle2;
        this.f9863m = i2;
        this.f9864n = list;
        this.f9844A = list3 == null ? Collections.emptyList() : Collections.unmodifiableList(list3);
        this.f9865o = bundle3;
        this.f9866p = z;
        this.f9867q = messenger;
        this.f9868r = i3;
        this.f9869s = i4;
        this.f9870t = f;
        this.f9871u = str5;
        this.f9872v = j;
        this.f9873w = str6;
        this.f9874x = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.f9875y = str7;
        this.f9876z = nativeAdOptionsParcel;
        this.f9845B = j2;
        this.f9846C = capabilityParcel;
        this.f9847D = str8;
        this.f9848E = f2;
        this.f9849F = i5;
        this.f9850G = i6;
    }

    public AdRequestInfoParcel(Bundle bundle, AdRequestParcel adRequestParcel, AdSizeParcel adSizeParcel, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, VersionInfoParcel versionInfoParcel, Bundle bundle2, int i, List<String> list, List<String> list2, Bundle bundle3, boolean z, Messenger messenger, int i2, int i3, float f, String str5, long j, String str6, List<String> list3, String str7, NativeAdOptionsParcel nativeAdOptionsParcel, long j2, CapabilityParcel capabilityParcel, String str8, float f2, int i4, int i5) {
        this(15, bundle, adRequestParcel, adSizeParcel, str, applicationInfo, packageInfo, str2, str3, str4, versionInfoParcel, bundle2, i, list, bundle3, z, messenger, i2, i3, f, str5, j, str6, list3, str7, nativeAdOptionsParcel, list2, j2, capabilityParcel, str8, f2, i4, i5);
    }

    public AdRequestInfoParcel(C2904a c2904a, String str, long j) {
        String str2 = str;
        long j2 = j;
        this(c2904a.f9818a, c2904a.f9819b, c2904a.f9820c, c2904a.f9821d, c2904a.f9822e, c2904a.f9823f, str2, c2904a.f9824g, c2904a.f9825h, c2904a.f9827j, c2904a.f9826i, c2904a.f9828k, c2904a.f9829l, c2904a.f9830m, c2904a.f9831n, c2904a.f9832o, c2904a.f9833p, c2904a.f9834q, c2904a.f9835r, c2904a.f9836s, c2904a.f9837t, c2904a.f9838u, c2904a.f9839v, c2904a.f9840w, c2904a.f9841x, c2904a.f9842y, j2, c2904a.f9843z, c2904a.f9814A, c2904a.f9815B, c2904a.f9816C, c2904a.f9817D);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2928f.m11405a(this, parcel, i);
    }
}
