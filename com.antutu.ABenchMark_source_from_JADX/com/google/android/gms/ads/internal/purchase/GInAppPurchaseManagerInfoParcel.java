package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.p146b.fb;
import com.google.android.gms.p146b.gb;
import com.google.android.gms.p151a.C2687a.C2689a;
import com.google.android.gms.p151a.C2690b;

@gb
public final class GInAppPurchaseManagerInfoParcel implements SafeParcelable {
    public static final C2879a CREATOR;
    public final int f9746a;
    public final C2894k f9747b;
    public final fb f9748c;
    public final Context f9749d;
    public final C2736j f9750e;

    static {
        CREATOR = new C2879a();
    }

    GInAppPurchaseManagerInfoParcel(int i, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4) {
        this.f9746a = i;
        this.f9747b = (C2894k) C2690b.m10263a(C2689a.m10261a(iBinder));
        this.f9748c = (fb) C2690b.m10263a(C2689a.m10261a(iBinder2));
        this.f9749d = (Context) C2690b.m10263a(C2689a.m10261a(iBinder3));
        this.f9750e = (C2736j) C2690b.m10263a(C2689a.m10261a(iBinder4));
    }

    public GInAppPurchaseManagerInfoParcel(Context context, C2894k c2894k, fb fbVar, C2736j c2736j) {
        this.f9746a = 2;
        this.f9749d = context;
        this.f9747b = c2894k;
        this.f9748c = fbVar;
        this.f9750e = c2736j;
    }

    public static GInAppPurchaseManagerInfoParcel m11191a(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
            bundleExtra.setClassLoader(GInAppPurchaseManagerInfoParcel.class.getClassLoader());
            return (GInAppPurchaseManagerInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
        } catch (Exception e) {
            return null;
        }
    }

    public static void m11192a(Intent intent, GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", gInAppPurchaseManagerInfoParcel);
        intent.putExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", bundle);
    }

    IBinder m11193a() {
        return C2690b.m10262a(this.f9750e).asBinder();
    }

    IBinder m11194b() {
        return C2690b.m10262a(this.f9747b).asBinder();
    }

    IBinder m11195c() {
        return C2690b.m10262a(this.f9748c).asBinder();
    }

    IBinder m11196d() {
        return C2690b.m10262a(this.f9749d).asBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2879a.m11197a(this, parcel, i);
    }
}
