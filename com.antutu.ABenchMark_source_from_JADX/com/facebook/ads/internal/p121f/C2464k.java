package com.facebook.ads.internal.p121f;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.View.MeasureSpec;
import android.widget.TextView;

/* renamed from: com.facebook.ads.internal.f.k */
public class C2464k extends TextView {
    private int f8488a;
    private float f8489b;
    private float f8490c;

    public C2464k(Context context, int i) {
        super(context);
        this.f8490c = 8.0f;
        setMaxLines(i);
        setEllipsize(TruncateAt.END);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.setMaxLines(this.f8488a + 1);
        super.setTextSize(this.f8489b);
        int i5 = i3 - i;
        int i6 = i4 - i2;
        measure(MeasureSpec.makeMeasureSpec(i5, 1073741824), MeasureSpec.makeMeasureSpec(i6, 0));
        if (getMeasuredHeight() > i6) {
            float f = this.f8489b;
            while (f > this.f8490c) {
                f -= 0.5f;
                super.setTextSize(f);
                measure(MeasureSpec.makeMeasureSpec(i5, 1073741824), 0);
                if (getMeasuredHeight() <= i6 && getLineCount() <= this.f8488a) {
                    break;
                }
            }
        }
        super.setMaxLines(this.f8488a);
        setMeasuredDimension(i5, i6);
        super.onLayout(z, i, i2, i3, i4);
    }

    public void setMaxLines(int i) {
        this.f8488a = i;
        super.setMaxLines(i);
    }

    public void setMinTextSize(float f) {
        this.f8490c = f;
    }

    public void setTextSize(float f) {
        this.f8489b = f;
        super.setTextSize(f);
    }
}
