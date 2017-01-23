package android.support.v4.view.accessibility;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

class AccessibilityNodeProviderCompatJellyBean {

    interface AccessibilityNodeInfoBridge {
        Object m1891a(int i);

        List<Object> m1892a(String str, int i);

        boolean m1893a(int i, int i2, Bundle bundle);
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeProviderCompatJellyBean.1 */
    final class C01021 extends AccessibilityNodeProvider {
        final /* synthetic */ AccessibilityNodeInfoBridge f955a;

        C01021(AccessibilityNodeInfoBridge accessibilityNodeInfoBridge) {
            this.f955a = accessibilityNodeInfoBridge;
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            return (AccessibilityNodeInfo) this.f955a.m1891a(i);
        }

        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            return this.f955a.m1892a(str, i);
        }

        public boolean performAction(int i, int i2, Bundle bundle) {
            return this.f955a.m1893a(i, i2, bundle);
        }
    }

    AccessibilityNodeProviderCompatJellyBean() {
    }

    public static Object m1913a(AccessibilityNodeInfoBridge accessibilityNodeInfoBridge) {
        return new C01021(accessibilityNodeInfoBridge);
    }
}
