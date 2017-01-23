package com.aide.ui.preferences;

import android.app.Activity;
import android.content.Context;
import android.preference.CheckBoxPreference;
import android.util.AttributeSet;
import com.aide.ui.e;

public class PremiumCheckBoxPreference extends CheckBoxPreference {
    public PremiumCheckBoxPreference(Context context) {
        super(context);
    }

    public PremiumCheckBoxPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PremiumCheckBoxPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onClick() {
        if (e.Mr().j6((Activity) getContext(), getKey())) {
            super.onClick();
        }
    }
}
