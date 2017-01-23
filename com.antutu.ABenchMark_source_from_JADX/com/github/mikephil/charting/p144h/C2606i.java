package com.github.mikephil.charting.p144h;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.antutu.utils.widget.SystemBarTintManager;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.C2576k;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.p039d.C1202f;
import com.github.mikephil.charting.p136a.C2522a;
import com.github.mikephil.charting.p139f.p141b.C2563d;
import com.github.mikephil.charting.p139f.p141b.C2586h;
import com.github.mikephil.charting.p142e.C2581c;
import com.github.mikephil.charting.p145i.C2620f;
import com.github.mikephil.charting.p145i.C2621g;
import com.taobao.accs.common.Constants;
import java.lang.ref.WeakReference;
import java.util.List;

/* renamed from: com.github.mikephil.charting.h.i */
public class C2606i extends C2598c {
    protected PieChart f9042a;
    protected Paint f9043b;
    protected Paint f9044c;
    protected WeakReference<Bitmap> f9045d;
    protected Canvas f9046j;
    private TextPaint f9047k;
    private StaticLayout f9048l;
    private CharSequence f9049m;
    private RectF f9050n;
    private RectF[] f9051r;
    private Path f9052s;
    private RectF f9053t;
    private Path f9054u;

    public C2606i(PieChart pieChart, C2522a c2522a, C2621g c2621g) {
        super(c2522a, c2621g);
        this.f9050n = new RectF();
        this.f9051r = new RectF[]{new RectF(), new RectF(), new RectF()};
        this.f9052s = new Path();
        this.f9053t = new RectF();
        this.f9054u = new Path();
        this.f9042a = pieChart;
        this.f9043b = new Paint(1);
        this.f9043b.setColor(-1);
        this.f9043b.setStyle(Style.FILL);
        this.f9044c = new Paint(1);
        this.f9044c.setColor(-1);
        this.f9044c.setStyle(Style.FILL);
        this.f9044c.setAlpha(Constants.COMMAND_ELECTION);
        this.f9047k = new TextPaint(1);
        this.f9047k.setColor(SystemBarTintManager.DEFAULT_TINT_COLOR);
        this.f9047k.setTextSize(C2620f.m10053a(12.0f));
        this.i.setTextSize(C2620f.m10053a(13.0f));
        this.i.setColor(-1);
        this.i.setTextAlign(Align.CENTER);
    }

    protected float m9981a(PointF pointF, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = (f6 / 2.0f) + f5;
        float cos = pointF.x + (((float) Math.cos((double) ((f5 + f6) * 0.017453292f))) * f);
        float sin = pointF.y + (((float) Math.sin((double) ((f5 + f6) * 0.017453292f))) * f);
        float cos2 = pointF.x + (((float) Math.cos((double) (0.017453292f * f7))) * f);
        f7 = (((float) Math.sin((double) (f7 * 0.017453292f))) * f) + pointF.y;
        return (float) (((double) (f - ((float) ((Math.sqrt(Math.pow((double) (cos - f3), 2.0d) + Math.pow((double) (sin - f4), 2.0d)) / 2.0d) * Math.tan(((180.0d - ((double) f2)) / 2.0d) * 0.017453292519943295d))))) - Math.sqrt(Math.pow((double) (f7 - ((sin + f4) / 2.0f)), 2.0d) + Math.pow((double) (cos2 - ((cos + f3) / 2.0f)), 2.0d)));
    }

    public void m9982a() {
    }

    public void m9983a(Canvas canvas) {
        int n = (int) this.o.m10105n();
        int m = (int) this.o.m10104m();
        if (!(this.f9045d != null && ((Bitmap) this.f9045d.get()).getWidth() == n && ((Bitmap) this.f9045d.get()).getHeight() == m)) {
            if (n > 0 && m > 0) {
                this.f9045d = new WeakReference(Bitmap.createBitmap(n, m, Config.ARGB_4444));
                this.f9046j = new Canvas((Bitmap) this.f9045d.get());
            } else {
                return;
            }
        }
        ((Bitmap) this.f9045d.get()).eraseColor(0);
        for (C2586h c2586h : ((C2576k) this.f9042a.getData()).m9767k()) {
            if (c2586h.m9790k() && c2586h.m9792m() > 0) {
                m9984a(canvas, c2586h);
            }
        }
    }

