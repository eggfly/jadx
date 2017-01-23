package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.C0517e;
import android.support.v7.widget.RecyclerView.C0517e.C0516c;
import android.support.v7.widget.RecyclerView.C0532u;
import android.view.View;

public abstract class ba extends C0517e {
    boolean f1805a;

    public ba() {
        this.f1805a = true;
    }

    public final void m2264a(C0532u c0532u, boolean z) {
        m2275d(c0532u, z);
        m1827e(c0532u);
    }

    public abstract boolean m2265a(C0532u c0532u);

    public abstract boolean m2266a(C0532u c0532u, int i, int i2, int i3, int i4);

    public boolean m2267a(C0532u c0532u, C0516c c0516c, C0516c c0516c2) {
        int i = c0516c.f1510a;
        int i2 = c0516c.f1511b;
        View view = c0532u.itemView;
        int left = c0516c2 == null ? view.getLeft() : c0516c2.f1510a;
        int top = c0516c2 == null ? view.getTop() : c0516c2.f1511b;
        if (c0532u.isRemoved() || (i == left && i2 == top)) {
            return m2265a(c0532u);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return m2266a(c0532u, i, i2, left, top);
    }

    public abstract boolean m2268a(C0532u c0532u, C0532u c0532u2, int i, int i2, int i3, int i4);

    public boolean m2269a(C0532u c0532u, C0532u c0532u2, C0516c c0516c, C0516c c0516c2) {
        int i;
        int i2;
        int i3 = c0516c.f1510a;
        int i4 = c0516c.f1511b;
        if (c0532u2.shouldIgnore()) {
            i = c0516c.f1510a;
            i2 = c0516c.f1511b;
        } else {
            i = c0516c2.f1510a;
            i2 = c0516c2.f1511b;
        }
        return m2268a(c0532u, c0532u2, i3, i4, i, i2);
    }

    public final void m2270b(C0532u c0532u, boolean z) {
        m2273c(c0532u, z);
    }

    public abstract boolean m2271b(C0532u c0532u);

    public boolean m2272b(C0532u c0532u, C0516c c0516c, C0516c c0516c2) {
        if (c0516c == null || (c0516c.f1510a == c0516c2.f1510a && c0516c.f1511b == c0516c2.f1511b)) {
            return m2271b(c0532u);
        }
        return m2266a(c0532u, c0516c.f1510a, c0516c.f1511b, c0516c2.f1510a, c0516c2.f1511b);
    }

    public void m2273c(C0532u c0532u, boolean z) {
    }

    public boolean m2274c(C0532u c0532u, C0516c c0516c, C0516c c0516c2) {
        if (c0516c.f1510a == c0516c2.f1510a && c0516c.f1511b == c0516c2.f1511b) {
            m2278i(c0532u);
            return false;
        }
        return m2266a(c0532u, c0516c.f1510a, c0516c.f1511b, c0516c2.f1510a, c0516c2.f1511b);
    }

    public void m2275d(C0532u c0532u, boolean z) {
    }

    public boolean m2276g(C0532u c0532u) {
        return !this.f1805a || c0532u.isInvalid();
    }

    public final void m2277h(C0532u c0532u) {
        m2284o(c0532u);
        m1827e(c0532u);
    }

    public final void m2278i(C0532u c0532u) {
        m2288s(c0532u);
        m1827e(c0532u);
    }

    public final void m2279j(C0532u c0532u) {
        m2286q(c0532u);
        m1827e(c0532u);
    }

    public final void m2280k(C0532u c0532u) {
        m2283n(c0532u);
    }

    public final void m2281l(C0532u c0532u) {
        m2287r(c0532u);
    }

    public final void m2282m(C0532u c0532u) {
        m2285p(c0532u);
    }

    public void m2283n(C0532u c0532u) {
    }

    public void m2284o(C0532u c0532u) {
    }

    public void m2285p(C0532u c0532u) {
    }

    public void m2286q(C0532u c0532u) {
    }

    public void m2287r(C0532u c0532u) {
    }

    public void m2288s(C0532u c0532u) {
    }
}
