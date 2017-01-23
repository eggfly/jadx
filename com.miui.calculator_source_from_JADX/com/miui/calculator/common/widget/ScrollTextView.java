package com.miui.calculator.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.TextView.BufferType;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;

public class ScrollTextView extends EditText {
    private boolean f1497a;

    public ScrollTextView(Context context) {
        this(context, null);
    }

    public ScrollTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrollTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setSingleLine();
        setGravity(5);
        setFocusable(false);
        setBackground(null);
        setCursorVisible(false);
        setKeyListener(null);
        setInputType(0);
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        super.setText(charSequence, bufferType);
        if (charSequence != null) {
            setSelection(charSequence.length());
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        switch (motionEvent.getActionMasked()) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                this.f1497a = true;
                break;
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                this.f1497a = false;
                setClickable(true);
                setLongClickable(true);
                break;
        }
        return onTouchEvent;
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.f1497a) {
            setClickable(false);
            setLongClickable(false);
        }
    }
}
