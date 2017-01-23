package com.baidu.mobads.production.p101c;

import android.view.ViewGroup;

/* renamed from: com.baidu.mobads.production.c.d */
class C2040d implements Runnable {
    final /* synthetic */ C2038b f7136a;

    C2040d(C2038b c2038b) {
        this.f7136a = c2038b;
    }

    public void run() {
        this.f7136a.f7132x.m7392d("remote Interstitial.removeAd");
        try {
            if (this.f7136a.e.getParent() != null) {
                ((ViewGroup) this.f7136a.e.getParent()).removeView(this.f7136a.e);
            }
            this.f7136a.e.removeAllViews();
        } catch (Throwable e) {
            this.f7136a.f7132x.m7394d("Interstitial.removeAd", e);
        }
    }
}
