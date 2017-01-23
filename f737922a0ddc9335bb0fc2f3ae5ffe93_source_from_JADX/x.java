import android.graphics.Rect;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

class x {
    public static Object j6(Object obj) {
        return AccessibilityNodeInfo.obtain((AccessibilityNodeInfo) obj);
    }

    public static void j6(Object obj, int i) {
        ((AccessibilityNodeInfo) obj).addAction(i);
    }

    public static void j6(Object obj, View view) {
        ((AccessibilityNodeInfo) obj).addChild(view);
    }

    public static int DW(Object obj) {
        return ((AccessibilityNodeInfo) obj).getActions();
    }

    public static void j6(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).getBoundsInParent(rect);
    }

    public static void DW(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).getBoundsInScreen(rect);
    }

    public static CharSequence FH(Object obj) {
        return ((AccessibilityNodeInfo) obj).getClassName();
    }

    public static CharSequence Hw(Object obj) {
        return ((AccessibilityNodeInfo) obj).getContentDescription();
    }

    public static CharSequence v5(Object obj) {
        return ((AccessibilityNodeInfo) obj).getPackageName();
    }

    public static CharSequence Zo(Object obj) {
        return ((AccessibilityNodeInfo) obj).getText();
    }

    public static boolean VH(Object obj) {
        return ((AccessibilityNodeInfo) obj).isCheckable();
    }

    public static boolean gn(Object obj) {
        return ((AccessibilityNodeInfo) obj).isChecked();
    }

    public static boolean u7(Object obj) {
        return ((AccessibilityNodeInfo) obj).isClickable();
    }

    public static boolean tp(Object obj) {
        return ((AccessibilityNodeInfo) obj).isEnabled();
    }

    public static boolean EQ(Object obj) {
        return ((AccessibilityNodeInfo) obj).isFocusable();
    }

    public static boolean we(Object obj) {
        return ((AccessibilityNodeInfo) obj).isFocused();
    }

    public static boolean J0(Object obj) {
        return ((AccessibilityNodeInfo) obj).isLongClickable();
    }

    public static boolean J8(Object obj) {
        return ((AccessibilityNodeInfo) obj).isPassword();
    }

    public static boolean Ws(Object obj) {
        return ((AccessibilityNodeInfo) obj).isScrollable();
    }

    public static boolean QX(Object obj) {
        return ((AccessibilityNodeInfo) obj).isSelected();
    }

    public static void FH(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).setBoundsInParent(rect);
    }

    public static void Hw(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).setBoundsInScreen(rect);
    }

    public static void j6(Object obj, CharSequence charSequence) {
        ((AccessibilityNodeInfo) obj).setClassName(charSequence);
    }

    public static void j6(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setClickable(z);
    }

    public static void DW(Object obj, CharSequence charSequence) {
        ((AccessibilityNodeInfo) obj).setContentDescription(charSequence);
    }

    public static void DW(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setEnabled(z);
    }

    public static void FH(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setFocusable(z);
    }

    public static void Hw(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setFocused(z);
    }

    public static void v5(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setLongClickable(z);
    }

    public static void FH(Object obj, CharSequence charSequence) {
        ((AccessibilityNodeInfo) obj).setPackageName(charSequence);
    }

    public static void DW(Object obj, View view) {
        ((AccessibilityNodeInfo) obj).setParent(view);
    }

    public static void Zo(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setScrollable(z);
    }

    public static void VH(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setSelected(z);
    }

    public static void FH(Object obj, View view) {
        ((AccessibilityNodeInfo) obj).setSource(view);
    }

    public static void XL(Object obj) {
        ((AccessibilityNodeInfo) obj).recycle();
    }
}
