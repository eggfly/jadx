package com.viewpagerindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

/* renamed from: com.viewpagerindicator.b */
class C4287b extends LinearLayout {
    private static final int[] f14700a;
    private Drawable f14701b;
    private int f14702c;
    private int f14703d;
    private int f14704e;
    private int f14705f;

    static {
        f14700a = new int[]{16843049, 16843561, 16843562};
    }

    public C4287b(Context context, int i) {
        super(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, f14700a, i, 0);
        setDividerDrawable(obtainStyledAttributes.getDrawable(0));
        this.f14705f = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.f14704e = obtainStyledAttributes.getInteger(1, 0);
        obtainStyledAttributes.recycle();
    }

    private void m17585a(Canvas canvas) {
        int childCount = getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = getChildAt(i);
            if (!(childAt == null || childAt.getVisibility() == 8 || !m17587a(i))) {
                m17586a(canvas, childAt.getTop() - ((LayoutParams) childAt.getLayoutParams()).topMargin);
            }
            i++;
        }
        if (m17587a(childCount)) {
            View childAt2 = getChildAt(childCount - 1);
            m17586a(canvas, childAt2 == null ? (getHeight() - getPaddingBottom()) - this.f14703d : childAt2.getBottom());
        }
    }

    private void m17586a(Canvas canvas, int i) {
        this.f14701b.setBounds(getPaddingLeft() + this.f14705f, i, (getWidth() - getPaddingRight()) - this.f14705f, this.f14703d + i);
        this.f14701b.draw(canvas);
    }

    private boolean m17587a(int i) {
        if (i == 0 || i == getChildCount() || (this.f14704e & 2) == 0) {
            return false;
        }
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (getChildAt(i2).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    private void m17588b(Canvas canvas) {
        int childCount = getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = getChildAt(i);
            if (!(childAt == null || childAt.getVisibility() == 8 || !m17587a(i))) {
                m17589b(canvas, childAt.getLeft() - ((LayoutParams) childAt.getLayoutParams()).leftMargin);
            }
            i++;
        }
        if (m17587a(childCount)) {
            View childAt2 = getChildAt(childCount - 1);
            m17589b(canvas, childAt2 == null ? (getWidth() - getPaddingRight()) - this.f14702c : childAt2.getRight());
        }
    }

    private void m17589b(Canvas canvas, int i) {
        this.f14701b.setBounds(i, getPaddingTop() + this.f14705f, this.f14702c + i, (getHeight() - getPaddingBottom()) - this.f14705f);
        this.f14701b.draw(canvas);
    }

    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        int indexOfChild = indexOfChild(view);
        int orientation = getOrientation();
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (m17587a(indexOfChild)) {
            if (orientation == 1) {
                layoutParams.topMargin = this.f14703d;
            } else {
                layoutParams.leftMargin = this.f14702c;
            }
        }
        int childCount = getChildCount();
        if (indexOfChild == childCount - 1 && m17587a(childCount)) {
            if (orientation == 1) {
                layoutParams.bottomMargin = this.f14703d;
            } else {
                layoutParams.rightMargin = this.f14702c;
            }
        }
        super.measureChildWithMargins(view, i, i2, i3, i4);
    }

    protected void onDraw(Canvas canvas) {
        if (this.f14701b != null) {
            if (getOrientation() == 1) {
                m17585a(canvas);
            } else {
                m17588b(canvas);
            }
        }
        super.onDraw(canvas);
    }

    public void setDividerDrawable(Drawable drawable) {
        boolean z = false;
        if (drawable != this.f14701b) {
            this.f14701b = drawable;
            if (drawable != null) {
                this.f14702c = drawable.getIntrinsicWidth();
                this.f14703d = drawable.getIntrinsicHeight();
            } else {
                this.f14702c = 0;
                this.f14703d = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }
}
