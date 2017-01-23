package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;

public class ViewParentCompat {
    static final ViewParentCompatImpl f900a;

    interface ViewParentCompatImpl {
        void m1575a(ViewParent viewParent, View view);

        void m1576a(ViewParent viewParent, View view, int i, int i2, int i3, int i4);

        void m1577a(ViewParent viewParent, View view, int i, int i2, int[] iArr);

        boolean m1578a(ViewParent viewParent, View view, float f, float f2);

        boolean m1579a(ViewParent viewParent, View view, float f, float f2, boolean z);

        boolean m1580a(ViewParent viewParent, View view, View view2, int i);

        boolean m1581a(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent);

        void m1582b(ViewParent viewParent, View view, View view2, int i);
    }

    static class ViewParentCompatStubImpl implements ViewParentCompatImpl {
        ViewParentCompatStubImpl() {
        }

        public boolean m1589a(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
            if (view == null) {
                return false;
            }
            ((AccessibilityManager) view.getContext().getSystemService("accessibility")).sendAccessibilityEvent(accessibilityEvent);
            return true;
        }

        public boolean m1588a(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof NestedScrollingParent) {
                return ((NestedScrollingParent) viewParent).onStartNestedScroll(view, view2, i);
            }
            return false;
        }

        public void m1590b(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent).onNestedScrollAccepted(view, view2, i);
            }
        }

        public void m1583a(ViewParent viewParent, View view) {
            if (viewParent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent).onStopNestedScroll(view);
            }
        }

        public void m1584a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            if (viewParent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent).onNestedScroll(view, i, i2, i3, i4);
            }
        }

        public void m1585a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            if (viewParent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent).onNestedPreScroll(view, i, i2, iArr);
            }
        }

        public boolean m1587a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            if (viewParent instanceof NestedScrollingParent) {
                return ((NestedScrollingParent) viewParent).onNestedFling(view, f, f2, z);
            }
            return false;
        }

        public boolean m1586a(ViewParent viewParent, View view, float f, float f2) {
            if (viewParent instanceof NestedScrollingParent) {
                return ((NestedScrollingParent) viewParent).onNestedPreFling(view, f, f2);
            }
            return false;
        }
    }

    static class ViewParentCompatICSImpl extends ViewParentCompatStubImpl {
        ViewParentCompatICSImpl() {
        }

        public boolean m1591a(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
            return ViewParentCompatICS.m1607a(viewParent, view, accessibilityEvent);
        }
    }

    static class ViewParentCompatKitKatImpl extends ViewParentCompatICSImpl {
        ViewParentCompatKitKatImpl() {
        }
    }

    static class ViewParentCompatLollipopImpl extends ViewParentCompatKitKatImpl {
        ViewParentCompatLollipopImpl() {
        }

        public boolean m1597a(ViewParent viewParent, View view, View view2, int i) {
            return ViewParentCompatLollipop.m1613a(viewParent, view, view2, i);
        }

        public void m1598b(ViewParent viewParent, View view, View view2, int i) {
            ViewParentCompatLollipop.m1614b(viewParent, view, view2, i);
        }

        public void m1592a(ViewParent viewParent, View view) {
            ViewParentCompatLollipop.m1608a(viewParent, view);
        }

        public void m1593a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            ViewParentCompatLollipop.m1609a(viewParent, view, i, i2, i3, i4);
        }

        public void m1594a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            ViewParentCompatLollipop.m1610a(viewParent, view, i, i2, iArr);
        }

        public boolean m1596a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            return ViewParentCompatLollipop.m1612a(viewParent, view, f, f2, z);
        }

        public boolean m1595a(ViewParent viewParent, View view, float f, float f2) {
            return ViewParentCompatLollipop.m1611a(viewParent, view, f, f2);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f900a = new ViewParentCompatLollipopImpl();
        } else if (i >= 19) {
            f900a = new ViewParentCompatKitKatImpl();
        } else if (i >= 14) {
            f900a = new ViewParentCompatICSImpl();
        } else {
            f900a = new ViewParentCompatStubImpl();
        }
    }

    private ViewParentCompat() {
    }

    public static boolean m1605a(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
        return f900a.m1581a(viewParent, view, accessibilityEvent);
    }

    public static boolean m1604a(ViewParent viewParent, View view, View view2, int i) {
        return f900a.m1580a(viewParent, view, view2, i);
    }

    public static void m1606b(ViewParent viewParent, View view, View view2, int i) {
        f900a.m1582b(viewParent, view, view2, i);
    }

    public static void m1599a(ViewParent viewParent, View view) {
        f900a.m1575a(viewParent, view);
    }

    public static void m1600a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
        f900a.m1576a(viewParent, view, i, i2, i3, i4);
    }

    public static void m1601a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
        f900a.m1577a(viewParent, view, i, i2, iArr);
    }

    public static boolean m1603a(ViewParent viewParent, View view, float f, float f2, boolean z) {
        return f900a.m1579a(viewParent, view, f, f2, z);
    }

    public static boolean m1602a(ViewParent viewParent, View view, float f, float f2) {
        return f900a.m1578a(viewParent, view, f, f2);
    }
}
