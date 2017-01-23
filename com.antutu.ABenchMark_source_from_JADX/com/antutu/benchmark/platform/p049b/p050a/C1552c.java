package com.antutu.benchmark.platform.p049b.p050a;

import android.support.v7.widget.LinearLayoutManager;

/* renamed from: com.antutu.benchmark.platform.b.a.c */
public class C1552c {
    private static int m6153a(int i) {
        return i == C1558i.f5423b ? C1558i.f5422a : C1558i.f5423b;
    }

    public static C1567s m6154a(C1567s c1567s, int i) {
        return C1552c.m6155a(c1567s, i, C1558i.f5423b, LinearLayoutManager.INVALID_OFFSET, Integer.MAX_VALUE);
    }

    private static C1567s m6155a(C1567s c1567s, int i, int i2, int i3, int i4) {
        if (i <= 0) {
            c1567s.m6200c();
            return c1567s;
        }
        C1567s c1567s2 = new C1567s();
        c1567s2.m6197a(i4);
        C1567s c1567s3 = c1567s2;
        for (C1561l a : c1567s.m6199b(i2)) {
            c1567s2 = C1564p.m6182a(c1567s, a);
            int d = C1552c.m6157b(c1567s2, i - 1, C1552c.m6153a(i2), i3, i4).m6201d();
            if (d < i4) {
                c1567s2.m6197a(d);
                i4 = d;
            } else {
                c1567s2 = c1567s3;
            }
            if (i4 <= i3) {
                return c1567s2;
            }
            c1567s3 = c1567s2;
        }
        return c1567s3;
    }

    public static C1567s m6156b(C1567s c1567s, int i) {
        return C1552c.m6155a(c1567s, i, C1558i.f5422a, LinearLayoutManager.INVALID_OFFSET, Integer.MAX_VALUE);
    }

    private static C1567s m6157b(C1567s c1567s, int i, int i2, int i3, int i4) {
        if (i <= 0) {
            c1567s.m6200c();
            return c1567s;
        }
        C1567s c1567s2 = new C1567s();
        c1567s2.m6197a(i3);
        C1567s c1567s3 = c1567s2;
        for (C1561l a : c1567s.m6199b(i2)) {
            c1567s2 = C1564p.m6182a(c1567s, a);
            int d = C1552c.m6155a(c1567s2, i - 1, C1552c.m6153a(i2), i3, i4).m6201d();
            if (d > i3) {
                c1567s2.m6197a(d);
                i3 = d;
            } else {
                c1567s2 = c1567s3;
            }
            if (i4 <= i3) {
                return c1567s2;
            }
            c1567s3 = c1567s2;
        }
        return c1567s3;
    }
}
