package com.miui.support.view.animation;

import android.view.animation.Interpolator;

public class BackEaseInOutInterpolator implements Interpolator {
    private final float f3926a;

    public BackEaseInOutInterpolator() {
        this(0.0f);
    }

    public BackEaseInOutInterpolator(float f) {
        this.f3926a = f;
    }

    public float getInterpolation(float f) {
        float f2 = this.f3926a == 0.0f ? 1.70158f : this.f3926a;
        float f3 = f * 2.0f;
        if (f3 < 1.0f) {
            f2 = (float) (((double) f2) * 1.525d);
            return (((f3 * (f2 + 1.0f)) - f2) * (f3 * f3)) * 0.5f;
        }
        f3 -= 2.0f;
        f2 = (float) (((double) f2) * 1.525d);
        return (((f2 + (f3 * (f2 + 1.0f))) * (f3 * f3)) + 2.0f) * 0.5f;
    }
}
