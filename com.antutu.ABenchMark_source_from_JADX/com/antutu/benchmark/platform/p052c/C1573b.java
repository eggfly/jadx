package com.antutu.benchmark.platform.p052c;

import com.facebook.ads.AdError;
import java.lang.reflect.Array;

/* renamed from: com.antutu.benchmark.platform.c.b */
public class C1573b {
    private static int f5467a;
    private String[][] f5468b;

    static {
        f5467a = 50;
    }

    public C1573b() {
        this.f5468b = (String[][]) null;
    }

    private void m6229a(int[] iArr) {
        int i = iArr[0];
        this.f5468b[i][iArr[1]] = "O";
    }

    private void m6230b(int[] iArr) {
        int i = iArr[0];
        this.f5468b[i][iArr[1]] = "X";
    }

    public double m6231a() {
        try {
            C1572a.f5463c = f5467a;
            double nanoTime = (((double) System.nanoTime()) / 1000.0d) / 1000.0d;
            int i = 0;
            while (true) {
                this.f5468b = (String[][]) Array.newInstance(String.class, new int[]{f5467a, f5467a});
                m6230b(new int[]{f5467a / 2, f5467a / 2});
                do {
                    m6229a(C1572a.m6223a(this.f5468b, "O"));
                    m6230b(C1572a.m6223a(this.f5468b, "X"));
                    if (C1572a.m6224b(this.f5468b, "X")) {
                        break;
                    }
                } while (!C1572a.m6224b(this.f5468b, "O"));
                double nanoTime2 = ((((double) System.nanoTime()) / 1000.0d) / 1000.0d) - nanoTime;
                int i2 = i + 1;
                if (nanoTime2 >= 5000.0d) {
                    return ((double) (i2 * AdError.NETWORK_ERROR_CODE)) / nanoTime2;
                }
                i = i2;
            }
        } catch (Exception e) {
            return 0.0d;
        }
    }
}
