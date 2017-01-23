package com.facebook.ads.internal.server;

import com.facebook.ads.internal.p125c.C2347c;

/* renamed from: com.facebook.ads.internal.server.c */
public class C2482c {
    private C2347c f8543a;
    private C2481a f8544b;

    /* renamed from: com.facebook.ads.internal.server.c.a */
    public enum C2481a {
        UNKNOWN,
        ERROR,
        ADS
    }

    public C2482c(C2481a c2481a, C2347c c2347c) {
        this.f8544b = c2481a;
        this.f8543a = c2347c;
    }

    public C2481a m9445a() {
        return this.f8544b;
    }

    public C2347c m9446b() {
        return this.f8543a;
    }
}
