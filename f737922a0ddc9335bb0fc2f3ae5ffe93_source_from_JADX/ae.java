import android.view.accessibility.AccessibilityRecord;

class ae {
    public static Object j6() {
        return AccessibilityRecord.obtain();
    }

    public static void j6(Object obj, int i) {
        ((AccessibilityRecord) obj).setFromIndex(i);
    }

    public static void DW(Object obj, int i) {
        ((AccessibilityRecord) obj).setItemCount(i);
    }

    public static void FH(Object obj, int i) {
        ((AccessibilityRecord) obj).setScrollX(i);
    }

    public static void Hw(Object obj, int i) {
        ((AccessibilityRecord) obj).setScrollY(i);
    }

    public static void j6(Object obj, boolean z) {
        ((AccessibilityRecord) obj).setScrollable(z);
    }

    public static void v5(Object obj, int i) {
        ((AccessibilityRecord) obj).setToIndex(i);
    }
}
