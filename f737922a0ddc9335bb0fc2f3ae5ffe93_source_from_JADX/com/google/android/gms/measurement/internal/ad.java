package com.google.android.gms.measurement.internal;

import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.internal.hr.d;

class ad {
    final int DW;
    long FH;
    double Hw;
    long VH;
    double Zo;
    double gn;
    final boolean j6;
    final boolean u7;
    long v5;

    public ad(d dVar) {
        boolean z;
        boolean z2 = true;
        b.j6((Object) dVar);
        if (dVar.j6 == null || dVar.j6.intValue() == 0) {
            z = false;
        } else {
            if (dVar.j6.intValue() != 4) {
                if (dVar.FH == null) {
                    z = false;
                }
            } else if (dVar.Hw == null || dVar.v5 == null) {
                z = false;
            }
            z = true;
        }
        if (z) {
            this.DW = dVar.j6.intValue();
            if (dVar.DW == null || !dVar.DW.booleanValue()) {
                z2 = false;
            }
            this.j6 = z2;
            if (dVar.j6.intValue() == 4) {
                if (this.j6) {
                    this.Zo = Double.parseDouble(dVar.Hw);
                    this.gn = Double.parseDouble(dVar.v5);
                } else {
                    this.v5 = Long.parseLong(dVar.Hw);
                    this.VH = Long.parseLong(dVar.v5);
                }
            } else if (this.j6) {
                this.Hw = Double.parseDouble(dVar.FH);
            } else {
                this.FH = Long.parseLong(dVar.FH);
            }
        } else {
            this.DW = 0;
            this.j6 = false;
        }
        this.u7 = z;
    }

    public Boolean j6(double d) {
        boolean z = true;
        boolean z2 = false;
        if (!this.u7) {
            return null;
        }
        if (!this.j6) {
            return null;
        }
        switch (this.DW) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                if (d >= this.Hw) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                if (d <= this.Hw) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                if (d == this.Hw || Math.abs(d - this.Hw) < 2.0d * Math.max(Math.ulp(d), Math.ulp(this.Hw))) {
                    z2 = true;
                }
                return Boolean.valueOf(z2);
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                if (d < this.Zo || d > this.gn) {
                    z = false;
                }
                return Boolean.valueOf(z);
            default:
                return null;
        }
    }

    public Boolean j6(long j) {
        boolean z = true;
        if (!this.u7) {
            return null;
        }
        if (this.j6) {
            return null;
        }
        switch (this.DW) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                if (j >= this.FH) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                if (j <= this.FH) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                if (j != this.FH) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                if (j < this.v5 || j > this.VH) {
                    z = false;
                }
                return Boolean.valueOf(z);
            default:
                return null;
        }
    }
}
