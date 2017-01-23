package com.github.mikephil.charting.p144h;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.v4.view.MotionEventCompat;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.C2562a;
import com.github.mikephil.charting.p136a.C2522a;
import com.github.mikephil.charting.p137b.C2524b;
import com.github.mikephil.charting.p139f.p140a.C2546a;
import com.github.mikephil.charting.p139f.p141b.C2563d;
import com.github.mikephil.charting.p139f.p141b.C2584a;
import com.github.mikephil.charting.p142e.C2581c;
import com.github.mikephil.charting.p145i.C2618d;
import com.github.mikephil.charting.p145i.C2620f;
import com.github.mikephil.charting.p145i.C2621g;
import java.util.List;
import org.android.agoo.message.MessageService;

/* renamed from: com.github.mikephil.charting.h.b */
public class C2599b extends C2598c {
    protected C2546a f9023a;
    protected RectF f9024b;
    protected C2524b[] f9025c;
    protected Paint f9026d;

    public C2599b(C2546a c2546a, C2522a c2522a, C2621g c2621g) {
        super(c2522a, c2621g);
        this.f9024b = new RectF();
        this.f9023a = c2546a;
        this.g = new Paint(1);
        this.g.setStyle(Style.FILL);
        this.g.setColor(Color.rgb(0, 0, 0));
        this.g.setAlpha(120);
        this.f9026d = new Paint(1);
        this.f9026d.setStyle(Style.FILL);
    }

    public void m9944a() {
        C2562a barData = this.f9023a.getBarData();
        this.f9025c = new C2524b[barData.m9761e()];
        for (int i = 0; i < this.f9025c.length; i++) {
            C2584a c2584a = (C2584a) barData.m9756a(i);
            this.f9025c[i] = new C2524b((c2584a.m9893n() ? c2584a.m9894q() : 1) * (c2584a.m9792m() * 4), barData.m9771a(), barData.m9761e(), c2584a.m9893n());
        }
    }

    protected void m9945a(float f, float f2, float f3, float f4, C2618d c2618d) {
        this.f9024b.set((f - 0.5f) + f4, f2, (0.5f + f) - f4, f3);
        c2618d.m10042a(this.f9024b, this.e.m9540a());
    }

    public void m9946a(Canvas canvas) {
        C2562a barData = this.f9023a.getBarData();
        for (int i = 0; i < barData.m9761e(); i++) {
            C2584a c2584a = (C2584a) barData.m9756a(i);
            if (c2584a.m9790k() && c2584a.m9792m() > 0) {
                m9947a(canvas, c2584a, i);
            }
        }
    }

    protected void m9947a(Canvas canvas, C2584a c2584a, int i) {
        C2618d a = this.f9023a.m9665a(c2584a.m9791l());
        this.f9026d.setColor(c2584a.m9895r());
        float b = this.e.m9542b();
        float a2 = this.e.m9540a();
        C2524b c2524b = this.f9025c[i];
        c2524b.m9544a(b, a2);
        c2524b.m9548a(c2584a.m9892d());
        c2524b.m9552c(i);
        c2524b.m9551a(this.f9023a.m9666c(c2584a.m9791l()));
        c2524b.m9550a(c2584a);
        a.m10044a(c2524b.b);
        int i2;
        if (c2584a.m9778b().size() > 1) {
            for (i2 = 0; i2 < c2524b.m9546b(); i2 += 4) {
                if (this.o.m10091e(c2524b.b[i2 + 2])) {
                    if (this.o.m10093f(c2524b.b[i2])) {
                        if (this.f9023a.m9693e()) {
                            canvas.drawRect(c2524b.b[i2], this.o.m10090e(), c2524b.b[i2 + 2], this.o.m10096h(), this.f9026d);
                        }
                        this.f.setColor(c2584a.m9777b(i2 / 4));
                        canvas.drawRect(c2524b.b[i2], c2524b.b[i2 + 1], c2524b.b[i2 + 2], c2524b.b[i2 + 3], this.f);
                    } else {
                        return;
                    }
                }
            }
            return;
        }
        this.f.setColor(c2584a.m9779c());
        for (i2 = 0; i2 < c2524b.m9546b(); i2 += 4) {
            if (this.o.m10091e(c2524b.b[i2 + 2])) {
                if (this.o.m10093f(c2524b.b[i2])) {
                    if (this.f9023a.m9693e()) {
                        canvas.drawRect(c2524b.b[i2], this.o.m10090e(), c2524b.b[i2 + 2], this.o.m10096h(), this.f9026d);
                    }
                    canvas.drawRect(c2524b.b[i2], c2524b.b[i2 + 1], c2524b.b[i2 + 2], c2524b.b[i2 + 3], this.f);
                } else {
                    return;
                }
            }
        }
    }

