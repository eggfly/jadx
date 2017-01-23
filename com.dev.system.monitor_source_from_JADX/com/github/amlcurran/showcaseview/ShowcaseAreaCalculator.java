package com.github.amlcurran.showcaseview;

import android.graphics.Rect;
import android.util.Log;

class ShowcaseAreaCalculator {
    private final Rect mShowcaseRect;

    ShowcaseAreaCalculator() {
        this.mShowcaseRect = new Rect();
    }

    public boolean calculateShowcaseRect(float x, float y, ShowcaseDrawer showcaseDrawer) {
        int cx = (int) x;
        int cy = (int) y;
        int dw = showcaseDrawer.getShowcaseWidth();
        int dh = showcaseDrawer.getShowcaseHeight();
        if (this.mShowcaseRect.left == cx - (dw / 2) && this.mShowcaseRect.top == cy - (dh / 2)) {
            return false;
        }
        Log.d("ShowcaseView", "Recalculated");
        this.mShowcaseRect.left = cx - (dw / 2);
        this.mShowcaseRect.top = cy - (dh / 2);
        this.mShowcaseRect.right = (dw / 2) + cx;
        this.mShowcaseRect.bottom = (dh / 2) + cy;
        return true;
    }

    public Rect getShowcaseRect() {
        return this.mShowcaseRect;
    }
}
