package com.google.android.gms.internal;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

@eh
abstract class fg {
    private final WeakReference<View> j6;

    public fg(View view) {
        this.j6 = new WeakReference(view);
    }

    public final void DW() {
        ViewTreeObserver FH = FH();
        if (FH != null) {
            DW(FH);
        }
    }

    protected abstract void DW(ViewTreeObserver viewTreeObserver);

    protected ViewTreeObserver FH() {
        View view = (View) this.j6.get();
        if (view == null) {
            return null;
        }
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        return (viewTreeObserver == null || !viewTreeObserver.isAlive()) ? null : viewTreeObserver;
    }

    public final void j6() {
        ViewTreeObserver FH = FH();
        if (FH != null) {
            j6(FH);
        }
    }

    protected abstract void j6(ViewTreeObserver viewTreeObserver);
}
