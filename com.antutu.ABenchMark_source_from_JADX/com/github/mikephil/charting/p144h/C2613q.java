package com.github.mikephil.charting.p144h;

import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
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

/* renamed from: com.github.mikephil.charting.h.q */
public class C2613q extends C2612p {
    public C2613q(C2621g c2621g, C2541g c2541g, C2618d c2618d) {
        super(c2621g, c2541g, c2618d);
        this.e.setTextAlign(Align.LEFT);
    }

    public void m10028a(float f, float f2) {
        if (this.o.m10100j() > 10.0f && !this.o.m10111t()) {
            C2616b a = this.a.m10039a(this.o.m10092f(), this.o.m10090e());
            C2616b a2 = this.a.m10039a(this.o.m10094g(), this.o.m10090e());
            if (this.f.m9642w()) {
                f = (float) a2.f9067a;
                f2 = (float) a.f9067a;
            } else {
                f = (float) a.f9067a;
                f2 = (float) a2.f9067a;
            }
        }
        m10024b(f, f2);
    }

    public void m10029a(Canvas canvas) {
        if (this.f.m9565p() && this.f.m9574g()) {
            float[] fArr = new float[(this.f.f8806n * 2)];
            for (int i = 0; i < fArr.length; i += 2) {
                fArr[i] = this.f.f8805m[i / 2];
            }
            this.a.m10044a(fArr);
            this.c.setTypeface(this.f.m9562m());
            this.c.setTextSize(this.f.m9563n());
            this.c.setColor(this.f.m9564o());
            this.c.setTextAlign(Align.CENTER);
            float a = C2620f.m10053a(2.5f);
            float b = (float) C2620f.m10071b(this.c, "Q");
            C2539a q = this.f.m9636q();
            C2540b r = this.f.m9637r();
            a = q == C2539a.LEFT ? r == C2540b.OUTSIDE_CHART ? this.o.m10090e() - a : this.o.m10090e() - a : r == C2540b.OUTSIDE_CHART ? a + (b + this.o.m10096h()) : a + (b + this.o.m10096h());
            m10030a(canvas, a, fArr, this.f.m9561l());
        }
    }

    protected void m10030a(Canvas canvas, float f, float[] fArr, float f2) {
        this.c.setTypeface(this.f.m9562m());
        this.c.setTextSize(this.f.m9563n());
        this.c.setColor(this.f.m9564o());
        int i = 0;
        while (i < this.f.f8806n) {
            String a = this.f.m9632a(i);
            if (this.f.m9638s() || i < this.f.f8806n - 1) {
                canvas.drawText(a, fArr[i * 2], f - f2, this.c);
                i++;
            } else {
                return;
            }
        }
    }

    public void m10031b(Canvas canvas) {
        if (this.f.m9565p() && this.f.m9569b()) {
            this.d.setColor(this.f.m9573f());
            this.d.setStrokeWidth(this.f.m9571d());
            if (this.f.m9636q() == C2539a.LEFT) {
                canvas.drawLine(this.o.m10092f(), this.o.m10090e(), this.o.m10094g(), this.o.m10090e(), this.d);
                return;
            }
            canvas.drawLine(this.o.m10092f(), this.o.m10096h(), this.o.m10094g(), this.o.m10096h(), this.d);
        }
    }

    public void m10032c(Canvas canvas) {
        if (this.f.m9565p()) {
            float[] fArr = new float[2];
            if (this.f.m9567a()) {
                this.b.setColor(this.f.m9570c());
                this.b.setStrokeWidth(this.f.m9572e());
                for (int i = 0; i < this.f.f8806n; i++) {
                    fArr[0] = this.f.f8805m[i];
                    this.a.m10044a(fArr);
                    canvas.drawLine(fArr[0], this.o.m10090e(), fArr[0], this.o.m10096h(), this.b);
                }
            }
            if (this.f.m9625B()) {
                fArr[0] = 0.0f;
                this.a.m10044a(fArr);
                m10022a(canvas, fArr[0] + 1.0f, fArr[0] + 1.0f, this.o.m10090e(), this.o.m10096h());
            }
        }
    }

    public void m10033d(Canvas canvas) {
        List h = this.f.m9575h();
        if (h != null && h.size() > 0) {
            float[] fArr = new float[4];
            Path path = new Path();
            for (int i = 0; i < h.size(); i++) {
                C2535d c2535d = (C2535d) h.get(i);
                if (c2535d.m9565p()) {
                    fArr[0] = c2535d.m9602a();
                    fArr[2] = c2535d.m9602a();
                    this.a.m10044a(fArr);
                    fArr[1] = this.o.m10090e();
                    fArr[3] = this.o.m10096h();
                    path.moveTo(fArr[0], fArr[1]);
                    path.lineTo(fArr[2], fArr[3]);
                    this.e.setStyle(Style.STROKE);
                    this.e.setColor(c2535d.m9604c());
                    this.e.setPathEffect(c2535d.m9605d());
                    this.e.setStrokeWidth(c2535d.m9603b());
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
                        float b = c2535d.m9603b() + c2535d.m9560k();
                        float a = C2620f.m10053a(2.0f) + c2535d.m9561l();
                        C2534a f = c2535d.m9607f();
                        if (f == C2534a.RIGHT_TOP) {
                            float b2 = (float) C2620f.m10071b(this.e, g);
                            this.e.setTextAlign(Align.LEFT);
                            canvas.drawText(g, b + fArr[0], b2 + (a + this.o.m10090e()), this.e);
                        } else if (f == C2534a.RIGHT_BOTTOM) {
                            this.e.setTextAlign(Align.LEFT);
                            canvas.drawText(g, fArr[0] + b, this.o.m10096h() - a, this.e);
                        } else if (f == C2534a.LEFT_TOP) {
                            this.e.setTextAlign(Align.RIGHT);
                            canvas.drawText(g, fArr[0] - b, ((float) C2620f.m10071b(this.e, g)) + (a + this.o.m10090e()), this.e);
                        } else {
                            this.e.setTextAlign(Align.RIGHT);
                            canvas.drawText(g, fArr[0] - b, this.o.m10096h() - a, this.e);
                        }
                    }
                }
            }
        }
    }
}
