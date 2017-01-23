package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

class ae {
    public static void j6(View view) {
        view.postInvalidateOnAnimation();
    }

    public static void j6(View view, int i, int i2, int i3, int i4) {
        view.postInvalidate(i, i2, i3, i4);
    }

    public static void j6(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static int DW(View view) {
        return view.getImportantForAccessibility();
    }

    public static void j6(View view, int i) {
        view.setImportantForAccessibility(i);
    }

    public static ViewParent FH(View view) {
        return view.getParentForAccessibility();
    }

    public static boolean Hw(View view) {
        return view.getFitsSystemWindows();
    }

    public static boolean v5(View view) {
        return view.hasOverlappingRendering();
    }
}
