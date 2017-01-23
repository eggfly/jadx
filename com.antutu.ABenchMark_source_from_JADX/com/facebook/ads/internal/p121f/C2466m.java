package com.facebook.ads.internal.p121f;

import android.content.Context;
import android.widget.RelativeLayout;

/* renamed from: com.facebook.ads.internal.f.m */
public class C2466m extends RelativeLayout {
    private int f8493a;
    private int f8494b;

    public C2466m(Context context) {
        super(context);
        this.f8493a = 0;
        this.f8494b = 0;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f8494b > 0 && getMeasuredWidth() > this.f8494b) {
            setMeasuredDimension(this.f8494b, getMeasuredHeight());
        } else if (getMeasuredWidth() < this.f8493a) {
            setMeasuredDimension(this.f8493a, getMeasuredHeight());
        }
    }

    protected void setMaxWidth(int i) {
        this.f8494b = i;
    }

    public void setMinWidth(int i) {
        this.f8493a = i;
    }
}
