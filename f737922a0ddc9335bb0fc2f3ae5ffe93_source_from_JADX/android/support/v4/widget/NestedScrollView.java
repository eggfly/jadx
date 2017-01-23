package android.support.v4.widget;

import ad;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.n;
import android.support.v4.view.r;
import android.support.v4.view.s;
import android.support.v4.view.t;
import android.support.v4.view.u;
import android.support.v4.view.x;
import android.support.v4.view.z;
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
import com.aide.uidesigner.ProxyTextView;
import java.util.List;
import v;

public class NestedScrollView extends FrameLayout implements r, t {
    private static final a a8;
    private static final int[] lg;
    private final Rect DW;
    private VelocityTracker EQ;
    private g FH;
    private EdgeEffectCompat Hw;
    private boolean J0;
    private int J8;
    private int Mr;
    private int QX;
    private SavedState U2;
    private boolean VH;
    private int Ws;
    private int XL;
    private int Zo;
    private final int[] aM;
    private final s er;
    private boolean gn;
    private final int[] j3;
    private long j6;
    private final u rN;
    private boolean tp;
    private View u7;
    private EdgeEffectCompat v5;
    private boolean we;
    private float yS;

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        public int j6;

        static class 1 implements Creator<SavedState> {
            1() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return j6(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return j6(i);
            }

            public SavedState j6(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] j6(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.j6 = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.j6);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.j6 + "}";
        }