    public void m9948a(Canvas canvas, C2581c[] c2581cArr) {
        int e = this.f9023a.getBarData().m9761e();
        for (C2581c c2581c : c2581cArr) {
            int b = c2581c.m9885b();
            int a = c2581c.m9883a();
            C2584a c2584a = (C2584a) this.f9023a.getBarData().m9756a(a);
            if (c2584a != null && c2584a.m9784f()) {
                float d = c2584a.m9892d() / 2.0f;
                C2618d a2 = this.f9023a.m9665a(c2584a.m9791l());
                this.g.setColor(c2584a.m9822a());
                this.g.setAlpha(c2584a.m9896s());
                if (b >= 0 && ((float) b) < (this.f9023a.getXChartMax() * this.e.m9542b()) / ((float) e)) {
                    BarEntry barEntry = (BarEntry) c2584a.m9781e(b);
                    if (barEntry != null && barEntry.m9743d() == b) {
                        Object obj;
                        float f;
                        float f2;
                        float a3 = this.f9023a.getBarData().m9771a();
                        if (c2581c.m9886c() < 0) {
                            obj = null;
                        } else {
                            int i = 1;
                        }
                        float f3 = (((float) ((b * e) + a)) + (a3 / 2.0f)) + (((float) b) * a3);
                        if (obj != null) {
                            f = c2581c.m9887d().f8972a;
                            f2 = c2581c.m9887d().f8973b;
                        } else {
                            f = barEntry.m9745b();
                            f2 = 0.0f;
                        }
                        m9945a(f3, f, f2, d, a2);
                        canvas.drawRect(this.f9024b, this.g);
                        if (this.f9023a.m9691c()) {
                            this.g.setAlpha(MotionEventCompat.ACTION_MASK);
                            float a4 = this.e.m9540a() * 0.07f;
                            float[] fArr = new float[9];
                            a2.m10047b().getValues(fArr);
                            float d2 = c2584a.m9892d() / 2.0f;
                            d = Math.abs(fArr[4] / fArr[0]) * d2;
                            Path path;
                            if (f > (-f2)) {
                                f *= this.e.m9540a();
                                path = new Path();
                                path.moveTo(0.4f + f3, f + a4);
                                path.lineTo((0.4f + f3) + d2, (f + a4) - d);
                                path.lineTo((f3 + 0.4f) + d2, (a4 + f) + d);
                                a2.m10041a(path);
                                canvas.drawPath(path, this.g);
                            } else {
                                f *= this.e.m9540a();
                                path = new Path();
                                path.moveTo(0.4f + f3, f + a4);
                                path.lineTo((0.4f + f3) + d2, (f + a4) - d);
                                path.lineTo((f3 + 0.4f) + d2, (a4 + f) + d);
                                a2.m10041a(path);
                                canvas.drawPath(path, this.g);
                            }
                        }
                    }
                }
            }
        }
    }

    public float[] m9949a(C2618d c2618d, C2584a c2584a, int i) {
        return c2618d.m10045a(c2584a, i, this.f9023a.getBarData(), this.e.m9540a());
    }

