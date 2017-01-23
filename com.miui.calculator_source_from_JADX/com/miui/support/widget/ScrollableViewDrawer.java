package com.miui.support.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.Scroller;
import com.miui.support.C0234R;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import com.miui.support.util.AttributeResolver;

public class ScrollableViewDrawer extends FrameLayout {
    private int f4417a;
    private int f4418b;
    private int f4419c;
    private View f4420d;
    private View f4421e;
    private IScrollableView f4422f;
    private int f4423g;
    private boolean f4424h;
    private Drawable f4425i;
    private int f4426j;
    private DrawerListener f4427k;
    private VelocityTracker f4428l;
    private Scroller f4429m;
    private int f4430n;
    private int f4431o;
    private int f4432p;
    private boolean f4433q;
    private boolean f4434r;
    private boolean f4435s;
    private float f4436t;
    private float f4437u;
    private float f4438v;
    private int f4439w;

    public interface IScrollableView {
        boolean m6077a();
    }

    private static class AdapterViewWrapper implements IScrollableView {
        private AdapterView<?> f4415a;

        public AdapterViewWrapper(AdapterView<?> adapterView) {
            this.f4415a = adapterView;
        }

        public boolean m6078a() {
            int firstVisiblePosition = this.f4415a.getFirstVisiblePosition();
            if (firstVisiblePosition > 0) {
                Log.d("ScrollableViewDrawer", "canScrollDown true first visible " + firstVisiblePosition);
                return true;
            }
            int paddingTop = this.f4415a.getPaddingTop();
            int childCount = this.f4415a.getChildCount();
            for (firstVisiblePosition = 0; firstVisiblePosition < childCount; firstVisiblePosition++) {
                if (this.f4415a.getChildAt(firstVisiblePosition).getTop() < paddingTop) {
                    Log.d("ScrollableViewDrawer", "canScrollDown true " + firstVisiblePosition);
                    return true;
                }
            }
            return false;
        }
    }

    public interface DrawerListener {
        void m6079a(ScrollableViewDrawer scrollableViewDrawer);

        void m6080a(ScrollableViewDrawer scrollableViewDrawer, float f);

        void m6081b(ScrollableViewDrawer scrollableViewDrawer);
    }

    private static class ScrollViewWrapper implements IScrollableView {
        private ScrollView f4416a;

        public ScrollViewWrapper(ScrollView scrollView) {
            this.f4416a = scrollView;
        }

        public boolean m6082a() {
            return this.f4416a.getScrollY() > 0;
        }
    }

