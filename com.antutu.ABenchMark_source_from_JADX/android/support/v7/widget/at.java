package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

public class at extends AccessibilityDelegateCompat {
    final RecyclerView f1889a;
    final AccessibilityDelegateCompat f1890b;

    /* renamed from: android.support.v7.widget.at.1 */
    class C05861 extends AccessibilityDelegateCompat {
        final /* synthetic */ at f1888a;

        C05861(at atVar) {
            this.f1888a = atVar;
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (!this.f1888a.m2425b() && this.f1888a.f1889a.getLayoutManager() != null) {
                this.f1888a.f1889a.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
            }
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return super.performAccessibilityAction(view, i, bundle) ? true : (this.f1888a.m2425b() || this.f1888a.f1889a.getLayoutManager() == null) ? false : this.f1888a.f1889a.getLayoutManager().performAccessibilityActionForItem(view, i, bundle);
        }
    }

    public at(RecyclerView recyclerView) {
        this.f1890b = new C05861(this);
        this.f1889a = recyclerView;
    }

    private boolean m2425b() {
        return this.f1889a.hasPendingAdapterUpdates();
    }

    AccessibilityDelegateCompat m2426a() {
        return this.f1890b;
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if ((view instanceof RecyclerView) && !m2425b()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().onInitializeAccessibilityEvent(accessibilityEvent);
            }
        }
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setClassName(RecyclerView.class.getName());
        if (!m2425b() && this.f1889a.getLayoutManager() != null) {
            this.f1889a.getLayoutManager().onInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat);
        }
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        return super.performAccessibilityAction(view, i, bundle) ? true : (m2425b() || this.f1889a.getLayoutManager() == null) ? false : this.f1889a.getLayoutManager().performAccessibilityAction(i, bundle);
    }
}
