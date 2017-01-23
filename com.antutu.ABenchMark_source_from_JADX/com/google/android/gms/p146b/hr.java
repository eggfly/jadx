package com.google.android.gms.p146b;

import com.google.android.gms.ads.internal.C2968s;

@gb
/* renamed from: com.google.android.gms.b.hr */
public class hr {
    private long f11349a;
    private long f11350b;
    private Object f11351c;

    public hr(long j) {
        this.f11350b = Long.MIN_VALUE;
        this.f11351c = new Object();
        this.f11349a = j;
    }

    public boolean m13157a() {
        boolean z;
        synchronized (this.f11351c) {
            long b = C2968s.m11529i().m13544b();
            if (this.f11350b + this.f11349a > b) {
                z = false;
            } else {
                this.f11350b = b;
                z = true;
            }
        }
        return z;
    }
}
