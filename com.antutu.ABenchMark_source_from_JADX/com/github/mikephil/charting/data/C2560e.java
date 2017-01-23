package com.github.mikephil.charting.data;

import android.support.v4.widget.AutoScrollHelper;
import com.github.mikephil.charting.p138c.C2541g.C2539a;
import com.github.mikephil.charting.p139f.p141b.C2563d;
import com.github.mikephil.charting.p142e.C2581c;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.github.mikephil.charting.data.e */
public abstract class C2560e<T extends C2563d<? extends Entry>> {
    protected float f8920a;
    protected float f8921b;
    protected float f8922c;
    protected float f8923d;
    protected float f8924e;
    protected float f8925f;
    protected List<String> f8926g;
    protected List<T> f8927h;
    private int f8928i;
    private float f8929j;

    public C2560e() {
        this.f8920a = 0.0f;
        this.f8921b = 0.0f;
        this.f8922c = 0.0f;
        this.f8923d = 0.0f;
        this.f8924e = 0.0f;
        this.f8925f = 0.0f;
        this.f8928i = 0;
        this.f8929j = 0.0f;
        this.f8926g = new ArrayList();
        this.f8927h = new ArrayList();
    }

    public C2560e(List<String> list, List<T> list2) {
        this.f8920a = 0.0f;
        this.f8921b = 0.0f;
        this.f8922c = 0.0f;
        this.f8923d = 0.0f;
        this.f8924e = 0.0f;
        this.f8925f = 0.0f;
        this.f8928i = 0;
        this.f8929j = 0.0f;
        this.f8926g = list;
        this.f8927h = list2;
        m9759c();
    }

    private void m9750a() {
        if (this.f8926g.size() <= 0) {
            this.f8929j = 1.0f;
            return;
        }
        int i = 1;
        for (int i2 = 0; i2 < this.f8926g.size(); i2++) {
            int length = ((String) this.f8926g.get(i2)).length();
            if (length > i) {
                i = length;
            }
        }
        this.f8929j = (float) i;
    }

    private void m9751a(T t, T t2) {
        if (t == null) {
            this.f8922c = this.f8924e;
            this.f8923d = this.f8925f;
        } else if (t2 == null) {
            this.f8924e = this.f8922c;
            this.f8925f = this.f8923d;
        }
    }

    private void m9752b() {
        if (this.f8927h != null && !(this instanceof C2578m)) {
            for (int i = 0; i < this.f8927h.size(); i++) {
                if (((C2563d) this.f8927h.get(i)).m9792m() > this.f8926g.size()) {
                    throw new IllegalArgumentException("One or more of the DataSet Entry arrays are longer than the x-values array of this ChartData object.");
                }
            }
        }
    }

    public float m9753a(C2539a c2539a) {
        return c2539a == C2539a.LEFT ? this.f8923d : this.f8925f;
    }

    public int m9754a(T t) {
        for (int i = 0; i < this.f8927h.size(); i++) {
            if (this.f8927h.get(i) == t) {
                return i;
            }
        }
        return -1;
    }

    public Entry m9755a(C2581c c2581c) {
        return c2581c.m9883a() >= this.f8927h.size() ? null : ((C2563d) this.f8927h.get(c2581c.m9883a())).m9781e(c2581c.m9885b());
    }

    public T m9756a(int i) {
        return (this.f8927h == null || i < 0 || i >= this.f8927h.size()) ? null : (C2563d) this.f8927h.get(i);
    }

    public void m9757a(int i, int i2) {
        if (this.f8927h == null || this.f8927h.size() < 1) {
            this.f8920a = 0.0f;
            this.f8921b = 0.0f;
            return;
        }
        this.f8921b = AutoScrollHelper.NO_MAX;
        this.f8920a = -3.4028235E38f;
        for (int i3 = 0; i3 < this.f8927h.size(); i3++) {
            C2563d c2563d = (C2563d) this.f8927h.get(i3);
            c2563d.m9775a(i, i2);
            if (c2563d.m9793o() < this.f8921b) {
                this.f8921b = c2563d.m9793o();
            }
            if (c2563d.m9794p() > this.f8920a) {
                this.f8920a = c2563d.m9794p();
            }
        }
        if (this.f8921b == AutoScrollHelper.NO_MAX) {
            this.f8921b = 0.0f;
            this.f8920a = 0.0f;
        }
        C2563d m = m9769m();
        if (m != null) {
            this.f8922c = m.m9794p();
            this.f8923d = m.m9793o();
            for (C2563d c2563d2 : this.f8927h) {
                if (c2563d2.m9791l() == C2539a.LEFT) {
                    if (c2563d2.m9793o() < this.f8923d) {
                        this.f8923d = c2563d2.m9793o();
                    }
                    if (c2563d2.m9794p() > this.f8922c) {
                        this.f8922c = c2563d2.m9794p();
                    }
                }
            }
        }
        C2563d n = m9770n();
        if (n != null) {
            this.f8924e = n.m9794p();
            this.f8925f = n.m9793o();
            for (C2563d c2563d22 : this.f8927h) {
                if (c2563d22.m9791l() == C2539a.RIGHT) {
                    if (c2563d22.m9793o() < this.f8925f) {
                        this.f8925f = c2563d22.m9793o();
                    }
                    if (c2563d22.m9794p() > this.f8924e) {
                        this.f8924e = c2563d22.m9794p();
                    }
                }
            }
        }
        m9751a(m, n);
    }

    public float m9758b(C2539a c2539a) {
        return c2539a == C2539a.LEFT ? this.f8922c : this.f8924e;
    }

    protected void m9759c() {
        m9752b();
        m9760d();
        m9757a(0, this.f8928i);
        m9750a();
    }

    protected void m9760d() {
        this.f8928i = 0;
        if (this.f8927h != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.f8927h.size(); i2++) {
                i += ((C2563d) this.f8927h.get(i2)).m9792m();
            }
            this.f8928i = i;
        }
    }

    public int m9761e() {
        return this.f8927h == null ? 0 : this.f8927h.size();
    }

    public float m9762f() {
        return this.f8921b;
    }

    public float m9763g() {
        return this.f8920a;
    }

    public float m9764h() {
        return this.f8929j;
    }

    public int m9765i() {
        return this.f8928i;
    }

    public List<String> m9766j() {
        return this.f8926g;
    }

    public List<T> m9767k() {
        return this.f8927h;
    }

    public int m9768l() {
        return this.f8926g.size();
    }

    public T m9769m() {
        for (C2563d c2563d : this.f8927h) {
            if (c2563d.m9791l() == C2539a.LEFT) {
                return c2563d;
            }
        }
        return null;
    }

    public T m9770n() {
        for (C2563d c2563d : this.f8927h) {
            if (c2563d.m9791l() == C2539a.RIGHT) {
                return c2563d;
            }
        }
        return null;
    }
}
