package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

class h {
    public static Object j6(Context context, Interpolator interpolator) {
        return interpolator != null ? new OverScroller(context, interpolator) : new OverScroller(context);
    }

    public static boolean j6(Object obj) {
        return ((OverScroller) obj).isFinished();
    }

    public static int DW(Object obj) {
        return ((OverScroller) obj).getCurrX();
    }

    public static int FH(Object obj) {
        return ((OverScroller) obj).getCurrY();
    }

    public static boolean Hw(Object obj) {
        return ((OverScroller) obj).computeScrollOffset();
    }

    public static void j6(Object obj, int i, int i2, int i3, int i4) {
        ((OverScroller) obj).startScroll(i, i2, i3, i4);
    }

    public static void j6(Object obj, int i, int i2, int i3, int i4, int i5) {
        ((OverScroller) obj).startScroll(i, i2, i3, i4, i5);
    }

    public static void j6(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        ((OverScroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    public static void v5(Object obj) {
        ((OverScroller) obj).abortAnimation();
    }

    public static int Zo(Object obj) {
        return ((OverScroller) obj).getFinalX();
    }

    public static int VH(Object obj) {
        return ((OverScroller) obj).getFinalY();
    }
}
