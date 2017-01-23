package com.github.mikephil.charting.p144h;

import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.C2562a;
import com.github.mikephil.charting.p138c.C2535d;
import com.github.mikephil.charting.p138c.C2535d.C2534a;
import com.github.mikephil.charting.p138c.C2538f;
import com.github.mikephil.charting.p138c.C2538f.C2537a;
import com.github.mikephil.charting.p145i.C2615a;
import com.github.mikephil.charting.p145i.C2618d;
import com.github.mikephil.charting.p145i.C2620f;
import com.github.mikephil.charting.p145i.C2621g;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.List;

/* renamed from: com.github.mikephil.charting.h.n */
public class C2610n extends C2609m {
    public C2610n(C2621g c2621g, C2538f c2538f, C2618d c2618d, BarChart barChart) {
        super(c2621g, c2538f, c2618d, barChart);
    }

    public void m10012a(float f, List<String> list) {
        this.c.setTypeface(this.f.m9562m());
        this.c.setTextSize(this.f.m9563n());
        this.f.m9615a((List) list);
        C2615a c = C2620f.m10075c(this.c, this.f.m9623x());
        float k = (float) ((int) (c.f9065a + (this.f.m9560k() * 3.5f)));
        float f2 = c.f9066b;
        c = C2620f.m10059a(c.f9065a, f2, this.f.m9617r());
        this.f.f8781m = Math.round(k);
        this.f.f8782n = Math.round(f2);
        this.f.f8783o = (int) (c.f9065a + (this.f.m9560k() * 3.5f));
        this.f.f8784p = Math.round(c.f9066b);
    }

    public void m10013a(Canvas canvas) {
        if (this.f.m9565p() && this.f.m9574g()) {
            float k = this.f.m9560k();
            this.c.setTypeface(this.f.m9562m());
            this.c.setTextSize(this.f.m9563n());
            this.c.setColor(this.f.m9564o());
            if (this.f.m9616q() == C2537a.TOP) {
                m10014a(canvas, k + this.o.m10094g(), new PointF(0.0f, 0.5f));
            } else if (this.f.m9616q() == C2537a.TOP_INSIDE) {
                m10014a(canvas, this.o.m10094g() - k, new PointF(1.0f, 0.5f));
            } else if (this.f.m9616q() == C2537a.BOTTOM) {
                m10014a(canvas, this.o.m10092f() - k, new PointF(1.0f, 0.5f));
            } else if (this.f.m9616q() == C2537a.BOTTOM_INSIDE) {
                m10014a(canvas, k + this.o.m10092f(), new PointF(0.0f, 0.5f));
            } else {
                m10014a(canvas, this.o.m10094g() + k, new PointF(0.0f, 0.5f));
                m10014a(canvas, this.o.m10092f() - k, new PointF(1.0f, 0.5f));
            }
        }
    }

    protected void m10014a(Canvas canvas, float f, PointF pointF) {
        float r = this.f.m9617r();
        float[] fArr = new float[]{0.0f, 0.0f};
        C2562a c2562a = (C2562a) this.h.getData();
        int e = c2562a.m9761e();
        int i = this.p;
        while (i <= this.q) {
            fArr[1] = (((float) (i * e)) + (((float) i) * c2562a.m9771a())) + (c2562a.m9771a() / 2.0f);
            if (e > 1) {
                fArr[1] = fArr[1] + ((((float) e) - 1.0f) / 2.0f);
            }
            this.a.m10044a(fArr);
            if (this.o.m10089d(fArr[1])) {
                m10006a(canvas, (String) this.f.m9621v().get(i), i, f, fArr[1], pointF, r);
            }
            i += this.f.f8786r;
        }
    }

