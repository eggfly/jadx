package android.support.v4.view;

import android.graphics.Paint;
import android.view.View;

class ViewCompatJellybeanMr1 {
    ViewCompatJellybeanMr1() {
    }

    public static void m1503a(View view, Paint paint) {
        view.setLayerPaint(paint);
    }

    public static int m1502a(View view) {
        return view.getLayoutDirection();
    }
}
