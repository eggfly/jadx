package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.client.C2646a;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.p146b.bx;
import com.google.android.gms.p146b.cd;
import com.google.android.gms.p146b.gb;
import com.google.android.gms.p146b.ii;
import com.google.android.gms.p151a.C2687a.C2689a;
import com.google.android.gms.p151a.C2690b;

@gb
public final class AdOverlayInfoParcel implements SafeParcelable {
    public static final C2866f CREATOR;
    public final int f9645a;
    public final AdLauncherIntentInfoParcel f9646b;
    public final C2646a f9647c;
    public final C2735g f9648d;
    public final ii f9649e;
    public final bx f9650f;
    public final String f9651g;
    public final boolean f9652h;
    public final String f9653i;
    public final C2730p f9654j;
    public final int f9655k;
    public final int f9656l;
    public final String f9657m;
    public final VersionInfoParcel f9658n;
    public final cd f9659o;
    public final String f9660p;
    public final InterstitialAdParameterParcel f9661q;

    static {
        CREATOR = new C2866f();
    }

    AdOverlayInfoParcel(int i, AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String str, boolean z, String str2, IBinder iBinder5, int i2, int i3, String str3, VersionInfoParcel versionInfoParcel, IBinder iBinder6, String str4, InterstitialAdParameterParcel interstitialAdParameterParcel) {
        this.f9645a = i;
        this.f9646b = adLauncherIntentInfoParcel;
        this.f9647c = (C2646a) C2690b.m10263a(C2689a.m10261a(iBinder));
        this.f9648d = (C2735g) C2690b.m10263a(C2689a.m10261a(iBinder2));
        this.f9649e = (ii) C2690b.m10263a(C2689a.m10261a(iBinder3));
        this.f9650f = (bx) C2690b.m10263a(C2689a.m10261a(iBinder4));
        this.f9651g = str;
        this.f9652h = z;
        this.f9653i = str2;
        this.f9654j = (C2730p) C2690b.m10263a(C2689a.m10261a(iBinder5));
        this.f9655k = i2;
        this.f9656l = i3;
        this.f9657m = str3;
        this.f9658n = versionInfoParcel;
        this.f9659o = (cd) C2690b.m10263a(C2689a.m10261a(iBinder6));
        this.f9660p = str4;
        this.f9661q = interstitialAdParameterParcel;
    }

    public AdOverlayInfoParcel(C2646a c2646a, C2735g c2735g, C2730p c2730p, ii iiVar, int i, VersionInfoParcel versionInfoParcel, String str, InterstitialAdParameterParcel interstitialAdParameterParcel) {
        this.f9645a = 4;
        this.f9646b = null;
        this.f9647c = c2646a;
        this.f9648d = c2735g;
        this.f9649e = iiVar;
        this.f9650f = null;
        this.f9651g = null;
        this.f9652h = false;
        this.f9653i = null;
        this.f9654j = c2730p;
        this.f9655k = i;
        this.f9656l = 1;
        this.f9657m = null;
        this.f9658n = versionInfoParcel;
        this.f9659o = null;
        this.f9660p = str;
        this.f9661q = interstitialAdParameterParcel;
    }

    public AdOverlayInfoParcel(C2646a c2646a, C2735g c2735g, C2730p c2730p, ii iiVar, boolean z, int i, VersionInfoParcel versionInfoParcel) {
        this.f9645a = 4;
        this.f9646b = null;
        this.f9647c = c2646a;
        this.f9648d = c2735g;
        this.f9649e = iiVar;
        this.f9650f = null;
        this.f9651g = null;
        this.f9652h = z;
        this.f9653i = null;
        this.f9654j = c2730p;
        this.f9655k = i;
        this.f9656l = 2;
        this.f9657m = null;
        this.f9658n = versionInfoParcel;
        this.f9659o = null;
        this.f9660p = null;
        this.f9661q = null;
    }

    public AdOverlayInfoParcel(C2646a c2646a, C2735g c2735g, bx bxVar, C2730p c2730p, ii iiVar, boolean z, int i, String str, VersionInfoParcel versionInfoParcel, cd cdVar) {
        this.f9645a = 4;
        this.f9646b = null;
        this.f9647c = c2646a;
        this.f9648d = c2735g;
        this.f9649e = iiVar;
        this.f9650f = bxVar;
        this.f9651g = null;
        this.f9652h = z;
        this.f9653i = null;
        this.f9654j = c2730p;
        this.f9655k = i;
        this.f9656l = 3;
        this.f9657m = str;
        this.f9658n = versionInfoParcel;
        this.f9659o = cdVar;
        this.f9660p = null;
        this.f9661q = null;
    }

    public AdOverlayInfoParcel(C2646a c2646a, C2735g c2735g, bx bxVar, C2730p c2730p, ii iiVar, boolean z, int i, String str, String str2, VersionInfoParcel versionInfoParcel, cd cdVar) {
        this.f9645a = 4;
        this.f9646b = null;
        this.f9647c = c2646a;
        this.f9648d = c2735g;
        this.f9649e = iiVar;
        this.f9650f = bxVar;
        this.f9651g = str2;
        this.f9652h = z;
        this.f9653i = str;
        this.f9654j = c2730p;
        this.f9655k = i;
        this.f9656l = 3;
        this.f9657m = null;
        this.f9658n = versionInfoParcel;
        this.f9659o = cdVar;
        this.f9660p = null;
        this.f9661q = null;
    }

    public AdOverlayInfoParcel(AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, C2646a c2646a, C2735g c2735g, C2730p c2730p, VersionInfoParcel versionInfoParcel) {
        this.f9645a = 4;
        this.f9646b = adLauncherIntentInfoParcel;
        this.f9647c = c2646a;
        this.f9648d = c2735g;
        this.f9649e = null;
        this.f9650f = null;
        this.f9651g = null;
        this.f9652h = false;
        this.f9653i = null;
        this.f9654j = c2730p;
        this.f9655k = -1;
        this.f9656l = 4;
        this.f9657m = null;
        this.f9658n = versionInfoParcel;
        this.f9659o = null;
        this.f9660p = null;
        this.f9661q = null;
    }

    public static AdOverlayInfoParcel m11035a(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception e) {
            return null;
        }
    }

    public static void m11036a(Intent intent, AdOverlayInfoParcel adOverlayInfoParcel) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", adOverlayInfoParcel);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    IBinder m11037a() {
        return C2690b.m10262a(this.f9647c).asBinder();
    }

    IBinder m11038b() {
        return C2690b.m10262a(this.f9648d).asBinder();
    }

    IBinder m11039c() {
        return C2690b.m10262a(this.f9649e).asBinder();
    }

    IBinder m11040d() {
        return C2690b.m10262a(this.f9650f).asBinder();
    }

    public int describeContents() {
        return 0;
    }

    IBinder m11041e() {
        return C2690b.m10262a(this.f9659o).asBinder();
    }

    IBinder m11042f() {
        return C2690b.m10262a(this.f9654j).asBinder();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2866f.m11124a(this, parcel, i);
    }
}
