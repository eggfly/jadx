package p000a;

import java.lang.ref.Reference;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p000a.p001a.C0037c;
import p000a.p001a.p003b.C0015c;
import p000a.p001a.p003b.C0016d;
import p000a.p001a.p003b.C0020g;
import p000a.p001a.p003b.C0020g.C0019a;
import p000a.p001a.p009g.C0090e;

/* renamed from: a.j */
public final class C0116j {
    static final /* synthetic */ boolean f478c;
    private static final Executor f479d;
    final C0016d f480a;
    boolean f481b;
    private final int f482e;
    private final long f483f;
    private final Runnable f484g;
    private final Deque<C0015c> f485h;

    /* renamed from: a.j.1 */
    class C01151 implements Runnable {
        final /* synthetic */ C0116j f477a;

        C01151(C0116j c0116j) {
            this.f477a = c0116j;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r8 = this;
            r6 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
        L_0x0003:
            r0 = r8.f477a;
            r2 = java.lang.System.nanoTime();
            r0 = r0.m494a(r2);
            r2 = -1;
            r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
            if (r2 != 0) goto L_0x0014;
        L_0x0013:
            return;
        L_0x0014:
            r2 = 0;
            r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
            if (r2 <= 0) goto L_0x0003;
        L_0x001a:
            r2 = r0 / r6;
            r4 = r2 * r6;
            r0 = r0 - r4;
            r4 = r8.f477a;
            monitor-enter(r4);
            r5 = r8.f477a;	 Catch:{ InterruptedException -> 0x002d }
            r0 = (int) r0;	 Catch:{ InterruptedException -> 0x002d }
            r5.wait(r2, r0);	 Catch:{ InterruptedException -> 0x002d }
        L_0x0028:
            monitor-exit(r4);	 Catch:{ all -> 0x002a }
            goto L_0x0003;
        L_0x002a:
            r0 = move-exception;
            monitor-exit(r4);	 Catch:{ all -> 0x002a }
            throw r0;
        L_0x002d:
            r0 = move-exception;
            goto L_0x0028;
            */
            throw new UnsupportedOperationException("Method not decompiled: a.j.1.run():void");
        }
    }

    static {
        f478c = !C0116j.class.desiredAssertionStatus();
        f479d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), C0037c.m158a("OkHttp ConnectionPool", true));
    }

    public C0116j() {
        this(5, 5, TimeUnit.MINUTES);
    }

    public C0116j(int i, long j, TimeUnit timeUnit) {
        this.f484g = new C01151(this);
        this.f485h = new ArrayDeque();
        this.f480a = new C0016d();
        this.f482e = i;
        this.f483f = timeUnit.toNanos(j);
        if (j <= 0) {
            throw new IllegalArgumentException("keepAliveDuration <= 0: " + j);
        }
    }

    private int m493a(C0015c c0015c, long j) {
        List list = c0015c.f59g;
        int i = 0;
        while (i < list.size()) {
            Reference reference = (Reference) list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                C0019a c0019a = (C0019a) reference;
                C0090e.m389b().m395a("A connection to " + c0015c.m52a().m458a().m444a() + " was leaked. Did you forget to close a response body?", c0019a.f78a);
                list.remove(i);
                c0015c.f60h = true;
                if (list.isEmpty()) {
                    c0015c.f61i = j - this.f483f;
                    return 0;
                }
            }
        }
        return list.size();
    }

    long m494a(long j) {
        C0015c c0015c = null;
        long j2 = Long.MIN_VALUE;
        synchronized (this) {
            int i = 0;
            int i2 = 0;
            for (C0015c c0015c2 : this.f485h) {
                long j3;
                if (m493a(c0015c2, j) > 0) {
                    i2++;
                } else {
                    C0015c c0015c3;
                    int i3 = i + 1;
                    long j4 = j - c0015c2.f61i;
                    if (j4 > j2) {
                        long j5 = j4;
                        c0015c3 = c0015c2;
                        j3 = j5;
                    } else {
                        c0015c3 = c0015c;
                        j3 = j2;
                    }
                    j2 = j3;
                    c0015c = c0015c3;
                    i = i3;
                }
            }
            if (j2 >= this.f483f || i > this.f482e) {
                this.f485h.remove(c0015c);
                C0037c.m161a(c0015c.m57b());
                return 0;
            }
            if (i > 0) {
                j3 = this.f483f - j2;
                return j3;
            } else if (i2 > 0) {
                j3 = this.f483f;
                return j3;
            } else {
                this.f481b = false;
                return -1;
            }
        }
    }

    C0015c m495a(C0102a c0102a, C0020g c0020g) {
        if (f478c || Thread.holdsLock(this)) {
            for (C0015c c0015c : this.f485h) {
                if (c0015c.f59g.size() < c0015c.f58f && c0102a.equals(c0015c.m52a().f383a) && !c0015c.f60h) {
                    c0020g.m85a(c0015c);
                    return c0015c;
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    void m496a(C0015c c0015c) {
        if (f478c || Thread.holdsLock(this)) {
            if (!this.f481b) {
                this.f481b = true;
                f479d.execute(this.f484g);
            }
            this.f485h.add(c0015c);
            return;
        }
        throw new AssertionError();
    }

    boolean m497b(C0015c c0015c) {
        if (!f478c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (c0015c.f60h || this.f482e == 0) {
            this.f485h.remove(c0015c);
            return true;
        } else {
            notifyAll();
            return false;
        }
    }
}
