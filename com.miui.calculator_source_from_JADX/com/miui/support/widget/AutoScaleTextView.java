package com.miui.support.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.RemotableViewMethod;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import com.miui.support.C0234R;

public class AutoScaleTextView extends TextView {
    private float f3977a;
    private float f3978b;
    private boolean f3979c;

    public AutoScaleTextView(Context context) {
        super(context);
        m5695a();
    }

    public AutoScaleTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5696a(context, attributeSet, 0);
        m5695a();
    }

    public AutoScaleTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5696a(context, attributeSet, 0);
        m5695a();
    }

    private void m5696a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0234R.styleable.AutoScaleTextView, i, 0);
        this.f3978b = (float) obtainStyledAttributes.getDimensionPixelSize(C0234R.styleable.AutoScaleTextView_minTextSize, 0);
        obtainStyledAttributes.recycle();
    }

    @RemotableViewMethod
    public void setMinTextSize(float f) {
        m5697a(2, f);
    }

    public void m5697a(int i, float f) {
        Resources system;
        Context context = getContext();
        if (context == null) {
            system = Resources.getSystem();
        } else {
            system = context.getResources();
        }
        this.f3978b = TypedValue.applyDimension(i, f, system.getDisplayMetrics());
    }

    public float getMinTextSize() {
        return this.f3978b;
    }

    public void setTextSize(float f) {
        super.setTextSize(f);
        m5695a();
    }

    public void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        m5695a();
    }

    private void m5695a() {
        this.f3977a = super.getTextSize();
    }

    public float getTextSize() {
        return this.f3977a;
    }

    protected void onMeasure(int i, int i2) {
        if (this.f3978b <= 0.0f || this.f3978b >= this.f3977a || getMaxLines() > 1) {
            super.onMeasure(i, i2);
        } else if (MeasureSpec.getMode(i) == 0) {
            super.onMeasure(i, i2);
        } else {
            int size = MeasureSpec.getSize(i);
            super.onMeasure(0, i2);
            int measuredWidth = getMeasuredWidth();
            if (measuredWidth > size) {
                int paddingLeft = getPaddingLeft() + getPaddingRight();
                float f = (float) (size - paddingLeft);
                f = (f * super.getTextSize()) / (((float) (measuredWidth - paddingLeft)) + 0.001f);
                if (f < this.f3978b) {
                    f = this.f3978b;
                }
                this.f3979c = true;
                super.setTextSize(0, f);
                this.f3979c = false;
                super.onMeasure(i, i2);
            }
        }
    }

    public void requestLayout() {
        if (!this.f3979c) {
            super.requestLayout();
        }
    }

    public void invalidate() {
        if (!this.f3979c) {
            super.invalidate();
        }
    }
}
