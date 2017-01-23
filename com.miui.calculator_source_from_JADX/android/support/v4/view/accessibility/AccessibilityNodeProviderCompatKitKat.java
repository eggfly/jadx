package android.support.v4.view.accessibility;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

class AccessibilityNodeProviderCompatKitKat {

    interface AccessibilityNodeInfoBridge {
        Object m1899a(int i);

        List<Object> m1900a(String str, int i);

        boolean m1901a(int i, int i2, Bundle bundle);

        Object m1902b(int i);
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeProviderCompatKitKat.1 */
    final class C01031 extends AccessibilityNodeProvider {
        final /* synthetic */ AccessibilityNodeInfoBridge f956a;

        C01031(AccessibilityNodeInfoBridge accessibilityNodeInfoBridge) {
            this.f956a = accessibilityNodeInfoBridge;
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            return (AccessibilityNodeInfo) this.f956a.m1899a(i);
        }

        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            return this.f956a.m1900a(str, i);
        }

        public boolean performAction(int i, int i2, Bundle bundle) {
            return this.f956a.m1901a(i, i2, bundle);
        }

        public AccessibilityNodeInfo findFocus(int i) {
            return (AccessibilityNodeInfo) this.f956a.m1902b(i);
        }
    }

    AccessibilityNodeProviderCompatKitKat() {
    }

    public static Object m1914a(AccessibilityNodeInfoBridge accessibilityNodeInfoBridge) {
        return new C01031(accessibilityNodeInfoBridge);
    }
}
