package com.aide.ui.preferences;

import android.app.Activity;
import android.content.Context;
import android.preference.EditTextPreference;
import android.util.AttributeSet;
import com.aide.ui.e;

public class PremiumEditTextPreference extends EditTextPreference {
    public PremiumEditTextPreference(Context context) {
        super(context);
    }

    public PremiumEditTextPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PremiumEditTextPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onClick() {
        if (e.Mr().j6((Activity) getContext(), getKey())) {
            super.onClick();
        }
    }
}
