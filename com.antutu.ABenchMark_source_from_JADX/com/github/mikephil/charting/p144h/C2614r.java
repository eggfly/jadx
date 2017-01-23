package com.github.mikephil.charting.p144h;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PointF;
import com.github.mikephil.charting.charts.C2551e;
import com.github.mikephil.charting.data.C2577l;
import com.github.mikephil.charting.p138c.C2535d;
import com.github.mikephil.charting.p138c.C2541g;
import com.github.mikephil.charting.p145i.C2620f;
import com.github.mikephil.charting.p145i.C2621g;
import java.util.List;

/* renamed from: com.github.mikephil.charting.h.r */
public class C2614r extends C2612p {
    private C2551e f9064h;

    public C2614r(C2621g c2621g, C2541g c2541g, C2551e c2551e) {
        super(c2621g, c2541g, null);
        this.f9064h = c2551e;
    }

    public void m10034a(float f, float f2) {
        m10036b(f, f2);
    }

    public void m10035a(Canvas canvas) {
        if (this.f.m9565p() && this.f.m9574g()) {
            this.c.setTypeface(this.f.m9562m());
            this.c.setTextSize(this.f.m9563n());
            this.c.setColor(this.f.m9564o());
            PointF centerOffsets = this.f9064h.getCenterOffsets();
            float factor = this.f9064h.getFactor();
            int i = this.f.f8806n;
            int i2 = 0;
            while (i2 < i) {
                if (i2 != i - 1 || this.f.m9638s()) {
                    PointF a = C2620f.m10058a(centerOffsets, (this.f.f8805m[i2] - this.f.f8798A) * factor, this.f9064h.getRotationAngle());
                    canvas.drawText(this.f.m9632a(i2), a.x + 10.0f, a.y, this.c);
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    protected void m10036b(float f, float f2) {
        int t = this.f.m9639t();
        double abs = (double) Math.abs(f2 - f);
        if (t == 0 || abs <= 0.0d) {
            this.f.f8805m = new float[0];
            this.f.f8806n = 0;
            return;
        }
        double a = (double) C2620f.m10052a(abs / ((double) t));
        double pow = Math.pow(10.0d, (double) ((int) Math.log10(a)));
        if (((int) (a / pow)) > 5) {
            a = Math.floor(10.0d * pow);
        }
        int i;
        if (this.f.m9640u()) {
            float f3 = ((float) abs) / ((float) (t - 1));
            this.f.f8806n = t;
            if (this.f.f8805m.length < t) {
                this.f.f8805m = new float[t];
            }
            float f4 = f;
            for (i = 0; i < t; i++) {
                this.f.f8805m[i] = f4;
                f4 += f3;
            }
        } else if (this.f.m9641v()) {
            this.f.f8806n = 2;
            r3 = new float[2];
            this.f.f8805m = r3;
            this.f.f8805m[0] = f;
            this.f.f8805m[1] = f2;
        } else {
            abs = ((double) f) / a;
            abs = abs < 0.0d ? Math.floor(abs) * a : Math.ceil(abs) * a;
            if (abs == 0.0d) {
                abs = 0.0d;
            }
            t = 0;
            for (pow = abs; pow <= C2620f.m10066b(Math.floor(((double) f2) / a) * a); pow += a) {
                t++;
            }
            if (Float.isNaN(this.f.m9644y())) {
                t++;
            }
            this.f.f8806n = t;
            if (this.f.f8805m.length < t) {
                this.f.f8805m = new float[t];
            }
            pow = abs;
            for (i = 0; i < t; i++) {
                this.f.f8805m[i] = (float) pow;
                pow += a;
            }
        }
        if (a < 1.0d) {
            this.f.f8807o = (int) Math.ceil(-Math.log10(a));
        } else {
            this.f.f8807o = 0;
        }
        if (this.f.f8805m[0] < f) {
            this.f.f8798A = this.f.f8805m[0];
        }
        this.f.f8818z = this.f.f8805m[this.f.f8806n - 1];
        this.f.f8799B = Math.abs(this.f.f8818z - this.f.f8798A);
    }

    public void m10037d(Canvas canvas) {
        List h = this.f.m9575h();
        if (h != null) {
            float sliceAngle = this.f9064h.getSliceAngle();
            float factor = this.f9064h.getFactor();
            PointF centerOffsets = this.f9064h.getCenterOffsets();
            for (int i = 0; i < h.size(); i++) {
                C2535d c2535d = (C2535d) h.get(i);
                if (c2535d.m9565p()) {
                    this.e.setColor(c2535d.m9604c());
                    this.e.setPathEffect(c2535d.m9605d());
                    this.e.setStrokeWidth(c2535d.m9603b());
                    float a = (c2535d.m9602a() - this.f9064h.getYChartMin()) * factor;
                    Path path = new Path();
                    for (int i2 = 0; i2 < ((C2577l) this.f9064h.getData()).m9768l(); i2++) {
                        PointF a2 = C2620f.m10058a(centerOffsets, a, (((float) i2) * sliceAngle) + this.f9064h.getRotationAngle());
                        if (i2 == 0) {
                            path.moveTo(a2.x, a2.y);
                        } else {
                            path.lineTo(a2.x, a2.y);
                        }
                    }
                    path.close();
                    canvas.drawPath(path, this.e);
                }
            }
        }
    }
}
