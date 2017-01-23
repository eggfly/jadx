package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import anet.channel.p017a.C0646b;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.p146b.gb;
import com.google.android.gms.p146b.jq;

@gb
/* renamed from: com.google.android.gms.ads.internal.overlay.e */
public class C2865e {
    public void m11122a(Context context, AdOverlayInfoParcel adOverlayInfoParcel) {
        m11123a(context, adOverlayInfoParcel, true);
    }

    public void m11123a(Context context, AdOverlayInfoParcel adOverlayInfoParcel, boolean z) {
        if (adOverlayInfoParcel.f9656l == 4 && adOverlayInfoParcel.f9648d == null) {
            if (adOverlayInfoParcel.f9647c != null) {
                adOverlayInfoParcel.f9647c.m10223a();
            }
            C2968s.m11522b().m11044a(context, adOverlayInfoParcel.f9646b, adOverlayInfoParcel.f9654j);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(context, "com.google.android.gms.ads.AdActivity");
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", adOverlayInfoParcel.f9658n.f10084e);
        intent.putExtra("shouldCallOnOverlayOpened", z);
        AdOverlayInfoParcel.m11036a(intent, adOverlayInfoParcel);
        if (!jq.m13574g()) {
            intent.addFlags(C0646b.MAX_POOL_SIZE);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        C2968s.m11525e().m13033a(context, intent);
    }
}
