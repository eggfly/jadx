package com.google.android.gms.common.internal;

import aeq$a;
import aeq$b;
import aeq$c;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.api.Scope;

public final class zzaf extends Button {
    public zzaf(Context context) {
        this(context, null);
    }

    public zzaf(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16842824);
    }

    private void DW(Resources resources, int i, int i2, boolean z) {
        setTextColor((ColorStateList) b.j6(resources.getColorStateList(z ? j6(i2, aeq$a.common_plus_signin_btn_text_dark, aeq$a.common_plus_signin_btn_text_light, aeq$a.common_plus_signin_btn_text_dark) : j6(i2, aeq$a.common_google_signin_btn_text_dark, aeq$a.common_google_signin_btn_text_light, aeq$a.common_google_signin_btn_text_light))));
        switch (i) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                setText(resources.getString(aeq$c.common_signin_button_text));
                break;
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                setText(resources.getString(aeq$c.common_signin_button_text_long));
                break;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                setText(null);
                break;
            default:
                throw new IllegalStateException("Unknown button size: " + i);
        }
        setTransformationMethod(null);
    }

    private int j6(int i, int i2, int i3) {
        switch (i) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                return i3;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                return i2;
            default:
                throw new IllegalStateException("Unknown button size: " + i);
        }
    }

    private int j6(int i, int i2, int i3, int i4) {
        switch (i) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                return i2;
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                return i3;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                return i4;
            default:
                throw new IllegalStateException("Unknown color scheme: " + i);
        }
    }

    private void j6(Resources resources) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        float f = resources.getDisplayMetrics().density;
        setMinHeight((int) ((f * 48.0f) + 0.5f));
        setMinWidth((int) ((f * 48.0f) + 0.5f));
    }

    private void j6(Resources resources, int i, int i2, boolean z) {
        setBackgroundDrawable(resources.getDrawable(z ? j6(i, j6(i2, aeq$b.common_plus_signin_btn_icon_dark, aeq$b.common_plus_signin_btn_icon_light, aeq$b.common_plus_signin_btn_icon_dark), j6(i2, aeq$b.common_plus_signin_btn_text_dark, aeq$b.common_plus_signin_btn_text_light, aeq$b.common_plus_signin_btn_text_dark)) : j6(i, j6(i2, aeq$b.common_google_signin_btn_icon_dark, aeq$b.common_google_signin_btn_icon_light, aeq$b.common_google_signin_btn_icon_light), j6(i2, aeq$b.common_google_signin_btn_text_dark, aeq$b.common_google_signin_btn_text_light, aeq$b.common_google_signin_btn_text_light))));
    }

    private boolean j6(Scope[] scopeArr) {
        if (scopeArr == null) {
            return false;
        }
        for (Scope j6 : scopeArr) {
            String j62 = j6.j6();
            if (j62.contains("/plus.") && !j62.equals("https://www.googleapis.com/auth/plus.me")) {
                return true;
            }
            if (j62.equals("https://www.googleapis.com/auth/games")) {
                return true;
            }
        }
        return false;
    }

    public void j6(Resources resources, int i, int i2, Scope[] scopeArr) {
        boolean j6 = j6(scopeArr);
        j6(resources);
        j6(resources, i, i2, j6);
        DW(resources, i, i2, j6);
    }
}
