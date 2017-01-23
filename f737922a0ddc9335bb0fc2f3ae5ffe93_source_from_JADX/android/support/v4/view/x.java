package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

public class x {
    static final c j6;

    interface c {
        float DW(VelocityTracker velocityTracker, int i);

        float j6(VelocityTracker velocityTracker, int i);
    }

    static class a implements c {
        a() {
        }

        public float j6(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getXVelocity();
        }

        public float DW(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getYVelocity();
        }
    }

    static class b implements c {
        b() {
        }

        public float j6(VelocityTracker velocityTracker, int i) {
            return y.j6(velocityTracker, i);
        }

        public float DW(VelocityTracker velocityTracker, int i) {
            return y.DW(velocityTracker, i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            j6 = new b();
        } else {
            j6 = new a();
        }
    }

    public static float j6(VelocityTracker velocityTracker, int i) {
        return j6.j6(velocityTracker, i);
    }

    public static float DW(VelocityTracker velocityTracker, int i) {
        return j6.DW(velocityTracker, i);
    }
}
