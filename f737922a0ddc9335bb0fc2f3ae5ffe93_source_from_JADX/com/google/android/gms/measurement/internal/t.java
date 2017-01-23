package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.b;

class t {
    final String DW;
    final long FH;
    final long Hw;
    final String j6;
    final long v5;

    t(String str, String str2, long j, long j2, long j3) {
        boolean z = true;
        b.j6(str);
        b.j6(str2);
        b.DW(j >= 0);
        if (j2 < 0) {
            z = false;
        }
        b.DW(z);
        this.j6 = str;
        this.DW = str2;
        this.FH = j;
        this.Hw = j2;
        this.v5 = j3;
    }

    t j6() {
        return new t(this.j6, this.DW, this.FH + 1, this.Hw + 1, this.v5);
    }

    t j6(long j) {
        return new t(this.j6, this.DW, this.FH, this.Hw, j);
    }
}
