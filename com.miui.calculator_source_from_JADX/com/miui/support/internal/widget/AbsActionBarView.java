package com.miui.support.internal.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.miui.support.C0234R;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.view.menu.ActionMenuPresenter;
import com.miui.support.internal.view.menu.ActionMenuView;
import com.miui.support.util.ViewUtils;

abstract class AbsActionBarView extends ViewGroup {
    protected ActionMenuView f2850a;
    protected ActionMenuPresenter f2851b;
    protected ActionBarContainer f2852c;
    protected boolean f2853d;
    protected boolean f2854e;
    protected int f2855f;

    /* renamed from: com.miui.support.internal.widget.AbsActionBarView.1 */
    class C03681 implements Runnable {
        final /* synthetic */ AbsActionBarView f2849a;

        C03681(AbsActionBarView absActionBarView) {
            this.f2849a = absActionBarView;
        }

        public void run() {
            this.f2849a.m4612a();
        }
    }

    AbsActionBarView(Context context) {
        super(context);
    }

    AbsActionBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    AbsActionBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, C0234R.styleable.ActionBar, getActionBarStyle(), 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(C0234R.styleable.ActionBar_android_height, 0));
        obtainStyledAttributes.recycle();
        if (this.f2854e) {
            setSplitActionBar(getContext().getResources().getBoolean(C0264R.bool.abc_split_action_bar_is_narrow));
        }
        if (this.f2851b != null) {
            this.f2851b.m4372a(configuration);
        }
    }

    int getActionBarStyle() {
        return 16843470;
    }

    public void setSplitActionBar(boolean z) {
        this.f2853d = z;
    }

    public void setSplitWhenNarrow(boolean z) {
        this.f2854e = z;
    }

    public void setContentHeight(int i) {
        this.f2855f = i;
        requestLayout();
    }

    public int getContentHeight() {
        return this.f2855f;
    }

    public void setSplitView(ActionBarContainer actionBarContainer) {
        this.f2852c = actionBarContainer;
    }

    public int getAnimatedVisibility() {
        return getVisibility();
    }

    public ActionMenuView getActionMenuView() {
        return this.f2850a;
    }

    public void setVisibility(int i) {
        if (i != getVisibility()) {
            super.setVisibility(i);
        }
    }

    public boolean m4612a() {
        return this.f2851b != null && this.f2851b.m4376a();
    }

    public void m4614b() {
        post(new C03681(this));
    }

    public boolean m4616c() {
        return this.f2851b != null && this.f2851b.m4386e(false);
    }

    public boolean m4617d() {
        return this.f2851b != null && this.f2851b.m4382c();
    }

    public boolean m4618e() {
        return this.f2851b != null && this.f2851b.m4384d();
    }

    protected int m4611a(View view, int i, int i2, int i3) {
        view.measure(MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    protected int m4613b(View view, int i, int i2, int i3) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i2 + ((i3 - measuredHeight) / 2);
        View view2 = view;
        int i5 = i;
        ViewUtils.m5449a(this, view2, i5, i4, i + measuredWidth, i4 + measuredHeight);
        return measuredWidth;
    }

    protected int m4615c(View view, int i, int i2, int i3) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i2 + ((i3 - measuredHeight) / 2);
        View view2 = view;
        ViewUtils.m5449a(this, view2, i - measuredWidth, i4, i, i4 + measuredHeight);
        return measuredWidth;
    }

    public ActionMenuView getMenuView() {
        return this.f2850a;
    }
}
