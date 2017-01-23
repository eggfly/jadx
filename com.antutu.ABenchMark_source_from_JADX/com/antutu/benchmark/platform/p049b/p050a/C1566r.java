package com.antutu.benchmark.platform.p049b.p050a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.antutu.benchmark.platform.b.a.r */
public class C1566r extends C1549a implements C1550m {
    private static boolean f5445f;
    private static List<C1555f> f5446g;
    private static int f5447h;
    private static int f5448i;

    static {
        f5445f = false;
        f5446g = Arrays.asList(new C1555f[]{new C1555f(-1, 0), new C1555f(1, 0), new C1555f(0, -1), new C1555f(0, 1)});
        f5447h = 180;
        f5448i = 4;
    }

    public C1566r(int i, int i2, int i3) {
        super(i, i2, i3);
    }

    public int m6188a(int i, int i2) {
        int a = C1568t.m6202a(i, i2);
        return this.b == C1558i.f5422a ? ((Integer) C1557h.f5410c.get(a)).intValue() : ((Integer) C1557h.f5411d.get(a)).intValue() * -1;
    }

    public int m6189a(C1567s c1567s, int i, int i2) {
        return m6190b(c1567s, i, i2).size() * f5448i;
    }

    public List<C1561l> m6190b(C1567s c1567s, int i, int i2) {
        List<C1561l> arrayList = new ArrayList();
        C1563o b = c1567s.m6198b();
        int a = C1568t.m6202a(i, i2);
        for (int i3 = 0; i3 < 4; i3++) {
            for (int i4 = 1; i4 <= 10; i4++) {
                int i5 = i + (((C1555f) f5446g.get(i3)).f5406a * i4);
                int i6 = i2 + (((C1555f) f5446g.get(i3)).f5407b * i4);
                int a2 = C1568t.m6202a(i5, i6);
                if (!C1549a.m6127c(i5, i6)) {
                    break;
                }
                int c = ((C1550m) b.get(Integer.valueOf(a))).m6145c();
                int c2 = ((C1550m) b.get(Integer.valueOf(a2))).m6145c();
                if (c == c2) {
                    break;
                }
                arrayList.add(new C1561l(i, i2, i5, i6));
                if (c2 != C1558i.f5424c) {
                    break;
                }
            }
        }
        return arrayList;
    }

    public int m6191f() {
        return this.b == C1558i.f5422a ? f5447h : f5447h * -1;
    }

    public String toString() {
        return this.b == C1558i.f5422a ? "R" : "r";
    }
}
