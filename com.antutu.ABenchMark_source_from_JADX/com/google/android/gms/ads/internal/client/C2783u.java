package com.google.android.gms.ads.internal.client;

import android.app.Activity;
import android.content.Context;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.C2728a;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.p146b.bh;
import com.google.android.gms.p146b.dt;
import com.google.android.gms.p146b.et;
import com.google.android.gms.p146b.fd;
import com.google.android.gms.p146b.gb;

@gb
/* renamed from: com.google.android.gms.ads.internal.client.u */
public class C2783u {
    public static String f9454a;
    private C2727v f9455b;

    static {
        f9454a = null;
    }

    public C2783u() {
        C2728a.m10387a();
        if (f9454a != null) {
            try {
                this.f9455b = (C2727v) C2783u.class.getClassLoader().loadClass(f9454a).newInstance();
                return;
            } catch (Throwable e) {
                C2972b.m11584d("Failed to instantiate ClientApi class.", e);
                this.f9455b = new C2765h();
                return;
            }
        }
        C2972b.m11583d("No client jar implementation found.");
        this.f9455b = new C2765h();
    }

    public ab m10735a(Context context, String str, dt dtVar, VersionInfoParcel versionInfoParcel) {
        return this.f9455b.m10381a(context, str, dtVar, versionInfoParcel);
    }

    public ad m10736a(Context context, AdSizeParcel adSizeParcel, String str, dt dtVar, VersionInfoParcel versionInfoParcel) {
        return this.f9455b.m10382a(context, adSizeParcel, str, dtVar, versionInfoParcel);
    }

    public bh m10737a(FrameLayout frameLayout, FrameLayout frameLayout2) {
        return this.f9455b.m10383a(frameLayout, frameLayout2);
    }

    public fd m10738a(Activity activity) {
        return this.f9455b.m10384a(activity);
    }

    public ad m10739b(Context context, AdSizeParcel adSizeParcel, String str, dt dtVar, VersionInfoParcel versionInfoParcel) {
        return this.f9455b.m10385b(context, adSizeParcel, str, dtVar, versionInfoParcel);
    }

    public et m10740b(Activity activity) {
        return this.f9455b.m10386b(activity);
    }
}
