package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.C0532u;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

class ag {
    final C0505b f1767a;
    final C0559a f1768b;
    final List<View> f1769c;

    /* renamed from: android.support.v7.widget.ag.b */
    interface C0505b {
        int m1751a();

        int m1752a(View view);

        void m1753a(int i);

        void m1754a(View view, int i);

        void m1755a(View view, int i, LayoutParams layoutParams);

        C0532u m1756b(View view);

        View m1757b(int i);

        void m1758b();

        void m1759c(int i);

        void m1760c(View view);

        void m1761d(View view);
    }

    /* renamed from: android.support.v7.widget.ag.a */
    static class C0559a {
        long f1765a;
        C0559a f1766b;

        C0559a() {
            this.f1765a = 0;
        }

        private void m2205b() {
            if (this.f1766b == null) {
                this.f1766b = new C0559a();
            }
        }

        void m2206a() {
            this.f1765a = 0;
            if (this.f1766b != null) {
                this.f1766b.m2206a();
            }
        }

        void m2207a(int i) {
            if (i >= 64) {
                m2205b();
                this.f1766b.m2207a(i - 64);
                return;
            }
            this.f1765a |= 1 << i;
        }

        void m2208a(int i, boolean z) {
            if (i >= 64) {
                m2205b();
                this.f1766b.m2208a(i - 64, z);
                return;
            }
            boolean z2 = (this.f1765a & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            this.f1765a = (((j ^ -1) & this.f1765a) << 1) | (this.f1765a & j);
            if (z) {
                m2207a(i);
            } else {
                m2209b(i);
            }
            if (z2 || this.f1766b != null) {
                m2205b();
                this.f1766b.m2208a(0, z2);
            }
        }

        void m2209b(int i) {
            if (i < 64) {
                this.f1765a &= (1 << i) ^ -1;
            } else if (this.f1766b != null) {
                this.f1766b.m2209b(i - 64);
            }
        }

        boolean m2210c(int i) {
            if (i < 64) {
                return (this.f1765a & (1 << i)) != 0;
            } else {
                m2205b();
                return this.f1766b.m2210c(i - 64);
            }
        }

        boolean m2211d(int i) {
            if (i >= 64) {
                m2205b();
                return this.f1766b.m2211d(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.f1765a & j) != 0;
            this.f1765a &= j ^ -1;
            j--;
            this.f1765a = Long.rotateRight((j ^ -1) & this.f1765a, 1) | (this.f1765a & j);
            if (this.f1766b == null) {
                return z;
            }
            if (this.f1766b.m2210c(0)) {
                m2207a(63);
            }
            this.f1766b.m2211d(0);
            return z;
        }

        int m2212e(int i) {
            return this.f1766b == null ? i >= 64 ? Long.bitCount(this.f1765a) : Long.bitCount(this.f1765a & ((1 << i) - 1)) : i < 64 ? Long.bitCount(this.f1765a & ((1 << i) - 1)) : this.f1766b.m2212e(i - 64) + Long.bitCount(this.f1765a);
        }

        public String toString() {
            return this.f1766b == null ? Long.toBinaryString(this.f1765a) : this.f1766b.toString() + "xx" + Long.toBinaryString(this.f1765a);
        }
    }

    ag(C0505b c0505b) {
        this.f1767a = c0505b;
        this.f1768b = new C0559a();
        this.f1769c = new ArrayList();
    }

    private int m2213e(int i) {
        if (i < 0) {
            return -1;
        }
        int a = this.f1767a.m1751a();
        int i2 = i;
        while (i2 < a) {
            int e = i - (i2 - this.f1768b.m2212e(i2));
            if (e == 0) {
                while (this.f1768b.m2210c(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += e;
        }
        return -1;
    }

    private void m2214g(View view) {
        this.f1769c.add(view);
        this.f1767a.m1760c(view);
    }

    private boolean m2215h(View view) {
        if (!this.f1769c.remove(view)) {
            return false;
        }
        this.f1767a.m1761d(view);
        return true;
    }

    View m2216a(int i, int i2) {
        int size = this.f1769c.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = (View) this.f1769c.get(i3);
            C0532u b = this.f1767a.m1756b(view);
            if (b.getLayoutPosition() == i && !b.isInvalid() && !b.isRemoved() && (i2 == -1 || b.getItemViewType() == i2)) {
                return view;
            }
        }
        return null;
    }

    void m2217a() {
        this.f1768b.m2206a();
        for (int size = this.f1769c.size() - 1; size >= 0; size--) {
            this.f1767a.m1761d((View) this.f1769c.get(size));
            this.f1769c.remove(size);
        }
        this.f1767a.m1758b();
    }

    void m2218a(int i) {
        int e = m2213e(i);
        View b = this.f1767a.m1757b(e);
        if (b != null) {
            if (this.f1768b.m2211d(e)) {
                m2215h(b);
            }
            this.f1767a.m1753a(e);
        }
    }

    void m2219a(View view) {
        int a = this.f1767a.m1752a(view);
        if (a >= 0) {
            if (this.f1768b.m2211d(a)) {
                m2215h(view);
            }
            this.f1767a.m1753a(a);
        }
    }

    void m2220a(View view, int i, LayoutParams layoutParams, boolean z) {
        int a = i < 0 ? this.f1767a.m1751a() : m2213e(i);
        this.f1768b.m2208a(a, z);
        if (z) {
            m2214g(view);
        }
        this.f1767a.m1755a(view, a, layoutParams);
    }

    void m2221a(View view, int i, boolean z) {
        int a = i < 0 ? this.f1767a.m1751a() : m2213e(i);
        this.f1768b.m2208a(a, z);
        if (z) {
            m2214g(view);
        }
        this.f1767a.m1754a(view, a);
    }

    void m2222a(View view, boolean z) {
        m2221a(view, -1, z);
    }

    int m2223b() {
        return this.f1767a.m1751a() - this.f1769c.size();
    }

    int m2224b(View view) {
        int a = this.f1767a.m1752a(view);
        return (a == -1 || this.f1768b.m2210c(a)) ? -1 : a - this.f1768b.m2212e(a);
    }

    View m2225b(int i) {
        return this.f1767a.m1757b(m2213e(i));
    }

    int m2226c() {
        return this.f1767a.m1751a();
    }

    View m2227c(int i) {
        return this.f1767a.m1757b(i);
    }

    boolean m2228c(View view) {
        return this.f1769c.contains(view);
    }

    void m2229d(int i) {
        int e = m2213e(i);
        this.f1768b.m2211d(e);
        this.f1767a.m1759c(e);
    }

    void m2230d(View view) {
        int a = this.f1767a.m1752a(view);
        if (a < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        this.f1768b.m2207a(a);
        m2214g(view);
    }

    void m2231e(View view) {
        int a = this.f1767a.m1752a(view);
        if (a < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        } else if (this.f1768b.m2210c(a)) {
            this.f1768b.m2209b(a);
            m2215h(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    boolean m2232f(View view) {
        int a = this.f1767a.m1752a(view);
        if (a == -1) {
            return m2215h(view) ? true : true;
        } else {
            if (!this.f1768b.m2210c(a)) {
                return false;
            }
            this.f1768b.m2211d(a);
            if (m2215h(view)) {
                this.f1767a.m1753a(a);
            } else {
                this.f1767a.m1753a(a);
            }
            return true;
        }
    }

    public String toString() {
        return this.f1768b.toString() + ", hidden list:" + this.f1769c.size();
    }
}
