package com.google.android.gms.internal;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.internal.f;

@eh
public final class ez {
    private Activity DW;
    private boolean FH;
    private boolean Hw;
    private OnScrollChangedListener VH;
    private OnGlobalLayoutListener Zo;
    private final View j6;
    private boolean v5;

    public ez(Activity activity, View view, OnGlobalLayoutListener onGlobalLayoutListener, OnScrollChangedListener onScrollChangedListener) {
        this.DW = activity;
        this.j6 = view;
        this.Zo = onGlobalLayoutListener;
        this.VH = onScrollChangedListener;
    }

    private void Zo() {
        if (this.DW != null && this.FH) {
            if (!(this.Zo == null || this.DW == null)) {
                f.v5().j6(this.DW, this.Zo);
            }
            if (!(this.VH == null || this.DW == null)) {
                f.FH().DW(this.DW, this.VH);
            }
            this.FH = false;
        }
    }

    private void v5() {
        if (!this.FH) {
            if (this.Zo != null) {
                if (this.DW != null) {
                    f.FH().j6(this.DW, this.Zo);
                }
                f.we().j6(this.j6, this.Zo);
            }
            if (this.VH != null) {
                if (this.DW != null) {
                    f.FH().j6(this.DW, this.VH);
                }
                f.we().j6(this.j6, this.VH);
            }
            this.FH = true;
        }
    }

    public void DW() {
        this.v5 = false;
        Zo();
    }

    public void FH() {
        this.Hw = true;
        if (this.v5) {
            v5();
        }
    }

    public void Hw() {
        this.Hw = false;
        Zo();
    }

    public void j6() {
        this.v5 = true;
        if (this.Hw) {
            v5();
        }
    }

    public void j6(Activity activity) {
        this.DW = activity;
    }
}
