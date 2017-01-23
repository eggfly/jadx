package com.google.android.gms.p146b;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.google.android.gms.ads.internal.C2968s;
import java.lang.ref.WeakReference;

@gb
/* renamed from: com.google.android.gms.b.ie */
class ie extends ig implements OnGlobalLayoutListener {
    private final WeakReference<OnGlobalLayoutListener> f11406a;

    public ie(View view, OnGlobalLayoutListener onGlobalLayoutListener) {
        super(view);
        this.f11406a = new WeakReference(onGlobalLayoutListener);
    }

    protected void m13209a(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnGlobalLayoutListener(this);
    }

    protected void m13210b(ViewTreeObserver viewTreeObserver) {
        C2968s.m11527g().m13083a(viewTreeObserver, (OnGlobalLayoutListener) this);
    }

    public void onGlobalLayout() {
        OnGlobalLayoutListener onGlobalLayoutListener = (OnGlobalLayoutListener) this.f11406a.get();
        if (onGlobalLayoutListener != null) {
            onGlobalLayoutListener.onGlobalLayout();
        } else {
            m13206b();
        }
    }
}
