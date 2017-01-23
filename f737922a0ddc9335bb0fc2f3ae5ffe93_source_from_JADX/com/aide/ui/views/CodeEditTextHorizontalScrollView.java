package com.aide.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import com.aide.common.d;

public class CodeEditTextHorizontalScrollView extends HorizontalScrollView {
    public CodeEditTextHorizontalScrollView(Context context) {
        super(context);
    }

    public CodeEditTextHorizontalScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public CodeEditTextHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private CodeEditText getCodeEditText() {
        return (CodeEditText) ((ViewGroup) getChildAt(0)).getChildAt(1);
    }

    private c getOEditorView() {
        return getCodeEditText().getOEditorView();
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        getOEditorView().aM();
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        getOEditorView().aM();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (d.j6(motionEvent)) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
