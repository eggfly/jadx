package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.a;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.e;
import com.google.android.gms.ads.internal.f;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

@eh
public class fl {
    public fj j6(Context context, AdSizeParcel adSizeParcel, boolean z, boolean z2, y yVar, VersionInfoParcel versionInfoParcel, ay ayVar, e eVar, a aVar) {
        fj fmVar = new fm(zzle.j6(context, adSizeParcel, z, z2, yVar, versionInfoParcel, ayVar, eVar, aVar));
        fmVar.setWebViewClient(f.v5().j6(fmVar, z2));
        fmVar.setWebChromeClient(f.v5().FH(fmVar));
        return fmVar;
    }
}
