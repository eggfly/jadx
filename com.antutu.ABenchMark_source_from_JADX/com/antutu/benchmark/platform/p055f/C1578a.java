package com.antutu.benchmark.platform.p055f;

import com.antutu.benchmark.platform.C1574c;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.antutu.benchmark.platform.f.a */
public class C1578a {
    private double f5480a;
    private int f5481b;
    private long f5482c;
    private boolean f5483d;
    private C1574c f5484e;

    public C1578a() {
        this.f5480a = 0.0d;
        this.f5481b = SpdyProtocol.SLIGHTSSL_0_RTT_MODE;
        this.f5482c = 0;
        this.f5483d = false;
        this.f5484e = new C1574c();
    }

    private void m6246a(int i) {
        int[] iArr = new int[8193];
        this.f5484e.m6234c();
        this.f5484e.m6232a();
        while (true) {
            int i2 = i - 1;
            if (i == 0) {
                this.f5482c = this.f5484e.m6235d();
                this.f5480a = (((double) this.f5481b) * 10000.0d) / ((double) this.f5482c);
                return;
            } else if (!this.f5483d) {
                int i3;
                for (i3 = 0; i3 < 8193; i3++) {
                    iArr[i3] = 1;
                }
                for (int i4 = 2; i4 < 8193; i4++) {
                    if (iArr[i4] != 0) {
                        int i5 = i4 - 0;
                        for (i3 = i4 + i5; i3 < 8193; i3 += i5) {
                            iArr[i3] = 0;
                        }
                    }
                }
                i = i2;
            } else {
                return;
            }
        }
    }

    public double m6247a() {
        return this.f5480a;
    }

    public void m6248b() {
        m6246a(this.f5481b);
    }
}
