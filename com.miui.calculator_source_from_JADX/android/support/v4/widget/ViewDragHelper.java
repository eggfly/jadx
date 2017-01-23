package android.support.v4.widget;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import java.util.Arrays;

public class ViewDragHelper {
    private static final Interpolator f1273v;
    private int f1274a;
    private int f1275b;
    private int f1276c;
    private float[] f1277d;
    private float[] f1278e;
    private float[] f1279f;
    private float[] f1280g;
    private int[] f1281h;
    private int[] f1282i;
    private int[] f1283j;
    private int f1284k;
    private VelocityTracker f1285l;
    private float f1286m;
    private float f1287n;
    private int f1288o;
    private int f1289p;
    private ScrollerCompat f1290q;
    private final Callback f1291r;
    private View f1292s;
    private boolean f1293t;
    private final ViewGroup f1294u;
    private final Runnable f1295w;

    public static abstract class Callback {
        public abstract boolean m2094a(View view, int i);

        public void m2090a(int i) {
        }

        public void m2093a(View view, int i, int i2, int i3, int i4) {
        }

        public void m2098b(View view, int i) {
        }

        public void m2092a(View view, float f, float f2) {
        }

        public void m2091a(int i, int i2) {
        }

        public boolean m2099b(int i) {
            return false;
        }

        public void m2097b(int i, int i2) {
        }

        public int m2100c(int i) {
            return i;
        }

        public int m2088a(View view) {
            return 0;
        }

        public int m2095b(View view) {
            return 0;
        }

        public int m2089a(View view, int i, int i2) {
            return 0;
        }

        public int m2096b(View view, int i, int i2) {
            return 0;
        }
    }

    /* renamed from: android.support.v4.widget.ViewDragHelper.1 */
    final class C01311 implements Interpolator {
        C01311() {
        }

        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    }

    /* renamed from: android.support.v4.widget.ViewDragHelper.2 */
    class C01322 implements Runnable {
        final /* synthetic */ ViewDragHelper f1272a;

        C01322(ViewDragHelper viewDragHelper) {
            this.f1272a = viewDragHelper;
        }

        public void run() {
            this.f1272a.m2537c(0);
        }
    }

    static {
        f1273v = new C01311();
    }

