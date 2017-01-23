package com.p063b.p064a;

import android.view.View;
import com.p063b.p076b.C1865c;
import com.p063b.p077c.p078a.C1888a;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.b.a.i */
public final class C1864i extends C1863m {
    private static final Map<String, C1865c> f6387h;
    private Object f6388i;
    private String f6389j;
    private C1865c f6390k;

    static {
        f6387h = new HashMap();
        f6387h.put("alpha", C1877j.f6393a);
        f6387h.put("pivotX", C1877j.f6394b);
        f6387h.put("pivotY", C1877j.f6395c);
        f6387h.put("translationX", C1877j.f6396d);
        f6387h.put("translationY", C1877j.f6397e);
        f6387h.put("rotation", C1877j.f6398f);
        f6387h.put("rotationX", C1877j.f6399g);
        f6387h.put("rotationY", C1877j.f6400h);
        f6387h.put("scaleX", C1877j.f6401i);
        f6387h.put("scaleY", C1877j.f6402j);
        f6387h.put("scrollX", C1877j.f6403k);
        f6387h.put("scrollY", C1877j.f6404l);
        f6387h.put("x", C1877j.f6405m);
        f6387h.put("y", C1877j.f6406n);
    }

    private C1864i(Object obj, String str) {
        this.f6388i = obj;
        m6988a(str);
    }

    public static C1864i m6983a(Object obj, String str, float... fArr) {
        C1864i c1864i = new C1864i(obj, str);
        c1864i.m6989a(fArr);
        return c1864i;
    }

    public /* synthetic */ C1847a m6984a(long j) {
        return m6990b(j);
    }

    public void m6985a() {
        super.m6971a();
    }

    void m6986a(float f) {
        super.m6972a(f);
        for (C1879k b : this.f) {
            b.m7070b(this.f6388i);
        }
    }

    public void m6987a(C1865c c1865c) {
        if (this.f != null) {
            C1879k c1879k = this.f[0];
            String c = c1879k.m7071c();
            c1879k.m7064a(c1865c);
            this.g.remove(c);
            this.g.put(this.f6389j, c1879k);
        }
        if (this.f6390k != null) {
            this.f6389j = c1865c.m6997a();
        }
        this.f6390k = c1865c;
        this.e = false;
    }

    public void m6988a(String str) {
        if (this.f != null) {
            C1879k c1879k = this.f[0];
            String c = c1879k.m7071c();
            c1879k.m7067a(str);
            this.g.remove(c);
            this.g.put(str, c1879k);
        }
        this.f6389j = str;
        this.e = false;
    }

    public void m6989a(float... fArr) {
        if (this.f != null && this.f.length != 0) {
            super.m6974a(fArr);
        } else if (this.f6390k != null) {
            m6975a(C1879k.m7056a(this.f6390k, fArr));
        } else {
            m6975a(C1879k.m7057a(this.f6389j, fArr));
        }
    }

    public C1864i m6990b(long j) {
        super.m6977c(j);
        return this;
    }

    public /* synthetic */ C1847a m6991c() {
        return m6994e();
    }

    public /* synthetic */ C1863m m6992c(long j) {
        return m6990b(j);
    }

    public /* synthetic */ Object clone() {
        return m6994e();
    }

    void m6993d() {
        if (!this.e) {
            if (this.f6390k == null && C1888a.f6427a && (this.f6388i instanceof View) && f6387h.containsKey(this.f6389j)) {
                m6987a((C1865c) f6387h.get(this.f6389j));
            }
            for (C1879k a : this.f) {
                a.m7066a(this.f6388i);
            }
            super.m6978d();
        }
    }

    public C1864i m6994e() {
        return (C1864i) super.m6981f();
    }

    public /* synthetic */ C1863m m6995f() {
        return m6994e();
    }

    public String toString() {
        String str = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.f6388i;
        if (this.f != null) {
            for (C1879k c1879k : this.f) {
                str = str + "\n    " + c1879k.toString();
            }
        }
        return str;
    }
}