    protected void m9984a(Canvas canvas, C2586h c2586h) {
        float rotationAngle = this.f9042a.getRotationAngle();
        float b = this.e.m9542b();
        float a = this.e.m9540a();
        RectF circleBox = this.f9042a.getCircleBox();
        int m = c2586h.m9792m();
        float[] drawAngles = this.f9042a.getDrawAngles();
        float a2 = c2586h.m9900a();
        PointF centerCircleBox = this.f9042a.getCenterCircleBox();
        float radius = this.f9042a.getRadius();
        float holeRadius = (!this.f9042a.m9720d() || this.f9042a.m9719c()) ? 0.0f : (this.f9042a.getHoleRadius() / 100.0f) * radius;
        int i = 0;
        int i2 = 0;
        while (i2 < m) {
            int i3 = ((double) Math.abs(c2586h.m9783f(i2).m9742b())) > 1.0E-6d ? i + 1 : i;
            i2++;
            i = i3;
        }
        int i4 = 0;
        float f = 0.0f;
        while (i4 < m) {
            float f2 = drawAngles[i4];
            Entry f3 = c2586h.m9783f(i4);
            if (((double) Math.abs(f3.m9742b())) > 1.0E-6d && !this.f9042a.m9716a(f3.m9743d(), ((C2576k) this.f9042a.getData()).m9754a((C2563d) c2586h))) {
                this.f.setColor(c2586h.m9777b(i4));
                float f4 = i == 1 ? 0.0f : a2 / (0.017453292f * radius);
                float f5 = rotationAngle + (((f4 / 2.0f) + f) * a);
                float f6 = (f2 - f4) * a;
                if (f6 < 0.0f) {
                    f6 = 0.0f;
                }
                this.f9052s.reset();
                float f7 = 0.0f;
                float f8 = 0.0f;
                if (f6 % 360.0f == 0.0f) {
                    this.f9052s.addCircle(centerCircleBox.x, centerCircleBox.y, radius, Direction.CW);
                } else {
                    f7 = centerCircleBox.x + (((float) Math.cos((double) (0.017453292f * f5))) * radius);
                    f8 = centerCircleBox.y + (((float) Math.sin((double) (0.017453292f * f5))) * radius);
                    this.f9052s.moveTo(f7, f8);
                    this.f9052s.arcTo(circleBox, f5, f6);
                }
                f4 = a2 > 0.0f ? Math.max(holeRadius, m9981a(centerCircleBox, radius, f2 * a, f7, f8, f5, f6)) : holeRadius;
                this.f9053t.set(centerCircleBox.x - f4, centerCircleBox.y - f4, centerCircleBox.x + f4, centerCircleBox.y + f4);
                if (((double) f4) > 0.0d) {
                    float f9 = i == 1 ? 0.0f : a2 / (0.017453292f * f4);
                    f7 = (((f9 / 2.0f) + f) * a) + rotationAngle;
                    f9 = (f2 - f9) * a;
                    if (f9 < 0.0f) {
                        f9 = 0.0f;
                    }
                    f7 += f9;
                    if (f6 % 360.0f == 0.0f) {
                        this.f9052s.addCircle(centerCircleBox.x, centerCircleBox.y, f4, Direction.CCW);
                    } else {
                        this.f9052s.lineTo(centerCircleBox.x + (((float) Math.cos((double) (0.017453292f * f7))) * f4), (f4 * ((float) Math.sin((double) (0.017453292f * f7)))) + centerCircleBox.y);
                        this.f9052s.arcTo(this.f9053t, f7, -f9);
                    }
                } else if (f6 % 360.0f != 0.0f) {
                    this.f9052s.lineTo(centerCircleBox.x, centerCircleBox.y);
                }
                this.f9052s.close();
                this.f9046j.drawPath(this.f9052s, this.f);
            }
            i4++;
            f += f2 * b;
        }
    }

