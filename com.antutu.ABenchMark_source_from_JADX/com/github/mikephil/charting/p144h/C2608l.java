package com.github.mikephil.charting.p144h;

import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import com.antutu.utils.widget.SystemBarTintManager;
import com.github.mikephil.charting.p138c.C2535d;
import com.github.mikephil.charting.p138c.C2535d.C2534a;
import com.github.mikephil.charting.p138c.C2538f;
import com.github.mikephil.charting.p138c.C2538f.C2537a;
import com.github.mikephil.charting.p145i.C2615a;
import com.github.mikephil.charting.p145i.C2618d;
import com.github.mikephil.charting.p145i.C2620f;
import com.github.mikephil.charting.p145i.C2621g;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.List;

/* renamed from: com.github.mikephil.charting.h.l */
public class C2608l extends C2597a {
    protected C2538f f9057f;
    float[] f9058g;
    private Path f9059h;

    public C2608l(C2621g c2621g, C2538f c2538f, C2618d c2618d) {
        super(c2621g, c2618d);
        this.f9058g = new float[4];
        this.f9059h = new Path();
        this.f9057f = c2538f;
        this.c.setColor(SystemBarTintManager.DEFAULT_TINT_COLOR);
        this.c.setTextAlign(Align.CENTER);
        this.c.setTextSize(C2620f.m10053a(10.0f));
    }

    public void m10001a(float f, List<String> list) {
        int i = 0;
        this.c.setTypeface(this.f9057f.m9562m());
        this.c.setTextSize(this.f9057f.m9563n());
        StringBuilder stringBuilder = new StringBuilder();
        int round = Math.round(f);
        for (int i2 = 0; i2 < round; i2++) {
            stringBuilder.append('h');
        }
        float f2 = C2620f.m10075c(this.c, stringBuilder.toString()).f9065a;
        float b = (float) C2620f.m10071b(this.c, "Q");
        C2615a a = C2620f.m10059a(f2, b, this.f9057f.m9617r());
        StringBuilder stringBuilder2 = new StringBuilder();
        int t = this.f9057f.m9619t();
        while (i < t) {
            stringBuilder2.append('h');
            i++;
        }
        C2615a c = C2620f.m10075c(this.c, stringBuilder2.toString());
        this.f9057f.f8781m = Math.round(f2 + c.f9065a);
        this.f9057f.f8782n = Math.round(b);
        this.f9057f.f8783o = Math.round(c.f9065a + a.f9065a);
        this.f9057f.f8784p = Math.round(a.f9066b);
        this.f9057f.m9615a((List) list);
    }

    public void m10002a(Canvas canvas) {
        if (this.f9057f.m9565p() && this.f9057f.m9574g()) {
            float l = this.f9057f.m9561l();
            this.c.setTypeface(this.f9057f.m9562m());
            this.c.setTextSize(this.f9057f.m9563n());
            this.c.setColor(this.f9057f.m9564o());
            if (this.f9057f.m9616q() == C2537a.TOP) {
                m10003a(canvas, this.o.m10090e() - l, new PointF(0.5f, 1.0f));
            } else if (this.f9057f.m9616q() == C2537a.TOP_INSIDE) {
                m10003a(canvas, (l + this.o.m10090e()) + ((float) this.f9057f.f8784p), new PointF(0.5f, 1.0f));
            } else if (this.f9057f.m9616q() == C2537a.BOTTOM) {
                m10003a(canvas, l + this.o.m10096h(), new PointF(0.5f, 0.0f));
            } else if (this.f9057f.m9616q() == C2537a.BOTTOM_INSIDE) {
                m10003a(canvas, (this.o.m10096h() - l) - ((float) this.f9057f.f8784p), new PointF(0.5f, 0.0f));
            } else {
                m10003a(canvas, this.o.m10090e() - l, new PointF(0.5f, 1.0f));
                m10003a(canvas, l + this.o.m10096h(), new PointF(0.5f, 0.0f));
            }
        }
    }

    protected void m10003a(Canvas canvas, float f, PointF pointF) {
        float r = this.f9057f.m9617r();
        float[] fArr = new float[]{0.0f, 0.0f};
        int i = this.p;
        while (i <= this.q) {
            fArr[0] = (float) i;
            this.a.m10044a(fArr);
            if (this.o.m10087c(fArr[0])) {
                String str = (String) this.f9057f.m9621v().get(i);
                if (this.f9057f.m9620u()) {
                    if (i == this.f9057f.m9621v().size() - 1 && this.f9057f.m9621v().size() > 1) {
                        float a = (float) C2620f.m10056a(this.c, str);
                        if (a > this.o.m10082b() * 2.0f && fArr[0] + a > this.o.m10105n()) {
                            fArr[0] = fArr[0] - (a / 2.0f);
                        }
                    } else if (i == 0) {
                        fArr[0] = (((float) C2620f.m10056a(this.c, str)) / 2.0f) + fArr[0];
                    }
                }
                m10006a(canvas, str, i, fArr[0], f, pointF, r);
            }
            i += this.f9057f.f8786r;
        }
    }

