package android.support.v4.widget;

import ag;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import java.util.ArrayList;

class f extends Drawable implements Animatable {
    private static final Interpolator DW;
    private static final Interpolator FH;
    private float EQ;
    private final int[] Hw;
    private double J0;
    private final Callback J8;
    private float VH;
    private final a Zo;
    private Resources gn;
    boolean j6;
    private Animation tp;
    private View u7;
    private final ArrayList<Animation> v5;
    private double we;

    class 1 extends Animation {
        final /* synthetic */ f DW;
        final /* synthetic */ a j6;

        1(f fVar, a aVar) {
            this.DW = fVar;
            this.j6 = aVar;
        }

        public void applyTransformation(float f, Transformation transformation) {
            if (this.DW.j6) {
                this.DW.DW(f, this.j6);
                return;
            }
            float j6 = this.DW.j6(this.j6);
            float VH = this.j6.VH();
            float Zo = this.j6.Zo();
            float EQ = this.j6.EQ();
            this.DW.j6(f, this.j6);
            if (f <= 0.5f) {
                float f2 = 0.8f - j6;
                this.j6.DW(Zo + (f.FH.getInterpolation(f / 0.5f) * f2));
            }
            if (f > 0.5f) {
                this.j6.FH(((0.8f - j6) * f.FH.getInterpolation((f - 0.5f) / 0.5f)) + VH);
            }
            this.j6.Hw((0.25f * f) + EQ);
            this.DW.FH((216.0f * f) + (1080.0f * (this.DW.EQ / 5.0f)));
        }
    }

    class 2 implements AnimationListener {
        final /* synthetic */ f DW;
        final /* synthetic */ a j6;

        2(f fVar, a aVar) {
            this.DW = fVar;
            this.j6 = aVar;
        }

