package com.github.mikephil.charting.p138c;

import android.graphics.Paint;
import com.github.mikephil.charting.p039d.C2557h;
import com.github.mikephil.charting.p039d.C2558d;
import com.github.mikephil.charting.p145i.C2620f;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.github.mikephil.charting.c.g */
public class C2541g extends C2529a {
    public float f8798A;
    public float f8799B;
    private int f8800C;
    private boolean f8801D;
    private C2540b f8802E;
    private C2539a f8803F;
    protected C2557h f8804l;
    public float[] f8805m;
    public int f8806n;
    public int f8807o;
    protected boolean f8808p;
    protected boolean f8809q;
    protected boolean f8810r;
    protected boolean f8811s;
    protected int f8812t;
    protected float f8813u;
    protected float f8814v;
    protected float f8815w;
    protected float f8816x;
    protected float f8817y;
    public float f8818z;

    /* renamed from: com.github.mikephil.charting.c.g.a */
    public enum C2539a {
        LEFT,
        RIGHT
    }

    /* renamed from: com.github.mikephil.charting.c.g.b */
    public enum C2540b {
        OUTSIDE_CHART,
        INSIDE_CHART
    }

    public C2541g() {
        this.f8805m = new float[0];
        this.f8800C = 6;
        this.f8801D = true;
        this.f8808p = false;
        this.f8809q = false;
        this.f8810r = false;
        this.f8811s = true;
        this.f8812t = -7829368;
        this.f8813u = 1.0f;
        this.f8814v = Float.NaN;
        this.f8815w = Float.NaN;
        this.f8816x = 10.0f;
        this.f8817y = 10.0f;
        this.f8818z = 0.0f;
        this.f8798A = 0.0f;
        this.f8799B = 0.0f;
        this.f8802E = C2540b.OUTSIDE_CHART;
        this.f8803F = C2539a.LEFT;
        this.h = 0.0f;
    }

    public C2541g(C2539a c2539a) {
        this.f8805m = new float[0];
        this.f8800C = 6;
        this.f8801D = true;
        this.f8808p = false;
        this.f8809q = false;
        this.f8810r = false;
        this.f8811s = true;
        this.f8812t = -7829368;
        this.f8813u = 1.0f;
        this.f8814v = Float.NaN;
        this.f8815w = Float.NaN;
        this.f8816x = 10.0f;
        this.f8817y = 10.0f;
        this.f8818z = 0.0f;
        this.f8798A = 0.0f;
        this.f8799B = 0.0f;
        this.f8802E = C2540b.OUTSIDE_CHART;
        this.f8803F = c2539a;
        this.h = 0.0f;
    }

    public float m9624A() {
        return this.f8817y;
    }

    public boolean m9625B() {
        return this.f8811s;
    }

    public int m9626C() {
        return this.f8812t;
    }

    public float m9627D() {
        return this.f8813u;
    }

    public String m9628E() {
        String str = BuildConfig.FLAVOR;
        int i = 0;
        while (i < this.f8805m.length) {
            String a = m9632a(i);
            if (str.length() >= a.length()) {
                a = str;
            }
            i++;
            str = a;
        }
        return str;
    }

    public C2557h m9629F() {
        if (this.f8804l == null) {
            this.f8804l = new C2558d(this.f8807o);
        }
        return this.f8804l;
    }

    public boolean m9630G() {
        return m9565p() && m9574g() && m9637r() == C2540b.OUTSIDE_CHART;
    }

    public float m9631a(Paint paint) {
        paint.setTextSize(this.j);
        return ((float) C2620f.m10056a(paint, m9628E())) + (m9560k() * 2.0f);
    }

    public String m9632a(int i) {
        return (i < 0 || i >= this.f8805m.length) ? BuildConfig.FLAVOR : m9629F().m9740a(this.f8805m[i], this);
    }

    public void m9633a(float f) {
        this.f8814v = f;
    }

    public void m9634a(int i, boolean z) {
        int i2 = 25;
        int i3 = 2;
        if (i <= 25) {
            i2 = i;
        }
        if (i2 >= 2) {
            i3 = i2;
        }
        this.f8800C = i3;
        this.f8810r = z;
    }

    public float m9635b(Paint paint) {
        paint.setTextSize(this.j);
        return ((float) C2620f.m10071b(paint, m9628E())) + (m9561l() * 2.0f);
    }

    public C2539a m9636q() {
        return this.f8803F;
    }

    public C2540b m9637r() {
        return this.f8802E;
    }

    public boolean m9638s() {
        return this.f8801D;
    }

    public int m9639t() {
        return this.f8800C;
    }

    public boolean m9640u() {
        return this.f8810r;
    }

    public boolean m9641v() {
        return this.f8808p;
    }

    public boolean m9642w() {
        return this.f8809q;
    }

    public float m9643x() {
        return this.f8814v;
    }

    public float m9644y() {
        return this.f8815w;
    }

    public float m9645z() {
        return this.f8816x;
    }
}
