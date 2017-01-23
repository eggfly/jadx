package com.aide.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.SlidingDrawer;

public class WrappingSlidingDrawer extends SlidingDrawer {
    private int DW;
    private boolean j6;

    public WrappingSlidingDrawer(Context context, AttributeSet attributeSet, int i) {
        boolean z = true;
        super(context, attributeSet, i);
        int attributeIntValue = attributeSet.getAttributeIntValue("android", "orientation", 1);
        this.DW = attributeSet.getAttributeIntValue("android", "topOffset", 0);
        if (attributeIntValue != 1) {
            z = false;
        }
        this.j6 = z;
    }

    public WrappingSlidingDrawer(Context context, AttributeSet attributeSet) {
        boolean z = true;
        super(context, attributeSet);
        int attributeIntValue = attributeSet.getAttributeIntValue("android", "orientation", 1);
        this.DW = attributeSet.getAttributeIntValue("android", "topOffset", 0);
        if (attributeIntValue != 1) {
            z = false;
        }
        this.j6 = z;
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (mode == 0 || mode2 == 0) {
            throw new RuntimeException("SlidingDrawer cannot have UNSPECIFIED dimensions");
        }
        View handle = getHandle();
        View content = getContent();
        measureChild(handle, i, i2);
        if (this.j6) {
            content.measure(i, MeasureSpec.makeMeasureSpec((size2 - handle.getMeasuredHeight()) - this.DW, mode2));
            size = content.getMeasuredHeight() + (handle.getMeasuredHeight() + this.DW);
            mode = content.getMeasuredWidth();
            if (handle.getMeasuredWidth() > mode) {
                mode = handle.getMeasuredWidth();
            }
            int i3 = size;
            size = mode;
            mode = i3;
        } else {
            content.measure(MeasureSpec.makeMeasureSpec((size - handle.getMeasuredWidth()) - this.DW, mode), i2);
            size = content.getMeasuredWidth() + (handle.getMeasuredWidth() + this.DW);
            mode = content.getMeasuredHeight();
            if (handle.getMeasuredHeight() > mode) {
                mode = handle.getMeasuredHeight();
            }
        }
        setMeasuredDimension(size, mode);
    }
}
