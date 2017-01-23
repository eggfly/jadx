package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.a;
import com.google.android.gms.internal.eh;

@eh
public class y extends a {
    private a DW;
    private final Object j6;

    public y() {
        this.j6 = new Object();
    }

    public void DW() {
        synchronized (this.j6) {
            if (this.DW != null) {
                this.DW.DW();
            }
        }
    }

    public void FH() {
        synchronized (this.j6) {
            if (this.DW != null) {
                this.DW.FH();
            }
        }
    }

    public void Hw() {
        synchronized (this.j6) {
            if (this.DW != null) {
                this.DW.Hw();
            }
        }
    }

    public void j6() {
        synchronized (this.j6) {
            if (this.DW != null) {
                this.DW.j6();
            }
        }
    }

    public void j6(int i) {
        synchronized (this.j6) {
            if (this.DW != null) {
                this.DW.j6(i);
            }
        }
    }

    public void j6(a aVar) {
        synchronized (this.j6) {
            this.DW = aVar;
        }
    }
}
