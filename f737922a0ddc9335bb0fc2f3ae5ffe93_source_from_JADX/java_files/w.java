import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;

class w {
    public static boolean j6(Object obj, Object obj2) {
        return ((AccessibilityNodeInfo) obj).removeAction((AccessibilityAction) obj2);
    }

    static Object j6(int i, CharSequence charSequence) {
        return new AccessibilityAction(i, charSequence);
    }
}
