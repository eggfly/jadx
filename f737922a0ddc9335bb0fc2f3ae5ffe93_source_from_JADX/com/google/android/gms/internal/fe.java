package com.google.android.gms.internal;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.google.android.gms.ads.internal.f;
import java.lang.ref.WeakReference;

@eh
class fe extends fg implements OnGlobalLayoutListener {
    private final WeakReference<OnGlobalLayoutListener> j6;

    public fe(View view, OnGlobalLayoutListener onGlobalLayoutListener) {
        super(view);
        this.j6 = new WeakReference(onGlobalLayoutListener);
    }

    protected void DW(ViewTreeObserver viewTreeObserver) {
        f.v5().j6(viewTreeObserver, (OnGlobalLayoutListener) this);
    }

    protected void j6(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnGlobalLayoutListener(this);
    }

    public void onGlobalLayout() {
        OnGlobalLayoutListener onGlobalLayoutListener = (OnGlobalLayoutListener) this.j6.get();
        if (onGlobalLayoutListener != null) {
            onGlobalLayoutListener.onGlobalLayout();
        } else {
            DW();
        }
    }
}
