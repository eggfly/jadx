package com.google.android.gms.ads.mediation;

import android.os.Bundle;

/* renamed from: com.google.android.gms.ads.mediation.b */
public interface C2633b {

    /* renamed from: com.google.android.gms.ads.mediation.b.a */
    public static class C2975a {
        private int f10092a;

        public Bundle m11595a() {
            Bundle bundle = new Bundle();
            bundle.putInt("capabilities", this.f10092a);
            return bundle;
        }

        public C2975a m11596a(int i) {
            this.f10092a = i;
            return this;
        }
    }

    void m10137a();

    void m10138b();

    void m10139c();
}
