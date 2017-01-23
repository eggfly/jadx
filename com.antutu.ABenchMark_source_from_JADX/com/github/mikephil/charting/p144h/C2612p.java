package com.github.mikephil.charting.p144h;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import com.antutu.utils.widget.SystemBarTintManager;
import com.github.mikephil.charting.p138c.C2535d;
import com.github.mikephil.charting.p138c.C2535d.C2534a;
import com.github.mikephil.charting.p138c.C2541g;
import com.github.mikephil.charting.p138c.C2541g.C2539a;
import com.github.mikephil.charting.p138c.C2541g.C2540b;
import com.github.mikephil.charting.p145i.C2616b;
import com.github.mikephil.charting.p145i.C2618d;
import com.github.mikephil.charting.p145i.C2620f;
import com.github.mikephil.charting.p145i.C2621g;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.List;

/* renamed from: com.github.mikephil.charting.h.p */
public class C2612p extends C2597a {
    protected C2541g f9062f;
    protected Paint f9063g;

    public C2612p(C2621g c2621g, C2541g c2541g, C2618d c2618d) {
        super(c2621g, c2618d);
        this.f9062f = c2541g;
        this.c.setColor(SystemBarTintManager.DEFAULT_TINT_COLOR);
        this.c.setTextSize(C2620f.m10053a(10.0f));
        this.f9063g = new Paint(1);
        this.f9063g.setColor(-7829368);
        this.f9063g.setStrokeWidth(1.0f);
        this.f9063g.setStyle(Style.STROKE);
    }

    public void m10020a(float f, float f2) {
        if (this.o.m10098i() > 10.0f && !this.o.m10110s()) {
            C2616b a = this.a.m10039a(this.o.m10092f(), this.o.m10090e());
            C2616b a2 = this.a.m10039a(this.o.m10092f(), this.o.m10096h());
            if (this.f9062f.m9642w()) {
                f = (float) a.f9068b;
                f2 = (float) a2.f9068b;
            } else {
                f = (float) a2.f9068b;
                f2 = (float) a.f9068b;
            }
        }
        m10024b(f, f2);
    }

    public void m10021a(Canvas canvas) {
        if (this.f9062f.m9565p() && this.f9062f.m9574g()) {
            float[] fArr = new float[(this.f9062f.f8806n * 2)];
            for (int i = 0; i < fArr.length; i += 2) {
                fArr[i + 1] = this.f9062f.f8805m[i / 2];
            }
            this.a.m10044a(fArr);
            this.c.setTypeface(this.f9062f.m9562m());
            this.c.setTextSize(this.f9062f.m9563n());
            this.c.setColor(this.f9062f.m9564o());
            float k = this.f9062f.m9560k();
            float b = (((float) C2620f.m10071b(this.c, "A")) / 2.5f) + this.f9062f.m9561l();
            C2539a q = this.f9062f.m9636q();
            C2540b r = this.f9062f.m9637r();
            if (q == C2539a.LEFT) {
                if (r == C2540b.OUTSIDE_CHART) {
                    this.c.setTextAlign(Align.RIGHT);
                    k = this.o.m10076a() - k;
                } else {
                    this.c.setTextAlign(Align.LEFT);
                    k += this.o.m10076a();
                }
            } else if (r == C2540b.OUTSIDE_CHART) {
                this.c.setTextAlign(Align.LEFT);
                k += this.o.m10094g();
            } else {
                this.c.setTextAlign(Align.RIGHT);
                k = this.o.m10094g() - k;
            }
            m10023a(canvas, k, fArr, b);
        }
    }

    protected void m10022a(Canvas canvas, float f, float f2, float f3, float f4) {
        this.f9063g.setColor(this.f9062f.m9626C());
        this.f9063g.setStrokeWidth(this.f9062f.m9627D());
        Path path = new Path();
        path.moveTo(f, f3);
        path.lineTo(f2, f4);
        canvas.drawPath(path, this.f9063g);
    }

    protected void m10023a(Canvas canvas, float f, float[] fArr, float f2) {
        int i = 0;
        while (i < this.f9062f.f8806n) {
            String a = this.f9062f.m9632a(i);
            if (this.f9062f.m9638s() || i < this.f9062f.f8806n - 1) {
                canvas.drawText(a, f, fArr[(i * 2) + 1] + f2, this.c);
                i++;
            } else {
                return;
            }
        }
    }

