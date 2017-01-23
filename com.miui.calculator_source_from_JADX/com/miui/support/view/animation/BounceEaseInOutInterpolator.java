package com.miui.support.view.animation;

import android.view.animation.Interpolator;

public class BounceEaseInOutInterpolator implements Interpolator {
    public float getInterpolation(float f) {
        if (f < 0.5f) {
            return new BounceEaseInInterpolator().getInterpolation(2.0f * f) * 0.5f;
        }
        return (new BounceEaseOutInterpolator().getInterpolation((2.0f * f) - 1.0f) * 0.5f) + 0.5f;
    }
}
