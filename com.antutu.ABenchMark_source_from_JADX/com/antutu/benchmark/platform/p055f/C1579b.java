package com.antutu.benchmark.platform.p055f;

import com.antutu.benchmark.platform.C1574c;
import java.util.Random;

/* renamed from: com.antutu.benchmark.platform.f.b */
public class C1579b {
    private final int f5485a;
    private double f5486b;
    private double f5487c;
    private double f5488d;
    private double f5489e;
    private double f5490f;
    private boolean f5491g;
    private C1574c f5492h;

    public C1579b() {
        this.f5485a = 640;
        this.f5486b = 0.0d;
        this.f5487c = 0.0d;
        this.f5488d = 0.0d;
        this.f5489e = 0.0d;
        this.f5490f = 0.0d;
        this.f5491g = false;
        this.f5492h = new C1574c();
    }

    private double m6249a(int i, double[] dArr, int i2, int i3, double[] dArr2, int i4, int i5) {
        if (i <= 0) {
            return 0.0d;
        }
        double d;
        int i6;
        if (i3 == 1 && i5 == 1) {
            d = 0.0d;
            i6 = 0;
            while (i6 < i) {
                double d2 = (dArr[i6 + i2] * dArr2[i6 + i4]) + d;
                i6++;
                d = d2;
            }
            return d;
        }
        int i7 = 0;
        int i8 = 0;
        if (i3 < 0) {
            i7 = ((-i) + 1) * i3;
        }
        if (i5 < 0) {
            i8 = ((-i) + 1) * i5;
        }
        int i9 = 0;
        int i10 = i8;
        d = 0.0d;
        i6 = i10;
        int i11 = i7;
        while (i9 < i) {
            double d3 = (dArr[i11 + i2] * dArr2[i6 + i4]) + d;
            i11 += i3;
            i9++;
            i6 += i5;
            d = d3;
        }
        return d;
    }

    private double m6250a(double[][] dArr, int i, int i2, double[] dArr2) {
        int i3;
        double d = 0.0d;
        Random random = new Random((long) 1325);
        int i4 = 0;
        while (i4 < i2) {
            double d2 = d;
            for (int i5 = 0; i5 < i2; i5++) {
                dArr[i5][i4] = random.nextDouble() - 0.5d;
                if (dArr[i5][i4] > d2) {
                    d2 = dArr[i5][i4];
                }
            }
            i4++;
            d = d2;
        }
        for (i3 = 0; i3 < i2; i3++) {
            dArr2[i3] = 0.0d;
        }
        for (int i6 = 0; i6 < i2; i6++) {
            for (i3 = 0; i3 < i2; i3++) {
                dArr2[i3] = dArr2[i3] + dArr[i6][i3];
            }
        }
        return d;
    }

    private int m6251a(int i, double[] dArr, int i2, int i3) {
        if (i < 1) {
            return -1;
        }
        if (i == 1) {
            return 0;
        }
        double d;
        int i4;
        int i5;
        double d2;
        if (i3 != 1) {
            int i6 = i3 + 1;
            d = dArr[i2] < 0.0d ? -dArr[i2] : dArr[i2];
            i4 = 0;
            i5 = 0;
            while (i4 < i) {
                d2 = dArr[i6 + i2] < 0.0d ? -dArr[i6 + i2] : dArr[i6 + i2];
                if (d2 > d) {
                    i5 = i4;
                } else {
                    d2 = d;
                }
                i4++;
                i6 += i3;
                d = d2;
            }
            return i5;
        }
        d = dArr[i2] < 0.0d ? -dArr[i2] : dArr[i2];
        i4 = 0;
        i5 = 0;
        while (i4 < i) {
            d2 = dArr[i4 + i2] < 0.0d ? -dArr[i4 + i2] : dArr[i4 + i2];
            if (d2 > d) {
                i5 = i4;
            } else {
                d2 = d;
            }
            i4++;
            d = d2;
        }
        return i5;
    }

