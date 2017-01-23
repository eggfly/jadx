package com.google.android.gms.p146b;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import java.lang.ref.WeakReference;

@gb
/* renamed from: com.google.android.gms.b.if */
class C3282if extends ig implements OnScrollChangedListener {
    private final WeakReference<OnScrollChangedListener> f11407a;

    public C3282if(View view, OnScrollChangedListener onScrollChangedListener) {
        super(view);
        this.f11407a = new WeakReference(onScrollChangedListener);
    }

    protected void m13211a(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnScrollChangedListener(this);
    }

    protected void m13212b(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.removeOnScrollChangedListener(this);
    }

    public void onScrollChanged() {
        OnScrollChangedListener onScrollChangedListener = (OnScrollChangedListener) this.f11407a.get();
        if (onScrollChangedListener != null) {
            onScrollChangedListener.onScrollChanged();
        } else {
            m13206b();
        }
    }
}
