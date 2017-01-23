package com.igexin.p158b.p159a.p165d;

import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.igexin.b.a.d.f */
final class C3696f {
    final BlockingQueue f12456a;
    final HashMap f12457b;
    final ReentrantLock f12458c;
    ThreadFactory f12459d;
    volatile long f12460e;
    volatile int f12461f;
    volatile int f12462g;
    volatile int f12463h;
    final /* synthetic */ C3684e f12464i;

    public C3696f(C3684e c3684e) {
        this.f12464i = c3684e;
        this.f12458c = new ReentrantLock();
        this.f12456a = new SynchronousQueue();
        this.f12457b = new HashMap();
        this.f12460e = TimeUnit.SECONDS.toNanos(60);
        this.f12461f = 0;
        this.f12459d = new C3698h(this);
        this.f12463h = Integer.MAX_VALUE;
    }

    final C3666d m15119a() {
        while (true) {
            try {
                C3666d c3666d = this.f12462g > this.f12461f ? (C3666d) this.f12456a.poll(this.f12460e, TimeUnit.NANOSECONDS) : (C3666d) this.f12456a.take();
                if (c3666d != null) {
                    return c3666d;
                }
                if (this.f12456a.isEmpty()) {
                    return null;
                }
            } catch (InterruptedException e) {
            }
        }
    }

    final void m15120a(C3666d c3666d) {
        if (c3666d == null) {
            throw new NullPointerException();
        }
        if (c3666d.f12353z != 0) {
            ReentrantLock reentrantLock = this.f12458c;
            reentrantLock.lock();
            try {
                C3697g c3697g = (C3697g) this.f12457b.get(Integer.valueOf(c3666d.f12353z));
                if (c3697g != null) {
                    c3697g.f12465a.offer(c3666d);
                    return;
                }
                reentrantLock.unlock();
            } finally {
                reentrantLock.unlock();
            }
        }
        m15122b(c3666d);
    }

    final boolean m15121a(C3697g c3697g) {
        ReentrantLock reentrantLock = this.f12458c;
        reentrantLock.lock();
        try {
            int i = this.f12462g - 1;
            this.f12462g = i;
            if (i == 0 && !this.f12456a.isEmpty()) {
                Thread f = m15126f(null);
                if (f != null) {
                    f.start();
                }
            } else if (!c3697g.f12465a.isEmpty()) {
                reentrantLock.unlock();
                return true;
            }
            this.f12457b.remove(Integer.valueOf(c3697g.f12468d));
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    final void m15122b(C3666d c3666d) {
        if (this.f12462g < this.f12461f && m15123c(c3666d)) {
            return;
        }
        if (this.f12456a.offer(c3666d)) {
            if (this.f12462g == 0) {
                m15125e(c3666d);
            }
        } else if (!m15124d(c3666d)) {
        }
    }

    final boolean m15123c(C3666d c3666d) {
        Thread thread = null;
        ReentrantLock reentrantLock = this.f12458c;
        reentrantLock.lock();
        try {
            if (this.f12462g < this.f12461f) {
                thread = m15126f(c3666d);
            }
            reentrantLock.unlock();
            if (thread == null) {
                return false;
            }
            thread.start();
            return true;
        } catch (Throwable th) {
            reentrantLock.unlock();
        }
    }

    final boolean m15124d(C3666d c3666d) {
        Thread thread = null;
        ReentrantLock reentrantLock = this.f12458c;
        reentrantLock.lock();
        try {
            if (this.f12462g < this.f12463h) {
                thread = m15126f(c3666d);
            }
            reentrantLock.unlock();
            if (thread == null) {
                return false;
            }
            thread.start();
            return true;
        } catch (Throwable th) {
            reentrantLock.unlock();
        }
    }

    final void m15125e(C3666d c3666d) {
        Thread thread = null;
        ReentrantLock reentrantLock = this.f12458c;
        reentrantLock.lock();
        try {
            if (this.f12462g < Math.max(this.f12461f, 1) && !this.f12456a.isEmpty()) {
                thread = m15126f(null);
            }
            reentrantLock.unlock();
            if (thread != null) {
                thread.start();
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
        }
    }

    final Thread m15126f(C3666d c3666d) {
        Runnable c3697g = new C3697g(this, c3666d);
        if (!(c3666d == null || c3666d.f12353z == 0)) {
            this.f12457b.put(Integer.valueOf(c3666d.f12353z), c3697g);
        }
        Thread newThread = this.f12459d.newThread(c3697g);
        if (newThread != null) {
            this.f12462g++;
        }
        return newThread;
    }
}
