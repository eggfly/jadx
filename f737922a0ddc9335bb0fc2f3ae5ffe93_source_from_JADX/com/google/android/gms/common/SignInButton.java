package com.google.android.gms.common;

import aeq$d;
import agi$a;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.zzaf;

public final class SignInButton extends FrameLayout implements OnClickListener {
    private int DW;
    private Scope[] FH;
    private View Hw;
    private int j6;
    private OnClickListener v5;

    public SignInButton(Context context) {
        this(context, null);
    }

    public SignInButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SignInButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.v5 = null;
        j6(context, attributeSet);
        j6(this.j6, this.DW, this.FH);
    }

    private static Button j6(Context context, int i, int i2, Scope[] scopeArr) {
        Button com_google_android_gms_common_internal_zzaf = new zzaf(context);
        com_google_android_gms_common_internal_zzaf.j6(context.getResources(), i, i2, scopeArr);
        return com_google_android_gms_common_internal_zzaf;
    }

    private void j6(Context context) {
        if (this.Hw != null) {
            removeView(this.Hw);
        }
        try {
            this.Hw = f.j6(context, this.j6, this.DW, this.FH);
        } catch (agi$a e) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            this.Hw = j6(context, this.j6, this.DW, this.FH);
        }
        addView(this.Hw);
        this.Hw.setEnabled(isEnabled());
        this.Hw.setOnClickListener(this);
    }

    private void j6(Context context, AttributeSet attributeSet) {
        int i = 0;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, aeq$d.SignInButton, 0, 0);
        try {
            this.j6 = obtainStyledAttributes.getInt(aeq$d.SignInButton_buttonSize, 0);
            this.DW = obtainStyledAttributes.getInt(aeq$d.SignInButton_colorScheme, 2);
            String string = obtainStyledAttributes.getString(aeq$d.SignInButton_scopeUris);
            if (string == null) {
                this.FH = null;
            } else {
                String[] split = string.trim().split("\\s+");
                this.FH = new Scope[split.length];
                while (i < split.length) {
                    this.FH[i] = new Scope(split[i].toString());
                    i++;
                }
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    public void j6(int i, int i2, Scope[] scopeArr) {
        this.j6 = i;
        this.DW = i2;
        this.FH = scopeArr;
        j6(getContext());
    }

    public void onClick(View view) {
        if (this.v5 != null && view == this.Hw) {
            this.v5.onClick(this);
        }
    }

    public void setColorScheme(int i) {
        j6(this.j6, i, this.FH);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.Hw.setEnabled(z);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.v5 = onClickListener;
        if (this.Hw != null) {
            this.Hw.setOnClickListener(this);
        }
    }

    public void setScopes(Scope[] scopeArr) {
        j6(this.j6, this.DW, scopeArr);
    }

    public void setSize(int i) {
        j6(i, this.DW, this.FH);
    }
}
