package com.github.mikephil.charting.p144h;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.support.v4.view.MotionEventCompat;
import com.github.mikephil.charting.charts.C2551e;
import com.github.mikephil.charting.data.C2577l;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.p136a.C2522a;
import com.github.mikephil.charting.p139f.p141b.C2563d;
import com.github.mikephil.charting.p139f.p141b.C2587i;
import com.github.mikephil.charting.p142e.C2581c;
import com.github.mikephil.charting.p145i.C2620f;
import com.github.mikephil.charting.p145i.C2621g;

/* renamed from: com.github.mikephil.charting.h.j */
public class C2607j extends C2604g {
    protected C2551e f9055a;
    protected Paint f9056b;

    public C2607j(C2551e c2551e, C2522a c2522a, C2621g c2621g) {
        super(c2522a, c2621g);
        this.f9055a = c2551e;
        this.g = new Paint(1);
        this.g.setStyle(Style.STROKE);
        this.g.setStrokeWidth(2.0f);
        this.g.setColor(Color.rgb(MotionEventCompat.ACTION_MASK, 187, 115));
        this.f9056b = new Paint(1);
        this.f9056b.setStyle(Style.STROKE);
    }

    public void m9994a() {
    }

    public void m9995a(Canvas canvas) {
        C2577l c2577l = (C2577l) this.f9055a.getData();
        int i = 0;
        for (C2587i c2587i : c2577l.m9767k()) {
            i = c2587i.m9792m() > i ? c2587i.m9792m() : i;
        }
        for (C2587i c2587i2 : c2577l.m9767k()) {
            if (c2587i2.m9790k() && c2587i2.m9792m() > 0) {
                m9996a(canvas, c2587i2, i);
            }
        }
    }

    protected void m9996a(Canvas canvas, C2587i c2587i, int i) {
        int i2 = 0;
        float b = this.e.m9542b();
        float a = this.e.m9540a();
        float sliceAngle = this.f9055a.getSliceAngle();
        float factor = this.f9055a.getFactor();
        PointF centerOffsets = this.f9055a.getCenterOffsets();
        Path path = new Path();
        int i3 = 0;
        while (i2 < c2587i.m9792m()) {
            this.f.setColor(c2587i.m9777b(i2));
            PointF a2 = C2620f.m10058a(centerOffsets, ((c2587i.m9783f(i2).m9742b() - this.f9055a.getYChartMin()) * factor) * a, ((((float) i2) * sliceAngle) * b) + this.f9055a.getRotationAngle());
            if (!Float.isNaN(a2.x)) {
                if (i3 == 0) {
                    path.moveTo(a2.x, a2.y);
                    i3 = 1;
                } else {
                    path.lineTo(a2.x, a2.y);
                }
            }
            i2++;
        }
        if (c2587i.m9792m() >= i) {
            path.close();
        } else {
            path.lineTo(centerOffsets.x, centerOffsets.y);
            path.close();
        }
        if (c2587i.m9837E()) {
            Drawable B = c2587i.m9834B();
            if (B != null) {
                m9967a(canvas, path, B);
            } else {
                m9966a(canvas, path, c2587i.m9833A(), c2587i.m9835C());
            }
        }
        this.f.setStrokeWidth(c2587i.m9836D());
        this.f.setStyle(Style.STROKE);
        if (!c2587i.m9837E() || c2587i.m9835C() < MotionEventCompat.ACTION_MASK) {
            canvas.drawPath(path, this.f);
        }
    }

