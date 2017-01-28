package com.miui.support.internal.variable.hook.v16;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AbsSeekBar;
import com.miui.support.reflect.Field;

public class Android_Widget_AbsSeekBar_class extends com.miui.support.internal.variable.hook.Android_Widget_AbsSeekBar_class {
    protected static final Field mIsDragging;
    protected static final Field mThumb;
    protected static final Field mThumbOffset;

    static {
        mThumb = Field.of(AbsSeekBar.class, "mThumb", "Landroid/graphics/drawable/Drawable;");
        mThumbOffset = Field.of(AbsSeekBar.class, "mThumbOffset", Field.INT_SIGNATURE_PRIMITIVE);
        mIsDragging = Field.of(AbsSeekBar.class, "mIsDragging", Field.BOOLEAN_SIGNATURE_PRIMITIVE);
    }

    public void buildProxy() {
        attachMethod("onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    }

    protected void handle() {
        handleOnTouchEvent(0, null, null);
    }

    protected boolean handleOnTouchEvent(long j, AbsSeekBar absSeekBar, MotionEvent motionEvent) {
        Drawable drawable = (Drawable) mThumb.get(absSeekBar);
        if (drawable == null) {
            return originalOnTouchEvent(j, absSeekBar, motionEvent);
        }
        boolean z = mIsDragging.getBoolean(absSeekBar);
        if (!z && ((AccessibilityManager) absSeekBar.getContext().getSystemService("accessibility")).isEnabled()) {
            return originalOnTouchEvent(j, absSeekBar, motionEvent);
        }
        int paddingLeft = absSeekBar.getPaddingLeft() - mThumbOffset.getInt(absSeekBar);
        int intrinsicWidth = (drawable.getBounds().left + paddingLeft) - (drawable.getIntrinsicWidth() / 2);
        int intrinsicWidth2 = (drawable.getIntrinsicWidth() / 2) + (paddingLeft + drawable.getBounds().right);
        if (z || (motionEvent.getX() > ((float) intrinsicWidth) && motionEvent.getX() < ((float) intrinsicWidth2))) {
            return originalOnTouchEvent(j, absSeekBar, motionEvent);
        }
        return false;
    }

    protected boolean originalOnTouchEvent(long j, AbsSeekBar absSeekBar, MotionEvent motionEvent) {
        throw new IllegalStateException("com.miui.internal.variable.v16.Android_Widget_AbsSeekBar_class.originalOnTouchEvent(long, AbsSeekBar, MotionEvent)");
    }
}
