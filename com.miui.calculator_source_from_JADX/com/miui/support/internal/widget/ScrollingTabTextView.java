package com.miui.support.internal.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.miui.support.internal.C0264R;
import com.miui.support.util.ViewUtils;

public class ScrollingTabTextView extends TextView {
    private ColorStateList f3209a;
    private int f3210b;
    private int f3211c;
    private ValueAnimator f3212d;
    private int f3213e;
    private boolean f3214f;

    /* renamed from: com.miui.support.internal.widget.ScrollingTabTextView.1 */
    class C03941 implements AnimatorUpdateListener {
        final /* synthetic */ ScrollingTabTextView f3207a;

        C03941(ScrollingTabTextView scrollingTabTextView) {
            this.f3207a = scrollingTabTextView;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f3207a.f3213e = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            this.f3207a.invalidate();
        }
    }

    /* renamed from: com.miui.support.internal.widget.ScrollingTabTextView.2 */
    class C03952 extends AnimatorListenerAdapter {
        final /* synthetic */ ScrollingTabTextView f3208a;

        C03952(ScrollingTabTextView scrollingTabTextView) {
            this.f3208a = scrollingTabTextView;
        }

        public void onAnimationEnd(Animator animator) {
            this.f3208a.f3213e = this.f3208a.getWidth();
        }
    }

    public ScrollingTabTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3209a = getTextColors();
        this.f3210b = this.f3209a.getColorForState(ENABLED_STATE_SET, getResources().getColor(C0264R.color.action_bar_tab_text_color_normal_light));
        this.f3211c = this.f3209a.getColorForState(ENABLED_SELECTED_STATE_SET, getResources().getColor(C0264R.color.action_bar_tab_text_color_selected_light));
    }

    protected void onDraw(Canvas canvas) {
        if (this.f3212d == null || !this.f3212d.isRunning()) {
            super.onDraw(canvas);
            return;
        }
        int i;
        int scrollX;
        if ((!this.f3214f || isSelected()) && (this.f3214f || !isSelected())) {
            i = this.f3211c;
        } else {
            i = this.f3210b;
        }
        setTextColor(i);
        boolean a = ViewUtils.m5452a((View) this);
        int i2 = this.f3213e;
        int height = getHeight();
        if (a) {
            scrollX = getScrollX() + 0;
            i2 += getScrollX();
        } else {
            scrollX = 0;
        }
        canvas.save();
        canvas.clipRect(scrollX, 0, i2, height);
        super.onDraw(canvas);
        canvas.restore();
        if (i == this.f3210b) {
            i = this.f3211c;
        } else if (i == this.f3211c) {
            i = this.f3210b;
        }
        setTextColor(i);
        i2 = this.f3213e;
        i = getWidth();
        if (a) {
            i2 += getScrollX();
            i += getScrollX();
        }
        canvas.save();
        canvas.clipRect(i2, 0, i, height);
        super.onDraw(canvas);
        canvas.restore();
        setTextColor(this.f3209a);
    }

    public void m4884a(boolean z) {
        int width;
        int i;
        if (this.f3212d == null) {
            this.f3212d = new ValueAnimator();
        } else {
            this.f3212d.cancel();
        }
        this.f3214f = z;
        if (this.f3214f) {
            width = getWidth();
            i = 0;
        } else {
            i = getWidth();
            width = 0;
        }
        this.f3212d.setIntValues(new int[]{i, width});
        this.f3212d.setDuration(200);
        this.f3212d.addUpdateListener(new C03941(this));
        this.f3212d.addListener(new C03952(this));
        this.f3212d.start();
    }
}
