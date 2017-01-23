package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener;

class AccessibilityManagerCompatIcs {

    interface AccessibilityStateChangeListenerBridge {
        void m1633a(boolean z);
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityManagerCompatIcs.1 */
    final class C00981 implements AccessibilityStateChangeListener {
        final /* synthetic */ AccessibilityStateChangeListenerBridge f923a;

        C00981(AccessibilityStateChangeListenerBridge accessibilityStateChangeListenerBridge) {
            this.f923a = accessibilityStateChangeListenerBridge;
        }

        public void onAccessibilityStateChanged(boolean z) {
            this.f923a.m1633a(z);
        }
    }

    AccessibilityManagerCompatIcs() {
    }

    public static Object m1644a(AccessibilityStateChangeListenerBridge accessibilityStateChangeListenerBridge) {
        return new C00981(accessibilityStateChangeListenerBridge);
    }

    public static boolean m1645a(AccessibilityManager accessibilityManager) {
        return accessibilityManager.isTouchExplorationEnabled();
    }
}
