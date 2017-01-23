package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.view.accessibility.AccessibilityWindowInfo;

class AccessibilityWindowInfoCompatApi21 {
    AccessibilityWindowInfoCompatApi21() {
    }

    public static int m1999a(Object obj) {
        return ((AccessibilityWindowInfo) obj).getType();
    }

    public static int m2001b(Object obj) {
        return ((AccessibilityWindowInfo) obj).getLayer();
    }

    public static Object m2002c(Object obj) {
        return ((AccessibilityWindowInfo) obj).getParent();
    }

    public static int m2003d(Object obj) {
        return ((AccessibilityWindowInfo) obj).getId();
    }

    public static void m2000a(Object obj, Rect rect) {
        ((AccessibilityWindowInfo) obj).getBoundsInScreen(rect);
    }

    public static boolean m2004e(Object obj) {
        return ((AccessibilityWindowInfo) obj).isActive();
    }

    public static boolean m2005f(Object obj) {
        return ((AccessibilityWindowInfo) obj).isFocused();
    }

    public static int m2006g(Object obj) {
        return ((AccessibilityWindowInfo) obj).getChildCount();
    }
}
