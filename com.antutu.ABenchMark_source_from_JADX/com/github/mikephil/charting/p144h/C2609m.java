package com.github.mikephil.charting.p144h;

import android.graphics.Canvas;
import android.graphics.PointF;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.C2562a;
import com.github.mikephil.charting.p138c.C2538f;
import com.github.mikephil.charting.p145i.C2618d;
import com.github.mikephil.charting.p145i.C2620f;
import com.github.mikephil.charting.p145i.C2621g;

/* renamed from: com.github.mikephil.charting.h.m */
public class C2609m extends C2608l {
    protected BarChart f9060h;

    public C2609m(C2621g c2621g, C2538f c2538f, C2618d c2618d, BarChart barChart) {
        super(c2621g, c2538f, c2618d);
        this.f9060h = barChart;
    }

    protected void m10010a(Canvas canvas, float f, PointF pointF) {
        float r = this.f.m9617r();
        float[] fArr = new float[]{0.0f, 0.0f};
        C2562a c2562a = (C2562a) this.f9060h.getData();
        int e = c2562a.m9761e();
        int i = this.p;
        while (i <= this.q) {
            fArr[0] = (((float) (i * e)) + (((float) i) * c2562a.m9771a())) + (c2562a.m9771a() / 2.0f);
            if (e > 1) {
                fArr[0] = fArr[0] + ((((float) e) - 1.0f) / 2.0f);
            }
            this.a.m10044a(fArr);
            if (this.o.m10087c(fArr[0]) && i >= 0 && i < this.f.m9621v().size()) {
                String str = (String) this.f.m9621v().get(i);
                if (this.f.m9620u()) {
                    float a;
                    if (i == this.f.m9621v().size() - 1) {
                        a = (float) C2620f.m10056a(this.c, str);
                        if (fArr[0] + (a / 2.0f) > this.o.m10094g()) {
                            fArr[0] = this.o.m10094g() - (a / 2.0f);
                        }
                    } else if (i == 0) {
                        a = (float) C2620f.m10056a(this.c, str);
                        if (fArr[0] - (a / 2.0f) < this.o.m10092f()) {
                            fArr[0] = (a / 2.0f) + this.o.m10092f();
                        }
                    }
                }
                m10006a(canvas, str, i, fArr[0], f, pointF, r);
            }
            i += this.f.f8786r;
        }
    }

    public void m10011c(Canvas canvas) {
        if (this.f.m9567a() && this.f.m9565p()) {
            float[] fArr = new float[]{0.0f, 0.0f};
            this.b.setColor(this.f.m9570c());
            this.b.setStrokeWidth(this.f.m9572e());
            C2562a c2562a = (C2562a) this.f9060h.getData();
            int e = c2562a.m9761e();
            int i = this.p;
            while (i < this.q) {
                fArr[0] = (((float) (i * e)) + (((float) i) * c2562a.m9771a())) - 0.5f;
                this.a.m10044a(fArr);
                if (this.o.m10087c(fArr[0])) {
                    canvas.drawLine(fArr[0], this.o.m10086c(), fArr[0], this.o.m10096h(), this.b);
                }
                i = this.f.f8786r + i;
            }
        }
    }
}
