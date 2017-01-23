package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.C2301a;
import com.google.android.gms.ads.internal.client.C2772z.C2773a;
import com.google.android.gms.p146b.gb;

@gb
/* renamed from: com.google.android.gms.ads.internal.client.l */
public final class C2774l extends C2773a {
    private final C2301a f9431a;

    public C2774l(C2301a c2301a) {
        this.f9431a = c2301a;
    }

    public void m10707a() {
        this.f9431a.onAdClosed();
    }

    public void m10708a(int i) {
        this.f9431a.onAdFailedToLoad(i);
    }

    public void m10709b() {
        this.f9431a.onAdLeftApplication();
    }

    public void m10710c() {
        this.f9431a.onAdLoaded();
    }

    public void m10711d() {
        this.f9431a.onAdOpened();
    }
}
