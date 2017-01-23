package com.github.mikephil.charting.p144h;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.data.C2565f.C2568a;
import com.github.mikephil.charting.data.C2569g;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.p136a.C2522a;
import com.github.mikephil.charting.p137b.C2525c;
import com.github.mikephil.charting.p137b.C2527e;
import com.github.mikephil.charting.p139f.p140a.C2547d;
import com.github.mikephil.charting.p139f.p141b.C2563d;
import com.github.mikephil.charting.p139f.p141b.C2574e;
import com.github.mikephil.charting.p142e.C2581c;
import com.github.mikephil.charting.p145i.C2618d;
import com.github.mikephil.charting.p145i.C2621g;
import java.lang.ref.WeakReference;
import java.util.List;

/* renamed from: com.github.mikephil.charting.h.f */
public class C2605f extends C2604g {
    protected C2547d f9033a;
    protected Paint f9034b;
    protected WeakReference<Bitmap> f9035c;
    protected Canvas f9036d;
    protected Config f9037j;
    protected Path f9038k;
    protected Path f9039l;
    protected C2527e[] f9040m;
    protected C2525c[] f9041n;

    public C2605f(C2547d c2547d, C2522a c2522a, C2621g c2621g) {
        super(c2522a, c2621g);
        this.f9037j = Config.ARGB_8888;
        this.f9038k = new Path();
        this.f9039l = new Path();
        this.f9033a = c2547d;
        this.f9034b = new Paint(1);
        this.f9034b.setStyle(Style.FILL);
        this.f9034b.setColor(-1);
    }

    private Path m9968a(C2574e c2574e, int i, int i2) {
        float a = c2574e.m9853z().m9735a(c2574e, this.f9033a);
        float b = this.e.m9542b();
        float a2 = this.e.m9540a();
        Path path = new Path();
        Entry f = c2574e.m9783f(i);
        path.moveTo((float) f.m9743d(), a);
        path.lineTo((float) f.m9743d(), f.m9742b() * a2);
        int ceil = (int) Math.ceil((double) ((((float) (i2 - i)) * b) + ((float) i)));
        for (int i3 = i + 1; i3 < ceil; i3++) {
            Entry f2 = c2574e.m9783f(i3);
            path.lineTo((float) f2.m9743d(), f2.m9742b() * a2);
        }
        path.lineTo((float) c2574e.m9783f(Math.max(Math.min(((int) Math.ceil((double) ((((float) (i2 - i)) * b) + ((float) i)))) - 1, c2574e.m9792m() - 1), 0)).m9743d(), a);
        path.close();
        return path;
    }

    public void m9969a() {
        C2569g lineData = this.f9033a.getLineData();
        this.f9040m = new C2527e[lineData.m9761e()];
        this.f9041n = new C2525c[lineData.m9761e()];
        for (int i = 0; i < this.f9040m.length; i++) {
            C2574e c2574e = (C2574e) lineData.m9756a(i);
            this.f9040m[i] = new C2527e((c2574e.m9792m() * 4) - 4);
            this.f9041n[i] = new C2525c(c2574e.m9792m() * 2);
        }
    }

    public void m9970a(Canvas canvas) {
        int n = (int) this.o.m10105n();
        int m = (int) this.o.m10104m();
        if (!(this.f9035c != null && ((Bitmap) this.f9035c.get()).getWidth() == n && ((Bitmap) this.f9035c.get()).getHeight() == m)) {
            if (n > 0 && m > 0) {
                this.f9035c = new WeakReference(Bitmap.createBitmap(n, m, this.f9037j));
                this.f9036d = new Canvas((Bitmap) this.f9035c.get());
            } else {
                return;
            }
        }
        ((Bitmap) this.f9035c.get()).eraseColor(0);
        for (C2574e c2574e : this.f9033a.getLineData().m9767k()) {
            if (c2574e.m9790k() && c2574e.m9792m() > 0) {
                m9971a(canvas, c2574e);
            }
        }
        canvas.drawBitmap((Bitmap) this.f9035c.get(), 0.0f, 0.0f, this.f);
    }

