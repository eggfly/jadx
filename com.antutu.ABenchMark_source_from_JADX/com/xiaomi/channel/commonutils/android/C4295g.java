package com.xiaomi.channel.commonutils.android;

import android.content.Context;
import android.preference.PreferenceManager;

/* renamed from: com.xiaomi.channel.commonutils.android.g */
public abstract class C4295g {
    public static void m17620a(Context context) {
    }

    public static boolean m17621a(Context context, String str, boolean z) {
        C4295g.m17620a(context);
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(str, z);
    }

    public static void m17622b(Context context, String str, boolean z) {
        C4295g.m17620a(context);
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(str, z).commit();
    }
}
