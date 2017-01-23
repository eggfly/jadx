package android.support.v4.view;

import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

class AccessibilityDelegateCompatIcs {

    public interface AccessibilityDelegateBridge {
        void m1123a(View view, int i);

        void m1124a(View view, Object obj);

        boolean m1125a(View view, AccessibilityEvent accessibilityEvent);

        boolean m1126a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);

        void m1127b(View view, AccessibilityEvent accessibilityEvent);

        void m1128c(View view, AccessibilityEvent accessibilityEvent);

        void m1129d(View view, AccessibilityEvent accessibilityEvent);
    }

    /* renamed from: android.support.v4.view.AccessibilityDelegateCompatIcs.1 */
    final class C00811 extends AccessibilityDelegate {
        final /* synthetic */ AccessibilityDelegateBridge f757a;

        C00811(AccessibilityDelegateBridge accessibilityDelegateBridge) {
            this.f757a = accessibilityDelegateBridge;
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f757a.m1125a(view, accessibilityEvent);
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f757a.m1127b(view, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            this.f757a.m1124a(view, (Object) accessibilityNodeInfo);
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f757a.m1128c(view, accessibilityEvent);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f757a.m1126a(viewGroup, view, accessibilityEvent);
        }

        public void sendAccessibilityEvent(View view, int i) {
            this.f757a.m1123a(view, i);
        }

        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f757a.m1129d(view, accessibilityEvent);
        }
    }

    AccessibilityDelegateCompatIcs() {
    }

    public static Object m1199a() {
        return new AccessibilityDelegate();
    }

    public static Object m1200a(AccessibilityDelegateBridge accessibilityDelegateBridge) {
        return new C00811(accessibilityDelegateBridge);
    }

    public static boolean m1203a(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        return ((AccessibilityDelegate) obj).dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public static void m1205b(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        ((AccessibilityDelegate) obj).onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public static void m1202a(Object obj, View view, Object obj2) {
        ((AccessibilityDelegate) obj).onInitializeAccessibilityNodeInfo(view, (AccessibilityNodeInfo) obj2);
    }

    public static void m1206c(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        ((AccessibilityDelegate) obj).onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public static boolean m1204a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return ((AccessibilityDelegate) obj).onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public static void m1201a(Object obj, View view, int i) {
        ((AccessibilityDelegate) obj).sendAccessibilityEvent(view, i);
    }

    public static void m1207d(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        ((AccessibilityDelegate) obj).sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }
}
