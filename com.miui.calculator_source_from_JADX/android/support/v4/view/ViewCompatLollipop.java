package android.support.v4.view;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

class ViewCompatLollipop {

    /* renamed from: android.support.v4.view.ViewCompatLollipop.1 */
    final class C00881 implements OnApplyWindowInsetsListener {
        final /* synthetic */ OnApplyWindowInsetsListener f831a;

        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            return ((WindowInsetsCompatApi21) this.f831a.m1311a(view, new WindowInsetsCompatApi21(windowInsets))).m1631a();
        }
    }

    ViewCompatLollipop() {
    }

    public static void m1505a(View view, float f) {
        view.setElevation(f);
    }

    public static float m1504a(View view) {
        return view.getElevation();
    }

    public static boolean m1506b(View view) {
        return view.isNestedScrollingEnabled();
    }

    public static void m1507c(View view) {
        view.stopNestedScroll();
    }
}
