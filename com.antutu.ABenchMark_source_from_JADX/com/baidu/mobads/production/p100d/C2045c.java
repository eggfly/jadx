package com.baidu.mobads.production.p100d;

import android.view.ViewGroup;

/* renamed from: com.baidu.mobads.production.d.c */
class C2045c implements Runnable {
    final /* synthetic */ C2044b f7149a;

    C2045c(C2044b c2044b) {
        this.f7149a = c2044b;
    }

    public void run() {
        this.f7149a.f7146x.m7392d("remote Interstitial.removeAd");
        this.f7149a.f7141B = false;
        try {
            this.f7149a.e.removeAllViews();
            ViewGroup a = this.f7149a.m7697d(this.f7149a.e.getContext());
            this.f7149a.f7143D.removeAllViews();
            a.removeView(this.f7149a.f7143D);
        } catch (Throwable e) {
            this.f7149a.f7146x.m7394d("Interstitial.removeAd", e);
        }
    }
}
