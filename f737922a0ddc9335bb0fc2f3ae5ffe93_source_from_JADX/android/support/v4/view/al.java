package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;

public class al {
    static final b j6;

    interface b {
        void DW(ViewParent viewParent, View view, View view2, int i);

        void j6(ViewParent viewParent, View view);

        void j6(ViewParent viewParent, View view, int i, int i2, int i3, int i4);

        void j6(ViewParent viewParent, View view, int i, int i2, int[] iArr);

        boolean j6(ViewParent viewParent, View view, float f, float f2);

        boolean j6(ViewParent viewParent, View view, float f, float f2, boolean z);

        boolean j6(ViewParent viewParent, View view, View view2, int i);
    }

    static class e implements b {
        e() {
        }

        public boolean j6(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof t) {
                return ((t) viewParent).onStartNestedScroll(view, view2, i);
            }
            return false;
        }

        public void DW(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof t) {
                ((t) viewParent).onNestedScrollAccepted(view, view2, i);
            }
        }

        public void j6(ViewParent viewParent, View view) {
            if (viewParent instanceof t) {
                ((t) viewParent).onStopNestedScroll(view);
            }
        }

        public void j6(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            if (viewParent instanceof t) {
                ((t) viewParent).onNestedScroll(view, i, i2, i3, i4);
            }
        }

        public void j6(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            if (viewParent instanceof t) {
                ((t) viewParent).onNestedPreScroll(view, i, i2, iArr);
            }
        }

        public boolean j6(ViewParent viewParent, View view, float f, float f2, boolean z) {
            if (viewParent instanceof t) {
                return ((t) viewParent).onNestedFling(view, f, f2, z);
            }
            return false;
        }

        public boolean j6(ViewParent viewParent, View view, float f, float f2) {
            if (viewParent instanceof t) {
                return ((t) viewParent).onNestedPreFling(view, f, f2);
            }
            return false;
        }
    }

    static class a extends e {
        a() {
        }
    }

    static class c extends a {
        c() {
        }
    }

    static class d extends c {
        d() {
        }

        public boolean j6(ViewParent viewParent, View view, View view2, int i) {
            return am.j6(viewParent, view, view2, i);
        }

        public void DW(ViewParent viewParent, View view, View view2, int i) {
            am.DW(viewParent, view, view2, i);
        }

        public void j6(ViewParent viewParent, View view) {
            am.j6(viewParent, view);
        }

        public void j6(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            am.j6(viewParent, view, i, i2, i3, i4);
        }

        public void j6(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            am.j6(viewParent, view, i, i2, iArr);
        }

        public boolean j6(ViewParent viewParent, View view, float f, float f2, boolean z) {
            return am.j6(viewParent, view, f, f2, z);
        }

        public boolean j6(ViewParent viewParent, View view, float f, float f2) {
            return am.j6(viewParent, view, f, f2);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            j6 = new d();
        } else if (i >= 19) {
            j6 = new c();
        } else if (i >= 14) {
            j6 = new a();
        } else {
            j6 = new e();
        }
    }

    public static boolean j6(ViewParent viewParent, View view, View view2, int i) {
        return j6.j6(viewParent, view, view2, i);
    }

    public static void DW(ViewParent viewParent, View view, View view2, int i) {
        j6.DW(viewParent, view, view2, i);
    }

    public static void j6(ViewParent viewParent, View view) {
        j6.j6(viewParent, view);
    }

    public static void j6(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
        j6.j6(viewParent, view, i, i2, i3, i4);
    }

    public static void j6(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
        j6.j6(viewParent, view, i, i2, iArr);
    }

    public static boolean j6(ViewParent viewParent, View view, float f, float f2, boolean z) {
        return j6.j6(viewParent, view, f, f2, z);
    }

    public static boolean j6(ViewParent viewParent, View view, float f, float f2) {
        return j6.j6(viewParent, view, f, f2);
    }
}
