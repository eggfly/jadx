package android.support.v4.widget;

import android.os.SystemClock;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;

public abstract class AutoScrollHelper implements OnTouchListener {
    private static final int f980r;
    private final ClampedScroller f981a;
    private final Interpolator f982b;
    private final View f983c;
    private Runnable f984d;
    private float[] f985e;
    private float[] f986f;
    private int f987g;
    private int f988h;
    private float[] f989i;
    private float[] f990j;
    private float[] f991k;
    private boolean f992l;
    private boolean f993m;
    private boolean f994n;
    private boolean f995o;
    private boolean f996p;
    private boolean f997q;

    private static class ClampedScroller {
        private int f968a;
        private int f969b;
        private float f970c;
        private float f971d;
        private long f972e;
        private long f973f;
        private int f974g;
        private int f975h;
        private long f976i;
        private float f977j;
        private int f978k;

        public ClampedScroller() {
            this.f972e = Long.MIN_VALUE;
            this.f976i = -1;
            this.f973f = 0;
            this.f974g = 0;
            this.f975h = 0;
        }

        public void m2009a() {
            this.f972e = AnimationUtils.currentAnimationTimeMillis();
            this.f976i = -1;
            this.f973f = this.f972e;
            this.f977j = 0.5f;
            this.f974g = 0;
            this.f975h = 0;
        }

        public void m2011b() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f978k = AutoScrollHelper.m2027b((int) (currentAnimationTimeMillis - this.f972e), 0, this.f969b);
            this.f977j = m2008a(currentAnimationTimeMillis);
            this.f976i = currentAnimationTimeMillis;
        }

        public boolean m2012c() {
            return this.f976i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f976i + ((long) this.f978k);
        }

        private float m2008a(long j) {
            if (j < this.f972e) {
                return 0.0f;
            }
            if (this.f976i < 0 || j < this.f976i) {
                return AutoScrollHelper.m2026b(((float) (j - this.f972e)) / ((float) this.f968a), 0.0f, 1.0f) * 0.5f;
            }
            long j2 = j - this.f976i;
            return (AutoScrollHelper.m2026b(((float) j2) / ((float) this.f978k), 0.0f, 1.0f) * this.f977j) + (1.0f - this.f977j);
        }

        private float m2007a(float f) {
            return ((-4.0f * f) * f) + (4.0f * f);
        }

        public void m2013d() {
            if (this.f973f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float a = m2007a(m2008a(currentAnimationTimeMillis));
            long j = currentAnimationTimeMillis - this.f973f;
            this.f973f = currentAnimationTimeMillis;
            this.f974g = (int) ((((float) j) * a) * this.f970c);
            this.f975h = (int) ((((float) j) * a) * this.f971d);
        }

        public void m2010a(float f, float f2) {
            this.f970c = f;
            this.f971d = f2;
        }

        public int m2014e() {
            return (int) (this.f970c / Math.abs(this.f970c));
        }

        public int m2015f() {
            return (int) (this.f971d / Math.abs(this.f971d));
        }

        public int m2016g() {
            return this.f974g;
        }

        public int m2017h() {
            return this.f975h;
        }
    }

    private class ScrollAnimationRunnable implements Runnable {
        final /* synthetic */ AutoScrollHelper f979a;

        private ScrollAnimationRunnable(AutoScrollHelper autoScrollHelper) {
            this.f979a = autoScrollHelper;
        }

        public void run() {
            if (this.f979a.f995o) {
                if (this.f979a.f993m) {
                    this.f979a.f993m = false;
                    this.f979a.f981a.m2009a();
                }
                ClampedScroller c = this.f979a.f981a;
                if (c.m2012c() || !this.f979a.m2023a()) {
                    this.f979a.f995o = false;
                    return;
                }
                if (this.f979a.f994n) {
                    this.f979a.f994n = false;
                    this.f979a.m2034d();
                }
                c.m2013d();
                this.f979a.m2039a(c.m2016g(), c.m2017h());
                ViewCompat.m1453a(this.f979a.f983c, (Runnable) this);
            }
        }
    }

    public abstract void m2039a(int i, int i2);

    public abstract boolean m2040a(int i);

    public abstract boolean m2041b(int i);

    static {
        f980r = ViewConfiguration.getTapTimeout();
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z = true;
        if (!this.f996p) {
            return false;
        }
        switch (MotionEventCompat.m1283a(motionEvent)) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                this.f994n = true;
                this.f992l = false;
                break;
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                m2032c();
                break;
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                break;
        }
        this.f981a.m2010a(m2021a(0, motionEvent.getX(), (float) view.getWidth(), (float) this.f983c.getWidth()), m2021a(1, motionEvent.getY(), (float) view.getHeight(), (float) this.f983c.getHeight()));
        if (!this.f995o && m2023a()) {
            m2028b();
        }
        if (!(this.f997q && this.f995o)) {
            z = false;
        }
        return z;
    }

    private boolean m2023a() {
        ClampedScroller clampedScroller = this.f981a;
        int f = clampedScroller.m2015f();
        int e = clampedScroller.m2014e();
        return (f != 0 && m2041b(f)) || (e != 0 && m2040a(e));
    }

    private void m2028b() {
        if (this.f984d == null) {
            this.f984d = new ScrollAnimationRunnable();
        }
        this.f995o = true;
        this.f993m = true;
        if (this.f992l || this.f988h <= 0) {
            this.f984d.run();
        } else {
            ViewCompat.m1454a(this.f983c, this.f984d, (long) this.f988h);
        }
        this.f992l = true;
    }

    private void m2032c() {
        if (this.f993m) {
            this.f995o = false;
        } else {
            this.f981a.m2011b();
        }
    }

    private float m2021a(int i, float f, float f2, float f3) {
        float a = m2020a(this.f985e[i], f2, this.f986f[i], f);
        if (a == 0.0f) {
            return 0.0f;
        }
        float f4 = this.f989i[i];
        float f5 = this.f990j[i];
        float f6 = this.f991k[i];
        f4 *= f3;
        if (a > 0.0f) {
            return m2026b(a * f4, f5, f6);
        }
        return -m2026b((-a) * f4, f5, f6);
    }

    private float m2020a(float f, float f2, float f3, float f4) {
        float f5;
        float b = m2026b(f * f2, 0.0f, f3);
        b = m2018a(f2 - f4, b) - m2018a(f4, b);
        if (b < 0.0f) {
            f5 = -this.f982b.getInterpolation(-b);
        } else if (b <= 0.0f) {
            return 0.0f;
        } else {
            f5 = this.f982b.getInterpolation(b);
        }
        return m2026b(f5, -1.0f, 1.0f);
    }

    private float m2018a(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        switch (this.f987g) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                if (f >= f2) {
                    return 0.0f;
                }
                if (f >= 0.0f) {
                    return 1.0f - (f / f2);
                }
                if (this.f995o && this.f987g == 1) {
                    return 1.0f;
                }
                return 0.0f;
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                if (f < 0.0f) {
                    return f / (-f2);
                }
                return 0.0f;
            default:
                return 0.0f;
        }
    }

    private static int m2027b(int i, int i2, int i3) {
        if (i > i3) {
            return i3;
        }
        if (i < i2) {
            return i2;
        }
        return i;
    }

    private static float m2026b(float f, float f2, float f3) {
        if (f > f3) {
            return f3;
        }
        if (f < f2) {
            return f2;
        }
        return f;
    }

    private void m2034d() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f983c.onTouchEvent(obtain);
        obtain.recycle();
    }
}
