package com.miui.calculator.common.utils;

import android.content.Context;
import android.preference.PreferenceManager;
import com.miui.calculator.CalculatorApplication;

public class DefaultPreferenceHelper {
    public static final void m2833a(Context context, boolean z) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("pref_network_confirmed", z).commit();
    }

    public static final boolean m2835a(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("pref_network_confirmed", false);
    }

    public static final void m2832a(Context context, String str, String str2) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(str, str2).commit();
    }

    public static final String m2837b(Context context, String str, String str2) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(str, str2);
    }

    public static final void m2831a(Context context, String str) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString("pref_last_city", str).commit();
    }

    public static final String m2836b(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("pref_last_city", str);
    }

    public static final boolean m2834a() {
        return PreferenceManager.getDefaultSharedPreferences(CalculatorApplication.m2559b()).getBoolean("key_use_degress", true);
    }
}
