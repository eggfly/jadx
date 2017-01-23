package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import com.github.mikephil.charting.data.C2560e;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.p138c.C2533c.C2532c;
import com.github.mikephil.charting.p138c.C2538f;
import com.github.mikephil.charting.p139f.p141b.C2563d;
import com.github.mikephil.charting.p143g.C2595f;
import com.github.mikephil.charting.p145i.C2617c;
import com.github.mikephil.charting.p145i.C2620f;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.github.mikephil.charting.charts.d */
public abstract class C2548d<T extends C2560e<? extends C2563d<? extends Entry>>> extends C2543b<T> {
    private float f8883a;
    private float f8884b;
    protected boolean f8885c;
    protected float f8886d;

    public C2548d(Context context) {
        super(context);
        this.f8883a = 270.0f;
        this.f8884b = 270.0f;
        this.f8885c = true;
        this.f8886d = 0.0f;
    }

    public C2548d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8883a = 270.0f;
        this.f8884b = 270.0f;
        this.f8885c = true;
        this.f8886d = 0.0f;
    }

    public C2548d(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8883a = 270.0f;
        this.f8884b = 270.0f;
        this.f8885c = true;
        this.f8886d = 0.0f;
    }

    public float m9702a(float f, float f2) {
        PointF centerOffsets = getCenterOffsets();
        double d = (double) (f - centerOffsets.x);
        double d2 = (double) (f2 - centerOffsets.y);
        float toDegrees = (float) Math.toDegrees(Math.acos(d2 / Math.sqrt((d * d) + (d2 * d2))));
        if (f > centerOffsets.x) {
            toDegrees = 360.0f - toDegrees;
        }
        toDegrees += 90.0f;
        return toDegrees > 360.0f ? toDegrees - 360.0f : toDegrees;
    }

    public abstract int m9703a(float f);

    protected PointF m9704a(PointF pointF, float f, float f2) {
        return new PointF((float) (((double) pointF.x) + (((double) f) * Math.cos(Math.toRadians((double) f2)))), (float) (((double) pointF.y) + (((double) f) * Math.sin(Math.toRadians((double) f2)))));
    }

    protected void m9705a() {
        super.m9647a();
        this.F = new C2595f(this);
    }

    public float m9706b(float f, float f2) {
        PointF centerOffsets = getCenterOffsets();
        return (float) Math.sqrt(Math.pow((double) (f2 > centerOffsets.y ? f2 - centerOffsets.y : centerOffsets.y - f2), 2.0d) + Math.pow((double) (f > centerOffsets.x ? f - centerOffsets.x : centerOffsets.x - f), 2.0d));
    }

    public List<C2617c> m9707b(int i) {
        List<C2617c> arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.t.m9761e(); i2++) {
            C2563d a = this.t.m9756a(i2);
            float g = a.m9785g(i);
            if (g != Float.NaN) {
                arrayList.add(new C2617c(g, i2, a));
            }
        }
        return arrayList;
    }

    protected void m9708b() {
        this.z = (float) (this.t.m9766j().size() - 1);
    }

    public void computeScroll() {
        if (this.F instanceof C2595f) {
            ((C2595f) this.F).m9933b();
        }
    }

    public float getDiameter() {
        RectF k = this.J.m10102k();
        return Math.min(k.width(), k.height());
    }

    public float getMinOffset() {
        return this.f8886d;
    }

    public abstract float getRadius();

    public float getRawRotationAngle() {
        return this.f8884b;
    }

    protected abstract float getRequiredBaseOffset();

    protected abstract float getRequiredLegendOffset();

    public float getRotationAngle() {
        return this.f8883a;
    }

    public float getYChartMax() {
        return 0.0f;
    }

    public float getYChartMin() {
        return 0.0f;
    }

    public void m9709h() {
        if (this.t != null) {
            m9708b();
            if (this.D != null) {
                this.G.m9964a(this.t);
            }
            m9710i();
        }
    }

    public void m9710i() {
        float f;
        float f2;
        float f3;
        float min;
        float b;
        float f4 = 0.0f;
        if (this.D == null || !this.D.m9565p()) {
            f = 0.0f;
            f2 = 0.0f;
            f3 = 0.0f;
        } else {
            min = (Math.min(this.D.f8742a, this.J.m10105n() * this.D.m9598t()) + this.D.m9593i()) + this.D.m9596r();
            if (this.D.m9590f() == C2532c.RIGHT_OF_CHART_CENTER) {
                f = min + C2620f.m10053a(13.0f);
                f2 = 0.0f;
                min = 0.0f;
            } else if (this.D.m9590f() == C2532c.RIGHT_OF_CHART) {
                f = C2620f.m10053a(8.0f) + min;
                min = this.D.f8743b + this.D.f8744c;
                r3 = getCenter();
                r4 = new PointF((((float) getWidth()) - f) + 15.0f, min + 15.0f);
                min = m9706b(r4.x, r4.y);
                r5 = m9704a(r3, getRadius(), m9702a(r4.x, r4.y));
                b = m9706b(r5.x, r5.y);
                min = min < b ? (b - min) + C2620f.m10053a(5.0f) : 0.0f;
                if (r4.y >= r3.y && ((float) getHeight()) - f > ((float) getWidth())) {
                    min = f;
                }
                f = min;
                f2 = 0.0f;
                min = 0.0f;
            } else if (this.D.m9590f() == C2532c.LEFT_OF_CHART_CENTER) {
                f = 0.0f;
                f2 = min + C2620f.m10053a(13.0f);
                min = 0.0f;
            } else if (this.D.m9590f() == C2532c.LEFT_OF_CHART) {
                f = C2620f.m10053a(8.0f) + min;
                min = this.D.f8743b + this.D.f8744c;
                r3 = getCenter();
                r4 = new PointF(f - 15.0f, min + 15.0f);
                min = m9706b(r4.x, r4.y);
                r5 = m9704a(r3, getRadius(), m9702a(r4.x, r4.y));
                b = m9706b(r5.x, r5.y);
                min = min < b ? (b - min) + C2620f.m10053a(5.0f) : 0.0f;
                if (r4.y >= r3.y && ((float) getHeight()) - f > ((float) getWidth())) {
                    min = f;
                }
                f = 0.0f;
                f2 = min;
                min = 0.0f;
            } else if (this.D.m9590f() == C2532c.BELOW_CHART_LEFT || this.D.m9590f() == C2532c.BELOW_CHART_RIGHT || this.D.m9590f() == C2532c.BELOW_CHART_CENTER) {
                min = Math.min(getRequiredLegendOffset() + this.D.f8743b, this.J.m10104m() * this.D.m9598t());
                f = 0.0f;
                f2 = 0.0f;
            } else if (this.D.m9590f() == C2532c.ABOVE_CHART_LEFT || this.D.m9590f() == C2532c.ABOVE_CHART_RIGHT || this.D.m9590f() == C2532c.ABOVE_CHART_CENTER) {
                f = 0.0f;
                f2 = 0.0f;
                min = 0.0f;
                f4 = Math.min(getRequiredLegendOffset() + this.D.f8743b, this.J.m10104m() * this.D.m9598t());
            } else {
                min = 0.0f;
                f = 0.0f;
                f2 = 0.0f;
            }
            f4 += getRequiredBaseOffset();
            f3 = f2 + getRequiredBaseOffset();
            f2 = f + getRequiredBaseOffset();
            f = min;
        }
        b = C2620f.m10053a(this.f8886d);
        if (this instanceof C2551e) {
            C2538f xAxis = ((C2551e) this).getXAxis();
            if (xAxis.m9565p() && xAxis.m9574g()) {
                min = Math.max(b, (float) xAxis.f8783o);
                f4 += getExtraTopOffset();
                f2 += getExtraRightOffset();
                f += getExtraBottomOffset();
                f3 = Math.max(min, f3 + getExtraLeftOffset());
                f4 = Math.max(min, f4);
                f2 = Math.max(min, f2);
                min = Math.max(min, Math.max(getRequiredBaseOffset(), f));
                this.J.m10080a(f3, f4, f2, min);
                if (this.s) {
                    Log.i("MPAndroidChart", "offsetLeft: " + f3 + ", offsetTop: " + f4 + ", offsetRight: " + f2 + ", offsetBottom: " + min);
                }
            }
        }
        min = b;
        f4 += getExtraTopOffset();
        f2 += getExtraRightOffset();
        f += getExtraBottomOffset();
        f3 = Math.max(min, f3 + getExtraLeftOffset());
        f4 = Math.max(min, f4);
        f2 = Math.max(min, f2);
        min = Math.max(min, Math.max(getRequiredBaseOffset(), f));
        this.J.m10080a(f3, f4, f2, min);
        if (this.s) {
            Log.i("MPAndroidChart", "offsetLeft: " + f3 + ", offsetTop: " + f4 + ", offsetRight: " + f2 + ", offsetBottom: " + min);
        }
    }

    public boolean m9711j() {
        return this.f8885c;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return (!this.C || this.F == null) ? super.onTouchEvent(motionEvent) : this.F.onTouch(this, motionEvent);
    }

    public void setMinOffset(float f) {
        this.f8886d = f;
    }

    public void setRotationAngle(float f) {
        this.f8884b = f;
        this.f8883a = C2620f.m10074c(this.f8884b);
    }

    public void setRotationEnabled(boolean z) {
        this.f8885c = z;
    }
}
