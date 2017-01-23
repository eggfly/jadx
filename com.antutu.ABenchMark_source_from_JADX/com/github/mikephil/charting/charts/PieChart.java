package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import com.github.mikephil.charting.data.C2576k;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.p139f.p141b.C2586h;
import com.github.mikephil.charting.p142e.C2581c;
import com.github.mikephil.charting.p144h.C2606i;
import com.github.mikephil.charting.p145i.C2620f;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.List;

public class PieChart extends C2548d<C2576k> {
    protected float f8887a;
    protected float f8888b;
    private RectF f8889e;
    private boolean f8890f;
    private float[] f8891g;
    private float[] f8892h;
    private boolean f8893i;
    private boolean f8894j;
    private boolean f8895k;
    private boolean f8896l;
    private CharSequence f8897m;
    private float f8898n;
    private boolean f8899o;
    private float f8900p;

    public PieChart(Context context) {
        super(context);
        this.f8889e = new RectF();
        this.f8890f = true;
        this.f8893i = true;
        this.f8894j = false;
        this.f8895k = false;
        this.f8896l = false;
        this.f8897m = BuildConfig.FLAVOR;
        this.f8898n = 50.0f;
        this.f8887a = 55.0f;
        this.f8899o = true;
        this.f8900p = 100.0f;
        this.f8888b = 360.0f;
    }

