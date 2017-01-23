package com.antutu.redacc.p072e;

import java.util.Comparator;

/* renamed from: com.antutu.redacc.e.e */
public class C1743e {
    private static Comparator<C1737a> f6175a;

    /* renamed from: com.antutu.redacc.e.e.1 */
    static class C17421 implements Comparator {
        C17421() {
        }

        public int compare(Object obj, Object obj2) {
            C1737a c1737a = (C1737a) obj;
            C1737a c1737a2 = (C1737a) obj2;
            return c1737a.m6717e() != c1737a2.m6717e() ? c1737a.m6717e() ? -1 : 1 : c1737a.m6718f().compareTo(c1737a2.m6718f());
        }
    }

    public static Comparator<C1737a> m6734a() {
        if (f6175a == null) {
            f6175a = new C17421();
        }
        return f6175a;
    }
}
