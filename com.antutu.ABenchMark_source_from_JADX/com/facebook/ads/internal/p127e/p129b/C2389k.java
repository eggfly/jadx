package com.facebook.ads.internal.p127e.p129b;

import android.util.Log;
import java.lang.Thread.State;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.facebook.ads.internal.e.b.k */
class C2389k {
    private final C2400n f8286a;
    private final C2376a f8287b;
    private final Object f8288c;
    private final Object f8289d;
    private final AtomicInteger f8290e;
    private volatile Thread f8291f;
    private volatile boolean f8292g;
    private volatile int f8293h;

    /* renamed from: com.facebook.ads.internal.e.b.k.a */
    private class C2406a implements Runnable {
        final /* synthetic */ C2389k f8328a;

        private C2406a(C2389k c2389k) {
            this.f8328a = c2389k;
        }

        public void run() {
            this.f8328a.m9188e();
        }
    }

    public C2389k(C2400n c2400n, C2376a c2376a) {
        this.f8288c = new Object();
        this.f8289d = new Object();
        this.f8293h = -1;
        this.f8286a = (C2400n) C2404j.m9249a(c2400n);
        this.f8287b = (C2376a) C2404j.m9249a(c2376a);
        this.f8290e = new AtomicInteger();
    }

    private void m9184b() {
        int i = this.f8290e.get();
        if (i >= 1) {
            this.f8290e.set(0);
            throw new C2402l("Error reading source " + i + " times");
        }
    }

    private void m9185b(long j, long j2) {
        m9195a(j, j2);
        synchronized (this.f8288c) {
            this.f8288c.notifyAll();
        }
    }

    private synchronized void m9186c() {
        Object obj = (this.f8291f == null || this.f8291f.getState() == State.TERMINATED) ? null : 1;
        if (!(this.f8292g || this.f8287b.m9151d() || obj != null)) {
            this.f8291f = new Thread(new C2406a(), "Source reader for " + this.f8286a);
            this.f8291f.start();
        }
    }

