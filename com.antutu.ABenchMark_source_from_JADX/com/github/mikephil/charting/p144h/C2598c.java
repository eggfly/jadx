package com.github.mikephil.charting.p144h;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.support.v4.view.MotionEventCompat;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.p039d.C1202f;
import com.github.mikephil.charting.p136a.C2522a;
import com.github.mikephil.charting.p139f.p141b.C2563d;
import com.github.mikephil.charting.p142e.C2581c;
import com.github.mikephil.charting.p145i.C2620f;
import com.github.mikephil.charting.p145i.C2621g;

/* renamed from: com.github.mikephil.charting.h.c */
public abstract class C2598c extends C2596k {
    protected C2522a f9018e;
    protected Paint f9019f;
    protected Paint f9020g;
    protected Paint f9021h;
    protected Paint f9022i;

    public C2598c(C2522a c2522a, C2621g c2621g) {
        super(c2621g);
        this.f9018e = c2522a;
        this.f9019f = new Paint(1);
        this.f9019f.setStyle(Style.FILL);
        this.f9021h = new Paint(4);
        this.f9022i = new Paint(1);
        this.f9022i.setColor(Color.rgb(63, 63, 63));
        this.f9022i.setTextAlign(Align.CENTER);
        this.f9022i.setTextSize(C2620f.m10053a(9.0f));
        this.f9020g = new Paint(1);
        this.f9020g.setStyle(Style.STROKE);
        this.f9020g.setStrokeWidth(2.0f);
        this.f9020g.setColor(Color.rgb(MotionEventCompat.ACTION_MASK, 187, 115));
    }

    public abstract void m9937a();

    public abstract void m9938a(Canvas canvas);

    public void m9939a(Canvas canvas, C1202f c1202f, float f, Entry entry, int i, float f2, float f3, int i2) {
        this.f9022i.setColor(i2);
        canvas.drawText(c1202f.m4963a(f, entry, i, this.o), f2, f3, this.f9022i);
    }

    public abstract void m9940a(Canvas canvas, C2581c[] c2581cArr);

    protected void m9941a(C2563d c2563d) {
        this.f9022i.setTypeface(c2563d.m9787h());
        this.f9022i.setTextSize(c2563d.m9788i());
    }

    public abstract void m9942b(Canvas canvas);

    public abstract void m9943c(Canvas canvas);
}
