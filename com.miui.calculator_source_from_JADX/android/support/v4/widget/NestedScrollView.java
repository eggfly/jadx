package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import java.util.List;

public class NestedScrollView extends FrameLayout implements NestedScrollingChild, NestedScrollingParent {
    private static final AccessibilityDelegate f1135v;
    private static final int[] f1136w;
    private long f1137a;
    private final Rect f1138b;
    private ScrollerCompat f1139c;
    private EdgeEffectCompat f1140d;
    private EdgeEffectCompat f1141e;
    private int f1142f;
    private boolean f1143g;
    private boolean f1144h;
    private View f1145i;
    private boolean f1146j;
    private VelocityTracker f1147k;
    private boolean f1148l;
    private boolean f1149m;
    private int f1150n;
    private int f1151o;
    private int f1152p;
    private int f1153q;
    private final int[] f1154r;
    private final int[] f1155s;
    private int f1156t;
    private SavedState f1157u;
    private final NestedScrollingParentHelper f1158x;
    private final NestedScrollingChildHelper f1159y;
    private float f1160z;

    static class AccessibilityDelegate extends AccessibilityDelegateCompat {
        AccessibilityDelegate() {
        }

        public boolean m2287a(View view, int i, Bundle bundle) {
            if (super.m1194a(view, i, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int min;
            switch (i) {
                case 4096:
                    min = Math.min(((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()) + nestedScrollView.getScrollY(), nestedScrollView.getScrollRange());
                    if (min == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.m2316b(0, min);
                    return true;
                case 8192:
                    min = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (min == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.m2316b(0, min);
                    return true;
                default:
                    return false;
            }
        }

        public void m2286a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.m1192a(view, accessibilityNodeInfoCompat);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityNodeInfoCompat.m1808b(ScrollView.class.getName());
            if (nestedScrollView.isEnabled()) {
                int a = nestedScrollView.getScrollRange();
                if (a > 0) {
                    accessibilityNodeInfoCompat.m1827i(true);
                    if (nestedScrollView.getScrollY() > 0) {
                        accessibilityNodeInfoCompat.m1798a(8192);
                    }
                    if (nestedScrollView.getScrollY() < a) {
                        accessibilityNodeInfoCompat.m1798a(4096);
                    }
                }
            }
        }

        public void m2288d(View view, AccessibilityEvent accessibilityEvent) {
            super.m1198d(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            AccessibilityRecordCompat a = AccessibilityEventCompat.m1632a(accessibilityEvent);
            a.m1948a(nestedScrollView.getScrollRange() > 0);
            a.m1951d(nestedScrollView.getScrollX());
            a.m1952e(nestedScrollView.getScrollY());
            a.m1953f(nestedScrollView.getScrollX());
            a.m1954g(nestedScrollView.getScrollRange());
        }
    }

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        public int f1134a;

        /* renamed from: android.support.v4.widget.NestedScrollView.SavedState.1 */
        final class C01151 implements Creator<SavedState> {
            C01151() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m2289a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m2290a(i);
            }

            public SavedState m2289a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m2290a(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f1134a = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1134a);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f1134a + "}";
        }

        static {
            CREATOR = new C01151();
        }
    }

    static {
        f1135v = new AccessibilityDelegate();
        f1136w = new int[]{16843130};
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1138b = new Rect();
        this.f1143g = true;
        this.f1144h = false;
        this.f1145i = null;
        this.f1146j = false;
        this.f1149m = true;
        this.f1153q = -1;
        this.f1154r = new int[2];
        this.f1155s = new int[2];
        m2293a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1136w, i, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.f1158x = new NestedScrollingParentHelper(this);
        this.f1159y = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        ViewCompat.m1450a((View) this, f1135v);
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f1159y.m1299a(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.f1159y.m1300a();
    }

    public boolean startNestedScroll(int i) {
        return this.f1159y.m1303a(i);
    }

    public void stopNestedScroll() {
        this.f1159y.m1307c();
    }

    public boolean hasNestedScrollingParent() {
        return this.f1159y.m1306b();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f1159y.m1304a(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f1159y.m1305a(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f1159y.m1302a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f1159y.m1301a(f, f2);
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f1158x.m1310a(view, view2, i);
        startNestedScroll(2);
    }

    public void onStopNestedScroll(View view) {
        stopNestedScroll();
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int scrollY = getScrollY();
        scrollBy(0, i4);
        int scrollY2 = getScrollY() - scrollY;
        dispatchNestedScroll(0, scrollY2, 0, i4 - scrollY2, null);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        m2309f((int) f2);
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public int getNestedScrollAxes() {
        return this.f1158x.m1308a();
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return ((float) scrollY) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = (getChildAt(0).getBottom() - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return ((float) bottom) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (0.5f * ((float) getHeight()));
    }

    private void m2293a() {
        this.f1139c = new ScrollerCompat(getContext(), null);
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f1150n = viewConfiguration.getScaledTouchSlop();
        this.f1151o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1152p = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    public void addView(View view, int i) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i);
    }

    public void addView(View view, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i, layoutParams);
    }

    private boolean m2302b() {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return false;
        }
        if (getHeight() < (childAt.getHeight() + getPaddingTop()) + getPaddingBottom()) {
            return true;
        }
        return false;
    }

    public void setFillViewport(boolean z) {
        if (z != this.f1148l) {
            this.f1148l = z;
            requestLayout();
        }
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.f1149m = z;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f1148l && MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            int measuredHeight = getMeasuredHeight();
            if (childAt.getMeasuredHeight() < measuredHeight) {
                childAt.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), ((FrameLayout.LayoutParams) childAt.getLayoutParams()).width), MeasureSpec.makeMeasureSpec((measuredHeight - getPaddingTop()) - getPaddingBottom(), 1073741824));
            }
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m2315a(keyEvent);
    }

    public boolean m2315a(KeyEvent keyEvent) {
        int i = 33;
        this.f1138b.setEmpty();
        if (m2302b()) {
            if (keyEvent.getAction() != 0) {
                return false;
            }
            switch (keyEvent.getKeyCode()) {
                case C0264R.styleable.Window_immersionMenuLayout /*19*/:
                    if (keyEvent.isAltPressed()) {
                        return m2317b(33);
                    }
                    return m2318c(33);
                case C0264R.styleable.Window_immersionButtonMoreBackground /*20*/:
                    if (keyEvent.isAltPressed()) {
                        return m2317b(130);
                    }
                    return m2318c(130);
                case 62:
                    if (!keyEvent.isShiftPressed()) {
                        i = 130;
                    }
                    m2313a(i);
                    return false;
                default:
                    return false;
            }
        } else if (!isFocused() || keyEvent.getKeyCode() == 4) {
            return false;
        } else {
            boolean z;
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            findFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            if (findFocus == null || findFocus == this || !findFocus.requestFocus(130)) {
                z = false;
            } else {
                z = true;
            }
            return z;
        }
    }

    private boolean m2304c(int i, int i2) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        if (i2 < childAt.getTop() - scrollY || i2 >= childAt.getBottom() - scrollY || i < childAt.getLeft() || i >= childAt.getRight()) {
            return false;
        }
        return true;
    }