    protected void m10024b(float f, float f2) {
        int t = this.f9062f.m9639t();
        double abs = (double) Math.abs(f2 - f);
        if (t == 0 || abs <= 0.0d) {
            this.f9062f.f8805m = new float[0];
            this.f9062f.f8806n = 0;
            return;
        }
        double a = (double) C2620f.m10052a(abs / ((double) t));
        double pow = Math.pow(10.0d, (double) ((int) Math.log10(a)));
        if (((int) (a / pow)) > 5) {
            a = Math.floor(10.0d * pow);
        }
        if (this.f9062f.m9640u()) {
            float f3 = ((float) abs) / ((float) (t - 1));
            this.f9062f.f8806n = t;
            if (this.f9062f.f8805m.length < t) {
                this.f9062f.f8805m = new float[t];
            }
            for (int i = 0; i < t; i++) {
                this.f9062f.f8805m[i] = f;
                f += f3;
            }
        } else if (this.f9062f.m9641v()) {
            this.f9062f.f8806n = 2;
            r3 = new float[2];
            this.f9062f.f8805m = r3;
            this.f9062f.f8805m[0] = f;
            this.f9062f.f8805m[1] = f2;
        } else {
            abs = Math.ceil(((double) f) / a) * a;
            int i2 = 0;
            pow = abs;
            while (pow <= C2620f.m10066b(Math.floor(((double) f2) / a) * a)) {
                pow += a;
                i2++;
            }
            this.f9062f.f8806n = i2;
            if (this.f9062f.f8805m.length < i2) {
                this.f9062f.f8805m = new float[i2];
            }
            double d = abs;
            int i3 = 0;
            while (i3 < i2) {
                if (d == 0.0d) {
                    d = 0.0d;
                }
                this.f9062f.f8805m[i3] = (float) d;
                i3++;
                d += a;
            }
        }
        if (a < 1.0d) {
            this.f9062f.f8807o = (int) Math.ceil(-Math.log10(a));
            return;
        }
        this.f9062f.f8807o = 0;
    }

    public void m10025b(Canvas canvas) {
        if (this.f9062f.m9565p() && this.f9062f.m9569b()) {
            this.d.setColor(this.f9062f.m9573f());
            this.d.setStrokeWidth(this.f9062f.m9571d());
            if (this.f9062f.m9636q() == C2539a.LEFT) {
                canvas.drawLine(this.o.m10092f(), this.o.m10090e(), this.o.m10092f(), this.o.m10096h(), this.d);
                return;
            }
            canvas.drawLine(this.o.m10094g(), this.o.m10090e(), this.o.m10094g(), this.o.m10096h(), this.d);
        }
    }

    public void m10026c(Canvas canvas) {
        if (this.f9062f.m9565p()) {
            float[] fArr = new float[2];
            if (this.f9062f.m9567a()) {
                this.b.setColor(this.f9062f.m9570c());
                this.b.setStrokeWidth(this.f9062f.m9572e());
                this.b.setPathEffect(this.f9062f.m9577j());
                Path path = new Path();
                for (int i = 0; i < this.f9062f.f8806n; i++) {
                    fArr[1] = this.f9062f.f8805m[i];
                    this.a.m10044a(fArr);
                    path.moveTo(this.o.m10076a(), fArr[1]);
                    path.lineTo(this.o.m10094g(), fArr[1]);
                    canvas.drawPath(path, this.b);
                    path.reset();
                }
            }
            if (this.f9062f.m9625B()) {
                fArr[1] = 0.0f;
                this.a.m10044a(fArr);
                m10022a(canvas, this.o.m10076a(), this.o.m10094g(), fArr[1] - 1.0f, fArr[1] - 1.0f);
            }
        }
    }

    public void m10027d(Canvas canvas) {
        List h = this.f9062f.m9575h();
        if (h != null && h.size() > 0) {
            float[] fArr = new float[2];
            Path path = new Path();
            for (int i = 0; i < h.size(); i++) {
                C2535d c2535d = (C2535d) h.get(i);
                if (c2535d.m9565p()) {
                    this.e.setStyle(Style.STROKE);
                    this.e.setColor(c2535d.m9604c());
                    this.e.setStrokeWidth(c2535d.m9603b());
                    this.e.setPathEffect(c2535d.m9605d());
                    fArr[1] = c2535d.m9602a();
                    this.a.m10044a(fArr);
                    path.moveTo(this.o.m10092f(), fArr[1]);
                    path.lineTo(this.o.m10094g(), fArr[1]);
                    canvas.drawPath(path, this.e);
                    path.reset();
                    String g = c2535d.m9608g();
                    if (!(g == null || g.equals(BuildConfig.FLAVOR))) {
                        this.e.setStyle(c2535d.m9606e());
                        this.e.setPathEffect(null);
                        this.e.setColor(c2535d.m9564o());
                        this.e.setTypeface(c2535d.m9562m());
                        this.e.setStrokeWidth(0.5f);
                        this.e.setTextSize(c2535d.m9563n());
                        float b = (float) C2620f.m10071b(this.e, g);
                        float a = C2620f.m10053a(4.0f) + c2535d.m9560k();
                        float b2 = (c2535d.m9603b() + b) + c2535d.m9561l();
                        C2534a f = c2535d.m9607f();
                        if (f == C2534a.RIGHT_TOP) {
                            this.e.setTextAlign(Align.RIGHT);
                            canvas.drawText(g, this.o.m10094g() - a, b + (fArr[1] - b2), this.e);
                        } else if (f == C2534a.RIGHT_BOTTOM) {
                            this.e.setTextAlign(Align.RIGHT);
                            canvas.drawText(g, this.o.m10094g() - a, fArr[1] + b2, this.e);
                        } else if (f == C2534a.LEFT_TOP) {
                            this.e.setTextAlign(Align.LEFT);
                            canvas.drawText(g, this.o.m10092f() + a, b + (fArr[1] - b2), this.e);
                        } else {
                            this.e.setTextAlign(Align.LEFT);
                            canvas.drawText(g, this.o.m10076a() + a, fArr[1] + b2, this.e);
                        }
                    }
                }
            }
        }
    }
}
