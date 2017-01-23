package com.github.mikephil.charting.p145i;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.v4.widget.AutoScrollHelper;
import android.view.View;

/* renamed from: com.github.mikephil.charting.i.g */
public class C2621g {
    protected final Matrix f9083a;
    protected RectF f9084b;
    protected float f9085c;
    protected float f9086d;
    protected final float[] f9087e;
    private float f9088f;
    private float f9089g;
    private float f9090h;
    private float f9091i;
    private float f9092j;
    private float f9093k;
    private float f9094l;
    private float f9095m;
    private float f9096n;
    private float f9097o;

    public C2621g() {
        this.f9083a = new Matrix();
        this.f9084b = new RectF();
        this.f9085c = 0.0f;
        this.f9086d = 0.0f;
        this.f9088f = 1.0f;
        this.f9089g = AutoScrollHelper.NO_MAX;
        this.f9090h = 1.0f;
        this.f9091i = AutoScrollHelper.NO_MAX;
        this.f9092j = 1.0f;
        this.f9093k = 1.0f;
        this.f9094l = 0.0f;
        this.f9095m = 0.0f;
        this.f9096n = 0.0f;
        this.f9097o = 0.0f;
        this.f9087e = new float[9];
    }

    public float m10076a() {
        return this.f9084b.left;
    }

    public Matrix m10077a(Matrix matrix, View view, boolean z) {
        this.f9083a.set(matrix);
        m10081a(this.f9083a, this.f9084b);
        if (z) {
            view.invalidate();
        }
        matrix.set(this.f9083a);
        return matrix;
    }

    public void m10078a(float f) {
        if (f < 1.0f) {
            f = 1.0f;
        }
        this.f9090h = f;
        m10081a(this.f9083a, this.f9084b);
    }

    public void m10079a(float f, float f2) {
        float a = m10076a();
        float c = m10086c();
        float b = m10082b();
        float d = m10088d();
        this.f9086d = f2;
        this.f9085c = f;
        m10080a(a, c, b, d);
    }

    public void m10080a(float f, float f2, float f3, float f4) {
        this.f9084b.set(f, f2, this.f9085c - f3, this.f9086d - f4);
    }

    public void m10081a(Matrix matrix, RectF rectF) {
        float f = 0.0f;
        matrix.getValues(this.f9087e);
        float f2 = this.f9087e[2];
        float f3 = this.f9087e[0];
        float f4 = this.f9087e[5];
        float f5 = this.f9087e[4];
        this.f9092j = Math.min(Math.max(this.f9090h, f3), this.f9091i);
        this.f9093k = Math.min(Math.max(this.f9088f, f5), this.f9089g);
        if (rectF != null) {
            f3 = rectF.width();
            f = rectF.height();
        } else {
            f3 = 0.0f;
        }
        this.f9094l = Math.min(Math.max(f2, ((-f3) * (this.f9092j - 1.0f)) - this.f9096n), this.f9096n);
        this.f9095m = Math.max(Math.min(f4, (f * (this.f9093k - 1.0f)) + this.f9097o), -this.f9097o);
        this.f9087e[2] = this.f9094l;
        this.f9087e[0] = this.f9092j;
        this.f9087e[5] = this.f9095m;
        this.f9087e[4] = this.f9093k;
        matrix.setValues(this.f9087e);
    }

    public float m10082b() {
        return this.f9085c - this.f9084b.right;
    }

    public Matrix m10083b(float f, float f2, float f3, float f4) {
        Matrix matrix = new Matrix();
        matrix.set(this.f9083a);
        matrix.postScale(f, f2, f3, f4);
        return matrix;
    }

    public void m10084b(float f) {
        this.f9091i = f;
        m10081a(this.f9083a, this.f9084b);
    }

    public boolean m10085b(float f, float f2) {
        return m10087c(f) && m10089d(f2);
    }

    public float m10086c() {
        return this.f9084b.top;
    }

    public boolean m10087c(float f) {
        return m10091e(f) && m10093f(f);
    }

    public float m10088d() {
        return this.f9086d - this.f9084b.bottom;
    }

    public boolean m10089d(float f) {
        return m10095g(f) && m10097h(f);
    }

    public float m10090e() {
        return this.f9084b.top;
    }

    public boolean m10091e(float f) {
        return this.f9084b.left <= f;
    }

    public float m10092f() {
        return this.f9084b.left;
    }

    public boolean m10093f(float f) {
        return this.f9084b.right >= ((float) ((int) (f * 100.0f))) / 100.0f;
    }

    public float m10094g() {
        return this.f9084b.right;
    }

    public boolean m10095g(float f) {
        return this.f9084b.top <= f;
    }

    public float m10096h() {
        return this.f9084b.bottom;
    }

    public boolean m10097h(float f) {
        return this.f9084b.bottom >= ((float) ((int) (f * 100.0f))) / 100.0f;
    }

    public float m10098i() {
        return this.f9084b.width();
    }

    public void m10099i(float f) {
        this.f9096n = C2620f.m10053a(f);
    }

    public float m10100j() {
        return this.f9084b.height();
    }

    public void m10101j(float f) {
        this.f9097o = C2620f.m10053a(f);
    }

    public RectF m10102k() {
        return this.f9084b;
    }

    public PointF m10103l() {
        return new PointF(this.f9084b.centerX(), this.f9084b.centerY());
    }

    public float m10104m() {
        return this.f9086d;
    }

    public float m10105n() {
        return this.f9085c;
    }

    public Matrix m10106o() {
        return this.f9083a;
    }

    public float m10107p() {
        return this.f9092j;
    }

    public float m10108q() {
        return this.f9093k;
    }

    public boolean m10109r() {
        return m10111t() && m10110s();
    }

    public boolean m10110s() {
        return this.f9093k <= this.f9088f && this.f9088f <= 1.0f;
    }

    public boolean m10111t() {
        return this.f9092j <= this.f9090h && this.f9090h <= 1.0f;
    }

    public boolean m10112u() {
        return this.f9096n <= 0.0f && this.f9097o <= 0.0f;
    }

    public boolean m10113v() {
        return this.f9092j > this.f9090h;
    }

    public boolean m10114w() {
        return this.f9092j < this.f9091i;
    }
}
