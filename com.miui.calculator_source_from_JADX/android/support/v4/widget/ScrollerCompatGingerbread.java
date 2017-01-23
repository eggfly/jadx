package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

class ScrollerCompatGingerbread {
    ScrollerCompatGingerbread() {
    }

    public static Object m2371a(Context context, Interpolator interpolator) {
        return interpolator != null ? new OverScroller(context, interpolator) : new OverScroller(context);
    }

    public static boolean m2375a(Object obj) {
        return ((OverScroller) obj).isFinished();
    }

    public static int m2376b(Object obj) {
        return ((OverScroller) obj).getCurrX();
    }

    public static int m2377c(Object obj) {
        return ((OverScroller) obj).getCurrY();
    }

    public static boolean m2378d(Object obj) {
        return ((OverScroller) obj).computeScrollOffset();
    }

    public static void m2372a(Object obj, int i, int i2, int i3, int i4) {
        ((OverScroller) obj).startScroll(i, i2, i3, i4);
    }

    public static void m2373a(Object obj, int i, int i2, int i3, int i4, int i5) {
        ((OverScroller) obj).startScroll(i, i2, i3, i4, i5);
    }

    public static void m2374a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        ((OverScroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    public static void m2379e(Object obj) {
        ((OverScroller) obj).abortAnimation();
    }

    public static int m2380f(Object obj) {
        return ((OverScroller) obj).getFinalX();
    }

    public static int m2381g(Object obj) {
        return ((OverScroller) obj).getFinalY();
    }
}
