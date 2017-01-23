package com.google.android.gms.internal;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.ads.internal.overlay.i;
import com.google.android.gms.common.internal.b;

@eh
public class fh {
    private final Context DW;
    private final ViewGroup FH;
    private i Hw;
    private final fj j6;

    public fh(Context context, ViewGroup viewGroup, fj fjVar) {
        this(context, viewGroup, fjVar, null);
    }

    fh(Context context, ViewGroup viewGroup, fj fjVar, i iVar) {
        this.DW = context;
        this.FH = viewGroup;
        this.j6 = fjVar;
        this.Hw = iVar;
    }

    public void DW() {
        b.DW("onPause must be called from the UI thread.");
        if (this.Hw != null) {
            this.Hw.DW();
        }
    }

    public void FH() {
        b.DW("onDestroy must be called from the UI thread.");
        if (this.Hw != null) {
            this.Hw.VH();
            this.FH.removeView(this.Hw);
            this.Hw = null;
        }
    }

    public i j6() {
        b.DW("getAdVideoUnderlay must be called from the UI thread.");
        return this.Hw;
    }

    public void j6(int i, int i2, int i3, int i4) {
        b.DW("The underlay may only be modified from the UI thread.");
        if (this.Hw != null) {
            this.Hw.j6(i, i2, i3, i4);
        }
    }

    public void j6(int i, int i2, int i3, int i4, int i5, boolean z) {
        if (this.Hw == null) {
            at.j6(this.j6.lg().j6(), this.j6.a8(), "vpr");
            aw j6 = at.j6(this.j6.lg().j6());
            this.Hw = new i(this.DW, this.j6, i5, z, this.j6.lg().j6(), j6);
            this.FH.addView(this.Hw, 0, new LayoutParams(-1, -1));
            this.Hw.j6(i, i2, i3, i4);
            this.j6.J0().j6(false);
        }
    }
}
