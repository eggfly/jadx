package com.github.mikephil.charting.p142e;

import com.github.mikephil.charting.p138c.C2541g.C2539a;
import com.github.mikephil.charting.p139f.p140a.C2546a;
import com.github.mikephil.charting.p139f.p141b.C2584a;

/* renamed from: com.github.mikephil.charting.e.d */
public class C2582d extends C2580a {
    public C2582d(C2546a c2546a) {
        super(c2546a);
    }

    protected int m9888a(float f) {
        if (((C2546a) this.a).getBarData().m9772b()) {
            int b = ((int) m9890b(f)) / ((C2546a) this.a).getBarData().m9761e();
            int l = ((C2546a) this.a).getData().m9768l();
            return b < 0 ? 0 : b >= l ? l - 1 : b;
        } else {
            float[] fArr = new float[2];
            fArr[1] = f;
            ((C2546a) this.a).m9665a(C2539a.LEFT).m10049b(fArr);
            return Math.round(fArr[1]);
        }
    }

    public C2581c m9889a(float f, float f2) {
        C2581c a = super.m9879a(f, f2);
        if (a == null) {
            return a;
        }
        C2584a c2584a = (C2584a) ((C2546a) this.a).getBarData().m9756a(a.m9883a());
        if (!c2584a.m9893n()) {
            return a;
        }
        float[] fArr = new float[2];
        fArr[0] = f2;
        ((C2546a) this.a).m9665a(c2584a.m9791l()).m10049b(fArr);
        return m9880a(a, c2584a, a.m9885b(), a.m9883a(), (double) fArr[0]);
    }

    protected float m9890b(float f) {
        float[] fArr = new float[2];
        fArr[1] = f;
        ((C2546a) this.a).m9665a(C2539a.LEFT).m10049b(fArr);
        float f2 = fArr[1];
        return f2 - (((C2546a) this.a).getBarData().m9771a() * ((float) ((int) (f2 / (((C2546a) this.a).getBarData().m9771a() + ((float) ((C2546a) this.a).getBarData().m9761e()))))));
    }
}
