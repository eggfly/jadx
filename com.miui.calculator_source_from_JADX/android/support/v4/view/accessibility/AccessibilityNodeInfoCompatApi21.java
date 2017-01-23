package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;

class AccessibilityNodeInfoCompatApi21 {

    static class CollectionItemInfo {
        CollectionItemInfo() {
        }
    }

    AccessibilityNodeInfoCompatApi21() {
    }

    public static boolean m1843a(Object obj, Object obj2) {
        return ((AccessibilityNodeInfo) obj).removeAction((AccessibilityAction) obj2);
    }

    static Object m1842a(int i, CharSequence charSequence) {
        return new AccessibilityAction(i, charSequence);
    }
}
