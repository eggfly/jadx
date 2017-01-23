package com.cmcm.p074a.p075a.p112a;

/* renamed from: com.cmcm.a.a.a.d */
class C2110d implements Runnable {
    final /* synthetic */ C2109c f7423a;

    C2110d(C2109c c2109c) {
        this.f7423a = c2109c;
    }

    public void run() {
        this.f7423a.f7420d.run();
        C2109c.m7944b(this.f7423a);
        if (this.f7423a.f7420d == null) {
            return;
        }
        if (this.f7423a.f7419c < this.f7423a.f7418b) {
            this.f7423a.f7417a.postDelayed(this.f7423a.f7422f, this.f7423a.f7421e);
        } else {
            this.f7423a.f7420d = null;
        }
    }
}