    private void m2303c() {
        if (this.f1147k == null) {
            this.f1147k = VelocityTracker.obtain();
        } else {
            this.f1147k.clear();
        }
    }

    private void m2305d() {
        if (this.f1147k == null) {
            this.f1147k = VelocityTracker.obtain();
        }
    }

    private void m2306e() {
        if (this.f1147k != null) {
            this.f1147k.recycle();
            this.f1147k = null;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            m2306e();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        int action = motionEvent.getAction();
        if (action == 2 && this.f1146j) {
            return true;
        }
        if (getScrollY() == 0 && !ViewCompat.m1461b((View) this, 1)) {
            return false;
        }
        switch (action & 255) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                action = (int) motionEvent.getY();
                if (!m2304c((int) motionEvent.getX(), action)) {
                    this.f1146j = false;
                    m2306e();
                    break;
                }
                this.f1142f = action;
                this.f1153q = MotionEventCompat.m1286b(motionEvent, 0);
                m2303c();
                this.f1147k.addMovement(motionEvent);
                if (this.f1139c.m2363a()) {
                    z = false;
                }
                this.f1146j = z;
                startNestedScroll(2);
                break;
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                this.f1146j = false;
                this.f1153q = -1;
                m2306e();
                stopNestedScroll();
                break;
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                action = this.f1153q;
                if (action != -1) {
                    int a = MotionEventCompat.m1284a(motionEvent, action);
                    if (a != -1) {
                        action = (int) MotionEventCompat.m1289d(motionEvent, a);
                        if (Math.abs(action - this.f1142f) > this.f1150n && (getNestedScrollAxes() & 2) == 0) {
                            this.f1146j = true;
                            this.f1142f = action;
                            m2305d();
                            this.f1147k.addMovement(motionEvent);
                            this.f1156t = 0;
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                    }
                    Log.e("NestedScrollView", "Invalid pointerId=" + action + " in onInterceptTouchEvent");
                    break;
                }
                break;
            case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                m2294a(motionEvent);
                break;
        }
        return this.f1146j;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        m2305d();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int a = MotionEventCompat.m1283a(motionEvent);
        if (a == 0) {
            this.f1156t = 0;
        }
        obtain.offsetLocation(0.0f, (float) this.f1156t);
        switch (a) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                if (getChildCount() != 0) {
                    boolean z = !this.f1139c.m2363a();
                    this.f1146j = z;
                    if (z) {
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (!this.f1139c.m2363a()) {
                        this.f1139c.m2370h();
                    }
                    this.f1142f = (int) motionEvent.getY();
                    this.f1153q = MotionEventCompat.m1286b(motionEvent, 0);
                    startNestedScroll(2);
                    break;
                }
                return false;
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                if (this.f1146j) {
                    VelocityTracker velocityTracker = this.f1147k;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f1152p);
                    a = (int) VelocityTrackerCompat.m1343b(velocityTracker, this.f1153q);
                    if (Math.abs(a) > this.f1151o) {
                        m2309f(-a);
                    }
                    this.f1153q = -1;
                    m2308f();
                    break;
                }
                break;
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                int a2 = MotionEventCompat.m1284a(motionEvent, this.f1153q);
                if (a2 != -1) {
                    int i;
                    int d = (int) MotionEventCompat.m1289d(motionEvent, a2);
                    a = this.f1142f - d;
                    if (dispatchNestedPreScroll(0, a, this.f1155s, this.f1154r)) {
                        a -= this.f1155s[1];
                        obtain.offsetLocation(0.0f, (float) this.f1154r[1]);
                        this.f1156t += this.f1154r[1];
                    }
                    if (this.f1146j || Math.abs(a) <= this.f1150n) {
                        i = a;
                    } else {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f1146j = true;
                        if (a > 0) {
                            i = a - this.f1150n;
                        } else {
                            i = a + this.f1150n;
                        }
                    }
                    if (this.f1146j) {
                        Object obj;
                        this.f1142f = d - this.f1154r[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        a = ViewCompat.m1445a(this);
                        if (a == 0 || (a == 1 && scrollRange > 0)) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (m2314a(0, i, 0, getScrollY(), 0, scrollRange, 0, 0, true) && !hasNestedScrollingParent()) {
                            this.f1147k.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        if (!dispatchNestedScroll(0, scrollY2, 0, i - scrollY2, this.f1154r)) {
                            if (obj != null) {
                                m2310g();
                                a = scrollY + i;
                                if (a < 0) {
                                    this.f1140d.m2192a(((float) i) / ((float) getHeight()), MotionEventCompat.m1287c(motionEvent, a2) / ((float) getWidth()));
                                    if (!this.f1141e.m2190a()) {
                                        this.f1141e.m2196c();
                                    }
                                } else if (a > scrollRange) {
                                    this.f1141e.m2192a(((float) i) / ((float) getHeight()), 1.0f - (MotionEventCompat.m1287c(motionEvent, a2) / ((float) getWidth())));
                                    if (!this.f1140d.m2190a()) {
                                        this.f1140d.m2196c();
                                    }
                                }
                                if (!(this.f1140d == null || (this.f1140d.m2190a() && this.f1141e.m2190a()))) {
                                    ViewCompat.m1459b(this);
                                    break;
                                }
                            }
                        }
                        this.f1142f -= this.f1154r[1];
                        obtain.offsetLocation(0.0f, (float) this.f1154r[1]);
                        this.f1156t += this.f1154r[1];
                        break;
                    }
                }
                Log.e("NestedScrollView", "Invalid pointerId=" + this.f1153q + " in onTouchEvent");
                break;
                break;
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                if (this.f1146j && getChildCount() > 0) {
                    this.f1153q = -1;
                    m2308f();
                    break;
                }
            case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                a = MotionEventCompat.m1285b(motionEvent);
                this.f1142f = (int) MotionEventCompat.m1289d(motionEvent, a);
                this.f1153q = MotionEventCompat.m1286b(motionEvent, a);
                break;
            case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                m2294a(motionEvent);
                this.f1142f = (int) MotionEventCompat.m1289d(motionEvent, MotionEventCompat.m1284a(motionEvent, this.f1153q));
                break;
        }
        if (this.f1147k != null) {
            this.f1147k.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    private void m2294a(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (MotionEventCompat.m1286b(motionEvent, action) == this.f1153q) {
            action = action == 0 ? 1 : 0;
            this.f1142f = (int) MotionEventCompat.m1289d(motionEvent, action);
            this.f1153q = MotionEventCompat.m1286b(motionEvent, action);
            if (this.f1147k != null) {
                this.f1147k.clear();
            }
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((MotionEventCompat.m1290d(motionEvent) & 2) == 0) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case C0264R.styleable.Window_windowFixedWidthMinor /*8*/:
                if (this.f1146j) {
                    return false;
                }
                float e = MotionEventCompat.m1291e(motionEvent, 9);
                if (e == 0.0f) {
                    return false;
                }
                int verticalScrollFactorCompat = (int) (e * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                verticalScrollFactorCompat = scrollY - verticalScrollFactorCompat;
                if (verticalScrollFactorCompat < 0) {
                    scrollRange = 0;
                } else if (verticalScrollFactorCompat <= scrollRange) {
                    scrollRange = verticalScrollFactorCompat;
                }
                if (scrollRange == scrollY) {
                    return false;
                }
                super.scrollTo(getScrollX(), scrollRange);
                return true;
            default:
                return false;
        }
    }

    private float getVerticalScrollFactorCompat() {
        if (this.f1160z == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.f1160z = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.f1160z;
    }

    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    boolean m2314a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        boolean z2;
        int a = ViewCompat.m1445a(this);
        Object obj = computeHorizontalScrollRange() > computeHorizontalScrollExtent() ? 1 : null;
        Object obj2 = computeVerticalScrollRange() > computeVerticalScrollExtent() ? 1 : null;
        Object obj3 = (a == 0 || (a == 1 && obj != null)) ? 1 : null;
        obj = (a == 0 || (a == 1 && obj2 != null)) ? 1 : null;
        int i9 = i3 + i;
        if (obj3 == null) {
            i7 = 0;
        }
        a = i4 + i2;
        if (obj == null) {
            i8 = 0;
        }
        int i10 = -i7;
        int i11 = i7 + i5;
        int i12 = -i8;
        int i13 = i8 + i6;
        if (i9 > i11) {
            i10 = i11;
            z2 = true;
        } else if (i9 < i10) {
            z2 = true;
        } else {
            z2 = false;
            i10 = i9;
        }
        boolean z3 = false;
        if (a > i13) {
            z3 = true;
        } else if (a < i12) {
            z3 = true;
            i13 = i12;
        } else {
            i13 = a;
        }
        onOverScrolled(i10, i13, z2, z3);
        if (z2 || z3) {
            return true;
        }
        return false;
    }

    private int getScrollRange() {
        if (getChildCount() > 0) {
            return Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
        }
        return 0;
    }

    private View m2292a(boolean z, int i, int i2) {
        List focusables = getFocusables(2);
        View view = null;
        Object obj = null;
        int size = focusables.size();
        int i3 = 0;
        while (i3 < size) {
            View view2;
            Object obj2;
            View view3 = (View) focusables.get(i3);
            int top = view3.getTop();
            int bottom = view3.getBottom();
            if (i < bottom && top < i2) {
                Object obj3 = (i >= top || bottom >= i2) ? null : 1;
                if (view == null) {
                    Object obj4 = obj3;
                    view2 = view3;
                    obj2 = obj4;
                } else {
                    Object obj5 = ((!z || top >= view.getTop()) && (z || bottom <= view.getBottom())) ? null : 1;
                    if (obj != null) {
                        if (!(obj3 == null || obj5 == null)) {
                            view2 = view3;
                            obj2 = obj;
                        }
                    } else if (obj3 != null) {
                        view2 = view3;
                        int i4 = 1;
                    } else if (obj5 != null) {
                        view2 = view3;
                        obj2 = obj;
                    }
                }
                i3++;
                view = view2;
                obj = obj2;
            }
            obj2 = obj;
            view2 = view;
            i3++;
            view = view2;
            obj = obj2;
        }
        return view;
    }

    public boolean m2313a(int i) {
        int i2 = i == 130 ? 1 : 0;
        int height = getHeight();
        if (i2 != 0) {
            this.f1138b.top = getScrollY() + height;
            i2 = getChildCount();
            if (i2 > 0) {
                View childAt = getChildAt(i2 - 1);
                if (this.f1138b.top + height > childAt.getBottom()) {
                    this.f1138b.top = childAt.getBottom() - height;
                }
            }
        } else {
            this.f1138b.top = getScrollY() - height;
            if (this.f1138b.top < 0) {
                this.f1138b.top = 0;
            }
        }
        this.f1138b.bottom = this.f1138b.top + height;
        return m2295a(i, this.f1138b.top, this.f1138b.bottom);
    }

    public boolean m2317b(int i) {
        int i2 = i == 130 ? 1 : 0;
        int height = getHeight();
        this.f1138b.top = 0;
        this.f1138b.bottom = height;
        if (i2 != 0) {
            i2 = getChildCount();
            if (i2 > 0) {
                this.f1138b.bottom = getChildAt(i2 - 1).getBottom() + getPaddingBottom();
                this.f1138b.top = this.f1138b.bottom - height;
            }
        }
        return m2295a(i, this.f1138b.top, this.f1138b.bottom);
    }

    private boolean m2295a(int i, int i2, int i3) {
        boolean z = false;
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = scrollY + height;
        boolean z2 = i == 33;
        View a = m2292a(z2, i2, i3);
        if (a == null) {
            a = this;
        }
        if (i2 < scrollY || i3 > i4) {
            m2307e(z2 ? i2 - scrollY : i3 - i4);
            z = true;
        }
        if (a != findFocus()) {
            a.requestFocus(i);
        }
        return z;
    }

    public boolean m2318c(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !m2298a(findNextFocus, maxScrollAmount, getHeight())) {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                int bottom = getChildAt(0).getBottom();
                int scrollY = (getScrollY() + getHeight()) - getPaddingBottom();
                if (bottom - scrollY < maxScrollAmount) {
                    maxScrollAmount = bottom - scrollY;
                }
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            m2307e(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.f1138b);
            offsetDescendantRectToMyCoords(findNextFocus, this.f1138b);
            m2307e(m2311a(this.f1138b));
            findNextFocus.requestFocus(i);
        }
        if (findFocus != null && findFocus.isFocused() && m2297a(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    private boolean m2297a(View view) {
        return !m2298a(view, 0, getHeight());
    }

    private boolean m2298a(View view, int i, int i2) {
        view.getDrawingRect(this.f1138b);
        offsetDescendantRectToMyCoords(view, this.f1138b);
        return this.f1138b.bottom + i >= getScrollY() && this.f1138b.top - i <= getScrollY() + i2;
    }

    private void m2307e(int i) {
        if (i == 0) {
            return;
        }
        if (this.f1149m) {
            m2312a(0, i);
        } else {
            scrollBy(0, i);
        }
    }

    public final void m2312a(int i, int i2) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.f1137a > 250) {
                int max = Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
                int scrollY = getScrollY();
                this.f1139c.m2360a(getScrollX(), scrollY, 0, Math.max(0, Math.min(scrollY + i2, max)) - scrollY);
                ViewCompat.m1459b(this);
            } else {
                if (!this.f1139c.m2363a()) {
                    this.f1139c.m2370h();
                }
                scrollBy(i, i2);
            }
            this.f1137a = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    public final void m2316b(int i, int i2) {
        m2312a(i - getScrollX(), i2 - getScrollY());
    }

    protected int computeVerticalScrollRange() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (getChildCount() == 0) {
            return height;
        }
        int bottom = getChildAt(0).getBottom();
        int scrollY = getScrollY();
        height = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        if (scrollY > height) {
            return bottom + (scrollY - height);
        }
        return bottom;
    }

    protected int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    protected void measureChild(View view, int i, int i2) {
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), MeasureSpec.makeMeasureSpec(0, 0));
    }

    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width), MeasureSpec.makeMeasureSpec(marginLayoutParams.bottomMargin + marginLayoutParams.topMargin, 0));
    }

