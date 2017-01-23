package com.miui.support.internal.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import com.miui.support.C0234R;
import com.miui.support.app.ActionBar.FragmentViewPagerChangeListener;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.util.DeviceHelper;
import com.miui.support.internal.view.menu.ActionMenuView;
import com.miui.support.util.AttributeResolver;
import com.miui.support.util.DrawableUtil;

public class ActionBarContainer extends FrameLayout implements FragmentViewPagerChangeListener {
    private boolean f2859a;
    private View f2860b;
    private ActionBarView f2861c;
    private ActionBarContextView f2862d;
    private Animator f2863e;
    private Drawable f2864f;
    private Drawable[] f2865g;
    private Drawable f2866h;
    private Drawable f2867i;
    private Drawable f2868j;
    private Drawable f2869k;
    private boolean f2870l;
    private boolean f2871m;
    private boolean f2872n;
    private boolean f2873o;
    private boolean f2874p;
    private int f2875q;
    private Rect f2876r;
    private int f2877s;
    private boolean f2878t;
    private AnimatorListenerAdapter f2879u;
    private AnimatorListenerAdapter f2880v;

    /* renamed from: com.miui.support.internal.widget.ActionBarContainer.1 */
    class C03691 extends AnimatorListenerAdapter {
        final /* synthetic */ ActionBarContainer f2856a;

        C03691(ActionBarContainer actionBarContainer) {
            this.f2856a = actionBarContainer;
        }

        public void onAnimationEnd(Animator animator) {
            this.f2856a.setVisibility(8);
            this.f2856a.f2863e = null;
        }
    }

    /* renamed from: com.miui.support.internal.widget.ActionBarContainer.2 */
    class C03702 extends AnimatorListenerAdapter {
        final /* synthetic */ ActionBarContainer f2857a;

        C03702(ActionBarContainer actionBarContainer) {
            this.f2857a = actionBarContainer;
        }

        public void onAnimationEnd(Animator animator) {
            this.f2857a.f2863e = null;
        }
    }

    /* renamed from: com.miui.support.internal.widget.ActionBarContainer.3 */
    class C03713 implements Runnable {
        final /* synthetic */ ActionBarContainer f2858a;

        C03713(ActionBarContainer actionBarContainer) {
            this.f2858a = actionBarContainer;
        }

