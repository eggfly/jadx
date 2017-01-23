package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.handmark.pulltorefresh.library.listener.ScrollViewListener;

public class HomeScrollView extends ScrollView {
    private ScrollViewListener scrollViewListener;

    public HomeScrollView(Context context) {
        super(context);
        this.scrollViewListener = null;
    }

    public HomeScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.scrollViewListener = null;
    }

    public HomeScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.scrollViewListener = null;
    }

    protected int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        return 0;
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.scrollViewListener != null) {
            this.scrollViewListener.onScrollChanged(this, i, i2, i3, i4);
        }
    }

    public void setScrollViewListener(ScrollViewListener scrollViewListener) {
        this.scrollViewListener = scrollViewListener;
    }
}
