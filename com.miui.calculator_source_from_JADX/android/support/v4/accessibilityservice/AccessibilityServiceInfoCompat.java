package android.support.v4.accessibilityservice;

import android.os.Build.VERSION;

public class AccessibilityServiceInfoCompat {
    private static final AccessibilityServiceInfoVersionImpl f18a;

    interface AccessibilityServiceInfoVersionImpl {
    }

    static class AccessibilityServiceInfoStubImpl implements AccessibilityServiceInfoVersionImpl {
        AccessibilityServiceInfoStubImpl() {
        }
    }

    static class AccessibilityServiceInfoIcsImpl extends AccessibilityServiceInfoStubImpl {
        AccessibilityServiceInfoIcsImpl() {
        }
    }

    static class AccessibilityServiceInfoJellyBeanMr2 extends AccessibilityServiceInfoIcsImpl {
        AccessibilityServiceInfoJellyBeanMr2() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 18) {
            f18a = new AccessibilityServiceInfoJellyBeanMr2();
        } else if (VERSION.SDK_INT >= 14) {
            f18a = new AccessibilityServiceInfoIcsImpl();
        } else {
            f18a = new AccessibilityServiceInfoStubImpl();
        }
    }

    private AccessibilityServiceInfoCompat() {
    }
}
