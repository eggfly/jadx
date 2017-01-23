package android.support.v7.widget;

import android.support.v4.animation.AnimatorCompatHelper;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.widget.RecyclerView.C0532u;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aj extends ba {
    private ArrayList<C0532u> f1806b;
    private ArrayList<C0532u> f1807c;
    private ArrayList<C0570b> f1808d;
    private ArrayList<C0569a> f1809e;
    private ArrayList<ArrayList<C0532u>> f1810f;
    private ArrayList<ArrayList<C0570b>> f1811g;
    private ArrayList<ArrayList<C0569a>> f1812h;
    private ArrayList<C0532u> f1813i;
    private ArrayList<C0532u> f1814j;
    private ArrayList<C0532u> f1815k;
    private ArrayList<C0532u> f1816l;

    /* renamed from: android.support.v7.widget.aj.1 */
    class C05601 implements Runnable {
        final /* synthetic */ ArrayList f1770a;
        final /* synthetic */ aj f1771b;

        C05601(aj ajVar, ArrayList arrayList) {
            this.f1771b = ajVar;
            this.f1770a = arrayList;
        }

        public void run() {
            Iterator it = this.f1770a.iterator();
            while (it.hasNext()) {
                C0570b c0570b = (C0570b) it.next();
                this.f1771b.m2297b(c0570b.f1800a, c0570b.f1801b, c0570b.f1802c, c0570b.f1803d, c0570b.f1804e);
            }
            this.f1770a.clear();
            this.f1771b.f1811g.remove(this.f1770a);
        }
    }

    /* renamed from: android.support.v7.widget.aj.2 */
    class C05612 implements Runnable {
        final /* synthetic */ ArrayList f1772a;
        final /* synthetic */ aj f1773b;

        C05612(aj ajVar, ArrayList arrayList) {
            this.f1773b = ajVar;
            this.f1772a = arrayList;
        }

        public void run() {
            Iterator it = this.f1772a.iterator();
            while (it.hasNext()) {
                this.f1773b.m2290a((C0569a) it.next());
            }
            this.f1772a.clear();
            this.f1773b.f1812h.remove(this.f1772a);
        }
    }

    /* renamed from: android.support.v7.widget.aj.3 */
    class C05623 implements Runnable {
        final /* synthetic */ ArrayList f1774a;
        final /* synthetic */ aj f1775b;

        C05623(aj ajVar, ArrayList arrayList) {
            this.f1775b = ajVar;
            this.f1774a = arrayList;
        }

        public void run() {
            Iterator it = this.f1774a.iterator();
            while (it.hasNext()) {
                this.f1775b.m2307u((C0532u) it.next());
            }
            this.f1774a.clear();
            this.f1775b.f1810f.remove(this.f1774a);
        }
    }

    /* renamed from: android.support.v7.widget.aj.c */
    private static class C0563c implements ViewPropertyAnimatorListener {
        private C0563c() {
        }

        public void onAnimationCancel(View view) {
        }

        public void onAnimationEnd(View view) {
        }

        public void onAnimationStart(View view) {
        }
    }

    /* renamed from: android.support.v7.widget.aj.4 */
    class C05644 extends C0563c {
        final /* synthetic */ C0532u f1776a;
        final /* synthetic */ ViewPropertyAnimatorCompat f1777b;
        final /* synthetic */ aj f1778c;

        C05644(aj ajVar, C0532u c0532u, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
            this.f1778c = ajVar;
            this.f1776a = c0532u;
            this.f1777b = viewPropertyAnimatorCompat;
            super();
        }

        public void onAnimationEnd(View view) {
            this.f1777b.setListener(null);
            ViewCompat.setAlpha(view, 1.0f);
            this.f1778c.m2277h(this.f1776a);
            this.f1778c.f1815k.remove(this.f1776a);
            this.f1778c.m2305j();
        }

        public void onAnimationStart(View view) {
            this.f1778c.m2280k(this.f1776a);
        }
    }

    /* renamed from: android.support.v7.widget.aj.5 */
    class C05655 extends C0563c {
        final /* synthetic */ C0532u f1779a;
        final /* synthetic */ ViewPropertyAnimatorCompat f1780b;
        final /* synthetic */ aj f1781c;

        C05655(aj ajVar, C0532u c0532u, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
            this.f1781c = ajVar;
            this.f1779a = c0532u;
            this.f1780b = viewPropertyAnimatorCompat;
            super();
        }

        public void onAnimationCancel(View view) {
            ViewCompat.setAlpha(view, 1.0f);
        }

        public void onAnimationEnd(View view) {
            this.f1780b.setListener(null);
            this.f1781c.m2279j(this.f1779a);
            this.f1781c.f1813i.remove(this.f1779a);
            this.f1781c.m2305j();
        }

        public void onAnimationStart(View view) {
            this.f1781c.m2282m(this.f1779a);
        }
    }

    /* renamed from: android.support.v7.widget.aj.6 */
    class C05666 extends C0563c {
        final /* synthetic */ C0532u f1782a;
        final /* synthetic */ int f1783b;
        final /* synthetic */ int f1784c;
        final /* synthetic */ ViewPropertyAnimatorCompat f1785d;
        final /* synthetic */ aj f1786e;

        C05666(aj ajVar, C0532u c0532u, int i, int i2, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
            this.f1786e = ajVar;
            this.f1782a = c0532u;
            this.f1783b = i;
            this.f1784c = i2;
            this.f1785d = viewPropertyAnimatorCompat;
            super();
        }

        public void onAnimationCancel(View view) {
            if (this.f1783b != 0) {
                ViewCompat.setTranslationX(view, 0.0f);
            }
            if (this.f1784c != 0) {
                ViewCompat.setTranslationY(view, 0.0f);
            }
        }

        public void onAnimationEnd(View view) {
            this.f1785d.setListener(null);
            this.f1786e.m2278i(this.f1782a);
            this.f1786e.f1814j.remove(this.f1782a);
            this.f1786e.m2305j();
        }

        public void onAnimationStart(View view) {
            this.f1786e.m2281l(this.f1782a);
        }
    }

    /* renamed from: android.support.v7.widget.aj.7 */
    class C05677 extends C0563c {
        final /* synthetic */ C0569a f1787a;
        final /* synthetic */ ViewPropertyAnimatorCompat f1788b;
        final /* synthetic */ aj f1789c;

        C05677(aj ajVar, C0569a c0569a, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
            this.f1789c = ajVar;
            this.f1787a = c0569a;
            this.f1788b = viewPropertyAnimatorCompat;
            super();
        }

        public void onAnimationEnd(View view) {
            this.f1788b.setListener(null);
            ViewCompat.setAlpha(view, 1.0f);
            ViewCompat.setTranslationX(view, 0.0f);
            ViewCompat.setTranslationY(view, 0.0f);
            this.f1789c.m2264a(this.f1787a.f1794a, true);
            this.f1789c.f1816l.remove(this.f1787a.f1794a);
            this.f1789c.m2305j();
        }

        public void onAnimationStart(View view) {
            this.f1789c.m2270b(this.f1787a.f1794a, true);
        }
    }

    /* renamed from: android.support.v7.widget.aj.8 */
    class C05688 extends C0563c {
        final /* synthetic */ C0569a f1790a;
        final /* synthetic */ ViewPropertyAnimatorCompat f1791b;
        final /* synthetic */ View f1792c;
        final /* synthetic */ aj f1793d;

        C05688(aj ajVar, C0569a c0569a, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            this.f1793d = ajVar;
            this.f1790a = c0569a;
            this.f1791b = viewPropertyAnimatorCompat;
            this.f1792c = view;
            super();
        }

        public void onAnimationEnd(View view) {
            this.f1791b.setListener(null);
            ViewCompat.setAlpha(this.f1792c, 1.0f);
            ViewCompat.setTranslationX(this.f1792c, 0.0f);
            ViewCompat.setTranslationY(this.f1792c, 0.0f);
            this.f1793d.m2264a(this.f1790a.f1795b, false);
            this.f1793d.f1816l.remove(this.f1790a.f1795b);
            this.f1793d.m2305j();
        }

        public void onAnimationStart(View view) {
            this.f1793d.m2270b(this.f1790a.f1795b, false);
        }
    }

    /* renamed from: android.support.v7.widget.aj.a */
    private static class C0569a {
        public C0532u f1794a;
        public C0532u f1795b;
        public int f1796c;
        public int f1797d;
        public int f1798e;
        public int f1799f;

        private C0569a(C0532u c0532u, C0532u c0532u2) {
            this.f1794a = c0532u;
            this.f1795b = c0532u2;
        }

        private C0569a(C0532u c0532u, C0532u c0532u2, int i, int i2, int i3, int i4) {
            this(c0532u, c0532u2);
            this.f1796c = i;
            this.f1797d = i2;
            this.f1798e = i3;
            this.f1799f = i4;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f1794a + ", newHolder=" + this.f1795b + ", fromX=" + this.f1796c + ", fromY=" + this.f1797d + ", toX=" + this.f1798e + ", toY=" + this.f1799f + '}';
        }
    }

    /* renamed from: android.support.v7.widget.aj.b */
    private static class C0570b {
        public C0532u f1800a;
        public int f1801b;
        public int f1802c;
        public int f1803d;
        public int f1804e;

        private C0570b(C0532u c0532u, int i, int i2, int i3, int i4) {
            this.f1800a = c0532u;
            this.f1801b = i;
            this.f1802c = i2;
            this.f1803d = i3;
            this.f1804e = i4;
        }
    }

    public aj() {
        this.f1806b = new ArrayList();
        this.f1807c = new ArrayList();
        this.f1808d = new ArrayList();
        this.f1809e = new ArrayList();
        this.f1810f = new ArrayList();
        this.f1811g = new ArrayList();
        this.f1812h = new ArrayList();
        this.f1813i = new ArrayList();
        this.f1814j = new ArrayList();
        this.f1815k = new ArrayList();
        this.f1816l = new ArrayList();
    }

    private void m2290a(C0569a c0569a) {
        View view = null;
        C0532u c0532u = c0569a.f1794a;
        View view2 = c0532u == null ? null : c0532u.itemView;
        C0532u c0532u2 = c0569a.f1795b;
        if (c0532u2 != null) {
            view = c0532u2.itemView;
        }
        if (view2 != null) {
            ViewPropertyAnimatorCompat duration = ViewCompat.animate(view2).setDuration(m1830g());
            this.f1816l.add(c0569a.f1794a);
            duration.translationX((float) (c0569a.f1798e - c0569a.f1796c));
            duration.translationY((float) (c0569a.f1799f - c0569a.f1797d));
            duration.alpha(0.0f).setListener(new C05677(this, c0569a, duration)).start();
        }
        if (view != null) {
            duration = ViewCompat.animate(view);
            this.f1816l.add(c0569a.f1795b);
            duration.translationX(0.0f).translationY(0.0f).setDuration(m1830g()).alpha(1.0f).setListener(new C05688(this, c0569a, duration, view)).start();
        }
    }

    private void m2294a(List<C0569a> list, C0532u c0532u) {
        for (int size = list.size() - 1; size >= 0; size--) {
            C0569a c0569a = (C0569a) list.get(size);
            if (m2295a(c0569a, c0532u) && c0569a.f1794a == null && c0569a.f1795b == null) {
                list.remove(c0569a);
            }
        }
    }

    private boolean m2295a(C0569a c0569a, C0532u c0532u) {
        boolean z = false;
        if (c0569a.f1795b == c0532u) {
            c0569a.f1795b = null;
        } else if (c0569a.f1794a != c0532u) {
            return false;
        } else {
            c0569a.f1794a = null;
            z = true;
        }
        ViewCompat.setAlpha(c0532u.itemView, 1.0f);
        ViewCompat.setTranslationX(c0532u.itemView, 0.0f);
        ViewCompat.setTranslationY(c0532u.itemView, 0.0f);
        m2264a(c0532u, z);
        return true;
    }

    private void m2297b(C0532u c0532u, int i, int i2, int i3, int i4) {
        View view = c0532u.itemView;
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (i5 != 0) {
            ViewCompat.animate(view).translationX(0.0f);
        }
        if (i6 != 0) {
            ViewCompat.animate(view).translationY(0.0f);
        }
        ViewPropertyAnimatorCompat animate = ViewCompat.animate(view);
        this.f1814j.add(c0532u);
        animate.setDuration(m1825d()).setListener(new C05666(this, c0532u, i5, i6, animate)).start();
    }

    private void m2298b(C0569a c0569a) {
        if (c0569a.f1794a != null) {
            m2295a(c0569a, c0569a.f1794a);
        }
        if (c0569a.f1795b != null) {
            m2295a(c0569a, c0569a.f1795b);
        }
    }

    private void m2305j() {
        if (!m2315b()) {
            m1832h();
        }
    }

    private void m2306t(C0532u c0532u) {
        ViewPropertyAnimatorCompat animate = ViewCompat.animate(c0532u.itemView);
        this.f1815k.add(c0532u);
        animate.setDuration(m1828f()).alpha(0.0f).setListener(new C05644(this, c0532u, animate)).start();
    }

    private void m2307u(C0532u c0532u) {
        ViewPropertyAnimatorCompat animate = ViewCompat.animate(c0532u.itemView);
        this.f1813i.add(c0532u);
        animate.alpha(1.0f).setDuration(m1826e()).setListener(new C05655(this, c0532u, animate)).start();
    }

    private void m2308v(C0532u c0532u) {
        AnimatorCompatHelper.clearInterpolator(c0532u.itemView);
        m2318c(c0532u);
    }

    public void m2309a() {
        int i = !this.f1806b.isEmpty() ? 1 : 0;
        int i2 = !this.f1808d.isEmpty() ? 1 : 0;
        int i3 = !this.f1809e.isEmpty() ? 1 : 0;
        int i4 = !this.f1807c.isEmpty() ? 1 : 0;
        if (i != 0 || i2 != 0 || i4 != 0 || i3 != 0) {
            ArrayList arrayList;
            Runnable c05601;
            Iterator it = this.f1806b.iterator();
            while (it.hasNext()) {
                m2306t((C0532u) it.next());
            }
            this.f1806b.clear();
            if (i2 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.f1808d);
                this.f1811g.add(arrayList);
                this.f1808d.clear();
                c05601 = new C05601(this, arrayList);
                if (i != 0) {
                    ViewCompat.postOnAnimationDelayed(((C0570b) arrayList.get(0)).f1800a.itemView, c05601, m1828f());
                } else {
                    c05601.run();
                }
            }
            if (i3 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.f1809e);
                this.f1812h.add(arrayList);
                this.f1809e.clear();
                c05601 = new C05612(this, arrayList);
                if (i != 0) {
                    ViewCompat.postOnAnimationDelayed(((C0569a) arrayList.get(0)).f1794a.itemView, c05601, m1828f());
                } else {
                    c05601.run();
                }
            }
            if (i4 != 0) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.f1807c);
                this.f1810f.add(arrayList2);
                this.f1807c.clear();
                Runnable c05623 = new C05623(this, arrayList2);
                if (i == 0 && i2 == 0 && i3 == 0) {
                    c05623.run();
                } else {
                    ViewCompat.postOnAnimationDelayed(((C0532u) arrayList2.get(0)).itemView, c05623, (i != 0 ? m1828f() : 0) + Math.max(i2 != 0 ? m1825d() : 0, i3 != 0 ? m1830g() : 0));
                }
            }
        }
    }

    void m2310a(List<C0532u> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ViewCompat.animate(((C0532u) list.get(size)).itemView).cancel();
        }
    }

    public boolean m2311a(C0532u c0532u) {
        m2308v(c0532u);
        this.f1806b.add(c0532u);
        return true;
    }

    public boolean m2312a(C0532u c0532u, int i, int i2, int i3, int i4) {
        View view = c0532u.itemView;
        int translationX = (int) (((float) i) + ViewCompat.getTranslationX(c0532u.itemView));
        int translationY = (int) (((float) i2) + ViewCompat.getTranslationY(c0532u.itemView));
        m2308v(c0532u);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            m2278i(c0532u);
            return false;
        }
        if (i5 != 0) {
            ViewCompat.setTranslationX(view, (float) (-i5));
        }
        if (i6 != 0) {
            ViewCompat.setTranslationY(view, (float) (-i6));
        }
        this.f1808d.add(new C0570b(translationX, translationY, i3, i4, null));
        return true;
    }

    public boolean m2313a(C0532u c0532u, C0532u c0532u2, int i, int i2, int i3, int i4) {
        if (c0532u == c0532u2) {
            return m2312a(c0532u, i, i2, i3, i4);
        }
        float translationX = ViewCompat.getTranslationX(c0532u.itemView);
        float translationY = ViewCompat.getTranslationY(c0532u.itemView);
        float alpha = ViewCompat.getAlpha(c0532u.itemView);
        m2308v(c0532u);
        int i5 = (int) (((float) (i3 - i)) - translationX);
        int i6 = (int) (((float) (i4 - i2)) - translationY);
        ViewCompat.setTranslationX(c0532u.itemView, translationX);
        ViewCompat.setTranslationY(c0532u.itemView, translationY);
        ViewCompat.setAlpha(c0532u.itemView, alpha);
        if (c0532u2 != null) {
            m2308v(c0532u2);
            ViewCompat.setTranslationX(c0532u2.itemView, (float) (-i5));
            ViewCompat.setTranslationY(c0532u2.itemView, (float) (-i6));
            ViewCompat.setAlpha(c0532u2.itemView, 0.0f);
        }
        this.f1809e.add(new C0569a(c0532u2, i, i2, i3, i4, null));
        return true;
    }

    public boolean m2314a(C0532u c0532u, List<Object> list) {
        return !list.isEmpty() || super.m1819a(c0532u, (List) list);
    }

    public boolean m2315b() {
        return (this.f1807c.isEmpty() && this.f1809e.isEmpty() && this.f1808d.isEmpty() && this.f1806b.isEmpty() && this.f1814j.isEmpty() && this.f1815k.isEmpty() && this.f1813i.isEmpty() && this.f1816l.isEmpty() && this.f1811g.isEmpty() && this.f1810f.isEmpty() && this.f1812h.isEmpty()) ? false : true;
    }

    public boolean m2316b(C0532u c0532u) {
        m2308v(c0532u);
        ViewCompat.setAlpha(c0532u.itemView, 0.0f);
        this.f1807c.add(c0532u);
        return true;
    }

    public void m2317c() {
        int size;
        for (size = this.f1808d.size() - 1; size >= 0; size--) {
            C0570b c0570b = (C0570b) this.f1808d.get(size);
            View view = c0570b.f1800a.itemView;
            ViewCompat.setTranslationY(view, 0.0f);
            ViewCompat.setTranslationX(view, 0.0f);
            m2278i(c0570b.f1800a);
            this.f1808d.remove(size);
        }
        for (size = this.f1806b.size() - 1; size >= 0; size--) {
            m2277h((C0532u) this.f1806b.get(size));
            this.f1806b.remove(size);
        }
        for (size = this.f1807c.size() - 1; size >= 0; size--) {
            C0532u c0532u = (C0532u) this.f1807c.get(size);
            ViewCompat.setAlpha(c0532u.itemView, 1.0f);
            m2279j(c0532u);
            this.f1807c.remove(size);
        }
        for (size = this.f1809e.size() - 1; size >= 0; size--) {
            m2298b((C0569a) this.f1809e.get(size));
        }
        this.f1809e.clear();
        if (m2315b()) {
            int size2;
            ArrayList arrayList;
            int size3;
            for (size2 = this.f1811g.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.f1811g.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    C0570b c0570b2 = (C0570b) arrayList.get(size3);
                    View view2 = c0570b2.f1800a.itemView;
                    ViewCompat.setTranslationY(view2, 0.0f);
                    ViewCompat.setTranslationX(view2, 0.0f);
                    m2278i(c0570b2.f1800a);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.f1811g.remove(arrayList);
                    }
                }
            }
            for (size2 = this.f1810f.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.f1810f.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    C0532u c0532u2 = (C0532u) arrayList.get(size3);
                    ViewCompat.setAlpha(c0532u2.itemView, 1.0f);
                    m2279j(c0532u2);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.f1810f.remove(arrayList);
                    }
                }
            }
            for (size2 = this.f1812h.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.f1812h.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    m2298b((C0569a) arrayList.get(size3));
                    if (arrayList.isEmpty()) {
                        this.f1812h.remove(arrayList);
                    }
                }
            }
            m2310a(this.f1815k);
            m2310a(this.f1814j);
            m2310a(this.f1813i);
            m2310a(this.f1816l);
            m1832h();
        }
    }

    public void m2318c(C0532u c0532u) {
        int size;
        View view = c0532u.itemView;
        ViewCompat.animate(view).cancel();
        for (size = this.f1808d.size() - 1; size >= 0; size--) {
            if (((C0570b) this.f1808d.get(size)).f1800a == c0532u) {
                ViewCompat.setTranslationY(view, 0.0f);
                ViewCompat.setTranslationX(view, 0.0f);
                m2278i(c0532u);
                this.f1808d.remove(size);
            }
        }
        m2294a(this.f1809e, c0532u);
        if (this.f1806b.remove(c0532u)) {
            ViewCompat.setAlpha(view, 1.0f);
            m2277h(c0532u);
        }
        if (this.f1807c.remove(c0532u)) {
            ViewCompat.setAlpha(view, 1.0f);
            m2279j(c0532u);
        }
        for (size = this.f1812h.size() - 1; size >= 0; size--) {
            List list = (ArrayList) this.f1812h.get(size);
            m2294a(list, c0532u);
            if (list.isEmpty()) {
                this.f1812h.remove(size);
            }
        }
        for (int size2 = this.f1811g.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = (ArrayList) this.f1811g.get(size2);
            int size3 = arrayList.size() - 1;
            while (size3 >= 0) {
                if (((C0570b) arrayList.get(size3)).f1800a == c0532u) {
                    ViewCompat.setTranslationY(view, 0.0f);
                    ViewCompat.setTranslationX(view, 0.0f);
                    m2278i(c0532u);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.f1811g.remove(size2);
                    }
                } else {
                    size3--;
                }
            }
        }
        for (size = this.f1810f.size() - 1; size >= 0; size--) {
            arrayList = (ArrayList) this.f1810f.get(size);
            if (arrayList.remove(c0532u)) {
                ViewCompat.setAlpha(view, 1.0f);
                m2279j(c0532u);
                if (arrayList.isEmpty()) {
                    this.f1810f.remove(size);
                }
            }
        }
        if (this.f1815k.remove(c0532u)) {
        }
        if (this.f1813i.remove(c0532u)) {
        }
        if (this.f1816l.remove(c0532u)) {
        }
        if (this.f1814j.remove(c0532u)) {
            m2305j();
        } else {
            m2305j();
        }
    }
}
