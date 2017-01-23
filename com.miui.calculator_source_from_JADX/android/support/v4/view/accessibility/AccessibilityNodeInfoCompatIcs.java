package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

class AccessibilityNodeInfoCompatIcs {
    AccessibilityNodeInfoCompatIcs() {
    }

    public static Object m1844a() {
        return AccessibilityNodeInfo.obtain();
    }

    public static Object m1845a(View view) {
        return AccessibilityNodeInfo.obtain(view);
    }

    public static Object m1846a(Object obj) {
        return AccessibilityNodeInfo.obtain((AccessibilityNodeInfo) obj);
    }

    public static void m1847a(Object obj, int i) {
        ((AccessibilityNodeInfo) obj).addAction(i);
    }

    public static void m1849a(Object obj, View view) {
        ((AccessibilityNodeInfo) obj).addChild(view);
    }

    public static int m1852b(Object obj) {
        return ((AccessibilityNodeInfo) obj).getActions();
    }

    public static void m1848a(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).getBoundsInParent(rect);
    }

    public static void m1853b(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).getBoundsInScreen(rect);
    }

    public static CharSequence m1857c(Object obj) {
        return ((AccessibilityNodeInfo) obj).getClassName();
    }

    public static CharSequence m1862d(Object obj) {
        return ((AccessibilityNodeInfo) obj).getContentDescription();
    }

    public static CharSequence m1865e(Object obj) {
        return ((AccessibilityNodeInfo) obj).getPackageName();
    }

    public static CharSequence m1867f(Object obj) {
        return ((AccessibilityNodeInfo) obj).getText();
    }

    public static boolean m1870g(Object obj) {
        return ((AccessibilityNodeInfo) obj).isCheckable();
    }

    public static boolean m1871h(Object obj) {
        return ((AccessibilityNodeInfo) obj).isChecked();
    }

    public static boolean m1872i(Object obj) {
        return ((AccessibilityNodeInfo) obj).isClickable();
    }

    public static boolean m1873j(Object obj) {
        return ((AccessibilityNodeInfo) obj).isEnabled();
    }

    public static boolean m1874k(Object obj) {
        return ((AccessibilityNodeInfo) obj).isFocusable();
    }

    public static boolean m1875l(Object obj) {
        return ((AccessibilityNodeInfo) obj).isFocused();
    }

    public static boolean m1876m(Object obj) {
        return ((AccessibilityNodeInfo) obj).isLongClickable();
    }

    public static boolean m1877n(Object obj) {
        return ((AccessibilityNodeInfo) obj).isPassword();
    }

    public static boolean m1878o(Object obj) {
        return ((AccessibilityNodeInfo) obj).isScrollable();
    }

    public static boolean m1879p(Object obj) {
        return ((AccessibilityNodeInfo) obj).isSelected();
    }

    public static void m1858c(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).setBoundsInParent(rect);
    }

    public static void m1863d(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).setBoundsInScreen(rect);
    }

    public static void m1850a(Object obj, CharSequence charSequence) {
        ((AccessibilityNodeInfo) obj).setClassName(charSequence);
    }

    public static void m1851a(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setClickable(z);
    }

    public static void m1855b(Object obj, CharSequence charSequence) {
        ((AccessibilityNodeInfo) obj).setContentDescription(charSequence);
    }

    public static void m1856b(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setEnabled(z);
    }

    public static void m1861c(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setFocusable(z);
    }

    public static void m1864d(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setFocused(z);
    }

    public static void m1866e(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setLongClickable(z);
    }

    public static void m1860c(Object obj, CharSequence charSequence) {
        ((AccessibilityNodeInfo) obj).setPackageName(charSequence);
    }

    public static void m1854b(Object obj, View view) {
        ((AccessibilityNodeInfo) obj).setParent(view);
    }

    public static void m1868f(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setScrollable(z);
    }

    public static void m1869g(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setSelected(z);
    }

    public static void m1859c(Object obj, View view) {
        ((AccessibilityNodeInfo) obj).setSource(view);
    }

    public static void m1880q(Object obj) {
        ((AccessibilityNodeInfo) obj).recycle();
    }
}
