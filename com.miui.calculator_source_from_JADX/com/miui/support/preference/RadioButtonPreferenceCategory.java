package com.miui.support.preference;

import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceCategory;

public class RadioButtonPreferenceCategory extends PreferenceCategory implements OnPreferenceChangeListener {
    private RadioButtonPreference f3514a;
    private int f3515b;

    public boolean addPreference(Preference preference) {
        if (preference instanceof RadioButtonPreference) {
            boolean addPreference = super.addPreference(preference);
            if (addPreference) {
                preference.setOnPreferenceChangeListener(this);
            }
            return addPreference;
        }
        throw new IllegalArgumentException("Only RadioButtonPreference can be added toRadioButtonPreferenceCategory");
    }

    public void m5207a(Preference preference) {
        int preferenceCount = getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            Preference preference2 = (RadioButtonPreference) getPreference(i);
            if (preference2 == preference) {
                this.f3514a = preference2;
                this.f3515b = i;
                preference2.setChecked(true);
            } else {
                preference2.setChecked(false);
            }
        }
    }

    public boolean onPreferenceChange(Preference preference, Object obj) {
        if (preference != this.f3514a) {
            m5207a(preference);
        }
        OnPreferenceClickListener onPreferenceClickListener = getOnPreferenceClickListener();
        if (onPreferenceClickListener != null) {
            onPreferenceClickListener.onPreferenceClick(this);
        }
        return false;
    }
}