    protected void m9971a(Canvas canvas, C2574e c2574e) {
        if (c2574e.m9792m() >= 1) {
            this.f.setStrokeWidth(c2574e.m9836D());
            this.f.setPathEffect(c2574e.m9848t());
            if (c2574e.m9850v()) {
                m9977b(canvas, c2574e);
            } else {
                m9979c(canvas, c2574e);
            }
            this.f.setPathEffect(null);
        }
    }

    protected void m9972a(Canvas canvas, C2574e c2574e, int i, int i2, C2618d c2618d) {
        Path a = m9968a(c2574e, i, i2);
        c2618d.m10041a(a);
        Drawable B = c2574e.m9834B();
        if (B != null) {
            m9967a(canvas, a, B);
        } else {
            m9966a(canvas, a, c2574e.m9833A(), c2574e.m9835C());
        }
    }

    protected void m9973a(Canvas canvas, C2574e c2574e, Path path, C2618d c2618d, int i, int i2) {
        float f = 0.0f;
        if (i2 - i > 1) {
            float a = c2574e.m9853z().m9735a(c2574e, this.f9033a);
            Entry f2 = c2574e.m9783f(i2 - 1);
            Entry f3 = c2574e.m9783f(i);
            float d = f2 == null ? 0.0f : (float) f2.m9743d();
            if (f3 != null) {
                f = (float) f3.m9743d();
            }
            path.lineTo(d, a);
            path.lineTo(f, a);
            path.close();
            c2618d.m10041a(path);
            Drawable B = c2574e.m9834B();
            if (B != null) {
                m9967a(canvas, path, B);
            } else {
                m9966a(canvas, path, c2574e.m9833A(), c2574e.m9835C());
            }
        }
    }

    public void m9974a(Canvas canvas, C2581c[] c2581cArr) {
        for (int i = 0; i < c2581cArr.length; i++) {
            C2574e c2574e = (C2574e) this.f9033a.getLineData().m9756a(c2581cArr[i].m9883a());
            if (c2574e != null && c2574e.m9784f()) {
                int b = c2581cArr[i].m9885b();
                if (((float) b) <= this.f9033a.getXChartMax() * this.e.m9542b()) {
                    float g = c2574e.m9785g(b);
                    if (g != Float.NaN) {
                        g *= this.e.m9540a();
                        float[] fArr = new float[]{(float) b, g};
                        this.f9033a.m9665a(c2574e.m9791l()).m10044a(fArr);
                        m9965a(canvas, fArr, c2574e);
                    }
                }
            }
        }
    }

    public void m9975b() {
        if (this.f9035c != null) {
            ((Bitmap) this.f9035c.get()).recycle();
            this.f9035c.clear();
            this.f9035c = null;
        }
    }

    public void m9976b(Canvas canvas) {
        if (((float) this.f9033a.getLineData().m9765i()) < ((float) this.f9033a.getMaxVisibleCount()) * this.o.m10107p()) {
            List k = this.f9033a.getLineData().m9767k();
            for (int i = 0; i < k.size(); i++) {
                C2574e c2574e = (C2574e) k.get(i);
                if (c2574e.m9789j() && c2574e.m9792m() != 0) {
                    m9941a((C2563d) c2574e);
                    C2618d a = this.f9033a.m9665a(c2574e.m9791l());
                    int r = (int) (c2574e.m9846r() * 1.75f);
                    int i2 = !c2574e.m9849u() ? r / 2 : r;
                    int m = c2574e.m9792m();
                    Entry a2 = c2574e.m9774a(this.p < 0 ? 0 : this.p, C2568a.DOWN);
                    Entry a3 = c2574e.m9774a(this.q, C2568a.UP);
                    int max = Math.max(c2574e.m9773a(a2), 0);
                    float[] a4 = a.m10046a(c2574e, this.e.m9542b(), this.e.m9540a(), max, Math.min(c2574e.m9773a(a3) + 1, m));
                    for (int i3 = 0; i3 < a4.length; i3 += 2) {
                        float f = a4[i3];
                        float f2 = a4[i3 + 1];
                        if (!this.o.m10093f(f)) {
                            break;
                        }
                        if (this.o.m10091e(f) && this.o.m10089d(f2)) {
                            Entry f3 = c2574e.m9783f((i3 / 2) + max);
                            m9939a(canvas, c2574e.m9786g(), f3.m9742b(), f3, i, f, f2 - ((float) i2), c2574e.m9780d(i3 / 2));
                        }
                    }
                }
            }
        }
    }

