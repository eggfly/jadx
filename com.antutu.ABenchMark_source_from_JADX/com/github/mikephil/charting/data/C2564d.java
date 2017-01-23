package com.github.mikephil.charting.data;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.view.MotionEventCompat;
import com.antutu.utils.widget.SystemBarTintManager;
import com.github.mikephil.charting.p039d.C1202f;
import com.github.mikephil.charting.p039d.C2554b;
import com.github.mikephil.charting.p138c.C2541g.C2539a;
import com.github.mikephil.charting.p139f.p141b.C2563d;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.github.mikephil.charting.data.d */
public abstract class C2564d<T extends Entry> implements C2563d<T> {
    private String f8931a;
    protected List<Integer> f8932b;
    protected List<Integer> f8933c;
    protected C2539a f8934d;
    protected boolean f8935e;
    protected transient C1202f f8936f;
    protected Typeface f8937g;
    protected boolean f8938h;
    protected float f8939i;
    protected boolean f8940j;

    public C2564d() {
        this.f8932b = null;
        this.f8933c = null;
        this.f8931a = "DataSet";
        this.f8934d = C2539a.LEFT;
        this.f8935e = true;
        this.f8938h = true;
        this.f8939i = 17.0f;
        this.f8940j = true;
        this.f8932b = new ArrayList();
        this.f8933c = new ArrayList();
        this.f8932b.add(Integer.valueOf(Color.rgb(140, 234, MotionEventCompat.ACTION_MASK)));
        this.f8933c.add(Integer.valueOf(SystemBarTintManager.DEFAULT_TINT_COLOR));
    }

    public C2564d(String str) {
        this();
        this.f8931a = str;
    }

    public void m9795a(C1202f c1202f) {
        if (c1202f != null) {
            this.f8936f = c1202f;
        }
    }

    public void m9796a(boolean z) {
        this.f8938h = z;
    }

    public int m9797b(int i) {
        return ((Integer) this.f8932b.get(i % this.f8932b.size())).intValue();
    }

    public List<Integer> m9798b() {
        return this.f8932b;
    }

    public int m9799c() {
        return ((Integer) this.f8932b.get(0)).intValue();
    }

    public void m9800c(int i) {
        m9802d();
        this.f8932b.add(Integer.valueOf(i));
    }

    public int m9801d(int i) {
        return ((Integer) this.f8933c.get(i % this.f8933c.size())).intValue();
    }

    public void m9802d() {
        this.f8932b = new ArrayList();
    }

    public String m9803e() {
        return this.f8931a;
    }

    public boolean m9804f() {
        return this.f8935e;
    }

    public C1202f m9805g() {
        return this.f8936f == null ? new C2554b(1) : this.f8936f;
    }

    public Typeface m9806h() {
        return this.f8937g;
    }

    public float m9807i() {
        return this.f8939i;
    }

    public boolean m9808j() {
        return this.f8938h;
    }

    public boolean m9809k() {
        return this.f8940j;
    }

    public C2539a m9810l() {
        return this.f8934d;
    }
}
