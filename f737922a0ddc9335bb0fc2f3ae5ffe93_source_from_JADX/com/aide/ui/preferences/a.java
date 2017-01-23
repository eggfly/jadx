package com.aide.ui.preferences;

import android.content.Context;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import com.aide.ui.e;
import gf;
import hh;

public class a {
    public static void j6(Context context, PreferenceScreen preferenceScreen) {
        PreferenceCategory preferenceCategory = null;
        for (hh hhVar : hh.values()) {
            if (preferenceCategory == null || !preferenceCategory.getTitle().equals(hhVar.FH())) {
                preferenceCategory = new PreferenceCategory(context);
                preferenceCategory.setTitle(hhVar.FH());
                preferenceScreen.addPreference(preferenceCategory);
            }
            Preference premiumCheckBoxPreference = new PremiumCheckBoxPreference(context);
            premiumCheckBoxPreference.setKey(hhVar.DW());
            premiumCheckBoxPreference.setTitle(hhVar.j6());
            if (hhVar.j6(false).length() > 0) {
                premiumCheckBoxPreference.setSummary(("\"" + hhVar.j6(false).replace("\n", "\\n") + "\"") + " versus " + ("\"" + hhVar.j6(true).replace("\n", "\\n") + "\""));
            }
            preferenceCategory.addPreference(premiumCheckBoxPreference);
        }
    }

    public static void DW(Context context, PreferenceScreen preferenceScreen) {
        PreferenceCategory preferenceCategory = null;
        for (gf gfVar : gf.values()) {
            if (preferenceCategory == null || !preferenceCategory.getTitle().equals(gfVar.FH())) {
                preferenceCategory = new PreferenceCategory(context);
                preferenceCategory.setTitle(gfVar.FH());
                preferenceScreen.addPreference(preferenceCategory);
            }
            Preference premiumCheckBoxPreference = new PremiumCheckBoxPreference(context);
            premiumCheckBoxPreference.setKey(gfVar.DW());
            premiumCheckBoxPreference.setTitle(gfVar.j6());
            if (gfVar.j6(false).length() > 0) {
                premiumCheckBoxPreference.setSummary(("\"" + gfVar.j6(false).replace("\n", "\\n") + "\"") + " versus " + ("\"" + gfVar.j6(true).replace("\n", "\\n") + "\""));
            }
            preferenceCategory.addPreference(premiumCheckBoxPreference);
        }
    }

    public static void FH(Context context, PreferenceScreen preferenceScreen) {
        if (e.Hw() || e.j6.equals("com.aide.phonegap") || e.j6.equals("com.aide.web")) {
            j6(context, preferenceScreen);
        }
        if (e.Hw() || e.j6.equals("com.aide.ui")) {
            DW(context, preferenceScreen);
        }
    }
}
