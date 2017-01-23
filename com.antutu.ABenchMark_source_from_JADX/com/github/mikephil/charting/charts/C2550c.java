package com.github.mikephil.charting.charts;

import android.util.Log;
import com.github.mikephil.charting.data.C2562a;
import com.github.mikephil.charting.p138c.C2533c.C2532c;
import com.github.mikephil.charting.p138c.C2538f.C2537a;
import com.github.mikephil.charting.p138c.C2541g.C2539a;
import com.github.mikephil.charting.p142e.C2581c;
import com.github.mikephil.charting.p142e.C2582d;
import com.github.mikephil.charting.p144h.C2600d;
import com.github.mikephil.charting.p144h.C2610n;
import com.github.mikephil.charting.p144h.C2613q;
import com.github.mikephil.charting.p145i.C2619e;
import com.github.mikephil.charting.p145i.C2620f;

/* renamed from: com.github.mikephil.charting.charts.c */
public class C2550c extends BarChart {
    public C2581c m9725a(float f, float f2) {
        if (this.t != null) {
            return getHighlighter().m9874a(f2, f);
        }
        Log.e("MPAndroidChart", "Can't select by touch. No data set.");
        return null;
    }

    protected void m9726a() {
        super.m9695a();
        this.p = new C2619e(this.J);
        this.q = new C2619e(this.J);
        this.H = new C2600d(this, this.K, this.J);
        setHighlighter(new C2582d(this));
        this.n = new C2613q(this.J, this.k, this.p);
        this.o = new C2613q(this.J, this.l, this.q);
        this.r = new C2610n(this.J, this.m, this.p, this);
    }

    protected void m9727f() {
        this.q.m10040a(this.l.f8798A, this.l.f8799B, this.z, this.A);
        this.p.m10040a(this.k.f8798A, this.k.f8799B, this.z, this.A);
    }

    public int getHighestVisibleXIndex() {
        float e = (float) ((C2562a) this.t).m9761e();
        float a = e <= 1.0f ? 1.0f : ((C2562a) this.t).m9771a() + e;
        float[] fArr = new float[]{this.J.m10092f(), this.J.m10090e()};
        m9668a(C2539a.LEFT).m10049b(fArr);
        return (int) (fArr[1] >= getXChartMax() ? getXChartMax() / a : fArr[1] / a);
    }

    public int getLowestVisibleXIndex() {
        float e = (float) ((C2562a) this.t).m9761e();
        float a = e <= 1.0f ? 1.0f : ((C2562a) this.t).m9771a() + e;
        float[] fArr = new float[]{this.J.m10092f(), this.J.m10096h()};
        m9668a(C2539a.LEFT).m10049b(fArr);
        return (int) ((fArr[1] <= 0.0f ? 0.0f : fArr[1] / a) + 1.0f);
    }