    private int m6252a(double[][] dArr, int i, int i2, int[] iArr) {
        int i3 = 0;
        int i4 = i2 - 1;
        if (i4 >= 0) {
            int i5 = 0;
            while (i5 < i4) {
                if (this.f5491g) {
                    return 0;
                }
                int i6;
                double[] dArr2 = dArr[i5];
                int i7 = i5 + 1;
                int a = m6251a(i2 - i5, dArr2, i5, 1) + i5;
                iArr[i5] = a;
                if (dArr2[a] != 0.0d) {
                    if (a != i5) {
                        double d = dArr2[a];
                        dArr2[a] = dArr2[i5];
                        dArr2[i5] = d;
                    }
                    m6253a(i2 - i7, -1.0d / dArr2[i5], dArr2, i7, 1);
                    for (int i8 = i7; i8 < i2; i8++) {
                        double[] dArr3 = dArr[i8];
                        double d2 = dArr3[a];
                        if (a != i5) {
                            dArr3[a] = dArr3[i5];
                            dArr3[i5] = d2;
                        }
                        m6254a(i2 - i7, d2, dArr2, i7, 1, dArr3, i7, 1);
                    }
                    i6 = i3;
                } else {
                    i6 = i5;
                }
                i5++;
                i3 = i6;
            }
        }
        iArr[i2 - 1] = i2 - 1;
        return dArr[i2 + -1][i2 + -1] == 0.0d ? i2 - 1 : i3;
    }

    private void m6253a(int i, double d, double[] dArr, int i2, int i3) {
        int i4 = 0;
        if (i <= 0) {
            return;
        }
        int i5;
        if (i3 != 1) {
            i5 = i * i3;
            while (i4 < i5) {
                int i6 = i4 + i2;
                dArr[i6] = dArr[i6] * d;
                i4 += i3;
            }
            return;
        }
        while (i4 < i) {
            i5 = i4 + i2;
            dArr[i5] = dArr[i5] * d;
            i4++;
        }
    }

    private void m6254a(int i, double d, double[] dArr, int i2, int i3, double[] dArr2, int i4, int i5) {
        if (i > 0 && d != 0.0d) {
            int i6;
            int i7;
            if (i3 == 1 && i5 == 1) {
                for (i6 = 0; i6 < i; i6++) {
                    i7 = i6 + i4;
                    dArr2[i7] = dArr2[i7] + (dArr[i6 + i2] * d);
                }
                return;
            }
            i7 = 0;
            i6 = 0;
            if (i3 < 0) {
                i7 = ((-i) + 1) * i3;
            }
            if (i5 < 0) {
                i6 = ((-i) + 1) * i5;
            }
            for (int i8 = 0; i8 < i; i8++) {
                int i9 = i6 + i4;
                dArr2[i9] = dArr2[i9] + (dArr[i7 + i2] * d);
                i7 += i3;
                i6 += i5;
            }
        }
    }

    private void m6255a(int i, double[] dArr, int i2, int i3, double[] dArr2, double[][] dArr3) {
        for (int i4 = 0; i4 < i2; i4++) {
            for (int i5 = 0; i5 < i; i5++) {
                dArr[i5] = dArr[i5] + (dArr2[i4] * dArr3[i4][i5]);
            }
        }
    }