    public void m9985a(Canvas canvas, C2581c[] c2581cArr) {
        float b = this.e.m9542b();
        float a = this.e.m9540a();
        float rotationAngle = this.f9042a.getRotationAngle();
        float[] drawAngles = this.f9042a.getDrawAngles();
        float[] absoluteAngles = this.f9042a.getAbsoluteAngles();
        PointF centerCircleBox = this.f9042a.getCenterCircleBox();
        float radius = this.f9042a.getRadius();
        float holeRadius = (!this.f9042a.m9720d() || this.f9042a.m9719c()) ? 0.0f : (this.f9042a.getHoleRadius() / 100.0f) * radius;
        RectF rectF = new RectF();
        for (int i = 0; i < c2581cArr.length; i++) {
            int b2 = c2581cArr[i].m9885b();
            if (b2 < drawAngles.length) {
                C2586h b3 = ((C2576k) this.f9042a.getData()).m9871b(c2581cArr[i].m9883a());
                if (b3 != null && b3.m9784f()) {
                    int m = b3.m9792m();
                    int i2 = 0;
                    int i3 = 0;
                    while (i3 < m) {
                        int i4 = ((double) Math.abs(b3.m9783f(i3).m9742b())) > 1.0E-6d ? i2 + 1 : i2;
                        i3++;
                        i2 = i4;
                    }
                    float f = b2 == 0 ? 0.0f : absoluteAngles[b2 - 1] * b;
                    float a2 = b3.m9900a();
                    float f2 = drawAngles[b2];
                    float f3 = i2 == 1 ? 0.0f : a2 / (0.017453292f * radius);
                    float d = b3.m9901d();
                    float f4 = radius + d;
                    rectF.set(this.f9042a.getCircleBox());
                    rectF.inset(-d, -d);
                    this.f.setColor(b3.m9777b(b2));
                    float f5 = rotationAngle + (((f3 / 2.0f) + f) * a);
                    float f6 = (f2 - f3) * a;
                    if (f6 < 0.0f) {
                        f6 = 0.0f;
                    }
                    this.f9052s.reset();
                    if (f6 % 360.0f == 0.0f) {
                        this.f9052s.addCircle(centerCircleBox.x, centerCircleBox.y, f4, Direction.CW);
                    } else {
                        this.f9052s.moveTo(centerCircleBox.x + (((float) Math.cos((double) (0.017453292f * f5))) * f4), centerCircleBox.y + (((float) Math.sin((double) (0.017453292f * f5))) * f4));
                        this.f9052s.arcTo(rectF, f5, f6);
                    }
                    f3 = a2 > 0.0f ? Math.max(holeRadius, m9981a(centerCircleBox, radius, f2 * a, (((float) Math.cos((double) (0.017453292f * f5))) * radius) + centerCircleBox.x, (((float) Math.sin((double) (0.017453292f * f5))) * radius) + centerCircleBox.y, f5, f6)) : holeRadius;
                    this.f9053t.set(centerCircleBox.x - f3, centerCircleBox.y - f3, centerCircleBox.x + f3, centerCircleBox.y + f3);
                    if (((double) f3) > 0.0d) {
                        d = i2 == 1 ? 0.0f : a2 / (0.017453292f * f3);
                        float f7 = (((d / 2.0f) + f) * a) + rotationAngle;
                        d = (f2 - d) * a;
                        if (d < 0.0f) {
                            d = 0.0f;
                        }
                        f7 += d;
                        if (f6 % 360.0f == 0.0f) {
                            this.f9052s.addCircle(centerCircleBox.x, centerCircleBox.y, f3, Direction.CCW);
                        } else {
                            this.f9052s.lineTo(centerCircleBox.x + (((float) Math.cos((double) (0.017453292f * f7))) * f3), (f3 * ((float) Math.sin((double) (0.017453292f * f7)))) + centerCircleBox.y);
                            this.f9052s.arcTo(this.f9053t, f7, -d);
                        }
                    } else if (f6 % 360.0f != 0.0f) {
                        this.f9052s.lineTo(centerCircleBox.x, centerCircleBox.y);
                    }
                    this.f9052s.close();
                    this.f9046j.drawPath(this.f9052s, this.f);
                }
            }
        }
    }

    public Paint m9986b() {
        return this.f9043b;
    }

    public void m9987b(Canvas canvas) {
        PointF centerCircleBox = this.f9042a.getCenterCircleBox();
        float radius = this.f9042a.getRadius();
        float rotationAngle = this.f9042a.getRotationAngle();
        float[] drawAngles = this.f9042a.getDrawAngles();
        float[] absoluteAngles = this.f9042a.getAbsoluteAngles();
        float b = this.e.m9542b();
        this.e.m9540a();
        float f = (radius / 10.0f) * 3.6f;
        if (this.f9042a.m9720d()) {
            f = (radius - ((radius / 100.0f) * this.f9042a.getHoleRadius())) / 2.0f;
        }
        float f2 = radius - f;
        C2576k c2576k = (C2576k) this.f9042a.getData();
        List k = c2576k.m9767k();
        float b2 = c2576k.m9870b();
        boolean f3 = this.f9042a.m9722f();
        int i = 0;
        for (int i2 = 0; i2 < k.size(); i2++) {
            C2586h c2586h = (C2586h) k.get(i2);
            if (c2586h.m9789j() || f3) {
                m9941a((C2563d) c2586h);
                float b3 = ((float) C2620f.m10071b(this.i, "Q")) + C2620f.m10053a(4.0f);
                int m = c2586h.m9792m();
                int min = Math.min((int) Math.ceil((double) (((float) m) * b)), m);
                int i3 = i;
                for (int i4 = 0; i4 < min; i4++) {
                    Entry f4 = c2586h.m9783f(i4);
                    f = (i3 == 0 ? 0.0f : absoluteAngles[i3 - 1] * b) + ((drawAngles[i3] - ((c2586h.m9900a() / (0.017453292f * f2)) / 2.0f)) / 2.0f);
                    float cos = (float) ((((double) f2) * Math.cos(Math.toRadians((double) (rotationAngle + f)))) + ((double) centerCircleBox.x));
                    float sin = (float) ((Math.sin(Math.toRadians((double) (f + rotationAngle))) * ((double) f2)) + ((double) centerCircleBox.y));
                    float b4 = this.f9042a.m9723g() ? (f4.m9742b() / b2) * 100.0f : f4.m9742b();
                    C1202f g = c2586h.m9786g();
                    boolean j = c2586h.m9789j();
                    if (f3 && j) {
                        m9939a(canvas, g, b4, f4, 0, cos, sin, c2586h.m9780d(i4));
                        if (i4 < c2576k.m9768l()) {
                            canvas.drawText((String) c2576k.m9766j().get(i4), cos, sin + b3, this.i);
                        }
                    } else if (f3) {
                        if (i4 < c2576k.m9768l()) {
                            this.i.setColor(c2586h.m9780d(i4));
                            canvas.drawText((String) c2576k.m9766j().get(i4), cos, (b3 / 2.0f) + sin, this.i);
                        }
                    } else if (j) {
                        m9939a(canvas, g, b4, f4, 0, cos, sin + (b3 / 2.0f), c2586h.m9780d(i4));
                    }
                    i3++;
                }
                i = i3;
            }
        }
    }

