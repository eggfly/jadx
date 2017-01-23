package com.antutu.benchmark.platform.p049b.p050a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.antutu.benchmark.platform.b.a.e */
public class C1554e extends C1549a implements C1550m {
    private static boolean f5402f;
    private static List<C1555f> f5403g;
    private static int f5404h;
    private static int f5405i;

    static {
        f5402f = false;
        f5403g = Arrays.asList(new C1555f[]{new C1555f(-1, 0), new C1555f(1, 0), new C1555f(0, -1), new C1555f(0, 1)});
        f5404h = 90;
        f5405i = 3;
    }

    public C1554e(int i, int i2, int i3) {
        super(i, i2, i3);
    }

    public int m6162a(int i, int i2) {
        int a = C1568t.m6202a(i, i2);
        return this.b == C1558i.f5422a ? ((Integer) C1557h.f5420m.get(a)).intValue() : ((Integer) C1557h.f5421n.get(a)).intValue() * -1;
    }

    public int m6163a(C1567s c1567s, int i, int i2) {
        return m6164b(c1567s, i, i2).size() * f5405i;
    }

    public List<C1561l> m6164b(C1567s c1567s, int i, int i2) {
        List<C1561l> arrayList = new ArrayList();
        C1563o b = c1567s.m6198b();
        int a = C1568t.m6202a(i, i2);
        for (int i3 = 0; i3 < 4; i3++) {
            Object obj = null;
            int i4 = 1;
            while (i4 <= 10) {
                int i5 = i + (((C1555f) f5403g.get(i3)).f5406a * i4);
                int i6 = i2 + (((C1555f) f5403g.get(i3)).f5407b * i4);
                int a2 = C1568t.m6202a(i5, i6);
                if (!C1549a.m6127c(i5, i6)) {
                    break;
                }
                Object obj2;
                int c = ((C1550m) b.get(Integer.valueOf(a))).m6145c();
                int c2 = ((C1550m) b.get(Integer.valueOf(a2))).m6145c();
                if (obj != null) {
                    if (c != c2) {
                        if (c2 != C1558i.f5424c) {
                            arrayList.add(new C1561l(i, i2, i5, i6));
                            break;
                        }
                        obj2 = obj;
                    } else {
                        break;
                    }
                } else if (c2 == C1558i.f5424c) {
                    arrayList.add(new C1561l(i, i2, i5, i6));
                    obj2 = obj;
                } else {
                    obj2 = 1;
                }
                i4++;
                obj = obj2;
            }
        }
        return arrayList;
    }

    public int m6165f() {
        return this.b == C1558i.f5422a ? f5404h : f5404h * -1;
    }

    public String toString() {
        return this.b == C1558i.f5422a ? "C" : "c";
    }
}
