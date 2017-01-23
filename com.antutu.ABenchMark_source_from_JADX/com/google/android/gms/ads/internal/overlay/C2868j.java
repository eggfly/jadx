package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.google.android.gms.p146b.aw;
import com.google.android.gms.p146b.az;
import com.google.android.gms.p146b.ii;
import com.google.android.gms.p146b.jq;

/* renamed from: com.google.android.gms.ads.internal.overlay.j */
public abstract class C2868j {
    public abstract C2854i m11134a(Context context, ii iiVar, int i, az azVar, aw awVar);

    protected boolean m11135a(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return jq.m13569b() && (applicationInfo == null || applicationInfo.targetSdkVersion >= 11);
    }
}
