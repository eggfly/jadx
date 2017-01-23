package com.github.mikephil.charting.p144h;

import android.graphics.Canvas;
import android.graphics.PointF;
import com.github.mikephil.charting.charts.C2551e;
import com.github.mikephil.charting.p138c.C2538f;
import com.github.mikephil.charting.p145i.C2620f;
import com.github.mikephil.charting.p145i.C2621g;

/* renamed from: com.github.mikephil.charting.h.o */
public class C2611o extends C2608l {
    private C2551e f9061h;

    public C2611o(C2621g c2621g, C2538f c2538f, C2551e c2551e) {
        super(c2621g, c2538f, null);
        this.f9061h = c2551e;
    }

    public void m10018a(Canvas canvas) {
        if (this.f.m9565p() && this.f.m9574g()) {
            float r = this.f.m9617r();
            PointF pointF = new PointF(0.5f, 0.0f);
            this.c.setTypeface(this.f.m9562m());
            this.c.setTextSize(this.f.m9563n());
            this.c.setColor(this.f.m9564o());
            float sliceAngle = this.f9061h.getSliceAngle();
            float factor = this.f9061h.getFactor();
            PointF centerOffsets = this.f9061h.getCenterOffsets();
            int i = this.f.f8786r;
            for (int i2 = 0; i2 < this.f.m9621v().size(); i2 += i) {
                String str = (String) this.f.m9621v().get(i2);
                PointF a = C2620f.m10058a(centerOffsets, (this.f9061h.getYRange() * factor) + (((float) this.f.f8783o) / 2.0f), ((((float) i2) * sliceAngle) + this.f9061h.getRotationAngle()) % 360.0f);
                m10006a(canvas, str, i2, a.x, a.y - (((float) this.f.f8784p) / 2.0f), pointF, r);
            }
        }
    }

    public void m10019d(Canvas canvas) {
    }
}
