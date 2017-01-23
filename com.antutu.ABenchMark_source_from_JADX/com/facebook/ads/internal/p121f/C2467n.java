package com.facebook.ads.internal.p121f;

import android.content.Context;
import android.view.View.MeasureSpec;
import android.widget.ImageView;

/* renamed from: com.facebook.ads.internal.f.n */
public class C2467n extends ImageView {
    public C2467n(Context context) {
        super(context);
    }

    protected void onMeasure(int i, int i2) {
        if (MeasureSpec.getMode(i) == 1073741824) {
            i2 = i;
        } else if (MeasureSpec.getMode(i2) == 1073741824) {
            i = i2;
        }
        super.onMeasure(i, i2);
    }
}
