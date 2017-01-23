package com.miui.support.view.animation;

import android.view.animation.Interpolator;

public class ElasticEaseInOutInterpolator implements Interpolator {
    private final float f3930a;
    private final float f3931b;

    public ElasticEaseInOutInterpolator() {
        this(0.0f, 0.0f);
    }

    public ElasticEaseInOutInterpolator(float f, float f2) {
        this.f3930a = f;
        this.f3931b = f2;
    }

    public float getInterpolation(float f) {
        float f2 = this.f3931b;
        float f3 = this.f3930a;
        if (f == 0.0f) {
            return 0.0f;
        }
        float f4 = f / 0.5f;
        if (f4 == 2.0f) {
            return 1.0f;
        }
        float f5;
        if (f2 == 0.0f) {
            f2 = 0.45000002f;
        }
        if (f3 == 0.0f || f3 < 1.0f) {
            f5 = f2 / 4.0f;
            f3 = 1.0f;
        } else {
            f5 = (float) ((((double) f2) / 6.283185307179586d) * Math.asin((double) (1.0f / f3)));
        }
        if (f4 < 1.0f) {
            float f6 = f4 - 1.0f;
            return ((float) (Math.sin((((double) (f6 - f5)) * 6.283185307179586d) / ((double) f2)) * (((double) f3) * Math.pow(2.0d, (double) (10.0f * f6))))) * -0.5f;
        }
        f6 = f4 - 1.0f;
        return (float) (((Math.sin((((double) (f6 - f5)) * 6.283185307179586d) / ((double) f2)) * (((double) f3) * Math.pow(2.0d, (double) (-10.0f * f6)))) * 0.5d) + 1.0d);
    }
}
