package com.github.mikephil.charting.p145i;

/* renamed from: com.github.mikephil.charting.i.e */
public class C2619e extends C2618d {
    public C2619e(C2621g c2621g) {
        super(c2621g);
    }

    public void m10051a(boolean z) {
        this.b.reset();
        if (z) {
            this.b.setTranslate(-(this.c.m10105n() - this.c.m10082b()), this.c.m10104m() - this.c.m10088d());
            this.b.postScale(-1.0f, 1.0f);
            return;
        }
        this.b.postTranslate(this.c.m10076a(), this.c.m10104m() - this.c.m10088d());
    }
}
