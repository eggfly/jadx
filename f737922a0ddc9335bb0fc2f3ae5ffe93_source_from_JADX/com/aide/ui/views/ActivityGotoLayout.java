package com.aide.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

public class ActivityGotoLayout extends ViewGroup {
    public ActivityGotoLayout(Context context) {
        super(context);
    }

    public ActivityGotoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ActivityGotoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i2);
        int size2 = MeasureSpec.getSize(i);
        getChildAt(0).measure(MeasureSpec.makeMeasureSpec((int) DW((float) size2), 1073741824), MeasureSpec.makeMeasureSpec((int) j6((float) size), 1073741824));
        setMeasuredDimension(size2, size);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f = (float) (i3 - i);
        float f2 = (float) (i4 - i2);
        float DW = (f - DW(f)) / 2.0f;
        float j6 = (f2 - j6(f2)) / 2.0f;
        getChildAt(0).layout((int) DW, (int) j6, (int) (f - DW), (int) (f2 - j6));
    }

    private float j6(float f) {
        return Math.min(f, FH(f));
    }

    private float DW(float f) {
        return Math.min(f, Hw(f));
    }

    private float FH(float f) {
        return getContext().getResources().getDisplayMetrics().density * 600.0f;
    }

    private float Hw(float f) {
        return getContext().getResources().getDisplayMetrics().density * 600.0f;
    }
}
