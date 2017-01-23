package com.baidu.mobads.production.p101c;

import android.graphics.Color;

/* renamed from: com.baidu.mobads.production.c.c */
class C2039c implements Runnable {
    final /* synthetic */ C2038b f7135a;

    C2039c(C2038b c2038b) {
        this.f7135a = c2038b;
    }

    public void run() {
        if (this.f7135a.m7685n()) {
            this.f7135a.e.setBackgroundColor(Color.argb(51, 0, 0, 0));
        }
        if (this.f7135a.h.getAdView() != null) {
            this.f7135a.h.getAdView().setVisibility(0);
        }
        if (this.f7135a.m7669r()) {
            this.f7135a.f7132x.m7392d("add countdown view");
            this.f7135a.m7671t();
            this.f7135a.e.addView(this.f7135a.m7670s(), this.f7135a.m7672u());
        }
    }
}
