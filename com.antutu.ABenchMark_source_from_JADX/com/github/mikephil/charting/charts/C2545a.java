package com.github.mikephil.charting.charts;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import com.antutu.utils.widget.SystemBarTintManager;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.C2561b;
import com.github.mikephil.charting.data.C2562a;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.p138c.C2533c.C2532c;
import com.github.mikephil.charting.p138c.C2538f;
import com.github.mikephil.charting.p138c.C2538f.C2537a;
import com.github.mikephil.charting.p138c.C2541g;
import com.github.mikephil.charting.p138c.C2541g.C2539a;
import com.github.mikephil.charting.p139f.p140a.C2544b;
import com.github.mikephil.charting.p139f.p141b.C2566b;
import com.github.mikephil.charting.p142e.C2579b;
import com.github.mikephil.charting.p142e.C2581c;
import com.github.mikephil.charting.p143g.C2589a;
import com.github.mikephil.charting.p143g.C2593e;
import com.github.mikephil.charting.p144h.C2608l;
import com.github.mikephil.charting.p144h.C2612p;
import com.github.mikephil.charting.p145i.C2618d;
import com.github.mikephil.charting.p145i.C2620f;

@SuppressLint({"RtlHardcoded"})
/* renamed from: com.github.mikephil.charting.charts.a */
public abstract class C2545a<T extends C2561b<? extends C2566b<? extends Entry>>> extends C2543b<T> implements C2544b {
    private boolean f8855Q;
    private Integer f8856R;
    private Integer f8857S;
    private boolean f8858T;
    private boolean f8859U;
    private boolean f8860V;
    private long f8861W;
    protected int f8862a;
    private long aa;
    private boolean ab;
    protected boolean f8863b;
    protected boolean f8864c;
    protected boolean f8865d;
    protected Paint f8866e;
    protected Paint f8867f;
    protected boolean f8868g;
    protected boolean f8869h;
    protected float f8870i;
    protected C2593e f8871j;
    protected C2541g f8872k;
    protected C2541g f8873l;
    protected C2538f f8874m;
    protected C2612p f8875n;
    protected C2612p f8876o;
    protected C2618d f8877p;
    protected C2618d f8878q;
    protected C2608l f8879r;

    public C2545a(Context context) {
        super(context);
        this.f8862a = 100;
        this.f8855Q = false;
        this.f8856R = null;
        this.f8857S = null;
        this.f8863b = false;
        this.f8864c = true;
        this.f8865d = true;
        this.f8858T = true;
        this.f8859U = true;
        this.f8860V = true;
        this.f8868g = false;
        this.f8869h = false;
        this.f8870i = 15.0f;
        this.f8861W = 0;
        this.aa = 0;
        this.ab = false;
    }