    public void m9950b(Canvas canvas) {
        if (m9951b()) {
            List k = this.f9023a.getBarData().m9767k();
            float a = C2620f.m10053a(4.5f);
            boolean d = this.f9023a.m9692d();
            for (int i = 0; i < this.f9023a.getBarData().m9761e(); i++) {
                C2584a c2584a = (C2584a) k.get(i);
                if (c2584a.m9789j() && c2584a.m9792m() != 0) {
                    float f;
                    float f2;
                    m9941a((C2563d) c2584a);
                    boolean c = this.f9023a.m9666c(c2584a.m9791l());
                    float b = (float) C2620f.m10071b(this.i, MessageService.MSG_ACCS_NOTIFY_CLICK);
                    float f3 = d ? -a : b + a;
                    float f4 = d ? b + a : -a;
                    if (c) {
                        f = (-f4) - b;
                        f2 = (-f3) - b;
                    } else {
                        f = f4;
                        f2 = f3;
                    }
                    C2618d a2 = this.f9023a.m9665a(c2584a.m9791l());
                    float[] a3 = m9949a(a2, c2584a, i);
                    int i2;
                    BarEntry barEntry;
                    if (c2584a.m9893n()) {
                        i2 = 0;
                        while (((float) i2) < ((float) (a3.length - 1)) * this.e.m9542b()) {
                            barEntry = (BarEntry) c2584a.m9783f(i2 / 2);
                            float[] a4 = barEntry.m9744a();
                            if (a4 == null) {
                                if (!this.o.m10093f(a3[i2])) {
                                    break;
                                } else if (this.o.m10089d(a3[i2 + 1]) && this.o.m10091e(a3[i2])) {
                                    m9939a(canvas, c2584a.m9786g(), barEntry.m9745b(), barEntry, i, a3[i2], a3[i2 + 1] + (barEntry.m9745b() >= 0.0f ? f2 : f), c2584a.m9780d(i2 / 2));
                                }
                            } else {
                                float f5;
                                int d2 = c2584a.m9780d(i2 / 2);
                                float[] fArr = new float[(a4.length * 2)];
                                b = 0.0f;
                                float f6 = -barEntry.m9746c();
                                int i3 = 0;
                                int i4 = 0;
                                while (i3 < fArr.length) {
                                    f5 = a4[i4];
                                    if (f5 >= 0.0f) {
                                        b += f5;
                                        f5 = b;
                                    } else {
                                        float f7 = f6;
                                        f6 -= f5;
                                        f5 = f7;
                                    }
                                    fArr[i3 + 1] = f5 * this.e.m9540a();
                                    i3 += 2;
                                    i4++;
                                }
                                a2.m10044a(fArr);
                                for (int i5 = 0; i5 < fArr.length; i5 += 2) {
                                    f5 = a3[i2];
                                    float f8 = fArr[i5 + 1] + (a4[i5 / 2] >= 0.0f ? f2 : f);
                                    if (!this.o.m10093f(f5)) {
                                        break;
                                    }
                                    if (this.o.m10089d(f8) && this.o.m10091e(f5)) {
                                        m9939a(canvas, c2584a.m9786g(), a4[i5 / 2], barEntry, i, f5, f8, d2);
                                    }
                                }
                            }
                            i2 += 2;
                        }
                    } else {
                        i2 = 0;
                        while (((float) i2) < ((float) a3.length) * this.e.m9542b() && this.o.m10093f(a3[i2])) {
                            if (this.o.m10089d(a3[i2 + 1]) && this.o.m10091e(a3[i2])) {
                                barEntry = (BarEntry) c2584a.m9783f(i2 / 2);
                                b = barEntry.m9745b();
                                m9939a(canvas, c2584a.m9786g(), b, barEntry, i, a3[i2], a3[i2 + 1] + (b >= 0.0f ? f2 : f), c2584a.m9780d(i2 / 2));
                            }
                            i2 += 2;
                        }
                    }
                }
            }
        }
    }

    protected boolean m9951b() {
        return ((float) this.f9023a.getBarData().m9765i()) < ((float) this.f9023a.getMaxVisibleCount()) * this.o.m10107p();
    }

    public void m9952c(Canvas canvas) {
    }
}
