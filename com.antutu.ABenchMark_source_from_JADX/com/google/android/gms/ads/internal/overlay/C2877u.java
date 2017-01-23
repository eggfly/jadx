package com.google.android.gms.ads.internal.overlay;

import com.google.android.gms.p146b.gb;
import com.google.android.gms.p146b.hj;

@gb
/* renamed from: com.google.android.gms.ads.internal.overlay.u */
class C2877u implements Runnable {
    private C2869k f9744a;
    private boolean f9745b;

    C2877u(C2869k c2869k) {
        this.f9745b = false;
        this.f9744a = c2869k;
    }

    public void m11188a() {
        this.f9745b = true;
        hj.f11297a.removeCallbacks(this);
    }

    public void m11189b() {
        hj.f11297a.postDelayed(this, 250);
    }

    public void run() {
        if (!this.f9745b) {
            this.f9744a.m11162n();
            m11189b();
        }
    }
}
