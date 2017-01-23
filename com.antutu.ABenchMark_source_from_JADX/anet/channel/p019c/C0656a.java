package anet.channel.p019c;

import com.qq.p035e.comm.constants.ErrorCode.AdError;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* renamed from: anet.channel.c.a */
class C0656a implements Comparable<C0656a>, Runnable, Future {
    Runnable f2191a;
    int f2192b;
    long f2193c;
    volatile boolean f2194d;
    volatile Future<?> f2195e;

    public C0656a(Runnable runnable, int i) {
        this.f2191a = null;
        this.f2192b = 0;
        this.f2193c = System.currentTimeMillis();
        this.f2194d = false;
        this.f2195e = null;
        this.f2191a = runnable;
        this.f2192b = i;
        this.f2193c = System.currentTimeMillis();
    }

    public int m2781a(C0656a c0656a) {
        return this.f2192b != c0656a.f2192b ? this.f2192b - c0656a.f2192b : (int) (c0656a.f2193c - this.f2193c);
    }

    public boolean cancel(boolean z) {
        this.f2194d = true;
        return this.f2195e != null ? this.f2195e.cancel(z) : true;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m2781a((C0656a) obj);
    }

    public Object get() {
        throw new RuntimeException("NOT SUPPORT!");
    }

    public Object get(long j, TimeUnit timeUnit) {
        throw new RuntimeException("NOT SUPPORT!");
    }

    public boolean isCancelled() {
        return this.f2194d;
    }

    public boolean isDone() {
        return false;
    }

    public void run() {
        try {
            if (!this.f2194d) {
                this.f2195e = C0660c.m2788c().submit(this.f2191a);
            }
        } catch (RejectedExecutionException e) {
            this.f2192b++;
            C0660c.m2786a(this, (long) ((this.f2192b + 1) * AdError.PLACEMENT_ERROR), TimeUnit.MILLISECONDS);
        }
    }
}
