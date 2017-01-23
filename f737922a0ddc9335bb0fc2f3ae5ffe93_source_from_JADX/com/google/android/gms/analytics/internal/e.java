package com.google.android.gms.analytics.internal;

import afq;

public class e {
    private final int DW;
    private double FH;
    private long Hw;
    private final afq VH;
    private final String Zo;
    private final long j6;
    private final Object v5;

    public e(int i, long j, String str, afq afq) {
        this.v5 = new Object();
        this.DW = i;
        this.FH = (double) this.DW;
        this.j6 = j;
        this.Zo = str;
        this.VH = afq;
    }

    public e(String str, afq afq) {
        this(60, 2000, str, afq);
    }

    public boolean j6() {
        boolean z;
        synchronized (this.v5) {
            long j6 = this.VH.j6();
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
                String str = this.Zo;
                f.FH(new StringBuilder(String.valueOf(str).length() + 34).append("Excessive ").append(str).append(" detected; call ignored.").toString());
                z = false;
            }
        }
        return z;
    }
}
