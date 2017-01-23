package com.github.mikephil.charting.p137b;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.p139f.p141b.C2584a;

/* renamed from: com.github.mikephil.charting.b.d */
public class C2526d extends C2524b {
    public C2526d(int i, float f, int i2, boolean z) {
        super(i, f, i2, z);
    }

    public void m9555a(C2584a c2584a) {
        float m = ((float) c2584a.m9792m()) * this.c;
        int i = this.j - 1;
        float f = this.g / 2.0f;
        float f2 = this.h / 2.0f;
        for (int i2 = 0; ((float) i2) < m; i2++) {
            BarEntry barEntry = (BarEntry) c2584a.m9783f(i2);
            float d = (((float) ((barEntry.m9743d() + (barEntry.m9743d() * i)) + this.i)) + (this.h * ((float) barEntry.m9743d()))) + f2;
            float b = barEntry.m9745b();
            float[] a = barEntry.m9744a();
            float f3;
            float f4;
            float f5;
            if (!this.k || a == null) {
                float f6;
                f3 = (d - 0.5f) + f;
                f4 = (d + 0.5f) - f;
                if (this.l) {
                    f5 = b >= 0.0f ? b : 0.0f;
                    f6 = b <= 0.0f ? b : 0.0f;
                    b = f5;
                } else {
                    f6 = b >= 0.0f ? b : 0.0f;
                    if (b > 0.0f) {
                        b = 0.0f;
                    }
                }
                if (f6 > 0.0f) {
                    f6 *= this.d;
                } else {
                    b *= this.d;
                }
                m9549a(b, f4, f6, f3);
            } else {
                f5 = 0.0f;
                b = -barEntry.m9746c();
                for (float f42 : a) {
                    if (f42 >= 0.0f) {
                        f3 = f5 + f42;
                        f42 = f5;
                        f5 = f3;
                    } else {
                        f3 = Math.abs(f42) + b;
                        float abs = Math.abs(f42) + b;
                        f42 = b;
                        b = abs;
                    }
                    float f7 = (d - 0.5f) + f;
                    float f8 = (d + 0.5f) - f;
                    float f9;
                    if (this.l) {
                        f9 = f42 >= f3 ? f42 : f3;
                        if (f42 > f3) {
                            f42 = f3;
                        }
                        f3 = f9;
                    } else {
                        f9 = f42 >= f3 ? f42 : f3;
                        if (f42 > f3) {
                            f42 = f3;
                        }
                        f3 = f42;
                        f42 = f9;
                    }
                    m9549a(f3 * this.d, f8, f42 * this.d, f7);
                }
            }
        }
        m9543a();
    }
}