    private void m6256a(double[][] dArr, int i, int i2, int[] iArr, double[] dArr2, int i3) {
        int i4 = i2 - 1;
        int i5;
        double d;
        if (i3 == 0) {
            int i6;
            if (i4 >= 1) {
                for (i6 = 0; i6 < i4; i6++) {
                    i5 = iArr[i6];
                    d = dArr2[i5];
                    if (i5 != i6) {
                        dArr2[i5] = dArr2[i6];
                        dArr2[i6] = d;
                    }
                    int i7 = i6 + 1;
                    m6254a(i2 - i7, d, dArr[i6], i7, 1, dArr2, i7, 1);
                }
            }
            for (i6 = 0; i6 < i2; i6++) {
                int i8 = i2 - (i6 + 1);
                dArr2[i8] = dArr2[i8] / dArr[i8][i8];
                m6254a(i8, -dArr2[i8], dArr[i8], 0, 1, dArr2, 0, 1);
            }
            return;
        }
        for (i8 = 0; i8 < i2; i8++) {
            dArr2[i8] = (dArr2[i8] - m6249a(i8, dArr[i8], 0, 1, dArr2, 0, 1)) / dArr[i8][i8];
        }
        if (i4 >= 1) {
            for (int i9 = 0; i9 < i4; i9++) {
                int i10 = i2 - (i9 + 1);
                int i11 = i10 + 1;
                dArr2[i10] = m6249a(i2 - i11, dArr[i10], i11, 1, dArr2, i11, 1) + dArr2[i10];
                i5 = iArr[i10];
                if (i5 != i10) {
                    d = dArr2[i5];
                    dArr2[i5] = dArr2[i10];
                    dArr2[i10] = d;
                }
            }
        }
    }

    private double m6257b(double d) {
        double d2 = 0.0d;
        while (d2 == 0.0d) {
            d2 = 1.3333333333333333d - 1.0d;
            d2 = m6259a((d2 + (d2 + d2)) - 1.0d);
        }
        return d2 * m6259a(d);
    }

    public double m6258a() {
        return this.f5487c;
    }

    double m6259a(double d) {
        return d >= 0.0d ? d : -d;
    }

    public void m6260b() {
        int i;
        double[][] dArr = new double[640][];
        double[] dArr2 = new double[640];
        double[] dArr3 = new double[640];
        int[] iArr = new int[640];
        for (i = 0; i < 640; i++) {
            dArr[i] = new double[641];
        }
        double d = ((2.0d * ((((double) 640) * ((double) 640)) * ((double) 640))) / 3.0d) + (2.0d * ((double) 409600));
        m6250a(dArr, 641, 640, dArr2);
        this.f5492h.m6234c();
        this.f5492h.m6232a();
        i = (m6252a(dArr, 641, 640, iArr) + 1) - 1;
        if (this.f5491g) {
            this.f5492h.m6233b();
            return;
        }
        m6256a(dArr, 641, 640, iArr, dArr2, 0);
        this.f5492h.m6233b();
        this.f5490f = ((double) this.f5492h.m6235d()) / 1000.0d;
        for (i = 0; i < 640; i++) {
            dArr3[i] = dArr2[i];
        }
        double a = m6250a(dArr, 641, 640, dArr2);
        for (i = 0; i < 640; i++) {
            dArr2[i] = -dArr2[i];
        }
        m6255a(640, dArr2, 640, 641, dArr3, dArr);
        double d2 = 0.0d;
        double d3 = 0.0d;
        for (int i2 = 0; i2 < 640; i2++) {
            if (d2 <= m6259a(dArr2[i2])) {
                d2 = m6259a(dArr2[i2]);
            }
            if (d3 <= m6259a(dArr3[i2])) {
                d3 = m6259a(dArr3[i2]);
            }
        }
        this.f5486b = m6257b(1.0d);
        this.f5488d = d2 / (((((double) 640) * a) * d3) * this.f5486b);
        this.f5488d += 0.005d;
        this.f5488d = (double) ((int) (this.f5488d * 100.0d));
        this.f5488d /= 100.0d;
        this.f5489e = this.f5490f;
        this.f5489e += 0.005d;
        this.f5489e = (double) ((int) (this.f5489e * 100.0d));
        this.f5489e /= 100.0d;
        this.f5487c = d / (1000000.0d * this.f5490f);
        this.f5487c += 5.0E-4d;
        this.f5487c = (double) ((int) (this.f5487c * 1000.0d));
        this.f5487c /= 1000.0d;
    }
}
