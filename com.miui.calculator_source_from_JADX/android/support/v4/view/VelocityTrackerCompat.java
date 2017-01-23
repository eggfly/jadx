package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

public class VelocityTrackerCompat {
    static final VelocityTrackerVersionImpl f826a;

    interface VelocityTrackerVersionImpl {
        float m1336a(VelocityTracker velocityTracker, int i);

        float m1337b(VelocityTracker velocityTracker, int i);
    }

    static class BaseVelocityTrackerVersionImpl implements VelocityTrackerVersionImpl {
        BaseVelocityTrackerVersionImpl() {
        }

        public float m1338a(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getXVelocity();
        }

        public float m1339b(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getYVelocity();
        }
    }

    static class HoneycombVelocityTrackerVersionImpl implements VelocityTrackerVersionImpl {
        HoneycombVelocityTrackerVersionImpl() {
        }

        public float m1340a(VelocityTracker velocityTracker, int i) {
            return VelocityTrackerCompatHoneycomb.m1344a(velocityTracker, i);
        }

        public float m1341b(VelocityTracker velocityTracker, int i) {
            return VelocityTrackerCompatHoneycomb.m1345b(velocityTracker, i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            f826a = new HoneycombVelocityTrackerVersionImpl();
        } else {
            f826a = new BaseVelocityTrackerVersionImpl();
        }
    }

    public static float m1342a(VelocityTracker velocityTracker, int i) {
        return f826a.m1336a(velocityTracker, i);
    }

    public static float m1343b(VelocityTracker velocityTracker, int i) {
        return f826a.m1337b(velocityTracker, i);
    }
}
