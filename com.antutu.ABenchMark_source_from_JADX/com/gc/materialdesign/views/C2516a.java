package com.gc.materialdesign.views;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.gc.materialdesign.C2513R;
import com.gc.materialdesign.p135a.C2514a;

/* renamed from: com.gc.materialdesign.views.a */
public abstract class C2516a extends C2515b {
    int f8632a;
    int f8633b;
    int f8634c;
    float f8635d;
    int f8636e;
    Integer f8637f;
    OnClickListener f8638g;
    boolean f8639h;
    int f8640i;
    TextView f8641j;
    float f8642k;
    float f8643l;
    float f8644m;

    public C2516a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8635d = 12.0f;
        this.f8636e = 3;
        this.f8639h = true;
        this.f8640i = Color.parseColor("#1E88E5");
        this.f8642k = -1.0f;
        this.f8643l = -1.0f;
        this.f8644m = -1.0f;
        m9524a();
        this.f8639h = attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res-auto", "animate", true);
        setAttributes(attributeSet);
        this.p = this.f8640i;
        if (this.f8637f == null) {
            this.f8637f = Integer.valueOf(m9525b());
        }
    }

    protected void m9524a() {
        setMinimumHeight(C2514a.m9521a((float) this.f8633b, getResources()));
        setMinimumWidth(C2514a.m9521a((float) this.f8632a, getResources()));
        setBackgroundResource(this.f8634c);
        setBackgroundColor(this.f8640i);
    }

    protected int m9525b() {
        int i = 0;
        int i2 = (this.f8640i >> 16) & MotionEventCompat.ACTION_MASK;
        int i3 = (this.f8640i >> 8) & MotionEventCompat.ACTION_MASK;
        int i4 = (this.f8640i >> 0) & MotionEventCompat.ACTION_MASK;
        int i5 = i2 + -30 < 0 ? 0 : i2 - 30;
        i2 = i3 + -30 < 0 ? 0 : i3 - 30;
        if (i4 - 30 >= 0) {
            i = i4 - 30;
        }
        return Color.rgb(i5, i2, i);
    }

    public float getRippleSpeed() {
        return this.f8635d;
    }

    public String getText() {
        return this.f8641j.getText().toString();
    }

    public TextView getTextView() {
        return this.f8641j;
    }

    protected void onFocusChanged(boolean z, int i, Rect rect) {
        if (!z) {
            this.f8642k = -1.0f;
            this.f8643l = -1.0f;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        invalidate();
        if (isEnabled()) {
            this.q = true;
            if (motionEvent.getAction() == 0) {
                this.f8644m = (float) (getHeight() / this.f8636e);
                this.f8642k = motionEvent.getX();
                this.f8643l = motionEvent.getY();
            } else if (motionEvent.getAction() == 2) {
                this.f8644m = (float) (getHeight() / this.f8636e);
                this.f8642k = motionEvent.getX();
                this.f8643l = motionEvent.getY();
                if (motionEvent.getX() > ((float) getWidth()) || motionEvent.getX() < 0.0f || motionEvent.getY() > ((float) getHeight()) || motionEvent.getY() < 0.0f) {
                    this.q = false;
                    this.f8642k = -1.0f;
                    this.f8643l = -1.0f;
                }
            } else if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() > ((float) getWidth()) || motionEvent.getX() < 0.0f || motionEvent.getY() > ((float) getHeight()) || motionEvent.getY() < 0.0f) {
                    this.q = false;
                    this.f8642k = -1.0f;
                    this.f8643l = -1.0f;
                } else {
                    this.f8644m += 1.0f;
                    if (!(this.f8639h || this.f8638g == null)) {
                        this.f8638g.onClick(this);
                    }
                }
            } else if (motionEvent.getAction() == 3) {
                this.q = false;
                this.f8642k = -1.0f;
                this.f8643l = -1.0f;
            }
        }
        return true;
    }

    protected abstract void setAttributes(AttributeSet attributeSet);

    public void setBackgroundColor(int i) {
        this.f8640i = i;
        if (isEnabled()) {
            this.p = this.f8640i;
        }
        try {
            ((GradientDrawable) ((LayerDrawable) getBackground()).findDrawableByLayerId(C2513R.id.shape_bacground)).setColor(this.f8640i);
            this.f8637f = Integer.valueOf(m9525b());
        } catch (Exception e) {
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.f8638g = onClickListener;
    }

    public void setRippleSpeed(float f) {
        this.f8635d = f;
    }

    public void setText(String str) {
        this.f8641j.setText(str);
    }

    public void setTextColor(int i) {
        this.f8641j.setTextColor(i);
    }
}
