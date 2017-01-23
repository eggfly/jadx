package com.antutu.redacc.p067f;

import android.content.Context;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.antutu.redacc.f.m */
public class C1756m {
    public static String m6763a(Context context, String str) {
        return context.getSharedPreferences("mobile_sharedpre", 0).getString(str, BuildConfig.FLAVOR);
    }
}
