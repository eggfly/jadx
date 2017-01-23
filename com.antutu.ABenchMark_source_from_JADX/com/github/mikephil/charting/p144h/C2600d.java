package com.github.mikephil.charting.p144h;

import android.graphics.Canvas;
import android.graphics.Paint.Align;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.C2562a;
import com.github.mikephil.charting.p039d.C1202f;
import com.github.mikephil.charting.p136a.C2522a;
import com.github.mikephil.charting.p137b.C2524b;
import com.github.mikephil.charting.p137b.C2526d;
import com.github.mikephil.charting.p139f.p140a.C2546a;
import com.github.mikephil.charting.p139f.p141b.C2563d;
import com.github.mikephil.charting.p139f.p141b.C2584a;
import com.github.mikephil.charting.p145i.C2618d;
import com.github.mikephil.charting.p145i.C2620f;
import com.github.mikephil.charting.p145i.C2621g;
import java.util.List;
import org.android.agoo.common.AgooConstants;

/* renamed from: com.github.mikephil.charting.h.d */
public class C2600d extends C2599b {
    public C2600d(C2546a c2546a, C2522a c2522a, C2621g c2621g) {
        super(c2546a, c2522a, c2621g);
        this.i.setTextAlign(Align.LEFT);
    }

    public void m9953a() {
        C2562a barData = this.a.getBarData();
        this.c = new C2526d[barData.m9761e()];
        for (int i = 0; i < this.c.length; i++) {
            C2584a c2584a = (C2584a) barData.m9756a(i);
            this.c[i] = new C2526d((c2584a.m9893n() ? c2584a.m9894q() : 1) * (c2584a.m9792m() * 4), barData.m9771a(), barData.m9761e(), c2584a.m9893n());
        }
    }

    protected void m9954a(float f, float f2, float f3, float f4, C2618d c2618d) {
        this.b.set(f2, (f - 0.5f) + f4, f3, (0.5f + f) - f4);
        c2618d.m10048b(this.b, this.e.m9540a());
    }

    protected void m9955a(Canvas canvas, C2584a c2584a, int i) {
        C2618d a = this.a.m9665a(c2584a.m9791l());
        this.d.setColor(c2584a.m9895r());
        float b = this.e.m9542b();
        float a2 = this.e.m9540a();
        C2524b c2524b = this.c[i];
        c2524b.m9544a(b, a2);
        c2524b.m9548a(c2584a.m9892d());
        c2524b.m9552c(i);
        c2524b.m9551a(this.a.m9666c(c2584a.m9791l()));
        c2524b.m9550a(c2584a);
        a.m10044a(c2524b.b);
        int i2 = 0;
        while (i2 < c2524b.m9546b() && this.o.m10095g(c2524b.b[i2 + 3])) {
            if (this.o.m10097h(c2524b.b[i2 + 1])) {
                if (this.a.m9693e()) {
                    canvas.drawRect(this.o.m10092f(), c2524b.b[i2 + 1], this.o.m10094g(), c2524b.b[i2 + 3], this.d);
                }
                this.f.setColor(c2584a.m9777b(i2 / 4));
                canvas.drawRect(c2524b.b[i2], c2524b.b[i2 + 1], c2524b.b[i2 + 2], c2524b.b[i2 + 3], this.f);
            }
            i2 += 4;
        }
    }

    protected void m9956a(Canvas canvas, String str, float f, float f2, int i) {
        this.i.setColor(i);
        canvas.drawText(str, f, f2, this.i);
    }

    public float[] m9957a(C2618d c2618d, C2584a c2584a, int i) {
        return c2618d.m10050b(c2584a, i, this.a.getBarData(), this.e.m9540a());
    }