    public PieChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8889e = new RectF();
        this.f8890f = true;
        this.f8893i = true;
        this.f8894j = false;
        this.f8895k = false;
        this.f8896l = false;
        this.f8897m = BuildConfig.FLAVOR;
        this.f8898n = 50.0f;
        this.f8887a = 55.0f;
        this.f8899o = true;
        this.f8900p = 100.0f;
        this.f8888b = 360.0f;
    }

    public PieChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8889e = new RectF();
        this.f8890f = true;
        this.f8893i = true;
        this.f8894j = false;
        this.f8895k = false;
        this.f8896l = false;
        this.f8897m = BuildConfig.FLAVOR;
        this.f8898n = 50.0f;
        this.f8887a = 55.0f;
        this.f8899o = true;
        this.f8900p = 100.0f;
        this.f8888b = 360.0f;
    }

    private float m9712d(float f, float f2) {
        return (f / f2) * this.f8888b;
    }

    private void m9713k() {
        this.f8891g = new float[((C2576k) this.t).m9765i()];
        this.f8892h = new float[((C2576k) this.t).m9765i()];
        float b = ((C2576k) this.t).m9870b();
        List k = ((C2576k) this.t).m9767k();
        int i = 0;
        for (int i2 = 0; i2 < ((C2576k) this.t).m9761e(); i2++) {
            C2586h c2586h = (C2586h) k.get(i2);
            int i3 = 0;
            while (i3 < c2586h.m9792m()) {
                this.f8891g[i] = m9712d(Math.abs(c2586h.m9783f(i3).m9742b()), b);
                if (i == 0) {
                    this.f8892h[i] = this.f8891g[i];
                } else {
                    this.f8892h[i] = this.f8892h[i - 1] + this.f8891g[i];
                }
                i3++;
                i++;
            }
        }
    }

    public int m9714a(float f) {
        float c = C2620f.m10074c(f - getRotationAngle());
        for (int i = 0; i < this.f8892h.length; i++) {
            if (this.f8892h[i] > c) {
                return i;
            }
        }
        return -1;
    }

    protected void m9715a() {
        super.m9705a();
        this.H = new C2606i(this, this.K, this.J);
    }

    public boolean m9716a(int i, int i2) {
        if (!m9660u() || i2 < 0) {
            return false;
        }
        int i3 = 0;
        while (i3 < this.M.length) {
            if (this.M[i3].m9885b() == i && this.M[i3].m9883a() == i2) {
                return true;
            }
            i3++;
        }
        return false;
    }

    protected float[] m9717a(Entry entry, C2581c c2581c) {
        PointF centerCircleBox = getCenterCircleBox();
        float radius = getRadius();
        float f = (radius / 10.0f) * 3.6f;
        if (m9720d()) {
            f = (radius - ((radius / 100.0f) * getHoleRadius())) / 2.0f;
        }
        f = radius - f;
        radius = getRotationAngle();
        int d = entry.m9743d();
        float f2 = this.f8891g[d] / 2.0f;
        float cos = (float) ((((double) f) * Math.cos(Math.toRadians((double) (((this.f8892h[d] + radius) - f2) * this.K.m9540a())))) + ((double) centerCircleBox.x));
        f = (float) (((double) centerCircleBox.y) + (Math.sin(Math.toRadians((double) (((this.f8892h[d] + radius) - f2) * this.K.m9540a()))) * ((double) f)));
        return new float[]{cos, f};
    }

    protected void m9718b() {
        super.m9708b();
        m9713k();
    }

    public boolean m9719c() {
        return this.f8894j;
    }

    public boolean m9720d() {
        return this.f8893i;
    }

    public boolean m9721e() {
        return this.f8899o;
    }

    public boolean m9722f() {
        return this.f8890f;
    }

    public boolean m9723g() {
        return this.f8895k;
    }

    public float[] getAbsoluteAngles() {
        return this.f8892h;
    }

    public PointF getCenterCircleBox() {
        return new PointF(this.f8889e.centerX(), this.f8889e.centerY());
    }

    public CharSequence getCenterText() {
        return this.f8897m;
    }

    public float getCenterTextRadiusPercent() {
        return this.f8900p;
    }

    public RectF getCircleBox() {
        return this.f8889e;
    }

    public float[] getDrawAngles() {
        return this.f8891g;
    }

    public float getHoleRadius() {
        return this.f8898n;
    }

    public float getMaxAngle() {
        return this.f8888b;
    }

    public float getRadius() {
        return this.f8889e == null ? 0.0f : Math.min(this.f8889e.width() / 2.0f, this.f8889e.height() / 2.0f);
    }

    protected float getRequiredBaseOffset() {
        return 0.0f;
    }

    protected float getRequiredLegendOffset() {
        return this.G.m9960a().getTextSize() * 2.0f;
    }

    public float getTransparentCircleRadius() {
        return this.f8887a;
    }

    public void m9724i() {
        super.m9710i();
        if (this.t != null) {
            float diameter = getDiameter() / 2.0f;
            PointF centerOffsets = getCenterOffsets();
            float d = ((C2576k) this.t).m9869a().m9901d();
            this.f8889e.set((centerOffsets.x - diameter) + d, (centerOffsets.y - diameter) + d, (centerOffsets.x + diameter) - d, (diameter + centerOffsets.y) - d);
        }
    }

    protected void onDetachedFromWindow() {
        if (this.H != null && (this.H instanceof C2606i)) {
            ((C2606i) this.H).m9992e();
        }
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.t != null) {
            this.H.m9938a(canvas);
            if (m9660u()) {
                this.H.m9940a(canvas, this.M);
            }
            this.H.m9943c(canvas);
            this.H.m9942b(canvas);
            this.G.m9961a(canvas);
            m9654b(canvas);
            m9656c(canvas);
        }
    }

    public void setCenterText(CharSequence charSequence) {
        if (charSequence == null) {
            this.f8897m = BuildConfig.FLAVOR;
        } else {
            this.f8897m = charSequence;
        }
    }

    public void setCenterTextColor(int i) {
        ((C2606i) this.H).m9990d().setColor(i);
    }

    public void setCenterTextRadiusPercent(float f) {
        this.f8900p = f;
    }

    public void setCenterTextSize(float f) {
        ((C2606i) this.H).m9990d().setTextSize(C2620f.m10053a(f));
    }

    public void setCenterTextSizePixels(float f) {
        ((C2606i) this.H).m9990d().setTextSize(f);
    }

    public void setCenterTextTypeface(Typeface typeface) {
        ((C2606i) this.H).m9990d().setTypeface(typeface);
    }

    public void setDrawCenterText(boolean z) {
        this.f8899o = z;
    }

    public void setDrawHoleEnabled(boolean z) {
        this.f8893i = z;
    }

    public void setDrawSliceText(boolean z) {
        this.f8890f = z;
    }

    public void setDrawSlicesUnderHole(boolean z) {
        this.f8894j = z;
    }

    public void setHoleColor(int i) {
        ((C2606i) this.H).m9986b().setColor(i);
    }

    public void setHoleRadius(float f) {
        this.f8898n = f;
    }

    public void setMaxAngle(float f) {
        float f2 = 360.0f;
        float f3 = 90.0f;
        if (f <= 360.0f) {
            f2 = f;
        }
        if (f2 >= 90.0f) {
            f3 = f2;
        }
        this.f8888b = f3;
    }

    public void setTransparentCircleAlpha(int i) {
        ((C2606i) this.H).m9988c().setAlpha(i);
    }

    public void setTransparentCircleColor(int i) {
        Paint c = ((C2606i) this.H).m9988c();
        int alpha = c.getAlpha();
        c.setColor(i);
        c.setAlpha(alpha);
    }

    public void setTransparentCircleRadius(float f) {
        this.f8887a = f;
    }

    public void setUsePercentValues(boolean z) {
        this.f8895k = z;
    }
}
