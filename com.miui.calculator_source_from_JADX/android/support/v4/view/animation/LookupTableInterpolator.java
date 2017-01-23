package android.support.v4.view.animation;

import android.view.animation.Interpolator;

abstract class LookupTableInterpolator implements Interpolator {
    private final float[] f961a;
    private final float f962b;

    public LookupTableInterpolator(float[] fArr) {
        this.f961a = fArr;
        this.f962b = 1.0f / ((float) (this.f961a.length - 1));
    }

    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        int min = Math.min((int) (((float) (this.f961a.length - 1)) * f), this.f961a.length - 2);
        float f2 = (f - (((float) min) * this.f962b)) / this.f962b;
        return ((this.f961a[min + 1] - this.f961a[min]) * f2) + this.f961a[min];
    }
}
