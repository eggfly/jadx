package p000a.p001a.p004e;

import cn.sharesdk.framework.Platform;
import java.util.Arrays;
import org.android.spdy.SpdyProtocol;

/* renamed from: a.a.e.n */
public final class C0083n {
    private int f327a;
    private final int[] f328b;

    public C0083n() {
        this.f328b = new int[10];
    }

    C0083n m363a(int i, int i2) {
        if (i < this.f328b.length) {
            this.f327a = (1 << i) | this.f327a;
            this.f328b[i] = i2;
        }
        return this;
    }

    void m364a() {
        this.f327a = 0;
        Arrays.fill(this.f328b, 0);
    }

    void m365a(C0083n c0083n) {
        for (int i = 0; i < 10; i++) {
            if (c0083n.m366a(i)) {
                m363a(i, c0083n.m368b(i));
            }
        }
    }

    boolean m366a(int i) {
        return ((1 << i) & this.f327a) != 0;
    }

    int m367b() {
        return Integer.bitCount(this.f327a);
    }

    int m368b(int i) {
        return this.f328b[i];
    }

    int m369c() {
        return (2 & this.f327a) != 0 ? this.f328b[1] : -1;
    }

    int m370c(int i) {
        return (16 & this.f327a) != 0 ? this.f328b[4] : i;
    }

    int m371d() {
        return (SpdyProtocol.SLIGHTSSLV2 & this.f327a) != 0 ? this.f328b[7] : Platform.CUSTOMER_ACTION_MASK;
    }

    int m372d(int i) {
        return (32 & this.f327a) != 0 ? this.f328b[5] : i;
    }
}
