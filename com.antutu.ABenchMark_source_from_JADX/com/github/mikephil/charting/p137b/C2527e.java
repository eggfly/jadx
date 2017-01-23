package com.github.mikephil.charting.p137b;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.p139f.p141b.C2574e;

/* renamed from: com.github.mikephil.charting.b.e */
public class C2527e extends C2523a<C2574e> {
    public C2527e(int i) {
        if (i < 4) {
            i = 4;
        }
        super(i);
    }

    public void m9556a(C2574e c2574e) {
        m9557b((float) c2574e.m9783f(this.e).m9743d(), c2574e.m9783f(this.e).m9742b() * this.d);
        int ceil = (int) Math.ceil((double) ((((float) (this.f - this.e)) * this.c) + ((float) this.e)));
        for (int i = this.e + 1; i < ceil; i++) {
            Entry f = c2574e.m9783f(i);
            m9558c((float) f.m9743d(), f.m9742b() * this.d);
        }
        m9543a();
    }

    public void m9557b(float f, float f2) {
        if (this.a == 0) {
            float[] fArr = this.b;
            int i = this.a;
            this.a = i + 1;
            fArr[i] = f;
            fArr = this.b;
            i = this.a;
            this.a = i + 1;
            fArr[i] = f2;
            this.b[this.a] = f;
            this.b[this.a + 1] = f2;
        }
    }

    public void m9558c(float f, float f2) {
        if (this.a == 2) {
            float[] fArr = this.b;
            int i = this.a;
            this.a = i + 1;
            fArr[i] = f;
            fArr = this.b;
            i = this.a;
            this.a = i + 1;
            fArr[i] = f2;
            return;
        }
        float f3 = this.b[this.a - 2];
        float f4 = this.b[this.a - 1];
        float[] fArr2 = this.b;
        int i2 = this.a;
        this.a = i2 + 1;
        fArr2[i2] = f3;
        fArr = this.b;
        int i3 = this.a;
        this.a = i3 + 1;
        fArr[i3] = f4;
        fArr = this.b;
        i = this.a;
        this.a = i + 1;
        fArr[i] = f;
        fArr = this.b;
        i = this.a;
        this.a = i + 1;
        fArr[i] = f2;
    }
}
