package com.facebook.ads.internal.p127e.p129b.p130a;

import java.io.File;

/* renamed from: com.facebook.ads.internal.e.b.a.g */
public class C2385g extends C2383e {
    private final long f8277a;

    public C2385g(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("Max size must be positive number!");
        }
        this.f8277a = j;
    }

    public /* bridge */ /* synthetic */ void m9176a(File file) {
        super.m9172a(file);
    }

    protected boolean m9177a(File file, long j, int i) {
        return j <= this.f8277a;
    }
}
