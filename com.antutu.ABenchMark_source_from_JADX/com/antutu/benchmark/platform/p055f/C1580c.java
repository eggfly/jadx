package com.antutu.benchmark.platform.p055f;

import com.antutu.benchmark.platform.C1574c;

/* renamed from: com.antutu.benchmark.platform.f.c */
public class C1580c {
    private int f5493A;
    private int f5494B;
    private long f5495C;
    private long f5496D;
    private C1574c f5497E;
    private final double f5498a;
    private final double f5499b;
    private final double f5500c;
    private int f5501d;
    private int f5502e;
    private int f5503f;
    private int f5504g;
    private int f5505h;
    private int f5506i;
    private int f5507j;
    private int f5508k;
    private int f5509l;
    private int f5510m;
    private int f5511n;
    private int f5512o;
    private int f5513p;
    private int f5514q;
    private double f5515r;
    private double f5516s;
    private double f5517t;
    private double f5518u;
    private double f5519v;
    private double f5520w;
    private double[] f5521x;
    private double[] f5522y;
    private int f5523z;

    public C1580c() {
        this.f5498a = 0.499975d;
        this.f5499b = 0.50025d;
        this.f5500c = 2.0d;
        this.f5521x = new double[4];
        this.f5522y = new double[1];
        this.f5497E = new C1574c();
    }

    private void m6261a(double d, double d2, double[] dArr) {
        double d3 = (d + d2) * 0.499975d;
        dArr[0] = (d3 + ((d3 + d2) * 0.499975d)) / 2.0d;
    }

    private void m6262a(double[] dArr) {
        int i = 0;
        do {
            dArr[0] = (((dArr[0] + dArr[1]) + dArr[2]) - dArr[3]) * 0.499975d;
            dArr[1] = (((dArr[0] + dArr[1]) - dArr[2]) + dArr[3]) * 0.499975d;
            dArr[2] = (((dArr[0] - dArr[1]) + dArr[2]) + dArr[3]) * 0.499975d;
            dArr[3] = ((((-dArr[0]) + dArr[1]) + dArr[2]) + dArr[3]) / 2.0d;
            i++;
        } while (i < 6);
    }

    private void m6263c() {
        this.f5521x[this.f5502e] = this.f5521x[this.f5503f];
        this.f5521x[this.f5503f] = this.f5521x[this.f5504g];
        this.f5521x[this.f5504g] = this.f5521x[this.f5502e];
    }

    public int m6264a() {
        return this.f5494B;
    }

    public void m6265a(int i) {
        this.f5493A = i;
    }

