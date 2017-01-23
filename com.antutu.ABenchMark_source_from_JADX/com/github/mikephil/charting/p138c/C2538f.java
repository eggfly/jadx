package com.github.mikephil.charting.p138c;

import com.github.mikephil.charting.p039d.C2555g;
import com.github.mikephil.charting.p039d.C2556c;
import com.github.mikephil.charting.p145i.C2620f;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.github.mikephil.charting.c.f */
public class C2538f extends C2529a {
    protected List<String> f8780l;
    public int f8781m;
    public int f8782n;
    public int f8783o;
    public int f8784p;
    protected float f8785q;
    public int f8786r;
    protected C2555g f8787s;
    private int f8788t;
    private boolean f8789u;
    private boolean f8790v;
    private C2537a f8791w;

    /* renamed from: com.github.mikephil.charting.c.f.a */
    public enum C2537a {
        TOP,
        BOTTOM,
        BOTH_SIDED,
        TOP_INSIDE,
        BOTTOM_INSIDE
    }

    public C2538f() {
        this.f8780l = new ArrayList();
        this.f8781m = 1;
        this.f8782n = 1;
        this.f8783o = 1;
        this.f8784p = 1;
        this.f8785q = 0.0f;
        this.f8788t = 4;
        this.f8786r = 1;
        this.f8789u = false;
        this.f8790v = false;
        this.f8787s = new C2556c();
        this.f8791w = C2537a.TOP;
        this.h = C2620f.m10053a(4.0f);
    }

    public void m9613a(int i) {
        this.f8788t = i;
    }

    public void m9614a(C2537a c2537a) {
        this.f8791w = c2537a;
    }

    public void m9615a(List<String> list) {
        this.f8780l = list;
    }

    public C2537a m9616q() {
        return this.f8791w;
    }

    public float m9617r() {
        return this.f8785q;
    }

    public boolean m9618s() {
        return this.f8789u;
    }

    public int m9619t() {
        return this.f8788t;
    }

    public boolean m9620u() {
        return this.f8790v;
    }

    public List<String> m9621v() {
        return this.f8780l;
    }

    public C2555g m9622w() {
        return this.f8787s;
    }

    public String m9623x() {
        String str = BuildConfig.FLAVOR;
        int i = 0;
        while (i < this.f8780l.size()) {
            String str2 = (String) this.f8780l.get(i);
            if (str.length() >= str2.length()) {
                str2 = str;
            }
            i++;
            str = str2;
        }
        return str;
    }
}
