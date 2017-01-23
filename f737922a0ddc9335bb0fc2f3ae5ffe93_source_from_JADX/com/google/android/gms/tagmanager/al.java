package com.google.android.gms.tagmanager;

import afq;
import afs;

class al implements ae {
    private final int DW;
    private double FH;
    private long Hw;
    private final afq Zo;
    private final long j6;
    private final Object v5;

    public al() {
        this(60, 2000);
    }

    public al(int i, long j) {
        this.v5 = new Object();
        this.DW = i;
        this.FH = (double) this.DW;
        this.j6 = j;
        this.Zo = afs.Hw();
    }

    public boolean j6() {
        boolean z;
        synchronized (this.v5) {
            long j6 = this.Zo.j6();
            if (this.FH < ((double) this.DW)) {
                double d = ((double) (j6 - this.Hw)) / ((double) this.j6);
                if (d > 0.0d) {
                    this.FH = Math.min((double) this.DW, d + this.FH);
                }
            }
            this.Hw = j6;
            if (this.FH >= 1.0d) {
                this.FH -= 1.0d;
                z = true;
            } else {
                r.DW("No more tokens available.");
                z = false;
            }
        }
        return z;
    }
}
