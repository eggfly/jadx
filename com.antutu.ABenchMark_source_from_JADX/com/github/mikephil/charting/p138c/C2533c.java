package com.github.mikephil.charting.p138c;

import android.graphics.Paint;
import com.github.mikephil.charting.p145i.C2615a;
import com.github.mikephil.charting.p145i.C2620f;
import com.github.mikephil.charting.p145i.C2621g;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.github.mikephil.charting.c.c */
public class C2533c extends C2528b {
    private Boolean[] f8740A;
    private C2615a[] f8741B;
    public float f8742a;
    public float f8743b;
    public float f8744c;
    public float f8745d;
    private int[] f8746e;
    private String[] f8747l;
    private int[] f8748m;
    private String[] f8749n;
    private boolean f8750o;
    private C2532c f8751p;
    private C2530a f8752q;
    private C2531b f8753r;
    private float f8754s;
    private float f8755t;
    private float f8756u;
    private float f8757v;
    private float f8758w;
    private float f8759x;
    private boolean f8760y;
    private C2615a[] f8761z;

    /* renamed from: com.github.mikephil.charting.c.c.a */
    public enum C2530a {
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT
    }

    /* renamed from: com.github.mikephil.charting.c.c.b */
    public enum C2531b {
        SQUARE,
        CIRCLE,
        LINE
    }

    /* renamed from: com.github.mikephil.charting.c.c.c */
    public enum C2532c {
        RIGHT_OF_CHART,
        RIGHT_OF_CHART_CENTER,
        RIGHT_OF_CHART_INSIDE,
        LEFT_OF_CHART,
        LEFT_OF_CHART_CENTER,
        LEFT_OF_CHART_INSIDE,
        BELOW_CHART_LEFT,
        BELOW_CHART_RIGHT,
        BELOW_CHART_CENTER,
        ABOVE_CHART_LEFT,
        ABOVE_CHART_RIGHT,
        ABOVE_CHART_CENTER,
        PIECHART_CENTER
    }

    public C2533c() {
        this.f8750o = false;
        this.f8751p = C2532c.BELOW_CHART_LEFT;
        this.f8752q = C2530a.LEFT_TO_RIGHT;
        this.f8753r = C2531b.SQUARE;
        this.f8754s = 8.0f;
        this.f8755t = 6.0f;
        this.f8756u = 0.0f;
        this.f8757v = 5.0f;
        this.f8758w = 3.0f;
        this.f8759x = 0.95f;
        this.f8742a = 0.0f;
        this.f8743b = 0.0f;
        this.f8744c = 0.0f;
        this.f8745d = 0.0f;
        this.f8760y = false;
        this.f8761z = new C2615a[0];
        this.f8740A = new Boolean[0];
        this.f8741B = new C2615a[0];
        this.f8754s = C2620f.m10053a(8.0f);
        this.f8755t = C2620f.m10053a(6.0f);
        this.f8756u = C2620f.m10053a(0.0f);
        this.f8757v = C2620f.m10053a(5.0f);
        this.j = C2620f.m10053a(10.0f);
        this.f8758w = C2620f.m10053a(3.0f);
        this.g = C2620f.m10053a(5.0f);
        this.h = C2620f.m10053a(4.0f);
    }

    public float m9578a(Paint paint) {
        float f = 0.0f;
        for (int i = 0; i < this.f8747l.length; i++) {
            if (this.f8747l[i] != null) {
                float a = (float) C2620f.m10056a(paint, this.f8747l[i]);
                if (a > f) {
                    f = a;
                }
            }
        }
        return (this.f8754s + f) + this.f8757v;
    }

