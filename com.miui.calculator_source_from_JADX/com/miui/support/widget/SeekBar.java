package com.miui.support.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.miui.support.internal.widget.ProgressBarDelegate;

public class SeekBar extends android.widget.SeekBar {
    private ProgressBarDelegate f4440a;

    public SeekBar(Context context) {
        this(context, null);
    }

    public SeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842875);
    }

    public SeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        getDelegate().m4857a(attributeSet, i);
    }

    public synchronized void setIndeterminate(boolean z) {
        getDelegate().m4858a(z);
    }

    public void setProgressDrawable(Drawable drawable) {
        getDelegate().m4856a(drawable);
    }

    public void setIndeterminateDrawable(Drawable drawable) {
        getDelegate().m4860b(drawable);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        getDelegate().m4855a(i, i2, i3, i4);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        getDelegate().m4859b();
    }

    public synchronized void setProgressMaskDrawable(Drawable drawable) {
        getDelegate().m4861c(drawable);
    }

    public Drawable getProgressMaskDrawable() {
        return getDelegate().m4854a();
    }

    private synchronized ProgressBarDelegate getDelegate() {
        if (this.f4440a == null) {
            this.f4440a = ProgressBarDelegate.m4846a((ProgressBar) this, android.widget.SeekBar.class);
        }
        return this.f4440a;
    }
}
