package com.antutu.benchmark.view;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import com.antutu.ABenchMark.C1082R;

public class CustomSwipeRefreshLayout extends SwipeRefreshLayout {
    public CustomSwipeRefreshLayout(Context context) {
        super(context);
        setColorSchemeResources(C1082R.color.colorPrimary_day);
    }

    public CustomSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setColorSchemeResources(C1082R.color.colorPrimary_day);
    }
}
