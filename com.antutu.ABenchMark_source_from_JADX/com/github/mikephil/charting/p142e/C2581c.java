package com.github.mikephil.charting.p142e;

/* renamed from: com.github.mikephil.charting.e.c */
public class C2581c {
    private int f8968a;
    private int f8969b;
    private int f8970c;
    private C2583e f8971d;

    public C2581c(int i, int i2) {
        this.f8970c = -1;
        this.f8968a = i;
        this.f8969b = i2;
    }

    public C2581c(int i, int i2, int i3) {
        this(i, i2);
        this.f8970c = i3;
    }

    public C2581c(int i, int i2, int i3, C2583e c2583e) {
        this(i, i2, i3);
        this.f8971d = c2583e;
    }

    public int m9883a() {
        return this.f8969b;
    }

    public boolean m9884a(C2581c c2581c) {
        return c2581c != null && this.f8969b == c2581c.f8969b && this.f8968a == c2581c.f8968a && this.f8970c == c2581c.f8970c;
    }

    public int m9885b() {
        return this.f8968a;
    }

    public int m9886c() {
        return this.f8970c;
    }

    public C2583e m9887d() {
        return this.f8971d;
    }

    public String toString() {
        return "Highlight, xIndex: " + this.f8968a + ", dataSetIndex: " + this.f8969b + ", stackIndex (only stacked barentry): " + this.f8970c;
    }
}
