package com.antutu.benchmark.platform.p049b.p050a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.antutu.benchmark.platform.b.a.d */
public class C1553d extends C1549a implements C1550m {
    private static boolean f5397f;
    private static List<Integer> f5398g;
    private static List<C1555f> f5399h;
    private static int f5400i;
    private static int f5401j;

    static {
        f5397f = false;
        f5398g = Arrays.asList(new Integer[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0)});
        f5399h = Arrays.asList(new C1555f[]{new C1555f(-2, -2), new C1555f(-2, 2), new C1555f(2, -2), new C1555f(2, 2)});
        f5400i = 40;
        f5401j = 2;
    }

    public C1553d(int i, int i2, int i3) {
        super(i, i2, i3);
    }

    public int m6158a(int i, int i2) {
        int a = C1568t.m6202a(i, i2);
        return this.b == C1558i.f5422a ? ((Integer) C1557h.f5414g.get(a)).intValue() : ((Integer) C1557h.f5415h.get(a)).intValue() * -1;
    }

    public int m6159a(C1567s c1567s, int i, int i2) {
        return m6160b(c1567s, i, i2).size() * f5401j;
    }

    public List<C1561l> m6160b(C1567s c1567s, int i, int i2) {
        List<C1561l> arrayList = new ArrayList();
        C1563o b = c1567s.m6198b();
        int a = C1568t.m6202a(i, i2);
        int i3 = 0;
        while (i3 < 4) {
            int i4 = i + ((C1555f) f5399h.get(i3)).f5406a;
            int i5 = i2 + ((C1555f) f5399h.get(i3)).f5407b;
            if (C1549a.m6127c(i4, i5) && ((C1550m) b.get(Integer.valueOf(C1568t.m6202a(i + (((C1555f) f5399h.get(i3)).f5406a / 2), (((C1555f) f5399h.get(i3)).f5407b / 2) + i2)))).getClass().equals(C1556g.class)) {
                int a2 = C1568t.m6202a(i4, i5);
                int c = ((C1550m) b.get(Integer.valueOf(a))).m6145c();
                int c2 = ((C1550m) b.get(Integer.valueOf(a2))).m6145c();
                if (((Integer) f5398g.get(a2)).equals(Integer.valueOf(1)) && c != c2) {
                    arrayList.add(new C1561l(i, i2, i4, i5));
                }
            }
            i3++;
        }
        return arrayList;
    }

    public int m6161f() {
        return this.b == C1558i.f5422a ? f5400i : f5400i * -1;
    }

    public String toString() {
        return this.b == C1558i.f5422a ? "B" : "b";
    }
}
