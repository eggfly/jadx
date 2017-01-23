package com.github.mikephil.charting.charts;

import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.RectF;
import com.github.mikephil.charting.data.C2577l;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.p138c.C2538f;
import com.github.mikephil.charting.p138c.C2541g;
import com.github.mikephil.charting.p138c.C2541g.C2539a;
import com.github.mikephil.charting.p142e.C2581c;
import com.github.mikephil.charting.p144h.C2607j;
import com.github.mikephil.charting.p144h.C2611o;
import com.github.mikephil.charting.p144h.C2614r;
import com.github.mikephil.charting.p145i.C2620f;

/* renamed from: com.github.mikephil.charting.charts.e */
public class C2551e extends C2548d<C2577l> {
    protected C2614r f8902a;
    protected C2611o f8903b;
    private float f8904e;
    private float f8905f;
    private int f8906g;
    private int f8907h;
    private int f8908i;
    private boolean f8909j;
    private int f8910k;
    private C2541g f8911l;
    private C2538f f8912m;

    public int m9730a(float f) {
        float c = C2620f.m10074c(f - getRotationAngle());
        float sliceAngle = getSliceAngle();
        for (int i = 0; i < ((C2577l) this.t).m9768l(); i++) {
            if ((((float) (i + 1)) * sliceAngle) - (sliceAngle / 2.0f) > c) {
                return i;
            }
        }
        return 0;
    }

    protected void m9731a() {
        super.m9705a();
        this.f8911l = new C2541g(C2539a.LEFT);
        this.f8912m = new C2538f();
        this.f8912m.m9613a(0);
        this.f8904e = C2620f.m10053a(1.5f);
        this.f8905f = C2620f.m10053a(0.75f);
        this.H = new C2607j(this, this.K, this.J);
        this.f8902a = new C2614r(this.J, this.f8911l, this);
        this.f8903b = new C2611o(this.J, this.f8912m, this);
    }

    protected float[] m9732a(Entry entry, C2581c c2581c) {
        float sliceAngle = (getSliceAngle() * ((float) entry.m9743d())) + getRotationAngle();
        float b = entry.m9742b() * getFactor();
        PointF centerOffsets = getCenterOffsets();
        PointF pointF = new PointF((float) (((double) centerOffsets.x) + (((double) b) * Math.cos(Math.toRadians((double) sliceAngle)))), (float) ((Math.sin(Math.toRadians((double) sliceAngle)) * ((double) b)) + ((double) centerOffsets.y)));
        return new float[]{pointF.x, pointF.y};
    }

    protected void m9733b() {
        super.m9708b();
        float x = !Float.isNaN(this.f8911l.m9643x()) ? this.f8911l.m9643x() : ((C2577l) this.t).m9753a(C2539a.LEFT);
        float y = !Float.isNaN(this.f8911l.m9644y()) ? this.f8911l.m9644y() : ((C2577l) this.t).m9758b(C2539a.LEFT);
        this.B = (float) (((C2577l) this.t).m9766j().size() - 1);
        this.z = Math.abs(this.B - this.A);
        float abs = Math.abs(y - x);
        float z = (abs / 100.0f) * this.f8911l.m9645z();
        float A = this.f8911l.m9624A() * (abs / 100.0f);
        this.B = (float) (((C2577l) this.t).m9766j().size() - 1);
        this.z = Math.abs(this.B - this.A);
        this.f8911l.f8798A = !Float.isNaN(this.f8911l.m9643x()) ? this.f8911l.m9643x() : x - A;
        this.f8911l.f8818z = !Float.isNaN(this.f8911l.m9644y()) ? this.f8911l.m9644y() : y + z;
        this.f8911l.f8799B = Math.abs(this.f8911l.f8818z - this.f8911l.f8798A);
    }

    public float getFactor() {
        RectF k = this.J.m10102k();
        return Math.min(k.width() / 2.0f, k.height() / 2.0f) / this.f8911l.f8799B;
    }

    public float getRadius() {
        RectF k = this.J.m10102k();
        return Math.min(k.width() / 2.0f, k.height() / 2.0f);
    }

    protected float getRequiredBaseOffset() {
        return (this.f8912m.m9565p() && this.f8912m.m9574g()) ? (float) this.f8912m.f8783o : C2620f.m10053a(10.0f);
    }

    protected float getRequiredLegendOffset() {
        return this.G.m9960a().getTextSize() * 4.0f;
    }

    public int getSkipWebLineCount() {
        return this.f8910k;
    }

    public float getSliceAngle() {
        return 360.0f / ((float) ((C2577l) this.t).m9768l());
    }

    public int getWebAlpha() {
        return this.f8908i;
    }

    public int getWebColor() {
        return this.f8906g;
    }

    public int getWebColorInner() {
        return this.f8907h;
    }

    public float getWebLineWidth() {
        return this.f8904e;
    }

    public float getWebLineWidthInner() {
        return this.f8905f;
    }

    public C2538f getXAxis() {
        return this.f8912m;
    }

    public C2541g getYAxis() {
        return this.f8911l;
    }

    public float getYChartMax() {
        return this.f8911l.f8818z;
    }

    public float getYChartMin() {
        return this.f8911l.f8798A;
    }

    public float getYRange() {
        return this.f8911l.f8799B;
    }

    public void m9734h() {
        if (this.t != null) {
            m9733b();
            this.f8902a.m10034a(this.f8911l.f8798A, this.f8911l.f8818z);
            this.f8903b.m10001a(((C2577l) this.t).m9764h(), ((C2577l) this.t).m9766j());
            if (!(this.D == null || this.D.m9589e())) {
                this.G.m9964a(this.t);
            }
            m9710i();
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.t != null) {
            this.f8903b.m10018a(canvas);
            if (this.f8909j) {
                this.H.m9943c(canvas);
            }
            this.f8902a.m10037d(canvas);
            this.H.m9938a(canvas);
            if (m9660u()) {
                this.H.m9940a(canvas, this.M);
            }
            this.f8902a.m10035a(canvas);
            this.H.m9942b(canvas);
            this.G.m9961a(canvas);
            m9654b(canvas);
            m9656c(canvas);
        }
    }

    public void setDrawWeb(boolean z) {
        this.f8909j = z;
    }

    public void setSkipWebLineCount(int i) {
        this.f8910k = Math.max(0, i);
    }

    public void setWebAlpha(int i) {
        this.f8908i = i;
    }

    public void setWebColor(int i) {
        this.f8906g = i;
    }

    public void setWebColorInner(int i) {
        this.f8907h = i;
    }

    public void setWebLineWidth(float f) {
        this.f8904e = C2620f.m10053a(f);
    }

    public void setWebLineWidthInner(float f) {
        this.f8905f = C2620f.m10053a(f);
    }
}
