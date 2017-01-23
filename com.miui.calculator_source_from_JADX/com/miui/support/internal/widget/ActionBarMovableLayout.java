package com.miui.support.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.OverScroller;
import com.miui.support.app.ActionBar.OnScrollListener;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.util.DeviceHelper;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;

public class ActionBarMovableLayout extends ActionBarOverlayLayout {
    private static final String f2945d;
    private View f2946e;
    private OverScroller f2947f;
    private int f2948g;
    private boolean f2949h;
    private float f2950i;
    private float f2951j;
    private int f2952k;
    private int f2953l;
    private final int f2954m;
    private final int f2955n;
    private final int f2956o;
    private int f2957p;
    private int f2958q;
    private int f2959r;
    private int f2960s;
    private int f2961t;
    private boolean f2962u;
    private boolean f2963v;
    private boolean f2964w;
    private VelocityTracker f2965x;
    private OnScrollListener f2966y;

    static {
        f2945d = ActionBarMovableLayout.class.getSimpleName();
    }

    public ActionBarMovableLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2953l = -1;
        this.f2957p = -1;
        this.f2959r = -1;
        this.f2961t = 8;
        this.f2963v = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0264R.styleable.ActionBarMovableLayout, C0264R.attr.actionBarMovableLayoutStyle, 0);
        if (DeviceHelper.f2553e) {
            this.f2958q = obtainStyledAttributes.getDimensionPixelSize(C0264R.styleable.ActionBarMovableLayout_overScrollRange, 0);
        }
        this.f2957p = obtainStyledAttributes.getDimensionPixelSize(C0264R.styleable.ActionBarMovableLayout_scrollRange, -1);
        this.f2959r = obtainStyledAttributes.getDimensionPixelSize(C0264R.styleable.ActionBarMovableLayout_scrollStart, -1);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f2954m = viewConfiguration.getScaledTouchSlop();
        this.f2947f = new OverScroller(context);
        this.f2955n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f2956o = viewConfiguration.getScaledMaximumFlingVelocity();
        setOverScrollMode(0);
        obtainStyledAttributes.recycle();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        View findViewById = findViewById(C0264R.id.content_mask);
        if (findViewById != null && findViewById.getVisibility() == 0) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 2 && this.f2949h) {
            return true;
        }
        switch (action & 255) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                this.f2950i = motionEvent.getY();
                this.f2951j = motionEvent.getX();
                this.f2948g = motionEvent.getPointerId(0);
                m4682h();
                this.f2965x.addMovement(motionEvent);
                this.f2947f.forceFinished(true);
                break;
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                this.f2949h = false;
                this.f2948g = -1;
                m4684j();
                m4694d();
                break;
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                if (m4689a(motionEvent)) {
                    this.f2949h = true;
                    m4683i();
                    this.f2965x.addMovement(motionEvent);
                    m4692c();
                    break;
                }
                break;
            case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                m4681b(motionEvent);
                break;
        }
        return this.f2949h;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        m4683i();
        this.f2965x.addMovement(motionEvent);
        int b;
        switch (motionEvent.getAction() & 255) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                this.f2950i = motionEvent.getY();
                this.f2948g = motionEvent.getPointerId(0);
                break;
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                if (this.f2949h) {
                    this.f2949h = false;
                    this.f2948g = -1;
                    b = m4691b();
                    if (Math.abs(b) <= this.f2955n) {
                        if (!this.f2947f.springBack(0, this.f2952k, 0, 0, 0, getScrollRange())) {
                            m4695e();
                            break;
                        }
                        invalidate();
                        break;
                    }
                    m4688a(b);
                    break;
                }
                break;
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                if (!this.f2949h) {
                    if (m4689a(motionEvent)) {
                        this.f2949h = true;
                        m4683i();
                        this.f2965x.addMovement(motionEvent);
                        m4692c();
                        break;
                    }
                }
                b = motionEvent.findPointerIndex(this.f2948g);
                if (b != -1) {
                    float y = motionEvent.getY(b);
                    int i = 0;
                    boolean overScrollBy = overScrollBy(0, (int) (y - this.f2950i), i, this.f2952k, 0, getScrollRange(), 0, getOverScrollDistance(), true);
                    this.f2950i = y;
                    if (overScrollBy) {
                        if (this.f2952k == 0) {
                            this.f2949h = false;
                            this.f2948g = -1;
                            motionEvent.setAction(0);
                            dispatchTouchEvent(motionEvent);
                        }
                        this.f2965x.clear();
                        break;
                    }
                }
                return false;
                break;
            case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                b = motionEvent.getActionIndex();
                this.f2950i = (float) ((int) motionEvent.getY(b));
                this.f2948g = motionEvent.getPointerId(b);
                break;
            case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                m4681b(motionEvent);
                this.f2950i = (float) ((int) motionEvent.getY(motionEvent.findPointerIndex(this.f2948g)));
                break;
        }
        return true;
    }

    public void computeScroll() {
        if (this.f2947f.computeScrollOffset()) {
            int i = this.f2952k;
            int currY = this.f2947f.getCurrY();
            if (i != currY) {
                int i2 = 0;
                overScrollBy(0, currY - i, i2, this.f2952k, 0, getScrollRange(), 0, getOverScrollDistance(), true);
            }
            postInvalidateOnAnimation();
        } else if (this.f2964w) {
            m4695e();
            this.f2964w = false;
        }
    }

    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        boolean z2 = true;
        int overScrollMode = getOverScrollMode();
        boolean z3 = computeVerticalScrollRange() > computeVerticalScrollExtent();
        if (overScrollMode == 0 || (overScrollMode == 1 && z3)) {
            z3 = true;
        } else {
            z3 = false;
        }
        overScrollMode = i4 + i2;
        if (!z3) {
            i8 = 0;
        }
        int i9 = i8 + i6;
        if (overScrollMode <= i9) {
            if (overScrollMode < 0) {
                i9 = 0;
            } else {
                z2 = false;
                i9 = overScrollMode;
            }
        }
        onOverScrolled(0, i9, false, z2);
        return z2;
    }

    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        m4687a((float) i2);
        this.f2952k = i2;
        if (this.f2952k == 0 && z2) {
            int b = m4691b();
            if (Math.abs(b) > this.f2955n * 2 && this.f2966y != null) {
                this.f2966y.m3252a(((float) (-b)) * 0.2f, 500);
            }
        }
    }

    public void setInitialMotionY(int i) {
        this.f2959r = i;
    }

    public void setOverScrollDistance(int i) {
        if (DeviceHelper.f2553e) {
            this.f2958q = i;
        }
    }

    public int getOverScrollDistance() {
        return DeviceHelper.f2553e ? this.f2958q : 0;
    }

    public void setScrollRange(int i) {
        this.f2957p = i;
    }

    public int getScrollRange() {
        return this.f2957p;
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.f2966y = onScrollListener;
    }

    public void setScrollStart(int i) {
        this.f2960s = i;
    }

    public int getScrollStart() {
        return this.f2960s;
    }

    public void setSpringBackEnabled(boolean z) {
        this.f2963v = z;
    }

    private boolean m4680a(View view, int i, int i2) {
        if (view == null) {
            return false;
        }
        int y = (int) view.getY();
        int x = (int) view.getX();
        int y2 = (int) (view.getY() + ((float) view.getHeight()));
        int x2 = (int) (view.getX() + ((float) view.getWidth()));
        if (view == this.f2946e) {
            int top = this.b.getTop();
            y += top;
            y2 += top;
        }
        if (i2 < y || i2 >= r1 || i < x || i >= x2) {
            return false;
        }
        return true;
    }

    private void m4682h() {
        if (this.f2965x == null) {
            this.f2965x = VelocityTracker.obtain();
        } else {
            this.f2965x.clear();
        }
    }

    private void m4683i() {
        if (this.f2965x == null) {
            this.f2965x = VelocityTracker.obtain();
        }
    }

    private void m4684j() {
        if (this.f2965x != null) {
            this.f2965x.recycle();
            this.f2965x = null;
        }
    }

    void m4686a() {
        this.f2946e = this.b.getTabContainer();
    }

    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        if (view != this.c) {
            super.measureChildWithMargins(view, i, i2, i3, i4);
            return;
        }
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        MarginLayoutParams marginLayoutParams2 = (MarginLayoutParams) this.a.getLayoutParams();
        view.measure(getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width), getChildMeasureSpec(i3, (((marginLayoutParams2.topMargin + (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.bottomMargin) + this.a.getMeasuredHeight())) - getScrollRange()) - getOverScrollDistance()) - this.f2960s, marginLayoutParams.height));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        boolean z2 = !this.f2962u || m4685k();
        if (!this.f2962u) {
            if (this.f2959r < 0) {
                this.f2959r = this.f2957p;
            }
            this.f2952k = this.f2959r;
            this.f2962u = true;
        }
        if (z2) {
            m4693c((float) this.f2952k);
        }
    }

    protected int computeVerticalScrollExtent() {
        return 0;
    }

    protected int computeVerticalScrollRange() {
        return getScrollRange();
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    protected int m4691b() {
        VelocityTracker velocityTracker = this.f2965x;
        velocityTracker.computeCurrentVelocity(1000, (float) this.f2956o);
        return (int) velocityTracker.getYVelocity(this.f2948g);
    }

    protected void m4688a(int i) {
        int overScrollDistance = getOverScrollDistance();
        this.f2947f.fling(0, this.f2952k, 0, i, 0, 0, 0, getScrollRange(), 0, overScrollDistance);
        this.f2964w = true;
        postInvalidate();
    }

    protected boolean m4689a(MotionEvent motionEvent) {
        int i = 0;
        int i2 = this.f2948g;
        if (i2 == -1) {
            return false;
        }
        i2 = motionEvent.findPointerIndex(i2);
        if (i2 == -1) {
            Log.w(f2945d, "invalid pointer index");
            return false;
        }
        boolean z;
        float x = motionEvent.getX(i2);
        float y = motionEvent.getY(i2);
        int i3 = (int) (y - this.f2950i);
        int abs = Math.abs(i3);
        int abs2 = (int) Math.abs(x - this.f2951j);
        i2 = (m4680a(this.c, (int) x, (int) y) || m4680a(this.f2946e, (int) x, (int) y)) ? true : 0;
        if (i2 == 0 || abs <= this.f2954m || abs <= abs2) {
            z = false;
        } else {
            if (this.f2952k == 0) {
                if (i3 < 0) {
                    z = false;
                } else if (this.f2966y != null && this.f2966y.m3255c()) {
                    z = false;
                }
            } else if (i3 > 0 && this.f2952k >= getOverScrollDistance() && this.f2966y != null && this.f2966y.m3255c()) {
                z = false;
            }
            z = true;
        }
        if (z) {
            this.f2950i = y;
            this.f2951j = x;
            if (i3 > 0) {
                i = 1;
            }
            this.f2953l = i;
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
        return z;
    }

    protected void m4692c() {
        if (this.f2966y != null) {
            this.f2966y.m3251a();
        }
    }

    protected void m4687a(float f) {
        m4693c(f);
        if (this.f2966y != null) {
            this.f2966y.m3253a(this.f2953l, f / ((float) this.f2957p));
        }
    }

    protected void m4694d() {
        this.f2953l = -1;
        if (this.f2966y != null) {
            this.f2966y.m3254b();
        }
    }

    protected float m4690b(float f) {
        float f2 = ((((float) (-this.f2958q)) + f) - ((float) this.f2957p)) - ((float) this.f2960s);
        m4686a();
        if (this.f2946e == null || this.f2946e.getVisibility() != 0) {
            return f2;
        }
        return f2 - ((float) this.f2946e.getHeight());
    }

    protected void m4693c(float f) {
        float b = m4690b(f);
        this.c.setTranslationY(b);
        m4686a();
        if (this.f2946e != null) {
            this.f2946e.setTranslationY(b);
        }
    }

    protected void m4695e() {
        if (this.f2963v) {
            int scrollRange = getScrollRange();
            this.f2947f.startScroll(0, this.f2952k, 0, this.f2952k > scrollRange / 2 ? scrollRange - this.f2952k : -this.f2952k, 800);
            postInvalidateOnAnimation();
        }
    }

    private void m4681b(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (motionEvent.getPointerId(action) == this.f2948g) {
            action = action == 0 ? 1 : 0;
            this.f2950i = (float) ((int) motionEvent.getY(action));
            this.f2948g = motionEvent.getPointerId(action);
            if (this.f2965x != null) {
                this.f2965x.clear();
            }
        }
    }

    private boolean m4685k() {
        m4686a();
        if (this.f2946e == null) {
            return false;
        }
        int visibility = this.f2946e.getVisibility();
        if (visibility == this.f2961t) {
            return false;
        }
        this.f2961t = visibility;
        return true;
    }

    public void setMotionY(int i) {
        this.f2952k = i;
        m4687a((float) i);
    }
}
