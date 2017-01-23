package com.google.android.gms.p146b;

import android.content.Context;
import com.google.android.gms.ads.internal.C2795e;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

@gb
/* renamed from: com.google.android.gms.b.ik */
public class ik {
    public ii m13299a(Context context, AdSizeParcel adSizeParcel, boolean z, boolean z2, C3326k c3326k, VersionInfoParcel versionInfoParcel) {
        return m13300a(context, adSizeParcel, z, z2, c3326k, versionInfoParcel, null, null);
    }

    public ii m13300a(Context context, AdSizeParcel adSizeParcel, boolean z, boolean z2, C3326k c3326k, VersionInfoParcel versionInfoParcel, az azVar, C2795e c2795e) {
        ii ilVar = new il(im.m13359a(context, adSizeParcel, z, z2, c3326k, versionInfoParcel, azVar, c2795e));
        ilVar.setWebViewClient(C2968s.m11527g().m13077a(ilVar, z2));
        ilVar.setWebChromeClient(C2968s.m11527g().m13093c(ilVar));
        return ilVar;
    }
}