    public void computeScroll() {
        if (this.f1139c.m2369g()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int b = this.f1139c.m2364b();
            int c = this.f1139c.m2365c();
            if (scrollX != b || scrollY != c) {
                int scrollRange = getScrollRange();
                int a = ViewCompat.m1445a(this);
                int i = (a == 0 || (a == 1 && scrollRange > 0)) ? 1 : 0;
                m2314a(b - scrollX, c - scrollY, scrollX, scrollY, 0, scrollRange, 0, 0, false);
                if (i != 0) {
                    m2310g();
                    if (c <= 0 && scrollY > 0) {
                        this.f1140d.m2193a((int) this.f1139c.m2368f());
                    } else if (c >= scrollRange && scrollY < scrollRange) {
                        this.f1141e.m2193a((int) this.f1139c.m2368f());
                    }
                }
            }
        }
    }

    private void m2301b(View view) {
        view.getDrawingRect(this.f1138b);
        offsetDescendantRectToMyCoords(view, this.f1138b);
        int a = m2311a(this.f1138b);
        if (a != 0) {
            scrollBy(0, a);
        }
    }

    private boolean m2296a(Rect rect, boolean z) {
        int a = m2311a(rect);
        boolean z2 = a != 0;
        if (z2) {
            if (z) {
                scrollBy(0, a);
            } else {
                m2312a(0, a);
            }
        }
        return z2;
    }

