package com.facebook.ads.internal.p121f;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.View.MeasureSpec;
import android.widget.TextView;

/* renamed from: com.facebook.ads.internal.f.l */
public class C2465l extends TextView {
    private float f8491a;
    private float f8492b;

    public C2465l(Context context) {
        super(context);
        this.f8492b = 8.0f;
        super.setSingleLine();
        super.setMaxLines(1);
        this.f8491a = getTextSize() / context.getResources().getDisplayMetrics().density;
        setEllipsize(TruncateAt.END);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        for (float f = this.f8491a; f >= this.f8492b; f -= 0.5f) {
            super.setTextSize(f);
            measure(0, 0);
            if (getMeasuredWidth() <= i5) {
                break;
            }
        }
        if (getMeasuredWidth() > i5) {
            measure(MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
        super.onLayout(z, i, i2, i3, i4);
    }

    public void setMaxLines(int i) {
    }

    public void setMinTextSize(float f) {
        if (f <= this.f8491a) {
            this.f8492b = f;
        }
    }

    public void setSingleLine(boolean z) {
    }

    public void setTextSize(float f) {
        this.f8491a = f;
        super.setTextSize(f);
    }
}
