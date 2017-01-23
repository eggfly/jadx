package com.github.mikephil.charting.p144h;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import com.github.mikephil.charting.data.C2560e;
import com.github.mikephil.charting.p138c.C2533c;
import com.github.mikephil.charting.p138c.C2533c.C2530a;
import com.github.mikephil.charting.p138c.C2533c.C2531b;
import com.github.mikephil.charting.p138c.C2533c.C2532c;
import com.github.mikephil.charting.p139f.p141b.C2563d;
import com.github.mikephil.charting.p139f.p141b.C2584a;
import com.github.mikephil.charting.p139f.p141b.C2585c;
import com.github.mikephil.charting.p139f.p141b.C2586h;
import com.github.mikephil.charting.p145i.C2615a;
import com.github.mikephil.charting.p145i.C2620f;
import com.github.mikephil.charting.p145i.C2621g;
import com.viewpagerindicator.C4273R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.github.mikephil.charting.h.e */
public class C2602e extends C2596k {
    protected Paint f9029a;
    protected Paint f9030b;
    protected C2533c f9031c;

    /* renamed from: com.github.mikephil.charting.h.e.1 */
    static /* synthetic */ class C26011 {
        static final /* synthetic */ int[] f9027a;
        static final /* synthetic */ int[] f9028b;

        static {
            f9028b = new int[C2531b.values().length];
            try {
                f9028b[C2531b.CIRCLE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f9028b[C2531b.SQUARE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f9028b[C2531b.LINE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            f9027a = new int[C2532c.values().length];
            try {
                f9027a[C2532c.BELOW_CHART_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f9027a[C2532c.BELOW_CHART_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f9027a[C2532c.BELOW_CHART_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f9027a[C2532c.ABOVE_CHART_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f9027a[C2532c.ABOVE_CHART_RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f9027a[C2532c.ABOVE_CHART_CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f9027a[C2532c.PIECHART_CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f9027a[C2532c.RIGHT_OF_CHART.ordinal()] = 8;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f9027a[C2532c.RIGHT_OF_CHART_CENTER.ordinal()] = 9;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f9027a[C2532c.RIGHT_OF_CHART_INSIDE.ordinal()] = 10;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f9027a[C2532c.LEFT_OF_CHART.ordinal()] = 11;
            } catch (NoSuchFieldError e14) {
            }
            try {
                f9027a[C2532c.LEFT_OF_CHART_CENTER.ordinal()] = 12;
            } catch (NoSuchFieldError e15) {
            }
            try {
                f9027a[C2532c.LEFT_OF_CHART_INSIDE.ordinal()] = 13;
            } catch (NoSuchFieldError e16) {
            }
        }
    }

    public C2602e(C2621g c2621g, C2533c c2533c) {
        super(c2621g);
        this.f9031c = c2533c;
        this.f9029a = new Paint(1);
        this.f9029a.setTextSize(C2620f.m10053a(9.0f));
        this.f9029a.setTextAlign(Align.LEFT);
        this.f9030b = new Paint(1);
        this.f9030b.setStyle(Style.FILL);
        this.f9030b.setStrokeWidth(3.0f);
    }

    public Paint m9960a() {
        return this.f9029a;
    }

    public void m9961a(Canvas canvas) {
        if (this.f9031c.m9565p()) {
            Typeface m = this.f9031c.m9562m();
            if (m != null) {
                this.f9029a.setTypeface(m);
            }
            this.f9029a.setTextSize(this.f9031c.m9563n());
            this.f9029a.setColor(this.f9031c.m9564o());
            float a = C2620f.m10054a(this.f9029a);
            float b = C2620f.m10067b(this.f9029a) + this.f9031c.m9595q();
            float b2 = a - (((float) C2620f.m10071b(this.f9029a, "ABC")) / 2.0f);
            String[] b3 = this.f9031c.m9584b();
            int[] a2 = this.f9031c.m9581a();
            float r = this.f9031c.m9596r();
            float j = this.f9031c.m9594j();
            C2530a g = this.f9031c.m9591g();
            float i = this.f9031c.m9593i();
            float s = this.f9031c.m9597s();
            float l = this.f9031c.m9561l();
            float k = this.f9031c.m9560k();
            C2532c f = this.f9031c.m9590f();
            float i2;
            float f2;
            int i3;
            float f3;
            switch (C26011.f9027a[f.ordinal()]) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                case SpdyProtocol.QUIC /*4*/:
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    i2 = this.o.m10098i();
                    if (f == C2532c.BELOW_CHART_LEFT || f == C2532c.ABOVE_CHART_LEFT) {
                        k += this.o.m10092f();
                        if (g == C2530a.RIGHT_TO_LEFT) {
                            f2 = k + this.f9031c.f8742a;
                        }
                        f2 = k;
                    } else if (f == C2532c.BELOW_CHART_RIGHT || f == C2532c.ABOVE_CHART_RIGHT) {
                        k = this.o.m10094g() - k;
                        if (g == C2530a.LEFT_TO_RIGHT) {
                            f2 = k - this.f9031c.f8742a;
                        }
                        f2 = k;
                    } else {
                        f2 = this.o.m10092f() + (i2 / 2.0f);
                    }
                    C2615a[] w = this.f9031c.m9601w();
                    C2615a[] u = this.f9031c.m9599u();
                    Boolean[] v = this.f9031c.m9600v();
                    k = (f == C2532c.ABOVE_CHART_LEFT || f == C2532c.ABOVE_CHART_RIGHT || f == C2532c.ABOVE_CHART_CENTER) ? 0.0f : (this.o.m10104m() - l) - this.f9031c.f8743b;
                    int i4 = 0;
                    i3 = 0;
                    int length = b3.length;
                    f3 = f2;
                    while (i3 < length) {
                        float f4;
                        int i5;
                        if (i3 >= v.length || !v[i3].booleanValue()) {
                            f4 = k;
                        } else {
                            f4 = k + (a + b);
                            f3 = f2;
                        }
                        if (f3 == f2 && f == C2532c.BELOW_CHART_CENTER && i4 < w.length) {
                            i5 = i4 + 1;
                            k = f3 + ((g == C2530a.RIGHT_TO_LEFT ? w[i4].f9065a : -w[i4].f9065a) / 2.0f);
                        } else {
                            i5 = i4;
                            k = f3;
                        }
                        Object obj = a2[i3] != -2 ? 1 : null;
                        Object obj2 = b3[i3] == null ? 1 : null;
                        if (obj != null) {
                            f3 = g == C2530a.RIGHT_TO_LEFT ? k - i : k;
                            m9962a(canvas, f3, f4 + b2, i3, this.f9031c);
                            i2 = g == C2530a.LEFT_TO_RIGHT ? f3 + i : f3;
                        } else {
                            i2 = k;
                        }
                        if (obj2 == null) {
                            if (obj != null) {
                                k = (g == C2530a.RIGHT_TO_LEFT ? -r : r) + i2;
                            } else {
                                k = i2;
                            }
                            if (g == C2530a.RIGHT_TO_LEFT) {
                                k -= u[i3].f9065a;
                            }
                            m9963a(canvas, k, f4 + a, b3[i3]);
                            if (g == C2530a.LEFT_TO_RIGHT) {
                                k += u[i3].f9065a;
                            }
                            k += g == C2530a.RIGHT_TO_LEFT ? -j : j;
                        } else {
                            k = (g == C2530a.RIGHT_TO_LEFT ? -s : s) + i2;
                        }
                        i3++;
                        i4 = i5;
                        f3 = k;
                        k = f4;
                    }
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                case Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
                case C4273R.styleable.TitlePageIndicator_titlePadding /*13*/:
                    if (f == C2532c.PIECHART_CENTER) {
                        k = ((this.o.m10104m() / 2.0f) - (this.f9031c.f8743b / 2.0f)) + this.f9031c.m9561l();
                        f2 = (this.o.m10105n() / 2.0f) + (g == C2530a.LEFT_TO_RIGHT ? (-this.f9031c.f8745d) / 2.0f : this.f9031c.f8745d / 2.0f);
                    } else {
                        Object obj3 = (f == C2532c.RIGHT_OF_CHART || f == C2532c.RIGHT_OF_CHART_CENTER || f == C2532c.RIGHT_OF_CHART_INSIDE) ? 1 : null;
                        if (obj3 != null) {
                            k = this.o.m10105n() - k;
                            if (g == C2530a.LEFT_TO_RIGHT) {
                                k -= this.f9031c.f8745d;
                            }
                        } else if (g == C2530a.RIGHT_TO_LEFT) {
                            k += this.f9031c.f8745d;
                        }
                        if (f == C2532c.RIGHT_OF_CHART || f == C2532c.LEFT_OF_CHART) {
                            f2 = k;
                            k = this.o.m10090e() + l;
                        } else if (f == C2532c.RIGHT_OF_CHART_CENTER || f == C2532c.LEFT_OF_CHART_CENTER) {
                            f2 = k;
                            k = (this.o.m10104m() / 2.0f) - (this.f9031c.f8743b / 2.0f);
                        } else {
                            f2 = k;
                            k = this.o.m10090e() + l;
                        }
                    }
                    i3 = 0;
                    Object obj4 = null;
                    float f5 = 0.0f;
                    j = k;
                    while (i3 < b3.length) {
                        Object obj5;
                        Boolean valueOf = Boolean.valueOf(a2[i3] != -2);
                        if (valueOf.booleanValue()) {
                            f3 = g == C2530a.LEFT_TO_RIGHT ? f2 + f5 : f2 - (i - f5);
                            m9962a(canvas, f3, j + b2, i3, this.f9031c);
                            if (g == C2530a.LEFT_TO_RIGHT) {
                                f3 += i;
                            }
                        } else {
                            f3 = f2;
                        }
                        if (b3[i3] != null) {
                            if (valueOf.booleanValue() && obj4 == null) {
                                f3 += g == C2530a.LEFT_TO_RIGHT ? r : -r;
                            } else if (obj4 != null) {
                                f3 = f2;
                            }
                            if (g == C2530a.RIGHT_TO_LEFT) {
                                f3 -= (float) C2620f.m10056a(this.f9029a, b3[i3]);
                            }
                            if (obj4 == null) {
                                m9963a(canvas, f3, j + a, b3[i3]);
                            } else {
                                j += a + b;
                                m9963a(canvas, f3, j + a, b3[i3]);
                            }
                            f3 = j + (a + b);
                            i2 = 0.0f;
                            obj5 = obj4;
                        } else {
                            i2 = f5 + (i + s);
                            obj5 = 1;
                            f3 = j;
                        }
                        i3++;
                        obj4 = obj5;
                        f5 = i2;
                        j = f3;
                    }
                default:
            }
        }
    }

    protected void m9962a(Canvas canvas, float f, float f2, int i, C2533c c2533c) {
        if (c2533c.m9581a()[i] != -2) {
            this.f9030b.setColor(c2533c.m9581a()[i]);
            float i2 = c2533c.m9593i();
            float f3 = i2 / 2.0f;
            switch (C26011.f9028b[c2533c.m9592h().ordinal()]) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    canvas.drawCircle(f + f3, f2, f3, this.f9030b);
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    canvas.drawRect(f, f2 - f3, f + i2, f2 + f3, this.f9030b);
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    canvas.drawLine(f, f2, f + i2, f2, this.f9030b);
                default:
            }
        }
    }

    protected void m9963a(Canvas canvas, float f, float f2, String str) {
        canvas.drawText(str, f, f2, this.f9029a);
    }

    public void m9964a(C2560e<?> c2560e) {
        int i = 0;
        if (!this.f9031c.m9589e()) {
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < c2560e.m9761e(); i2++) {
                C2563d a = c2560e.m9756a(i2);
                List b = a.m9778b();
                int m = a.m9792m();
                int i3;
                if ((a instanceof C2584a) && ((C2584a) a).m9893n()) {
                    C2584a c2584a = (C2584a) a;
                    String[] t = c2584a.m9897t();
                    i3 = 0;
                    while (i3 < b.size() && i3 < c2584a.m9894q()) {
                        arrayList.add(t[i3 % t.length]);
                        arrayList2.add(b.get(i3));
                        i3++;
                    }
                    if (c2584a.m9782e() != null) {
                        arrayList2.add(Integer.valueOf(-2));
                        arrayList.add(c2584a.m9782e());
                    }
                } else if (a instanceof C2586h) {
                    List j = c2560e.m9766j();
                    C2586h c2586h = (C2586h) a;
                    i3 = 0;
                    while (i3 < b.size() && i3 < m && i3 < j.size()) {
                        arrayList.add(j.get(i3));
                        arrayList2.add(b.get(i3));
                        i3++;
                    }
                    if (c2586h.m9782e() != null) {
                        arrayList2.add(Integer.valueOf(-2));
                        arrayList.add(c2586h.m9782e());
                    }
                } else if (!(a instanceof C2585c) || ((C2585c) a).m9899n() == -1) {
                    i3 = 0;
                    while (i3 < b.size() && i3 < m) {
                        if (i3 >= b.size() - 1 || i3 >= m - 1) {
                            arrayList.add(c2560e.m9756a(i2).m9782e());
                        } else {
                            arrayList.add(null);
                        }
                        arrayList2.add(b.get(i3));
                        i3++;
                    }
                } else {
                    arrayList2.add(Integer.valueOf(((C2585c) a).m9899n()));
                    arrayList2.add(Integer.valueOf(((C2585c) a).m9898d()));
                    arrayList.add(null);
                    arrayList.add(a.m9782e());
                }
            }
            if (!(this.f9031c.m9586c() == null || this.f9031c.m9588d() == null)) {
                int[] c = this.f9031c.m9586c();
                int length = c.length;
                while (i < length) {
                    arrayList2.add(Integer.valueOf(c[i]));
                    i++;
                }
                Collections.addAll(arrayList, this.f9031c.m9588d());
            }
            this.f9031c.m9580a(arrayList2);
            this.f9031c.m9583b(arrayList);
        }
        Typeface m2 = this.f9031c.m9562m();
        if (m2 != null) {
            this.f9029a.setTypeface(m2);
        }
        this.f9029a.setTextSize(this.f9031c.m9563n());
        this.f9029a.setColor(this.f9031c.m9564o());
        this.f9031c.m9579a(this.f9029a, this.o);
    }
}
