package com.miui.support.internal.hybrid;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.miui.support.C0234R;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;

public class WebContainerView extends FrameLayout {
    private boolean f2476a;
    private boolean f2477b;
    private View f2478c;
    private int f2479d;
    private float f2480e;
    private float f2481f;

    public WebContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2477b = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0234R.styleable.HybridViewStyle, 0, 0);
        this.f2476a = obtainStyledAttributes.getBoolean(C0234R.styleable.HybridViewStyle_hybridPullable, true);
        obtainStyledAttributes.recycle();
        this.f2479d = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public void setWebView(View view) {
        if (view != null && this.f2478c != view) {
            if (this.f2478c != null) {
                removeView(this.f2478c);
            }
            this.f2478c = view;
            addView(view, 0, new LayoutParams(-1, -1));
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f2478c == null || !this.f2476a) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (actionMasked == 3 || actionMasked == 1) {
            this.f2477b = false;
            return false;
        }
        switch (actionMasked) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                this.f2480e = rawX;
                this.f2481f = rawY;
                break;
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                if (this.f2477b) {
                    return true;
                }
                float f = this.f2481f - rawY;
                float abs = Math.abs(this.f2480e - rawX);
                float abs2 = Math.abs(f);
                this.f2480e = rawX;
                this.f2481f = rawY;
                if (this.f2478c.getScrollY() == 0 && f < 0.0f && abs2 > abs && abs2 > ((float) this.f2479d)) {
                    this.f2477b = true;
                    return true;
                }
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f2476a && this.f2477b) {
            float rawY = motionEvent.getRawY();
            switch (motionEvent.getAction()) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                    this.f2481f = rawY;
                    break;
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                    this.f2477b = false;
                    m4088a();
                    break;
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    setTranslationY(((rawY - this.f2481f) * 0.5f) + getTranslationY());
                    this.f2481f = rawY;
                    break;
                default:
                    break;
            }
        }
        return false;
    }

    private void m4088a() {
        if (getTranslationY() != 0.0f) {
            ViewPropertyAnimator animate = animate();
            animate.translationY(0.0f);
            animate.setDuration((long) getResources().getInteger(17694721));
            animate.start();
        }
    }
}
