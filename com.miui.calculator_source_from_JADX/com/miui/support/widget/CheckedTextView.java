package com.miui.support.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.view.View;
import com.miui.support.internal.C0264R;
import com.miui.support.util.ViewUtils;

public class CheckedTextView extends android.widget.CheckedTextView {
    private static final int[] f3996a;
    private Drawable f3997b;

    static {
        f3996a = new int[]{16842912};
    }

    public CheckedTextView(Context context) {
        this(context, null);
    }

    public CheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public CheckedTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public Drawable getCheckMarkDrawable() {
        return this.f3997b;
    }

    public void setCheckMarkDrawable(Drawable drawable) {
        if (this.f3997b != null) {
            this.f3997b.setCallback(null);
            unscheduleDrawable(this.f3997b);
        }
        if (drawable != null) {
            drawable.setCallback(this);
            drawable.setVisible(getVisibility() == 0, false);
            drawable.setState(f3996a);
            setMinHeight(drawable.getIntrinsicHeight());
            drawable.setState(getDrawableState());
        }
        this.f3997b = drawable;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onMeasure(int r4, int r5) {
        /*
        r3 = this;
        super.onMeasure(r4, r5);
        r0 = r3.getCheckWidth();
        if (r0 != 0) goto L_0x000a;
    L_0x0009:
        return;
    L_0x000a:
        r2 = android.view.View.MeasureSpec.getMode(r4);
        r1 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r2 == r1) goto L_0x0009;
    L_0x0012:
        r1 = r3.getMeasuredWidth();
        r1 = r1 + r0;
        r0 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        if (r2 != r0) goto L_0x0029;
    L_0x001b:
        r0 = android.view.View.MeasureSpec.getSize(r4);
        if (r1 <= r0) goto L_0x0029;
    L_0x0021:
        r1 = r3.getMeasuredHeight();
        r3.setMeasuredDimension(r0, r1);
        goto L_0x0009;
    L_0x0029:
        r0 = r1;
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.support.widget.CheckedTextView.onMeasure(int, int):void");
    }

    private int getCheckWidth() {
        Drawable checkMarkDrawable = getCheckMarkDrawable();
        return checkMarkDrawable == null ? 0 : checkMarkDrawable.getCurrent().getIntrinsicWidth();
    }

    protected void onDraw(Canvas canvas) {
        m5709b(canvas);
        m5708a(canvas);
    }

    private void m5708a(Canvas canvas) {
        int checkWidth = getCheckWidth();
        if (checkWidth == 0) {
            super.onDraw(canvas);
            return;
        }
        checkWidth += 0;
        if (ViewUtils.m5452a((View) this)) {
            checkWidth = -checkWidth;
        }
        canvas.translate((float) checkWidth, 0.0f);
        super.onDraw(canvas);
        canvas.translate((float) (-checkWidth), 0.0f);
    }

    private void m5709b(Canvas canvas) {
        Drawable checkMarkDrawable = getCheckMarkDrawable();
        if (checkMarkDrawable != null) {
            int width;
            int intrinsicWidth = checkMarkDrawable.getCurrent().getIntrinsicWidth();
            if (ViewUtils.m5452a((View) this)) {
                width = ((getWidth() - getPaddingRight()) - intrinsicWidth) + getScrollX();
            } else {
                width = getPaddingLeft() + getScrollX();
            }
            int paddingTop = getPaddingTop();
            int intrinsicHeight = checkMarkDrawable.getIntrinsicHeight();
            if (!(checkMarkDrawable.getCurrent() instanceof NinePatchDrawable)) {
                switch (getGravity() & 112) {
                    case C0264R.styleable.Window_contentAutoFitSystemWindow /*16*/:
                        paddingTop = (getHeight() - intrinsicHeight) / 2;
                        break;
                    case 80:
                        paddingTop = getHeight() - intrinsicHeight;
                        break;
                    default:
                        break;
                }
            }
            intrinsicHeight = (getHeight() - paddingTop) - getPaddingBottom();
            checkMarkDrawable.setBounds(width, paddingTop, intrinsicWidth + width, intrinsicHeight + paddingTop);
            checkMarkDrawable.draw(canvas);
        }
    }

    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f3996a);
        }
        return onCreateDrawableState;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f3997b != null) {
            this.f3997b.setState(getDrawableState());
            invalidate();
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f3997b;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.f3997b != null) {
            this.f3997b.jumpToCurrentState();
        }
    }
}
