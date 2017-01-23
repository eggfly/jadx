package com.miui.support.preference;

import android.preference.CheckBoxPreference;
import android.view.View;
import android.widget.CheckedTextView;

public class RadioButtonPreference extends CheckBoxPreference {
    protected void onBindView(View view) {
        super.onBindView(view);
        View findViewById = view.findViewById(16908310);
        if (findViewById == null || (findViewById instanceof CheckedTextView)) {
            ((CheckedTextView) findViewById).setCheckMarkDrawable(0);
            ((CheckedTextView) findViewById).setChecked(isChecked());
        } else {
            ((CheckedTextView) findViewById).setCheckMarkDrawable(0);
            ((CheckedTextView) findViewById).setChecked(isChecked());
        }
    }
}
