package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.client.ah.C2751a;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.p146b.gb;

@gb
/* renamed from: com.google.android.gms.ads.internal.o */
public class C2844o extends C2751a {
    private static final Object f9631a;
    private static C2844o f9632b;
    private final Object f9633c;
    private boolean f9634d;
    private float f9635e;

    static {
        f9631a = new Object();
    }

    public static C2844o m11030b() {
        C2844o c2844o;
        synchronized (f9631a) {
            c2844o = f9632b;
        }
        return c2844o;
    }

    public void m11031a() {
        synchronized (f9631a) {
            if (this.f9634d) {
                C2972b.m11583d("Mobile ads is initialized already.");
                return;
            }
            this.f9634d = true;
        }
    }

    public void m11032a(float f) {
        synchronized (this.f9633c) {
            this.f9635e = f;
        }
    }

    public float m11033c() {
        float f;
        synchronized (this.f9633c) {
            f = this.f9635e;
        }
        return f;
    }

    public boolean m11034d() {
        boolean z;
        synchronized (this.f9633c) {
            z = this.f9635e >= 0.0f;
        }
        return z;
    }
}
