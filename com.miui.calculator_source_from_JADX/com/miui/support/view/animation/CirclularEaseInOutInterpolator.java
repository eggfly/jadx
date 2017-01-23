package com.miui.support.view.animation;

import android.view.animation.Interpolator;

public class CirclularEaseInOutInterpolator implements Interpolator {
    public float getInterpolation(float f) {
        float f2 = f * 2.0f;
        if (f2 < 1.0f) {
            return ((float) (Math.sqrt((double) (1.0f - (f2 * f2))) - 1.0d)) * -0.5f;
        }
        f2 -= 2.0f;
        return ((float) (Math.sqrt((double) (1.0f - (f2 * f2))) + 1.0d)) * 0.5f;
    }
}
