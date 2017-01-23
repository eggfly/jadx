package android.support.v4.view;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;

class ViewCompatHC {
    ViewCompatHC() {
    }

    static long m1480a() {
        return ValueAnimator.getFrameDelay();
    }

    public static float m1479a(View view) {
        return view.getAlpha();
    }

    public static void m1482a(View view, int i, Paint paint) {
        view.setLayerType(i, paint);
    }

    public static int m1484b(View view) {
        return view.getLayerType();
    }

    public static float m1486c(View view) {
        return view.getScaleX();
    }

    public static void m1481a(View view, float f) {
        view.setScaleX(f);
    }

    public static void m1485b(View view, float f) {
        view.setScaleY(f);
    }

    public static void m1483a(View view, boolean z) {
        view.setSaveFromParentEnabled(z);
    }
}
