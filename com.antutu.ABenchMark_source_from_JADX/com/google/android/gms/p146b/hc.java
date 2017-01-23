package com.google.android.gms.p146b;

import android.os.Bundle;
import com.google.android.gms.ads.internal.C2968s;

@gb
/* renamed from: com.google.android.gms.b.hc */
public class hc {
    private final Object f11260a;
    private int f11261b;
    private int f11262c;
    private final gz f11263d;
    private final String f11264e;

    hc(gz gzVar, String str) {
        this.f11260a = new Object();
        this.f11263d = gzVar;
        this.f11264e = str;
    }

    public hc(String str) {
        this(C2968s.m11528h(), str);
    }

    public Bundle m12975a() {
        Bundle bundle;
        synchronized (this.f11260a) {
            bundle = new Bundle();
            bundle.putInt("pmnli", this.f11261b);
            bundle.putInt("pmnll", this.f11262c);
        }
        return bundle;
    }

    public void m12976a(int i, int i2) {
        synchronized (this.f11260a) {
            this.f11261b = i;
            this.f11262c = i2;
            this.f11263d.m12939a(this.f11264e, this);
        }
    }
}