    public double m6266b() {
        this.f5505h = this.f5493A * 0;
        this.f5506i = this.f5493A * 12;
        this.f5507j = this.f5493A * 14;
        this.f5508k = this.f5493A * 345;
        this.f5509l = this.f5493A * 210;
        this.f5510m = this.f5493A * 32;
        this.f5511n = this.f5493A * 899;
        this.f5512o = this.f5493A * 616;
        this.f5513p = this.f5493A * 0;
        this.f5514q = this.f5493A * 93;
        this.f5495C = 0;
        this.f5497E.m6234c();
        this.f5497E.m6232a();
        this.f5523z = 1;
        while (this.f5523z <= this.f5494B) {
            this.f5515r = 1.0d;
            this.f5518u = -1.0d;
            this.f5517t = -1.0d;
            this.f5516s = -1.0d;
            this.f5501d = 1;
            while (this.f5501d <= this.f5505h) {
                this.f5515r = (((this.f5515r + this.f5516s) + this.f5517t) - this.f5518u) * 0.499975d;
                this.f5516s = (((this.f5515r + this.f5516s) - this.f5517t) + this.f5518u) * 0.499975d;
                this.f5517t = (((this.f5515r - this.f5516s) + this.f5517t) + this.f5518u) * 0.499975d;
                this.f5518u = ((((-this.f5515r) + this.f5516s) + this.f5517t) + this.f5518u) * 0.499975d;
                this.f5501d++;
            }
            this.f5521x[0] = 1.0d;
            double[] dArr = this.f5521x;
            double[] dArr2 = this.f5521x;
            this.f5521x[3] = -1.0d;
            dArr2[2] = -1.0d;
            dArr[1] = -1.0d;
            this.f5501d = 1;
            while (this.f5501d <= this.f5506i) {
                this.f5521x[0] = (((this.f5521x[0] + this.f5521x[1]) + this.f5521x[2]) - this.f5521x[3]) * 0.499975d;
                this.f5521x[1] = (((this.f5521x[0] + this.f5521x[1]) - this.f5521x[2]) + this.f5521x[3]) * 0.499975d;
                this.f5521x[2] = (((this.f5521x[0] - this.f5521x[1]) + this.f5521x[2]) + this.f5521x[3]) * 0.499975d;
                this.f5521x[3] = ((((-this.f5521x[0]) + this.f5521x[1]) + this.f5521x[2]) + this.f5521x[3]) * 0.499975d;
                this.f5501d++;
            }
            this.f5501d = 1;
            while (this.f5501d <= this.f5507j) {
                m6262a(this.f5521x);
                this.f5501d++;
            }
            this.f5502e = 1;
            this.f5501d = 1;
            while (this.f5501d <= this.f5508k) {
                if (this.f5502e == 1) {
                    this.f5502e = 2;
                } else {
                    this.f5502e = 3;
                }
                if (this.f5502e > 2) {
                    this.f5502e = 0;
                } else {
                    this.f5502e = 1;
                }
                if (this.f5502e < 1) {
                    this.f5502e = 1;
                } else {
                    this.f5502e = 0;
                }
                this.f5501d++;
            }
            this.f5502e = 1;
            this.f5503f = 2;
            this.f5504g = 3;
            this.f5501d = 1;
            while (this.f5501d <= this.f5509l) {
                this.f5502e = (this.f5502e * (this.f5503f - this.f5502e)) * (this.f5504g - this.f5503f);
                this.f5503f = (this.f5504g * this.f5503f) - ((this.f5504g - this.f5502e) * this.f5503f);
                this.f5504g = (this.f5504g - this.f5503f) * (this.f5503f + this.f5502e);
                this.f5521x[this.f5504g - 2] = (double) ((this.f5502e + this.f5503f) + this.f5504g);
                this.f5521x[this.f5503f - 2] = (double) ((this.f5502e * this.f5503f) * this.f5504g);
                this.f5501d++;
            }
            this.f5520w = 0.5d;
            this.f5519v = 0.5d;
            this.f5501d = 1;
            while (this.f5501d <= this.f5510m) {
                this.f5519v = Math.atan(((2.0d * Math.sin(this.f5519v)) * Math.cos(this.f5519v)) / ((Math.cos(this.f5519v + this.f5520w) + Math.cos(this.f5519v - this.f5520w)) - 1.0d)) * 0.499975d;
                this.f5520w = Math.atan(((2.0d * Math.sin(this.f5520w)) * Math.cos(this.f5520w)) / ((Math.cos(this.f5519v + this.f5520w) + Math.cos(this.f5519v - this.f5520w)) - 1.0d)) * 0.499975d;
                this.f5501d++;
            }
            this.f5522y[0] = 1.0d;
            this.f5520w = 1.0d;
            this.f5519v = 1.0d;
            this.f5501d = 1;
            while (this.f5501d <= this.f5511n) {
                m6261a(this.f5519v, this.f5520w, this.f5522y);
                this.f5501d++;
            }
            this.f5502e = 0;
            this.f5503f = 1;
            this.f5504g = 2;
            this.f5521x[0] = 1.0d;
            this.f5521x[1] = 2.0d;
            this.f5521x[2] = 3.0d;
            this.f5501d = 1;
            while (this.f5501d <= this.f5512o) {
                m6263c();
                this.f5501d++;
            }
            this.f5502e = 2;
            this.f5503f = 3;
            this.f5501d = 1;
            while (this.f5501d <= this.f5513p) {
                this.f5502e += this.f5503f;
                this.f5503f = this.f5502e + this.f5503f;
                this.f5502e = this.f5503f - this.f5502e;
                this.f5503f = (this.f5503f - this.f5502e) - this.f5502e;
                this.f5501d++;
            }
            this.f5519v = 0.75d;
            this.f5501d = 1;
            while (this.f5501d <= this.f5514q) {
                this.f5519v = Math.sqrt(Math.exp(Math.log(this.f5519v) / 0.50025d));
                this.f5501d++;
            }
            this.f5523z++;
        }
        this.f5497E.m6233b();
        this.f5496D = this.f5497E.m6235d();
        return (double) (this.f5496D - this.f5495C);
    }

    public void m6267b(int i) {
        this.f5494B = i;
    }

    public void m6268c(int i) {
        this.f5494B += i;
    }
}