        static {
            CREATOR = new 1();
        }
    }

    static class a extends android.support.v4.view.a {
        a() {
        }

        public boolean j6(View view, int i, Bundle bundle) {
            if (super.j6(view, i, bundle)) {
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
                    nestedScrollView.DW(0, min);
                    return true;
                case 8192:
                    min = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (min == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.DW(0, min);
                    return true;
                default:
                    return false;
            }
        }

        public void j6(View view, v vVar) {
            super.j6(view, vVar);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            vVar.DW(ScrollView.class.getName());
            if (nestedScrollView.isEnabled()) {
                int j6 = nestedScrollView.getScrollRange();
                if (j6 > 0) {
                    vVar.u7(true);
                    if (nestedScrollView.getScrollY() > 0) {
                        vVar.j6(8192);
                    }
                    if (nestedScrollView.getScrollY() < j6) {
                        vVar.j6(4096);
                    }
                }
            }
        }

        public void Hw(View view, AccessibilityEvent accessibilityEvent) {
            super.Hw(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            ad j6 = u.j6(accessibilityEvent);
            j6.j6(nestedScrollView.getScrollRange() > 0);
            j6.Hw(nestedScrollView.getScrollX());
            j6.v5(nestedScrollView.getScrollY());
            j6.Zo(nestedScrollView.getScrollX());
            j6.VH(nestedScrollView.getScrollRange());
        }
    }

    static {
        a8 = new a();
        lg = new int[]{16843130};
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.DW = new Rect();
        this.VH = true;
        this.gn = false;
        this.u7 = null;
        this.tp = false;
        this.J0 = true;
        this.XL = -1;
        this.aM = new int[2];
        this.j3 = new int[2];
        j6();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, lg, i, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.rN = new u(this);
        this.er = new s(this);
        setNestedScrollingEnabled(true);
        z.j6((View) this, a8);
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.er.j6(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.er.j6();
    }

    public boolean startNestedScroll(int i) {
        return this.er.j6(i);
    }

    public void stopNestedScroll() {
        this.er.FH();
    }

    public boolean hasNestedScrollingParent() {
        return this.er.DW();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.er.j6(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.er.j6(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.er.j6(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.er.j6(f, f2);
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.rN.j6(view, view2, i);
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
        Zo((int) f2);
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public int getNestedScrollAxes() {
        return this.rN.j6();
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

    private void j6() {
        this.FH = new g(getContext(), null);
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.J8 = viewConfiguration.getScaledTouchSlop();
        this.Ws = viewConfiguration.getScaledMinimumFlingVelocity();
        this.QX = viewConfiguration.getScaledMaximumFlingVelocity();
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

    private boolean DW() {
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
        if (z != this.we) {
            this.we = z;
            requestLayout();
        }
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.J0 = z;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.we && MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            int measuredHeight = getMeasuredHeight();
            if (childAt.getMeasuredHeight() < measuredHeight) {
                childAt.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), ((FrameLayout.LayoutParams) childAt.getLayoutParams()).width), MeasureSpec.makeMeasureSpec((measuredHeight - getPaddingTop()) - getPaddingBottom(), 1073741824));
            }
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || j6(keyEvent);
    }

    public boolean j6(KeyEvent keyEvent) {
        int i = 33;
        this.DW.setEmpty();
        if (DW()) {
            if (keyEvent.getAction() != 0) {
                return false;
            }
            switch (keyEvent.getKeyCode()) {
                case 19:
                    if (keyEvent.isAltPressed()) {
                        return DW(33);
                    }
                    return FH(33);
                case ProxyTextView.INPUTTYPE_date /*20*/:
                    if (keyEvent.isAltPressed()) {
                        return DW(130);
                    }
                    return FH(130);
                case 62:
                    if (!keyEvent.isShiftPressed()) {
                        i = 130;
                    }
                    j6(i);
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

    private boolean FH(int i, int i2) {
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

    private void FH() {
        if (this.EQ == null) {
            this.EQ = VelocityTracker.obtain();
        } else {
            this.EQ.clear();
        }
    }

    private void Hw() {
        if (this.EQ == null) {
            this.EQ = VelocityTracker.obtain();
        }
    }

    private void v5() {
        if (this.EQ != null) {
            this.EQ.recycle();
            this.EQ = null;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            v5();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        int action = motionEvent.getAction();
        if (action == 2 && this.tp) {
            return true;
        }
        if (getScrollY() == 0 && !z.DW((View) this, 1)) {
            return false;
        }
        switch (action & 255) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                action = (int) motionEvent.getY();
                if (!FH((int) motionEvent.getX(), action)) {
                    this.tp = false;
                    v5();
                    break;
                }
                this.Zo = action;
                this.XL = n.DW(motionEvent, 0);
                FH();
                this.EQ.addMovement(motionEvent);
                if (this.FH.j6()) {
                    z = false;
                }
                this.tp = z;
                startNestedScroll(2);
                break;
            case ProxyTextView.TYPEFACE_SANS /*1*/:
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                this.tp = false;
                this.XL = -1;
                v5();
                stopNestedScroll();
                break;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                action = this.XL;
                if (action != -1) {
                    int j6 = n.j6(motionEvent, action);
                    if (j6 != -1) {
                        action = (int) n.Hw(motionEvent, j6);
                        if (Math.abs(action - this.Zo) > this.J8 && (getNestedScrollAxes() & 2) == 0) {
                            this.tp = true;
                            this.Zo = action;
                            Hw();
                            this.EQ.addMovement(motionEvent);
                            this.Mr = 0;
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
            case 6:
                j6(motionEvent);
                break;
        }
        return this.tp;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Hw();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int j6 = n.j6(motionEvent);
        if (j6 == 0) {
            this.Mr = 0;
        }
        obtain.offsetLocation(0.0f, (float) this.Mr);
        switch (j6) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                if (getChildCount() != 0) {
                    boolean z = !this.FH.j6();
                    this.tp = z;
                    if (z) {
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (!this.FH.j6()) {
                        this.FH.gn();
                    }
                    this.Zo = (int) motionEvent.getY();
                    this.XL = n.DW(motionEvent, 0);
                    startNestedScroll(2);
                    break;
                }
                return false;
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                if (this.tp) {
                    VelocityTracker velocityTracker = this.EQ;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.QX);
                    j6 = (int) x.DW(velocityTracker, this.XL);
                    if (Math.abs(j6) > this.Ws) {
                        Zo(-j6);
                    }
                    this.XL = -1;
                    Zo();
                    break;
                }
                break;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                int j62 = n.j6(motionEvent, this.XL);
                if (j62 != -1) {
                    int i;
                    int Hw = (int) n.Hw(motionEvent, j62);
                    j6 = this.Zo - Hw;
                    if (dispatchNestedPreScroll(0, j6, this.j3, this.aM)) {
                        j6 -= this.j3[1];
                        obtain.offsetLocation(0.0f, (float) this.aM[1]);
                        this.Mr += this.aM[1];
                    }
                    if (this.tp || Math.abs(j6) <= this.J8) {
                        i = j6;
                    } else {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.tp = true;
                        if (j6 > 0) {
                            i = j6 - this.J8;
                        } else {
                            i = j6 + this.J8;
                        }
                    }
                    if (this.tp) {
                        Object obj;
                        this.Zo = Hw - this.aM[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        j6 = z.j6(this);
                        if (j6 == 0 || (j6 == 1 && scrollRange > 0)) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (j6(0, i, 0, getScrollY(), 0, scrollRange, 0, 0, true) && !hasNestedScrollingParent()) {
                            this.EQ.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        if (!dispatchNestedScroll(0, scrollY2, 0, i - scrollY2, this.aM)) {
                            if (obj != null) {
                                VH();
                                j6 = scrollY + i;
                                if (j6 < 0) {
                                    this.Hw.j6(((float) i) / ((float) getHeight()), n.FH(motionEvent, j62) / ((float) getWidth()));
                                    if (!this.v5.j6()) {
                                        this.v5.FH();
                                    }
                                } else if (j6 > scrollRange) {
                                    this.v5.j6(((float) i) / ((float) getHeight()), 1.0f - (n.FH(motionEvent, j62) / ((float) getWidth())));
                                    if (!this.Hw.j6()) {
                                        this.Hw.FH();
                                    }
                                }
                                if (!(this.Hw == null || (this.Hw.j6() && this.v5.j6()))) {
                                    z.DW(this);
                                    break;
                                }
                            }
                        }
                        this.Zo -= this.aM[1];
                        obtain.offsetLocation(0.0f, (float) this.aM[1]);
                        this.Mr += this.aM[1];
                        break;
                    }
                }
                Log.e("NestedScrollView", "Invalid pointerId=" + this.XL + " in onTouchEvent");
                break;
                break;
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                if (this.tp && getChildCount() > 0) {
                    this.XL = -1;
                    Zo();
                    break;
                }
            case 5:
                j6 = n.DW(motionEvent);
                this.Zo = (int) n.Hw(motionEvent, j6);
                this.XL = n.DW(motionEvent, j6);
                break;
            case 6:
                j6(motionEvent);
                this.Zo = (int) n.Hw(motionEvent, n.j6(motionEvent, this.XL));
                break;
        }
        if (this.EQ != null) {
            this.EQ.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    private void j6(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (n.DW(motionEvent, action) == this.XL) {
            action = action == 0 ? 1 : 0;
            this.Zo = (int) n.Hw(motionEvent, action);
            this.XL = n.DW(motionEvent, action);
            if (this.EQ != null) {
                this.EQ.clear();
            }
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((n.Hw(motionEvent) & 2) == 0) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 8:
                if (this.tp) {
                    return false;
                }
                float v5 = n.v5(motionEvent, 9);
                if (v5 == 0.0f) {
                    return false;
                }
                int verticalScrollFactorCompat = (int) (v5 * getVerticalScrollFactorCompat());
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
        if (this.yS == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.yS = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.yS;
    }

    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    boolean j6(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        boolean z2;
        int j6 = z.j6(this);
        Object obj = computeHorizontalScrollRange() > computeHorizontalScrollExtent() ? 1 : null;
        Object obj2 = computeVerticalScrollRange() > computeVerticalScrollExtent() ? 1 : null;
        Object obj3 = (j6 == 0 || (j6 == 1 && obj != null)) ? 1 : null;
        obj = (j6 == 0 || (j6 == 1 && obj2 != null)) ? 1 : null;
        int i9 = i3 + i;
        if (obj3 == null) {
            i7 = 0;
        }
        j6 = i4 + i2;
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
        if (j6 > i13) {
            z3 = true;
        } else if (j6 < i12) {
            z3 = true;
            i13 = i12;
        } else {
            i13 = j6;
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

    private View j6(boolean z, int i, int i2) {
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

    public boolean j6(int i) {
        int i2 = i == 130 ? 1 : 0;
        int height = getHeight();
        if (i2 != 0) {
            this.DW.top = getScrollY() + height;
            i2 = getChildCount();
            if (i2 > 0) {
                View childAt = getChildAt(i2 - 1);
                if (this.DW.top + height > childAt.getBottom()) {
                    this.DW.top = childAt.getBottom() - height;
                }
            }
        } else {
            this.DW.top = getScrollY() - height;
            if (this.DW.top < 0) {
                this.DW.top = 0;
            }
        }
        this.DW.bottom = this.DW.top + height;
        return j6(i, this.DW.top, this.DW.bottom);
    }

    public boolean DW(int i) {
        int i2 = i == 130 ? 1 : 0;
        int height = getHeight();
        this.DW.top = 0;
        this.DW.bottom = height;
        if (i2 != 0) {
            i2 = getChildCount();
            if (i2 > 0) {
                this.DW.bottom = getChildAt(i2 - 1).getBottom() + getPaddingBottom();
                this.DW.top = this.DW.bottom - height;
            }
        }
        return j6(i, this.DW.top, this.DW.bottom);
    }

    private boolean j6(int i, int i2, int i3) {
        boolean z = false;
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = scrollY + height;
        boolean z2 = i == 33;
        View j6 = j6(z2, i2, i3);
        if (j6 == null) {
            j6 = this;
        }
        if (i2 < scrollY || i3 > i4) {
            v5(z2 ? i2 - scrollY : i3 - i4);
            z = true;
        }
        if (j6 != findFocus()) {
            j6.requestFocus(i);
        }
        return z;
    }

    public boolean FH(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !j6(findNextFocus, maxScrollAmount, getHeight())) {
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
            v5(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.DW);
            offsetDescendantRectToMyCoords(findNextFocus, this.DW);
            v5(j6(this.DW));
            findNextFocus.requestFocus(i);
        }
        if (findFocus != null && findFocus.isFocused() && j6(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    private boolean j6(View view) {
        return !j6(view, 0, getHeight());
    }

    private boolean j6(View view, int i, int i2) {
        view.getDrawingRect(this.DW);
        offsetDescendantRectToMyCoords(view, this.DW);
        return this.DW.bottom + i >= getScrollY() && this.DW.top - i <= getScrollY() + i2;
    }

    private void v5(int i) {
        if (i == 0) {
            return;
        }
        if (this.J0) {
            j6(0, i);
        } else {
            scrollBy(0, i);
        }
    }

    public final void j6(int i, int i2) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.j6 > 250) {
                int max = Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
                int scrollY = getScrollY();
                this.FH.j6(getScrollX(), scrollY, 0, Math.max(0, Math.min(scrollY + i2, max)) - scrollY);
                z.DW(this);
            } else {
                if (!this.FH.j6()) {
                    this.FH.gn();
                }
                scrollBy(i, i2);
            }
            this.j6 = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    public final void DW(int i, int i2) {
        j6(i - getScrollX(), i2 - getScrollY());
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
        if (this.FH.VH()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int DW = this.FH.DW();
            int FH = this.FH.FH();
            if (scrollX != DW || scrollY != FH) {
                int scrollRange = getScrollRange();
                int j6 = z.j6(this);
                int i = (j6 == 0 || (j6 == 1 && scrollRange > 0)) ? 1 : 0;
                j6(DW - scrollX, FH - scrollY, scrollX, scrollY, 0, scrollRange, 0, 0, false);
                if (i != 0) {
                    VH();
                    if (FH <= 0 && scrollY > 0) {
                        this.Hw.j6((int) this.FH.Zo());
                    } else if (FH >= scrollRange && scrollY < scrollRange) {
                        this.v5.j6((int) this.FH.Zo());
                    }
                }
            }
        }
    }

    private void DW(View view) {
        view.getDrawingRect(this.DW);
        offsetDescendantRectToMyCoords(view, this.DW);
        int j6 = j6(this.DW);
        if (j6 != 0) {
            scrollBy(0, j6);
        }
    }

    private boolean j6(Rect rect, boolean z) {
        int j6 = j6(rect);
        boolean z2 = j6 != 0;
        if (z2) {
            if (z) {
                scrollBy(0, j6);
            } else {
                j6(0, j6);
            }
        }
        return z2;
    }

    protected int j6(Rect rect) {
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
        if (this.VH) {
            this.u7 = view2;
        } else {
            DW(view2);
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
        if (findNextFocus == null || j6(findNextFocus)) {
            return false;
        }
        return findNextFocus.requestFocus(i, rect);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return j6(rect, z);
    }

    public void requestLayout() {
        this.VH = true;
        super.requestLayout();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.VH = false;
        if (this.u7 != null && j6(this.u7, (View) this)) {
            DW(this.u7);
        }
        this.u7 = null;
        if (!this.gn) {
            if (this.U2 != null) {
                scrollTo(getScrollX(), this.U2.j6);
                this.U2 = null;
            }
            int max = Math.max(0, (getChildCount() > 0 ? getChildAt(0).getMeasuredHeight() : 0) - (((i4 - i2) - getPaddingBottom()) - getPaddingTop()));
            if (getScrollY() > max) {
                scrollTo(getScrollX(), max);
            } else if (getScrollY() < 0) {
                scrollTo(getScrollX(), 0);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.gn = true;
    }

    public void onAttachedToWindow() {
        this.gn = false;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && j6(findFocus, 0, i4)) {
            findFocus.getDrawingRect(this.DW);
            offsetDescendantRectToMyCoords(findFocus, this.DW);
            v5(j6(this.DW));
        }
    }

    private static boolean j6(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        boolean z = (parent instanceof ViewGroup) && j6((View) parent, view2);
        return z;
    }

    public void Hw(int i) {
        if (getChildCount() > 0) {
            int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
            int height2 = getChildAt(0).getHeight();
            this.FH.j6(getScrollX(), getScrollY(), 0, i, 0, 0, 0, Math.max(0, height2 - height), 0, height / 2);
            z.DW(this);
        }
    }

    private void Zo(int i) {
        int scrollY = getScrollY();
        boolean z = (scrollY > 0 || i > 0) && (scrollY < getScrollRange() || i < 0);
        if (!dispatchNestedPreFling(0.0f, (float) i)) {
            dispatchNestedFling(0.0f, (float) i, z);
            if (z) {
                Hw(i);
            }
        }
    }

    private void Zo() {
        this.tp = false;
        v5();
        stopNestedScroll();
        if (this.Hw != null) {
            this.Hw.FH();
            this.v5.FH();
        }
    }

    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int DW = DW(i, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth());
            int DW2 = DW(i2, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight());
            if (DW != getScrollX() || DW2 != getScrollY()) {
                super.scrollTo(DW, DW2);
            }
        }
    }

    private void VH() {
        if (z.j6(this) == 2) {
            this.Hw = null;
            this.v5 = null;
        } else if (this.Hw == null) {
            Context context = getContext();
            this.Hw = new EdgeEffectCompat(context);
            this.v5 = new EdgeEffectCompat(context);
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.Hw != null) {
            int save;
            int width;
            int scrollY = getScrollY();
            if (!this.Hw.j6()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.translate((float) getPaddingLeft(), (float) Math.min(0, scrollY));
                this.Hw.j6(width, getHeight());
                if (this.Hw.j6(canvas)) {
                    z.DW(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.v5.j6()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                int height = getHeight();
                canvas.translate((float) ((-width) + getPaddingLeft()), (float) (Math.max(getScrollRange(), scrollY) + height));
                canvas.rotate(180.0f, (float) width, 0.0f);
                this.v5.j6(width, height);
                if (this.v5.j6(canvas)) {
                    z.DW(this);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    private static int DW(int i, int i2, int i3) {
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
        this.U2 = savedState;
        requestLayout();
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.j6 = getScrollY();
        return savedState;
    }
}