    public void m10015b(Canvas canvas) {
        if (this.f.m9569b() && this.f.m9565p()) {
            this.d.setColor(this.f.m9573f());
            this.d.setStrokeWidth(this.f.m9571d());
            if (this.f.m9616q() == C2537a.TOP || this.f.m9616q() == C2537a.TOP_INSIDE || this.f.m9616q() == C2537a.BOTH_SIDED) {
                canvas.drawLine(this.o.m10094g(), this.o.m10090e(), this.o.m10094g(), this.o.m10096h(), this.d);
            }
            if (this.f.m9616q() == C2537a.BOTTOM || this.f.m9616q() == C2537a.BOTTOM_INSIDE || this.f.m9616q() == C2537a.BOTH_SIDED) {
                canvas.drawLine(this.o.m10092f(), this.o.m10090e(), this.o.m10092f(), this.o.m10096h(), this.d);
            }
        }
    }

    public void m10016c(Canvas canvas) {
        if (this.f.m9567a() && this.f.m9565p()) {
            float[] fArr = new float[]{0.0f, 0.0f};
            this.b.setColor(this.f.m9570c());
            this.b.setStrokeWidth(this.f.m9572e());
            C2562a c2562a = (C2562a) this.h.getData();
            int e = c2562a.m9761e();
            int i = this.p;
            while (i <= this.q) {
                fArr[1] = (((float) (i * e)) + (((float) i) * c2562a.m9771a())) - 0.5f;
                this.a.m10044a(fArr);
                if (this.o.m10089d(fArr[1])) {
                    canvas.drawLine(this.o.m10092f(), fArr[1], this.o.m10094g(), fArr[1], this.b);
                }
                i = this.f.f8786r + i;
            }
        }
    }

    public void m10017d(Canvas canvas) {
        List h = this.f.m9575h();
        if (h != null && h.size() > 0) {
            float[] fArr = new float[2];
            Path path = new Path();
            for (int i = 0; i < h.size(); i++) {
                C2535d c2535d = (C2535d) h.get(i);
                if (c2535d.m9565p()) {
                    this.e.setStyle(Style.STROKE);
                    this.e.setColor(c2535d.m9604c());
                    this.e.setStrokeWidth(c2535d.m9603b());
                    this.e.setPathEffect(c2535d.m9605d());
                    fArr[1] = c2535d.m9602a();
                    this.a.m10044a(fArr);
                    path.moveTo(this.o.m10092f(), fArr[1]);
                    path.lineTo(this.o.m10094g(), fArr[1]);
                    canvas.drawPath(path, this.e);
                    path.reset();
                    String g = c2535d.m9608g();
                    if (!(g == null || g.equals(BuildConfig.FLAVOR))) {
                        this.e.setStyle(c2535d.m9606e());
                        this.e.setPathEffect(null);
                        this.e.setColor(c2535d.m9564o());
                        this.e.setStrokeWidth(0.5f);
                        this.e.setTextSize(c2535d.m9563n());
                        float b = (float) C2620f.m10071b(this.e, g);
                        float a = C2620f.m10053a(4.0f) + c2535d.m9560k();
                        float b2 = (c2535d.m9603b() + b) + c2535d.m9561l();
                        C2534a f = c2535d.m9607f();
                        if (f == C2534a.RIGHT_TOP) {
                            this.e.setTextAlign(Align.RIGHT);
                            canvas.drawText(g, this.o.m10094g() - a, b + (fArr[1] - b2), this.e);
                        } else if (f == C2534a.RIGHT_BOTTOM) {
                            this.e.setTextAlign(Align.RIGHT);
                            canvas.drawText(g, this.o.m10094g() - a, fArr[1] + b2, this.e);
                        } else if (f == C2534a.LEFT_TOP) {
                            this.e.setTextAlign(Align.LEFT);
                            canvas.drawText(g, this.o.m10092f() + a, b + (fArr[1] - b2), this.e);
                        } else {
                            this.e.setTextAlign(Align.LEFT);
                            canvas.drawText(g, this.o.m10076a() + a, fArr[1] + b2, this.e);
                        }
                    }
                }
            }
        }
    }
}
