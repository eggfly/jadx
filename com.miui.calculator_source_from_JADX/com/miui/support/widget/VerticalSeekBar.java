package com.miui.support.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class VerticalSeekBar extends SeekBar {
    private final Rect f4524a;

    public VerticalSeekBar(Context context) {
        this(context, null);
    }

    public VerticalSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842875);
    }

    public VerticalSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4524a = new Rect();
        setLayoutDirection(0);
    }

    protected synchronized void onDraw(Canvas canvas) {
        m6134a(canvas);
        m6135b(canvas);
    }

    private void m6134a(Canvas canvas) {
        Drawable progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            canvas.save();
            canvas.rotate(-90.0f, (float) (getWidth() / 2), (float) (getHeight() / 2));
            int width = getWidth();
            int height = getHeight();
            progressDrawable.setBounds(((-(height - width)) / 2) + getPaddingBottom(), ((height - width) / 2) + getPaddingLeft(), ((height + width) / 2) - getPaddingTop(), ((width + height) / 2) - getPaddingRight());
            progressDrawable.draw(canvas);
            canvas.restore();
        }
    }

    private void m6135b(Canvas canvas) {
        Drawable thumb = getThumb();
        if (thumb != null) {
            thumb.copyBounds(this.f4524a);
            int intrinsicWidth = thumb.getIntrinsicWidth();
            int intrinsicHeight = thumb.getIntrinsicHeight();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int thumbOffset = (getThumbOffset() * 2) + (((getHeight() - getPaddingTop()) - getPaddingBottom()) - intrinsicHeight);
            int max = getMax();
            max = (int) ((max > 0 ? 1.0f - (((float) getProgress()) / ((float) max)) : 0.0f) * ((float) thumbOffset));
            width = ((width - intrinsicWidth) / 2) + getPaddingLeft();
            thumb.setBounds(width, max, intrinsicWidth + width, intrinsicHeight + max);
            thumb.draw(canvas);
            thumb.setBounds(this.f4524a);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        motionEvent.setLocation(((((((float) getHeight()) - motionEvent.getY()) - ((float) getPaddingBottom())) / ((float) ((getHeight() - getPaddingTop()) - getPaddingBottom()))) * ((float) ((getWidth() - getPaddingLeft()) - getPaddingRight()))) + ((float) getPaddingLeft()), motionEvent.getY());
        return super.onTouchEvent(motionEvent);
    }
}
