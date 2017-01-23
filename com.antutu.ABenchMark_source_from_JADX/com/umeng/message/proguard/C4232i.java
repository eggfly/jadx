package com.umeng.message.proguard;

import android.content.Context;

/* renamed from: com.umeng.message.proguard.i */
public class C4232i {
    private static float f14373a;

    static {
        f14373a = 1.0f;
    }

    public C4232i(Context context) {
        C4232i.m17288a(context);
    }

    public static int m17287a(float f) {
        return (int) ((f14373a * f) + 0.5f);
    }

    public static void m17288a(Context context) {
        f14373a = context.getResources().getDisplayMetrics().density;
    }

    public static int m17289b(float f) {
        return (int) ((f / f14373a) + 0.5f);
    }

    public static int m17290c(float f) {
        return (int) ((f14373a * f) + 0.5f);
    }

    public static int m17291d(float f) {
        return (int) ((f / f14373a) + 0.5f);
    }
}