    public void m9997a(Canvas canvas, C2581c[] c2581cArr) {
        float b = this.e.m9542b();
        float a = this.e.m9540a();
        float sliceAngle = this.f9055a.getSliceAngle();
        float factor = this.f9055a.getFactor();
        PointF centerOffsets = this.f9055a.getCenterOffsets();
        for (int i = 0; i < c2581cArr.length; i++) {
            C2587i c2587i = (C2587i) ((C2577l) this.f9055a.getData()).m9756a(c2581cArr[i].m9883a());
            if (c2587i != null && c2587i.m9784f()) {
                int b2 = c2581cArr[i].m9885b();
                Entry e = c2587i.m9781e(b2);
                if (e != null && e.m9743d() == b2) {
                    b2 = c2587i.m9773a(e);
                    float b3 = e.m9742b() - this.f9055a.getYChartMin();
                    if (!Float.isNaN(b3)) {
                        PointF a2 = C2620f.m10058a(centerOffsets, (b3 * factor) * a, ((((float) b2) * sliceAngle) * b) + this.f9055a.getRotationAngle());
                        m9965a(canvas, new float[]{a2.x, a2.y}, c2587i);
                    }
                }
            }
        }
    }

    public void m9998b(Canvas canvas) {
        float b = this.e.m9542b();
        float a = this.e.m9540a();
        float sliceAngle = this.f9055a.getSliceAngle();
        float factor = this.f9055a.getFactor();
        PointF centerOffsets = this.f9055a.getCenterOffsets();
        float a2 = C2620f.m10053a(5.0f);
        for (int i = 0; i < ((C2577l) this.f9055a.getData()).m9761e(); i++) {
            C2587i c2587i = (C2587i) ((C2577l) this.f9055a.getData()).m9756a(i);
            if (c2587i.m9789j() && c2587i.m9792m() != 0) {
                m9941a((C2563d) c2587i);
                for (int i2 = 0; i2 < c2587i.m9792m(); i2++) {
                    Entry f = c2587i.m9783f(i2);
                    PointF a3 = C2620f.m10058a(centerOffsets, ((f.m9742b() - this.f9055a.getYChartMin()) * factor) * a, ((((float) i2) * sliceAngle) * b) + this.f9055a.getRotationAngle());
                    m9939a(canvas, c2587i.m9786g(), f.m9742b(), f, i, a3.x, a3.y - a2, c2587i.m9780d(i2));
                }
            }
        }
    }

    public void m9999c(Canvas canvas) {
        m10000d(canvas);
    }

    protected void m10000d(Canvas canvas) {
        int i;
        float sliceAngle = this.f9055a.getSliceAngle();
        float factor = this.f9055a.getFactor();
        float rotationAngle = this.f9055a.getRotationAngle();
        PointF centerOffsets = this.f9055a.getCenterOffsets();
        this.f9056b.setStrokeWidth(this.f9055a.getWebLineWidth());
        this.f9056b.setColor(this.f9055a.getWebColor());
        this.f9056b.setAlpha(this.f9055a.getWebAlpha());
        int skipWebLineCount = this.f9055a.getSkipWebLineCount() + 1;
        for (i = 0; i < ((C2577l) this.f9055a.getData()).m9768l(); i += skipWebLineCount) {
            PointF a = C2620f.m10058a(centerOffsets, this.f9055a.getYRange() * factor, (((float) i) * sliceAngle) + rotationAngle);
            canvas.drawLine(centerOffsets.x, centerOffsets.y, a.x, a.y, this.f9056b);
        }
        this.f9056b.setStrokeWidth(this.f9055a.getWebLineWidthInner());
        this.f9056b.setColor(this.f9055a.getWebColorInner());
        this.f9056b.setAlpha(this.f9055a.getWebAlpha());
        int i2 = this.f9055a.getYAxis().f8806n;
        for (skipWebLineCount = 0; skipWebLineCount < i2; skipWebLineCount++) {
            for (i = 0; i < ((C2577l) this.f9055a.getData()).m9768l(); i++) {
                float yChartMin = (this.f9055a.getYAxis().f8805m[skipWebLineCount] - this.f9055a.getYChartMin()) * factor;
                PointF a2 = C2620f.m10058a(centerOffsets, yChartMin, (((float) i) * sliceAngle) + rotationAngle);
                a = C2620f.m10058a(centerOffsets, yChartMin, (((float) (i + 1)) * sliceAngle) + rotationAngle);
                canvas.drawLine(a2.x, a2.y, a.x, a.y, this.f9056b);
            }
        }
    }
}
