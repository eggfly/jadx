package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import com.handmark.pulltorefresh.library.PullToRefreshBase.AnimationStyle;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation;
import com.handmark.pulltorefresh.library.listener.ScrollViewListener;

public class PullToRefreshHomeScrollView extends PullToRefreshBase<HomeScrollView> {

    @TargetApi(9)
    final class InternalScrollViewSDK9 extends HomeScrollView {
        public InternalScrollViewSDK9(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        private int getScrollRange() {
            return getChildCount() > 0 ? Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop())) : 0;
        }

        protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            boolean overScrollBy = super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            OverscrollHelper.overScrollBy(PullToRefreshHomeScrollView.this, i, i3, i2, i4, getScrollRange(), z);
            return overScrollBy;
        }
    }

    public PullToRefreshHomeScrollView(Context context) {
        super(context);
    }

    public PullToRefreshHomeScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PullToRefreshHomeScrollView(Context context, Mode mode) {
        super(context, mode);
    }

    public PullToRefreshHomeScrollView(Context context, Mode mode, AnimationStyle animationStyle) {
        super(context, mode, animationStyle);
    }

    protected HomeScrollView createRefreshableView(Context context, AttributeSet attributeSet) {
        HomeScrollView internalScrollViewSDK9 = VERSION.SDK_INT >= 9 ? new InternalScrollViewSDK9(context, attributeSet) : new HomeScrollView(context, attributeSet);
        internalScrollViewSDK9.setId(C3628R.id.scrollview);
        return internalScrollViewSDK9;
    }

    public final Orientation getPullToRefreshScrollDirection() {
        return Orientation.VERTICAL;
    }

    protected boolean isReadyForPullEnd() {
        View childAt = ((HomeScrollView) this.mRefreshableView).getChildAt(0);
        return childAt != null ? ((HomeScrollView) this.mRefreshableView).getScrollY() >= childAt.getHeight() - getHeight() : false;
    }

    protected boolean isReadyForPullStart() {
        return ((HomeScrollView) this.mRefreshableView).getScrollY() == 0;
    }

    public void setScrollViewListener(ScrollViewListener scrollViewListener) {
        ((HomeScrollView) this.mRefreshableView).setScrollViewListener(scrollViewListener);
    }
}
