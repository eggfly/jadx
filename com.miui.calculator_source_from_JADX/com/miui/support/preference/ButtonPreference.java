package com.miui.support.preference;

import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ButtonPreference extends Preference {
    private String f3501a;
    private OnPreferenceClickListener f3502b;

    /* renamed from: com.miui.support.preference.ButtonPreference.1 */
    class C04121 implements OnClickListener {
        final /* synthetic */ ButtonPreference f3500a;

        C04121(ButtonPreference buttonPreference) {
            this.f3500a = buttonPreference;
        }

        public void onClick(View view) {
            if (this.f3500a.f3502b != null) {
                this.f3500a.f3502b.onPreferenceClick(this.f3500a);
            }
        }
    }

    protected void onBindView(View view) {
        super.onBindView(view);
        view.setBackground(null);
        Button button = (Button) view.findViewById(16908313);
        if (button != null) {
            button.setOnClickListener(new C04121(this));
            button.setText(this.f3501a);
        }
    }

    public void setOnPreferenceClickListener(OnPreferenceClickListener onPreferenceClickListener) {
        this.f3502b = onPreferenceClickListener;
    }
}
