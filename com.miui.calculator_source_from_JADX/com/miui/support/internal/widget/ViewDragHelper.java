package com.miui.support.internal.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import java.util.Arrays;

public class ViewDragHelper {
    private static final Interpolator f3256v;
    private int f3257a;
    private int f3258b;
    private int f3259c;
    private float[] f3260d;
    private float[] f3261e;
    private float[] f3262f;
    private float[] f3263g;
    private int[] f3264h;
    private int[] f3265i;
    private int[] f3266j;
    private int f3267k;
    private VelocityTracker f3268l;
    private float f3269m;
    private float f3270n;
    private int f3271o;
    private int f3272p;
    private Scroller f3273q;
    private final Callback f3274r;
    private View f3275s;
    private boolean f3276t;
    private final ViewGroup f3277u;
    private final Runnable f3278w;

    /* renamed from: com.miui.support.internal.widget.ViewDragHelper.1 */
    final class C03971 implements Interpolator {
        C03971() {
        }

        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    }

    /* renamed from: com.miui.support.internal.widget.ViewDragHelper.2 */
    class C03982 implements Runnable {
        final /* synthetic */ ViewDragHelper f3255a;

        C03982(ViewDragHelper viewDragHelper) {
            this.f3255a = viewDragHelper;
        }

        public void run() {
            this.f3255a.m4987c(0);
        }
    }

    public static abstract class Callback {
        public abstract boolean m4950b(View view, int i);

        public void m4941a(int i) {
        }

        public void m4945a(View view, int i, int i2, int i3, int i4) {
        }

        public void m4944a(View view, int i) {
        }

        public void m4943a(View view, float f, float f2) {
        }

        public void m4942a(int i, int i2) {
        }

        public boolean m4949b(int i) {
            return false;
        }

        public void m4948b(int i, int i2) {
        }

        public int m4951c(int i) {
            return i;
        }

        public int m4939a(View view) {
            return 0;
        }

        public int m4946b(View view) {
            return 0;
        }

        public int m4940a(View view, int i, int i2) {
            return 0;
        }

        public int m4947b(View view, int i, int i2) {
            return 0;
        }
    }

    static {
        f3256v = new C03971();
    }

