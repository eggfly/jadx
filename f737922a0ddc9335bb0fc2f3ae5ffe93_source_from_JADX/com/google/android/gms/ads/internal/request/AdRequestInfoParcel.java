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
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.eh;
import java.util.Collections;
import java.util.List;

@eh
public final class AdRequestInfoParcel extends AbstractSafeParcelable {
    public static final b CREATOR;
    public final long BT;
    public final Bundle DW;
    public final VersionInfoParcel EQ;
    public final AdRequestParcel FH;
    public final AdSizeParcel Hw;
    public final int J0;
    public final List<String> J8;
    public final boolean KD;
    public final float Mr;
    public final String P8;
    public final boolean QX;
    public final int SI;
    public final String U2;
    public final PackageInfo VH;
    public final Bundle Ws;
    public final Messenger XL;
    public final ApplicationInfo Zo;
    public final long a8;
    public final int aM;
    public final String cb;
    public final String cn;
    public final boolean dx;
    public final Bundle ef;
    public final float ei;
    public final String er;
    public final List<String> gW;
    public final String gn;
    public final int j3;
    public final int j6;
    public final String lg;
    public final int nw;
    public final List<String> rN;
    public final boolean ro;
    public final int sG;
    public final boolean sh;
    public final String tp;
    public final String u7;
    public final String v5;
    public final CapabilityParcel vy;
    public final Bundle we;
    public final NativeAdOptionsParcel yS;

    static {
        CREATOR = new b();
    }

    AdRequestInfoParcel(int i, Bundle bundle, AdRequestParcel adRequestParcel, AdSizeParcel adSizeParcel, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, VersionInfoParcel versionInfoParcel, Bundle bundle2, int i2, List<String> list, Bundle bundle3, boolean z, Messenger messenger, int i3, int i4, float f, String str5, long j, String str6, List<String> list2, String str7, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list3, long j2, CapabilityParcel capabilityParcel, String str8, float f2, boolean z2, int i5, int i6, boolean z3, boolean z4, String str9, String str10, boolean z5, int i7, Bundle bundle4) {
        this.j6 = i;
        this.DW = bundle;
        this.FH = adRequestParcel;
        this.Hw = adSizeParcel;
        this.v5 = str;
        this.Zo = applicationInfo;
        this.VH = packageInfo;
        this.gn = str2;
        this.u7 = str3;
        this.tp = str4;
        this.EQ = versionInfoParcel;
        this.we = bundle2;
        this.J0 = i2;
        this.J8 = list;
        this.gW = list3 == null ? Collections.emptyList() : Collections.unmodifiableList(list3);
        if (bundle3 == null) {
            Bundle bundle5 = new Bundle(1);
        }
        this.Ws = bundle3;
        this.QX = z;
        this.XL = messenger;
        this.aM = i3;
        this.j3 = i4;
        this.Mr = f;
        this.U2 = str5;
        this.a8 = j;
        this.lg = str6;
        this.rN = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.er = str7;
        this.yS = nativeAdOptionsParcel;
        this.BT = j2;
        this.vy = capabilityParcel;
        this.P8 = str8;
        this.ei = f2;
        this.sh = z2;
        this.nw = i5;
        this.SI = i6;
        this.KD = z3;
        this.ro = z4;
        this.cn = str9;
        this.cb = str10;
        this.dx = z5;
        this.sG = i7;
        this.ef = bundle4;
    }

    public void writeToParcel(Parcel parcel, int i) {
        b.j6(this, parcel, i);
    }
}