        public void onAnimationStart(Animation animation) {
            this.DW.EQ = 0.0f;
        }

        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
            this.j6.we();
            this.j6.DW();
            this.j6.DW(this.j6.u7());
            if (this.DW.j6) {
                this.DW.j6 = false;
                animation.setDuration(1332);
                this.j6.j6(false);
                return;
            }
            this.DW.EQ = (this.DW.EQ + 1.0f) % 5.0f;
        }
    }

    class 3 implements Callback {
        final /* synthetic */ f j6;

        3(f fVar) {
            this.j6 = fVar;
        }

        public void invalidateDrawable(Drawable drawable) {
            this.j6.invalidateSelf();
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            this.j6.scheduleSelf(runnable, j);
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            this.j6.unscheduleSelf(runnable);
        }
    }

    private static class a {
        private final Paint DW;
        private int EQ;
        private final Paint FH;
        private final Callback Hw;
        private float J0;
        private float J8;
        private int Mr;
        private Path QX;
        private int U2;
        private float VH;
        private boolean Ws;
        private float XL;
        private float Zo;
        private final Paint a8;
        private double aM;
        private float gn;
        private int j3;
        private final RectF j6;
        private int lg;
        private int rN;
        private int[] tp;
        private float u7;
        private float v5;
        private float we;

        public a(Callback callback) {
            this.j6 = new RectF();
            this.DW = new Paint();
            this.FH = new Paint();
            this.v5 = 0.0f;
            this.Zo = 0.0f;
            this.VH = 0.0f;
            this.gn = 5.0f;
            this.u7 = 2.5f;
            this.a8 = new Paint(1);
            this.Hw = callback;
            this.DW.setStrokeCap(Cap.SQUARE);
            this.DW.setAntiAlias(true);
            this.DW.setStyle(Style.STROKE);
            this.FH.setStyle(Style.FILL);
            this.FH.setAntiAlias(true);
        }

        public void j6(int i) {
            this.lg = i;
        }

        public void j6(float f, float f2) {
            this.j3 = (int) f;
            this.Mr = (int) f2;
        }

        public void j6(Canvas canvas, Rect rect) {
            RectF rectF = this.j6;
            rectF.set(rect);
            rectF.inset(this.u7, this.u7);
            float f = (this.v5 + this.VH) * 360.0f;
            float f2 = ((this.Zo + this.VH) * 360.0f) - f;
            this.DW.setColor(this.rN);
            canvas.drawArc(rectF, f, f2, false, this.DW);
            j6(canvas, f, f2, rect);
            if (this.U2 < 255) {
                this.a8.setColor(this.lg);
                this.a8.setAlpha(255 - this.U2);
                canvas.drawCircle(rect.exactCenterX(), rect.exactCenterY(), (float) (rect.width() / 2), this.a8);
            }
        }

        private void j6(Canvas canvas, float f, float f2, Rect rect) {
            if (this.Ws) {
                if (this.QX == null) {
                    this.QX = new Path();
                    this.QX.setFillType(FillType.EVEN_ODD);
                } else {
                    this.QX.reset();
                }
                float f3 = ((float) (((int) this.u7) / 2)) * this.XL;
                float cos = (float) ((this.aM * Math.cos(0.0d)) + ((double) rect.exactCenterX()));
                float sin = (float) ((this.aM * Math.sin(0.0d)) + ((double) rect.exactCenterY()));
                this.QX.moveTo(0.0f, 0.0f);
                this.QX.lineTo(((float) this.j3) * this.XL, 0.0f);
                this.QX.lineTo((((float) this.j3) * this.XL) / 2.0f, ((float) this.Mr) * this.XL);
                this.QX.offset(cos - f3, sin);
                this.QX.close();
                this.FH.setColor(this.rN);
                canvas.rotate((f + f2) - 5.0f, rect.exactCenterX(), rect.exactCenterY());
                canvas.drawPath(this.QX, this.FH);
            }
        }

        public void j6(int[] iArr) {
            this.tp = iArr;
            FH(0);
        }

        public void DW(int i) {
            this.rN = i;
        }

        public void FH(int i) {
            this.EQ = i;
            this.rN = this.tp[this.EQ];
        }

        public int j6() {
            return this.tp[J8()];
        }

        private int J8() {
            return (this.EQ + 1) % this.tp.length;
        }

        public void DW() {
            FH(J8());
        }

        public void j6(ColorFilter colorFilter) {
            this.DW.setColorFilter(colorFilter);
            Ws();
        }

        public void Hw(int i) {
            this.U2 = i;
        }

        public int FH() {
            return this.U2;
        }

        public void j6(float f) {
            this.gn = f;
            this.DW.setStrokeWidth(f);
            Ws();
        }

        public float Hw() {
            return this.gn;
        }

        public void DW(float f) {
            this.v5 = f;
            Ws();
        }

        public float v5() {
            return this.v5;
        }

        public float Zo() {
            return this.we;
        }

        public float VH() {
            return this.J0;
        }

        public int gn() {
            return this.tp[this.EQ];
        }

        public void FH(float f) {
            this.Zo = f;
            Ws();
        }

        public float u7() {
            return this.Zo;
        }

        public void Hw(float f) {
            this.VH = f;
            Ws();
        }

        public void j6(int i, int i2) {
            float min = (float) Math.min(i, i2);
            if (this.aM <= 0.0d || min < 0.0f) {
                min = (float) Math.ceil((double) (this.gn / 2.0f));
            } else {
                min = (float) (((double) (min / 2.0f)) - this.aM);
            }
            this.u7 = min;
        }

        public void j6(double d) {
            this.aM = d;
        }

        public double tp() {
            return this.aM;
        }

        public void j6(boolean z) {
            if (this.Ws != z) {
                this.Ws = z;
                Ws();
            }
        }

        public void v5(float f) {
            if (f != this.XL) {
                this.XL = f;
                Ws();
            }
        }

        public float EQ() {
            return this.J8;
        }

        public void we() {
            this.we = this.v5;
            this.J0 = this.Zo;
            this.J8 = this.VH;
        }

        public void J0() {
            this.we = 0.0f;
            this.J0 = 0.0f;
            this.J8 = 0.0f;
            DW(0.0f);
            FH(0.0f);
            Hw(0.0f);
        }

        private void Ws() {
            this.Hw.invalidateDrawable(null);
        }
    }

    static {
        DW = new LinearInterpolator();
        FH = new ag();
    }

    public f(Context context, View view) {
        this.Hw = new int[]{-16777216};
        this.v5 = new ArrayList();
        this.J8 = new 3(this);
        this.u7 = view;
        this.gn = context.getResources();
        this.Zo = new a(this.J8);
        this.Zo.j6(this.Hw);
        j6(1);
        DW();
    }

    private void j6(double d, double d2, double d3, double d4, float f, float f2) {
        a aVar = this.Zo;
        float f3 = this.gn.getDisplayMetrics().density;
        this.we = ((double) f3) * d;
        this.J0 = ((double) f3) * d2;
        aVar.j6(((float) d4) * f3);
        aVar.j6(((double) f3) * d3);
        aVar.FH(0);
        aVar.j6(f * f3, f3 * f2);
        aVar.j6((int) this.we, (int) this.J0);
    }

    public void j6(int i) {
        if (i == 0) {
            j6(56.0d, 56.0d, 12.5d, 3.0d, 12.0f, 6.0f);
        } else {
            j6(40.0d, 40.0d, 8.75d, 2.5d, 10.0f, 5.0f);
        }
    }

    public void j6(boolean z) {
        this.Zo.j6(z);
    }

    public void j6(float f) {
        this.Zo.v5(f);
    }

    public void j6(float f, float f2) {
        this.Zo.DW(f);
        this.Zo.FH(f2);
    }

    public void DW(float f) {
        this.Zo.Hw(f);
    }

    public void DW(int i) {
        this.Zo.j6(i);
    }

    public void j6(int... iArr) {
        this.Zo.j6(iArr);
        this.Zo.FH(0);
    }

    public int getIntrinsicHeight() {
        return (int) this.J0;
    }

    public int getIntrinsicWidth() {
        return (int) this.we;
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int save = canvas.save();
        canvas.rotate(this.VH, bounds.exactCenterX(), bounds.exactCenterY());
        this.Zo.j6(canvas, bounds);
        canvas.restoreToCount(save);
    }

    public void setAlpha(int i) {
        this.Zo.Hw(i);
    }

    public int getAlpha() {
        return this.Zo.FH();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.Zo.j6(colorFilter);
    }

    void FH(float f) {
        this.VH = f;
        invalidateSelf();
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isRunning() {
        ArrayList arrayList = this.v5;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Animation animation = (Animation) arrayList.get(i);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    public void start() {
        this.tp.reset();
        this.Zo.we();
        if (this.Zo.u7() != this.Zo.v5()) {
            this.j6 = true;
            this.tp.setDuration(666);
            this.u7.startAnimation(this.tp);
            return;
        }
        this.Zo.FH(0);
        this.Zo.J0();
        this.tp.setDuration(1332);
        this.u7.startAnimation(this.tp);
    }

    public void stop() {
        this.u7.clearAnimation();
        FH(0.0f);
        this.Zo.j6(false);
        this.Zo.FH(0);
        this.Zo.J0();
    }

    private float j6(a aVar) {
        return (float) Math.toRadians(((double) aVar.Hw()) / (6.283185307179586d * aVar.tp()));
    }

    private int j6(float f, int i, int i2) {
        int intValue = Integer.valueOf(i).intValue();
        int i3 = (intValue >> 24) & 255;
        int i4 = (intValue >> 16) & 255;
        int i5 = (intValue >> 8) & 255;
        intValue &= 255;
        int intValue2 = Integer.valueOf(i2).intValue();
        return (intValue + ((int) (((float) ((intValue2 & 255) - intValue)) * f))) | ((((i3 + ((int) (((float) (((intValue2 >> 24) & 255) - i3)) * f))) << 24) | ((i4 + ((int) (((float) (((intValue2 >> 16) & 255) - i4)) * f))) << 16)) | ((((int) (((float) (((intValue2 >> 8) & 255) - i5)) * f)) + i5) << 8));
    }

    private void j6(float f, a aVar) {
        if (f > 0.75f) {
            aVar.DW(j6((f - 0.75f) / 0.25f, aVar.gn(), aVar.j6()));
        }
    }

    private void DW(float f, a aVar) {
        j6(f, aVar);
        float floor = (float) (Math.floor((double) (aVar.EQ() / 0.8f)) + 1.0d);
        float j6 = j6(aVar);
        aVar.DW((((aVar.VH() - j6) - aVar.Zo()) * f) + aVar.Zo());
        aVar.FH(aVar.VH());
        aVar.Hw(((floor - aVar.EQ()) * f) + aVar.EQ());
    }

    private void DW() {
        a aVar = this.Zo;
        Animation 1 = new 1(this, aVar);
        1.setRepeatCount(-1);
        1.setRepeatMode(1);
        1.setInterpolator(DW);
        1.setAnimationListener(new 2(this, aVar));
        this.tp = 1;
    }
}
