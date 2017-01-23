package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.n;
import android.support.v4.view.r;
import android.support.v4.view.s;
import android.support.v4.view.t;
import android.support.v4.view.u;
import android.support.v4.view.z;
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
import com.aide.uidesigner.ProxyTextView;

public class SwipeRefreshLayout extends ViewGroup implements r, t {
    private static final String FH;
    private static final int[] lg;
    private Animation BT;
    protected int DW;
    private final s EQ;
    private View Hw;
    private int J0;
    private int J8;
    private boolean KD;
    private boolean Mr;
    private Animation P8;
    private float QX;
    private float SI;
    private boolean U2;
    private int VH;
    private boolean Ws;
    private float XL;
    private boolean Zo;
    private final DecelerateInterpolator a8;
    private boolean aM;
    private AnimationListener cb;
    private int cn;
    private final Animation dx;
    private final Animation ef;
    private Animation ei;
    private int er;
    private f gW;
    private float gn;
    private int j3;
    protected int j6;
    private Animation nw;
    private a rN;
    private int ro;
    private final Animation sG;
    private boolean sh;
    private final u tp;
    private float u7;
    private a v5;
    private Animation vy;
    private final int[] we;
    private float yS;

    class 1 implements AnimationListener {
        final /* synthetic */ SwipeRefreshLayout j6;

        1(SwipeRefreshLayout swipeRefreshLayout) {
            this.j6 = swipeRefreshLayout;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            if (this.j6.Zo) {
                this.j6.gW.setAlpha(255);
                this.j6.gW.start();
                if (this.j6.KD && this.j6.v5 != null) {
                    this.j6.v5.j6();
                }
            } else {
                this.j6.gW.stop();
                this.j6.rN.setVisibility(8);
                this.j6.setColorViewAlpha(255);
                if (this.j6.Mr) {
                    this.j6.setAnimationProgress(0.0f);
                } else {
                    this.j6.j6(this.j6.DW - this.j6.J8, true);
                }
            }
            this.j6.J8 = this.j6.rN.getTop();
        }
    }

    class 2 extends Animation {
        final /* synthetic */ SwipeRefreshLayout j6;

        2(SwipeRefreshLayout swipeRefreshLayout) {
            this.j6 = swipeRefreshLayout;
        }

        public void applyTransformation(float f, Transformation transformation) {
            this.j6.setAnimationProgress(f);
        }
    }

    class 3 extends Animation {
        final /* synthetic */ SwipeRefreshLayout j6;

        3(SwipeRefreshLayout swipeRefreshLayout) {
            this.j6 = swipeRefreshLayout;
        }

        public void applyTransformation(float f, Transformation transformation) {
            this.j6.setAnimationProgress(1.0f - f);
        }
    }

    class 4 extends Animation {
        final /* synthetic */ int DW;
        final /* synthetic */ SwipeRefreshLayout FH;
        final /* synthetic */ int j6;

        4(SwipeRefreshLayout swipeRefreshLayout, int i, int i2) {
            this.FH = swipeRefreshLayout;
            this.j6 = i;
            this.DW = i2;
        }

        public void applyTransformation(float f, Transformation transformation) {
            this.FH.gW.setAlpha((int) (((float) this.j6) + (((float) (this.DW - this.j6)) * f)));
        }
    }

    class 5 implements AnimationListener {
        final /* synthetic */ SwipeRefreshLayout j6;

