package com.github.mikephil.charting.p137b;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.p139f.p141b.C2584a;

/* renamed from: com.github.mikephil.charting.b.b */
public class C2524b extends C2523a<C2584a> {
    protected float f8697g;
    protected float f8698h;
    protected int f8699i;
    protected int f8700j;
    protected boolean f8701k;
    protected boolean f8702l;

    public C2524b(int i, float f, int i2, boolean z) {
        super(i);
        this.f8697g = 0.0f;
        this.f8698h = 0.0f;
        this.f8699i = 0;
        this.f8700j = 1;
        this.f8701k = false;
        this.f8702l = false;
        this.f8698h = f;
        this.f8700j = i2;
        this.f8701k = z;
    }

    public void m9548a(float f) {
        this.f8697g = f;
    }

    protected void m9549a(float f, float f2, float f3, float f4) {
        float[] fArr = this.b;
        int i = this.a;
        this.a = i + 1;
        fArr[i] = f;
        fArr = this.b;
        i = this.a;
        this.a = i + 1;
        fArr[i] = f2;
        fArr = this.b;
        i = this.a;
        this.a = i + 1;
        fArr[i] = f3;
        fArr = this.b;
        i = this.a;
        this.a = i + 1;
        fArr[i] = f4;
    }

    public void m9550a(C2584a c2584a) {
        float m = ((float) c2584a.m9792m()) * this.c;
        int i = this.f8700j - 1;
        float f = this.f8697g / 2.0f;
        float f2 = this.f8698h / 2.0f;
        for (int i2 = 0; ((float) i2) < m; i2++) {
            BarEntry barEntry = (BarEntry) c2584a.m9783f(i2);
            float d = (((float) ((barEntry.m9743d() + (barEntry.m9743d() * i)) + this.f8699i)) + (this.f8698h * ((float) barEntry.m9743d()))) + f2;
            float b = barEntry.m9745b();
            float[] a = barEntry.m9744a();
            float f3;
            float f4;
            float f5;
            if (!this.f8701k || a == null) {
                float f6;
                f3 = (d - 0.5f) + f;
                f4 = (d + 0.5f) - f;
                if (this.f8702l) {
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
                m9549a(f3, f6, f4, b);
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
                    if (this.f8702l) {
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
                    m9549a(f7, f42 * this.d, f8, f3 * this.d);
                }
            }
        }
        m9543a();
    }

    public void m9551a(boolean z) {
        this.f8702l = z;
    }

    public void m9552c(int i) {
        this.f8699i = i;
    }
}
