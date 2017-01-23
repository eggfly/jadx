package com.google.android.gms.ads.internal.overlay;

import agb;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.ads.internal.f;
import com.google.android.gms.internal.eh;

@eh
public class d {
    public void j6(Context context, AdOverlayInfoParcel adOverlayInfoParcel, boolean z) {
        if (adOverlayInfoParcel.we == 4 && adOverlayInfoParcel.Hw == null) {
            if (adOverlayInfoParcel.FH != null) {
                adOverlayInfoParcel.FH.v5();
            }
            f.j6().j6(context, adOverlayInfoParcel.DW, adOverlayInfoParcel.tp);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(context, "com.google.android.gms.ads.AdActivity");
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", adOverlayInfoParcel.J8.v5);
        intent.putExtra("shouldCallOnOverlayOpened", z);
        AdOverlayInfoParcel.j6(intent, adOverlayInfoParcel);
        if (!agb.u7()) {
            intent.addFlags(524288);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        f.FH().j6(context, intent);
    }
}
