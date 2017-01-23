package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.appcompat.C0056R;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class LinearLayoutICS extends LinearLayout {
    private static final int SHOW_DIVIDER_BEGINNING = 1;
    private static final int SHOW_DIVIDER_END = 4;
    private static final int SHOW_DIVIDER_MIDDLE = 2;
    private static final int SHOW_DIVIDER_NONE = 0;
    private final Drawable mDivider;
    private final int mDividerHeight;
    private final int mDividerPadding;
    private final int mDividerWidth;
    private final int mShowDividers;

    public LinearLayoutICS(Context context, AttributeSet attrs) {
        boolean z = true;
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, C0056R.styleable.LinearLayoutICS);
        this.mDivider = a.getDrawable(0);
        if (this.mDivider != null) {
            this.mDividerWidth = this.mDivider.getIntrinsicWidth();
            this.mDividerHeight = this.mDivider.getIntrinsicHeight();
        } else {
            this.mDividerWidth = 0;
            this.mDividerHeight = 0;
        }
        this.mShowDividers = a.getInt(SHOW_DIVIDER_BEGINNING, 0);
        this.mDividerPadding = a.getDimensionPixelSize(SHOW_DIVIDER_MIDDLE, 0);
        a.recycle();
        if (this.mDivider != null) {
            z = false;
        }
        setWillNotDraw(z);
    }

    public int getSupportDividerWidth() {
        return this.mDividerWidth;
    }

    protected void onDraw(Canvas canvas) {
        if (this.mDivider != null) {
            if (getOrientation() == SHOW_DIVIDER_BEGINNING) {
                drawSupportDividersVertical(canvas);
            } else {
                drawSupportDividersHorizontal(canvas);
            }
        }
    }

    protected void measureChildWithMargins(View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
        if (this.mDivider != null) {
            int childIndex = indexOfChild(child);
            int count = getChildCount();
            LayoutParams params = (LayoutParams) child.getLayoutParams();
            if (getOrientation() == SHOW_DIVIDER_BEGINNING) {
                if (hasSupportDividerBeforeChildAt(childIndex)) {
                    params.topMargin = this.mDividerHeight;
                } else if (childIndex == count - 1 && hasSupportDividerBeforeChildAt(count)) {
                    params.bottomMargin = this.mDividerHeight;
                }
            } else if (hasSupportDividerBeforeChildAt(childIndex)) {
                params.leftMargin = this.mDividerWidth;
            } else if (childIndex == count - 1 && hasSupportDividerBeforeChildAt(count)) {
                params.rightMargin = this.mDividerWidth;
            }
        }
        super.measureChildWithMargins(child, parentWidthMeasureSpec, widthUsed, parentHeightMeasureSpec, heightUsed);
    }

    void drawSupportDividersVertical(Canvas canvas) {
        int count = getChildCount();
        int i = 0;
        while (i < count) {
            View child = getChildAt(i);
            if (!(child == null || child.getVisibility() == 8 || !hasSupportDividerBeforeChildAt(i))) {
                drawSupportHorizontalDivider(canvas, child.getTop() - ((LayoutParams) child.getLayoutParams()).topMargin);
            }
            i += SHOW_DIVIDER_BEGINNING;
        }
        if (hasSupportDividerBeforeChildAt(count)) {
            int bottom;
            child = getChildAt(count - 1);
            if (child == null) {
                bottom = (getHeight() - getPaddingBottom()) - this.mDividerHeight;
            } else {
                bottom = child.getBottom();
            }
            drawSupportHorizontalDivider(canvas, bottom);
        }
    }

    void drawSupportDividersHorizontal(Canvas canvas) {
        int count = getChildCount();
        int i = 0;
        while (i < count) {
            View child = getChildAt(i);
            if (!(child == null || child.getVisibility() == 8 || !hasSupportDividerBeforeChildAt(i))) {
                drawSupportVerticalDivider(canvas, child.getLeft() - ((LayoutParams) child.getLayoutParams()).leftMargin);
            }
            i += SHOW_DIVIDER_BEGINNING;
        }
        if (hasSupportDividerBeforeChildAt(count)) {
            int right;
            child = getChildAt(count - 1);
            if (child == null) {
                right = (getWidth() - getPaddingRight()) - this.mDividerWidth;
            } else {
                right = child.getRight();
            }
            drawSupportVerticalDivider(canvas, right);
        }
    }

    void drawSupportHorizontalDivider(Canvas canvas, int top) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, top, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + top);
        this.mDivider.draw(canvas);
    }

    void drawSupportVerticalDivider(Canvas canvas, int left) {
        this.mDivider.setBounds(left, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + left, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    protected boolean hasSupportDividerBeforeChildAt(int childIndex) {
        if (childIndex == 0) {
            if ((this.mShowDividers & SHOW_DIVIDER_BEGINNING) != 0) {
                return true;
            }
            return false;
        } else if (childIndex == getChildCount()) {
            if ((this.mShowDividers & SHOW_DIVIDER_END) == 0) {
                return false;
            }
            return true;
        } else if ((this.mShowDividers & SHOW_DIVIDER_MIDDLE) == 0) {
            return false;
        } else {
            boolean hasVisibleViewBefore = false;
            for (int i = childIndex - 1; i >= 0; i--) {
                if (getChildAt(i).getVisibility() != 8) {
                    hasVisibleViewBefore = true;
                    break;
                }
            }
            return hasVisibleViewBefore;
        }
    }
}
