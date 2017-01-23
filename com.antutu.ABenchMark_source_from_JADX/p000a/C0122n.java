package p000a;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p000a.C0137w.C0136a;
import p000a.p001a.C0037c;

/* renamed from: a.n */
public final class C0122n {
    private int f512a;
    private int f513b;
    private Runnable f514c;
    private ExecutorService f515d;
    private final Deque<C0136a> f516e;
    private final Deque<C0136a> f517f;
    private final Deque<C0137w> f518g;

    public C0122n() {
        this.f512a = 64;
        this.f513b = 5;
        this.f516e = new ArrayDeque();
        this.f517f = new ArrayDeque();
        this.f518g = new ArrayDeque();
    }

    private <T> void m527a(Deque<T> deque, T t, boolean z) {
        synchronized (this) {
            if (deque.remove(t)) {
                if (z) {
                    m529c();
                }
                int b = m533b();
                Runnable runnable = this.f514c;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (b == 0 && runnable != null) {
            runnable.run();
        }
    }

    private int m528b(C0136a c0136a) {
        int i = 0;
        for (C0136a a : this.f517f) {
            i = a.m644a().equals(c0136a.m644a()) ? i + 1 : i;
        }
        return i;
    }

    private void m529c() {
        if (this.f517f.size() < this.f512a && !this.f516e.isEmpty()) {
            Iterator it = this.f516e.iterator();
            while (it.hasNext()) {
                C0136a c0136a = (C0136a) it.next();
                if (m528b(c0136a) < this.f513b) {
                    it.remove();
                    this.f517f.add(c0136a);
                    m530a().execute(c0136a);
                }
                if (this.f517f.size() >= this.f512a) {
                    return;
                }
            }
        }
    }

    public synchronized ExecutorService m530a() {
        if (this.f515d == null) {
            this.f515d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), C0037c.m158a("OkHttp Dispatcher", false));
        }
        return this.f515d;
    }

    void m531a(C0136a c0136a) {
        m527a(this.f517f, c0136a, true);
    }

    synchronized void m532a(C0137w c0137w) {
        this.f518g.add(c0137w);
    }

    public synchronized int m533b() {
        return this.f517f.size() + this.f518g.size();
    }

    void m534b(C0137w c0137w) {
        m527a(this.f518g, c0137w, false);
    }
}