    public C2545a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8862a = 100;
        this.f8855Q = false;
        this.f8856R = null;
        this.f8857S = null;
        this.f8863b = false;
        this.f8864c = true;
        this.f8865d = true;
        this.f8858T = true;
        this.f8859U = true;
        this.f8860V = true;
        this.f8868g = false;
        this.f8869h = false;
        this.f8870i = 15.0f;
        this.f8861W = 0;
        this.aa = 0;
        this.ab = false;
    }

    public C2545a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8862a = 100;
        this.f8855Q = false;
        this.f8856R = null;
        this.f8857S = null;
        this.f8863b = false;
        this.f8864c = true;
        this.f8865d = true;
        this.f8858T = true;
        this.f8859U = true;
        this.f8860V = true;
        this.f8868g = false;
        this.f8869h = false;
        this.f8870i = 15.0f;
        this.f8861W = 0;
        this.aa = 0;
        this.ab = false;
    }

    public C2581c m9667a(float f, float f2) {
        if (this.t != null) {
            return getHighlighter().m9874a(f, f2);
        }
        Log.e("MPAndroidChart", "Can't select by touch. No data set.");
        return null;
    }

    public C2618d m9668a(C2539a c2539a) {
        return c2539a == C2539a.LEFT ? this.f8877p : this.f8878q;
    }

    protected void m9669a() {
        super.m9647a();
        this.f8872k = new C2541g(C2539a.LEFT);
        this.f8873l = new C2541g(C2539a.RIGHT);
        this.f8874m = new C2538f();
        this.f8877p = new C2618d(this.J);
        this.f8878q = new C2618d(this.J);
        this.f8875n = new C2612p(this.J, this.f8872k, this.f8877p);
        this.f8876o = new C2612p(this.J, this.f8873l, this.f8878q);
        this.f8879r = new C2608l(this.J, this.f8874m, this.f8877p);
        setHighlighter(new C2579b(this));
        this.F = new C2589a(this, this.J.m10106o());
        this.f8866e = new Paint();
        this.f8866e.setStyle(Style.FILL);
        this.f8866e.setColor(Color.rgb(240, 240, 240));
        this.f8867f = new Paint();
        this.f8867f.setStyle(Style.STROKE);
        this.f8867f.setColor(SystemBarTintManager.DEFAULT_TINT_COLOR);
        this.f8867f.setStrokeWidth(C2620f.m10053a(1.0f));
    }

    public void m9670a(float f, float f2, float f3, float f4) {
        this.J.m10077a(this.J.m10083b(f, f2, f3, -f4), this, false);
        m9680i();
        postInvalidate();
    }

    protected void m9671a(Canvas canvas) {
        if (this.f8868g) {
            canvas.drawRect(this.J.m10102k(), this.f8866e);
        }
        if (this.f8869h) {
            canvas.drawRect(this.J.m10102k(), this.f8867f);
        }
    }

    protected float[] m9672a(Entry entry, C2581c c2581c) {
        int a = c2581c.m9883a();
        float d = (float) entry.m9743d();
        float b = entry.m9742b();
        if (this instanceof BarChart) {
            d = ((C2562a) this.t).m9771a();
            int e = ((C2561b) this.t).m9761e();
            int d2 = entry.m9743d();
            if (this instanceof C2550c) {
                float f = (d / 2.0f) + (((float) ((((e - 1) * d2) + d2) + a)) + (((float) d2) * d));
                d = (((BarEntry) entry).m9744a() != null ? c2581c.m9887d().f8973b : entry.m9742b()) * this.K.m9540a();
                b = f;
            } else {
                d = (d / 2.0f) + (((float) ((((e - 1) * d2) + d2) + a)) + (((float) d2) * d));
                b = (((BarEntry) entry).m9744a() != null ? c2581c.m9887d().f8973b : entry.m9742b()) * this.K.m9540a();
            }
        } else {
            b *= this.K.m9540a();
        }
        float[] fArr = new float[]{d, b};
        m9668a(((C2566b) ((C2561b) this.t).m9756a(a)).m9791l()).m10044a(fArr);
        return fArr;
    }

    public C2541g m9673b(C2539a c2539a) {
        return c2539a == C2539a.LEFT ? this.f8872k : this.f8873l;
    }

    public C2566b m9674b(float f, float f2) {
        C2581c a = m9667a(f, f2);
        return a != null ? (C2566b) ((C2561b) this.t).m9756a(a.m9883a()) : null;
    }

    protected void m9675b() {
        float f;
        if (this.f8855Q) {
            ((C2561b) this.t).m9757a(getLowestVisibleXIndex(), getHighestVisibleXIndex());
        }
        float x = !Float.isNaN(this.f8872k.m9643x()) ? this.f8872k.m9643x() : ((C2561b) this.t).m9753a(C2539a.LEFT);
        float y = !Float.isNaN(this.f8872k.m9644y()) ? this.f8872k.m9644y() : ((C2561b) this.t).m9758b(C2539a.LEFT);
        float x2 = !Float.isNaN(this.f8873l.m9643x()) ? this.f8873l.m9643x() : ((C2561b) this.t).m9753a(C2539a.RIGHT);
        float y2 = !Float.isNaN(this.f8873l.m9644y()) ? this.f8873l.m9644y() : ((C2561b) this.t).m9758b(C2539a.RIGHT);
        float abs = Math.abs(y - x);
        float abs2 = Math.abs(y2 - x2);
        if (abs == 0.0f) {
            y += 1.0f;
            f = x - 1.0f;
        } else {
            f = x;
        }
        if (abs2 == 0.0f) {
            x2 -= 1.0f;
            x = y2 + 1.0f;
        } else {
            x = y2;
        }
        float z = this.f8872k.m9645z() * (abs / 100.0f);
        float z2 = this.f8873l.m9645z() * (abs2 / 100.0f);
        abs = this.f8872k.m9624A() * (abs / 100.0f);
        abs2 = this.f8873l.m9624A() * (abs2 / 100.0f);
        this.B = (float) (((C2561b) this.t).m9766j().size() - 1);
        this.z = Math.abs(this.B - this.A);
        this.f8872k.f8798A = !Float.isNaN(this.f8872k.m9643x()) ? this.f8872k.m9643x() : f - abs;
        this.f8872k.f8818z = !Float.isNaN(this.f8872k.m9644y()) ? this.f8872k.m9644y() : y + z;
        this.f8873l.f8798A = !Float.isNaN(this.f8873l.m9643x()) ? this.f8873l.m9643x() : x2 - abs2;
        this.f8873l.f8818z = !Float.isNaN(this.f8873l.m9644y()) ? this.f8873l.m9644y() : x + z2;
        this.f8872k.f8799B = Math.abs(this.f8872k.f8818z - this.f8872k.f8798A);
        this.f8873l.f8799B = Math.abs(this.f8873l.f8818z - this.f8873l.f8798A);
    }

    public boolean m9676c(C2539a c2539a) {
        return m9673b(c2539a).m9642w();
    }

    public void computeScroll() {
        if (this.F instanceof C2589a) {
            ((C2589a) this.F).m9917b();
        }
    }

    protected void m9677f() {
        if (this.s) {
            Log.i("MPAndroidChart", "Preparing Value-Px Matrix, xmin: " + this.A + ", xmax: " + this.B + ", xdelta: " + this.z);
        }
        this.f8878q.m10040a(this.A, this.z, this.f8873l.f8799B, this.f8873l.f8798A);
        this.f8877p.m10040a(this.A, this.z, this.f8872k.f8799B, this.f8872k.f8798A);
    }

    protected void m9678g() {
        this.f8878q.m10043a(this.f8873l.m9642w());
        this.f8877p.m10043a(this.f8872k.m9642w());
    }

    public C2541g getAxisLeft() {
        return this.f8872k;
    }

    public C2541g getAxisRight() {
        return this.f8873l;
    }

    public /* bridge */ /* synthetic */ C2561b getData() {
        return (C2561b) super.getData();
    }

    public C2593e getDrawListener() {
        return this.f8871j;
    }

    public int getHighestVisibleXIndex() {
        float[] fArr = new float[]{this.J.m10094g(), this.J.m10096h()};
        m9668a(C2539a.LEFT).m10049b(fArr);
        return fArr[0] >= ((float) ((C2561b) this.t).m9768l()) ? ((C2561b) this.t).m9768l() - 1 : (int) fArr[0];
    }

    public int getLowestVisibleXIndex() {
        float[] fArr = new float[]{this.J.m10092f(), this.J.m10096h()};
        m9668a(C2539a.LEFT).m10049b(fArr);
        return fArr[0] <= 0.0f ? 0 : (int) (fArr[0] + 1.0f);
    }

    public int getMaxVisibleCount() {
        return this.f8862a;
    }

    public float getMinOffset() {
        return this.f8870i;
    }

    public C2612p getRendererLeftYAxis() {
        return this.f8875n;
    }

    public C2612p getRendererRightYAxis() {
        return this.f8876o;
    }

    public C2608l getRendererXAxis() {
        return this.f8879r;
    }

    public float getScaleX() {
        return this.J == null ? 1.0f : this.J.m10107p();
    }

    public float getScaleY() {
        return this.J == null ? 1.0f : this.J.m10108q();
    }

    public C2538f getXAxis() {
        return this.f8874m;
    }

    public float getYChartMax() {
        return Math.max(this.f8872k.f8818z, this.f8873l.f8818z);
    }

    public float getYChartMin() {
        return Math.min(this.f8872k.f8798A, this.f8873l.f8798A);
    }

    public void m9679h() {
        if (this.t != null) {
            if (this.s) {
                Log.i("MPAndroidChart", "Preparing...");
            }
            if (this.H != null) {
                this.H.m9937a();
            }
            m9675b();
            this.f8875n.m10020a(this.f8872k.f8798A, this.f8872k.f8818z);
            this.f8876o.m10020a(this.f8873l.f8798A, this.f8873l.f8818z);
            this.f8879r.m10001a(((C2561b) this.t).m9764h(), ((C2561b) this.t).m9766j());
            if (this.D != null) {
                this.G.m9964a(this.t);
            }
            m9680i();
        } else if (this.s) {
            Log.i("MPAndroidChart", "Preparing... DATA NOT SET.");
        }
    }

    public void m9680i() {
        float f = 0.0f;
        if (!this.ab) {
            float min;
            float f2;
            float f3;
            float l;
            if (this.D != null && this.D.m9565p()) {
                if (this.D.m9590f() == C2532c.RIGHT_OF_CHART || this.D.m9590f() == C2532c.RIGHT_OF_CHART_CENTER) {
                    min = (Math.min(this.D.f8742a, this.J.m10105n() * this.D.m9598t()) + (this.D.m9560k() * 2.0f)) + 0.0f;
                    f2 = 0.0f;
                    f3 = 0.0f;
                    if (this.f8872k.m9630G()) {
                        f2 += this.f8872k.m9631a(this.f8875n.m9936a());
                    }
                    if (this.f8873l.m9630G()) {
                        min += this.f8873l.m9631a(this.f8876o.m9936a());
                    }
                    if (this.f8874m.m9565p() && this.f8874m.m9574g()) {
                        l = ((float) this.f8874m.f8784p) + this.f8874m.m9561l();
                        if (this.f8874m.m9616q() == C2537a.BOTTOM) {
                            f += l;
                        } else if (this.f8874m.m9616q() == C2537a.TOP) {
                            f3 += l;
                        } else if (this.f8874m.m9616q() == C2537a.BOTH_SIDED) {
                            f += l;
                            f3 += l;
                        }
                    }
                    f3 += getExtraTopOffset();
                    min += getExtraRightOffset();
                    f += getExtraBottomOffset();
                    f2 += getExtraLeftOffset();
                    l = C2620f.m10053a(this.f8870i);
                    this.J.m10080a(Math.max(l, f2), Math.max(l, f3), Math.max(l, min), Math.max(l, f));
                    if (this.s) {
                        Log.i("MPAndroidChart", "offsetLeft: " + f2 + ", offsetTop: " + f3 + ", offsetRight: " + min + ", offsetBottom: " + f);
                        Log.i("MPAndroidChart", "Content: " + this.J.m10102k().toString());
                    }
                } else if (this.D.m9590f() == C2532c.LEFT_OF_CHART || this.D.m9590f() == C2532c.LEFT_OF_CHART_CENTER) {
                    min = 0.0f;
                    f2 = (Math.min(this.D.f8742a, this.J.m10105n() * this.D.m9598t()) + (this.D.m9560k() * 2.0f)) + 0.0f;
                    f3 = 0.0f;
                    if (this.f8872k.m9630G()) {
                        f2 += this.f8872k.m9631a(this.f8875n.m9936a());
                    }
                    if (this.f8873l.m9630G()) {
                        min += this.f8873l.m9631a(this.f8876o.m9936a());
                    }
                    l = ((float) this.f8874m.f8784p) + this.f8874m.m9561l();
                    if (this.f8874m.m9616q() == C2537a.BOTTOM) {
                        f += l;
                    } else if (this.f8874m.m9616q() == C2537a.TOP) {
                        f3 += l;
                    } else if (this.f8874m.m9616q() == C2537a.BOTH_SIDED) {
                        f += l;
                        f3 += l;
                    }
                    f3 += getExtraTopOffset();
                    min += getExtraRightOffset();
                    f += getExtraBottomOffset();
                    f2 += getExtraLeftOffset();
                    l = C2620f.m10053a(this.f8870i);
                    this.J.m10080a(Math.max(l, f2), Math.max(l, f3), Math.max(l, min), Math.max(l, f));
                    if (this.s) {
                        Log.i("MPAndroidChart", "offsetLeft: " + f2 + ", offsetTop: " + f3 + ", offsetRight: " + min + ", offsetBottom: " + f);
                        Log.i("MPAndroidChart", "Content: " + this.J.m10102k().toString());
                    }
                } else if (this.D.m9590f() == C2532c.BELOW_CHART_LEFT || this.D.m9590f() == C2532c.BELOW_CHART_RIGHT || this.D.m9590f() == C2532c.BELOW_CHART_CENTER) {
                    min = 0.0f;
                    f2 = 0.0f;
                    f3 = 0.0f;
                    f = Math.min(this.D.f8744c + this.D.f8743b, this.J.m10104m() * this.D.m9598t()) + 0.0f;
                    if (this.f8872k.m9630G()) {
                        f2 += this.f8872k.m9631a(this.f8875n.m9936a());
                    }
                    if (this.f8873l.m9630G()) {
                        min += this.f8873l.m9631a(this.f8876o.m9936a());
                    }
                    l = ((float) this.f8874m.f8784p) + this.f8874m.m9561l();
                    if (this.f8874m.m9616q() == C2537a.BOTTOM) {
                        f += l;
                    } else if (this.f8874m.m9616q() == C2537a.TOP) {
                        f3 += l;
                    } else if (this.f8874m.m9616q() == C2537a.BOTH_SIDED) {
                        f += l;
                        f3 += l;
                    }
                    f3 += getExtraTopOffset();
                    min += getExtraRightOffset();
                    f += getExtraBottomOffset();
                    f2 += getExtraLeftOffset();
                    l = C2620f.m10053a(this.f8870i);
                    this.J.m10080a(Math.max(l, f2), Math.max(l, f3), Math.max(l, min), Math.max(l, f));
                    if (this.s) {
                        Log.i("MPAndroidChart", "offsetLeft: " + f2 + ", offsetTop: " + f3 + ", offsetRight: " + min + ", offsetBottom: " + f);
                        Log.i("MPAndroidChart", "Content: " + this.J.m10102k().toString());
                    }
                } else if (this.D.m9590f() == C2532c.ABOVE_CHART_LEFT || this.D.m9590f() == C2532c.ABOVE_CHART_RIGHT || this.D.m9590f() == C2532c.ABOVE_CHART_CENTER) {
                    f3 = Math.min(this.D.f8744c + this.D.f8743b, this.J.m10104m() * this.D.m9598t()) + 0.0f;
                    min = 0.0f;
                    f2 = 0.0f;
                    if (this.f8872k.m9630G()) {
                        f2 += this.f8872k.m9631a(this.f8875n.m9936a());
                    }
                    if (this.f8873l.m9630G()) {
                        min += this.f8873l.m9631a(this.f8876o.m9936a());
                    }
                    l = ((float) this.f8874m.f8784p) + this.f8874m.m9561l();
                    if (this.f8874m.m9616q() == C2537a.BOTTOM) {
                        f += l;
                    } else if (this.f8874m.m9616q() == C2537a.TOP) {
                        f3 += l;
                    } else if (this.f8874m.m9616q() == C2537a.BOTH_SIDED) {
                        f += l;
                        f3 += l;
                    }
                    f3 += getExtraTopOffset();
                    min += getExtraRightOffset();
                    f += getExtraBottomOffset();
                    f2 += getExtraLeftOffset();
                    l = C2620f.m10053a(this.f8870i);
                    this.J.m10080a(Math.max(l, f2), Math.max(l, f3), Math.max(l, min), Math.max(l, f));
                    if (this.s) {
                        Log.i("MPAndroidChart", "offsetLeft: " + f2 + ", offsetTop: " + f3 + ", offsetRight: " + min + ", offsetBottom: " + f);
                        Log.i("MPAndroidChart", "Content: " + this.J.m10102k().toString());
                    }
                }
            }
            f3 = 0.0f;
            min = 0.0f;
            f2 = 0.0f;
            if (this.f8872k.m9630G()) {
                f2 += this.f8872k.m9631a(this.f8875n.m9936a());
            }
            if (this.f8873l.m9630G()) {
                min += this.f8873l.m9631a(this.f8876o.m9936a());
            }
            l = ((float) this.f8874m.f8784p) + this.f8874m.m9561l();
            if (this.f8874m.m9616q() == C2537a.BOTTOM) {
                f += l;
            } else if (this.f8874m.m9616q() == C2537a.TOP) {
                f3 += l;
            } else if (this.f8874m.m9616q() == C2537a.BOTH_SIDED) {
                f += l;
                f3 += l;
            }
            f3 += getExtraTopOffset();
            min += getExtraRightOffset();
            f += getExtraBottomOffset();
            f2 += getExtraLeftOffset();
            l = C2620f.m10053a(this.f8870i);
            this.J.m10080a(Math.max(l, f2), Math.max(l, f3), Math.max(l, min), Math.max(l, f));
            if (this.s) {
                Log.i("MPAndroidChart", "offsetLeft: " + f2 + ", offsetTop: " + f3 + ", offsetRight: " + min + ", offsetBottom: " + f);
                Log.i("MPAndroidChart", "Content: " + this.J.m10102k().toString());
            }
        }
        m9678g();
        m9677f();
    }

    protected void m9681j() {
        if (this.f8874m != null && this.f8874m.m9565p()) {
            if (!this.f8874m.m9618s()) {
                float[] fArr = new float[9];
                this.J.m10106o().getValues(fArr);
                this.f8874m.f8786r = (int) Math.ceil((double) (((float) (((C2561b) this.t).m9768l() * this.f8874m.f8783o)) / (fArr[0] * this.J.m10098i())));
            }
            if (this.s) {
                Log.i("MPAndroidChart", "X-Axis modulus: " + this.f8874m.f8786r + ", x-axis label width: " + this.f8874m.f8781m + ", x-axis label rotated width: " + this.f8874m.f8783o + ", content width: " + this.J.m10098i());
            }
            if (this.f8874m.f8786r < 1) {
                this.f8874m.f8786r = 1;
            }
        }
    }

    public boolean m9682k() {
        return this.f8865d;
    }

    public boolean m9683l() {
        return this.f8858T;
    }

    public boolean m9684m() {
        return this.f8859U;
    }

    public boolean m9685n() {
        return this.f8860V;
    }

    public boolean m9686o() {
        return this.f8864c;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.t != null) {
            int lowestVisibleXIndex;
            long currentTimeMillis = System.currentTimeMillis();
            m9681j();
            this.f8879r.m9935a(this, this.f8874m.f8786r);
            this.H.m9935a(this, this.f8874m.f8786r);
            m9671a(canvas);
            if (this.f8872k.m9565p()) {
                this.f8875n.m10020a(this.f8872k.f8798A, this.f8872k.f8818z);
            }
            if (this.f8873l.m9565p()) {
                this.f8876o.m10020a(this.f8873l.f8798A, this.f8873l.f8818z);
            }
            this.f8879r.m10007b(canvas);
            this.f8875n.m10025b(canvas);
            this.f8876o.m10025b(canvas);
            if (this.f8855Q) {
                lowestVisibleXIndex = getLowestVisibleXIndex();
                int highestVisibleXIndex = getHighestVisibleXIndex();
                if (this.f8856R == null || this.f8856R.intValue() != lowestVisibleXIndex || this.f8857S == null || this.f8857S.intValue() != highestVisibleXIndex) {
                    m9675b();
                    m9680i();
                    this.f8856R = Integer.valueOf(lowestVisibleXIndex);
                    this.f8857S = Integer.valueOf(highestVisibleXIndex);
                }
            }
            lowestVisibleXIndex = canvas.save();
            canvas.clipRect(this.J.m10102k());
            this.f8879r.m10008c(canvas);
            this.f8875n.m10026c(canvas);
            this.f8876o.m10026c(canvas);
            if (this.f8874m.m9576i()) {
                this.f8879r.m10009d(canvas);
            }
            if (this.f8872k.m9576i()) {
                this.f8875n.m10027d(canvas);
            }
            if (this.f8873l.m9576i()) {
                this.f8876o.m10027d(canvas);
            }
            this.H.m9938a(canvas);
            if (!this.f8874m.m9576i()) {
                this.f8879r.m10009d(canvas);
            }
            if (!this.f8872k.m9576i()) {
                this.f8875n.m10027d(canvas);
            }
            if (!this.f8873l.m9576i()) {
                this.f8876o.m10027d(canvas);
            }
            if (m9660u()) {
                this.H.m9940a(canvas, this.M);
            }
            canvas.restoreToCount(lowestVisibleXIndex);
            this.H.m9943c(canvas);
            this.f8879r.m10002a(canvas);
            this.f8875n.m10021a(canvas);
            this.f8876o.m10021a(canvas);
            this.H.m9942b(canvas);
            this.G.m9961a(canvas);
            m9656c(canvas);
            m9654b(canvas);
            if (this.s) {
                currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                this.f8861W += currentTimeMillis;
                this.aa++;
                Log.i("MPAndroidChart", "Drawtime: " + currentTimeMillis + " ms, average: " + (this.f8861W / this.aa) + " ms, cycles: " + this.aa);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return (this.F == null || this.t == null || !this.C) ? false : this.F.onTouch(this, motionEvent);
    }

    public boolean m9687p() {
        return this.J.m10109r();
    }

    public boolean m9688q() {
        return this.f8863b;
    }

    public boolean m9689r() {
        return this.J.m10112u();
    }

    public boolean m9690s() {
        return this.f8872k.m9642w() || this.f8873l.m9642w();
    }

    public void setAutoScaleMinMaxEnabled(boolean z) {
        this.f8855Q = z;
    }

    public void setBorderColor(int i) {
        this.f8867f.setColor(i);
    }

    public void setBorderWidth(float f) {
        this.f8867f.setStrokeWidth(C2620f.m10053a(f));
    }

    public void setDoubleTapToZoomEnabled(boolean z) {
        this.f8864c = z;
    }

    public void setDragEnabled(boolean z) {
        this.f8858T = z;
    }

    public void setDragOffsetX(float f) {
        this.J.m10099i(f);
    }

    public void setDragOffsetY(float f) {
        this.J.m10101j(f);
    }

    public void setDrawBorders(boolean z) {
        this.f8869h = z;
    }

    public void setDrawGridBackground(boolean z) {
        this.f8868g = z;
    }

    public void setGridBackgroundColor(int i) {
        this.f8866e.setColor(i);
    }

    public void setHighlightPerDragEnabled(boolean z) {
        this.f8865d = z;
    }

    public void setMaxVisibleValueCount(int i) {
        this.f8862a = i;
    }

    public void setMinOffset(float f) {
        this.f8870i = f;
    }

    public void setOnDrawListener(C2593e c2593e) {
        this.f8871j = c2593e;
    }

    public void setPinchZoom(boolean z) {
        this.f8863b = z;
    }

    public void setRendererLeftYAxis(C2612p c2612p) {
        this.f8875n = c2612p;
    }

    public void setRendererRightYAxis(C2612p c2612p) {
        this.f8876o = c2612p;
    }

    public void setScaleEnabled(boolean z) {
        this.f8859U = z;
        this.f8860V = z;
    }

    public void setScaleXEnabled(boolean z) {
        this.f8859U = z;
    }

    public void setScaleYEnabled(boolean z) {
        this.f8860V = z;
    }

    public void setVisibleXRangeMaximum(float f) {
        this.J.m10078a(this.z / f);
    }

    public void setVisibleXRangeMinimum(float f) {
        this.J.m10084b(this.z / f);
    }

    public void setXAxisRenderer(C2608l c2608l) {
        this.f8879r = c2608l;
    }
}
