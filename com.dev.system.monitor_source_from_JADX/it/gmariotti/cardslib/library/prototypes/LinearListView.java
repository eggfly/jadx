package it.gmariotti.cardslib.library.prototypes;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import it.gmariotti.cardslib.library.C0173R;

public class LinearListView extends LinearLayout {
    public static final int INVALID_POSITION = -1;
    private static final int LinearLayout_divider = 0;
    private static final int[] R_styleable_LinearLayout;
    private Drawable mDivider;
    protected int mDividerHeight;
    protected int mDividerWidth;
    private LinearListAdapter mListAdapter;

    public LinearListView(Context context) {
        super(context);
        initAttrs(null, 0);
    }

    public LinearListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(attrs, 0);
    }

    public LinearListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initAttrs(attrs, defStyle);
    }

    protected void initAttrs(AttributeSet attrs, int defStyle) {
        TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs, R_styleable_LinearLayout, defStyle, defStyle);
        try {
            Drawable d = a.getDrawable(0);
            if (d != null) {
                setDividerDrawable(d);
            }
            a.recycle();
            a = getContext().getTheme().obtainStyledAttributes(attrs, C0173R.styleable.card_listItem, defStyle, defStyle);
            try {
                int dividerHeight = a.getDimensionPixelSize(C0173R.styleable.card_listItem_card_list_item_dividerHeight, 0);
                if (dividerHeight != 0) {
                    setDividerHeight(dividerHeight);
                }
                a.recycle();
            } catch (Throwable th) {
                a.recycle();
            }
        } catch (Throwable th2) {
            a.recycle();
        }
    }

    static {
        R_styleable_LinearLayout = new int[]{16843049, 16843476, 16843561, 16843562};
    }

    public void setDividerDrawable(Drawable divider) {
        boolean z = false;
        if (divider != this.mDivider) {
            this.mDivider = divider;
            if (divider != null) {
                this.mDividerWidth = divider.getIntrinsicWidth();
                this.mDividerHeight = divider.getIntrinsicHeight();
            } else {
                this.mDividerWidth = 0;
                this.mDividerHeight = 0;
            }
            if (divider == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    protected void measureChildWithMargins(View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
        int index = indexOfChild(child);
        int orientation = getOrientation();
        LayoutParams params = (LayoutParams) child.getLayoutParams();
        if (hasDividerBeforeChildAt(index)) {
            if (orientation == 1) {
                params.topMargin = this.mDividerHeight;
            } else {
                params.leftMargin = this.mDividerWidth;
            }
        }
        int count = getChildCount();
        if (index == count + INVALID_POSITION && hasDividerBeforeChildAt(count)) {
            if (orientation == 1) {
                params.bottomMargin = this.mDividerHeight;
            } else {
                params.rightMargin = this.mDividerWidth;
            }
        }
        super.measureChildWithMargins(child, parentWidthMeasureSpec, widthUsed, parentHeightMeasureSpec, heightUsed);
    }

    protected void onDraw(Canvas canvas) {
        if (this.mDivider != null) {
            if (getOrientation() == 1) {
                drawDividersVertical(canvas);
            } else {
                drawDividersHorizontal(canvas);
            }
        }
        super.onDraw(canvas);
    }

    void drawDividersVertical(Canvas canvas) {
        int count = getChildCount();
        int i = 0;
        while (i < count) {
            View child = getChildAt(i);
            if (!(child == null || child.getVisibility() == 8 || !hasDividerBeforeChildAt(i))) {
                drawHorizontalDivider(canvas, child.getTop() - ((LayoutParams) child.getLayoutParams()).topMargin);
            }
            i++;
        }
        if (hasDividerBeforeChildAt(count)) {
            int bottom;
            child = getChildAt(count + INVALID_POSITION);
            if (child == null) {
                bottom = (getHeight() - getPaddingBottom()) - this.mDividerHeight;
            } else {
                bottom = child.getBottom();
            }
            drawHorizontalDivider(canvas, bottom);
        }
    }

    void drawDividersHorizontal(Canvas canvas) {
        int count = getChildCount();
        int i = 0;
        while (i < count) {
            View child = getChildAt(i);
            if (!(child == null || child.getVisibility() == 8 || !hasDividerBeforeChildAt(i))) {
                drawVerticalDivider(canvas, child.getLeft() - ((LayoutParams) child.getLayoutParams()).leftMargin);
            }
            i++;
        }
        if (hasDividerBeforeChildAt(count)) {
            int right;
            child = getChildAt(count + INVALID_POSITION);
            if (child == null) {
                right = (getWidth() - getPaddingRight()) - this.mDividerWidth;
            } else {
                right = child.getRight();
            }
            drawVerticalDivider(canvas, right);
        }
    }

    void drawHorizontalDivider(Canvas canvas, int top) {
        this.mDivider.setBounds(getPaddingLeft() + getDividerPadding(), top, (getWidth() - getPaddingRight()) - getDividerPadding(), this.mDividerHeight + top);
        this.mDivider.draw(canvas);
    }

    void drawVerticalDivider(Canvas canvas, int left) {
        this.mDivider.setBounds(left, getPaddingTop() + getDividerPadding(), this.mDividerWidth + left, (getHeight() - getPaddingBottom()) - getDividerPadding());
        this.mDivider.draw(canvas);
    }

    protected boolean hasDividerBeforeChildAt(int childIndex) {
        if (childIndex == 0) {
            if ((getShowDividers() & 1) != 0) {
                return true;
            }
            return false;
        } else if (childIndex == getChildCount()) {
            if ((getShowDividers() & 4) == 0) {
                return false;
            }
            return true;
        } else if ((getShowDividers() & 2) == 0) {
            return false;
        } else {
            boolean hasVisibleViewBefore = false;
            for (int i = childIndex + INVALID_POSITION; i >= 0; i += INVALID_POSITION) {
                if (getChildAt(i).getVisibility() != 8) {
                    hasVisibleViewBefore = true;
                    break;
                }
            }
            return hasVisibleViewBefore;
        }
    }

    public int getDividerHeight() {
        return this.mDividerHeight;
    }

    public void setDividerHeight(int height) {
        if (getOrientation() == 1) {
            this.mDividerHeight = height;
        } else {
            this.mDividerWidth = height;
        }
        requestLayout();
    }

    public void setOrientation(int orientation) {
        if (orientation != getOrientation()) {
            int tmp = this.mDividerHeight;
            this.mDividerHeight = this.mDividerWidth;
            this.mDividerWidth = tmp;
        }
        super.setOrientation(orientation);
    }

    public void setAdapter(LinearListAdapter listAdapter) {
        this.mListAdapter = listAdapter;
        setOrientation(1);
        if (this.mListAdapter != null) {
            for (int i = 0; i < this.mListAdapter.getCount(); i++) {
                View itemView = this.mListAdapter.getView(i, null, null);
                if (itemView != null) {
                    addView(itemView);
                }
            }
        }
    }

    public LinearListAdapter getAdapter() {
        return this.mListAdapter;
    }

    public int getPositionForView(View view) {
        View listItem = view;
        while (true) {
            try {
                View v = (View) listItem.getParent();
                if (v.equals(this)) {
                    break;
                }
                listItem = v;
            } catch (ClassCastException e) {
                return INVALID_POSITION;
            }
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i).equals(listItem)) {
                return i;
            }
        }
        return INVALID_POSITION;
    }
}
