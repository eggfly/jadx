package com.antutu.benchmark.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class BaseViewPager extends ViewPager {
    private boolean f5693a;

    public BaseViewPager(Context context) {
        super(context);
        this.f5693a = true;
    }

    public BaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5693a = true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f5693a ? super.onInterceptTouchEvent(motionEvent) : false;
    }

    public void setScrollable(boolean z) {
        this.f5693a = z;
    }
}