    public static ViewDragHelper m2506a(ViewGroup viewGroup, Callback callback) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, callback);
    }

    public static ViewDragHelper m2505a(ViewGroup viewGroup, float f, Callback callback) {
        ViewDragHelper a = m2506a(viewGroup, callback);
        a.f1275b = (int) (((float) a.f1275b) * (1.0f / f));
        return a;
    }

    private ViewDragHelper(Context context, ViewGroup viewGroup, Callback callback) {
        this.f1276c = -1;
        this.f1295w = new C01322(this);
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (callback == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.f1294u = viewGroup;
            this.f1291r = callback;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.f1288o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f1275b = viewConfiguration.getScaledTouchSlop();
            this.f1286m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.f1287n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.f1290q = ScrollerCompat.m2359a(context, f1273v);
        }
    }

    public void m2523a(float f) {
        this.f1287n = f;
    }

    public int m2522a() {
        return this.f1274a;
    }

    public void m2524a(int i) {
        this.f1289p = i;
    }

    public int m2530b() {
        return this.f1288o;
    }

    public void m2525a(View view, int i) {
        if (view.getParent() != this.f1294u) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f1294u + ")");
        }
        this.f1292s = view;
        this.f1276c = i;
        this.f1291r.m2098b(view, i);
        m2537c(1);
    }

    public View m2536c() {
        return this.f1292s;
    }

    public int m2539d() {
        return this.f1275b;
    }

    public void m2542e() {
        this.f1276c = -1;
        m2520g();
        if (this.f1285l != null) {
            this.f1285l.recycle();
            this.f1285l = null;
        }
    }

    public void m2543f() {
        m2542e();
        if (this.f1274a == 2) {
            int b = this.f1290q.m2364b();
            int c = this.f1290q.m2365c();
            this.f1290q.m2370h();
            int b2 = this.f1290q.m2364b();
            int c2 = this.f1290q.m2365c();
            this.f1291r.m2093a(this.f1292s, b2, c2, b2 - b, c2 - c);
        }
        m2537c(0);
    }

    public boolean m2528a(View view, int i, int i2) {
        this.f1292s = view;
        this.f1276c = -1;
        boolean a = m2510a(i, i2, 0, 0);
        if (!(a || this.f1274a != 0 || this.f1292s == null)) {
            this.f1292s = null;
        }
        return a;
    }

    public boolean m2526a(int i, int i2) {
        if (this.f1293t) {
            return m2510a(i, i2, (int) VelocityTrackerCompat.m1342a(this.f1285l, this.f1276c), (int) VelocityTrackerCompat.m1343b(this.f1285l, this.f1276c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    private boolean m2510a(int i, int i2, int i3, int i4) {
        int left = this.f1292s.getLeft();
        int top = this.f1292s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.f1290q.m2370h();
            m2537c(0);
            return false;
        }
        this.f1290q.m2361a(left, top, i5, i6, m2504a(this.f1292s, i5, i6, i3, i4));
        m2537c(2);
        return true;
    }

    private int m2504a(View view, int i, int i2, int i3, int i4) {
        int b = m2513b(i3, (int) this.f1287n, (int) this.f1286m);
        int b2 = m2513b(i4, (int) this.f1287n, (int) this.f1286m);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(b);
        int abs4 = Math.abs(b2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        return (int) (((b2 != 0 ? ((float) abs4) / ((float) i5) : ((float) abs2) / ((float) i6)) * ((float) m2503a(i2, b2, this.f1291r.m2095b(view)))) + ((b != 0 ? ((float) abs3) / ((float) i5) : ((float) abs) / ((float) i6)) * ((float) m2503a(i, b, this.f1291r.m2088a(view)))));
    }

    private int m2503a(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.f1294u.getWidth();
        int i4 = width / 2;
        float b = (m2512b(Math.min(1.0f, ((float) Math.abs(i)) / ((float) width))) * ((float) i4)) + ((float) i4);
        i4 = Math.abs(i2);
        if (i4 > 0) {
            width = Math.round(Math.abs(b / ((float) i4)) * 1000.0f) * 4;
        } else {
            width = (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f);
        }
        return Math.min(width, 600);
    }

    private int m2513b(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        if (abs <= i3) {
            return i;
        }
        if (i <= 0) {
            return -i3;
        }
        return i3;
    }

    private float m2502a(float f, float f2, float f3) {
        float abs = Math.abs(f);
        if (abs < f2) {
            return 0.0f;
        }
        if (abs <= f3) {
            return f;
        }
        if (f <= 0.0f) {
            return -f3;
        }
        return f3;
    }

    private float m2512b(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    public boolean m2529a(boolean z) {
        if (this.f1274a == 2) {
            int i;
            boolean g = this.f1290q.m2369g();
            int b = this.f1290q.m2364b();
            int c = this.f1290q.m2365c();
            int left = b - this.f1292s.getLeft();
            int top = c - this.f1292s.getTop();
            if (left != 0) {
                this.f1292s.offsetLeftAndRight(left);
            }
            if (top != 0) {
                this.f1292s.offsetTopAndBottom(top);
            }
            if (!(left == 0 && top == 0)) {
                this.f1291r.m2093a(this.f1292s, b, c, left, top);
            }
            if (g && b == this.f1290q.m2366d() && c == this.f1290q.m2367e()) {
                this.f1290q.m2370h();
                i = 0;
            } else {
                boolean z2 = g;
            }
            if (i == 0) {
                if (z) {
                    this.f1294u.post(this.f1295w);
                } else {
                    m2537c(0);
                }
            }
        }
        return this.f1274a == 2;
    }

    private void m2507a(float f, float f2) {
        this.f1293t = true;
        this.f1291r.m2092a(this.f1292s, f, f2);
        this.f1293t = false;
        if (this.f1274a == 1) {
            m2537c(0);
        }
    }

    private void m2520g() {
        if (this.f1277d != null) {
            Arrays.fill(this.f1277d, 0.0f);
            Arrays.fill(this.f1278e, 0.0f);
            Arrays.fill(this.f1279f, 0.0f);
            Arrays.fill(this.f1280g, 0.0f);
            Arrays.fill(this.f1281h, 0);
            Arrays.fill(this.f1282i, 0);
            Arrays.fill(this.f1283j, 0);
            this.f1284k = 0;
        }
    }

    private void m2518e(int i) {
        if (this.f1277d != null) {
            this.f1277d[i] = 0.0f;
            this.f1278e[i] = 0.0f;
            this.f1279f[i] = 0.0f;
            this.f1280g[i] = 0.0f;
            this.f1281h[i] = 0;
            this.f1282i[i] = 0;
            this.f1283j[i] = 0;
            this.f1284k &= (1 << i) ^ -1;
        }
    }

    private void m2519f(int i) {
        if (this.f1277d == null || this.f1277d.length <= i) {
            Object obj = new float[(i + 1)];
            Object obj2 = new float[(i + 1)];
            Object obj3 = new float[(i + 1)];
            Object obj4 = new float[(i + 1)];
            Object obj5 = new int[(i + 1)];
            Object obj6 = new int[(i + 1)];
            Object obj7 = new int[(i + 1)];
            if (this.f1277d != null) {
                System.arraycopy(this.f1277d, 0, obj, 0, this.f1277d.length);
                System.arraycopy(this.f1278e, 0, obj2, 0, this.f1278e.length);
                System.arraycopy(this.f1279f, 0, obj3, 0, this.f1279f.length);
                System.arraycopy(this.f1280g, 0, obj4, 0, this.f1280g.length);
                System.arraycopy(this.f1281h, 0, obj5, 0, this.f1281h.length);
                System.arraycopy(this.f1282i, 0, obj6, 0, this.f1282i.length);
                System.arraycopy(this.f1283j, 0, obj7, 0, this.f1283j.length);
            }
            this.f1277d = obj;
            this.f1278e = obj2;
            this.f1279f = obj3;
            this.f1280g = obj4;
            this.f1281h = obj5;
            this.f1282i = obj6;
            this.f1283j = obj7;
        }
    }

    private void m2508a(float f, float f2, int i) {
        m2519f(i);
        float[] fArr = this.f1277d;
        this.f1279f[i] = f;
        fArr[i] = f;
        fArr = this.f1278e;
        this.f1280g[i] = f2;
        fArr[i] = f2;
        this.f1281h[i] = m2517e((int) f, (int) f2);
        this.f1284k |= 1 << i;
    }

    private void m2516c(MotionEvent motionEvent) {
        int c = MotionEventCompat.m1288c(motionEvent);
        for (int i = 0; i < c; i++) {
            int b = MotionEventCompat.m1286b(motionEvent, i);
            float c2 = MotionEventCompat.m1287c(motionEvent, i);
            float d = MotionEventCompat.m1289d(motionEvent, i);
            this.f1279f[b] = c2;
            this.f1280g[b] = d;
        }
    }

    public boolean m2532b(int i) {
        return (this.f1284k & (1 << i)) != 0;
    }

    void m2537c(int i) {
        this.f1294u.removeCallbacks(this.f1295w);
        if (this.f1274a != i) {
            this.f1274a = i;
            this.f1291r.m2090a(i);
            if (this.f1274a == 0) {
                this.f1292s = null;
            }
        }
    }

    boolean m2534b(View view, int i) {
        if (view == this.f1292s && this.f1276c == i) {
            return true;
        }
        if (view == null || !this.f1291r.m2094a(view, i)) {
            return false;
        }
        this.f1276c = i;
        m2525a(view, i);
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m2527a(android.view.MotionEvent r14) {
        /*
        r13 = this;
        r0 = android.support.v4.view.MotionEventCompat.m1283a(r14);
        r1 = android.support.v4.view.MotionEventCompat.m1285b(r14);
        if (r0 != 0) goto L_0x000d;
    L_0x000a:
        r13.m2542e();
    L_0x000d:
        r2 = r13.f1285l;
        if (r2 != 0) goto L_0x0017;
    L_0x0011:
        r2 = android.view.VelocityTracker.obtain();
        r13.f1285l = r2;
    L_0x0017:
        r2 = r13.f1285l;
        r2.addMovement(r14);
        switch(r0) {
            case 0: goto L_0x0026;
            case 1: goto L_0x0121;
            case 2: goto L_0x0092;
            case 3: goto L_0x0121;
            case 4: goto L_0x001f;
            case 5: goto L_0x005a;
            case 6: goto L_0x0118;
            default: goto L_0x001f;
        };
    L_0x001f:
        r0 = r13.f1274a;
        r1 = 1;
        if (r0 != r1) goto L_0x0126;
    L_0x0024:
        r0 = 1;
    L_0x0025:
        return r0;
    L_0x0026:
        r0 = r14.getX();
        r1 = r14.getY();
        r2 = 0;
        r2 = android.support.v4.view.MotionEventCompat.m1286b(r14, r2);
        r13.m2508a(r0, r1, r2);
        r0 = (int) r0;
        r1 = (int) r1;
        r0 = r13.m2540d(r0, r1);
        r1 = r13.f1292s;
        if (r0 != r1) goto L_0x0048;
    L_0x0040:
        r1 = r13.f1274a;
        r3 = 2;
        if (r1 != r3) goto L_0x0048;
    L_0x0045:
        r13.m2534b(r0, r2);
    L_0x0048:
        r0 = r13.f1281h;
        r0 = r0[r2];
        r1 = r13.f1289p;
        r1 = r1 & r0;
        if (r1 == 0) goto L_0x001f;
    L_0x0051:
        r1 = r13.f1291r;
        r3 = r13.f1289p;
        r0 = r0 & r3;
        r1.m2091a(r0, r2);
        goto L_0x001f;
    L_0x005a:
        r0 = android.support.v4.view.MotionEventCompat.m1286b(r14, r1);
        r2 = android.support.v4.view.MotionEventCompat.m1287c(r14, r1);
        r1 = android.support.v4.view.MotionEventCompat.m1289d(r14, r1);
        r13.m2508a(r2, r1, r0);
        r3 = r13.f1274a;
        if (r3 != 0) goto L_0x007f;
    L_0x006d:
        r1 = r13.f1281h;
        r1 = r1[r0];
        r2 = r13.f1289p;
        r2 = r2 & r1;
        if (r2 == 0) goto L_0x001f;
    L_0x0076:
        r2 = r13.f1291r;
        r3 = r13.f1289p;
        r1 = r1 & r3;
        r2.m2091a(r1, r0);
        goto L_0x001f;
    L_0x007f:
        r3 = r13.f1274a;
        r4 = 2;
        if (r3 != r4) goto L_0x001f;
    L_0x0084:
        r2 = (int) r2;
        r1 = (int) r1;
        r1 = r13.m2540d(r2, r1);
        r2 = r13.f1292s;
        if (r1 != r2) goto L_0x001f;
    L_0x008e:
        r13.m2534b(r1, r0);
        goto L_0x001f;
    L_0x0092:
        r0 = r13.f1277d;
        if (r0 == 0) goto L_0x001f;
    L_0x0096:
        r0 = r13.f1278e;
        if (r0 == 0) goto L_0x001f;
    L_0x009a:
        r2 = android.support.v4.view.MotionEventCompat.m1288c(r14);
        r0 = 0;
        r1 = r0;
    L_0x00a0:
        if (r1 >= r2) goto L_0x00fd;
    L_0x00a2:
        r3 = android.support.v4.view.MotionEventCompat.m1286b(r14, r1);
        r0 = android.support.v4.view.MotionEventCompat.m1287c(r14, r1);
        r4 = android.support.v4.view.MotionEventCompat.m1289d(r14, r1);
        r5 = r13.f1277d;
        r5 = r5[r3];
        r5 = r0 - r5;
        r6 = r13.f1278e;
        r6 = r6[r3];
        r6 = r4 - r6;
        r0 = (int) r0;
        r4 = (int) r4;
        r4 = r13.m2540d(r0, r4);
        if (r4 == 0) goto L_0x0102;
    L_0x00c2:
        r0 = r13.m2511a(r4, r5, r6);
        if (r0 == 0) goto L_0x0102;
    L_0x00c8:
        r0 = 1;
    L_0x00c9:
        if (r0 == 0) goto L_0x0104;
    L_0x00cb:
        r7 = r4.getLeft();
        r8 = (int) r5;
        r8 = r8 + r7;
        r9 = r13.f1291r;
        r10 = (int) r5;
        r8 = r9.m2089a(r4, r8, r10);
        r9 = r4.getTop();
        r10 = (int) r6;
        r10 = r10 + r9;
        r11 = r13.f1291r;
        r12 = (int) r6;
        r10 = r11.m2096b(r4, r10, r12);
        r11 = r13.f1291r;
        r11 = r11.m2088a(r4);
        r12 = r13.f1291r;
        r12 = r12.m2095b(r4);
        if (r11 == 0) goto L_0x00f7;
    L_0x00f3:
        if (r11 <= 0) goto L_0x0104;
    L_0x00f5:
        if (r8 != r7) goto L_0x0104;
    L_0x00f7:
        if (r12 == 0) goto L_0x00fd;
    L_0x00f9:
        if (r12 <= 0) goto L_0x0104;
    L_0x00fb:
        if (r10 != r9) goto L_0x0104;
    L_0x00fd:
        r13.m2516c(r14);
        goto L_0x001f;
    L_0x0102:
        r0 = 0;
        goto L_0x00c9;
    L_0x0104:
        r13.m2514b(r5, r6, r3);
        r5 = r13.f1274a;
        r6 = 1;
        if (r5 == r6) goto L_0x00fd;
    L_0x010c:
        if (r0 == 0) goto L_0x0114;
    L_0x010e:
        r0 = r13.m2534b(r4, r3);
        if (r0 != 0) goto L_0x00fd;
    L_0x0114:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x00a0;
    L_0x0118:
        r0 = android.support.v4.view.MotionEventCompat.m1286b(r14, r1);
        r13.m2518e(r0);
        goto L_0x001f;
    L_0x0121:
        r13.m2542e();
        goto L_0x001f;
    L_0x0126:
        r0 = 0;
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.ViewDragHelper.a(android.view.MotionEvent):boolean");
    }

    public void m2531b(MotionEvent motionEvent) {
        int i = 0;
        int a = MotionEventCompat.m1283a(motionEvent);
        int b = MotionEventCompat.m1285b(motionEvent);
        if (a == 0) {
            m2542e();
        }
        if (this.f1285l == null) {
            this.f1285l = VelocityTracker.obtain();
        }
        this.f1285l.addMovement(motionEvent);
        float x;
        float y;
        View d;
        int i2;
        switch (a) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                x = motionEvent.getX();
                y = motionEvent.getY();
                i = MotionEventCompat.m1286b(motionEvent, 0);
                d = m2540d((int) x, (int) y);
                m2508a(x, y, i);
                m2534b(d, i);
                i2 = this.f1281h[i];
                if ((this.f1289p & i2) != 0) {
                    this.f1291r.m2091a(i2 & this.f1289p, i);
                }
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                if (this.f1274a == 1) {
                    m2521h();
                }
                m2542e();
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                if (this.f1274a == 1) {
                    i = MotionEventCompat.m1284a(motionEvent, this.f1276c);
                    x = MotionEventCompat.m1287c(motionEvent, i);
                    i2 = (int) (x - this.f1279f[this.f1276c]);
                    i = (int) (MotionEventCompat.m1289d(motionEvent, i) - this.f1280g[this.f1276c]);
                    m2515b(this.f1292s.getLeft() + i2, this.f1292s.getTop() + i, i2, i);
                    m2516c(motionEvent);
                    return;
                }
                i2 = MotionEventCompat.m1288c(motionEvent);
                while (i < i2) {
                    a = MotionEventCompat.m1286b(motionEvent, i);
                    float c = MotionEventCompat.m1287c(motionEvent, i);
                    float d2 = MotionEventCompat.m1289d(motionEvent, i);
                    float f = c - this.f1277d[a];
                    float f2 = d2 - this.f1278e[a];
                    m2514b(f, f2, a);
                    if (this.f1274a != 1) {
                        d = m2540d((int) c, (int) d2);
                        if (!m2511a(d, f, f2) || !m2534b(d, a)) {
                            i++;
                        }
                    }
                    m2516c(motionEvent);
                }
                m2516c(motionEvent);
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                if (this.f1274a == 1) {
                    m2507a(0.0f, 0.0f);
                }
                m2542e();
            case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                i = MotionEventCompat.m1286b(motionEvent, b);
                x = MotionEventCompat.m1287c(motionEvent, b);
                y = MotionEventCompat.m1289d(motionEvent, b);
                m2508a(x, y, i);
                if (this.f1274a == 0) {
                    m2534b(m2540d((int) x, (int) y), i);
                    i2 = this.f1281h[i];
                    if ((this.f1289p & i2) != 0) {
                        this.f1291r.m2091a(i2 & this.f1289p, i);
                    }
                } else if (m2538c((int) x, (int) y)) {
                    m2534b(this.f1292s, i);
                }
            case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                a = MotionEventCompat.m1286b(motionEvent, b);
                if (this.f1274a == 1 && a == this.f1276c) {
                    b = MotionEventCompat.m1288c(motionEvent);
                    while (i < b) {
                        int b2 = MotionEventCompat.m1286b(motionEvent, i);
                        if (b2 != this.f1276c) {
                            if (m2540d((int) MotionEventCompat.m1287c(motionEvent, i), (int) MotionEventCompat.m1289d(motionEvent, i)) == this.f1292s && m2534b(this.f1292s, b2)) {
                                i = this.f1276c;
                                if (i == -1) {
                                    m2521h();
                                }
                            }
                        }
                        i++;
                    }
                    i = -1;
                    if (i == -1) {
                        m2521h();
                    }
                }
                m2518e(a);
            default:
        }
    }

    private void m2514b(float f, float f2, int i) {
        int i2 = 1;
        if (!m2509a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (m2509a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (m2509a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (m2509a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.f1282i;
            iArr[i] = iArr[i] | i2;
            this.f1291r.m2097b(i2, i);
        }
    }

    private boolean m2509a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.f1281h[i] & i2) != i2 || (this.f1289p & i2) == 0 || (this.f1283j[i] & i2) == i2 || (this.f1282i[i] & i2) == i2) {
            return false;
        }
        if (abs <= ((float) this.f1275b) && abs2 <= ((float) this.f1275b)) {
            return false;
        }
        if (abs < abs2 * 0.5f && this.f1291r.m2099b(i2)) {
            int[] iArr = this.f1283j;
            iArr[i] = iArr[i] | i2;
            return false;
        } else if ((this.f1282i[i] & i2) != 0 || abs <= ((float) this.f1275b)) {
            return false;
        } else {
            return true;
        }
    }

    private boolean m2511a(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z;
        boolean z2;
        if (this.f1291r.m2088a(view) > 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.f1291r.m2095b(view) > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && z2) {
            if ((f * f) + (f2 * f2) <= ((float) (this.f1275b * this.f1275b))) {
                return false;
            }
            return true;
        } else if (z) {
            if (Math.abs(f) <= ((float) this.f1275b)) {
                return false;
            }
            return true;
        } else if (!z2) {
            return false;
        } else {
            if (Math.abs(f2) <= ((float) this.f1275b)) {
                return false;
            }
            return true;
        }
    }

    public boolean m2541d(int i) {
        int length = this.f1277d.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (m2533b(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean m2533b(int i, int i2) {
        if (!m2532b(i2)) {
            return false;
        }
        boolean z;
        boolean z2 = (i & 1) == 1;
        if ((i & 2) == 2) {
            z = true;
        } else {
            z = false;
        }
        float f = this.f1279f[i2] - this.f1277d[i2];
        float f2 = this.f1280g[i2] - this.f1278e[i2];
        if (z2 && z) {
            if ((f * f) + (f2 * f2) <= ((float) (this.f1275b * this.f1275b))) {
                return false;
            }
            return true;
        } else if (z2) {
            if (Math.abs(f) <= ((float) this.f1275b)) {
                return false;
            }
            return true;
        } else if (!z) {
            return false;
        } else {
            if (Math.abs(f2) <= ((float) this.f1275b)) {
                return false;
            }
            return true;
        }
    }

    private void m2521h() {
        this.f1285l.computeCurrentVelocity(1000, this.f1286m);
        m2507a(m2502a(VelocityTrackerCompat.m1342a(this.f1285l, this.f1276c), this.f1287n, this.f1286m), m2502a(VelocityTrackerCompat.m1343b(this.f1285l, this.f1276c), this.f1287n, this.f1286m));
    }

    private void m2515b(int i, int i2, int i3, int i4) {
        int a;
        int b;
        int left = this.f1292s.getLeft();
        int top = this.f1292s.getTop();
        if (i3 != 0) {
            a = this.f1291r.m2089a(this.f1292s, i, i3);
            this.f1292s.offsetLeftAndRight(a - left);
        } else {
            a = i;
        }
        if (i4 != 0) {
            b = this.f1291r.m2096b(this.f1292s, i2, i4);
            this.f1292s.offsetTopAndBottom(b - top);
        } else {
            b = i2;
        }
        if (i3 != 0 || i4 != 0) {
            this.f1291r.m2093a(this.f1292s, a, b, a - left, b - top);
        }
    }

    public boolean m2538c(int i, int i2) {
        return m2535b(this.f1292s, i, i2);
    }

    public boolean m2535b(View view, int i, int i2) {
        if (view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom()) {
            return true;
        }
        return false;
    }

    public View m2540d(int i, int i2) {
        for (int childCount = this.f1294u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f1294u.getChildAt(this.f1291r.m2100c(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    private int m2517e(int i, int i2) {
        int i3 = 0;
        if (i < this.f1294u.getLeft() + this.f1288o) {
            i3 = 1;
        }
        if (i2 < this.f1294u.getTop() + this.f1288o) {
            i3 |= 4;
        }
        if (i > this.f1294u.getRight() - this.f1288o) {
            i3 |= 2;
        }
        if (i2 > this.f1294u.getBottom() - this.f1288o) {
            return i3 | 8;
        }
        return i3;
    }
}
