package android.support.v4.view;

import android.view.View;

class ag {
    public static void j6(View view, float f) {
        view.setElevation(f);
    }

    public static float j6(View view) {
        return view.getElevation();
    }

    public static boolean DW(View view) {
        return view.isNestedScrollingEnabled();
    }

    public static void FH(View view) {
        view.stopNestedScroll();
    }
}