    public Paint m9988c() {
        return this.f9044c;
    }

    public void m9989c(Canvas canvas) {
        m9991d(canvas);
        canvas.drawBitmap((Bitmap) this.f9045d.get(), 0.0f, 0.0f, null);
        m9993e(canvas);
    }

    public TextPaint m9990d() {
        return this.f9047k;
    }

    protected void m9991d(Canvas canvas) {
        if (this.f9042a.m9720d()) {
            float radius = this.f9042a.getRadius();
            float holeRadius = (this.f9042a.getHoleRadius() / 100.0f) * radius;
            PointF centerCircleBox = this.f9042a.getCenterCircleBox();
            if (Color.alpha(this.f9043b.getColor()) > 0) {
                this.f9046j.drawCircle(centerCircleBox.x, centerCircleBox.y, holeRadius, this.f9043b);
            }
            if (Color.alpha(this.f9044c.getColor()) > 0 && this.f9042a.getTransparentCircleRadius() > this.f9042a.getHoleRadius()) {
                int alpha = this.f9044c.getAlpha();
                radius *= this.f9042a.getTransparentCircleRadius() / 100.0f;
                this.f9044c.setAlpha((int) ((((float) alpha) * this.e.m9542b()) * this.e.m9540a()));
                this.f9054u.reset();
                this.f9054u.addCircle(centerCircleBox.x, centerCircleBox.y, radius, Direction.CW);
                this.f9054u.addCircle(centerCircleBox.x, centerCircleBox.y, holeRadius, Direction.CCW);
                this.f9046j.drawPath(this.f9054u, this.f9044c);
                this.f9044c.setAlpha(alpha);
            }
        }
    }

    public void m9992e() {
        if (this.f9045d != null) {
            ((Bitmap) this.f9045d.get()).recycle();
            this.f9045d.clear();
            this.f9045d = null;
        }
    }

    protected void m9993e(Canvas canvas) {
        CharSequence centerText = this.f9042a.getCenterText();
        if (this.f9042a.m9721e() && centerText != null) {
            PointF centerCircleBox = this.f9042a.getCenterCircleBox();
            float radius = (!this.f9042a.m9720d() || this.f9042a.m9719c()) ? this.f9042a.getRadius() : this.f9042a.getRadius() * (this.f9042a.getHoleRadius() / 100.0f);
            RectF rectF = this.f9051r[0];
            rectF.left = centerCircleBox.x - radius;
            rectF.top = centerCircleBox.y - radius;
            rectF.right = centerCircleBox.x + radius;
            rectF.bottom = radius + centerCircleBox.y;
            RectF rectF2 = this.f9051r[1];
            rectF2.set(rectF);
            radius = this.f9042a.getCenterTextRadiusPercent() / 100.0f;
            if (((double) radius) > 0.0d) {
                rectF2.inset((rectF2.width() - (rectF2.width() * radius)) / 2.0f, (rectF2.height() - (radius * rectF2.height())) / 2.0f);
            }
            if (!(centerText.equals(this.f9049m) && rectF2.equals(this.f9050n))) {
                this.f9050n.set(rectF2);
                this.f9049m = centerText;
                this.f9048l = new StaticLayout(centerText, 0, centerText.length(), this.f9047k, (int) Math.max(Math.ceil((double) this.f9050n.width()), 1.0d), Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
            }
            radius = (float) this.f9048l.getHeight();
            canvas.save();
            if (VERSION.SDK_INT >= 18) {
                Path path = new Path();
                path.addOval(rectF, Direction.CW);
                canvas.clipPath(path);
            }
            canvas.translate(rectF2.left, ((rectF2.height() - radius) / 2.0f) + rectF2.top);
            this.f9048l.draw(canvas);
            canvas.restore();
        }
    }
}
