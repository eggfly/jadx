package android.support.v4.view.accessibility;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;

public class AccessibilityEventCompat {
    private static final AccessibilityEventVersionImpl f918a;

    interface AccessibilityEventVersionImpl {
    }

    static class AccessibilityEventStubImpl implements AccessibilityEventVersionImpl {
        AccessibilityEventStubImpl() {
        }
    }

    static class AccessibilityEventIcsImpl extends AccessibilityEventStubImpl {
        AccessibilityEventIcsImpl() {
        }
    }

    static class AccessibilityEventKitKatImpl extends AccessibilityEventIcsImpl {
        AccessibilityEventKitKatImpl() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            f918a = new AccessibilityEventKitKatImpl();
        } else if (VERSION.SDK_INT >= 14) {
            f918a = new AccessibilityEventIcsImpl();
        } else {
            f918a = new AccessibilityEventStubImpl();
        }
    }

    private AccessibilityEventCompat() {
    }

    public static AccessibilityRecordCompat m1632a(AccessibilityEvent accessibilityEvent) {
        return new AccessibilityRecordCompat(accessibilityEvent);
    }
}
