package android.support.v4.view;

import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

class c {

    public interface a {
        void DW(View view, AccessibilityEvent accessibilityEvent);

        void FH(View view, AccessibilityEvent accessibilityEvent);

        void Hw(View view, AccessibilityEvent accessibilityEvent);

        Object j6(View view);

        void j6(View view, int i);

        void j6(View view, Object obj);

        boolean j6(View view, int i, Bundle bundle);

        boolean j6(View view, AccessibilityEvent accessibilityEvent);

        boolean j6(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);
    }

    static class 1 extends AccessibilityDelegate {
        final /* synthetic */ a j6;

        1(a aVar) {
            this.j6 = aVar;
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.j6.j6(view, accessibilityEvent);
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.j6.DW(view, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            this.j6.j6(view, (Object) accessibilityNodeInfo);
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.j6.FH(view, accessibilityEvent);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.j6.j6(viewGroup, view, accessibilityEvent);
        }

        public void sendAccessibilityEvent(View view, int i) {
            this.j6.j6(view, i);
        }

        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.j6.Hw(view, accessibilityEvent);
        }

        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            return (AccessibilityNodeProvider) this.j6.j6(view);
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return this.j6.j6(view, i, bundle);
        }
    }

    public static Object j6(a aVar) {
        return new 1(aVar);
    }

    public static Object j6(Object obj, View view) {
        return ((AccessibilityDelegate) obj).getAccessibilityNodeProvider(view);
    }

    public static boolean j6(Object obj, View view, int i, Bundle bundle) {
        return ((AccessibilityDelegate) obj).performAccessibilityAction(view, i, bundle);
    }
}
