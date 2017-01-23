package com.antutu.benchmark.platform.p049b.p050a;

import java.util.List;

/* renamed from: com.antutu.benchmark.platform.b.a.a */
public class C1549a implements Cloneable {
    int f5387a;
    int f5388b;
    int f5389c;
    int f5390d;
    int f5391e;

    public C1549a(int i, int i2, int i3) {
        this.f5387a = i;
        this.f5389c = i2;
        this.f5390d = i3;
        this.f5391e = C1568t.m6202a(i2, i3);
        m6128g();
    }

    protected static boolean m6127c(int i, int i2) {
        return i <= 8 && i >= 0 && i2 <= 9 && i2 >= 0;
    }

    private void m6128g() {
        if (this.f5387a == 0) {
            this.f5388b = C1558i.f5424c;
        } else if ((this.f5387a & C1558i.f5422a) == C1558i.f5422a) {
            this.f5388b = C1558i.f5422a;
        } else {
            this.f5388b = C1558i.f5423b;
        }
    }

    public int m6129a() {
        return this.f5391e;
    }

    public int m6130a(int i, int i2) {
        return 0;
    }

    public int m6131a(C1567s c1567s, int i, int i2) {
        return 0;
    }

    public int m6132b() {
        return this.f5387a;
    }

    public List<C1561l> m6133b(C1567s c1567s, int i, int i2) {
        return null;
    }

    public void m6134b(int i, int i2) {
        this.f5389c = i;
        this.f5390d = i2;
        this.f5391e = C1568t.m6202a(i, i2);
    }

    public int m6135c() {
        return this.f5388b;
    }

    public Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
        }
        return obj;
    }

    public int m6136d() {
        return this.f5389c;
    }

    public int m6137e() {
        return this.f5390d;
    }

    public int m6138f() {
        return 0;
    }
}
