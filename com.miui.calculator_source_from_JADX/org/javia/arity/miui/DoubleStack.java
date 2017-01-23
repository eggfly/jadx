package org.javia.arity.miui;

class DoubleStack {
    private double[] f4923a;
    private double[] f4924b;
    private int f4925c;

    DoubleStack() {
        this.f4923a = new double[8];
        this.f4924b = new double[8];
        this.f4925c = 0;
    }

    void m6716a() {
        this.f4925c = 0;
    }

    void m6717a(double d, double d2) {
        if (this.f4925c >= this.f4923a.length) {
            int length = this.f4923a.length << 1;
            Object obj = new double[length];
            Object obj2 = new double[length];
            System.arraycopy(this.f4923a, 0, obj, 0, this.f4923a.length);
            System.arraycopy(this.f4924b, 0, obj2, 0, this.f4923a.length);
            this.f4923a = obj;
            this.f4924b = obj2;
        }
        this.f4923a[this.f4925c] = d;
        this.f4924b[this.f4925c] = d2;
        this.f4925c++;
    }

    void m6718b() {
        this.f4925c--;
    }

    double[] m6719c() {
        Object obj = new double[this.f4925c];
        System.arraycopy(this.f4923a, 0, obj, 0, this.f4925c);
        return obj;
    }

    double[] m6720d() {
        int i;
        for (i = 0; i < this.f4925c; i++) {
            if (this.f4924b[i] != 0.0d) {
                i = 0;
                break;
            }
        }
        i = 1;
        if (i != 0) {
            return null;
        }
        double[] dArr = new double[this.f4925c];
        System.arraycopy(this.f4924b, 0, dArr, 0, this.f4925c);
        return dArr;
    }
}
