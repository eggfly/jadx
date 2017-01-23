package com.github.mikephil.charting.p142e;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.p138c.C2541g.C2539a;
import com.github.mikephil.charting.p139f.p140a.C2546a;
import com.github.mikephil.charting.p139f.p141b.C2584a;

/* renamed from: com.github.mikephil.charting.e.a */
public class C2580a extends C2579b<C2546a> {
    public C2580a(C2546a c2546a) {
        super(c2546a);
    }

    protected int m9876a(float f) {
        if (!((C2546a) this.a).getBarData().m9772b()) {
            return super.m9872a(f);
        }
        int b = ((int) m9882b(f)) / ((C2546a) this.a).getBarData().m9761e();
        int l = ((C2546a) this.a).getData().m9768l();
        return b < 0 ? 0 : b >= l ? l - 1 : b;
    }

    protected int m9877a(int i, float f, float f2) {
        if (!((C2546a) this.a).getBarData().m9772b()) {
            return 0;
        }
        float b = m9882b(f);
        int e = ((C2546a) this.a).getBarData().m9761e();
        int i2 = ((int) b) % e;
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 >= e) {
            i2 = e - 1;
        }
        return i2;
    }

    protected int m9878a(C2583e[] c2583eArr, float f) {
        if (c2583eArr == null || c2583eArr.length == 0) {
            return 0;
        }
        int length = c2583eArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            if (c2583eArr[i].m9891a(f)) {
                return i2;
            }
            i++;
            i2++;
        }
        i2 = Math.max(c2583eArr.length - 1, 0);
        return f <= c2583eArr[i2].f8973b ? 0 : i2;
    }

    public C2581c m9879a(float f, float f2) {
        C2581c a = super.m9874a(f, f2);
        if (a == null) {
            return a;
        }
        C2584a c2584a = (C2584a) ((C2546a) this.a).getBarData().m9756a(a.m9883a());
        if (!c2584a.m9893n()) {
            return a;
        }
        float[] fArr = new float[2];
        fArr[1] = f2;
        ((C2546a) this.a).m9665a(c2584a.m9791l()).m10049b(fArr);
        return m9880a(a, c2584a, a.m9885b(), a.m9883a(), (double) fArr[1]);
    }

    protected C2581c m9880a(C2581c c2581c, C2584a c2584a, int i, int i2, double d) {
        BarEntry barEntry = (BarEntry) c2584a.m9781e(i);
        if (barEntry == null || barEntry.m9744a() == null) {
            return c2581c;
        }
        C2583e[] a = m9881a(barEntry);
        int a2 = m9878a(a, (float) d);
        return new C2581c(i, i2, a2, a[a2]);
    }

    protected C2583e[] m9881a(BarEntry barEntry) {
        float[] a = barEntry.m9744a();
        if (a == null || a.length == 0) {
            return null;
        }
        C2583e[] c2583eArr = new C2583e[a.length];
        float f = -barEntry.m9746c();
        float f2 = 0.0f;
        for (int i = 0; i < c2583eArr.length; i++) {
            float f3 = a[i];
            if (f3 < 0.0f) {
                c2583eArr[i] = new C2583e(f, Math.abs(f3) + f);
                f += Math.abs(f3);
            } else {
                c2583eArr[i] = new C2583e(f2, f2 + f3);
                f2 += f3;
            }
        }
        return c2583eArr;
    }

    protected float m9882b(float f) {
        float[] fArr = new float[2];
        fArr[0] = f;
        ((C2546a) this.a).m9665a(C2539a.LEFT).m10049b(fArr);
        float f2 = fArr[0];
        return f2 - (((C2546a) this.a).getBarData().m9771a() * ((float) ((int) (f2 / (((C2546a) this.a).getBarData().m9771a() + ((float) ((C2546a) this.a).getBarData().m9761e()))))));
    }
}
