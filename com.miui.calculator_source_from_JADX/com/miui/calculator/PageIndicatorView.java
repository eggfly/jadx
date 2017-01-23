package com.miui.calculator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.miui.support.internal.C0264R;

public class PageIndicatorView extends LinearLayout {
    private Context f1357a;
    private int f1358b;

    public PageIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1357a = null;
        this.f1358b = 3;
        this.f1357a = context;
        this.f1358b = (int) (getResources().getDisplayMetrics().density * ((float) this.f1358b));
    }

    public void setIndicatorCount(int i) {
        removeAllViews();
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(this.f1358b, this.f1358b, this.f1358b, this.f1358b);
        for (int i2 = 0; i2 < i; i2++) {
            View imageView = new ImageView(this.f1357a);
            if (i2 == 0) {
                imageView.setImageResource(C0264R.drawable.seekpoint_highlight);
            } else {
                imageView.setImageResource(C0264R.drawable.seekpoint_normal);
            }
            addView(imageView, layoutParams);
        }
    }

    public void setSelectedPage(int i) {
        if (getLayoutDirection() == 1) {
            i = -i;
        }
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            ImageView imageView = (ImageView) getChildAt(i2);
            if (i2 == i) {
                imageView.setImageResource(C0264R.drawable.seekpoint_highlight);
            } else {
                imageView.setImageResource(C0264R.drawable.seekpoint_normal);
            }
        }
    }
}