        public void run() {
            this.f2858a.m4625a(true);
        }
    }

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        boolean z = true;
        super(context, attributeSet);
        this.f2878t = false;
        this.f2879u = new C03691(this);
        this.f2880v = new C03702(this);
        setBackground(null);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0234R.styleable.ActionBar);
        this.f2864f = obtainStyledAttributes.getDrawable(C0234R.styleable.ActionBar_android_background);
        this.f2865g = new Drawable[]{this.f2864f, obtainStyledAttributes.getDrawable(C0234R.styleable.ActionBar_actionBarEmbededTabsBackground), obtainStyledAttributes.getDrawable(C0234R.styleable.ActionBar_actionBarStackedBackground)};
        this.f2866h = obtainStyledAttributes.getDrawable(C0234R.styleable.ActionBar_android_backgroundStacked);
        this.f2874p = obtainStyledAttributes.getBoolean(C0234R.styleable.ActionBar_customViewAutoFitSystemWindow, false);
        if (getId() == C0264R.id.split_action_bar) {
            this.f2870l = true;
            this.f2867i = obtainStyledAttributes.getDrawable(C0234R.styleable.ActionBar_android_backgroundSplit);
            this.f2875q = obtainStyledAttributes.getDimensionPixelSize(C0234R.styleable.ActionBar_android_height, 0);
        }
        obtainStyledAttributes.recycle();
        this.f2868j = new ColorDrawable(AttributeResolver.m5322c(context, C0234R.attr.colorPrimary));
        if (!this.f2870l) {
            setPadding(0, 0, 0, 0);
        }
        if (this.f2870l) {
            if (this.f2867i != null) {
                z = false;
            }
        } else if (!(this.f2864f == null && this.f2866h == null)) {
            z = false;
        }
        setWillNotDraw(z);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f2861c = (ActionBarView) findViewById(C0264R.id.action_bar);
        this.f2862d = (ActionBarContextView) findViewById(C0264R.id.action_context_bar);
    }

    public void setActionBarContextView(ActionBarContextView actionBarContextView) {
        this.f2862d = actionBarContextView;
    }

    public void setPendingInsets(Rect rect) {
        if (!this.f2870l) {
            if (this.f2876r == null) {
                this.f2876r = new Rect();
            }
            this.f2876r.set(rect);
        }
    }

    public Rect getPendingInsets() {
        return this.f2876r;
    }

    public void setFragmentViewPagerMode(boolean z) {
        this.f2873o = z;
    }

    int getCollapsedHeight() {
        if (!this.f2870l) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (getChildAt(i2) instanceof ActionMenuView) {
                ActionMenuView actionMenuView = (ActionMenuView) getChildAt(i2);
                if (actionMenuView.getVisibility() == 0 && actionMenuView.getCollapsedHeight() > 0) {
                    i = Math.max(i, actionMenuView.getCollapsedHeight());
                }
            }
        }
        return i;
    }

    int getInsetHeight() {
        int collapsedHeight = getCollapsedHeight();
        if (this.f2873o) {
            int i = 0;
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                if (getChildAt(i2) instanceof ActionMenuView) {
                    ActionMenuView actionMenuView = (ActionMenuView) getChildAt(i2);
                    if (actionMenuView.getVisibility() == 0 && actionMenuView.getCollapsedHeight() > 0) {
                        i++;
                    }
                }
            }
            if (!(i == 1 && this.f2862d.getAnimatedVisibility() == 0)) {
                return 0;
            }
        }
        return collapsedHeight;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Rect bounds;
        if (this.f2864f != null) {
            bounds = this.f2864f.getBounds();
            this.f2864f.setCallback(null);
            unscheduleDrawable(this.f2864f);
        } else {
            bounds = null;
        }
        this.f2864f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (bounds == null) {
                requestLayout();
            } else {
                this.f2864f.setBounds(bounds);
            }
            this.f2878t = true;
        } else {
            this.f2878t = false;
        }
        boolean z = this.f2870l ? this.f2867i == null : this.f2864f == null && this.f2866h == null;
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        boolean z = true;
        if (this.f2866h != null) {
            this.f2866h.setCallback(null);
            unscheduleDrawable(this.f2866h);
        }
        this.f2866h = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        if (this.f2870l) {
            if (this.f2867i != null) {
                z = false;
            }
        } else if (!(this.f2864f == null && this.f2866h == null)) {
            z = false;
        }
        setWillNotDraw(z);
        if (this.f2860b != null) {
            this.f2860b.setBackground(this.f2866h);
        }
    }

    public void setSplitBackground(Drawable drawable) {
        boolean z = true;
        if (this.f2867i != null) {
            this.f2867i.setCallback(null);
            unscheduleDrawable(this.f2867i);
        }
        this.f2867i = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        if (this.f2870l) {
            if (this.f2867i != null) {
                z = false;
            }
        } else if (!(this.f2864f == null && this.f2866h == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.f2864f != null) {
            this.f2864f.setVisible(z, false);
        }
        if (this.f2866h != null) {
            this.f2866h.setVisible(z, false);
        }
        if (this.f2867i != null) {
            this.f2867i.setVisible(z, false);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f2864f && !this.f2870l) || ((drawable == this.f2866h && this.f2871m) || ((drawable == this.f2867i && this.f2870l) || super.verifyDrawable(drawable)));
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2864f != null && this.f2864f.isStateful()) {
            this.f2864f.setState(getDrawableState());
        }
        if (this.f2866h != null && this.f2866h.isStateful()) {
            this.f2866h.setState(getDrawableState());
        }
        if (this.f2867i != null && this.f2867i.isStateful()) {
            this.f2867i.setState(getDrawableState());
        }
    }

    public void setTransitioning(boolean z) {
        this.f2859a = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f2859a || super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return !this.f2870l && super.onTouchEvent(motionEvent);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (this.f2870l) {
            return false;
        }
        return true;
    }

    public View getTabContainer() {
        return this.f2860b;
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        if (this.f2860b != null) {
            removeView(this.f2860b);
        }
        if (scrollingTabContainerView != null) {
            addView(scrollingTabContainerView);
            LayoutParams layoutParams = scrollingTabContainerView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.setAllowCollapse(false);
            this.f2877s = scrollingTabContainerView.getPaddingTop();
        } else if (this.f2860b != null) {
            this.f2860b.setBackground(null);
        }
        this.f2860b = scrollingTabContainerView;
    }

    public void onDraw(Canvas canvas) {
        if (getWidth() != 0 && getHeight() != 0) {
            if (!this.f2870l) {
                if (this.f2864f != null) {
                    this.f2864f.draw(canvas);
                }
                if (this.f2868j != null && DrawableUtil.m5370a(this.f2864f)) {
                    this.f2868j.draw(canvas);
                    if (this.f2869k != null && !DrawableUtil.m5370a(this.f2868j)) {
                        this.f2869k.draw(canvas);
                    }
                }
            } else if (DeviceHelper.f2555g && this.f2867i != null) {
                this.f2867i.draw(canvas);
            }
        }
    }

    public ActionMode startActionModeForChild(View view, Callback callback) {
        return null;
    }

    private void m4622a(View view) {
        if (view != null && view.getVisibility() == 0) {
            if (view != this.f2861c || !this.f2874p) {
                ((MarginLayoutParams) view.getLayoutParams()).topMargin = this.f2876r != null ? this.f2876r.top : 0;
            }
        }
    }

    public void onMeasure(int i, int i2) {
        if (this.f2870l) {
            m4621a(i, i2);
            return;
        }
        int i3;
        int i4;
        if (this.f2860b != null) {
            this.f2860b.setPadding(this.f2860b.getPaddingLeft(), this.f2877s, this.f2860b.getPaddingRight(), this.f2860b.getPaddingBottom());
        }
        m4622a(this.f2861c);
        ActionBarContextView actionBarContextView = this.f2862d;
        if (actionBarContextView != null) {
            actionBarContextView.setContentInset(this.f2876r != null ? this.f2876r.top : 0);
        }
        super.onMeasure(i, i2);
        if (this.f2861c == null || this.f2861c.getVisibility() == 8 || this.f2861c.getMeasuredHeight() <= 0) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        if (i3 != 0) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f2861c.getLayoutParams();
            if (this.f2861c.m4764n()) {
                i4 = layoutParams.topMargin;
            } else {
                i4 = layoutParams.bottomMargin + (this.f2861c.getMeasuredHeight() + layoutParams.topMargin);
            }
        } else {
            i4 = 0;
        }
        if (!(this.f2860b == null || this.f2860b.getVisibility() == 8 || MeasureSpec.getMode(i2) != Integer.MIN_VALUE)) {
            int size = MeasureSpec.getSize(i2);
            int measuredWidth = getMeasuredWidth();
            size = Math.min(i4 + this.f2860b.getMeasuredHeight(), size);
            if (i3 != 0 || this.f2876r == null) {
                i4 = 0;
            } else {
                i4 = this.f2876r.top;
            }
            setMeasuredDimension(measuredWidth, i4 + size);
        }
        i3 = 0;
        for (i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() == 0 && childAt.getMeasuredHeight() > 0 && childAt.getMeasuredWidth() > 0) {
                i3++;
            }
        }
        if (i3 == 0) {
            setMeasuredDimension(0, 0);
        }
    }

    private void m4621a(int i, int i2) {
        if (MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            i = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i), 1073741824);
        }
        if (DeviceHelper.f2555g && this.f2875q > 0) {
            i2 = MeasureSpec.makeMeasureSpec(this.f2875q, 1073741824);
        }
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        int i3 = 0;
        for (int i4 = 0; i4 < childCount; i4++) {
            i3 = Math.max(i3, getChildAt(i4).getMeasuredHeight());
        }
        if (i3 == 0) {
            setMeasuredDimension(0, 0);
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6 = 1;
        super.onLayout(z, i, i2, i3, i4);
        int measuredHeight = getMeasuredHeight();
        if (!(this.f2860b == null || this.f2860b.getVisibility() == 8)) {
            int measuredHeight2 = this.f2860b.getMeasuredHeight();
            if (this.f2861c == null || this.f2861c.getVisibility() != 0 || this.f2861c.getMeasuredHeight() <= 0) {
                if (this.f2876r != null) {
                    i5 = this.f2876r.top;
                } else {
                    i5 = 0;
                }
                measuredHeight2 += i5;
                this.f2860b.setPadding(this.f2860b.getPaddingLeft(), this.f2876r != null ? this.f2876r.top + this.f2877s : this.f2877s, this.f2860b.getPaddingRight(), this.f2860b.getPaddingBottom());
                i5 = measuredHeight2;
            } else {
                this.f2860b.setPadding(this.f2860b.getPaddingLeft(), this.f2877s, this.f2860b.getPaddingRight(), this.f2860b.getPaddingBottom());
                i5 = measuredHeight2;
            }
            this.f2860b.layout(i, measuredHeight - i5, i3, measuredHeight);
        }
        if (!this.f2870l) {
            m4620a();
            if (this.f2864f != null) {
                this.f2864f.setBounds(0, 0, i3 - i, measuredHeight);
                i5 = 1;
            } else {
                i5 = 0;
            }
            if (this.f2868j != null) {
                this.f2868j.setBounds(0, 0, i3 - i, measuredHeight);
            } else {
                i6 = i5;
            }
            if (this.f2869k == null) {
                this.f2869k = getResources().getDrawable(C0264R.drawable.branding_bottom_divider);
            }
            this.f2869k.setBounds(0, measuredHeight - 1, i3 - i, measuredHeight);
        } else if (this.f2867i != null) {
            this.f2867i.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        } else {
            i6 = 0;
        }
        if (i6 != 0) {
            invalidate();
        }
    }

    public void m4625a(boolean z) {
        if (this.f2863e != null) {
            this.f2863e.cancel();
        }
        setVisibility(0);
        if (!z) {
            setTranslationY(0.0f);
        } else if (this.f2870l) {
            this.f2863e = ObjectAnimator.ofFloat(this, "TranslationY", new float[]{(float) getHeight(), 0.0f});
            this.f2863e.setDuration(DeviceHelper.f2553e ? (long) getContext().getResources().getInteger(17694720) : 0);
            this.f2863e.addListener(this.f2880v);
            this.f2863e.start();
            ActionMenuView actionMenuView = (ActionMenuView) getChildAt(0);
            if (actionMenuView != null) {
                actionMenuView.startLayoutAnimation();
            }
        }
    }

    public void m4624a(int i, float f, boolean z, boolean z2) {
        if (this.f2870l) {
            ActionMenuView actionMenuView = (ActionMenuView) getChildAt(0);
            if (actionMenuView != null) {
                actionMenuView.m4397a(i, f, z, z2);
            }
        }
    }

    public void m4623a(int i) {
    }

    public void m4626b(int i) {
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f2872n) {
            post(new C03713(this));
            this.f2872n = false;
        }
    }

    private void m4620a() {
        if (!this.f2878t && !this.f2870l && this.f2861c != null && this.f2864f != null && this.f2865g != null && this.f2865g.length >= 3) {
            int i = 0;
            if (this.f2861c.m4761k()) {
                i = 1;
                int displayOptions = this.f2861c.getDisplayOptions();
                if (!((displayOptions & 2) == 0 && (displayOptions & 4) == 0 && (displayOptions & 16) == 0)) {
                    i = 2;
                }
            }
            if (this.f2865g[i] != null) {
                this.f2864f = this.f2865g[i];
            }
        }
    }
}
