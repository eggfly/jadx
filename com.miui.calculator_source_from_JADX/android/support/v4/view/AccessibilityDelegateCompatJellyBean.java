package android.support.v4.view;

import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

class AccessibilityDelegateCompatJellyBean {

    public interface AccessibilityDelegateBridgeJellyBean {
        Object m1168a(View view);

        void m1169a(View view, int i);

        void m1170a(View view, Object obj);

        boolean m1171a(View view, int i, Bundle bundle);

        boolean m1172a(View view, AccessibilityEvent accessibilityEvent);

        boolean m1173a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);

        void m1174b(View view, AccessibilityEvent accessibilityEvent);

        void m1175c(View view, AccessibilityEvent accessibilityEvent);

        void m1176d(View view, AccessibilityEvent accessibilityEvent);
    }

    /* renamed from: android.support.v4.view.AccessibilityDelegateCompatJellyBean.1 */
    final class C00821 extends AccessibilityDelegate {
        final /* synthetic */ AccessibilityDelegateBridgeJellyBean f758a;

        C00821(AccessibilityDelegateBridgeJellyBean accessibilityDelegateBridgeJellyBean) {
            this.f758a = accessibilityDelegateBridgeJellyBean;
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f758a.m1172a(view, accessibilityEvent);
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f758a.m1174b(view, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            this.f758a.m1170a(view, (Object) accessibilityNodeInfo);
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f758a.m1175c(view, accessibilityEvent);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f758a.m1173a(viewGroup, view, accessibilityEvent);
        }

        public void sendAccessibilityEvent(View view, int i) {
            this.f758a.m1169a(view, i);
        }

        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f758a.m1176d(view, accessibilityEvent);
        }

        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            return (AccessibilityNodeProvider) this.f758a.m1168a(view);
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return this.f758a.m1171a(view, i, bundle);
        }
    }

    AccessibilityDelegateCompatJellyBean() {
    }

    public static Object m1208a(AccessibilityDelegateBridgeJellyBean accessibilityDelegateBridgeJellyBean) {
        return new C00821(accessibilityDelegateBridgeJellyBean);
    }

    public static Object m1209a(Object obj, View view) {
        return ((AccessibilityDelegate) obj).getAccessibilityNodeProvider(view);
    }

    public static boolean m1210a(Object obj, View view, int i, Bundle bundle) {
        return ((AccessibilityDelegate) obj).performAccessibilityAction(view, i, bundle);
    }
}
