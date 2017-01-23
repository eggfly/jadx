package com.igexin.p158b.p159a.p165d;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.igexin.b.a.d.g */
final class C3697g implements Runnable {
    final BlockingQueue f12465a;
    C3666d f12466b;
    C3666d f12467c;
    volatile int f12468d;
    final /* synthetic */ C3696f f12469e;

    public C3697g(C3696f c3696f, C3666d c3666d) {
        this.f12469e = c3696f;
        this.f12466b = c3666d;
        this.f12465a = new LinkedBlockingQueue();
    }

    public final void m15127a() {
        this.f12465a.clear();
        this.f12467c = null;
    }

    public final void m15128a(C3666d c3666d) {
        if (this.f12468d == 0) {
            this.f12468d = c3666d.f12353z;
        }
        Object obj = 1;
        while (obj != null) {
            try {
                c3666d.a_();
                c3666d.m14969s();
                c3666d.m14971u();
                if (!c3666d.f12347t) {
                    c3666d.m14960c();
                }
                if (!c3666d.f12339k && c3666d.f12342o) {
                }
            } catch (Exception e) {
                c3666d.f12347t = true;
                c3666d.f12329B = e;
                c3666d.m14972v();
                c3666d.m14966p();
                this.f12469e.f12464i.m15055a((Object) c3666d);
                this.f12469e.f12464i.m15058f();
                if (!c3666d.f12347t) {
                    c3666d.m14960c();
                }
                if (!c3666d.f12339k && c3666d.f12342o) {
                }
            } catch (Throwable th) {
                if (!c3666d.f12347t) {
                    c3666d.m14960c();
                }
                if (c3666d.f12339k || !c3666d.f12342o) {
                }
            }
            obj = null;
            c3666d = null;
        }
    }

    final C3666d m15129b() {
        while (this.f12468d != 0) {
            ReentrantLock reentrantLock;
            try {
                C3666d c3666d = (C3666d) this.f12465a.poll(this.f12469e.f12460e, TimeUnit.NANOSECONDS);
                if (c3666d != null) {
                    return c3666d;
                }
                if (this.f12465a.isEmpty()) {
                    reentrantLock = this.f12469e.f12458c;
                    reentrantLock.lock();
                    if (this.f12465a.isEmpty()) {
                        this.f12469e.f12457b.remove(Integer.valueOf(this.f12468d));
                        this.f12467c.m14962e();
                        this.f12468d = 0;
                        reentrantLock.unlock();
                        return null;
                    }
                    reentrantLock.unlock();
                } else {
                    continue;
                }
            } catch (InterruptedException e) {
            } catch (Throwable th) {
                reentrantLock.unlock();
            }
        }
        return null;
    }

    public final void run() {
        boolean z = true;
        while (z) {
            try {
                C3666d c3666d = this.f12466b;
                this.f12466b = null;
                while (true) {
                    if (c3666d == null) {
                        c3666d = m15129b();
                        if (c3666d == null) {
                            c3666d = this.f12469e.m15119a();
                            if (c3666d == null) {
                                break;
                            }
                        }
                    }
                    this.f12467c = null;
                    m15128a(c3666d);
                    this.f12467c = c3666d;
                    c3666d = null;
                }
                z = this.f12469e.m15121a(this);
                if (!z) {
                    m15127a();
                }
            } catch (Exception e) {
                z = this.f12469e.m15121a(this);
                if (!z) {
                    m15127a();
                }
            } catch (Throwable th) {
                if (!this.f12469e.m15121a(this)) {
                    m15127a();
                }
            }
        }
    }
}
