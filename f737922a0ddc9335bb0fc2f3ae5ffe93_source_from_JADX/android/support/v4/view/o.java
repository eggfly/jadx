package android.support.v4.view;

import android.view.MotionEvent;

class o {
    public static int j6(MotionEvent motionEvent, int i) {
        return motionEvent.findPointerIndex(i);
    }

    public static int DW(MotionEvent motionEvent, int i) {
        return motionEvent.getPointerId(i);
    }

    public static float FH(MotionEvent motionEvent, int i) {
        return motionEvent.getX(i);
    }

    public static float Hw(MotionEvent motionEvent, int i) {
        return motionEvent.getY(i);
    }

    public static int j6(MotionEvent motionEvent) {
        return motionEvent.getPointerCount();
    }
}
