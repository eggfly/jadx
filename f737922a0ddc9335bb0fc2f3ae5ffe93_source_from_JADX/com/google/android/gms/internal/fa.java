package com.google.android.gms.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@eh
public class fa<T> implements fb<T> {
    private T DW;
    private boolean FH;
    private boolean Hw;
    private final Object j6;
    private final fc v5;

    public fa() {
        this.j6 = new Object();
        this.DW = null;
        this.FH = false;
        this.Hw = false;
        this.v5 = new fc();
    }

    public void DW(T t) {
        synchronized (this.j6) {
            if (this.Hw) {
            } else if (this.FH) {
                throw new IllegalStateException("Provided CallbackFuture with multiple values.");
            } else {
                this.FH = true;
                this.DW = t;
                this.j6.notifyAll();
                this.v5.j6();
            }
        }
    }

    public boolean cancel(boolean z) {
        if (!z) {
            return false;
        }
        synchronized (this.j6) {
            if (this.FH) {
                return false;
            }
            this.Hw = true;
            this.FH = true;
            this.j6.notifyAll();
            this.v5.j6();
            return true;
        }
    }

    public T get() {
        T t;
        synchronized (this.j6) {
            if (!this.FH) {
                try {
                    this.j6.wait();
                } catch (InterruptedException e) {
                }
            }
            if (this.Hw) {
                throw new CancellationException("CallbackFuture was cancelled.");
            }
            t = this.DW;
        }
        return t;
    }

    public T get(long j, TimeUnit timeUnit) {
        T t;
        synchronized (this.j6) {
            if (!this.FH) {
                try {
                    long toMillis = timeUnit.toMillis(j);
                    if (toMillis != 0) {
                        this.j6.wait(toMillis);
                    }
                } catch (InterruptedException e) {
                }
            }
            if (!this.FH) {
                throw new TimeoutException("CallbackFuture timed out.");
            } else if (this.Hw) {
                throw new CancellationException("CallbackFuture was cancelled.");
            } else {
                t = this.DW;
            }
        }
        return t;
    }

    public boolean isCancelled() {
        boolean z;
        synchronized (this.j6) {
            z = this.Hw;
        }
        return z;
    }

    public boolean isDone() {
        boolean z;
        synchronized (this.j6) {
            z = this.FH;
        }
        return z;
    }

    public void j6(Runnable runnable) {
        this.v5.j6(runnable);
    }
}