    protected void m9977b(Canvas canvas, C2574e c2574e) {
        C2618d a = this.f9033a.m9665a(c2574e.m9791l());
        int m = c2574e.m9792m();
        Entry a2 = c2574e.m9774a(this.p < 0 ? 0 : this.p, C2568a.DOWN);
        Entry a3 = c2574e.m9774a(this.q, C2568a.UP);
        int max = Math.max((c2574e.m9773a(a2) - (a2 == a3 ? 1 : 0)) - 1, 0);
        int min = Math.min(c2574e.m9773a(a3) + 1, m);
        float b = this.e.m9542b();
        float a4 = this.e.m9540a();
        float q = c2574e.m9845q();
        this.f9038k.reset();
        int ceil = (int) Math.ceil((double) ((((float) (min - max)) * b) + ((float) max)));
        if (ceil - max >= 2) {
            Entry f;
            Entry f2 = c2574e.m9783f(max);
            Entry f3 = c2574e.m9783f(max + 1);
            this.f9038k.moveTo((float) f2.m9743d(), f2.m9742b() * a4);
            this.f9038k.cubicTo((((float) (f2.m9743d() - f2.m9743d())) * q) + ((float) f2.m9743d()), (((f2.m9742b() - f2.m9742b()) * q) + f2.m9742b()) * a4, ((float) f2.m9743d()) - (((float) (f3.m9743d() - f2.m9743d())) * q), (f2.m9742b() - ((f3.m9742b() - f2.m9742b()) * q)) * a4, (float) f2.m9743d(), f2.m9742b() * a4);
            min = max + 1;
            int min2 = Math.min(ceil, m - 1);
            max = min;
            while (max < min2) {
                f3 = c2574e.m9783f(max == 1 ? 0 : max - 2);
                f = c2574e.m9783f(max - 1);
                f2 = c2574e.m9783f(max);
                a3 = c2574e.m9783f(max + 1);
                this.f9038k.cubicTo(((float) f.m9743d()) + (((float) (f2.m9743d() - f3.m9743d())) * q), (f.m9742b() + ((f2.m9742b() - f3.m9742b()) * q)) * a4, ((float) f2.m9743d()) - (((float) (a3.m9743d() - f.m9743d())) * q), (f2.m9742b() - ((a3.m9742b() - f.m9742b()) * q)) * a4, (float) f2.m9743d(), f2.m9742b() * a4);
                max++;
            }
            if (ceil > m - 1) {
                f3 = c2574e.m9783f(m >= 3 ? m - 3 : m - 2);
                f = c2574e.m9783f(m - 2);
                f2 = c2574e.m9783f(m - 1);
                this.f9038k.cubicTo((((float) (f2.m9743d() - f3.m9743d())) * q) + ((float) f.m9743d()), (f.m9742b() + ((f2.m9742b() - f3.m9742b()) * q)) * a4, ((float) f2.m9743d()) - (((float) (f2.m9743d() - f.m9743d())) * q), (f2.m9742b() - ((f2.m9742b() - f.m9742b()) * q)) * a4, (float) f2.m9743d(), f2.m9742b() * a4);
            }
        }
        if (c2574e.m9837E()) {
            this.f9039l.reset();
            this.f9039l.addPath(this.f9038k);
            m9973a(this.f9036d, c2574e, this.f9039l, a, a2.m9743d(), a2.m9743d() + ceil);
        }
        this.f.setColor(c2574e.m9779c());
        this.f.setStyle(Style.STROKE);
        a.m10041a(this.f9038k);
        this.f9036d.drawPath(this.f9038k, this.f);
        this.f.setPathEffect(null);
    }

    public void m9978c(Canvas canvas) {
        m9980d(canvas);
    }

