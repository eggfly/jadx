package com.igexin.p158b.p159a.p161b.p162a.p163a;

import java.util.Comparator;

/* renamed from: com.igexin.b.a.b.a.a.h */
class C3675h implements Comparator {
    final /* synthetic */ C3671d f12389a;

    C3675h(C3671d c3671d) {
        this.f12389a = c3671d;
    }

    public int m15024a(C3678k c3678k, C3678k c3678k2) {
        return c3678k == null ? 1 : c3678k2 == null ? -1 : ((long) c3678k.y) + c3678k.w <= ((long) c3678k2.y) + c3678k2.w ? ((long) c3678k.y) + c3678k.w < ((long) c3678k2.y) + c3678k2.w ? -1 : 0 : 1;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m15024a((C3678k) obj, (C3678k) obj2);
    }
}
