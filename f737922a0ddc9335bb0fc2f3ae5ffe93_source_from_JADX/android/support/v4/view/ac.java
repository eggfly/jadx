package android.support.v4.view;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;

class ac {
    static long j6() {
        return ValueAnimator.getFrameDelay();
    }

    public static void j6(View view, int i, Paint paint) {
        view.setLayerType(i, paint);
    }

    public static int j6(View view) {
        return view.getLayerType();
    }

    public static float DW(View view) {
        return view.getScaleX();
    }

    public static void j6(View view, float f) {
        view.setScaleX(f);
    }

    public static void DW(View view, float f) {
        view.setScaleY(f);
    }

    public static void j6(View view, boolean z) {
        view.setSaveFromParentEnabled(z);
    }
}