    public void m9728i() {
        float min;
        float f;
        float f2;
        float f3;
        float f4 = 0.0f;
        if (this.D != null && this.D.m9565p()) {
            if (this.D.m9590f() == C2532c.RIGHT_OF_CHART || this.D.m9590f() == C2532c.RIGHT_OF_CHART_CENTER) {
                min = (Math.min(this.D.f8742a, this.J.m10105n() * this.D.m9598t()) + (this.D.m9560k() * 2.0f)) + 0.0f;
                f = 0.0f;
                f2 = 0.0f;
                if (this.k.m9630G()) {
                    f2 += this.k.m9635b(this.n.m9936a());
                }
                if (this.l.m9630G()) {
                    f4 += this.l.m9635b(this.o.m9936a());
                }
                f3 = (float) this.m.f8783o;
                if (this.m.m9565p()) {
                    if (this.m.m9616q() == C2537a.BOTTOM) {
                        f += f3;
                    } else if (this.m.m9616q() == C2537a.TOP) {
                        min += f3;
                    } else if (this.m.m9616q() == C2537a.BOTH_SIDED) {
                        f += f3;
                        min += f3;
                    }
                }
                f2 += getExtraTopOffset();
                min += getExtraRightOffset();
                f4 += getExtraBottomOffset();
                f += getExtraLeftOffset();
                f3 = C2620f.m10053a(this.i);
                this.J.m10080a(Math.max(f3, f), Math.max(f3, f2), Math.max(f3, min), Math.max(f3, f4));
                if (this.s) {
                    Log.i("MPAndroidChart", "offsetLeft: " + f + ", offsetTop: " + f2 + ", offsetRight: " + min + ", offsetBottom: " + f4);
                    Log.i("MPAndroidChart", "Content: " + this.J.m10102k().toString());
                }
                m9678g();
                m9727f();
            } else if (this.D.m9590f() == C2532c.LEFT_OF_CHART || this.D.m9590f() == C2532c.LEFT_OF_CHART_CENTER) {
                min = 0.0f;
                f = (Math.min(this.D.f8742a, this.J.m10105n() * this.D.m9598t()) + (this.D.m9560k() * 2.0f)) + 0.0f;
                f2 = 0.0f;
                if (this.k.m9630G()) {
                    f2 += this.k.m9635b(this.n.m9936a());
                }
                if (this.l.m9630G()) {
                    f4 += this.l.m9635b(this.o.m9936a());
                }
                f3 = (float) this.m.f8783o;
                if (this.m.m9565p()) {
                    if (this.m.m9616q() == C2537a.BOTTOM) {
                        f += f3;
                    } else if (this.m.m9616q() == C2537a.TOP) {
                        min += f3;
                    } else if (this.m.m9616q() == C2537a.BOTH_SIDED) {
                        f += f3;
                        min += f3;
                    }
                }
                f2 += getExtraTopOffset();
                min += getExtraRightOffset();
                f4 += getExtraBottomOffset();
                f += getExtraLeftOffset();
                f3 = C2620f.m10053a(this.i);
                this.J.m10080a(Math.max(f3, f), Math.max(f3, f2), Math.max(f3, min), Math.max(f3, f4));
                if (this.s) {
                    Log.i("MPAndroidChart", "offsetLeft: " + f + ", offsetTop: " + f2 + ", offsetRight: " + min + ", offsetBottom: " + f4);
                    Log.i("MPAndroidChart", "Content: " + this.J.m10102k().toString());
                }
                m9678g();
                m9727f();
            } else if (this.D.m9590f() == C2532c.BELOW_CHART_LEFT || this.D.m9590f() == C2532c.BELOW_CHART_RIGHT || this.D.m9590f() == C2532c.BELOW_CHART_CENTER) {
                min = 0.0f;
                f = 0.0f;
                f2 = 0.0f;
                f4 = Math.min(this.D.f8744c + this.D.f8743b, this.J.m10104m() * this.D.m9598t()) + 0.0f;
                if (this.k.m9630G()) {
                    f2 += this.k.m9635b(this.n.m9936a());
                }
                if (this.l.m9630G()) {
                    f4 += this.l.m9635b(this.o.m9936a());
                }
                f3 = (float) this.m.f8783o;
                if (this.m.m9565p()) {
                    if (this.m.m9616q() == C2537a.BOTTOM) {
                        f += f3;
                    } else if (this.m.m9616q() == C2537a.TOP) {
                        min += f3;
                    } else if (this.m.m9616q() == C2537a.BOTH_SIDED) {
                        f += f3;
                        min += f3;
                    }
                }
                f2 += getExtraTopOffset();
                min += getExtraRightOffset();
                f4 += getExtraBottomOffset();
                f += getExtraLeftOffset();
                f3 = C2620f.m10053a(this.i);
                this.J.m10080a(Math.max(f3, f), Math.max(f3, f2), Math.max(f3, min), Math.max(f3, f4));
                if (this.s) {
                    Log.i("MPAndroidChart", "offsetLeft: " + f + ", offsetTop: " + f2 + ", offsetRight: " + min + ", offsetBottom: " + f4);
                    Log.i("MPAndroidChart", "Content: " + this.J.m10102k().toString());
                }
                m9678g();
                m9727f();
            } else if (this.D.m9590f() == C2532c.ABOVE_CHART_LEFT || this.D.m9590f() == C2532c.ABOVE_CHART_RIGHT || this.D.m9590f() == C2532c.ABOVE_CHART_CENTER) {
                f2 = Math.min((this.D.f8744c * 2.0f) + this.D.f8743b, this.J.m10104m() * this.D.m9598t()) + 0.0f;
                min = 0.0f;
                f = 0.0f;
                if (this.k.m9630G()) {
                    f2 += this.k.m9635b(this.n.m9936a());
                }
                if (this.l.m9630G()) {
                    f4 += this.l.m9635b(this.o.m9936a());
                }
                f3 = (float) this.m.f8783o;
                if (this.m.m9565p()) {
                    if (this.m.m9616q() == C2537a.BOTTOM) {
                        f += f3;
                    } else if (this.m.m9616q() == C2537a.TOP) {
                        min += f3;
                    } else if (this.m.m9616q() == C2537a.BOTH_SIDED) {
                        f += f3;
                        min += f3;
                    }
                }
                f2 += getExtraTopOffset();
                min += getExtraRightOffset();
                f4 += getExtraBottomOffset();
                f += getExtraLeftOffset();
                f3 = C2620f.m10053a(this.i);
                this.J.m10080a(Math.max(f3, f), Math.max(f3, f2), Math.max(f3, min), Math.max(f3, f4));
                if (this.s) {
                    Log.i("MPAndroidChart", "offsetLeft: " + f + ", offsetTop: " + f2 + ", offsetRight: " + min + ", offsetBottom: " + f4);
                    Log.i("MPAndroidChart", "Content: " + this.J.m10102k().toString());
                }
                m9678g();
                m9727f();
            }
        }
        f2 = 0.0f;
        min = 0.0f;
        f = 0.0f;
        if (this.k.m9630G()) {
            f2 += this.k.m9635b(this.n.m9936a());
        }
        if (this.l.m9630G()) {
            f4 += this.l.m9635b(this.o.m9936a());
        }
        f3 = (float) this.m.f8783o;
        if (this.m.m9565p()) {
            if (this.m.m9616q() == C2537a.BOTTOM) {
                f += f3;
            } else if (this.m.m9616q() == C2537a.TOP) {
                min += f3;
            } else if (this.m.m9616q() == C2537a.BOTH_SIDED) {
                f += f3;
                min += f3;
            }
        }
        f2 += getExtraTopOffset();
        min += getExtraRightOffset();
        f4 += getExtraBottomOffset();
        f += getExtraLeftOffset();
        f3 = C2620f.m10053a(this.i);
        this.J.m10080a(Math.max(f3, f), Math.max(f3, f2), Math.max(f3, min), Math.max(f3, f4));
        if (this.s) {
            Log.i("MPAndroidChart", "offsetLeft: " + f + ", offsetTop: " + f2 + ", offsetRight: " + min + ", offsetBottom: " + f4);
            Log.i("MPAndroidChart", "Content: " + this.J.m10102k().toString());
        }
        m9678g();
        m9727f();
    }

    protected void m9729j() {
        float[] fArr = new float[9];
        this.J.m10106o().getValues(fArr);
        this.m.f8786r = (int) Math.ceil((double) (((float) (((C2562a) this.t).m9768l() * this.m.f8784p)) / (fArr[4] * this.J.m10100j())));
        if (this.m.f8786r < 1) {
            this.m.f8786r = 1;
        }
    }
}
