package com.facebook.ads.internal.util;

import java.lang.ref.WeakReference;

/* renamed from: com.facebook.ads.internal.util.u */
public abstract class C2290u<T> implements Runnable {
    private final WeakReference<T> f7926a;

    public C2290u(T t) {
        this.f7926a = new WeakReference(t);
    }

    public T m8655a() {
        return this.f7926a.get();
    }
}