    public void m9958b(Canvas canvas) {
        if (m9959b()) {
            List k = this.a.getBarData().m9767k();
            float a = C2620f.m10053a(5.0f);
            boolean d = this.a.m9692d();
            for (int i = 0; i < this.a.getBarData().m9761e(); i++) {
                C2584a c2584a = (C2584a) k.get(i);
                if (c2584a.m9789j() && c2584a.m9792m() != 0) {
                    boolean c = this.a.m9666c(c2584a.m9791l());
                    m9941a((C2563d) c2584a);
                    float b = ((float) C2620f.m10071b(this.i, AgooConstants.ACK_REMOVE_PACKAGE)) / 2.0f;
                    C1202f g = c2584a.m9786g();
                    C2618d a2 = this.a.m9665a(c2584a.m9791l());
                    float[] a3 = m9957a(a2, c2584a, i);
                    String a4;
                    float a5;
                    float f;
                    float f2;
                    float f3;
                    if (c2584a.m9893n()) {
                        int i2 = 0;
                        while (((float) i2) < ((float) (a3.length - 1)) * this.e.m9542b()) {
                            BarEntry barEntry = (BarEntry) c2584a.m9783f(i2 / 2);
                            float[] a6 = barEntry.m9744a();
                            if (a6 == null) {
                                if (!this.o.m10095g(a3[i2 + 1])) {
                                    break;
                                } else if (this.o.m10087c(a3[i2]) && this.o.m10097h(a3[i2 + 1])) {
                                    a4 = g.m4963a(barEntry.m9745b(), barEntry, i, this.o);
                                    a5 = (float) C2620f.m10056a(this.i, a4);
                                    f = d ? a : -(a5 + a);
                                    f2 = d ? -(a5 + a) : a;
                                    if (c) {
                                        f = (-f) - a5;
                                        f2 = (-f2) - a5;
                                    }
                                    a5 = a3[i2];
                                    if (barEntry.m9745b() < 0.0f) {
                                        f = f2;
                                    }
                                    m9956a(canvas, a4, a5 + f, a3[i2 + 1] + b, c2584a.m9780d(i2 / 2));
                                }
                            } else {
                                float[] fArr = new float[(a6.length * 2)];
                                a5 = 0.0f;
                                float f4 = -barEntry.m9746c();
                                int i3 = 0;
                                int i4 = 0;
                                while (i3 < fArr.length) {
                                    f3 = a6[i4];
                                    if (f3 >= 0.0f) {
                                        a5 += f3;
                                        f3 = a5;
                                    } else {
                                        float f5 = f4;
                                        f4 -= f3;
                                        f3 = f5;
                                    }
                                    fArr[i3] = f3 * this.e.m9540a();
                                    i3 += 2;
                                    i4++;
                                }
                                a2.m10044a(fArr);
                                for (int i5 = 0; i5 < fArr.length; i5 += 2) {
                                    a5 = a6[i5 / 2];
                                    a4 = g.m4963a(a5, barEntry, i, this.o);
                                    f3 = (float) C2620f.m10056a(this.i, a4);
                                    f = d ? a : -(f3 + a);
                                    f2 = d ? -(f3 + a) : a;
                                    if (c) {
                                        f = (-f) - f3;
                                        f2 = (-f2) - f3;
                                    }
                                    f3 = fArr[i5];
                                    if (a5 < 0.0f) {
                                        f = f2;
                                    }
                                    a5 = f3 + f;
                                    f2 = a3[i2 + 1];
                                    if (!this.o.m10095g(f2)) {
                                        break;
                                    }
                                    if (this.o.m10087c(a5) && this.o.m10097h(f2)) {
                                        m9956a(canvas, a4, a5, f2 + b, c2584a.m9780d(i2 / 2));
                                    }
                                }
                            }
                            i2 += 2;
                        }
                    } else {
                        int i6 = 0;
                        while (((float) i6) < ((float) a3.length) * this.e.m9542b() && this.o.m10095g(a3[i6 + 1])) {
                            if (this.o.m10087c(a3[i6]) && this.o.m10097h(a3[i6 + 1])) {
                                BarEntry barEntry2 = (BarEntry) c2584a.m9783f(i6 / 2);
                                a5 = barEntry2.m9745b();
                                a4 = g.m4963a(a5, barEntry2, i, this.o);
                                f3 = (float) C2620f.m10056a(this.i, a4);
                                f = d ? a : -(f3 + a);
                                f2 = d ? -(f3 + a) : a;
                                if (c) {
                                    f = (-f) - f3;
                                    f2 = (-f2) - f3;
                                }
                                f3 = a3[i6];
                                if (a5 < 0.0f) {
                                    f = f2;
                                }
                                m9956a(canvas, a4, f3 + f, a3[i6 + 1] + b, c2584a.m9780d(i6 / 2));
                            }
                            i6 += 2;
                        }
                    }
                }
            }
        }
    }

    protected boolean m9959b() {
        return ((float) this.a.getBarData().m9765i()) < ((float) this.a.getMaxVisibleCount()) * this.o.m10108q();
    }
}
