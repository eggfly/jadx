package com.miui.support.view.animation;

import android.view.animation.Interpolator;

public class QuadraticEaseInOutInterpolator implements Interpolator {
    public float getInterpolation(float f) {
        float f2 = f * 2.0f;
        if (f2 < 1.0f) {
            return f2 * (0.5f * f2);
        }
        f2 -= 1.0f;
        return ((f2 * (f2 - 2.0f)) - 1.0f) * -0.5f;
    }
}
