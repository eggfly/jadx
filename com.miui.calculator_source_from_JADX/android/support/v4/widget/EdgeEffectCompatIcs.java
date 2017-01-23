package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.EdgeEffect;

class EdgeEffectCompatIcs {
    EdgeEffectCompatIcs() {
    }

    public static Object m2197a(Context context) {
        return new EdgeEffect(context);
    }

    public static void m2198a(Object obj, int i, int i2) {
        ((EdgeEffect) obj).setSize(i, i2);
    }

    public static boolean m2199a(Object obj) {
        return ((EdgeEffect) obj).isFinished();
    }

    public static void m2203b(Object obj) {
        ((EdgeEffect) obj).finish();
    }

    public static boolean m2200a(Object obj, float f) {
        ((EdgeEffect) obj).onPull(f);
        return true;
    }

    public static boolean m2204c(Object obj) {
        EdgeEffect edgeEffect = (EdgeEffect) obj;
        edgeEffect.onRelease();
        return edgeEffect.isFinished();
    }

    public static boolean m2201a(Object obj, int i) {
        ((EdgeEffect) obj).onAbsorb(i);
        return true;
    }

    public static boolean m2202a(Object obj, Canvas canvas) {
        return ((EdgeEffect) obj).draw(canvas);
    }
}
