package com.google.android.gms.internal;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import java.lang.ref.WeakReference;

@eh
class ff extends fg implements OnScrollChangedListener {
    private final WeakReference<OnScrollChangedListener> j6;

    public ff(View view, OnScrollChangedListener onScrollChangedListener) {
        super(view);
        this.j6 = new WeakReference(onScrollChangedListener);
    }

    protected void DW(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.removeOnScrollChangedListener(this);
    }

    protected void j6(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnScrollChangedListener(this);
    }

    public void onScrollChanged() {
        OnScrollChangedListener onScrollChangedListener = (OnScrollChangedListener) this.j6.get();
        if (onScrollChangedListener != null) {
            onScrollChangedListener.onScrollChanged();
        } else {
            DW();
        }
    }
}
