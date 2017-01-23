package android.support.v4.view.accessibility;

import android.view.View;
import android.view.accessibility.AccessibilityRecord;

class AccessibilityRecordCompatJellyBean {
    AccessibilityRecordCompatJellyBean() {
    }

    public static void m1964a(Object obj, View view, int i) {
        ((AccessibilityRecord) obj).setSource(view, i);
    }
}
