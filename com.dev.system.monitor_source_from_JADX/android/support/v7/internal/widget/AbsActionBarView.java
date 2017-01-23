package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.widget.ExploreByTouchHelper;
import android.support.v7.appcompat.C0056R;
import android.support.v7.internal.view.menu.ActionMenuPresenter;
import android.support.v7.internal.view.menu.ActionMenuView;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

abstract class AbsActionBarView extends ViewGroup {
    private static final int FADE_DURATION = 200;
    protected ActionMenuPresenter mActionMenuPresenter;
    protected int mContentHeight;
    protected ActionMenuView mMenuView;
    protected boolean mSplitActionBar;
    protected ActionBarContainer mSplitView;
    protected boolean mSplitWhenNarrow;

    /* renamed from: android.support.v7.internal.widget.AbsActionBarView.1 */
    class C00591 implements Runnable {
        C00591() {
        }

        public void run() {
            AbsActionBarView.this.showOverflowMenu();
        }
    }

    AbsActionBarView(Context context) {
        super(context);
    }

    AbsActionBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    AbsActionBarView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    protected void onConfigurationChanged(Configuration newConfig) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(newConfig);
        }
        TypedArray a = getContext().obtainStyledAttributes(null, C0056R.styleable.ActionBar, C0056R.attr.actionBarStyle, 0);
        setContentHeight(a.getLayoutDimension(0, 0));
        a.recycle();
        if (this.mSplitWhenNarrow) {
            setSplitActionBar(getContext().getResources().getBoolean(C0056R.bool.abc_split_action_bar_is_narrow));
        }
        if (this.mActionMenuPresenter != null) {
            this.mActionMenuPresenter.onConfigurationChanged(newConfig);
        }
    }

    public void setSplitActionBar(boolean split) {
        this.mSplitActionBar = split;
    }

    public void setSplitWhenNarrow(boolean splitWhenNarrow) {
        this.mSplitWhenNarrow = splitWhenNarrow;
    }

    public void setContentHeight(int height) {
        this.mContentHeight = height;
        requestLayout();
    }

    public int getContentHeight() {
        return this.mContentHeight;
    }

    public void setSplitView(ActionBarContainer splitView) {
        this.mSplitView = splitView;
    }

    public int getAnimatedVisibility() {
        return getVisibility();
    }

    public void animateToVisibility(int visibility) {
        clearAnimation();
        if (visibility != getVisibility()) {
            Animation anim = AnimationUtils.loadAnimation(getContext(), visibility == 0 ? C0056R.anim.abc_fade_in : C0056R.anim.abc_fade_out);
            startAnimation(anim);
            setVisibility(visibility);
            if (this.mSplitView != null && this.mMenuView != null) {
                this.mMenuView.startAnimation(anim);
                this.mMenuView.setVisibility(visibility);
            }
        }
    }

    public void setVisibility(int visibility) {
        if (visibility != getVisibility()) {
            super.setVisibility(visibility);
        }
    }

    public boolean showOverflowMenu() {
        if (this.mActionMenuPresenter != null) {
            return this.mActionMenuPresenter.showOverflowMenu();
        }
        return false;
    }

    public void postShowOverflowMenu() {
        post(new C00591());
    }

    public boolean hideOverflowMenu() {
        if (this.mActionMenuPresenter != null) {
            return this.mActionMenuPresenter.hideOverflowMenu();
        }
        return false;
    }

    public boolean isOverflowMenuShowing() {
        if (this.mActionMenuPresenter != null) {
            return this.mActionMenuPresenter.isOverflowMenuShowing();
        }
        return false;
    }

    public boolean isOverflowReserved() {
        return this.mActionMenuPresenter != null && this.mActionMenuPresenter.isOverflowReserved();
    }

    public void dismissPopupMenus() {
        if (this.mActionMenuPresenter != null) {
            this.mActionMenuPresenter.dismissPopupMenus();
        }
    }

    protected int measureChildView(View child, int availableWidth, int childSpecHeight, int spacing) {
        child.measure(MeasureSpec.makeMeasureSpec(availableWidth, ExploreByTouchHelper.INVALID_ID), childSpecHeight);
        return Math.max(0, (availableWidth - child.getMeasuredWidth()) - spacing);
    }

    protected int positionChild(View child, int x, int y, int contentHeight) {
        int childWidth = child.getMeasuredWidth();
        int childHeight = child.getMeasuredHeight();
        int childTop = y + ((contentHeight - childHeight) / 2);
        child.layout(x, childTop, x + childWidth, childTop + childHeight);
        return childWidth;
    }

    protected int positionChildInverse(View child, int x, int y, int contentHeight) {
        int childWidth = child.getMeasuredWidth();
        int childHeight = child.getMeasuredHeight();
        int childTop = y + ((contentHeight - childHeight) / 2);
        child.layout(x - childWidth, childTop, x, childTop + childHeight);
        return childWidth;
    }
}
