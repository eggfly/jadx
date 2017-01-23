package com.antutu.benchmark.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class MainViewPager extends ViewPager {
    private boolean f5806a;

    public MainViewPager(Context context) {
        super(context);
        this.f5806a = false;
    }

    public MainViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5806a = false;
    }

    public boolean m6435a() {
        return this.f5806a;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.f5806a) {
            try {
                z = super.onInterceptTouchEvent(motionEvent);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        return z;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f5806a ? super.onTouchEvent(motionEvent) : false;
    }

    public void setCanScroll(boolean z) {
        this.f5806a = z;
    }

    public void setCurrentItem(int i) {
        super.setCurrentItem(i, m6435a());
    }
}
