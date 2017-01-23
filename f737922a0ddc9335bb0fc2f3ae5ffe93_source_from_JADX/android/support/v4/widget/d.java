package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.EdgeEffect;

class d {
    public static Object j6(Context context) {
        return new EdgeEffect(context);
    }

    public static void j6(Object obj, int i, int i2) {
        ((EdgeEffect) obj).setSize(i, i2);
    }

    public static boolean j6(Object obj) {
        return ((EdgeEffect) obj).isFinished();
    }

    public static void DW(Object obj) {
        ((EdgeEffect) obj).finish();
    }

    public static boolean j6(Object obj, float f) {
        ((EdgeEffect) obj).onPull(f);
        return true;
    }

    public static boolean FH(Object obj) {
        EdgeEffect edgeEffect = (EdgeEffect) obj;
        edgeEffect.onRelease();
        return edgeEffect.isFinished();
    }

    public static boolean j6(Object obj, int i) {
        ((EdgeEffect) obj).onAbsorb(i);
        return true;
    }

    public static boolean j6(Object obj, Canvas canvas) {
        return ((EdgeEffect) obj).draw(canvas);
    }
}
