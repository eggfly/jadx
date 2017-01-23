package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;

public class SwipeRefreshLayout extends ViewGroup implements NestedScrollingChild, NestedScrollingParent {
    private static final String f1230c;
    private static final int[] f1231w;
    private MaterialProgressDrawable f1232A;
    private Animation f1233B;
    private Animation f1234C;
    private Animation f1235D;
    private Animation f1236E;
    private Animation f1237F;
    private float f1238G;
    private boolean f1239H;
    private int f1240I;
    private int f1241J;
    private boolean f1242K;
    private AnimationListener f1243L;
    private final Animation f1244M;
    private final Animation f1245N;
    private final Animation f1246O;
    protected int f1247a;
    protected int f1248b;
    private View f1249d;
    private OnRefreshListener f1250e;
    private boolean f1251f;
    private int f1252g;
    private float f1253h;
    private float f1254i;
    private final NestedScrollingParentHelper f1255j;
    private final NestedScrollingChildHelper f1256k;
    private final int[] f1257l;
    private int f1258m;
    private int f1259n;
    private boolean f1260o;
    private float f1261p;
    private float f1262q;
    private boolean f1263r;
    private int f1264s;
    private boolean f1265t;
    private boolean f1266u;
    private final DecelerateInterpolator f1267v;
    private CircleImageView f1268x;
    private int f1269y;
    private float f1270z;

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout.1 */
    class C01221 implements AnimationListener {
        final /* synthetic */ SwipeRefreshLayout f1219a;

        C01221(SwipeRefreshLayout swipeRefreshLayout) {
            this.f1219a = swipeRefreshLayout;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            if (this.f1219a.f1251f) {
                this.f1219a.f1232A.setAlpha(255);
                this.f1219a.f1232A.start();
                if (this.f1219a.f1239H && this.f1219a.f1250e != null) {
                    this.f1219a.f1250e.m2465a();
                }
            } else {
                this.f1219a.f1232A.stop();
                this.f1219a.f1268x.setVisibility(8);
                this.f1219a.setColorViewAlpha(255);
                if (this.f1219a.f1265t) {
                    this.f1219a.setAnimationProgress(0.0f);
                } else {
                    this.f1219a.m2470a(this.f1219a.f1248b - this.f1219a.f1259n, true);
                }
            }
            this.f1219a.f1259n = this.f1219a.f1268x.getTop();
        }
    }

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout.2 */
    class C01232 extends Animation {
        final /* synthetic */ SwipeRefreshLayout f1220a;

        C01232(SwipeRefreshLayout swipeRefreshLayout) {
            this.f1220a = swipeRefreshLayout;
        }

        public void applyTransformation(float f, Transformation transformation) {
            this.f1220a.setAnimationProgress(f);
        }
    }

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout.3 */
    class C01243 extends Animation {
        final /* synthetic */ SwipeRefreshLayout f1221a;

        C01243(SwipeRefreshLayout swipeRefreshLayout) {
            this.f1221a = swipeRefreshLayout;
        }

        public void applyTransformation(float f, Transformation transformation) {
            this.f1221a.setAnimationProgress(1.0f - f);
        }
    }

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout.4 */
    class C01254 extends Animation {
        final /* synthetic */ int f1222a;
        final /* synthetic */ int f1223b;
        final /* synthetic */ SwipeRefreshLayout f1224c;

        C01254(SwipeRefreshLayout swipeRefreshLayout, int i, int i2) {
            this.f1224c = swipeRefreshLayout;
            this.f1222a = i;
            this.f1223b = i2;
        }

        public void applyTransformation(float f, Transformation transformation) {
            this.f1224c.f1232A.setAlpha((int) (((float) this.f1222a) + (((float) (this.f1223b - this.f1222a)) * f)));
        }
    }

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout.5 */
    class C01265 implements AnimationListener {
        final /* synthetic */ SwipeRefreshLayout f1225a;