    public void m10004a(Canvas canvas, C2535d c2535d, float[] fArr) {
        this.f9058g[0] = fArr[0];
        this.f9058g[1] = this.o.m10090e();
        this.f9058g[2] = fArr[0];
        this.f9058g[3] = this.o.m10096h();
        this.f9059h.reset();
        this.f9059h.moveTo(this.f9058g[0], this.f9058g[1]);
        this.f9059h.lineTo(this.f9058g[2], this.f9058g[3]);
        this.e.setStyle(Style.STROKE);
        this.e.setColor(c2535d.m9604c());
        this.e.setStrokeWidth(c2535d.m9603b());
        this.e.setPathEffect(c2535d.m9605d());
        canvas.drawPath(this.f9059h, this.e);
    }

    public void m10005a(Canvas canvas, C2535d c2535d, float[] fArr, float f) {
        String g = c2535d.m9608g();
        if (g != null && !g.equals(BuildConfig.FLAVOR)) {
            this.e.setStyle(c2535d.m9606e());
            this.e.setPathEffect(null);
            this.e.setColor(c2535d.m9564o());
            this.e.setStrokeWidth(0.5f);
            this.e.setTextSize(c2535d.m9563n());
            float b = c2535d.m9603b() + c2535d.m9560k();
            C2534a f2 = c2535d.m9607f();
            if (f2 == C2534a.RIGHT_TOP) {
                float b2 = (float) C2620f.m10071b(this.e, g);
                this.e.setTextAlign(Align.LEFT);
                canvas.drawText(g, b + fArr[0], b2 + (this.o.m10090e() + f), this.e);
            } else if (f2 == C2534a.RIGHT_BOTTOM) {
                this.e.setTextAlign(Align.LEFT);
                canvas.drawText(g, b + fArr[0], this.o.m10096h() - f, this.e);
            } else if (f2 == C2534a.LEFT_TOP) {
                this.e.setTextAlign(Align.RIGHT);
                canvas.drawText(g, fArr[0] - b, ((float) C2620f.m10071b(this.e, g)) + (this.o.m10090e() + f), this.e);
            } else {
                this.e.setTextAlign(Align.RIGHT);
                canvas.drawText(g, fArr[0] - b, this.o.m10096h() - f, this.e);
            }
        }
    }

    protected void m10006a(Canvas canvas, String str, int i, float f, float f2, PointF pointF, float f3) {
        C2620f.m10061a(canvas, this.f9057f.m9622w().m9738a(str, i, this.o), f, f2, this.c, pointF, f3);
    }

    public void m10007b(Canvas canvas) {
        if (this.f9057f.m9569b() && this.f9057f.m9565p()) {
            this.d.setColor(this.f9057f.m9573f());
            this.d.setStrokeWidth(this.f9057f.m9571d());
            if (this.f9057f.m9616q() == C2537a.TOP || this.f9057f.m9616q() == C2537a.TOP_INSIDE || this.f9057f.m9616q() == C2537a.BOTH_SIDED) {
                canvas.drawLine(this.o.m10092f(), this.o.m10090e(), this.o.m10094g(), this.o.m10090e(), this.d);
            }
            if (this.f9057f.m9616q() == C2537a.BOTTOM || this.f9057f.m9616q() == C2537a.BOTTOM_INSIDE || this.f9057f.m9616q() == C2537a.BOTH_SIDED) {
                canvas.drawLine(this.o.m10092f(), this.o.m10096h(), this.o.m10094g(), this.o.m10096h(), this.d);
            }
        }
    }

    public void m10008c(Canvas canvas) {
        if (this.f9057f.m9567a() && this.f9057f.m9565p()) {
            float[] fArr = new float[]{0.0f, 0.0f};
            this.b.setColor(this.f9057f.m9570c());
            this.b.setStrokeWidth(this.f9057f.m9572e());
            this.b.setPathEffect(this.f9057f.m9577j());
            Path path = new Path();
            int i = this.p;
            while (i <= this.q) {
                fArr[0] = (float) i;
                this.a.m10044a(fArr);
                if (fArr[0] >= this.o.m10076a() && fArr[0] <= this.o.m10105n()) {
                    path.moveTo(fArr[0], this.o.m10096h());
                    path.lineTo(fArr[0], this.o.m10090e());
                    canvas.drawPath(path, this.b);
                }
                path.reset();
                i += this.f9057f.f8786r;
            }
        }
    }

    public void m10009d(Canvas canvas) {
        List h = this.f9057f.m9575h();
        if (h != null && h.size() > 0) {
            float[] fArr = new float[2];
            for (int i = 0; i < h.size(); i++) {
                C2535d c2535d = (C2535d) h.get(i);
                if (c2535d.m9565p()) {
                    fArr[0] = c2535d.m9602a();
                    fArr[1] = 0.0f;
                    this.a.m10044a(fArr);
                    m10004a(canvas, c2535d, fArr);
                    m10005a(canvas, c2535d, fArr, 2.0f + c2535d.m9561l());
                }
            }
        }
    }
}
