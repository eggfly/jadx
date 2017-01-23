package com.antutu.benchmark.platform.p049b.p050a;

import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.antutu.benchmark.platform.b.a.k */
public class C1560k extends C1549a implements C1550m {
    private static boolean f5430f;
    private static List<C1555f> f5431g;
    private static int f5432h;
    private static int f5433i;

    static {
        f5430f = false;
        f5431g = Arrays.asList(new C1555f[]{new C1555f(-2, -1), new C1555f(-2, 1), new C1555f(-1, -2), new C1555f(-1, 2), new C1555f(1, -2), new C1555f(1, 2), new C1555f(2, -1), new C1555f(2, 1)});
        f5432h = 80;
        f5433i = 5;
    }

    public C1560k(int i, int i2, int i3) {
        super(i, i2, i3);
    }

    public int m6176a(int i, int i2) {
        int a = C1568t.m6202a(i, i2);
        return this.b == C1558i.f5422a ? ((Integer) C1557h.f5416i.get(a)).intValue() : ((Integer) C1557h.f5417j.get(a)).intValue() * -1;
    }

    public int m6177a(C1567s c1567s, int i, int i2) {
        return m6178b(c1567s, i, i2).size() * f5433i;
    }

    public List<C1561l> m6178b(C1567s c1567s, int i, int i2) {
        List<C1561l> arrayList = new ArrayList();
        C1563o b = c1567s.m6198b();
        int a = C1568t.m6202a(i, i2);
        int i3 = 0;
        while (i3 < 8) {
            int i4 = i + ((C1555f) f5431g.get(i3)).f5406a;
            int i5 = i2 + ((C1555f) f5431g.get(i3)).f5407b;
            if (C1549a.m6127c(i4, i5) && ((C1550m) b.get(Integer.valueOf(C1568t.m6202a(i + (((C1555f) f5431g.get(i3)).f5406a / 2), (((C1555f) f5431g.get(i3)).f5407b / 2) + i2)))).getClass().equals(C1556g.class)) {
                if (((C1550m) b.get(Integer.valueOf(a))).m6145c() != ((C1550m) b.get(Integer.valueOf(C1568t.m6202a(i4, i5)))).m6145c()) {
                    arrayList.add(new C1561l(i, i2, i4, i5));
                }
            }
            i3++;
        }
        return arrayList;
    }

    public int m6179f() {
        return this.b == C1558i.f5422a ? f5432h : f5432h * -1;
    }

    public String toString() {
        return this.b == C1558i.f5422a ? "N" : IXAdRequestInfo.AD_COUNT;
    }
}
