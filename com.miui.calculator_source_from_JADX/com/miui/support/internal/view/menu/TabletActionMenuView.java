package com.miui.support.internal.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.miui.support.internal.view.menu.ActionMenuView.LayoutParams;

public class TabletActionMenuView extends ActionMenuView {
    public TabletActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public int getCollapsedHeight() {
        return getMeasuredHeight();
    }

    public boolean m4590a(int i) {
        LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
        if (layoutParams == null || !layoutParams.f2666a) {
            return super.m4399a(i);
        }
        return false;
    }
}
