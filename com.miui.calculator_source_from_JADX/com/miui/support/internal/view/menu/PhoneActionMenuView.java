package com.miui.support.internal.view.menu;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.util.DeviceHelper;
import com.miui.support.internal.view.menu.ActionMenuView.LayoutParams;
import com.miui.support.internal.widget.ActionBarOverlayLayout;
import com.miui.support.util.ActionBarUtils;
import com.miui.support.util.ViewUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class PhoneActionMenuView extends ActionMenuView {
    private static final int[] f2799a;
    private View f2800b;
    private View f2801c;
    private OverflowMenuViewAnimator f2802d;
    private OverflowMenuState f2803e;
    private Drawable f2804f;
    private Drawable f2805g;
    private int f2806h;
    private int f2807i;
    private Rect f2808j;
    private int f2809k;
    private int f2810l;
    private int f2811m;

    private enum OverflowMenuState {
        Collapsed,
        Expanding,
        Expanded,
        Collapsing
    }

    private class OverflowMenuViewAnimator implements AnimatorListener, OnClickListener {
        final /* synthetic */ PhoneActionMenuView f2796a;
        private AnimatorSet f2797b;
        private AnimatorSet f2798c;

        private OverflowMenuViewAnimator(PhoneActionMenuView phoneActionMenuView) {
            this.f2796a = phoneActionMenuView;
        }

        public void m4537a() {
            if (this.f2797b == null) {
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) ActionBarUtils.m5257a(this.f2796a);
                AnimatorSet animatorSet = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f2796a, "Value", new float[]{1.0f, 0.0f});
                animatorSet.playTogether(new Animator[]{ofFloat, actionBarOverlayLayout.m4676a((OnClickListener) this).m4698a()});
                animatorSet.setDuration((long) this.f2796a.getResources().getInteger(17694720));
                animatorSet.addListener(this);
                this.f2797b = animatorSet;
                animatorSet = new AnimatorSet();
                ofFloat = ObjectAnimator.ofFloat(this.f2796a, "Value", new float[]{0.0f, 1.0f});
                animatorSet.playTogether(new Animator[]{ofFloat, actionBarOverlayLayout.m4676a(null).m4699b()});
                animatorSet.setDuration((long) this.f2796a.getResources().getInteger(17694720));
                animatorSet.addListener(this);
                this.f2798c = animatorSet;
                if (!DeviceHelper.f2553e) {
                    this.f2797b.setDuration(0);
                    this.f2798c.setDuration(0);
                }
            }
        }

        public void m4538b() {
            m4537a();
            this.f2798c.cancel();
            this.f2797b.cancel();
            this.f2797b.start();
        }

        public void m4539c() {
            m4537a();
            this.f2798c.cancel();
            this.f2797b.cancel();
            this.f2798c.start();
        }

        public void m4540d() {
            ArrayList arrayList = null;
            if (this.f2797b.isRunning()) {
                arrayList = this.f2797b.getChildAnimations();
            }
            if (this.f2798c.isRunning()) {
                arrayList = this.f2798c.getChildAnimations();
            }
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((ValueAnimator) ((Animator) it.next())).reverse();
                }
            }
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            if (this.f2796a.f2800b != null) {
                if (this.f2796a.f2800b.getTranslationY() == 0.0f) {
                    this.f2796a.f2803e = OverflowMenuState.Expanded;
                } else if (this.f2796a.f2800b.getTranslationY() == ((float) this.f2796a.getMeasuredHeight())) {
                    this.f2796a.f2803e = OverflowMenuState.Collapsed;
                }
            }
            this.f2796a.postInvalidateOnAnimation();
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationCancel(Animator animator) {
            if (this.f2796a.f2803e == OverflowMenuState.Expanding || this.f2796a.f2803e == OverflowMenuState.Expanded) {
                this.f2796a.setValue(0.0f);
            } else if (this.f2796a.f2803e == OverflowMenuState.Collapsing || this.f2796a.f2803e == OverflowMenuState.Collapsed) {
                this.f2796a.setValue(1.0f);
            }
            this.f2796a.postInvalidateOnAnimation();
        }

        public void onClick(View view) {
            if (this.f2796a.f2803e == OverflowMenuState.Expanded) {
                this.f2796a.getPresenter().m4386e(true);
            }
        }
    }

    static {
        f2799a = new int[]{16842964, C0264R.attr.expandBackground, C0264R.attr.splitActionBarOverlayHeight};
    }

    public PhoneActionMenuView(Context context) {
        this(context, null);
    }

    public PhoneActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2803e = OverflowMenuState.Collapsed;
        this.f2810l = 0;
        this.f2811m = 0;
        super.setBackground(null);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2799a);
        this.f2805g = obtainStyledAttributes.getDrawable(0);
        this.f2804f = obtainStyledAttributes.getDrawable(1);
        this.f2809k = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        obtainStyledAttributes.recycle();
        m4544g();
        this.f2801c = new View(context);
        addView(this.f2801c);
        setChildrenDrawingOrderEnabled(true);
        this.f2810l = context.getResources().getDimensionPixelSize(C0264R.dimen.action_button_max_width);
    }

    public void setBackground(Drawable drawable) {
        if (this.f2805g != drawable) {
            this.f2805g = drawable;
            m4544g();
        }
    }

    public boolean m4546a(int i) {
        boolean z;
        View childAt = getChildAt(i);
        if (childAt == this.f2800b || childAt == this.f2801c) {
            z = false;
        } else {
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            z = layoutParams == null || !layoutParams.f2666a;
        }
        if (z && super.m4399a(i)) {
            return true;
        }
        return false;
    }

    public void setOverflowMenuView(View view) {
        if (this.f2800b != view) {
            if (this.f2800b != null) {
                if (this.f2800b.getAnimation() != null) {
                    this.f2800b.clearAnimation();
                }
                removeView(this.f2800b);
            }
            if (view != null) {
                addView(view);
            }
            this.f2800b = view;
            m4544g();
        }
    }

    public boolean m4548d() {
        OverflowMenuState overflowMenuState = this.f2803e;
        if (overflowMenuState == OverflowMenuState.Expanding || overflowMenuState == OverflowMenuState.Expanded || this.f2800b == null) {
            return false;
        }
        this.f2801c.setBackground(this.f2804f);
        OverflowMenuViewAnimator overflowMenuViewAnimator = getOverflowMenuViewAnimator();
        if (overflowMenuState == OverflowMenuState.Collapsed) {
            this.f2803e = OverflowMenuState.Expanding;
            overflowMenuViewAnimator.m4538b();
        } else if (overflowMenuState == OverflowMenuState.Collapsing) {
            overflowMenuViewAnimator.m4540d();
        }
        postInvalidateOnAnimation();
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        return true;
    }

    public boolean m4549e() {
        return this.f2803e == OverflowMenuState.Expanding || this.f2803e == OverflowMenuState.Expanded;
    }

    public boolean m4550f() {
        OverflowMenuState overflowMenuState = this.f2803e;
        if (overflowMenuState == OverflowMenuState.Collapsing || overflowMenuState == OverflowMenuState.Collapsed) {
            return false;
        }
        this.f2801c.setBackground(this.f2805g);
        OverflowMenuViewAnimator overflowMenuViewAnimator = getOverflowMenuViewAnimator();
        if (overflowMenuState == OverflowMenuState.Expanded) {
            this.f2803e = OverflowMenuState.Collapsing;
            overflowMenuViewAnimator.m4539c();
        } else if (overflowMenuState == OverflowMenuState.Expanding) {
            overflowMenuViewAnimator.m4540d();
        }
        return true;
    }

    private OverflowMenuViewAnimator getOverflowMenuViewAnimator() {
        if (this.f2802d == null) {
            this.f2802d = new OverflowMenuViewAnimator();
        }
        return this.f2802d;
    }

    public int getCollapsedHeight() {
        if (this.f2807i == 0) {
            return 0;
        }
        return (this.f2807i + this.f2808j.top) - this.f2809k;
    }

    protected void onMeasure(int i, int i2) {
        int childCount = getChildCount();
        if (childCount == 0 || (m4547c() && childCount == 1)) {
            this.f2807i = 0;
            setMeasuredDimension(0, 0);
            return;
        }
        View childAt;
        int childCount2 = getChildCount();
        if (indexOfChild(this.f2800b) != -1) {
            childCount2--;
        }
        if (indexOfChild(this.f2801c) != -1) {
            childCount2--;
        }
        this.f2811m = Math.min(MeasureSpec.getSize(i) / childCount2, this.f2810l);
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f2811m, Integer.MIN_VALUE);
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < childCount) {
            int i6;
            childAt = getChildAt(i3);
            if (childAt == this.f2800b) {
                childCount2 = i4;
                i6 = i5;
            } else if (childAt == this.f2801c) {
                childCount2 = i4;
                i6 = i5;
            } else {
                measureChildWithMargins(childAt, makeMeasureSpec, 0, i2, 0);
                int measuredWidth = i5 + childAt.getMeasuredWidth();
                childCount2 = Math.max(i4, childAt.getMeasuredHeight());
                i6 = measuredWidth;
            }
            i3++;
            i4 = childCount2;
            i5 = i6;
        }
        this.f2806h = i5;
        this.f2807i = i4;
        if (this.f2800b != null) {
            measureChildWithMargins(this.f2800b, i, 0, i2, 0);
            i5 = Math.max(i5, this.f2800b.getMeasuredWidth());
            i4 += this.f2800b.getMeasuredHeight();
            this.f2800b.setTranslationY(this.f2803e == OverflowMenuState.Expanded ? 0.0f : (float) i4);
        }
        if (this.f2800b == null) {
            i4 += this.f2808j.top;
        }
        childAt = this.f2801c;
        Drawable drawable = (this.f2803e == OverflowMenuState.Expanded || this.f2803e == OverflowMenuState.Expanding) ? this.f2804f : this.f2805g;
        childAt.setBackground(drawable);
        setMeasuredDimension(Math.max(i5, MeasureSpec.getSize(i)), i4);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = i3 - i;
        int i8 = i4 - i2;
        if (this.f2800b != null) {
            int measuredHeight = this.f2800b.getMeasuredHeight();
            ViewUtils.m5449a(this, this.f2800b, 0, 0, i7, measuredHeight);
            i5 = measuredHeight - this.f2808j.top;
        } else {
            i5 = 0;
        }
        ViewUtils.m5449a(this, this.f2801c, 0, i5, i7, i8);
        Object obj = null;
        int i9 = 0;
        int childCount = getChildCount();
        int i10 = 0;
        while (i10 < childCount) {
            View childAt = getChildAt(i10);
            if (childAt == this.f2800b) {
                i6 = i9;
            } else if (childAt == this.f2801c) {
                i6 = i9;
            } else {
                Object obj2;
                if (childAt.getMeasuredWidth() >= this.f2811m) {
                    obj2 = 1;
                } else {
                    obj2 = obj;
                }
                obj = obj2;
                i6 = i9 + 1;
            }
            i10++;
            i9 = i6;
        }
        if (obj != null) {
            i6 = (i7 - (this.f2811m * i9)) >> 1;
        } else {
            i6 = (i7 - this.f2806h) >> 1;
        }
        i10 = i6;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt2 = getChildAt(i11);
            if (!(childAt2 == this.f2800b || childAt2 == this.f2801c)) {
                i6 = childAt2.getMeasuredWidth();
                if (obj != null) {
                    int i12 = (this.f2811m - i6) >> 1;
                    i10 += i12;
                    ViewUtils.m5449a(this, childAt2, i10, i5, i10 + i6, i8);
                    i10 = (i10 - i12) + this.f2811m;
                } else {
                    ViewUtils.m5449a(this, childAt2, i10, i5, i10 + i6, i8);
                    i10 += childAt2.getMeasuredWidth();
                }
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f;
        float y = motionEvent.getY();
        if (this.f2800b == null) {
            f = 0.0f;
        } else {
            f = this.f2800b.getTranslationY();
        }
        return y > f || super.onTouchEvent(motionEvent);
    }

    public void m4545a(int i, float f, boolean z, boolean z2) {
        if (DeviceHelper.f2553e) {
            setAlpha(m4401b(f, z, z2));
        }
        float a = m4393a(f, z, z2);
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (!(childAt == this.f2800b || childAt == this.f2801c)) {
                childAt.setTranslationY(a);
            }
        }
    }

    private void m4544g() {
        if (this.f2808j == null) {
            this.f2808j = new Rect();
        }
        Drawable drawable = this.f2800b == null ? this.f2805g : this.f2804f;
        if (drawable == null) {
            this.f2808j.setEmpty();
        } else {
            drawable.getPadding(this.f2808j);
        }
    }

    public void setValue(float f) {
        if (this.f2800b != null) {
            this.f2800b.setTranslationY(((float) getMeasuredHeight()) * f);
        }
    }

    protected int getChildDrawingOrder(int i, int i2) {
        int indexOfChild = indexOfChild(this.f2800b);
        int indexOfChild2 = indexOfChild(this.f2801c);
        if (i2 == 0) {
            if (indexOfChild != -1) {
                return indexOfChild;
            }
            if (indexOfChild2 != -1) {
                return indexOfChild2;
            }
        } else if (!(i2 != 1 || indexOfChild == -1 || indexOfChild2 == -1)) {
            return indexOfChild2;
        }
        int i3 = 0;
        while (i3 < i) {
            if (!(i3 == indexOfChild || i3 == indexOfChild2)) {
                int i4;
                if (i3 < indexOfChild) {
                    i4 = i3 + 1;
                } else {
                    i4 = i3;
                }
                if (i3 < indexOfChild2) {
                    i4++;
                }
                if (i4 == i2) {
                    return i3;
                }
            }
            i3++;
        }
        return super.getChildDrawingOrder(i, i2);
    }

    public boolean m4547c() {
        return getChildAt(0) == this.f2801c;
    }
}
