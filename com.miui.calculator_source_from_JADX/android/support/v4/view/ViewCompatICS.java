package android.support.v4.view;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

class ViewCompatICS {
    ViewCompatICS() {
    }

    public static boolean m1489a(View view, int i) {
        return view.canScrollHorizontally(i);
    }

    public static boolean m1491b(View view, int i) {
        return view.canScrollVertically(i);
    }

    public static void m1488a(View view, @Nullable Object obj) {
        view.setAccessibilityDelegate((AccessibilityDelegate) obj);
    }

    public static void m1487a(View view, AccessibilityEvent accessibilityEvent) {
        view.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public static void m1490b(View view, Object obj) {
        view.onInitializeAccessibilityNodeInfo((AccessibilityNodeInfo) obj);
    }
}
