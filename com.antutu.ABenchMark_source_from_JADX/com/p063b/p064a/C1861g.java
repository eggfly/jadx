package com.p063b.p064a;

import android.view.animation.Interpolator;

/* renamed from: com.b.a.g */
public abstract class C1861g implements Cloneable {
    float f6353a;
    Class f6354b;
    boolean f6355c;
    private Interpolator f6356d;

    /* renamed from: com.b.a.g.a */
    static class C1862a extends C1861g {
        float f6357d;

        C1862a(float f) {
            this.a = f;
            this.b = Float.TYPE;
        }

        C1862a(float f, float f2) {
            this.a = f;
            this.f6357d = f2;
            this.b = Float.TYPE;
            this.c = true;
        }

        public void m6949a(Object obj) {
            if (obj != null && obj.getClass() == Float.class) {
                this.f6357d = ((Float) obj).floatValue();
                this.c = true;
            }
        }

        public Object m6950b() {
            return Float.valueOf(this.f6357d);
        }

        public /* synthetic */ Object clone() {
            return m6953g();
        }

        public /* synthetic */ C1861g m6951e() {
            return m6953g();
        }

        public float m6952f() {
            return this.f6357d;
        }

        public C1862a m6953g() {
            C1862a c1862a = new C1862a(m6946c(), this.f6357d);
            c1862a.m6942a(m6947d());
            return c1862a;
        }
    }

    public C1861g() {
        this.f6356d = null;
        this.f6355c = false;
    }

    public static C1861g m6940a(float f) {
        return new C1862a(f);
    }

    public static C1861g m6941a(float f, float f2) {
        return new C1862a(f, f2);
    }

    public void m6942a(Interpolator interpolator) {
        this.f6356d = interpolator;
    }

    public abstract void m6943a(Object obj);

    public boolean m6944a() {
        return this.f6355c;
    }

    public abstract Object m6945b();

    public float m6946c() {
        return this.f6353a;
    }

    public /* synthetic */ Object clone() {
        return m6948e();
    }

    public Interpolator m6947d() {
        return this.f6356d;
    }

    public abstract C1861g m6948e();
}
