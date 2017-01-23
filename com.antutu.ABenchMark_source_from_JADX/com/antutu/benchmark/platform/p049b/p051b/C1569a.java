package com.antutu.benchmark.platform.p049b.p051b;

import com.antutu.benchmark.platform.p049b.p050a.C1552c;
import com.antutu.benchmark.platform.p049b.p050a.C1567s;

/* renamed from: com.antutu.benchmark.platform.b.b.a */
public class C1569a {
    C1567s f5454a;

    public double m6203a(int i, double d) {
        if (i < 1 || i > 9) {
            return 0.0d;
        }
        double nanoTime;
        double d2 = d * 1000.0d;
        double nanoTime2 = (((double) System.nanoTime()) / 1000.0d) / 1000.0d;
        int i2 = 0;
        do {
            this.f5454a = C1552c.m6154a(this.f5454a, i);
            this.f5454a = C1552c.m6156b(this.f5454a, i);
            nanoTime = ((((double) System.nanoTime()) / 1000.0d) / 1000.0d) - nanoTime2;
            i2++;
        } while (nanoTime < d2);
        return (((double) (i2 * 100)) * Math.pow(10.0d, (double) i)) / nanoTime;
    }

    public void m6204a() {
        this.f5454a = new C1567s();
    }
}
