package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityRecord;

class AccessibilityRecordCompatIcs {
    AccessibilityRecordCompatIcs() {
    }

    public static Object m1955a() {
        return AccessibilityRecord.obtain();
    }

    public static void m1956a(Object obj, int i) {
        ((AccessibilityRecord) obj).setFromIndex(i);
    }

    public static void m1958b(Object obj, int i) {
        ((AccessibilityRecord) obj).setItemCount(i);
    }

    public static void m1959c(Object obj, int i) {
        ((AccessibilityRecord) obj).setScrollX(i);
    }

    public static void m1960d(Object obj, int i) {
        ((AccessibilityRecord) obj).setScrollY(i);
    }

    public static void m1957a(Object obj, boolean z) {
        ((AccessibilityRecord) obj).setScrollable(z);
    }

    public static void m1961e(Object obj, int i) {
        ((AccessibilityRecord) obj).setToIndex(i);
    }
}
