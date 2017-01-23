package android.support.v4.view.accessibility;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityManager;

public class AccessibilityManagerCompat {
    private static final AccessibilityManagerVersionImpl f922a;

    interface AccessibilityManagerVersionImpl {
        Object m1635a(AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat);

        boolean m1636a(AccessibilityManager accessibilityManager);
    }

    static class AccessibilityManagerStubImpl implements AccessibilityManagerVersionImpl {
        AccessibilityManagerStubImpl() {
        }

        public Object m1637a(AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
            return null;
        }

        public boolean m1638a(AccessibilityManager accessibilityManager) {
            return false;
        }
    }

    static class AccessibilityManagerIcsImpl extends AccessibilityManagerStubImpl {

        /* renamed from: android.support.v4.view.accessibility.AccessibilityManagerCompat.AccessibilityManagerIcsImpl.1 */
        class C00971 implements AccessibilityStateChangeListenerBridge {
            final /* synthetic */ AccessibilityStateChangeListenerCompat f919a;
            final /* synthetic */ AccessibilityManagerIcsImpl f920b;

            C00971(AccessibilityManagerIcsImpl accessibilityManagerIcsImpl, AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
                this.f920b = accessibilityManagerIcsImpl;
                this.f919a = accessibilityStateChangeListenerCompat;
            }

            public void m1634a(boolean z) {
                this.f919a.m1641a(z);
            }
        }

        AccessibilityManagerIcsImpl() {
        }

        public Object m1639a(AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
            return AccessibilityManagerCompatIcs.m1644a(new C00971(this, accessibilityStateChangeListenerCompat));
        }

        public boolean m1640a(AccessibilityManager accessibilityManager) {
            return AccessibilityManagerCompatIcs.m1645a(accessibilityManager);
        }
    }

    public static abstract class AccessibilityStateChangeListenerCompat {
        final Object f921a;

        public abstract void m1641a(boolean z);

        public AccessibilityStateChangeListenerCompat() {
            this.f921a = AccessibilityManagerCompat.f922a.m1635a(this);
        }
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            f922a = new AccessibilityManagerIcsImpl();
        } else {
            f922a = new AccessibilityManagerStubImpl();
        }
    }

    public static boolean m1643a(AccessibilityManager accessibilityManager) {
        return f922a.m1636a(accessibilityManager);
    }
}
