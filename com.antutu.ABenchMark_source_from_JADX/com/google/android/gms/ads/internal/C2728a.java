package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.C2727v;
import com.google.android.gms.ads.internal.client.C2783u;
import com.google.android.gms.ads.internal.client.ab;
import com.google.android.gms.ads.internal.client.ad;
import com.google.android.gms.ads.internal.formats.C2822k;
import com.google.android.gms.ads.internal.overlay.C2864d;
import com.google.android.gms.ads.internal.purchase.C2886e;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.p146b.aq;
import com.google.android.gms.p146b.bh;
import com.google.android.gms.p146b.cy;
import com.google.android.gms.p146b.dt;
import com.google.android.gms.p146b.et;
import com.google.android.gms.p146b.fd;

/* renamed from: com.google.android.gms.ads.internal.a */
public class C2728a implements C2727v {
    public static void m10387a() {
        C2783u.f9454a = C2728a.class.getName();
    }

    public ab m10388a(Context context, String str, dt dtVar, VersionInfoParcel versionInfoParcel) {
        return new C2831k(context, str, dtVar, versionInfoParcel, C2795e.m10771a());
    }

    public ad m10389a(Context context, AdSizeParcel adSizeParcel, String str, dt dtVar, VersionInfoParcel versionInfoParcel) {
        return new C2826g(context, adSizeParcel, str, dtVar, versionInfoParcel, C2795e.m10771a());
    }

    public bh m10390a(FrameLayout frameLayout, FrameLayout frameLayout2) {
        return new C2822k(frameLayout, frameLayout2);
    }

    public fd m10391a(Activity activity) {
        return new C2886e(activity);
    }

    public ad m10392b(Context context, AdSizeParcel adSizeParcel, String str, dt dtVar, VersionInfoParcel versionInfoParcel) {
        if (((Boolean) aq.ae.m11794c()).booleanValue()) {
            return new cy(context, str, dtVar, versionInfoParcel, C2795e.m10771a());
        }
        return new C2836l(context, adSizeParcel, str, dtVar, versionInfoParcel, C2795e.m10771a());
    }

    public et m10393b(Activity activity) {
        return new C2864d(activity);
    }
}
