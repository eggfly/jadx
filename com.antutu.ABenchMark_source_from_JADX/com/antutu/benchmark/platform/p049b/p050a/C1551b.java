package com.antutu.benchmark.platform.p049b.p050a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.antutu.benchmark.platform.b.a.b */
public class C1551b extends C1549a implements C1550m {
    private static boolean f5392f;
    private static List<Integer> f5393g;
    private static List<C1555f> f5394h;
    private static int f5395i;
    private static int f5396j;

    static {
        f5392f = false;
        f5393g = Arrays.asList(new Integer[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
        f5394h = Arrays.asList(new C1555f[]{new C1555f(-1, -1), new C1555f(-1, 1), new C1555f(1, -1), new C1555f(1, 1)});
        f5395i = 40;
        f5396j = 2;
    }

    public C1551b(int i, int i2, int i3) {
        super(i, i2, i3);
    }

    public int m6149a(int i, int i2) {
        int a = C1568t.m6202a(i, i2);
        return this.b == C1558i.f5422a ? ((Integer) C1557h.f5412e.get(a)).intValue() : ((Integer) C1557h.f5413f.get(a)).intValue() * -1;
    }

    public int m6150a(C1567s c1567s, int i, int i2) {
        return m6151b(c1567s, i, i2).size() * f5396j;
    }

    public List<C1561l> m6151b(C1567s c1567s, int i, int i2) {
        List<C1561l> arrayList = new ArrayList();
        C1563o b = c1567s.m6198b();
        int a = C1568t.m6202a(i, i2);
        for (int i3 = 0; i3 < 4; i3++) {
            int i4 = i + ((C1555f) f5394h.get(i3)).f5406a;
            int i5 = i2 + ((C1555f) f5394h.get(i3)).f5407b;
            if (C1549a.m6127c(i4, i5)) {
                int a2 = C1568t.m6202a(i4, i5);
                int c = ((C1550m) b.get(Integer.valueOf(a))).m6145c();
                int c2 = ((C1550m) b.get(Integer.valueOf(a2))).m6145c();
                if (((Integer) f5393g.get(a2)).equals(Integer.valueOf(1)) && c != c2) {
                    arrayList.add(new C1561l(i, i2, i4, i5));
                }
            }
        }
        return arrayList;
    }

    public int m6152f() {
        return this.b == C1558i.f5422a ? f5395i : f5395i * -1;
    }

    public String toString() {
        return this.b == C1558i.f5422a ? "A" : "a";
    }
}