        C01265(SwipeRefreshLayout swipeRefreshLayout) {
            this.f1225a = swipeRefreshLayout;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            if (!this.f1225a.f1265t) {
                this.f1225a.m2486b(null);
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout.6 */
    class C01276 extends Animation {
        final /* synthetic */ SwipeRefreshLayout f1226a;

        C01276(SwipeRefreshLayout swipeRefreshLayout) {
            this.f1226a = swipeRefreshLayout;
        }

        public void applyTransformation(float f, Transformation transformation) {
            int i;
            if (this.f1226a.f1242K) {
                i = (int) this.f1226a.f1238G;
            } else {
                i = (int) (this.f1226a.f1238G - ((float) Math.abs(this.f1226a.f1248b)));
            }
            this.f1226a.m2470a((((int) (((float) (i - this.f1226a.f1247a)) * f)) + this.f1226a.f1247a) - this.f1226a.f1268x.getTop(), false);
            this.f1226a.f1232A.m2278a(1.0f - f);
        }
    }

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout.7 */
    class C01287 extends Animation {
        final /* synthetic */ SwipeRefreshLayout f1227a;

        C01287(SwipeRefreshLayout swipeRefreshLayout) {
            this.f1227a = swipeRefreshLayout;
        }

        public void applyTransformation(float f, Transformation transformation) {
            int i;
            if (this.f1227a.f1242K) {
                i = (int) this.f1227a.f1238G;
            } else {
                i = (int) (this.f1227a.f1238G - ((float) Math.abs(this.f1227a.f1248b)));
            }
            this.f1227a.m2470a((((int) (((float) (i - this.f1227a.f1247a)) * f)) + this.f1227a.f1247a) - this.f1227a.f1268x.getTop(), false);
            this.f1227a.f1232A.m2278a(1.0f - f);
        }
    }

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout.8 */
    class C01298 extends Animation {
        final /* synthetic */ SwipeRefreshLayout f1228a;

        C01298(SwipeRefreshLayout swipeRefreshLayout) {
            this.f1228a = swipeRefreshLayout;
        }

        public void applyTransformation(float f, Transformation transformation) {
            this.f1228a.m2487c(f);
        }
    }

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout.9 */
    class C01309 extends Animation {
        final /* synthetic */ SwipeRefreshLayout f1229a;

        C01309(SwipeRefreshLayout swipeRefreshLayout) {
            this.f1229a = swipeRefreshLayout;
        }

        public void applyTransformation(float f, Transformation transformation) {
            this.f1229a.setAnimationProgress(this.f1229a.f1270z + ((-this.f1229a.f1270z) * f));
            this.f1229a.m2487c(f);
        }
    }

    public interface OnRefreshListener {
        void m2465a();
    }

    static {
        f1230c = SwipeRefreshLayout.class.getSimpleName();
        f1231w = new int[]{16842766};
    }

    private void setColorViewAlpha(int i) {
        this.f1268x.getBackground().setAlpha(i);
        this.f1232A.setAlpha(i);
    }

    public void setSize(int i) {
        if (i == 0 || i == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            int i2;
            if (i == 0) {
                i2 = (int) (displayMetrics.density * 56.0f);
                this.f1240I = i2;
                this.f1241J = i2;
            } else {
                i2 = (int) (displayMetrics.density * 40.0f);
                this.f1240I = i2;
                this.f1241J = i2;
            }
            this.f1268x.setImageDrawable(null);
            this.f1232A.m2280a(i);
            this.f1268x.setImageDrawable(this.f1232A);
        }
    }

    public SwipeRefreshLayout(Context context) {
        this(context, null);
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1251f = false;
        this.f1253h = -1.0f;
        this.f1257l = new int[2];
        this.f1260o = false;
        this.f1264s = -1;
        this.f1269y = -1;
        this.f1243L = new C01221(this);
        this.f1244M = new C01276(this);
        this.f1245N = new C01287(this);
        this.f1246O = new C01298(this);
        this.f1252g = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f1258m = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.f1267v = new DecelerateInterpolator(2.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1231w);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f1240I = (int) (displayMetrics.density * 40.0f);
        this.f1241J = (int) (displayMetrics.density * 40.0f);
        m2482b();
        ViewCompat.m1456a((ViewGroup) this, true);
        this.f1238G = displayMetrics.density * 64.0f;
        this.f1253h = this.f1238G;
        this.f1255j = new NestedScrollingParentHelper(this);
        this.f1256k = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.f1269y < 0) {
            return i2;
        }
        if (i2 == i - 1) {
            return this.f1269y;
        }
        if (i2 >= this.f1269y) {
            return i2 + 1;
        }
        return i2;
    }

    private void m2482b() {
        this.f1268x = new CircleImageView(getContext(), -328966, 20.0f);
        this.f1232A = new MaterialProgressDrawable(getContext(), this);
        this.f1232A.m2284b(-328966);
        this.f1268x.setImageDrawable(this.f1232A);
        this.f1268x.setVisibility(8);
        addView(this.f1268x);
    }

    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.f1250e = onRefreshListener;
    }

