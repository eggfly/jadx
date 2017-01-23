package com.github.mikephil.charting.p137b;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.p139f.p141b.C2574e;

/* renamed from: com.github.mikephil.charting.b.c */
public class C2525c extends C2523a<C2574e> {
    public C2525c(int i) {
        super(i);
    }

    public void m9553a(C2574e c2574e) {
        int ceil = (int) Math.ceil((double) ((((float) (this.f - this.e)) * this.c) + ((float) this.e)));
        for (int i = this.e; i < ceil; i++) {
            Entry f = c2574e.m9783f(i);
            m9554b((float) f.m9743d(), f.m9742b() * this.d);
        }
        m9543a();
    }

    protected void m9554b(float f, float f2) {
        float[] fArr = this.b;
        int i = this.a;
        this.a = i + 1;
        fArr[i] = f;
        fArr = this.b;
        i = this.a;
        this.a = i + 1;
        fArr[i] = f2;
    }
}
