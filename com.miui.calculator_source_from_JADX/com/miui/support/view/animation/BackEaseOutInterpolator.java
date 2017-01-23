package com.miui.support.view.animation;

import android.view.animation.Interpolator;

public class BackEaseOutInterpolator implements Interpolator {
    private final float f3927a;

    public BackEaseOutInterpolator() {
        this(0.0f);
    }

    public BackEaseOutInterpolator(float f) {
        this.f3927a = f;
    }

    public float getInterpolation(float f) {
        float f2 = this.f3927a == 0.0f ? 1.70158f : this.f3927a;
        float f3 = f - 1.0f;
        return ((f2 + (f3 * (f2 + 1.0f))) * (f3 * f3)) + 1.0f;
    }
}
