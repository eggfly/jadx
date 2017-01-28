import android.view.animation.Interpolator;

abstract class ah implements Interpolator {
    private final float DW;
    private final float[] j6;

    public ah(float[] fArr) {
        this.j6 = fArr;
        this.DW = 1.0f / ((float) (this.j6.length - 1));
    }

    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        int min = Math.min((int) (((float) (this.j6.length - 1)) * f), this.j6.length - 2);
        float f2 = (f - (((float) min) * this.DW)) / this.DW;
        return ((this.j6[min + 1] - this.j6[min]) * f2) + this.j6[min];
    }
}
