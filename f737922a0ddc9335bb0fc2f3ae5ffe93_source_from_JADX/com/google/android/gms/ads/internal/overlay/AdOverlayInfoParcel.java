package com.google.android.gms.ads.internal.overlay;

import agg$a;
import agh;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.client.a;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.bv;
import com.google.android.gms.internal.bz;
import com.google.android.gms.internal.eh;
import com.google.android.gms.internal.fj;

@eh
public final class AdOverlayInfoParcel extends AbstractSafeParcelable {
    public static final e CREATOR;
    public final AdLauncherIntentInfoParcel DW;
    public final int EQ;
    public final a FH;
    public final f Hw;
    public final String J0;
    public final VersionInfoParcel J8;
    public final String QX;
    public final String VH;
    public final bz Ws;
    public final InterstitialAdParameterParcel XL;
    public final bv Zo;
    public final boolean gn;
    public final int j6;
    public final m tp;
    public final String u7;
    public final fj v5;
    public final int we;

    static {
        CREATOR = new e();
    }

    AdOverlayInfoParcel(int i, AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String str, boolean z, String str2, IBinder iBinder5, int i2, int i3, String str3, VersionInfoParcel versionInfoParcel, IBinder iBinder6, String str4, InterstitialAdParameterParcel interstitialAdParameterParcel) {
        this.j6 = i;
        this.DW = adLauncherIntentInfoParcel;
        this.FH = (a) agh.j6(agg$a.j6(iBinder));
        this.Hw = (f) agh.j6(agg$a.j6(iBinder2));
        this.v5 = (fj) agh.j6(agg$a.j6(iBinder3));
        this.Zo = (bv) agh.j6(agg$a.j6(iBinder4));
        this.VH = str;
        this.gn = z;
        this.u7 = str2;
        this.tp = (m) agh.j6(agg$a.j6(iBinder5));
        this.EQ = i2;
        this.we = i3;
        this.J0 = str3;
        this.J8 = versionInfoParcel;
        this.Ws = (bz) agh.j6(agg$a.j6(iBinder6));
        this.QX = str4;
        this.XL = interstitialAdParameterParcel;
    }

    public AdOverlayInfoParcel(a aVar, f fVar, m mVar, fj fjVar, boolean z, int i, VersionInfoParcel versionInfoParcel) {
        this.j6 = 4;
        this.DW = null;
        this.FH = aVar;
        this.Hw = fVar;
        this.v5 = fjVar;
        this.Zo = null;
        this.VH = null;
        this.gn = z;
        this.u7 = null;
        this.tp = mVar;
        this.EQ = i;
        this.we = 2;
        this.J0 = null;
        this.J8 = versionInfoParcel;
        this.Ws = null;
        this.QX = null;
        this.XL = null;
    }

    public AdOverlayInfoParcel(a aVar, f fVar, bv bvVar, m mVar, fj fjVar, boolean z, int i, String str, VersionInfoParcel versionInfoParcel, bz bzVar) {
        this.j6 = 4;
        this.DW = null;
        this.FH = aVar;
        this.Hw = fVar;
        this.v5 = fjVar;
        this.Zo = bvVar;
        this.VH = null;
        this.gn = z;
        this.u7 = null;
        this.tp = mVar;
        this.EQ = i;
        this.we = 3;
        this.J0 = str;
        this.J8 = versionInfoParcel;
        this.Ws = bzVar;
        this.QX = null;
        this.XL = null;
    }

    public AdOverlayInfoParcel(a aVar, f fVar, bv bvVar, m mVar, fj fjVar, boolean z, int i, String str, String str2, VersionInfoParcel versionInfoParcel, bz bzVar) {
        this.j6 = 4;
        this.DW = null;
        this.FH = aVar;
        this.Hw = fVar;
        this.v5 = fjVar;
        this.Zo = bvVar;
        this.VH = str2;
        this.gn = z;
        this.u7 = str;
        this.tp = mVar;
        this.EQ = i;
        this.we = 3;
        this.J0 = null;
        this.J8 = versionInfoParcel;
        this.Ws = bzVar;
        this.QX = null;
        this.XL = null;
    }

    public AdOverlayInfoParcel(AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, a aVar, f fVar, m mVar, VersionInfoParcel versionInfoParcel) {
        this.j6 = 4;
        this.DW = adLauncherIntentInfoParcel;
        this.FH = aVar;
        this.Hw = fVar;
        this.v5 = null;
        this.Zo = null;
        this.VH = null;
        this.gn = false;
        this.u7 = null;
        this.tp = mVar;
        this.EQ = -1;
        this.we = 4;
        this.J0 = null;
        this.J8 = versionInfoParcel;
        this.Ws = null;
        this.QX = null;
        this.XL = null;
    }

    public static AdOverlayInfoParcel j6(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception e) {
            return null;
        }
    }

    public static void j6(Intent intent, AdOverlayInfoParcel adOverlayInfoParcel) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", adOverlayInfoParcel);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    IBinder DW() {
        return agh.j6(this.Hw).asBinder();
    }

    IBinder FH() {
        return agh.j6(this.v5).asBinder();
    }

    IBinder Hw() {
        return agh.j6(this.Zo).asBinder();
    }

    IBinder Zo() {
        return agh.j6(this.tp).asBinder();
    }

    IBinder j6() {
        return agh.j6(this.FH).asBinder();
    }

    IBinder v5() {
        return agh.j6(this.Ws).asBinder();
    }

    public void writeToParcel(Parcel parcel, int i) {
        e.j6(this, parcel, i);
    }
}