    private boolean m2489c() {
        return VERSION.SDK_INT < 11;
    }

    public void setRefreshing(boolean z) {
        if (!z || this.f1251f == z) {
            m2477a(z, false);
            return;
        }
        int i;
        this.f1251f = z;
        if (this.f1242K) {
            i = (int) this.f1238G;
        } else {
            i = (int) (this.f1238G + ((float) this.f1248b));
        }
        m2470a(i - this.f1259n, true);
        this.f1239H = false;
        m2476a(this.f1243L);
    }

    private void m2476a(AnimationListener animationListener) {
        this.f1268x.setVisibility(0);
        if (VERSION.SDK_INT >= 11) {
            this.f1232A.setAlpha(255);
        }
        this.f1233B = new C01232(this);
        this.f1233B.setDuration((long) this.f1258m);
        if (animationListener != null) {
            this.f1268x.m2045a(animationListener);
        }
        this.f1268x.clearAnimation();
        this.f1268x.startAnimation(this.f1233B);
    }

    private void setAnimationProgress(float f) {
        if (m2489c()) {
            setColorViewAlpha((int) (255.0f * f));
            return;
        }
        ViewCompat.m1446a(this.f1268x, f);
        ViewCompat.m1460b(this.f1268x, f);
    }

    private void m2477a(boolean z, boolean z2) {
        if (this.f1251f != z) {
            this.f1239H = z2;
            m2495f();
            this.f1251f = z;
            if (this.f1251f) {
                m2469a(this.f1259n, this.f1243L);
            } else {
                m2486b(this.f1243L);
            }
        }
    }

    private void m2486b(AnimationListener animationListener) {
        this.f1234C = new C01243(this);
        this.f1234C.setDuration(150);
        this.f1268x.m2045a(animationListener);
        this.f1268x.clearAnimation();
        this.f1268x.startAnimation(this.f1234C);
    }

    private void m2492d() {
        this.f1235D = m2467a(this.f1232A.getAlpha(), 76);
    }

    private void m2494e() {
        this.f1236E = m2467a(this.f1232A.getAlpha(), 255);
    }

    private Animation m2467a(int i, int i2) {
        if (this.f1265t && m2489c()) {
            return null;
        }
        Animation c01254 = new C01254(this, i, i2);
        c01254.setDuration(300);
        this.f1268x.m2045a(null);
        this.f1268x.clearAnimation();
        this.f1268x.startAnimation(c01254);
        return c01254;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i) {
        setProgressBackgroundColorSchemeResource(i);
    }

    public void setProgressBackgroundColorSchemeResource(@ColorRes int i) {
        setProgressBackgroundColorSchemeColor(getResources().getColor(i));
    }

