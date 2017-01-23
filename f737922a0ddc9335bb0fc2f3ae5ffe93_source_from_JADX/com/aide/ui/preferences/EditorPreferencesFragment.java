package com.aide.ui.preferences;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceFragment;
import com.aide.ui.e;

public class EditorPreferencesFragment extends PreferenceFragment {

    class 1 implements OnPreferenceClickListener {
        final /* synthetic */ EditorPreferencesFragment j6;

        1(EditorPreferencesFragment editorPreferencesFragment) {
            this.j6 = editorPreferencesFragment;
        }

        public boolean onPreferenceClick(Preference preference) {
            e.KD().j6(this.j6.getActivity());
            return true;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(2131034117);
        findPreference("download_doc").setOnPreferenceClickListener(new 1(this));
    }
}
