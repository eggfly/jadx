package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.widget.ExploreByTouchHelper;
import android.support.v7.appcompat.C0056R;
import android.support.v7.internal.view.menu.MenuBuilder.ItemInvoker;
import android.support.v7.internal.widget.LinearLayoutICS;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView extends LinearLayoutICS implements ItemInvoker, MenuView {
    static final int GENERATED_ITEM_PADDING = 4;
    static final int MIN_CELL_SIZE = 56;
    private static final String TAG = "ActionMenuView";
    private boolean mFormatItems;
    private int mFormatItemsWidth;
    private int mGeneratedItemPadding;
    private int mMaxItemHeight;
    private int mMeasuredExtraWidth;
    private MenuBuilder mMenu;
    private int mMinCellSize;
    private ActionMenuPresenter mPresenter;
    private boolean mReserveOverflow;

    public interface ActionMenuChildView {
        boolean needsDividerAfter();

        boolean needsDividerBefore();
    }

    public static class LayoutParams extends android.widget.LinearLayout.LayoutParams {
        @ExportedProperty
        public int cellsUsed;
        @ExportedProperty
        public boolean expandable;
        public boolean expanded;
        @ExportedProperty
        public int extraPixels;
        @ExportedProperty
        public boolean isOverflowButton;
        @ExportedProperty
        public boolean preventEdgeOffset;

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
        }

        public LayoutParams(LayoutParams other) {
            super(other);
            this.isOverflowButton = other.isOverflowButton;
        }

        public LayoutParams(int width, int height) {
            super(width, height);
            this.isOverflowButton = false;
        }

        public LayoutParams(int width, int height, boolean isOverflowButton) {
            super(width, height);
            this.isOverflowButton = isOverflowButton;
        }
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBaselineAligned(false);
        float density = context.getResources().getDisplayMetrics().density;
        this.mMinCellSize = (int) (56.0f * density);
        this.mGeneratedItemPadding = (int) (4.0f * density);
        TypedArray a = context.obtainStyledAttributes(attrs, C0056R.styleable.ActionBar, C0056R.attr.actionBarStyle, 0);
        this.mMaxItemHeight = a.getDimensionPixelSize(0, 0);
        a.recycle();
    }

    public void setPresenter(ActionMenuPresenter presenter) {
        this.mPresenter = presenter;
    }

    public boolean isExpandedFormat() {
        return this.mFormatItems;
    }

    public void onConfigurationChanged(Configuration newConfig) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(newConfig);
        }
        this.mPresenter.updateMenuView(false);
        if (this.mPresenter != null && this.mPresenter.isOverflowMenuShowing()) {
            this.mPresenter.hideOverflowMenu();
            this.mPresenter.showOverflowMenu();
        }
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        boolean z;
        boolean wasFormatted = this.mFormatItems;
        if (MeasureSpec.getMode(widthMeasureSpec) == 1073741824) {
            z = true;
        } else {
            z = false;
        }
        this.mFormatItems = z;
        if (wasFormatted != this.mFormatItems) {
            this.mFormatItemsWidth = 0;
        }
        int widthSize = MeasureSpec.getMode(widthMeasureSpec);
        if (!(!this.mFormatItems || this.mMenu == null || widthSize == this.mFormatItemsWidth)) {
            this.mFormatItemsWidth = widthSize;
            this.mMenu.onItemsChanged(true);
        }
        if (this.mFormatItems) {
            onMeasureExactFormat(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            LayoutParams lp = (LayoutParams) getChildAt(i).getLayoutParams();
            lp.rightMargin = 0;
            lp.leftMargin = 0;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private void onMeasureExactFormat(int widthMeasureSpec, int heightMeasureSpec) {
        int itemHeightSpec;
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int widthPadding = getPaddingLeft() + getPaddingRight();
        int heightPadding = getPaddingTop() + getPaddingBottom();
        if (heightMode == 1073741824) {
            itemHeightSpec = MeasureSpec.makeMeasureSpec(heightSize - heightPadding, 1073741824);
        } else {
            itemHeightSpec = MeasureSpec.makeMeasureSpec(Math.min(this.mMaxItemHeight, heightSize - heightPadding), ExploreByTouchHelper.INVALID_ID);
        }
        widthSize -= widthPadding;
        int cellCount = widthSize / this.mMinCellSize;
        int cellSizeRemaining = widthSize % this.mMinCellSize;
        if (cellCount == 0) {
            setMeasuredDimension(widthSize, 0);
            return;
        }
        int i;
        LayoutParams lp;
        int cellSize = this.mMinCellSize + (cellSizeRemaining / cellCount);
        int cellsRemaining = cellCount;
        int maxChildHeight = 0;
        int maxCellsUsed = 0;
        int expandableItemCount = 0;
        int visibleItemCount = 0;
        boolean hasOverflow = false;
        long smallestItemsAt = 0;
        int childCount = getChildCount();
        for (i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != 8) {
                int cellsAvailable;
                boolean isGeneratedItem = child instanceof ActionMenuItemView;
                visibleItemCount++;
                if (isGeneratedItem) {
                    child.setPadding(this.mGeneratedItemPadding, 0, this.mGeneratedItemPadding, 0);
                }
                lp = (LayoutParams) child.getLayoutParams();
                lp.expanded = false;
                lp.extraPixels = 0;
                lp.cellsUsed = 0;
                lp.expandable = false;
                lp.leftMargin = 0;
                lp.rightMargin = 0;
                boolean z = isGeneratedItem && ((ActionMenuItemView) child).hasText();
                lp.preventEdgeOffset = z;
                if (lp.isOverflowButton) {
                    cellsAvailable = 1;
                } else {
                    cellsAvailable = cellsRemaining;
                }
                int cellsUsed = measureChildForCells(child, cellSize, cellsAvailable, itemHeightSpec, heightPadding);
                maxCellsUsed = Math.max(maxCellsUsed, cellsUsed);
                if (lp.expandable) {
                    expandableItemCount++;
                }
                if (lp.isOverflowButton) {
                    hasOverflow = true;
                }
                cellsRemaining -= cellsUsed;
                maxChildHeight = Math.max(maxChildHeight, child.getMeasuredHeight());
                if (cellsUsed == 1) {
                    smallestItemsAt |= (long) (1 << i);
                }
            }
        }
        boolean centerSingleExpandedItem = hasOverflow && visibleItemCount == 2;
        boolean needsExpansion = false;
        while (expandableItemCount > 0 && cellsRemaining > 0) {
            int minCells = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            long minCellsAt = 0;
            int minCellsItemCount = 0;
            for (i = 0; i < childCount; i++) {
                int i2;
                lp = (LayoutParams) getChildAt(i).getLayoutParams();
                if (lp.expandable) {
                    i2 = lp.cellsUsed;
                    if (r0 < minCells) {
                        minCells = lp.cellsUsed;
                        minCellsAt = (long) (1 << i);
                        minCellsItemCount = 1;
                    } else {
                        i2 = lp.cellsUsed;
                        if (r0 == minCells) {
                            minCellsAt |= (long) (1 << i);
                            minCellsItemCount++;
                        }
                    }
                }
            }
            smallestItemsAt |= minCellsAt;
            if (minCellsItemCount > cellsRemaining) {
                break;
            }
            minCells++;
            for (i = 0; i < childCount; i++) {
                child = getChildAt(i);
                lp = (LayoutParams) child.getLayoutParams();
                if ((((long) (1 << i)) & minCellsAt) == 0) {
                    i2 = lp.cellsUsed;
                    if (r0 == minCells) {
                        smallestItemsAt |= (long) (1 << i);
                    }
                } else {
                    if (centerSingleExpandedItem && lp.preventEdgeOffset && cellsRemaining == 1) {
                        child.setPadding(this.mGeneratedItemPadding + cellSize, 0, this.mGeneratedItemPadding, 0);
                    }
                    lp.cellsUsed++;
                    lp.expanded = true;
                    cellsRemaining--;
                }
            }
            needsExpansion = true;
        }
        boolean singleItem = !hasOverflow && visibleItemCount == 1;
        if (cellsRemaining > 0 && smallestItemsAt != 0 && (cellsRemaining < visibleItemCount - 1 || singleItem || maxCellsUsed > 1)) {
            float expandCount = (float) Long.bitCount(smallestItemsAt);
            if (!singleItem) {
                if ((1 & smallestItemsAt) != 0) {
                    if (!((LayoutParams) getChildAt(0).getLayoutParams()).preventEdgeOffset) {
                        expandCount -= 0.5f;
                    }
                }
                if ((((long) (1 << (childCount - 1))) & smallestItemsAt) != 0) {
                    if (!((LayoutParams) getChildAt(childCount - 1).getLayoutParams()).preventEdgeOffset) {
                        expandCount -= 0.5f;
                    }
                }
            }
            int extraPixels = expandCount > 0.0f ? (int) (((float) (cellsRemaining * cellSize)) / expandCount) : 0;
            for (i = 0; i < childCount; i++) {
                if ((((long) (1 << i)) & smallestItemsAt) != 0) {
                    child = getChildAt(i);
                    lp = (LayoutParams) child.getLayoutParams();
                    if (child instanceof ActionMenuItemView) {
                        lp.extraPixels = extraPixels;
                        lp.expanded = true;
                        if (i == 0 && !lp.preventEdgeOffset) {
                            lp.leftMargin = (-extraPixels) / 2;
                        }
                        needsExpansion = true;
                    } else if (lp.isOverflowButton) {
                        lp.extraPixels = extraPixels;
                        lp.expanded = true;
                        lp.rightMargin = (-extraPixels) / 2;
                        needsExpansion = true;
                    } else {
                        if (i != 0) {
                            lp.leftMargin = extraPixels / 2;
                        }
                        if (i != childCount - 1) {
                            lp.rightMargin = extraPixels / 2;
                        }
                    }
                }
            }
            cellsRemaining = 0;
        }
        if (needsExpansion) {
            for (i = 0; i < childCount; i++) {
                child = getChildAt(i);
                lp = (LayoutParams) child.getLayoutParams();
                if (lp.expanded) {
                    child.measure(MeasureSpec.makeMeasureSpec((lp.cellsUsed * cellSize) + lp.extraPixels, 1073741824), itemHeightSpec);
                }
            }
        }
        if (heightMode != 1073741824) {
            heightSize = maxChildHeight;
        }
        setMeasuredDimension(widthSize, heightSize);
        this.mMeasuredExtraWidth = cellsRemaining * cellSize;
    }

    static int measureChildForCells(View child, int cellSize, int cellsRemaining, int parentHeightMeasureSpec, int parentHeightPadding) {
        LayoutParams lp = (LayoutParams) child.getLayoutParams();
        int childHeightSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(parentHeightMeasureSpec) - parentHeightPadding, MeasureSpec.getMode(parentHeightMeasureSpec));
        ActionMenuItemView itemView = child instanceof ActionMenuItemView ? (ActionMenuItemView) child : null;
        boolean hasText = itemView != null && itemView.hasText();
        int cellsUsed = 0;
        if (cellsRemaining > 0 && (!hasText || cellsRemaining >= 2)) {
            child.measure(MeasureSpec.makeMeasureSpec(cellSize * cellsRemaining, ExploreByTouchHelper.INVALID_ID), childHeightSpec);
            int measuredWidth = child.getMeasuredWidth();
            cellsUsed = measuredWidth / cellSize;
            if (measuredWidth % cellSize != 0) {
                cellsUsed++;
            }
            if (hasText && cellsUsed < 2) {
                cellsUsed = 2;
            }
        }
        boolean expandable = !lp.isOverflowButton && hasText;
        lp.expandable = expandable;
        lp.cellsUsed = cellsUsed;
        child.measure(MeasureSpec.makeMeasureSpec(cellsUsed * cellSize, 1073741824), childHeightSpec);
        return cellsUsed;
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (this.mFormatItems) {
            int i;
            View v;
            int height;
            int t;
            int childCount = getChildCount();
            int midVertical = (top + bottom) / 2;
            int dividerWidth = getSupportDividerWidth();
            int nonOverflowWidth = 0;
            int nonOverflowCount = 0;
            int widthRemaining = ((right - left) - getPaddingRight()) - getPaddingLeft();
            boolean hasOverflow = false;
            for (i = 0; i < childCount; i++) {
                v = getChildAt(i);
                if (v.getVisibility() != 8) {
                    LayoutParams p = (LayoutParams) v.getLayoutParams();
                    if (p.isOverflowButton) {
                        int overflowWidth = v.getMeasuredWidth();
                        if (hasSupportDividerBeforeChildAt(i)) {
                            overflowWidth += dividerWidth;
                        }
                        height = v.getMeasuredHeight();
                        int r = (getWidth() - getPaddingRight()) - p.rightMargin;
                        t = midVertical - (height / 2);
                        v.layout(r - overflowWidth, t, r, t + height);
                        widthRemaining -= overflowWidth;
                        hasOverflow = true;
                    } else {
                        int size = (v.getMeasuredWidth() + p.leftMargin) + p.rightMargin;
                        nonOverflowWidth += size;
                        widthRemaining -= size;
                        if (hasSupportDividerBeforeChildAt(i)) {
                            nonOverflowWidth += dividerWidth;
                        }
                        nonOverflowCount++;
                    }
                }
            }
            int width;
            if (childCount != 1 || hasOverflow) {
                int spacerCount = nonOverflowCount - (hasOverflow ? 0 : 1);
                int spacerSize = Math.max(0, spacerCount > 0 ? widthRemaining / spacerCount : 0);
                int startLeft = getPaddingLeft();
                for (i = 0; i < childCount; i++) {
                    v = getChildAt(i);
                    LayoutParams lp = (LayoutParams) v.getLayoutParams();
                    if (!(v.getVisibility() == 8 || lp.isOverflowButton)) {
                        startLeft += lp.leftMargin;
                        width = v.getMeasuredWidth();
                        height = v.getMeasuredHeight();
                        t = midVertical - (height / 2);
                        v.layout(startLeft, t, startLeft + width, t + height);
                        startLeft += (lp.rightMargin + width) + spacerSize;
                    }
                }
                return;
            }
            v = getChildAt(0);
            width = v.getMeasuredWidth();
            height = v.getMeasuredHeight();
            int l = ((right - left) / 2) - (width / 2);
            t = midVertical - (height / 2);
            v.layout(l, t, l + width, t + height);
            return;
        }
        super.onLayout(changed, left, top, right, bottom);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mPresenter.dismissPopupMenus();
    }

    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    public void setOverflowReserved(boolean reserveOverflow) {
        this.mReserveOverflow = reserveOverflow;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        LayoutParams params = new LayoutParams(-2, -2);
        params.gravity = 16;
        return params;
    }

    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    protected LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams p) {
        if (!(p instanceof LayoutParams)) {
            return generateDefaultLayoutParams();
        }
        LayoutParams result = new LayoutParams((LayoutParams) p);
        if (result.gravity > 0) {
            return result;
        }
        result.gravity = 16;
        return result;
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams p) {
        return p != null && (p instanceof LayoutParams);
    }

    public LayoutParams generateOverflowButtonLayoutParams() {
        LayoutParams result = generateDefaultLayoutParams();
        result.isOverflowButton = true;
        return result;
    }

    public boolean invokeItem(MenuItemImpl item) {
        return this.mMenu.performItemAction(item, 0);
    }

    public int getWindowAnimations() {
        return 0;
    }

    public void initialize(MenuBuilder menu) {
        this.mMenu = menu;
    }

    protected boolean hasSupportDividerBeforeChildAt(int childIndex) {
        View childBefore = getChildAt(childIndex - 1);
        View child = getChildAt(childIndex);
        boolean result = false;
        if (childIndex < getChildCount() && (childBefore instanceof ActionMenuChildView)) {
            result = false | ((ActionMenuChildView) childBefore).needsDividerAfter();
        }
        if (childIndex <= 0 || !(child instanceof ActionMenuChildView)) {
            return result;
        }
        return result | ((ActionMenuChildView) child).needsDividerBefore();
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        return false;
    }
}
