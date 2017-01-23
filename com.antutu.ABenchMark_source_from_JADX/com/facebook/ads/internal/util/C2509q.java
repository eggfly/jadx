package com.facebook.ads.internal.util;

import android.graphics.Bitmap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.facebook.ads.internal.util.q */
public class C2509q {
    static final int f8622a;
    static final ExecutorService f8623b;
    private static volatile boolean f8624c;
    private final Bitmap f8625d;
    private Bitmap f8626e;
    private final C2501j f8627f;

    static {
        f8622a = Runtime.getRuntime().availableProcessors();
        f8623b = Executors.newFixedThreadPool(f8622a);
        f8624c = true;
    }

    public C2509q(Bitmap bitmap) {
        this.f8625d = bitmap;
        this.f8627f = new C2504m();
    }

    public Bitmap m9514a() {
        return this.f8626e;
    }

    public Bitmap m9515a(int i) {
        this.f8626e = this.f8627f.m9499a(this.f8625d, (float) i);
        return this.f8626e;
    }
}
