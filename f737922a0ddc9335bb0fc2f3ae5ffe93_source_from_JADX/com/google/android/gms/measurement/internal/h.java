package com.google.android.gms.measurement.internal;

import afq;
import com.google.android.gms.common.internal.b;

class h {
    private long DW;
    private final afq j6;

    public h(afq afq) {
        b.j6((Object) afq);
        this.j6 = afq;
    }

    public void DW() {
        this.DW = 0;
    }

    public void j6() {
        this.DW = this.j6.DW();
    }

    public boolean j6(long j) {
        return this.DW == 0 || this.j6.DW() - this.DW >= j;
    }
}
