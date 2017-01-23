package android.support.v7.widget;

import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SimplePool;
import android.support.v7.widget.RecyclerView.C0517e.C0516c;
import android.support.v7.widget.RecyclerView.C0532u;

class bk {
    final ArrayMap<C0532u, C0595a> f2017a;
    final LongSparseArray<C0532u> f2018b;

    /* renamed from: android.support.v7.widget.bk.b */
    interface C0503b {
        void m1743a(C0532u c0532u);

        void m1744a(C0532u c0532u, C0516c c0516c, C0516c c0516c2);

        void m1745b(C0532u c0532u, C0516c c0516c, C0516c c0516c2);

        void m1746c(C0532u c0532u, C0516c c0516c, C0516c c0516c2);
    }

    /* renamed from: android.support.v7.widget.bk.a */
    static class C0595a {
        static Pool<C0595a> f2013d;
        int f2014a;
        C0516c f2015b;
        C0516c f2016c;

        static {
            f2013d = new SimplePool(20);
        }

        private C0595a() {
        }

        static C0595a m2569a() {
            C0595a c0595a = (C0595a) f2013d.acquire();
            return c0595a == null ? new C0595a() : c0595a;
        }

        static void m2570a(C0595a c0595a) {
            c0595a.f2014a = 0;
            c0595a.f2015b = null;
            c0595a.f2016c = null;
            f2013d.release(c0595a);
        }

        static void m2571b() {
            do {
            } while (f2013d.acquire() != null);
        }
    }

    bk() {
        this.f2017a = new ArrayMap();
        this.f2018b = new LongSparseArray();
    }

    private C0516c m2572a(C0532u c0532u, int i) {
        C0516c c0516c = null;
        int indexOfKey = this.f2017a.indexOfKey(c0532u);
        if (indexOfKey >= 0) {
            C0595a c0595a = (C0595a) this.f2017a.valueAt(indexOfKey);
            if (!(c0595a == null || (c0595a.f2014a & i) == 0)) {
                c0595a.f2014a &= i ^ -1;
                if (i == 4) {
                    c0516c = c0595a.f2015b;
                } else if (i == 8) {
                    c0516c = c0595a.f2016c;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((c0595a.f2014a & 12) == 0) {
                    this.f2017a.removeAt(indexOfKey);
                    C0595a.m2570a(c0595a);
                }
            }
        }
        return c0516c;
    }

    C0532u m2573a(long j) {
        return (C0532u) this.f2018b.get(j);
    }

    void m2574a() {
        this.f2017a.clear();
        this.f2018b.clear();
    }

    void m2575a(long j, C0532u c0532u) {
        this.f2018b.put(j, c0532u);
    }

    void m2576a(C0532u c0532u, C0516c c0516c) {
        C0595a c0595a = (C0595a) this.f2017a.get(c0532u);
        if (c0595a == null) {
            c0595a = C0595a.m2569a();
            this.f2017a.put(c0532u, c0595a);
        }
        c0595a.f2015b = c0516c;
        c0595a.f2014a |= 4;
    }

    void m2577a(C0503b c0503b) {
        for (int size = this.f2017a.size() - 1; size >= 0; size--) {
            C0532u c0532u = (C0532u) this.f2017a.keyAt(size);
            C0595a c0595a = (C0595a) this.f2017a.removeAt(size);
            if ((c0595a.f2014a & 3) == 3) {
                c0503b.m1743a(c0532u);
            } else if ((c0595a.f2014a & 1) != 0) {
                if (c0595a.f2015b == null) {
                    c0503b.m1743a(c0532u);
                } else {
                    c0503b.m1744a(c0532u, c0595a.f2015b, c0595a.f2016c);
                }
            } else if ((c0595a.f2014a & 14) == 14) {
                c0503b.m1745b(c0532u, c0595a.f2015b, c0595a.f2016c);
            } else if ((c0595a.f2014a & 12) == 12) {
                c0503b.m1746c(c0532u, c0595a.f2015b, c0595a.f2016c);
            } else if ((c0595a.f2014a & 4) != 0) {
                c0503b.m1744a(c0532u, c0595a.f2015b, null);
            } else if ((c0595a.f2014a & 8) != 0) {
                c0503b.m1745b(c0532u, c0595a.f2015b, c0595a.f2016c);
            } else if ((c0595a.f2014a & 2) != 0) {
            }
            C0595a.m2570a(c0595a);
        }
    }

    boolean m2578a(C0532u c0532u) {
        C0595a c0595a = (C0595a) this.f2017a.get(c0532u);
        return (c0595a == null || (c0595a.f2014a & 1) == 0) ? false : true;
    }

    C0516c m2579b(C0532u c0532u) {
        return m2572a(c0532u, 4);
    }

    void m2580b() {
        C0595a.m2571b();
    }

    void m2581b(C0532u c0532u, C0516c c0516c) {
        C0595a c0595a = (C0595a) this.f2017a.get(c0532u);
        if (c0595a == null) {
            c0595a = C0595a.m2569a();
            this.f2017a.put(c0532u, c0595a);
        }
        c0595a.f2014a |= 2;
        c0595a.f2015b = c0516c;
    }

    C0516c m2582c(C0532u c0532u) {
        return m2572a(c0532u, 8);
    }

    void m2583c(C0532u c0532u, C0516c c0516c) {
        C0595a c0595a = (C0595a) this.f2017a.get(c0532u);
        if (c0595a == null) {
            c0595a = C0595a.m2569a();
            this.f2017a.put(c0532u, c0595a);
        }
        c0595a.f2016c = c0516c;
        c0595a.f2014a |= 8;
    }

    boolean m2584d(C0532u c0532u) {
        C0595a c0595a = (C0595a) this.f2017a.get(c0532u);
        return (c0595a == null || (c0595a.f2014a & 4) == 0) ? false : true;
    }

    void m2585e(C0532u c0532u) {
        C0595a c0595a = (C0595a) this.f2017a.get(c0532u);
        if (c0595a == null) {
            c0595a = C0595a.m2569a();
            this.f2017a.put(c0532u, c0595a);
        }
        r0.f2014a |= 1;
    }

    void m2586f(C0532u c0532u) {
        C0595a c0595a = (C0595a) this.f2017a.get(c0532u);
        if (c0595a != null) {
            c0595a.f2014a &= -2;
        }
    }

    void m2587g(C0532u c0532u) {
        for (int size = this.f2018b.size() - 1; size >= 0; size--) {
            if (c0532u == this.f2018b.valueAt(size)) {
                this.f2018b.removeAt(size);
                break;
            }
        }
        C0595a c0595a = (C0595a) this.f2017a.remove(c0532u);
        if (c0595a != null) {
            C0595a.m2570a(c0595a);
        }
    }

    public void m2588h(C0532u c0532u) {
        m2586f(c0532u);
    }
}
