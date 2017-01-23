package android.support.v4.view;

import android.view.View;
import android.view.View.AccessibilityDelegate;

class ad {
    public static boolean j6(View view, int i) {
        return view.canScrollHorizontally(i);
    }

    public static boolean DW(View view, int i) {
        return view.canScrollVertically(i);
    }

    public static void j6(View view, Object obj) {
        view.setAccessibilityDelegate((AccessibilityDelegate) obj);
    }
}
