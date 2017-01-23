package com.google.android.gms.p146b;

import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@gb
/* renamed from: com.google.android.gms.b.hw */
public class hw<T> implements hz<T> {
    private final Object f10563a;
    private T f10564b;
    private boolean f10565c;
    private boolean f10566d;
    private final ia f10567e;

    public hw() {
        this.f10563a = new Object();
        this.f10564b = null;
        this.f10565c = false;
        this.f10566d = false;
        this.f10567e = new ia();
    }

    public void m12216a(Runnable runnable) {
        this.f10567e.m13199a(runnable);
    }

    public void m12217b(T t) {
        synchronized (this.f10563a) {
            if (this.f10566d) {
            } else if (this.f10565c) {
                throw new IllegalStateException("Provided CallbackFuture with multiple values.");
            } else {
                this.f10565c = true;
                this.f10564b = t;
                this.f10563a.notifyAll();
                this.f10567e.m13198a();
            }
        }
    }

    public void m12218b(Runnable runnable) {
        this.f10567e.m13200b(runnable);
    }

    public boolean cancel(boolean z) {
        if (!z) {
            return false;
        }
        synchronized (this.f10563a) {
            if (this.f10565c) {
                return false;
            }
            this.f10566d = true;
            this.f10565c = true;
            this.f10563a.notifyAll();
            this.f10567e.m13198a();
            return true;
        }
    }

    public T get() {
        T t;
        synchronized (this.f10563a) {
            if (!this.f10565c) {
                try {
                    this.f10563a.wait();
                } catch (InterruptedException e) {
                }
            }
            if (this.f10566d) {
                throw new CancellationException("CallbackFuture was cancelled.");
            }
            t = this.f10564b;
        }
        return t;
    }

    public T get(long j, TimeUnit timeUnit) {
        T t;
        synchronized (this.f10563a) {
            if (!this.f10565c) {
                try {
                    long toMillis = timeUnit.toMillis(j);
                    if (toMillis != 0) {
                        this.f10563a.wait(toMillis);
                    }
                } catch (InterruptedException e) {
                }
            }
            if (!this.f10565c) {
                throw new TimeoutException("CallbackFuture timed out.");
            } else if (this.f10566d) {
                throw new CancellationException("CallbackFuture was cancelled.");
            } else {
                t = this.f10564b;
            }
        }
        return t;
    }

    public boolean isCancelled() {
        boolean z;
        synchronized (this.f10563a) {
            z = this.f10566d;
        }
        return z;
    }

    public boolean isDone() {
        boolean z;
        synchronized (this.f10563a) {
            z = this.f10565c;
        }
        return z;
    }
}
