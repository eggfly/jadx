package android.support.v4.view;

import android.graphics.Rect;
import android.view.Gravity;

class GravityCompatJellybeanMr1 {
    GravityCompatJellybeanMr1() {
    }

    public static int m1226a(int i, int i2) {
        return Gravity.getAbsoluteGravity(i, i2);
    }

    public static void m1227a(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
        Gravity.apply(i, i2, i3, rect, rect2, i4);
    }
}
