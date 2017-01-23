package com.github.mikephil.charting.p137b;

/* renamed from: com.github.mikephil.charting.b.a */
public abstract class C2523a<T> {
    protected int f8691a;
    public final float[] f8692b;
    protected float f8693c;
    protected float f8694d;
    protected int f8695e;
    protected int f8696f;

    public C2523a(int i) {
        this.f8691a = 0;
        this.f8693c = 1.0f;
        this.f8694d = 1.0f;
        this.f8695e = 0;
        this.f8696f = 0;
        this.f8691a = 0;
        this.f8692b = new float[i];
    }

    public void m9543a() {
        this.f8691a = 0;
    }

    public void m9544a(float f, float f2) {
        this.f8693c = f;
        this.f8694d = f2;
    }

    public void m9545a(int i) {
        if (i < 0) {
            i = 0;
        }
        this.f8695e = i;
    }

    public int m9546b() {
        return this.f8692b.length;
    }

    public void m9547b(int i) {
        if (i < 0) {
            i = 0;
        }
        this.f8696f = i;
    }
}
