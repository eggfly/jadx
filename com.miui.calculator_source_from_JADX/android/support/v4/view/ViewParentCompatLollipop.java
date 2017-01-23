package android.support.v4.view;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;

class ViewParentCompatLollipop {
    ViewParentCompatLollipop() {
    }

    public static boolean m1613a(ViewParent viewParent, View view, View view2, int i) {
        try {
            return viewParent.onStartNestedScroll(view, view2, i);
        } catch (Throwable e) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface " + "method onStartNestedScroll", e);
            return false;
        }
    }

    public static void m1614b(ViewParent viewParent, View view, View view2, int i) {
        try {
            viewParent.onNestedScrollAccepted(view, view2, i);
        } catch (Throwable e) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface " + "method onNestedScrollAccepted", e);
        }
    }

    public static void m1608a(ViewParent viewParent, View view) {
        try {
            viewParent.onStopNestedScroll(view);
        } catch (Throwable e) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface " + "method onStopNestedScroll", e);
        }
    }

    public static void m1609a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
        try {
            viewParent.onNestedScroll(view, i, i2, i3, i4);
        } catch (Throwable e) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface " + "method onNestedScroll", e);
        }
    }

    public static void m1610a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
        try {
            viewParent.onNestedPreScroll(view, i, i2, iArr);
        } catch (Throwable e) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface " + "method onNestedPreScroll", e);
        }
    }

    public static boolean m1612a(ViewParent viewParent, View view, float f, float f2, boolean z) {
        try {
            return viewParent.onNestedFling(view, f, f2, z);
        } catch (Throwable e) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface " + "method onNestedFling", e);
            return false;
        }
    }

    public static boolean m1611a(ViewParent viewParent, View view, float f, float f2) {
        try {
            return viewParent.onNestedPreFling(view, f, f2);
        } catch (Throwable e) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface " + "method onNestedPreFling", e);
            return false;
        }
    }
}