    protected int m2311a(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        if (rect.bottom < getChildAt(0).getHeight()) {
            i -= verticalFadingEdgeLength;
        }
        if (rect.bottom > i && rect.top > scrollY) {
            if (rect.height() > height) {
                scrollY = (rect.top - scrollY) + 0;
            } else {
                scrollY = (rect.bottom - i) + 0;
            }
            scrollY = Math.min(scrollY, getChildAt(0).getBottom() - i);
        } else if (rect.top >= scrollY || rect.bottom >= i) {
            scrollY = 0;
        } else {
            if (rect.height() > height) {
                scrollY = 0 - (i - rect.bottom);
            } else {
                scrollY = 0 - (scrollY - rect.top);
            }
            scrollY = Math.max(scrollY, -getScrollY());
        }
        return scrollY;
    }

    public void requestChildFocus(View view, View view2) {
        if (this.f1143g) {
            this.f1145i = view2;
        } else {
            m2301b(view2);
        }
        super.requestChildFocus(view, view2);
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        View findNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        if (findNextFocus == null || m2297a(findNextFocus)) {
            return false;
        }
        return findNextFocus.requestFocus(i, rect);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return m2296a(rect, z);
    }

    public void requestLayout() {
        this.f1143g = true;
        super.requestLayout();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f1143g = false;
        if (this.f1145i != null && m2299a(this.f1145i, (View) this)) {
            m2301b(this.f1145i);
        }
        this.f1145i = null;
        if (!this.f1144h) {
            if (this.f1157u != null) {
                scrollTo(getScrollX(), this.f1157u.f1134a);
                this.f1157u = null;
            }
            int max = Math.max(0, (getChildCount() > 0 ? getChildAt(0).getMeasuredHeight() : 0) - (((i4 - i2) - getPaddingBottom()) - getPaddingTop()));
            if (getScrollY() > max) {
                scrollTo(getScrollX(), max);
            } else if (getScrollY() < 0) {
                scrollTo(getScrollX(), 0);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f1144h = true;
    }

    public void onAttachedToWindow() {
        this.f1144h = false;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && m2298a(findFocus, 0, i4)) {
            findFocus.getDrawingRect(this.f1138b);
            offsetDescendantRectToMyCoords(findFocus, this.f1138b);
            m2307e(m2311a(this.f1138b));
        }
    }

    private static boolean m2299a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        boolean z = (parent instanceof ViewGroup) && m2299a((View) parent, view2);
        return z;
    }

