package com.google.android.gms.p146b;

import java.util.concurrent.TimeUnit;

@gb
/* renamed from: com.google.android.gms.b.hx */
public class hx<T> implements hz<T> {
    private final T f11359a;
    private final ia f11360b;

    public hx(T t) {
        this.f11359a = t;
        this.f11360b = new ia();
        this.f11360b.m13198a();
    }

    public void m13168a(Runnable runnable) {
        this.f11360b.m13199a(runnable);
    }

    public boolean cancel(boolean z) {
        return false;
    }

    public T get() {
        return this.f11359a;
    }

    public T get(long j, TimeUnit timeUnit) {
        return this.f11359a;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }
}
