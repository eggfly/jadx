package com.antutu.benchmark.platform.p049b.p050a;

/* renamed from: com.antutu.benchmark.platform.b.a.p */
public class C1564p {
    public static C1567s m6181a(C1567s c1567s, int i, int i2, int i3, int i4) {
        try {
            C1567s c1567s2 = (C1567s) c1567s.clone();
            try {
                C1563o b = c1567s2.m6198b();
                int a = C1568t.m6202a(i, i2);
                int a2 = C1568t.m6202a(i3, i4);
                C1550m c1550m = (C1550m) ((C1550m) b.get(Integer.valueOf(a))).clone();
                b.remove(Integer.valueOf(c1550m.m6139a()));
                c1550m.m6144b(i3, i4);
                b.put(Integer.valueOf(a2), c1550m);
                return c1567s2;
            } catch (CloneNotSupportedException e) {
                return c1567s2;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public static C1567s m6182a(C1567s c1567s, C1561l c1561l) {
        return C1564p.m6181a(c1567s, c1561l.f5434a, c1561l.f5435b, c1561l.f5436c, c1561l.f5437d);
    }
}