    public void setProgressBackgroundColorSchemeColor(@ColorInt int i) {
        this.f1268x.setBackgroundColor(i);
        this.f1232A.m2284b(i);
    }

    @Deprecated
    public void setColorScheme(@ColorInt int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeResources(@ColorRes int... iArr) {
        Resources resources = getResources();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = resources.getColor(iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    @ColorInt
    public void setColorSchemeColors(int... iArr) {
        m2495f();
        this.f1232A.m2282a(iArr);
    }

    private void m2495f() {
        if (this.f1249d == null) {
            int i = 0;
            while (i < getChildCount()) {
                View childAt = getChildAt(i);
                if (childAt.equals(this.f1268x)) {
                    i++;
                } else {
                    this.f1249d = childAt;
                    return;
                }
            }
        }
    }

    public void setDistanceToTriggerSync(int i) {
        this.f1253h = (float) i;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.f1249d == null) {
                m2495f();
            }
            if (this.f1249d != null) {
                View view = this.f1249d;
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                measuredHeight = this.f1268x.getMeasuredWidth();
                this.f1268x.layout((measuredWidth / 2) - (measuredHeight / 2), this.f1259n, (measuredWidth / 2) + (measuredHeight / 2), this.f1259n + this.f1268x.getMeasuredHeight());
            }
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f1249d == null) {
            m2495f();
        }
        if (this.f1249d != null) {
            int i3;
            this.f1249d.measure(MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.f1268x.measure(MeasureSpec.makeMeasureSpec(this.f1240I, 1073741824), MeasureSpec.makeMeasureSpec(this.f1241J, 1073741824));
            if (!(this.f1242K || this.f1260o)) {
                this.f1260o = true;
                i3 = -this.f1268x.getMeasuredHeight();
                this.f1248b = i3;
                this.f1259n = i3;
            }
            this.f1269y = -1;
            for (i3 = 0; i3 < getChildCount(); i3++) {
                if (getChildAt(i3) == this.f1268x) {
                    this.f1269y = i3;
                    return;
                }
            }
        }
    }

    public int getProgressCircleDiameter() {
        return this.f1268x != null ? this.f1268x.getMeasuredHeight() : 0;
    }

    public boolean m2501a() {
        boolean z = false;
        if (VERSION.SDK_INT >= 14) {
            return ViewCompat.m1461b(this.f1249d, -1);
        }
        if (this.f1249d instanceof AbsListView) {
            AbsListView absListView = (AbsListView) this.f1249d;
            return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
        } else {
            if (ViewCompat.m1461b(this.f1249d, -1) || this.f1249d.getScrollY() > 0) {
                z = true;
            }
            return z;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        m2495f();
        int a = MotionEventCompat.m1283a(motionEvent);
        if (this.f1266u && a == 0) {
            this.f1266u = false;
        }
        if (!isEnabled() || this.f1266u || m2501a() || this.f1251f) {
            return false;
        }
        float a2;
        switch (a) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                m2470a(this.f1248b - this.f1268x.getTop(), true);
                this.f1264s = MotionEventCompat.m1286b(motionEvent, 0);
                this.f1263r = false;
                a2 = m2466a(motionEvent, this.f1264s);
                if (a2 != -1.0f) {
                    this.f1262q = a2;
                    break;
                }
                return false;
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                this.f1263r = false;
                this.f1264s = -1;
                break;
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                if (this.f1264s == -1) {
                    Log.e(f1230c, "Got ACTION_MOVE event but don't have an active pointer id.");
                    return false;
                }
                a2 = m2466a(motionEvent, this.f1264s);
                if (a2 != -1.0f) {
                    if (a2 - this.f1262q > ((float) this.f1252g) && !this.f1263r) {
                        this.f1261p = this.f1262q + ((float) this.f1252g);
                        this.f1263r = true;
                        this.f1232A.setAlpha(76);
                        break;
                    }
                }
                return false;
            case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                m2475a(motionEvent);
                break;
        }
        return this.f1263r;
    }

    private float m2466a(MotionEvent motionEvent, int i) {
        int a = MotionEventCompat.m1284a(motionEvent, i);
        if (a < 0) {
            return -1.0f;
        }
        return MotionEventCompat.m1289d(motionEvent, a);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (VERSION.SDK_INT < 21 && (this.f1249d instanceof AbsListView)) {
            return;
        }
        if (this.f1249d == null || ViewCompat.m1474m(this.f1249d)) {
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        if (!isEnabled() || (i & 2) == 0) {
            return false;
        }
        startNestedScroll(i & 2);
        return true;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f1255j.m1310a(view, view2, i);
        this.f1254i = 0.0f;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0 && this.f1254i > 0.0f) {
            if (((float) i2) > this.f1254i) {
                iArr[1] = i2 - ((int) this.f1254i);
                this.f1254i = 0.0f;
            } else {
                this.f1254i -= (float) i2;
                iArr[1] = i2;
            }
            m2468a(this.f1254i);
        }
        int[] iArr2 = this.f1257l;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr2[1] + iArr[1];
        }
    }

    public int getNestedScrollAxes() {
        return this.f1255j.m1308a();
    }

    public void onStopNestedScroll(View view) {
        this.f1255j.m1309a(view);
        if (this.f1254i > 0.0f) {
            m2483b(this.f1254i);
            this.f1254i = 0.0f;
        }
        stopNestedScroll();
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        if (i4 < 0) {
            this.f1254i = ((float) Math.abs(i4)) + this.f1254i;
            m2468a(this.f1254i);
        }
        dispatchNestedScroll(i, i2, i3, i, null);
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return false;
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f1256k.m1299a(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.f1256k.m1300a();
    }

    public boolean startNestedScroll(int i) {
        return this.f1256k.m1303a(i);
    }

    public void stopNestedScroll() {
        this.f1256k.m1307c();
    }

    public boolean hasNestedScrollingParent() {
        return this.f1256k.m1306b();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f1256k.m1304a(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f1256k.m1305a(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f1256k.m1302a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f1256k.m1301a(f, f2);
    }

    private boolean m2479a(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void m2468a(float f) {
        this.f1232A.m2281a(true);
        float min = Math.min(1.0f, Math.abs(f / this.f1253h));
        float max = (((float) Math.max(((double) min) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f) - this.f1253h;
        float f2 = this.f1242K ? this.f1238G - ((float) this.f1248b) : this.f1238G;
        abs = Math.max(0.0f, Math.min(abs, f2 * 2.0f) / f2);
        abs = ((float) (((double) (abs / 4.0f)) - Math.pow((double) (abs / 4.0f), 2.0d))) * 2.0f;
        int i = ((int) ((f2 * min) + ((f2 * abs) * 2.0f))) + this.f1248b;
        if (this.f1268x.getVisibility() != 0) {
            this.f1268x.setVisibility(0);
        }
        if (!this.f1265t) {
            ViewCompat.m1446a(this.f1268x, 1.0f);
            ViewCompat.m1460b(this.f1268x, 1.0f);
        }
        if (f < this.f1253h) {
            if (this.f1265t) {
                setAnimationProgress(f / this.f1253h);
            }
            if (this.f1232A.getAlpha() > 76 && !m2479a(this.f1235D)) {
                m2492d();
            }
            this.f1232A.m2279a(0.0f, Math.min(0.8f, max * 0.8f));
            this.f1232A.m2278a(Math.min(1.0f, max));
        } else if (this.f1232A.getAlpha() < 255 && !m2479a(this.f1236E)) {
            m2494e();
        }
        this.f1232A.m2283b(((-0.25f + (max * 0.4f)) + (abs * 2.0f)) * 0.5f);
        m2470a(i - this.f1259n, true);
    }

    private void m2483b(float f) {
        if (f > this.f1253h) {
            m2477a(true, true);
            return;
        }
        this.f1251f = false;
        this.f1232A.m2279a(0.0f, 0.0f);
        AnimationListener animationListener = null;
        if (!this.f1265t) {
            animationListener = new C01265(this);
        }
        m2484b(this.f1259n, animationListener);
        this.f1232A.m2281a(false);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = MotionEventCompat.m1283a(motionEvent);
        if (this.f1266u && a == 0) {
            this.f1266u = false;
        }
        if (!isEnabled() || this.f1266u || m2501a()) {
            return false;
        }
        switch (a) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                this.f1264s = MotionEventCompat.m1286b(motionEvent, 0);
                this.f1263r = false;
                break;
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                if (this.f1264s != -1) {
                    float d = (MotionEventCompat.m1289d(motionEvent, MotionEventCompat.m1284a(motionEvent, this.f1264s)) - this.f1261p) * 0.5f;
                    this.f1263r = false;
                    m2483b(d);
                    this.f1264s = -1;
                    return false;
                } else if (a != 1) {
                    return false;
                } else {
                    Log.e(f1230c, "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                a = MotionEventCompat.m1284a(motionEvent, this.f1264s);
                if (a < 0) {
                    Log.e(f1230c, "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                float d2 = (MotionEventCompat.m1289d(motionEvent, a) - this.f1261p) * 0.5f;
                if (this.f1263r) {
                    if (d2 > 0.0f) {
                        m2468a(d2);
                        break;
                    }
                    return false;
                }
                break;
            case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                this.f1264s = MotionEventCompat.m1286b(motionEvent, MotionEventCompat.m1285b(motionEvent));
                break;
            case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                m2475a(motionEvent);
                break;
        }
        return true;
    }

    private void m2469a(int i, AnimationListener animationListener) {
        this.f1247a = i;
        this.f1244M.reset();
        this.f1244M.setDuration(200);
        this.f1244M.setInterpolator(this.f1267v);
        if (animationListener != null) {
            this.f1268x.m2045a(animationListener);
        }
        this.f1268x.clearAnimation();
        this.f1268x.startAnimation(this.f1244M);
    }

    private void m2484b(int i, AnimationListener animationListener) {
        if (this.f1265t) {
            m2488c(i, animationListener);
            return;
        }
        this.f1247a = i;
        this.f1246O.reset();
        this.f1246O.setDuration(200);
        this.f1246O.setInterpolator(this.f1267v);
        if (animationListener != null) {
            this.f1268x.m2045a(animationListener);
        }
        this.f1268x.clearAnimation();
        this.f1268x.startAnimation(this.f1246O);
    }

    private void m2487c(float f) {
        m2470a((this.f1247a + ((int) (((float) (this.f1248b - this.f1247a)) * f))) - this.f1268x.getTop(), false);
    }

    private void m2488c(int i, AnimationListener animationListener) {
        this.f1247a = i;
        if (m2489c()) {
            this.f1270z = (float) this.f1232A.getAlpha();
        } else {
            this.f1270z = ViewCompat.m1470i(this.f1268x);
        }
        this.f1237F = new C01309(this);
        this.f1237F.setDuration(150);
        if (animationListener != null) {
            this.f1268x.m2045a(animationListener);
        }
        this.f1268x.clearAnimation();
        this.f1268x.startAnimation(this.f1237F);
    }

    private void m2470a(int i, boolean z) {
        this.f1268x.bringToFront();
        this.f1268x.offsetTopAndBottom(i);
        this.f1259n = this.f1268x.getTop();
        if (z && VERSION.SDK_INT < 11) {
            invalidate();
        }
    }

    private void m2475a(MotionEvent motionEvent) {
        int b = MotionEventCompat.m1285b(motionEvent);
        if (MotionEventCompat.m1286b(motionEvent, b) == this.f1264s) {
            this.f1264s = MotionEventCompat.m1286b(motionEvent, b == 0 ? 1 : 0);
        }
    }
}
