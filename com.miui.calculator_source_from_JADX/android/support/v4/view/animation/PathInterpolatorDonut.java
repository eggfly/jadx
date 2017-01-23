package android.support.v4.view.animation;

import android.view.animation.Interpolator;

class PathInterpolatorDonut implements Interpolator {
    private final float[] f966a;
    private final float[] f967b;

    public float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int i = 0;
        int length = this.f966a.length - 1;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.f966a[i2]) {
                length = i;
            } else {
                int i3 = length;
                length = i2;
                i2 = i3;
            }
            i = length;
            length = i2;
        }
        float f2 = this.f966a[length] - this.f966a[i];
        if (f2 == 0.0f) {
            return this.f967b[i];
        }
        f2 = (f - this.f966a[i]) / f2;
        float f3 = this.f967b[i];
        return (f2 * (this.f967b[length] - f3)) + f3;
    }
}