    public static ViewDragHelper m4956a(ViewGroup viewGroup, Callback callback) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, callback);
    }

    public static ViewDragHelper m4955a(ViewGroup viewGroup, float f, Callback callback) {
        ViewDragHelper a = m4956a(viewGroup, callback);
        a.f3258b = (int) (((float) a.f3258b) * (1.0f / f));
        return a;
    }

    private ViewDragHelper(Context context, ViewGroup viewGroup, Callback callback) {
        this.f3259c = -1;
        this.f3278w = new C03982(this);
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (callback == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.f3277u = viewGroup;
            this.f3274r = callback;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.f3271o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f3258b = viewConfiguration.getScaledTouchSlop();
            this.f3269m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.f3270n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.f3273q = new Scroller(context, f3256v);
        }
    }

    public void m4973a(float f) {
        this.f3270n = f;
    }

    public void m4974a(int i) {
        this.f3272p = i;
    }

    public int m4972a() {
        return this.f3271o;
    }

    public void m4975a(View view, int i) {
        if (view.getParent() != this.f3277u) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f3277u + ")");
        }
        this.f3275s = view;
        this.f3259c = i;
        this.f3274r.m4944a(view, i);
        m4987c(1);
    }

    public int m4980b() {
        return this.f3258b;
    }

    public void m4986c() {
        this.f3259c = -1;
        m4967d();
        if (this.f3268l != null) {
            this.f3268l.recycle();
            this.f3268l = null;
        }
    }

    public boolean m4978a(View view, int i, int i2) {
        this.f3275s = view;
        this.f3259c = -1;
        return m4960a(i, i2, 0, 0);
    }

    public boolean m4976a(int i, int i2) {
        if (this.f3276t) {
            return m4960a(i, i2, (int) this.f3268l.getXVelocity(this.f3259c), (int) this.f3268l.getYVelocity(this.f3259c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    private boolean m4960a(int i, int i2, int i3, int i4) {
        int left = this.f3275s.getLeft();
        int top = this.f3275s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.f3273q.abortAnimation();
            m4987c(0);
            return false;
        }
        this.f3273q.startScroll(left, top, i5, i6, m4954a(this.f3275s, i5, i6, i3, i4));
        m4987c(2);
        return true;
    }

    private int m4954a(View view, int i, int i2, int i3, int i4) {
        int b = m4963b(i3, (int) this.f3270n, (int) this.f3269m);
        int b2 = m4963b(i4, (int) this.f3270n, (int) this.f3269m);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(b);
        int abs4 = Math.abs(b2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        return (int) (((b2 != 0 ? ((float) abs4) / ((float) i5) : ((float) abs2) / ((float) i6)) * ((float) m4953a(i2, b2, this.f3274r.m4946b(view)))) + ((b != 0 ? ((float) abs3) / ((float) i5) : ((float) abs) / ((float) i6)) * ((float) m4953a(i, b, this.f3274r.m4939a(view)))));
    }

    private int m4953a(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.f3277u.getWidth();
        int i4 = width / 2;
        float b = (m4962b(Math.min(1.0f, ((float) Math.abs(i)) / ((float) width))) * ((float) i4)) + ((float) i4);
        i4 = Math.abs(i2);
        if (i4 > 0) {
            width = Math.round(Math.abs(b / ((float) i4)) * 1000.0f) * 4;
        } else {
            width = (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f);
        }
        return Math.min(width, 600);
    }

    private int m4963b(int i, int i2, int i3) {
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

    private float m4952a(float f, float f2, float f3) {
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

    private float m4962b(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    public boolean m4979a(boolean z) {
        if (this.f3257a == 2) {
            boolean isFinished;
            boolean computeScrollOffset = this.f3273q.computeScrollOffset();
            int currX = this.f3273q.getCurrX();
            int currY = this.f3273q.getCurrY();
            int left = currX - this.f3275s.getLeft();
            int top = currY - this.f3275s.getTop();
            if (left != 0) {
                this.f3275s.offsetLeftAndRight(left);
            }
            if (top != 0) {
                this.f3275s.offsetTopAndBottom(top);
            }
            if (!(left == 0 && top == 0)) {
                this.f3274r.m4945a(this.f3275s, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.f3273q.getFinalX() && currY == this.f3273q.getFinalY()) {
                this.f3273q.abortAnimation();
                isFinished = this.f3273q.isFinished();
            } else {
                isFinished = computeScrollOffset;
            }
            if (!isFinished) {
                if (z) {
                    this.f3277u.post(this.f3278w);
                } else {
                    m4987c(0);
                }
            }
        }
        return this.f3257a == 2;
    }

    private void m4957a(float f, float f2) {
        this.f3276t = true;
        this.f3274r.m4943a(this.f3275s, f, f2);
        this.f3276t = false;
        if (this.f3257a == 1) {
            m4987c(0);
        }
    }

    private void m4967d() {
        if (this.f3260d != null) {
            Arrays.fill(this.f3260d, 0.0f);
            Arrays.fill(this.f3261e, 0.0f);
            Arrays.fill(this.f3262f, 0.0f);
            Arrays.fill(this.f3263g, 0.0f);
            Arrays.fill(this.f3264h, 0);
            Arrays.fill(this.f3265i, 0);
            Arrays.fill(this.f3266j, 0);
            this.f3267k = 0;
        }
    }

    private void m4970f(int i) {
        if (this.f3260d != null) {
            this.f3260d[i] = 0.0f;
            this.f3261e[i] = 0.0f;
            this.f3262f[i] = 0.0f;
            this.f3263g[i] = 0.0f;
            this.f3264h[i] = 0;
            this.f3265i[i] = 0;
            this.f3266j[i] = 0;
            this.f3267k &= (1 << i) ^ -1;
        }
    }

    private void m4971g(int i) {
        if (this.f3260d == null || this.f3260d.length <= i) {
            Object obj = new float[(i + 1)];
            Object obj2 = new float[(i + 1)];
            Object obj3 = new float[(i + 1)];
            Object obj4 = new float[(i + 1)];
            Object obj5 = new int[(i + 1)];
            Object obj6 = new int[(i + 1)];
            Object obj7 = new int[(i + 1)];
            if (this.f3260d != null) {
                System.arraycopy(this.f3260d, 0, obj, 0, this.f3260d.length);
                System.arraycopy(this.f3261e, 0, obj2, 0, this.f3261e.length);
                System.arraycopy(this.f3262f, 0, obj3, 0, this.f3262f.length);
                System.arraycopy(this.f3263g, 0, obj4, 0, this.f3263g.length);
                System.arraycopy(this.f3264h, 0, obj5, 0, this.f3264h.length);
                System.arraycopy(this.f3265i, 0, obj6, 0, this.f3265i.length);
                System.arraycopy(this.f3266j, 0, obj7, 0, this.f3266j.length);
            }
            this.f3260d = obj;
            this.f3261e = obj2;
            this.f3262f = obj3;
            this.f3263g = obj4;
            this.f3264h = obj5;
            this.f3265i = obj6;
            this.f3266j = obj7;
        }
    }

    private void m4958a(float f, float f2, int i) {
        m4971g(i);
        float[] fArr = this.f3260d;
        this.f3262f[i] = f;
        fArr[i] = f;
        fArr = this.f3261e;
        this.f3263g[i] = f2;
        fArr[i] = f2;
        this.f3264h[i] = m4969f((int) f, (int) f2);
        this.f3267k |= 1 << i;
    }

    private void m4966c(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            float x = motionEvent.getX(i);
            float y = motionEvent.getY(i);
            this.f3262f[pointerId] = x;
            this.f3263g[pointerId] = y;
        }
    }

    public boolean m4982b(int i) {
        return (this.f3267k & (1 << i)) != 0;
    }

    void m4987c(int i) {
        if (this.f3257a != i) {
            this.f3257a = i;
            this.f3274r.m4941a(i);
            if (i == 0) {
                this.f3275s = null;
            }
        }
    }

    boolean m4984b(View view, int i) {
        if (view == this.f3275s && this.f3259c == i) {
            return true;
        }
        if (view == null || !this.f3274r.m4950b(view, i)) {
            return false;
        }
        this.f3259c = i;
        m4975a(view, i);
        return true;
    }

    public boolean m4977a(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            m4986c();
        }
        if (this.f3268l == null) {
            this.f3268l = VelocityTracker.obtain();
        }
        this.f3268l.addMovement(motionEvent);
        float y;
        int pointerId;
        switch (actionMasked) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                float x = motionEvent.getX();
                y = motionEvent.getY();
                pointerId = motionEvent.getPointerId(0);
                m4958a(x, y, pointerId);
                View e = m4991e((int) x, (int) y);
                if (e == this.f3275s && this.f3257a == 2) {
                    m4984b(e, pointerId);
                }
                actionMasked = this.f3264h[pointerId];
                if ((this.f3272p & actionMasked) != 0) {
                    this.f3274r.m4942a(actionMasked & this.f3272p, pointerId);
                    break;
                }
                break;
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                m4986c();
                break;
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                actionIndex = motionEvent.getPointerCount();
                actionMasked = 0;
                while (actionMasked < actionIndex) {
                    pointerId = motionEvent.getPointerId(actionMasked);
                    float x2 = motionEvent.getX(actionMasked);
                    float y2 = motionEvent.getY(actionMasked);
                    float f = x2 - this.f3260d[pointerId];
                    float f2 = y2 - this.f3261e[pointerId];
                    m4964b(f, f2, pointerId);
                    if (this.f3257a != 1) {
                        View e2 = m4991e((int) x2, (int) y2);
                        if (e2 == null || !m4961a(e2, f, f2) || !m4984b(e2, pointerId)) {
                            actionMasked++;
                        }
                    }
                    m4966c(motionEvent);
                    break;
                }
                m4966c(motionEvent);
                break;
            case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                actionMasked = motionEvent.getPointerId(actionIndex);
                float x3 = motionEvent.getX(actionIndex);
                y = motionEvent.getY(actionIndex);
                m4958a(x3, y, actionMasked);
                if (this.f3257a != 0) {
                    if (this.f3257a == 2) {
                        View e3 = m4991e((int) x3, (int) y);
                        if (e3 == this.f3275s) {
                            m4984b(e3, actionMasked);
                            break;
                        }
                    }
                }
                actionIndex = this.f3264h[actionMasked];
                if ((this.f3272p & actionIndex) != 0) {
                    this.f3274r.m4942a(actionIndex & this.f3272p, actionMasked);
                    break;
                }
                break;
            case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                m4970f(motionEvent.getPointerId(actionIndex));
                break;
        }
        if (this.f3257a == 1) {
            return true;
        }
        return false;
    }

    public void m4981b(MotionEvent motionEvent) {
        int i = 0;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            m4986c();
        }
        if (this.f3268l == null) {
            this.f3268l = VelocityTracker.obtain();
        }
        this.f3268l.addMovement(motionEvent);
        float x;
        float y;
        View e;
        int i2;
        switch (actionMasked) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                x = motionEvent.getX();
                y = motionEvent.getY();
                i = motionEvent.getPointerId(0);
                e = m4991e((int) x, (int) y);
                m4958a(x, y, i);
                m4984b(e, i);
                i2 = this.f3264h[i];
                if ((this.f3272p & i2) != 0) {
                    this.f3274r.m4942a(i2 & this.f3272p, i);
                }
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                if (this.f3257a == 1) {
                    m4968e();
                }
                m4986c();
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                if (this.f3257a == 1) {
                    i = motionEvent.findPointerIndex(this.f3259c);
                    if (i >= 0 && i < motionEvent.getPointerCount()) {
                        x = motionEvent.getX(i);
                        i2 = (int) (x - this.f3262f[this.f3259c]);
                        i = (int) (motionEvent.getY(i) - this.f3263g[this.f3259c]);
                        m4965b(this.f3275s.getLeft() + i2, this.f3275s.getTop() + i, i2, i);
                        m4966c(motionEvent);
                        return;
                    }
                    return;
                }
                i2 = motionEvent.getPointerCount();
                while (i < i2) {
                    actionMasked = motionEvent.getPointerId(i);
                    float x2 = motionEvent.getX(i);
                    float y2 = motionEvent.getY(i);
                    float f = x2 - this.f3260d[actionMasked];
                    float f2 = y2 - this.f3261e[actionMasked];
                    m4964b(f, f2, actionMasked);
                    if (this.f3257a != 1) {
                        e = m4991e((int) x2, (int) y2);
                        if (!m4961a(e, f, f2) || !m4984b(e, actionMasked)) {
                            i++;
                        }
                    }
                    m4966c(motionEvent);
                }
                m4966c(motionEvent);
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                if (this.f3257a == 1) {
                    m4957a(0.0f, 0.0f);
                }
                m4986c();
            case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                i = motionEvent.getPointerId(actionIndex);
                x = motionEvent.getX(actionIndex);
                y = motionEvent.getY(actionIndex);
                m4958a(x, y, i);
                if (this.f3257a == 0) {
                    m4984b(m4991e((int) x, (int) y), i);
                    i2 = this.f3264h[i];
                    if ((this.f3272p & i2) != 0) {
                        this.f3274r.m4942a(i2 & this.f3272p, i);
                    }
                } else if (m4990d((int) x, (int) y)) {
                    m4984b(this.f3275s, i);
                }
            case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                actionMasked = motionEvent.getPointerId(actionIndex);
                if (this.f3257a == 1 && actionMasked == this.f3259c) {
                    actionIndex = motionEvent.getPointerCount();
                    while (i < actionIndex) {
                        int pointerId = motionEvent.getPointerId(i);
                        if (pointerId != this.f3259c) {
                            if (m4991e((int) motionEvent.getX(i), (int) motionEvent.getY(i)) == this.f3275s && m4984b(this.f3275s, pointerId)) {
                                i = this.f3259c;
                                if (i == -1) {
                                    m4968e();
                                }
                            }
                        }
                        i++;
                    }
                    i = -1;
                    if (i == -1) {
                        m4968e();
                    }
                }
                m4970f(actionMasked);
            default:
        }
    }

    private void m4964b(float f, float f2, int i) {
        int i2 = 1;
        if (!m4959a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (m4959a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (m4959a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (m4959a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.f3265i;
            iArr[i] = iArr[i] | i2;
            this.f3274r.m4948b(i2, i);
        }
    }

    private boolean m4959a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.f3264h[i] & i2) != i2 || (this.f3272p & i2) == 0 || (this.f3266j[i] & i2) == i2 || (this.f3265i[i] & i2) == i2) {
            return false;
        }
        if (abs <= ((float) this.f3258b) && abs2 <= ((float) this.f3258b)) {
            return false;
        }
        if (abs < abs2 * 0.5f && this.f3274r.m4949b(i2)) {
            int[] iArr = this.f3266j;
            iArr[i] = iArr[i] | i2;
            return false;
        } else if ((this.f3265i[i] & i2) != 0 || abs <= ((float) this.f3258b)) {
            return false;
        } else {
            return true;
        }
    }

    private boolean m4961a(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z;
        boolean z2;
        if (this.f3274r.m4939a(view) > 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.f3274r.m4946b(view) > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && z2) {
            if ((f * f) + (f2 * f2) <= ((float) (this.f3258b * this.f3258b))) {
                return false;
            }
            return true;
        } else if (z) {
            if (Math.abs(f2) >= ((float) this.f3258b) || Math.abs(f) <= ((float) this.f3258b)) {
                return false;
            }
            return true;
        } else if (!z2) {
            return false;
        } else {
            if (Math.abs(f) >= ((float) this.f3258b) || Math.abs(f2) <= ((float) this.f3258b)) {
                return false;
            }
            return true;
        }
    }

    public boolean m4989d(int i) {
        int length = this.f3260d.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (m4983b(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean m4983b(int i, int i2) {
        if (!m4982b(i2)) {
            return false;
        }
        boolean z;
        boolean z2 = (i & 1) == 1;
        if ((i & 2) == 2) {
            z = true;
        } else {
            z = false;
        }
        float f = this.f3262f[i2] - this.f3260d[i2];
        float f2 = this.f3263g[i2] - this.f3261e[i2];
        if (z2 && z) {
            if ((f * f) + (f2 * f2) <= ((float) (this.f3258b * this.f3258b))) {
                return false;
            }
            return true;
        } else if (z2) {
            if (Math.abs(f) <= ((float) this.f3258b)) {
                return false;
            }
            return true;
        } else if (!z) {
            return false;
        } else {
            if (Math.abs(f2) <= ((float) this.f3258b)) {
                return false;
            }
            return true;
        }
    }

    public boolean m4992e(int i) {
        int length = this.f3264h.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (m4988c(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean m4988c(int i, int i2) {
        return m4982b(i2) && (this.f3264h[i2] & i) != 0;
    }

    private void m4968e() {
        this.f3268l.computeCurrentVelocity(1000, this.f3269m);
        m4957a(m4952a(this.f3268l.getXVelocity(this.f3259c), this.f3270n, this.f3269m), m4952a(this.f3268l.getYVelocity(this.f3259c), this.f3270n, this.f3269m));
    }

    private void m4965b(int i, int i2, int i3, int i4) {
        int a;
        int b;
        int left = this.f3275s.getLeft();
        int top = this.f3275s.getTop();
        if (i3 != 0) {
            a = this.f3274r.m4940a(this.f3275s, i, i3);
            this.f3275s.offsetLeftAndRight(a - left);
        } else {
            a = i;
        }
        if (i4 != 0) {
            b = this.f3274r.m4947b(this.f3275s, i2, i4);
            this.f3275s.offsetTopAndBottom(b - top);
        } else {
            b = i2;
        }
        if (i3 != 0 || i4 != 0) {
            this.f3274r.m4945a(this.f3275s, a, b, a - left, b - top);
        }
    }

    public boolean m4990d(int i, int i2) {
        return m4985b(this.f3275s, i, i2);
    }

    public boolean m4985b(View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    public View m4991e(int i, int i2) {
        for (int childCount = this.f3277u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f3277u.getChildAt(this.f3274r.m4951c(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    private int m4969f(int i, int i2) {
        int i3 = 0;
        if (i < this.f3277u.getLeft() + this.f3271o) {
            i3 = 1;
        }
        if (i2 < this.f3277u.getTop() + this.f3271o) {
            i3 |= 4;
        }
        if (i > this.f3277u.getRight() - this.f3271o) {
            i3 |= 2;
        }
        if (i2 > this.f3277u.getBottom() - this.f3271o) {
            return i3 | 8;
        }
        return i3;
    }
}
