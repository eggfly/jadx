package android.support.v4.view;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;

class ViewCompatJB {
    ViewCompatJB() {
    }

    public static void m1492a(View view) {
        view.postInvalidateOnAnimation();
    }

    public static void m1494a(View view, int i, int i2, int i3, int i4) {
        view.postInvalidate(i, i2, i3, i4);
    }

    public static void m1495a(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void m1496a(View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    public static int m1498b(View view) {
        return view.getImportantForAccessibility();
    }

    public static void m1493a(View view, int i) {
        view.setImportantForAccessibility(i);
    }

    public static boolean m1497a(View view, int i, Bundle bundle) {
        return view.performAccessibilityAction(i, bundle);
    }

    public static ViewParent m1499c(View view) {
        return view.getParentForAccessibility();
    }

    public static boolean m1500d(View view) {
        return view.getFitsSystemWindows();
    }

    public static boolean m1501e(View view) {
        return view.hasOverlappingRendering();
    }
}