    public void m2319d(int i) {
        if (getChildCount() > 0) {
            int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
            int height2 = getChildAt(0).getHeight();
            this.f1139c.m2362a(getScrollX(), getScrollY(), 0, i, 0, 0, 0, Math.max(0, height2 - height), 0, height / 2);
            ViewCompat.m1459b(this);
        }
    }

    private void m2309f(int i) {
        int scrollY = getScrollY();
        boolean z = (scrollY > 0 || i > 0) && (scrollY < getScrollRange() || i < 0);
        if (!dispatchNestedPreFling(0.0f, (float) i)) {
            dispatchNestedFling(0.0f, (float) i, z);
            if (z) {
                m2319d(i);
            }
        }
    }

    private void m2308f() {
        this.f1146j = false;
        m2306e();
        stopNestedScroll();
        if (this.f1140d != null) {
            this.f1140d.m2196c();
            this.f1141e.m2196c();
        }
    }

    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int b = m2300b(i, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth());
            int b2 = m2300b(i2, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight());
            if (b != getScrollX() || b2 != getScrollY()) {
                super.scrollTo(b, b2);
            }
        }
    }

    private void m2310g() {
        if (ViewCompat.m1445a(this) == 2) {
            this.f1140d = null;
            this.f1141e = null;
        } else if (this.f1140d == null) {
            Context context = getContext();
            this.f1140d = new EdgeEffectCompat(context);
            this.f1141e = new EdgeEffectCompat(context);
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f1140d != null) {
            int save;
            int width;
            int scrollY = getScrollY();
            if (!this.f1140d.m2190a()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.translate((float) getPaddingLeft(), (float) Math.min(0, scrollY));
                this.f1140d.m2189a(width, getHeight());
                if (this.f1140d.m2194a(canvas)) {
                    ViewCompat.m1459b(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.f1141e.m2190a()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                int height = getHeight();
                canvas.translate((float) ((-width) + getPaddingLeft()), (float) (Math.max(getScrollRange(), scrollY) + height));
                canvas.rotate(180.0f, (float) width, 0.0f);
                this.f1141e.m2189a(width, height);
                if (this.f1141e.m2194a(canvas)) {
                    ViewCompat.m1459b(this);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    private static int m2300b(int i, int i2, int i3) {
        if (i2 >= i3 || i < 0) {
            return 0;
        }
        if (i2 + i > i3) {
            return i3 - i2;
        }
        return i;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f1157u = savedState;
        requestLayout();
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1134a = getScrollY();
        return savedState;
    }
}
