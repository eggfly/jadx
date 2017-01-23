package com.miui.support.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import com.miui.support.util.ViewUtils;

public class ClearableEditText extends EditText {
    private static final int[] f4015a;
    private Drawable f4016b;
    private boolean f4017c;
    private boolean f4018d;

    /* renamed from: com.miui.support.widget.ClearableEditText.1 */
    class C04571 implements TextWatcher {
        final /* synthetic */ ClearableEditText f4014a;

        C04571(ClearableEditText clearableEditText) {
            this.f4014a = clearableEditText;
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            this.f4014a.f4018d = editable.length() > 0;
            this.f4014a.refreshDrawableState();
        }
    }

    static {
        f4015a = new int[]{16842921};
    }

    public ClearableEditText(Context context) {
        this(context, null);
    }

    public ClearableEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0264R.attr.editTextSearchStyle);
    }

    public ClearableEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        if (compoundDrawablesRelative[0] == null && compoundDrawablesRelative[1] == null && compoundDrawablesRelative[2] != null && compoundDrawablesRelative[3] == null) {
            this.f4016b = compoundDrawablesRelative[2];
            addTextChangedListener(new C04571(this));
            return;
        }
        throw new IllegalStateException("ClearableEditText need only drawableEnd");
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new IllegalStateException("ClearableEditText can only set drawables by setCompoundDrawablesRelative()");
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable == null && drawable2 == null && drawable3 != null && drawable4 == null) {
            this.f4016b = drawable3;
            super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new IllegalStateException("ClearableEditText can only set drawableRight");
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.f4018d) {
            if (ViewUtils.m5452a((View) this)) {
                if (motionEvent.getX() < ((float) (this.f4016b.getIntrinsicWidth() + getPaddingLeft()))) {
                    z = true;
                }
            } else if (motionEvent.getX() > ((float) ((getWidth() - getPaddingRight()) - this.f4016b.getIntrinsicWidth()))) {
                z = true;
            }
        }
        if (!z) {
            return super.dispatchTouchEvent(motionEvent);
        }
        m5719a(motionEvent);
        return true;
    }

    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (!this.f4018d) {
            mergeDrawableStates(onCreateDrawableState, f4015a);
        }
        return onCreateDrawableState;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f4016b != null) {
            this.f4016b.setState(getDrawableState());
            invalidate();
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f4016b;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.f4016b != null) {
            this.f4016b.jumpToCurrentState();
        }
    }

    private void m5719a(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                if (isEnabled() && this.f4018d) {
                    this.f4017c = true;
                }
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                if (isEnabled() && this.f4017c) {
                    m5718a();
                }
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                if (this.f4017c) {
                    this.f4017c = false;
                }
            default:
        }
    }

    private void m5718a() {
        setText("");
    }
}
