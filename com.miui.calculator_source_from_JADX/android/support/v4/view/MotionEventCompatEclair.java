package android.support.v4.view;

import android.view.MotionEvent;

class MotionEventCompatEclair {
    MotionEventCompatEclair() {
    }

    public static int m1293a(MotionEvent motionEvent, int i) {
        return motionEvent.findPointerIndex(i);
    }

    public static int m1294b(MotionEvent motionEvent, int i) {
        return motionEvent.getPointerId(i);
    }

    public static float m1295c(MotionEvent motionEvent, int i) {
        return motionEvent.getX(i);
    }

    public static float m1296d(MotionEvent motionEvent, int i) {
        return motionEvent.getY(i);
    }

    public static int m1292a(MotionEvent motionEvent) {
        return motionEvent.getPointerCount();
    }
}
