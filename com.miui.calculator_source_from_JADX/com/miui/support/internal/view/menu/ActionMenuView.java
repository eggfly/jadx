package com.miui.support.internal.view.menu;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.ViewDebug.ExportedProperty;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import com.miui.support.internal.util.DeviceHelper;
import com.miui.support.internal.view.menu.MenuBuilder.ItemInvoker;

public abstract class ActionMenuView extends LinearLayout implements ItemInvoker, MenuView {
    private MenuBuilder f2669a;
    private boolean f2670b;
    private ActionMenuPresenter f2671c;
    private OpenCloseAnimator f2672d;

    public interface ActionMenuChildView {
    }

    public static class LayoutParams extends android.widget.LinearLayout.LayoutParams {
        @ExportedProperty
        public boolean f2666a;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.f2666a = layoutParams.f2666a;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f2666a = false;
        }
    }

    class OpenCloseAnimator implements AnimatorListener {
        Animator f2667a;
        final /* synthetic */ ActionMenuView f2668b;

        public void m4388a(float f) {
            for (int i = 0; i < this.f2668b.getChildCount(); i++) {
                this.f2668b.getChildAt(i).setTranslationY(f);
            }
        }

        public OpenCloseAnimator(ActionMenuView actionMenuView) {
            this.f2668b = actionMenuView;
        }

        public void onAnimationStart(Animator animator) {
            this.f2667a = animator;
        }

        public void onAnimationEnd(Animator animator) {
            this.f2667a = null;
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    public abstract int getCollapsedHeight();

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return m4394a();
    }

    protected /* synthetic */ android.widget.LinearLayout.LayoutParams m6777generateDefaultLayoutParams() {
        return m4394a();
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m4395a(attributeSet);
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return m4396a(layoutParams);
    }

    public /* synthetic */ android.widget.LinearLayout.LayoutParams m6778generateLayoutParams(AttributeSet attributeSet) {
        return m4395a(attributeSet);
    }

    protected /* synthetic */ android.widget.LinearLayout.LayoutParams m6779generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return m4396a(layoutParams);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        this.f2672d = new OpenCloseAnimator(this);
        if (!DeviceHelper.f2553e) {
            setLayoutAnimation(null);
        }
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.f2671c = actionMenuPresenter;
    }

    public ActionMenuPresenter getPresenter() {
        return this.f2671c;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        if (this.f2671c != null) {
            this.f2671c.m4383d(false);
            if (this.f2671c.m4382c()) {
                this.f2671c.m4386e(false);
                this.f2671c.m4376a();
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        if (getChildCount() == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(i, i2);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2671c.m4387f(false);
    }

    public void setOverflowReserved(boolean z) {
        this.f2670b = z;
    }

    public boolean m4399a(int i) {
        removeViewAt(i);
        return true;
    }

    protected LayoutParams m4394a() {
        return new LayoutParams(-2, -2);
    }

    public LayoutParams m4395a(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected LayoutParams m4396a(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        return m4394a();
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof LayoutParams);
    }

    public LayoutParams m4402b() {
        LayoutParams a = m4394a();
        a.f2666a = true;
        return a;
    }

    public boolean m4400a(MenuItemImpl menuItemImpl) {
        return this.f2669a.m4426a((MenuItem) menuItemImpl, 0);
    }

    public int getWindowAnimations() {
        return 0;
    }

    public void m4398a(MenuBuilder menuBuilder) {
        this.f2669a = menuBuilder;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public boolean m4403c() {
        return false;
    }

    protected float m4393a(float f, boolean z, boolean z2) {
        float collapsedHeight = (float) getCollapsedHeight();
        if (z && z2) {
            if (((double) f) < 0.5d) {
                f *= 2.0f;
            } else {
                f = 2.0f * (1.0f - f);
            }
        } else if (z2) {
            f = 1.0f - f;
        }
        return collapsedHeight * f;
    }

    protected float m4401b(float f, boolean z, boolean z2) {
        if (z && z2) {
            return 1.0f;
        }
        if (z) {
            return ((float) ((int) ((1.0f - f) * 10.0f))) / 10.0f;
        }
        if (z2) {
            return ((float) ((int) (f * 10.0f))) / 10.0f;
        }
        return 1.0f;
    }

    public void m4397a(int i, float f, boolean z, boolean z2) {
        if (DeviceHelper.f2553e) {
            setAlpha(m4401b(f, z, z2));
        }
        float a = m4393a(f, z, z2);
        if (!(z && z2 && getTranslationY() == 0.0f)) {
            setTranslationY(a);
        }
        this.f2672d.m4388a(a);
    }
}
