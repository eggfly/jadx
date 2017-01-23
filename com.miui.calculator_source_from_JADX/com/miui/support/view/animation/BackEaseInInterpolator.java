package com.miui.support.view.animation;

import android.view.animation.Interpolator;

public class BackEaseInInterpolator implements Interpolator {
    private final float f3925a;

    public BackEaseInInterpolator() {
        this(0.0f);
    }

    public BackEaseInInterpolator(float f) {
        this.f3925a = f;
    }

    public float getInterpolation(float f) {
        float f2 = this.f3925a == 0.0f ? 1.70158f : this.f3925a;
        return (((1.0f + f2) * f) - f2) * (f * f);
    }
}
