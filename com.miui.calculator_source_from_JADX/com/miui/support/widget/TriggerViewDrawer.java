package com.miui.support.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Scroller;
import com.miui.support.C0234R;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;

public class TriggerViewDrawer extends RelativeLayout {
    private int f4495A;
    private boolean f4496B;
    private boolean f4497C;
    private int f4498a;
    private int f4499b;
    private int f4500c;
    private int f4501d;
    private View f4502e;
    private View f4503f;
    private View f4504g;
    private ScrollableView f4505h;
    private View f4506i;
    private Drawable f4507j;
    private boolean f4508k;
    private int f4509l;
    private int f4510m;
    private int f4511n;
    private DrawerListener f4512o;
    private TriggerListener f4513p;
    private boolean f4514q;
    private VelocityTracker f4515r;
    private Scroller f4516s;
    private int f4517t;
    private int f4518u;
    private float f4519v;
    private float f4520w;
    private View f4521x;
    private float f4522y;
    private int f4523z;

    public interface ScrollableView {
        boolean m6114a();
    }

    private static class AdapterViewWrapper implements ScrollableView {
        private AdapterView<?> f4493a;

        public AdapterViewWrapper(AdapterView<?> adapterView) {
            this.f4493a = adapterView;
        }

        public boolean m6115a() {
            int firstVisiblePosition = this.f4493a.getFirstVisiblePosition();
            if (firstVisiblePosition > 0) {
                Log.d("TriggerViewDrawer", "canScrollDown true first visible " + firstVisiblePosition);
                return true;
            }
            int paddingTop = this.f4493a.getPaddingTop();
            int childCount = this.f4493a.getChildCount();
            for (firstVisiblePosition = 0; firstVisiblePosition < childCount; firstVisiblePosition++) {
                if (this.f4493a.getChildAt(firstVisiblePosition).getTop() < paddingTop) {
                    Log.d("TriggerViewDrawer", "canScrollDown true " + firstVisiblePosition);
                    return true;
                }
            }
            return false;
        }
    }

    public interface DrawerListener {
        void m6116a(TriggerViewDrawer triggerViewDrawer);

        void m6117a(TriggerViewDrawer triggerViewDrawer, float f);

        void m6118b(TriggerViewDrawer triggerViewDrawer);
    }

    private static class FixedViewWrapper implements ScrollableView {
        public boolean m6119a() {
            return false;
        }
    }

    private static class ScrollViewWrapper implements ScrollableView {
        private ScrollView f4494a;

        public ScrollViewWrapper(ScrollView scrollView) {
            this.f4494a = scrollView;
        }

        public boolean m6120a() {
            return this.f4494a.getScrollY() > 0;
        }
    }

    public interface TriggerListener {
        void m6121a(TriggerViewDrawer triggerViewDrawer);

        void m6122a(TriggerViewDrawer triggerViewDrawer, float f);
    }

    public TriggerViewDrawer(Context context) {
        this(context, null);
    }