    public void m9579a(Paint paint, C2621g c2621g) {
        if (this.f8751p == C2532c.RIGHT_OF_CHART || this.f8751p == C2532c.RIGHT_OF_CHART_CENTER || this.f8751p == C2532c.LEFT_OF_CHART || this.f8751p == C2532c.LEFT_OF_CHART_CENTER || this.f8751p == C2532c.PIECHART_CENTER) {
            this.f8742a = m9578a(paint);
            this.f8743b = m9587d(paint);
            this.f8745d = this.f8742a;
            this.f8744c = m9582b(paint);
        } else if (this.f8751p == C2532c.BELOW_CHART_LEFT || this.f8751p == C2532c.BELOW_CHART_RIGHT || this.f8751p == C2532c.BELOW_CHART_CENTER || this.f8751p == C2532c.ABOVE_CHART_LEFT || this.f8751p == C2532c.ABOVE_CHART_RIGHT || this.f8751p == C2532c.ABOVE_CHART_CENTER) {
            int length = this.f8747l.length;
            float a = C2620f.m10054a(paint);
            float b = C2620f.m10067b(paint) + this.f8756u;
            float i = c2621g.m10098i();
            ArrayList arrayList = new ArrayList(length);
            ArrayList arrayList2 = new ArrayList(length);
            ArrayList arrayList3 = new ArrayList();
            float f = 0.0f;
            float f2 = 0.0f;
            float f3 = 0.0f;
            int i2 = -1;
            int i3 = 0;
            while (i3 < length) {
                int i4;
                float f4;
                Object obj = this.f8746e[i3] != -2 ? 1 : null;
                arrayList2.add(Boolean.valueOf(false));
                f3 = i2 == -1 ? 0.0f : f3 + this.f8758w;
                if (this.f8747l[i3] != null) {
                    arrayList.add(C2620f.m10075c(paint, this.f8747l[i3]));
                    f3 = ((C2615a) arrayList.get(i3)).f9065a + (f3 + (obj != null ? this.f8757v + this.f8754s : 0.0f));
                    i4 = i2;
                } else {
                    arrayList.add(new C2615a(0.0f, 0.0f));
                    float f5 = (obj != null ? this.f8754s : 0.0f) + f3;
                    if (i2 == -1) {
                        f3 = f5;
                        i4 = i3;
                    } else {
                        f3 = f5;
                        i4 = i2;
                    }
                }
                if (this.f8747l[i3] != null || i3 == length - 1) {
                    f4 = f2 == 0.0f ? 0.0f : this.f8755t;
                    if (!this.f8760y || f2 == 0.0f || i - f2 >= f4 + f3) {
                        f4 = (f4 + f3) + f2;
                        f2 = f;
                    } else {
                        arrayList3.add(new C2615a(f2, a));
                        f2 = Math.max(f, f2);
                        arrayList2.set(i4 > -1 ? i4 : i3, Boolean.valueOf(true));
                        f4 = f3;
                    }
                    if (i3 == length - 1) {
                        arrayList3.add(new C2615a(f4, a));
                        f2 = Math.max(f2, f4);
                    }
                } else {
                    f4 = f2;
                    f2 = f;
                }
                if (this.f8747l[i3] != null) {
                    i4 = -1;
                }
                i3++;
                f = f2;
                f2 = f4;
                i2 = i4;
            }
            this.f8761z = (C2615a[]) arrayList.toArray(new C2615a[arrayList.size()]);
            this.f8740A = (Boolean[]) arrayList2.toArray(new Boolean[arrayList2.size()]);
            this.f8741B = (C2615a[]) arrayList3.toArray(new C2615a[arrayList3.size()]);
            this.f8745d = m9578a(paint);
            this.f8744c = m9582b(paint);
            this.f8742a = f;
            this.f8743b = (((float) (this.f8741B.length == 0 ? 0 : this.f8741B.length - 1)) * b) + (a * ((float) this.f8741B.length));
        } else {
            this.f8742a = m9585c(paint);
            this.f8743b = m9582b(paint);
            this.f8745d = m9578a(paint);
            this.f8744c = this.f8743b;
        }
    }

    public void m9580a(List<Integer> list) {
        this.f8746e = C2620f.m10065a((List) list);
    }

    public int[] m9581a() {
        return this.f8746e;
    }

    public float m9582b(Paint paint) {
        float f = 0.0f;
        for (int i = 0; i < this.f8747l.length; i++) {
            if (this.f8747l[i] != null) {
                float b = (float) C2620f.m10071b(paint, this.f8747l[i]);
                if (b > f) {
                    f = b;
                }
            }
        }
        return f;
    }

    public void m9583b(List<String> list) {
        this.f8747l = C2620f.m10073b((List) list);
    }

    public String[] m9584b() {
        return this.f8747l;
    }

    public float m9585c(Paint paint) {
        float f = 0.0f;
        for (int i = 0; i < this.f8747l.length; i++) {
            if (this.f8747l[i] != null) {
                if (this.f8746e[i] != -2) {
                    f += this.f8754s + this.f8757v;
                }
                f += (float) C2620f.m10056a(paint, this.f8747l[i]);
                if (i < this.f8747l.length - 1) {
                    f += this.f8755t;
                }
            } else {
                f += this.f8754s;
                if (i < this.f8747l.length - 1) {
                    f += this.f8758w;
                }
            }
        }
        return f;
    }

    public int[] m9586c() {
        return this.f8748m;
    }

    public float m9587d(Paint paint) {
        float f = 0.0f;
        for (int i = 0; i < this.f8747l.length; i++) {
            if (this.f8747l[i] != null) {
                f += (float) C2620f.m10071b(paint, this.f8747l[i]);
                if (i < this.f8747l.length - 1) {
                    f += this.f8756u;
                }
            }
        }
        return f;
    }

    public String[] m9588d() {
        return this.f8749n;
    }

    public boolean m9589e() {
        return this.f8750o;
    }

    public C2532c m9590f() {
        return this.f8751p;
    }

    public C2530a m9591g() {
        return this.f8752q;
    }

    public C2531b m9592h() {
        return this.f8753r;
    }

    public float m9593i() {
        return this.f8754s;
    }

    public float m9594j() {
        return this.f8755t;
    }

    public float m9595q() {
        return this.f8756u;
    }

    public float m9596r() {
        return this.f8757v;
    }

    public float m9597s() {
        return this.f8758w;
    }

    public float m9598t() {
        return this.f8759x;
    }

    public C2615a[] m9599u() {
        return this.f8761z;
    }

    public Boolean[] m9600v() {
        return this.f8740A;
    }

    public C2615a[] m9601w() {
        return this.f8741B;
    }
}