    private void m9187d() {
        synchronized (this.f8288c) {
            try {
                this.f8288c.wait(1000);
            } catch (Throwable e) {
                throw new C2402l("Waiting source data is interrupted!", e);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m9188e() {
        /*
        r8 = this;
        r3 = -1;
        r1 = 0;
        r0 = r8.f8287b;	 Catch:{ Throwable -> 0x006d, all -> 0x006a }
        r1 = r0.m9146a();	 Catch:{ Throwable -> 0x006d, all -> 0x006a }
        r0 = r8.f8286a;	 Catch:{ Throwable -> 0x006d, all -> 0x006a }
        r0.m9239a(r1);	 Catch:{ Throwable -> 0x006d, all -> 0x006a }
        r0 = r8.f8286a;	 Catch:{ Throwable -> 0x006d, all -> 0x006a }
        r2 = r0.m9237a();	 Catch:{ Throwable -> 0x006d, all -> 0x006a }
        r0 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r0 = new byte[r0];	 Catch:{ Throwable -> 0x003f }
    L_0x0017:
        r4 = r8.f8286a;	 Catch:{ Throwable -> 0x003f }
        r4 = r4.m9238a(r0);	 Catch:{ Throwable -> 0x003f }
        if (r4 == r3) goto L_0x005e;
    L_0x001f:
        r5 = r8.f8289d;	 Catch:{ Throwable -> 0x003f }
        monitor-enter(r5);	 Catch:{ Throwable -> 0x003f }
        r6 = r8.m9190g();	 Catch:{ all -> 0x0051 }
        if (r6 == 0) goto L_0x0032;
    L_0x0028:
        monitor-exit(r5);	 Catch:{ all -> 0x0051 }
        r8.m9191h();
        r0 = (long) r1;
        r2 = (long) r2;
        r8.m9185b(r0, r2);
    L_0x0031:
        return;
    L_0x0032:
        r6 = r8.f8287b;	 Catch:{ all -> 0x0051 }
        r6.m9148a(r0, r4);	 Catch:{ all -> 0x0051 }
        monitor-exit(r5);	 Catch:{ all -> 0x0051 }
        r1 = r1 + r4;
        r4 = (long) r1;
        r6 = (long) r2;
        r8.m9185b(r4, r6);	 Catch:{ Throwable -> 0x003f }
        goto L_0x0017;
    L_0x003f:
        r0 = move-exception;
    L_0x0040:
        r3 = r8.f8290e;	 Catch:{ all -> 0x0054 }
        r3.incrementAndGet();	 Catch:{ all -> 0x0054 }
        r8.m9196a(r0);	 Catch:{ all -> 0x0054 }
        r8.m9191h();
        r0 = (long) r1;
        r2 = (long) r2;
        r8.m9185b(r0, r2);
        goto L_0x0031;
    L_0x0051:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x0051 }
        throw r0;	 Catch:{ Throwable -> 0x003f }
    L_0x0054:
        r0 = move-exception;
    L_0x0055:
        r8.m9191h();
        r4 = (long) r1;
        r2 = (long) r2;
        r8.m9185b(r4, r2);
        throw r0;
    L_0x005e:
        r8.m9189f();	 Catch:{ Throwable -> 0x003f }
        r8.m9191h();
        r0 = (long) r1;
        r2 = (long) r2;
        r8.m9185b(r0, r2);
        goto L_0x0031;
    L_0x006a:
        r0 = move-exception;
        r2 = r3;
        goto L_0x0055;
    L_0x006d:
        r0 = move-exception;
        r2 = r3;
        goto L_0x0040;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.e.b.k.e():void");
    }

    private void m9189f() {
        synchronized (this.f8289d) {
            if (!m9190g() && this.f8287b.m9146a() == this.f8286a.m9237a()) {
                this.f8287b.m9150c();
            }
        }
    }

    private boolean m9190g() {
        return Thread.currentThread().isInterrupted() || this.f8292g;
    }

    private void m9191h() {
        try {
            this.f8286a.m9240b();
        } catch (Throwable e) {
            m9196a(new C2402l("Error closing source " + this.f8286a, e));
        }
    }

    public int m9192a(byte[] bArr, long j, int i) {
        C2407m.m9255a(bArr, j, i);
        while (!this.f8287b.m9151d() && ((long) this.f8287b.m9146a()) < ((long) i) + j && !this.f8292g) {
            m9186c();
            m9187d();
            m9184b();
        }
        int a = this.f8287b.m9147a(bArr, j, i);
        if (this.f8287b.m9151d() && this.f8293h != 100) {
            this.f8293h = 100;
            m9194a(100);
        }
        return a;
    }

    public void m9193a() {
        synchronized (this.f8289d) {
            Log.d("ProxyCache", "Shutdown proxy for " + this.f8286a);
            try {
                this.f8292g = true;
                if (this.f8291f != null) {
                    this.f8291f.interrupt();
                }
                this.f8287b.m9149b();
            } catch (Throwable e) {
                m9196a(e);
            }
        }
    }

    protected void m9194a(int i) {
    }

    protected void m9195a(long j, long j2) {
        Object obj = 1;
        int i = ((j2 > 0 ? 1 : (j2 == 0 ? 0 : -1)) == 0 ? 1 : null) != null ? 100 : (int) ((100 * j) / j2);
        Object obj2 = i != this.f8293h ? 1 : null;
        if (j2 < 0) {
            obj = null;
        }
        if (!(obj == null || obj2 == null)) {
            m9194a(i);
        }
        this.f8293h = i;
    }

    protected final void m9196a(Throwable th) {
        if (th instanceof C2403i) {
            Log.d("ProxyCache", "ProxyCache is interrupted");
        } else {
            Log.e("ProxyCache", "ProxyCache error", th);
        }
    }
}
