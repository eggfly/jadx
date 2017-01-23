package com.miui.support.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.RemotableViewMethod;
import android.widget.RemoteViews.RemoteView;
import com.miui.support.internal.widget.ProgressBarDelegate;

@RemoteView
public class ProgressBar extends android.widget.ProgressBar {
    private ProgressBarDelegate f4321a;

    public ProgressBar(Context context) {
        this(context, null);
    }

    public ProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842871);
    }

    public ProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        getDelegate().m4857a(attributeSet, i);
    }

    @RemotableViewMethod
    public synchronized void setIndeterminate(boolean z) {
        getDelegate().m4858a(z);
    }

    public void setProgressDrawable(Drawable drawable) {
        getDelegate().m4856a(drawable);
    }

    @RemotableViewMethod
    public void setIndeterminateDrawable(Drawable drawable) {
        getDelegate().m4860b(drawable);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        getDelegate().m4855a(i, i2, i3, i4);
    }

    public synchronized void setProgressMaskDrawable(Drawable drawable) {
        getDelegate().m4861c(drawable);
    }

    public Drawable getProgressMaskDrawable() {
        return getDelegate().m4854a();
    }

    private synchronized ProgressBarDelegate getDelegate() {
        if (this.f4321a == null) {
            this.f4321a = ProgressBarDelegate.m4846a((android.widget.ProgressBar) this, android.widget.ProgressBar.class);
        }
        return this.f4321a;
    }
}
