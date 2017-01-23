package com.antutu.benchmark.platform.p049b.p050a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.antutu.benchmark.platform.b.a.j */
public class C1559j extends C1549a implements C1550m {
    private static boolean f5425f;
    private static List<C1555f> f5426g;
    private static List<Integer> f5427h;
    private static int f5428i;
    private static int f5429j;

    static {
        f5425f = false;
        f5426g = Arrays.asList(new C1555f[]{new C1555f(-1, 0), new C1555f(1, 0), new C1555f(0, -1), new C1555f(0, 1)});
        f5427h = Arrays.asList(new Integer[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
        f5428i = 10000;
        f5429j = 2;
    }

    public C1559j(int i, int i2, int i3) {
        super(i, i2, i3);
    }

    private boolean m6171a(C1567s c1567s, int i, int i2, int i3) {
        C1563o b = c1567s.m6198b();
        while (i2 <= i3) {
            if (((C1550m) b.get(Integer.valueOf(C1568t.m6202a(i, i2)))).getClass() != C1556g.class) {
                return false;
            }
            i2++;
        }
        return true;
    }

    public int m6172a(int i, int i2) {
        int a = C1568t.m6202a(i, i2);
        return this.b == C1558i.f5422a ? ((Integer) C1557h.f5408a.get(a)).intValue() : ((Integer) C1557h.f5409b.get(a)).intValue() * -1;
    }

    public int m6173a(C1567s c1567s, int i, int i2) {
        return m6174b(c1567s, i, i2).size() * f5429j;
    }

    public List<C1561l> m6174b(C1567s c1567s, int i, int i2) {
        int i3;
        List<C1561l> arrayList = new ArrayList();
        C1563o b = c1567s.m6198b();
        int a = C1568t.m6202a(i, i2);
        for (i3 = 0; i3 < 4; i3++) {
            int i4 = i + ((C1555f) f5426g.get(i3)).f5406a;
            int i5 = i2 + ((C1555f) f5426g.get(i3)).f5407b;
            if (C1549a.m6127c(i4, i5)) {
                int a2 = C1568t.m6202a(i4, i5);
                int c = ((C1550m) b.get(Integer.valueOf(a))).m6145c();
                int c2 = ((C1550m) b.get(Integer.valueOf(a2))).m6145c();
                if (((Integer) f5427h.get(a2)).equals(Integer.valueOf(1)) && c != c2) {
                    arrayList.add(new C1561l(i, i2, i4, i5));
                }
            }
        }
        if (m6135c() == C1558i.f5422a) {
            i3 = 0;
            while (i3 < 3 && ((C1550m) b.get(Integer.valueOf(C1568t.m6202a(i, i3)))).getClass() != C1559j.class) {
                i3++;
            }
            if (i3 >= 3 || !m6171a(c1567s, i, i3 + 1, i2 - 1)) {
                return arrayList;
            }
            arrayList.add(new C1561l(i, i2, i, i3));
        } else if (m6135c() == C1558i.f5423b) {
            i3 = 9;
            while (i3 > 6 && ((C1550m) b.get(Integer.valueOf(C1568t.m6202a(i, i3)))).getClass() != C1559j.class) {
                i3--;
            }
            if (i3 <= 6 || !m6171a(c1567s, i, i2 + 1, i3 - 1)) {
                return arrayList;
            }
            arrayList.add(new C1561l(i, i2, i, i3));
        }
        return arrayList;
    }

    public int m6175f() {
        return this.b == C1558i.f5422a ? f5428i : f5428i * -1;
    }

    public String toString() {
        return this.b == C1558i.f5422a ? "K" : "k";
    }
}
