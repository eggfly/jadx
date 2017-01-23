package com.google.android.gms.p146b;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.b.ig */
abstract class ig {
    private final WeakReference<View> f11405a;

    public ig(View view) {
        this.f11405a = new WeakReference(view);
    }

    public final void m13204a() {
        ViewTreeObserver c = m13208c();
        if (c != null) {
            m13205a(c);
        }
    }

    protected abstract void m13205a(ViewTreeObserver viewTreeObserver);

    public final void m13206b() {
        ViewTreeObserver c = m13208c();
        if (c != null) {
            m13207b(c);
        }
    }

    protected abstract void m13207b(ViewTreeObserver viewTreeObserver);

    protected ViewTreeObserver m13208c() {
        View view = (View) this.f11405a.get();
        if (view == null) {
            return null;
        }
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        return (viewTreeObserver == null || !viewTreeObserver.isAlive()) ? null : viewTreeObserver;
    }
}
