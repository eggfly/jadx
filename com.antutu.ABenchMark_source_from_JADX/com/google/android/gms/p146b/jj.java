package com.google.android.gms.p146b;

import android.annotation.TargetApi;
import android.content.Context;

/* renamed from: com.google.android.gms.b.jj */
public final class jj {
    @TargetApi(20)
    public static boolean m13557a(Context context) {
        return jq.m13573f() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
    }
}
