package com.antutu.benchmark.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.C0491i;
import android.support.v7.widget.RecyclerView.C0525n;
import android.support.v7.widget.RecyclerView.C0529r;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

public class MyLinearLayoutManager extends LinearLayoutManager {
    private int[] f5848a;

    public MyLinearLayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
        this.f5848a = new int[2];
    }

    private void m6466a(C0525n c0525n, int i, int i2, int i3, int[] iArr) {
        try {
            View c = c0525n.m1877c(i);
            c0525n.m1869a(c, i);
            if (c != null) {
                C0491i c0491i = (C0491i) c.getLayoutParams();
                c.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight(), c0491i.width), ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom(), c0491i.height));
                iArr[0] = (c.getMeasuredWidth() + c0491i.leftMargin) + c0491i.rightMargin;
                iArr[1] = c0491i.topMargin + (c.getMeasuredHeight() + c0491i.bottomMargin);
                c0525n.m1868a(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onMeasure(C0525n c0525n, C0529r c0529r, int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < getItemCount()) {
            int i6;
            int i7;
            if (getOrientation() == 0) {
                m6466a(c0525n, i3, MeasureSpec.makeMeasureSpec(i3, 0), i2, this.f5848a);
                i6 = i5 + this.f5848a[0];
                i7 = i3 == 0 ? this.f5848a[1] : i4;
            } else {
                m6466a(c0525n, i3, i, MeasureSpec.makeMeasureSpec(i3, 0), this.f5848a);
                i7 = this.f5848a[1] + i4;
                i6 = i3 == 0 ? this.f5848a[0] : i5;
            }
            i3++;
            i4 = i7;
            i5 = i6;
        }
        switch (mode) {
            case 1073741824:
                i5 = size;
                break;
        }
        switch (mode2) {
            case 1073741824:
                i4 = size2;
                break;
        }
        setMeasuredDimension(i5, i4);
    }
}
