package com.miui.support.view.animation;

import android.view.animation.Interpolator;

public class BounceEaseOutInterpolator implements Interpolator {
    public float getInterpolation(float f) {
        if (((double) f) < 0.36363636363636365d) {
            return (7.5625f * f) * f;
        }
        float f2;
        if (((double) f) < 0.7272727272727273d) {
            f2 = (float) (((double) f) - 0.5454545454545454d);
            return (f2 * (7.5625f * f2)) + 0.75f;
        } else if (((double) f) < 0.9090909090909091d) {
            f2 = (float) (((double) f) - 0.8181818181818182d);
            return (f2 * (7.5625f * f2)) + 0.9375f;
        } else {
            f2 = (float) (((double) f) - 0.9545454545454546d);
            return (f2 * (7.5625f * f2)) + 0.984375f;
        }
    }
}