    public ScrollableViewDrawer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrollableViewDrawer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4431o = -1;
        this.f4430n = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f4429m = new Scroller(context);
        this.f4428l = VelocityTracker.obtain();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0234R.styleable.ScrollableViewDrawer, i, 0);
        this.f4417a = obtainStyledAttributes.getResourceId(C0234R.styleable.ScrollableViewDrawer_contentView, 0);
        if (this.f4417a == 0) {
            throw new IllegalArgumentException("The contentView attribute is required and must refer to a valid child.");
        }
        this.f4418b = obtainStyledAttributes.getResourceId(C0234R.styleable.ScrollableViewDrawer_targetView, 0);
        if (this.f4418b == 0) {
            throw new IllegalArgumentException("The targetView attribute is required and must refer to a valid child.");
        }
        this.f4419c = obtainStyledAttributes.getResourceId(C0234R.styleable.ScrollableViewDrawer_scrollableView, 0);
        if (this.f4419c == 0) {
            throw new IllegalArgumentException("The scrollableView attribute is required and must refer to a valid child.");
        }
        this.f4425i = obtainStyledAttributes.getDrawable(C0234R.styleable.ScrollableViewDrawer_scrollDivider);
        if (this.f4425i == null) {
            this.f4425i = AttributeResolver.m5320b(context, C0234R.attr.scrollDivider);
        }
        if (this.f4425i != null) {
            this.f4426j = this.f4425i.getIntrinsicHeight();
        }
        this.f4424h = obtainStyledAttributes.getBoolean(C0234R.styleable.ScrollableViewDrawer_dragEnabled, true);
        obtainStyledAttributes.recycle();
    }

    protected void onFinishInflate() {
        this.f4420d = findViewById(this.f4417a);
        if (this.f4420d == null) {
            throw new IllegalArgumentException("The contentView attribute is must refer to an existing child.");
        } else if (this.f4420d.getParent() != this) {
            throw new IllegalArgumentException("The contentView attribute is must be a direct child of ScrollableViewDrawer.");
        } else {
            this.f4421e = findViewById(this.f4418b);
            if (this.f4421e == null) {
                throw new IllegalArgumentException("The targetView attribute is must refer to an existing child.");
            }
            View findViewById = this.f4421e.findViewById(this.f4419c);
            if (findViewById == null) {
                throw new IllegalArgumentException("The scrollableView attribute is must refer to an existing child of targetView.");
            } else if (findViewById instanceof IScrollableView) {
                this.f4422f = (IScrollableView) findViewById;
            } else if (findViewById instanceof ScrollView) {
                this.f4422f = new ScrollViewWrapper((ScrollView) findViewById);
            } else if (findViewById instanceof AdapterView) {
                this.f4422f = new AdapterViewWrapper((AdapterView) findViewById);
            } else {
                throw new IllegalArgumentException("The scrollableView attribute is must refer to an ScrollView or AdapterView or IScrollableViewWrapper.");
            }
        }
    }

    private int getVerticalRange() {
        if (this.f4423g == 0) {
            this.f4423g = this.f4420d.getMeasuredHeight();
        }
        return this.f4423g;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.f4424h) {
            return super.dispatchTouchEvent(motionEvent);
        }
        float y;
        int findPointerIndex;
        switch (motionEvent.getActionMasked()) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                this.f4431o = motionEvent.getPointerId(0);
                this.f4433q = false;
                this.f4428l.clear();
                this.f4428l.addMovement(motionEvent);
                this.f4436t = motionEvent.getX(0);
                y = motionEvent.getY(0);
                this.f4437u = y;
                this.f4438v = y;
                this.f4439w = (int) this.f4421e.getTranslationY();
                break;
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                if (!this.f4433q) {
                    this.f4428l.clear();
                }
                this.f4433q = false;
                this.f4435s = false;
                this.f4434r = false;
                break;
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                findPointerIndex = motionEvent.findPointerIndex(this.f4431o);
                if (findPointerIndex == -1) {
                    this.f4431o = motionEvent.getPointerId(0);
                    findPointerIndex = 0;
                }
                float x = motionEvent.getX(findPointerIndex) - this.f4436t;
                float y2 = motionEvent.getY(findPointerIndex) - this.f4437u;
                if (!(this.f4433q || this.f4435s)) {
                    if (this.f4439w == getVerticalRange() && y2 < 0.0f) {
                        this.f4433q = true;
                    } else if (y2 > ((float) this.f4430n)) {
                        this.f4433q = m6083a();
                    }
                    if (this.f4433q) {
                        Log.d("ScrollableViewDrawer", "determine drag");
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (Math.abs(y2) > ((float) this.f4430n) && !this.f4435s) {
                        this.f4434r = true;
                    }
                    if (Math.abs(x) > ((float) this.f4430n) && !this.f4434r) {
                        this.f4435s = true;
                    }
                }
                if (!this.f4433q) {
                    this.f4428l.addMovement(motionEvent);
                    this.f4438v = motionEvent.getY(findPointerIndex);
                    break;
                }
                break;
            case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                findPointerIndex = motionEvent.getActionIndex();
                if (motionEvent.getPointerId(findPointerIndex) == this.f4431o) {
                    if (findPointerIndex == 0) {
                        findPointerIndex = 1;
                    } else {
                        findPointerIndex = 0;
                    }
                    this.f4431o = motionEvent.getPointerId(findPointerIndex);
                    this.f4436t = motionEvent.getX(findPointerIndex);
                    y = motionEvent.getY(findPointerIndex);
                    this.f4437u = y;
                    this.f4438v = y;
                    break;
                }
                break;
        }
        if (super.dispatchTouchEvent(motionEvent) || this.f4433q) {
            return true;
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                this.f4428l.addMovement(motionEvent);
                this.f4428l.computeCurrentVelocity(1000);
                if (this.f4439w == 0 || this.f4439w == getVerticalRange()) {
                    m6084b();
                } else {
                    if (this.f4428l.getYVelocity() > 5.0f) {
                        this.f4429m.startScroll(0, this.f4439w, 0, getVerticalRange() - this.f4439w);
                    } else {
                        this.f4429m.startScroll(0, this.f4439w, 0, -this.f4439w);
                    }
                    invalidate();
                }
                this.f4428l.clear();
                break;
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                this.f4428l.addMovement(motionEvent);
                int findPointerIndex = motionEvent.findPointerIndex(this.f4431o);
                if (findPointerIndex == -1) {
                    this.f4431o = motionEvent.getPointerId(0);
                    findPointerIndex = 0;
                }
                float y = motionEvent.getY(findPointerIndex);
                this.f4439w = Math.max(0, Math.min(((int) (y - this.f4438v)) + this.f4439w, getVerticalRange()));
                this.f4438v = y;
                m6086d();
                invalidate();
                break;
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                if (this.f4439w == 0 || this.f4439w == getVerticalRange()) {
                    m6084b();
                } else {
                    this.f4429m.startScroll(0, this.f4439w, 0, -this.f4439w);
                    invalidate();
                }
                this.f4428l.clear();
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f4424h && this.f4433q;
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        if (view == this.f4420d) {
            int paddingLeft = getPaddingLeft();
            int width = getWidth() - getPaddingRight();
            int top = view.getTop();
            int i = this.f4439w + top;
            if (this.f4426j > 0) {
                this.f4425i.setBounds(paddingLeft, i - this.f4426j, width, i);
                this.f4425i.draw(canvas);
                i -= this.f4426j;
            }
            canvas.save();
            canvas.clipRect(paddingLeft, top, width, i);
        }
        boolean drawChild = super.drawChild(canvas, view, j);
        if (view == this.f4420d) {
            canvas.restore();
        }
        return drawChild;
    }

    private boolean m6083a() {
        return (this.f4421e == null || this.f4439w != 0 || this.f4422f.m6077a()) ? false : true;
    }

    public void computeScroll() {
        super.computeScroll();
        if (this.f4421e != null && this.f4429m.computeScrollOffset()) {
            this.f4439w = this.f4429m.getCurrY();
            m6086d();
            postInvalidateOnAnimation();
        }
    }

    public void setDragEnabled(boolean z) {
        this.f4424h = z;
    }

    public void setDrawerListener(DrawerListener drawerListener) {
        this.f4427k = drawerListener;
    }

    private void m6084b() {
        int i;
        if (this.f4439w == 0) {
            if (!this.f4433q) {
                i = 0;
            }
            i = 1;
        } else {
            if (this.f4439w == getVerticalRange() && !this.f4433q) {
                i = 2;
            }
            i = 1;
        }
        if (this.f4432p != i) {
            this.f4432p = i;
            m6085c();
        } else if (this.f4432p == 1) {
            m6085c();
        }
    }

    private void m6085c() {
        if (this.f4427k != null) {
            switch (this.f4432p) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                    this.f4427k.m6081b(this);
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    this.f4427k.m6080a(this, ((float) this.f4439w) / ((float) getVerticalRange()));
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    this.f4427k.m6079a(this);
                default:
            }
        }
    }

    private void m6086d() {
        if (this.f4424h && this.f4421e != null) {
            this.f4421e.setTranslationY((float) this.f4439w);
            m6084b();
        }
    }
}
