package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.v7.app.ActionBar;
import android.support.v7.appcompat.C0056R;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class ActionBarOverlayLayout extends FrameLayout {
    static final int[] mActionBarSizeAttr;
    private ActionBar mActionBar;
    private View mActionBarBottom;
    private int mActionBarHeight;
    private View mActionBarTop;
    private ActionBarView mActionView;
    private ActionBarContainer mContainerView;
    private View mContent;
    private final Rect mZeroRect;

    static {
        mActionBarSizeAttr = new int[]{C0056R.attr.actionBarSize};
    }

    public ActionBarOverlayLayout(Context context) {
        super(context);
        this.mZeroRect = new Rect(0, 0, 0, 0);
        init(context);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mZeroRect = new Rect(0, 0, 0, 0);
        init(context);
    }

    private void init(Context context) {
        TypedArray ta = getContext().getTheme().obtainStyledAttributes(mActionBarSizeAttr);
        this.mActionBarHeight = ta.getDimensionPixelSize(0, 0);
        ta.recycle();
    }

    public void setActionBar(ActionBar impl) {
        this.mActionBar = impl;
    }

    private boolean applyInsets(View view, Rect insets, boolean left, boolean top, boolean bottom, boolean right) {
        boolean changed = false;
        LayoutParams lp = (LayoutParams) view.getLayoutParams();
        if (left && lp.leftMargin != insets.left) {
            changed = true;
            lp.leftMargin = insets.left;
        }
        if (top && lp.topMargin != insets.top) {
            changed = true;
            lp.topMargin = insets.top;
        }
        if (right && lp.rightMargin != insets.right) {
            changed = true;
            lp.rightMargin = insets.right;
        }
        if (!bottom || lp.bottomMargin == insets.bottom) {
            return changed;
        }
        lp.bottomMargin = insets.bottom;
        return true;
    }

    void pullChildren() {
        if (this.mContent == null) {
            this.mContent = findViewById(C0056R.id.action_bar_activity_content);
            if (this.mContent == null) {
                this.mContent = findViewById(16908290);
            }
            this.mActionBarTop = findViewById(C0056R.id.top_action_bar);
            this.mContainerView = (ActionBarContainer) findViewById(C0056R.id.action_bar_container);
            this.mActionView = (ActionBarView) findViewById(C0056R.id.action_bar);
            this.mActionBarBottom = findViewById(C0056R.id.split_action_bar);
        }
    }
}