        5(SwipeRefreshLayout swipeRefreshLayout) {
            this.j6 = swipeRefreshLayout;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            if (!this.j6.Mr) {
                this.j6.DW(null);
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    class 6 extends Animation {
        final /* synthetic */ SwipeRefreshLayout j6;

        6(SwipeRefreshLayout swipeRefreshLayout) {
            this.j6 = swipeRefreshLayout;
        }

        public void applyTransformation(float f, Transformation transformation) {
            int u7;
            if (this.j6.sh) {
                u7 = (int) this.j6.SI;
            } else {
                u7 = (int) (this.j6.SI - ((float) Math.abs(this.j6.DW)));
            }
            this.j6.j6((((int) (((float) (u7 - this.j6.j6)) * f)) + this.j6.j6) - this.j6.rN.getTop(), false);
            this.j6.gW.j6(1.0f - f);
        }
    }

    class 7 extends Animation {
        final /* synthetic */ SwipeRefreshLayout j6;

        7(SwipeRefreshLayout swipeRefreshLayout) {
            this.j6 = swipeRefreshLayout;
        }

        public void applyTransformation(float f, Transformation transformation) {
            int u7;
            if (this.j6.sh) {
                u7 = (int) this.j6.SI;
            } else {
                u7 = (int) (this.j6.SI - ((float) Math.abs(this.j6.DW)));
            }
            this.j6.j6((((int) (((float) (u7 - this.j6.j6)) * f)) + this.j6.j6) - this.j6.rN.getTop(), false);
            this.j6.gW.j6(1.0f - f);
        }
    }

    class 8 extends Animation {
        final /* synthetic */ SwipeRefreshLayout j6;

        8(SwipeRefreshLayout swipeRefreshLayout) {
            this.j6 = swipeRefreshLayout;
        }

        public void applyTransformation(float f, Transformation transformation) {
            this.j6.FH(f);
        }
    }

    class 9 extends Animation {
        final /* synthetic */ SwipeRefreshLayout j6;

        9(SwipeRefreshLayout swipeRefreshLayout) {
            this.j6 = swipeRefreshLayout;
        }

        public void applyTransformation(float f, Transformation transformation) {
            this.j6.setAnimationProgress(this.j6.yS + ((-this.j6.yS) * f));
            this.j6.FH(f);
        }
    }

    public interface a {
        void j6();
    }

    static {
        FH = SwipeRefreshLayout.class.getSimpleName();
        lg = new int[]{16842766};
    }

    private void setColorViewAlpha(int i) {
        this.rN.getBackground().setAlpha(i);
        this.gW.setAlpha(i);
    }

    public void setSize(int i) {
        if (i == 0 || i == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            int i2;
            if (i == 0) {
                i2 = (int) (displayMetrics.density * 56.0f);
                this.ro = i2;
                this.cn = i2;
            } else {
                i2 = (int) (displayMetrics.density * 40.0f);
                this.ro = i2;
                this.cn = i2;
            }
            this.rN.setImageDrawable(null);
            this.gW.j6(i);
            this.rN.setImageDrawable(this.gW);
        }
    }

    public SwipeRefreshLayout(Context context) {
        this(context, null);
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Zo = false;
        this.gn = -1.0f;
        this.we = new int[2];
        this.Ws = false;
        this.j3 = -1;
        this.er = -1;
        this.cb = new 1(this);
        this.dx = new 6(this);
        this.sG = new 7(this);
        this.ef = new 8(this);
        this.VH = ViewConfiguration.get(context).getScaledTouchSlop();
        this.J0 = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.a8 = new DecelerateInterpolator(2.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, lg);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.ro = (int) (displayMetrics.density * 40.0f);
        this.cn = (int) (displayMetrics.density * 40.0f);
        DW();
        z.j6((ViewGroup) this, true);
        this.SI = displayMetrics.density * 64.0f;
        this.gn = this.SI;
        this.tp = new u(this);
        this.EQ = new s(this);
        setNestedScrollingEnabled(true);
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.er < 0) {
            return i2;
        }
        if (i2 == i - 1) {
            return this.er;
        }
        if (i2 >= this.er) {
            return i2 + 1;
        }
        return i2;
    }

    private void DW() {
        this.rN = new a(getContext(), -328966, 20.0f);
        this.gW = new f(getContext(), this);
        this.gW.DW(-328966);
        this.rN.setImageDrawable(this.gW);
        this.rN.setVisibility(8);
        addView(this.rN);
    }

    public void setOnRefreshListener(a aVar) {
        this.v5 = aVar;
    }

    private boolean FH() {
        return VERSION.SDK_INT < 11;
    }

    public void setRefreshing(boolean z) {
        if (!z || this.Zo == z) {
            j6(z, false);
            return;
        }
        int i;
        this.Zo = z;
        if (this.sh) {
            i = (int) this.SI;
        } else {
            i = (int) (this.SI + ((float) this.DW));
        }
        j6(i - this.J8, true);
        this.KD = false;
        j6(this.cb);
    }

    private void j6(AnimationListener animationListener) {
        this.rN.setVisibility(0);
        if (VERSION.SDK_INT >= 11) {
            this.gW.setAlpha(255);
        }
        this.BT = new 2(this);
        this.BT.setDuration((long) this.J0);
        if (animationListener != null) {
            this.rN.j6(animationListener);
        }
        this.rN.clearAnimation();
        this.rN.startAnimation(this.BT);
    }

    private void setAnimationProgress(float f) {
        if (FH()) {
            setColorViewAlpha((int) (255.0f * f));
            return;
        }
        z.j6(this.rN, f);
        z.DW(this.rN, f);
    }

    private void j6(boolean z, boolean z2) {
        if (this.Zo != z) {
            this.KD = z2;
            Zo();
            this.Zo = z;
            if (this.Zo) {
                j6(this.J8, this.cb);
            } else {
                DW(this.cb);
            }
        }
    }

    private void DW(AnimationListener animationListener) {
        this.vy = new 3(this);
        this.vy.setDuration(150);
        this.rN.j6(animationListener);
        this.rN.clearAnimation();
        this.rN.startAnimation(this.vy);
    }

    private void Hw() {
        this.P8 = j6(this.gW.getAlpha(), 76);
    }

    private void v5() {
        this.ei = j6(this.gW.getAlpha(), 255);
    }

    private Animation j6(int i, int i2) {
        if (this.Mr && FH()) {
            return null;
        }
        Animation 4 = new 4(this, i, i2);
        4.setDuration(300);
        this.rN.j6(null);
        this.rN.clearAnimation();
        this.rN.startAnimation(4);
        return 4;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i) {
        setProgressBackgroundColorSchemeResource(i);
    }

    public void setProgressBackgroundColorSchemeResource(int i) {
        setProgressBackgroundColorSchemeColor(getResources().getColor(i));
    }

    public void setProgressBackgroundColorSchemeColor(int i) {
        this.rN.setBackgroundColor(i);
        this.gW.DW(i);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Resources resources = getResources();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = resources.getColor(iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setColorSchemeColors(int... iArr) {
        Zo();
        this.gW.j6(iArr);
    }

    private void Zo() {
        if (this.Hw == null) {
            int i = 0;
            while (i < getChildCount()) {
                View childAt = getChildAt(i);
                if (childAt.equals(this.rN)) {
                    i++;
                } else {
                    this.Hw = childAt;
                    return;
                }
            }
        }
    }

    public void setDistanceToTriggerSync(int i) {
        this.gn = (float) i;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.Hw == null) {
                Zo();
            }
            if (this.Hw != null) {
                View view = this.Hw;
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                measuredHeight = this.rN.getMeasuredWidth();
                this.rN.layout((measuredWidth / 2) - (measuredHeight / 2), this.J8, (measuredWidth / 2) + (measuredHeight / 2), this.J8 + this.rN.getMeasuredHeight());
            }
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.Hw == null) {
            Zo();
        }
        if (this.Hw != null) {
            int i3;
            this.Hw.measure(MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.rN.measure(MeasureSpec.makeMeasureSpec(this.ro, 1073741824), MeasureSpec.makeMeasureSpec(this.cn, 1073741824));
            if (!(this.sh || this.Ws)) {
                this.Ws = true;
                i3 = -this.rN.getMeasuredHeight();
                this.DW = i3;
                this.J8 = i3;
            }
            this.er = -1;
            for (i3 = 0; i3 < getChildCount(); i3++) {
                if (getChildAt(i3) == this.rN) {
                    this.er = i3;
                    return;
                }
            }
        }
    }

    public int getProgressCircleDiameter() {
        return this.rN != null ? this.rN.getMeasuredHeight() : 0;
    }

    public boolean j6() {
        boolean z = false;
        if (VERSION.SDK_INT >= 14) {
            return z.DW(this.Hw, -1);
        }
        if (this.Hw instanceof AbsListView) {
            AbsListView absListView = (AbsListView) this.Hw;
            return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
        } else {
            if (z.DW(this.Hw, -1) || this.Hw.getScrollY() > 0) {
                z = true;
            }
            return z;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        Zo();
        int j6 = n.j6(motionEvent);
        if (this.U2 && j6 == 0) {
            this.U2 = false;
        }
        if (!isEnabled() || this.U2 || j6() || this.Zo) {
            return false;
        }
        float j62;
        switch (j6) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                j6(this.DW - this.rN.getTop(), true);
                this.j3 = n.DW(motionEvent, 0);
                this.aM = false;
                j62 = j6(motionEvent, this.j3);
                if (j62 != -1.0f) {
                    this.XL = j62;
                    break;
                }
                return false;
            case ProxyTextView.TYPEFACE_SANS /*1*/:
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                this.aM = false;
                this.j3 = -1;
                break;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                if (this.j3 == -1) {
                    Log.e(FH, "Got ACTION_MOVE event but don't have an active pointer id.");
                    return false;
                }
                j62 = j6(motionEvent, this.j3);
                if (j62 != -1.0f) {
                    if (j62 - this.XL > ((float) this.VH) && !this.aM) {
                        this.QX = this.XL + ((float) this.VH);
                        this.aM = true;
                        this.gW.setAlpha(76);
                        break;
                    }
                }
                return false;
            case 6:
                j6(motionEvent);
                break;
        }
        return this.aM;
    }

    private float j6(MotionEvent motionEvent, int i) {
        int j6 = n.j6(motionEvent, i);
        if (j6 < 0) {
            return -1.0f;
        }
        return n.Hw(motionEvent, j6);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (VERSION.SDK_INT < 21 && (this.Hw instanceof AbsListView)) {
            return;
        }
        if (this.Hw == null || z.we(this.Hw)) {
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
        this.tp.j6(view, view2, i);
        this.u7 = 0.0f;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0 && this.u7 > 0.0f) {
            if (((float) i2) > this.u7) {
                iArr[1] = i2 - ((int) this.u7);
                this.u7 = 0.0f;
            } else {
                this.u7 -= (float) i2;
                iArr[1] = i2;
            }
            j6(this.u7);
        }
        int[] iArr2 = this.we;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr2[1] + iArr[1];
        }
    }

    public int getNestedScrollAxes() {
        return this.tp.j6();
    }

    public void onStopNestedScroll(View view) {
        this.tp.j6(view);
        if (this.u7 > 0.0f) {
            DW(this.u7);
            this.u7 = 0.0f;
        }
        stopNestedScroll();
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        if (i4 < 0) {
            this.u7 = ((float) Math.abs(i4)) + this.u7;
            j6(this.u7);
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
        this.EQ.j6(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.EQ.j6();
    }

    public boolean startNestedScroll(int i) {
        return this.EQ.j6(i);
    }

    public void stopNestedScroll() {
        this.EQ.FH();
    }

    public boolean hasNestedScrollingParent() {
        return this.EQ.DW();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.EQ.j6(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.EQ.j6(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.EQ.j6(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.EQ.j6(f, f2);
    }

    private boolean j6(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void j6(float f) {
        this.gW.j6(true);
        float min = Math.min(1.0f, Math.abs(f / this.gn));
        float max = (((float) Math.max(((double) min) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f) - this.gn;
        float f2 = this.sh ? this.SI - ((float) this.DW) : this.SI;
        abs = Math.max(0.0f, Math.min(abs, f2 * 2.0f) / f2);
        abs = ((float) (((double) (abs / 4.0f)) - Math.pow((double) (abs / 4.0f), 2.0d))) * 2.0f;
        int i = ((int) ((f2 * min) + ((f2 * abs) * 2.0f))) + this.DW;
        if (this.rN.getVisibility() != 0) {
            this.rN.setVisibility(0);
        }
        if (!this.Mr) {
            z.j6(this.rN, 1.0f);
            z.DW(this.rN, 1.0f);
        }
        if (f < this.gn) {
            if (this.Mr) {
                setAnimationProgress(f / this.gn);
            }
            if (this.gW.getAlpha() > 76 && !j6(this.P8)) {
                Hw();
            }
            this.gW.j6(0.0f, Math.min(0.8f, max * 0.8f));
            this.gW.j6(Math.min(1.0f, max));
        } else if (this.gW.getAlpha() < 255 && !j6(this.ei)) {
            v5();
        }
        this.gW.DW(((-0.25f + (max * 0.4f)) + (abs * 2.0f)) * 0.5f);
        j6(i - this.J8, true);
    }

    private void DW(float f) {
        if (f > this.gn) {
            j6(true, true);
            return;
        }
        this.Zo = false;
        this.gW.j6(0.0f, 0.0f);
        AnimationListener animationListener = null;
        if (!this.Mr) {
            animationListener = new 5(this);
        }
        DW(this.J8, animationListener);
        this.gW.j6(false);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int j6 = n.j6(motionEvent);
        if (this.U2 && j6 == 0) {
            this.U2 = false;
        }
        if (!isEnabled() || this.U2 || j6()) {
            return false;
        }
        switch (j6) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                this.j3 = n.DW(motionEvent, 0);
                this.aM = false;
                break;
            case ProxyTextView.TYPEFACE_SANS /*1*/:
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                if (this.j3 != -1) {
                    float Hw = (n.Hw(motionEvent, n.j6(motionEvent, this.j3)) - this.QX) * 0.5f;
                    this.aM = false;
                    DW(Hw);
                    this.j3 = -1;
                    return false;
                } else if (j6 != 1) {
                    return false;
                } else {
                    Log.e(FH, "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                j6 = n.j6(motionEvent, this.j3);
                if (j6 < 0) {
                    Log.e(FH, "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                float Hw2 = (n.Hw(motionEvent, j6) - this.QX) * 0.5f;
                if (this.aM) {
                    if (Hw2 > 0.0f) {
                        j6(Hw2);
                        break;
                    }
                    return false;
                }
                break;
            case 5:
                this.j3 = n.DW(motionEvent, n.DW(motionEvent));
                break;
            case 6:
                j6(motionEvent);
                break;
        }
        return true;
    }

    private void j6(int i, AnimationListener animationListener) {
        this.j6 = i;
        this.dx.reset();
        this.dx.setDuration(200);
        this.dx.setInterpolator(this.a8);
        if (animationListener != null) {
            this.rN.j6(animationListener);
        }
        this.rN.clearAnimation();
        this.rN.startAnimation(this.dx);
    }

    private void DW(int i, AnimationListener animationListener) {
        if (this.Mr) {
            FH(i, animationListener);
            return;
        }
        this.j6 = i;
        this.ef.reset();
        this.ef.setDuration(200);
        this.ef.setInterpolator(this.a8);
        if (animationListener != null) {
            this.rN.j6(animationListener);
        }
        this.rN.clearAnimation();
        this.rN.startAnimation(this.ef);
    }

    private void FH(float f) {
        j6((this.j6 + ((int) (((float) (this.DW - this.j6)) * f))) - this.rN.getTop(), false);
    }

    private void FH(int i, AnimationListener animationListener) {
        this.j6 = i;
        if (FH()) {
            this.yS = (float) this.gW.getAlpha();
        } else {
            this.yS = z.gn(this.rN);
        }
        this.nw = new 9(this);
        this.nw.setDuration(150);
        if (animationListener != null) {
            this.rN.j6(animationListener);
        }
        this.rN.clearAnimation();
        this.rN.startAnimation(this.nw);
    }

    private void j6(int i, boolean z) {
        this.rN.bringToFront();
        this.rN.offsetTopAndBottom(i);
        this.J8 = this.rN.getTop();
        if (z && VERSION.SDK_INT < 11) {
            invalidate();
        }
    }

    private void j6(MotionEvent motionEvent) {
        int DW = n.DW(motionEvent);
        if (n.DW(motionEvent, DW) == this.j3) {
            this.j3 = n.DW(motionEvent, DW == 0 ? 1 : 0);
        }
    }
}
