package com.github.mikephil.charting.p144h;

import android.graphics.Canvas;
import android.graphics.Path;
import com.github.mikephil.charting.p136a.C2522a;
import com.github.mikephil.charting.p139f.p141b.C2570g;
import com.github.mikephil.charting.p145i.C2621g;

/* renamed from: com.github.mikephil.charting.h.h */
public abstract class C2603h extends C2598c {
    private Path f9032a;

    public C2603h(C2522a c2522a, C2621g c2621g) {
        super(c2522a, c2621g);
        this.f9032a = new Path();
    }

    protected void m9965a(Canvas canvas, float[] fArr, C2570g c2570g) {
        this.g.setColor(c2570g.m9822a());
        this.g.setStrokeWidth(c2570g.m9827H());
        this.g.setPathEffect(c2570g.m9828I());
        if (c2570g.m9825F()) {
            this.f9032a.reset();
            this.f9032a.moveTo(fArr[0], this.o.m10090e());
            this.f9032a.lineTo(fArr[0], this.o.m10096h());
            canvas.drawPath(this.f9032a, this.g);
        }
        if (c2570g.m9826G()) {
            this.f9032a.reset();
            this.f9032a.moveTo(this.o.m10092f(), fArr[1]);
            this.f9032a.lineTo(this.o.m10094g(), fArr[1]);
            canvas.drawPath(this.f9032a, this.g);
        }
    }
}
