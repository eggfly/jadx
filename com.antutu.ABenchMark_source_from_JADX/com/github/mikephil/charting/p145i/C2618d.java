package com.github.mikephil.charting.p145i;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.data.C2562a;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.p139f.p141b.C2574e;
import com.github.mikephil.charting.p139f.p141b.C2584a;

/* renamed from: com.github.mikephil.charting.i.d */
public class C2618d {
    protected Matrix f9072a;
    protected Matrix f9073b;
    protected C2621g f9074c;
    private Matrix f9075d;
    private Matrix f9076e;

    public C2618d(C2621g c2621g) {
        this.f9072a = new Matrix();
        this.f9073b = new Matrix();
        this.f9075d = new Matrix();
        this.f9076e = new Matrix();
        this.f9074c = c2621g;
    }

    public Matrix m10038a() {
        this.f9075d.set(this.f9072a);
        this.f9075d.postConcat(this.f9074c.f9083a);
        this.f9075d.postConcat(this.f9073b);
        return this.f9075d;
    }

    public C2616b m10039a(float f, float f2) {
        float[] fArr = new float[]{f, f2};
        m10049b(fArr);
        return new C2616b((double) fArr[0], (double) fArr[1]);
    }

    public void m10040a(float f, float f2, float f3, float f4) {
        float f5 = 0.0f;
        float i = this.f9074c.m10098i() / f2;
        float j = this.f9074c.m10100j() / f3;
        if (Float.isInfinite(i)) {
            i = 0.0f;
        }
        if (!Float.isInfinite(j)) {
            f5 = j;
        }
        this.f9072a.reset();
        this.f9072a.postTranslate(-f, -f4);
        this.f9072a.postScale(i, -f5);
    }

    public void m10041a(Path path) {
        path.transform(this.f9072a);
        path.transform(this.f9074c.m10106o());
        path.transform(this.f9073b);
    }

    public void m10042a(RectF rectF, float f) {
        rectF.top *= f;
        rectF.bottom *= f;
        this.f9072a.mapRect(rectF);
        this.f9074c.m10106o().mapRect(rectF);
        this.f9073b.mapRect(rectF);
    }

    public void m10043a(boolean z) {
        this.f9073b.reset();
        if (z) {
            this.f9073b.setTranslate(this.f9074c.m10076a(), -this.f9074c.m10086c());
            this.f9073b.postScale(1.0f, -1.0f);
            return;
        }
        this.f9073b.postTranslate(this.f9074c.m10076a(), this.f9074c.m10104m() - this.f9074c.m10088d());
    }

    public void m10044a(float[] fArr) {
        this.f9072a.mapPoints(fArr);
        this.f9074c.m10106o().mapPoints(fArr);
        this.f9073b.mapPoints(fArr);
    }

    public float[] m10045a(C2584a c2584a, int i, C2562a c2562a, float f) {
        float[] fArr = new float[(c2584a.m9792m() * 2)];
        int e = c2562a.m9761e();
        float a = c2562a.m9771a();
        for (int i2 = 0; i2 < fArr.length; i2 += 2) {
            Entry f2 = c2584a.m9783f(i2 / 2);
            int d = f2.m9743d();
            float d2 = ((((float) d) * a) + ((float) ((f2.m9743d() + ((e - 1) * d)) + i))) + (a / 2.0f);
            float b = f2.m9742b();
            fArr[i2] = d2;
            fArr[i2 + 1] = b * f;
        }
        m10038a().mapPoints(fArr);
        return fArr;
    }

    public float[] m10046a(C2574e c2574e, float f, float f2, int i, int i2) {
        int ceil = ((int) Math.ceil((double) (((float) (i2 - i)) * f))) * 2;
        float[] fArr = new float[ceil];
        for (int i3 = 0; i3 < ceil; i3 += 2) {
            Entry f3 = c2574e.m9783f((i3 / 2) + i);
            if (f3 != null) {
                fArr[i3] = (float) f3.m9743d();
                fArr[i3 + 1] = f3.m9742b() * f2;
            }
        }
        m10038a().mapPoints(fArr);
        return fArr;
    }

    public Matrix m10047b() {
        m10038a().invert(this.f9076e);
        return this.f9076e;
    }

    public void m10048b(RectF rectF, float f) {
        rectF.left *= f;
        rectF.right *= f;
        this.f9072a.mapRect(rectF);
        this.f9074c.m10106o().mapRect(rectF);
        this.f9073b.mapRect(rectF);
    }

    public void m10049b(float[] fArr) {
        Matrix matrix = new Matrix();
        this.f9073b.invert(matrix);
        matrix.mapPoints(fArr);
        this.f9074c.m10106o().invert(matrix);
        matrix.mapPoints(fArr);
        this.f9072a.invert(matrix);
        matrix.mapPoints(fArr);
    }

    public float[] m10050b(C2584a c2584a, int i, C2562a c2562a, float f) {
        float[] fArr = new float[(c2584a.m9792m() * 2)];
        int e = c2562a.m9761e();
        float a = c2562a.m9771a();
        for (int i2 = 0; i2 < fArr.length; i2 += 2) {
            Entry f2 = c2584a.m9783f(i2 / 2);
            int d = f2.m9743d();
            float f3 = ((((float) d) * a) + ((float) ((((e - 1) * d) + d) + i))) + (a / 2.0f);
            fArr[i2] = f2.m9742b() * f;
            fArr[i2 + 1] = f3;
        }
        m10038a().mapPoints(fArr);
        return fArr;
    }
}
