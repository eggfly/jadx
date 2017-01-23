package android.support.v4.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewParentCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityManagerCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat {
    private static final String f1080b;
    private final Rect f1081c;
    private final Rect f1082d;
    private final Rect f1083e;
    private final int[] f1084f;
    private final AccessibilityManager f1085g;
    private final View f1086h;
    private ExploreByTouchNodeProvider f1087i;
    private int f1088j;

    private class ExploreByTouchNodeProvider extends AccessibilityNodeProviderCompat {
        final /* synthetic */ ExploreByTouchHelper f1079a;

        private ExploreByTouchNodeProvider(ExploreByTouchHelper exploreByTouchHelper) {
            this.f1079a = exploreByTouchHelper;
        }

        public AccessibilityNodeInfoCompat m2206a(int i) {
            return this.f1079a.m2214b(i);
        }

        public boolean m2207a(int i, int i2, Bundle bundle) {
            return this.f1079a.m2216b(i, i2, bundle);
        }
    }

    protected abstract void m2225a(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

    protected abstract void m2226a(int i, AccessibilityEvent accessibilityEvent);

    protected abstract void m2228a(List<Integer> list);

    protected abstract boolean m2230a(int i, int i2, Bundle bundle);

    static {
        f1080b = View.class.getName();
    }

    public AccessibilityNodeProviderCompat m2224a(View view) {
        if (this.f1087i == null) {
            this.f1087i = new ExploreByTouchNodeProvider();
        }
        return this.f1087i;
    }

    public boolean m2229a(int i, int i2) {
        if (i == Integer.MIN_VALUE || !this.f1085g.isEnabled()) {
            return false;
        }
        ViewParent parent = this.f1086h.getParent();
        if (parent == null) {
            return false;
        }
        return ViewParentCompat.m1605a(parent, this.f1086h, m2215b(i, i2));
    }

    private AccessibilityEvent m2215b(int i, int i2) {
        switch (i) {
            case -1:
                return m2209a(i2);
            default:
                return m2218c(i, i2);
        }
    }

    private AccessibilityEvent m2209a(int i) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i);
        ViewCompat.m1452a(this.f1086h, obtain);
        return obtain;
    }

    private AccessibilityEvent m2218c(int i, int i2) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        obtain.setEnabled(true);
        obtain.setClassName(f1080b);
        m2226a(i, obtain);
        if (obtain.getText().isEmpty() && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        obtain.setPackageName(this.f1086h.getContext().getPackageName());
        AccessibilityEventCompat.m1632a(obtain).m1947a(this.f1086h, i);
        return obtain;
    }

    private AccessibilityNodeInfoCompat m2214b(int i) {
        switch (i) {
            case -1:
                return m2213b();
            default:
                return m2217c(i);
        }
    }

    private AccessibilityNodeInfoCompat m2213b() {
        AccessibilityNodeInfoCompat a = AccessibilityNodeInfoCompat.m1792a(this.f1086h);
        ViewCompat.m1451a(this.f1086h, a);
        m2227a(a);
        List linkedList = new LinkedList();
        m2228a(linkedList);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            a.m1807b(this.f1086h, ((Integer) it.next()).intValue());
        }
        return a;
    }

    private AccessibilityNodeInfoCompat m2217c(int i) {
        AccessibilityNodeInfoCompat b = AccessibilityNodeInfoCompat.m1794b();
        b.m1825h(true);
        b.m1808b(f1080b);
        m2225a(i, b);
        if (b.m1838s() == null && b.m1839t() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        b.m1799a(this.f1082d);
        if (this.f1082d.isEmpty()) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int c = b.m1810c();
        if ((c & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        } else if ((c & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        } else {
            b.m1801a(this.f1086h.getContext().getPackageName());
            b.m1800a(this.f1086h, i);
            b.m1817d(this.f1086h);
            if (this.f1088j == i) {
                b.m1818d(true);
                b.m1798a(128);
            } else {
                b.m1818d(false);
                b.m1798a(64);
            }
            if (m2211a(this.f1082d)) {
                b.m1814c(true);
                b.m1805b(this.f1082d);
            }
            this.f1086h.getLocationOnScreen(this.f1084f);
            c = this.f1084f[0];
            int i2 = this.f1084f[1];
            this.f1081c.set(this.f1082d);
            this.f1081c.offset(c, i2);
            b.m1816d(this.f1081c);
            return b;
        }
    }

    private boolean m2216b(int i, int i2, Bundle bundle) {
        switch (i) {
            case -1:
                return m2210a(i2, bundle);
            default:
                return m2219c(i, i2, bundle);
        }
    }

    private boolean m2210a(int i, Bundle bundle) {
        return ViewCompat.m1458a(this.f1086h, i, bundle);
    }

    private boolean m2219c(int i, int i2, Bundle bundle) {
        switch (i2) {
            case 64:
            case 128:
                return m2221d(i, i2, bundle);
            default:
                return m2230a(i, i2, bundle);
        }
    }

    private boolean m2221d(int i, int i2, Bundle bundle) {
        switch (i2) {
            case 64:
                return m2222e(i);
            case 128:
                return m2223f(i);
            default:
                return false;
        }
    }

    private boolean m2211a(Rect rect) {
        if (rect == null || rect.isEmpty()) {
            return false;
        }
        if (this.f1086h.getWindowVisibility() != 0) {
            return false;
        }
        ViewParent parent = this.f1086h.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (ViewCompat.m1465d(view) <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        if (parent == null) {
            return false;
        }
        if (this.f1086h.getLocalVisibleRect(this.f1083e)) {
            return rect.intersect(this.f1083e);
        }
        return false;
    }

    private boolean m2220d(int i) {
        return this.f1088j == i;
    }

    private boolean m2222e(int i) {
        if (!this.f1085g.isEnabled() || !AccessibilityManagerCompat.m1643a(this.f1085g) || m2220d(i)) {
            return false;
        }
        if (this.f1088j != Integer.MIN_VALUE) {
            m2229a(this.f1088j, 65536);
        }
        this.f1088j = i;
        this.f1086h.invalidate();
        m2229a(i, 32768);
        return true;
    }

    private boolean m2223f(int i) {
        if (!m2220d(i)) {
            return false;
        }
        this.f1088j = Integer.MIN_VALUE;
        this.f1086h.invalidate();
        m2229a(i, 65536);
        return true;
    }

    public void m2227a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }
}
