package com.google.android.gms.analytics.internal;

import com.google.android.gms.internal.fu;

public class z extends t {
    private final fu j6;

    z(v vVar) {
        super(vVar);
        this.j6 = new fu();
    }

    public void DW() {
        q a8 = a8();
        String FH = a8.FH();
        if (FH != null) {
            this.j6.j6(FH);
        }
        String DW = a8.DW();
        if (DW != null) {
            this.j6.DW(DW);
        }
    }

    public fu FH() {
        P8();
        return this.j6;
    }

    protected void j6() {
        aM().j6().j6(this.j6);
        DW();
    }
}
