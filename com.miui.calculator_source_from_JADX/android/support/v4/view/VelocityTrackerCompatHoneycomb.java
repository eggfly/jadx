package android.support.v4.view;

import android.view.VelocityTracker;

class VelocityTrackerCompatHoneycomb {
    VelocityTrackerCompatHoneycomb() {
    }

    public static float m1344a(VelocityTracker velocityTracker, int i) {
        return velocityTracker.getXVelocity(i);
    }

    public static float m1345b(VelocityTracker velocityTracker, int i) {
        return velocityTracker.getYVelocity(i);
    }
}