    public TriggerViewDrawer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0234R.attr.triggerViewDrawerStyle);
    }

    public TriggerViewDrawer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4518u = -1;
        this.f4517t = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f4516s = new Scroller(context);
        this.f4515r = VelocityTracker.obtain();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0234R.styleable.TriggerViewDrawer, i, C0234R.style.Widget_TriggerViewDrawer);
        this.f4498a = obtainStyledAttributes.getResourceId(C0234R.styleable.TriggerViewDrawer_contentView, 0);
        this.f4499b = obtainStyledAttributes.getResourceId(C0234R.styleable.TriggerViewDrawer_targetView, 0);
        if (this.f4499b == 0) {
            throw new IllegalArgumentException("The targetView attribute is required and must refer to a valid child.");
        }
        this.f4500c = obtainStyledAttributes.getResourceId(C0234R.styleable.TriggerViewDrawer_scrollableView, 0);
        this.f4501d = obtainStyledAttributes.getResourceId(C0234R.styleable.TriggerViewDrawer_triggerView, 0);
        this.f4511n = obtainStyledAttributes.getDimensionPixelSize(C0234R.styleable.TriggerViewDrawer_triggerDistance, 0);
        this.f4507j = obtainStyledAttributes.getDrawable(C0234R.styleable.TriggerViewDrawer_scrollDivider);
        if (this.f4507j != null) {
            this.f4509l = this.f4507j.getIntrinsicHeight();
        }
        this.f4508k = obtainStyledAttributes.getBoolean(C0234R.styleable.TriggerViewDrawer_dragEnabled, false);
        obtainStyledAttributes.recycle();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        if (this.f4498a > 0) {
            this.f4502e = findViewById(this.f4498a);
            if (this.f4502e == null) {
                throw new IllegalArgumentException("The contentView attribute is must refer to an existing child.");
            } else if (this.f4502e.getParent() != this) {
                throw new IllegalArgumentException("The contentView attribute is must be a direct child of TriggerViewDrawer.");
            }
        }
        this.f4503f = findViewById(this.f4499b);
        if (this.f4503f == null) {
            throw new IllegalArgumentException("The targetView attribute is must refer to an existing child.");
        }
        this.f4504g = this.f4503f;
        while (this.f4504g != null && this.f4504g.getParent() != this) {
            this.f4504g = (View) this.f4504g.getParent();
        }
        if (this.f4500c > 0) {
            View findViewById = this.f4503f.findViewById(this.f4500c);
            if (findViewById == null) {
                throw new IllegalArgumentException("The scrollableView attribute is must refer to an existing child of targetView.");
            } else if (findViewById instanceof ScrollableView) {
                this.f4505h = (ScrollableView) findViewById;
            } else if (findViewById instanceof ScrollView) {
                this.f4505h = new ScrollViewWrapper((ScrollView) findViewById);
            } else if (findViewById instanceof AdapterView) {
                this.f4505h = new AdapterViewWrapper((AdapterView) findViewById);
            } else {
                Log.w("TriggerViewDrawer", "The scrollableView is a fixed view that can't scroll all the time");
                this.f4505h = new FixedViewWrapper();
            }
        }
        if (this.f4501d > 0) {
            this.f4506i = findViewById(this.f4501d);
            if (this.f4506i == null) {
                throw new IllegalArgumentException("The triggerView attribute is must refer to an existing child.");
            } else if (this.f4506i.getParent() != this) {
                throw new IllegalArgumentException("The triggerView attribute is must be a direct child of TriggerViewDrawer.");
            }
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f4502e != null) {
            this.f4510m = ((int) this.f4502e.getY()) + this.f4502e.getHeight();
        }
        if (this.f4506i != null) {
            this.f4511n = ((int) this.f4506i.getY()) + this.f4506i.getHeight();
        }
        if (m6128a()) {
            Log.w("TriggerViewDrawer", "Height of trigger must bigger than height of content, mTriggerDistance=" + this.f4511n + ", mContentDistance=" + this.f4510m);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        if (!this.f4508k || m6128a() || ((this.f4510m <= 0 && this.f4511n <= 0) || (motionEvent.getActionMasked() != 0 && this.f4523z == 0))) {
            return super.dispatchTouchEvent(motionEvent);
        }
        float y;
        int translationY;
        switch (motionEvent.getActionMasked()) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                this.f4518u = motionEvent.getPointerId(0);
                this.f4515r.clear();
                this.f4515r.addMovement(motionEvent);
                this.f4519v = motionEvent.getX(0);
                y = motionEvent.getY(0);
                this.f4522y = y;
                this.f4520w = y;
                this.f4521x = m6123a((int) this.f4519v, (int) this.f4520w);
                this.f4523z = 1;
                this.f4495A = 0;
                this.f4497C = false;
                break;
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                translationY = (int) this.f4503f.getTranslationY();
                if (this.f4514q && translationY != 0) {
                    m6131b(translationY, -translationY);
                } else if (!(translationY == 0 || translationY == this.f4510m)) {
                    this.f4515r.addMovement(motionEvent);
                    this.f4515r.computeCurrentVelocity(1000);
                    if (this.f4515r.getYVelocity() > 5.0f) {
                        m6131b(translationY, this.f4510m - translationY);
                    } else {
                        m6131b(translationY, -translationY);
                    }
                }
                this.f4515r.clear();
                this.f4523z = 1;
                this.f4495A = 0;
                this.f4497C = false;
                break;
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                translationY = motionEvent.findPointerIndex(this.f4518u);
                if (translationY == -1) {
                    this.f4518u = motionEvent.getPointerId(0);
                    translationY = 0;
                }
                float x = motionEvent.getX(translationY);
                float y2 = motionEvent.getY(translationY);
                y = Math.abs(x - this.f4519v);
                x = Math.abs(y2 - this.f4520w);
                if (this.f4523z == 1) {
                    if (y > ((float) this.f4517t) && y > x) {
                        this.f4523z = 0;
                    } else if (x > ((float) this.f4517t)) {
                        this.f4523z = 2;
                        getParent().requestDisallowInterceptTouchEvent(true);
                        if (this.f4502e != null && this.f4521x == this.f4502e) {
                            m6127a(this.f4502e, motionEvent, 3);
                        }
                    }
                }
                x = y2 - this.f4522y;
                if (this.f4523z == 2 && (x >= 1.0f || x <= -1.0f)) {
                    translationY = this.f4495A;
                    if (x > 0.0f) {
                        if ((this.f4511n > 0 || this.f4503f.getTranslationY() < ((float) this.f4510m)) && (this.f4505h == null || !this.f4505h.m6114a())) {
                            translationY = 1;
                        } else {
                            translationY = 2;
                        }
                    } else if (x < 0.0f) {
                        if (this.f4503f.getTranslationY() > 0.0f || this.f4505h == null) {
                            translationY = 1;
                        } else {
                            translationY = 2;
                        }
                    }
                    if (translationY == 1) {
                        if (this.f4495A == 2 || (this.f4521x == this.f4504g && this.f4495A == 0)) {
                            m6127a(this.f4504g, motionEvent, 3);
                        }
                        m6124a(x);
                        m6130b();
                    } else if (translationY == 2) {
                        if (this.f4495A == 1 || (this.f4521x != this.f4504g && this.f4495A == 0)) {
                            m6127a(this.f4504g, motionEvent, 0);
                        } else {
                            m6126a(this.f4504g, motionEvent);
                        }
                    }
                    this.f4495A = translationY;
                    this.f4522y = y2;
                }
                this.f4515r.addMovement(motionEvent);
                break;
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                translationY = (int) this.f4503f.getTranslationY();
                if (translationY != 0 && (this.f4514q || translationY != this.f4510m)) {
                    m6131b(translationY, -translationY);
                }
                this.f4515r.clear();
                this.f4523z = 1;
                this.f4495A = 0;
                this.f4497C = false;
                break;
            case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                translationY = motionEvent.getActionIndex();
                if (motionEvent.getPointerId(translationY) == this.f4518u) {
                    if (translationY == 0) {
                        i = 1;
                    }
                    this.f4518u = motionEvent.getPointerId(i);
                    this.f4519v = motionEvent.getX(i);
                    y = motionEvent.getY(i);
                    this.f4520w = y;
                    this.f4522y = y;
                }
                this.f4515r.addMovement(motionEvent);
                break;
        }
        if (this.f4523z != 2) {
            super.dispatchTouchEvent(motionEvent);
            return true;
        } else if (motionEvent.getActionMasked() == 2 || this.f4495A != 2) {
            return true;
        } else {
            m6126a(this.f4504g, motionEvent);
            return true;
        }
    }

    private boolean m6128a() {
        return this.f4511n > 0 && this.f4511n <= this.f4510m;
    }

    private View m6123a(int i, int i2) {
        Rect rect = new Rect();
        for (View view : new View[]{this.f4504g, this.f4502e}) {
            if (view != null && view.getVisibility() == 0) {
                int x = (int) view.getX();
                int y = (int) view.getY();
                rect.set(x, y, view.getWidth() + x, view.getHeight() + y);
                if (rect.contains(i, i2)) {
                    return view;
                }
            }
        }
        return null;
    }

    private void m6124a(float f) {
        float f2;
        int translationY = (int) this.f4503f.getTranslationY();
        if (translationY > this.f4510m) {
            f2 = (((float) (translationY - this.f4510m)) * 2.0f) + ((float) this.f4510m);
        } else {
            f2 = (float) translationY;
        }
        f2 += f;
        if (f2 > ((float) this.f4510m)) {
            translationY = ((int) ((f2 - ((float) this.f4510m)) / 2.0f)) + this.f4510m;
        } else {
            translationY = (int) f2;
        }
        m6125a(translationY);
        invalidate();
    }

    private void m6125a(int i) {
        if (this.f4511n <= 0) {
            i = Math.min(this.f4510m, i);
        }
        this.f4503f.setTranslationY((float) i);
        m6133c();
    }

    private void m6127a(View view, MotionEvent motionEvent, int i) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(i);
        m6126a(view, obtain);
        obtain.recycle();
    }

    private void m6126a(View view, MotionEvent motionEvent) {
        float f = (float) (-view.getLeft());
        float f2 = (float) (-view.getTop());
        motionEvent.offsetLocation(f, f2);
        view.dispatchTouchEvent(motionEvent);
        motionEvent.offsetLocation(-f, -f2);
    }

    private void m6131b(int i, int i2) {
        this.f4516s.startScroll(0, i, 0, i2);
        this.f4496B = true;
        invalidate();
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        if (view == this.f4502e) {
            return m6129a(canvas, view, j);
        }
        if (view == this.f4506i) {
            return m6132b(canvas, view, j);
        }
        return super.drawChild(canvas, view, j);
    }

    private boolean m6129a(Canvas canvas, View view, long j) {
        int translationY = (int) this.f4503f.getTranslationY();
        if (translationY > this.f4510m) {
            return super.drawChild(canvas, view, j);
        }
        int width = getWidth();
        if (this.f4509l > 0) {
            this.f4507j.setBounds(0, translationY - this.f4509l, width, translationY);
            this.f4507j.draw(canvas);
            translationY -= this.f4509l;
        }
        canvas.save();
        canvas.clipRect(0, 0, width, translationY);
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restore();
        return drawChild;
    }

    private boolean m6132b(Canvas canvas, View view, long j) {
        int translationY = (int) this.f4503f.getTranslationY();
        if (translationY < this.f4511n - view.getHeight()) {
            return true;
        }
        if (translationY > this.f4511n) {
            return super.drawChild(canvas, view, j);
        }
        int width = getWidth();
        int y = (int) view.getY();
        canvas.save();
        canvas.clipRect(0, y, width, translationY);
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restore();
        return drawChild;
    }

    public void computeScroll() {
        super.computeScroll();
        if (this.f4503f == null) {
            return;
        }
        if (this.f4516s.computeScrollOffset()) {
            m6125a(this.f4516s.getCurrY());
            postInvalidateOnAnimation();
        } else if (this.f4496B) {
            this.f4496B = false;
            m6130b();
        }
    }

    public void setDragEnabled(boolean z) {
        this.f4508k = z;
    }

    public void setDrawerListener(DrawerListener drawerListener) {
        this.f4512o = drawerListener;
    }

    public void setTriggerDistance(int i) {
        this.f4511n = i;
    }

    public void setTriggerListener(TriggerListener triggerListener) {
        this.f4513p = triggerListener;
    }

    public void setAutoClose(boolean z) {
        this.f4514q = z;
    }

    private void m6130b() {
        if (this.f4512o != null && this.f4502e != null) {
            int translationY = (int) this.f4503f.getTranslationY();
            if (this.f4523z == 2) {
                this.f4512o.m6117a(this, ((float) Math.min(this.f4510m, Math.max(translationY, 0))) / ((float) this.f4510m));
            } else if (translationY == 0) {
                this.f4512o.m6118b(this);
            } else if (translationY == this.f4510m) {
                this.f4512o.m6116a(this);
            } else {
                this.f4512o.m6117a(this, ((float) translationY) / ((float) this.f4510m));
            }
        }
    }

    private void m6133c() {
        if (this.f4513p != null && this.f4511n > 0 && this.f4523z == 2) {
            int i = this.f4511n - this.f4510m;
            int translationY = ((int) this.f4503f.getTranslationY()) - this.f4510m;
            this.f4513p.m6122a(this, ((float) translationY) / ((float) i));
            if (translationY >= i) {
                if (!this.f4497C) {
                    this.f4497C = true;
                    this.f4513p.m6121a(this);
                }
            } else if (this.f4497C) {
                this.f4497C = false;
            }
        }
    }
}
