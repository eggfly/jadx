package android.support.v4.view;

import android.view.View;

class ViewCompatMarshmallow {
    ViewCompatMarshmallow() {
    }

    public static int getScrollIndicators(View view) {
        return view.getScrollIndicators();
    }

    static void offsetLeftAndRight(View view, int i) {
        view.offsetLeftAndRight(i);
    }

    static void offsetTopAndBottom(View view, int i) {
        view.offsetTopAndBottom(i);
    }

    public static void setScrollIndicators(View view, int i) {
        view.setScrollIndicators(i);
    }

    public static void setScrollIndicators(View view, int i, int i2) {
        view.setScrollIndicators(i, i2);
    }
}
