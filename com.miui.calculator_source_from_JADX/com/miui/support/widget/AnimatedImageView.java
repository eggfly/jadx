package com.miui.support.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.miui.support.internal.variable.Android_Graphics_Drawable_AnimatedRotateDrawable_class;
import com.miui.support.internal.variable.Android_Graphics_Drawable_AnimatedRotateDrawable_class.Factory;

public class AnimatedImageView extends ImageView {
    private static final Android_Graphics_Drawable_AnimatedRotateDrawable_class f3971a;
    private Drawable f3972b;
    private boolean f3973c;

    static {
        f3971a = Factory.getInstance().get();
    }

    public AnimatedImageView(Context context) {
        super(context);
    }

    public AnimatedImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void m5681a() {
        if (isShown()) {
            m5684d();
        }
        Drawable drawable = getDrawable();
        if (drawable.getClass().getName().equals(Android_Graphics_Drawable_AnimatedRotateDrawable_class.NAME)) {
            this.f3972b = drawable;
            f3971a.setFramesCount(drawable, 56);
            f3971a.setFramesDuration(drawable, 32);
        } else {
            this.f3972b = null;
        }
        m5682b();
    }

    private void m5682b() {
        if (this.f3972b == null) {
            return;
        }
        if (isShown() && this.f3973c) {
            m5683c();
        } else {
            m5684d();
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        m5681a();
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        m5681a();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m5682b();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m5682b();
    }

    public void setAnimating(boolean z) {
        this.f3973c = z;
        m5682b();
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        m5682b();
    }

    private void m5683c() {
        if (this.f3972b != null && this.f3972b.getClass().getName().equals(Android_Graphics_Drawable_AnimatedRotateDrawable_class.NAME)) {
            f3971a.start(this.f3972b);
        }
    }

    private void m5684d() {
        if (this.f3972b != null && this.f3972b.getClass().getName().equals(Android_Graphics_Drawable_AnimatedRotateDrawable_class.NAME)) {
            f3971a.stop(this.f3972b);
        }
    }
}
