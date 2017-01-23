package com.google.android.gms.ads.internal.overlay;

import com.google.android.gms.internal.eh;
import com.google.android.gms.internal.et;

@eh
class q implements Runnable {
    private boolean DW;
    private i j6;

    q(i iVar) {
        this.DW = false;
        this.j6 = iVar;
    }

    public void DW() {
        et.j6.postDelayed(this, 250);
    }

    public void j6() {
        this.DW = true;
        et.j6.removeCallbacks(this);
    }

    public void run() {
        if (!this.DW) {
            this.j6.gn();
            DW();
        }
    }
}
