package android.support.v4.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public class ScrollerCompat {
    Object f1167a;
    ScrollerCompatImpl f1168b;

    interface ScrollerCompatImpl {
        Object m2322a(Context context, Interpolator interpolator);

        void m2323a(Object obj, int i, int i2, int i3, int i4);

        void m2324a(Object obj, int i, int i2, int i3, int i4, int i5);

        void m2325a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10);

        boolean m2326a(Object obj);

        int m2327b(Object obj);

        int m2328c(Object obj);

        float m2329d(Object obj);

        boolean m2330e(Object obj);

        void m2331f(Object obj);

        int m2332g(Object obj);

        int m2333h(Object obj);
    }

    static class ScrollerCompatImplBase implements ScrollerCompatImpl {
        ScrollerCompatImplBase() {
        }

        public Object m2334a(Context context, Interpolator interpolator) {
            return interpolator != null ? new Scroller(context, interpolator) : new Scroller(context);
        }

        public boolean m2338a(Object obj) {
            return ((Scroller) obj).isFinished();
        }

        public int m2339b(Object obj) {
            return ((Scroller) obj).getCurrX();
        }

        public int m2340c(Object obj) {
            return ((Scroller) obj).getCurrY();
        }

        public float m2341d(Object obj) {
            return 0.0f;
        }

        public boolean m2342e(Object obj) {
            return ((Scroller) obj).computeScrollOffset();
        }

        public void m2335a(Object obj, int i, int i2, int i3, int i4) {
            ((Scroller) obj).startScroll(i, i2, i3, i4);
        }

        public void m2336a(Object obj, int i, int i2, int i3, int i4, int i5) {
            ((Scroller) obj).startScroll(i, i2, i3, i4, i5);
        }

        public void m2337a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            ((Scroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
        }

        public void m2343f(Object obj) {
            ((Scroller) obj).abortAnimation();
        }

        public int m2344g(Object obj) {
            return ((Scroller) obj).getFinalX();
        }

        public int m2345h(Object obj) {
            return ((Scroller) obj).getFinalY();
        }
    }

    static class ScrollerCompatImplGingerbread implements ScrollerCompatImpl {
        ScrollerCompatImplGingerbread() {
        }

        public Object m2346a(Context context, Interpolator interpolator) {
            return ScrollerCompatGingerbread.m2371a(context, interpolator);
        }

        public boolean m2350a(Object obj) {
            return ScrollerCompatGingerbread.m2375a(obj);
        }

        public int m2351b(Object obj) {
            return ScrollerCompatGingerbread.m2376b(obj);
        }

        public int m2352c(Object obj) {
            return ScrollerCompatGingerbread.m2377c(obj);
        }

        public float m2353d(Object obj) {
            return 0.0f;
        }

        public boolean m2354e(Object obj) {
            return ScrollerCompatGingerbread.m2378d(obj);
        }

        public void m2347a(Object obj, int i, int i2, int i3, int i4) {
            ScrollerCompatGingerbread.m2372a(obj, i, i2, i3, i4);
        }

        public void m2348a(Object obj, int i, int i2, int i3, int i4, int i5) {
            ScrollerCompatGingerbread.m2373a(obj, i, i2, i3, i4, i5);
        }

        public void m2349a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            ScrollerCompatGingerbread.m2374a(obj, i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
        }

        public void m2355f(Object obj) {
            ScrollerCompatGingerbread.m2379e(obj);
        }

        public int m2356g(Object obj) {
            return ScrollerCompatGingerbread.m2380f(obj);
        }

        public int m2357h(Object obj) {
            return ScrollerCompatGingerbread.m2381g(obj);
        }
    }

    static class ScrollerCompatImplIcs extends ScrollerCompatImplGingerbread {
        ScrollerCompatImplIcs() {
        }

        public float m2358d(Object obj) {
            return ScrollerCompatIcs.m2382a(obj);
        }
    }

    public static ScrollerCompat m2359a(Context context, Interpolator interpolator) {
        return new ScrollerCompat(context, interpolator);
    }

    ScrollerCompat(Context context, Interpolator interpolator) {
        this(VERSION.SDK_INT, context, interpolator);
    }

    private ScrollerCompat(int i, Context context, Interpolator interpolator) {
        if (i >= 14) {
            this.f1168b = new ScrollerCompatImplIcs();
        } else if (i >= 9) {
            this.f1168b = new ScrollerCompatImplGingerbread();
        } else {
            this.f1168b = new ScrollerCompatImplBase();
        }
        this.f1167a = this.f1168b.m2322a(context, interpolator);
    }

    public boolean m2363a() {
        return this.f1168b.m2326a(this.f1167a);
    }

    public int m2364b() {
        return this.f1168b.m2327b(this.f1167a);
    }

    public int m2365c() {
        return this.f1168b.m2328c(this.f1167a);
    }

    public int m2366d() {
        return this.f1168b.m2332g(this.f1167a);
    }

    public int m2367e() {
        return this.f1168b.m2333h(this.f1167a);
    }

    public float m2368f() {
        return this.f1168b.m2329d(this.f1167a);
    }

    public boolean m2369g() {
        return this.f1168b.m2330e(this.f1167a);
    }

    public void m2360a(int i, int i2, int i3, int i4) {
        this.f1168b.m2323a(this.f1167a, i, i2, i3, i4);
    }

    public void m2361a(int i, int i2, int i3, int i4, int i5) {
        this.f1168b.m2324a(this.f1167a, i, i2, i3, i4, i5);
    }

    public void m2362a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.f1168b.m2325a(this.f1167a, i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    public void m2370h() {
        this.f1168b.m2331f(this.f1167a);
    }
}
