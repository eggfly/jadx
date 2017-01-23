package android.support.v4.view;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Gravity;

public class GravityCompat {
    static final GravityCompatImpl f770a;

    interface GravityCompatImpl {
        int m1218a(int i, int i2);

        void m1219a(int i, int i2, int i3, Rect rect, Rect rect2, int i4);
    }

    static class GravityCompatImplBase implements GravityCompatImpl {
        GravityCompatImplBase() {
        }

        public int m1220a(int i, int i2) {
            return -8388609 & i;
        }

        public void m1221a(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
            Gravity.apply(i, i2, i3, rect, rect2);
        }
    }

    static class GravityCompatImplJellybeanMr1 implements GravityCompatImpl {
        GravityCompatImplJellybeanMr1() {
        }

        public int m1222a(int i, int i2) {
            return GravityCompatJellybeanMr1.m1226a(i, i2);
        }

        public void m1223a(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
            GravityCompatJellybeanMr1.m1227a(i, i2, i3, rect, rect2, i4);
        }
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            f770a = new GravityCompatImplJellybeanMr1();
        } else {
            f770a = new GravityCompatImplBase();
        }
    }

    public static void m1225a(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
        f770a.m1219a(i, i2, i3, rect, rect2, i4);
    }

    public static int m1224a(int i, int i2) {
        return f770a.m1218a(i, i2);
    }
}
