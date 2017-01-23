package com.aide.ui.preferences;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceFragment;
import com.aide.ui.e;

public class CompilerPreferencesFragment extends PreferenceFragment {

    class 1 implements OnPreferenceClickListener {
        final /* synthetic */ CompilerPreferencesFragment j6;

        1(CompilerPreferencesFragment compilerPreferencesFragment) {
            this.j6 = compilerPreferencesFragment;
        }

        public boolean onPreferenceClick(Preference preference) {
            e.SI().j6(this.j6.getActivity());
            return true;
        }
    }

    class 2 implements OnPreferenceClickListener {
        final /* synthetic */ CompilerPreferencesFragment j6;

        2(CompilerPreferencesFragment compilerPreferencesFragment) {
            this.j6 = compilerPreferencesFragment;
        }

        public boolean onPreferenceClick(Preference preference) {
            e.KD().DW(this.j6.getActivity());
            return true;
        }
    }

    class 3 implements OnPreferenceClickListener {
        final /* synthetic */ CompilerPreferencesFragment j6;

        3(CompilerPreferencesFragment compilerPreferencesFragment) {
            this.j6 = compilerPreferencesFragment;
        }

        public boolean onPreferenceClick(Preference preference) {
            e.dx().FH();
            return true;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(2131034115);
        findPreference("generate_keystore").setOnPreferenceClickListener(new 1(this));
        findPreference("install_uninstall_ndksupport").setOnPreferenceClickListener(new 2(this));
        findPreference("refresh_maven_repository").setOnPreferenceClickListener(new 3(this));
    }
}