    protected void m9979c(Canvas canvas, C2574e c2574e) {
        int m = c2574e.m9792m();
        int a = this.f9033a.getLineData().m9754a((C2563d) c2574e);
        C2618d a2 = this.f9033a.m9665a(c2574e.m9791l());
        float b = this.e.m9542b();
        float a3 = this.e.m9540a();
        this.f.setStyle(Style.STROKE);
        Canvas canvas2 = c2574e.m9847s() ? this.f9036d : canvas;
        Entry a4 = c2574e.m9774a(this.p < 0 ? 0 : this.p, C2568a.DOWN);
        Entry a5 = c2574e.m9774a(this.q, C2568a.UP);
        int max = Math.max(c2574e.m9773a(a4), 0);
        int min = Math.min(c2574e.m9773a(a5) + 1, m);
        int i = ((min - max) * 4) - 4;
        C2527e c2527e = this.f9040m[a];
        c2527e.m9544a(b, a3);
        c2527e.m9545a(max);
        c2527e.m9547b(min);
        c2527e.m9556a(c2574e);
        a2.m10044a(c2527e.b);
        if (c2574e.m9778b().size() > 1) {
            int i2 = 0;
            while (i2 < i && this.o.m10093f(c2527e.b[i2])) {
                if (this.o.m10091e(c2527e.b[i2 + 2]) && ((this.o.m10095g(c2527e.b[i2 + 1]) || this.o.m10097h(c2527e.b[i2 + 3])) && (this.o.m10095g(c2527e.b[i2 + 1]) || this.o.m10097h(c2527e.b[i2 + 3])))) {
                    this.f.setColor(c2574e.m9777b((i2 / 4) + max));
                    canvas2.drawLine(c2527e.b[i2], c2527e.b[i2 + 1], c2527e.b[i2 + 2], c2527e.b[i2 + 3], this.f);
                }
                i2 += 4;
            }
        } else {
            this.f.setColor(c2574e.m9779c());
            canvas2.drawLines(c2527e.b, 0, i, this.f);
        }
        this.f.setPathEffect(null);
        if (c2574e.m9837E() && m > 0) {
            m9972a(canvas, c2574e, max, min, a2);
        }
    }

    protected void m9980d(Canvas canvas) {
        this.f.setStyle(Style.FILL);
        float b = this.e.m9542b();
        float a = this.e.m9540a();
        List k = this.f9033a.getLineData().m9767k();
        for (int i = 0; i < k.size(); i++) {
            C2574e c2574e = (C2574e) k.get(i);
            if (c2574e.m9790k() && c2574e.m9849u() && c2574e.m9792m() != 0) {
                this.f9034b.setColor(c2574e.m9851x());
                C2618d a2 = this.f9033a.m9665a(c2574e.m9791l());
                int m = c2574e.m9792m();
                Entry a3 = c2574e.m9774a(this.p < 0 ? 0 : this.p, C2568a.DOWN);
                Entry a4 = c2574e.m9774a(this.q, C2568a.UP);
                int max = Math.max(c2574e.m9773a(a3), 0);
                m = Math.min(c2574e.m9773a(a4) + 1, m);
                C2525c c2525c = this.f9041n[i];
                c2525c.m9544a(b, a);
                c2525c.m9545a(max);
                c2525c.m9547b(m);
                c2525c.m9553a(c2574e);
                a2.m10044a(c2525c.b);
                float r = c2574e.m9846r() / 2.0f;
                m = ((int) Math.ceil((double) ((((float) (m - max)) * b) + ((float) max)))) * 2;
                for (int i2 = 0; i2 < m; i2 += 2) {
                    float f = c2525c.b[i2];
                    float f2 = c2525c.b[i2 + 1];
                    if (!this.o.m10093f(f)) {
                        break;
                    }
                    if (this.o.m10091e(f) && this.o.m10089d(f2)) {
                        int h = c2574e.m9844h((i2 / 2) + max);
                        this.f.setColor(h);
                        canvas.drawCircle(f, f2, c2574e.m9846r(), this.f);
                        if (c2574e.m9852y() && h != this.f9034b.getColor()) {
                            canvas.drawCircle(f, f2, r, this.f9034b);
                        }
                    }
                }
            }
        }
    }
}
