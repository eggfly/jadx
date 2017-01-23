package p000a.p001a.p003b;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import p000a.C0102a;
import p000a.C0116j;
import p000a.C0134u;
import p000a.ab;
import p000a.p001a.C0010a;
import p000a.p001a.C0037c;
import p000a.p001a.p004e.C0047a;
import p000a.p001a.p004e.C0048b;
import p000a.p001a.p004e.C0055f;
import p000a.p001a.p004e.C0084o;
import p000a.p001a.p005c.C0025c;
import p000a.p001a.p006d.C0045a;

/* renamed from: a.a.b.g */
public final class C0020g {
    static final /* synthetic */ boolean f79b;
    public final C0102a f80a;
    private ab f81c;
    private final C0116j f82d;
    private final Object f83e;
    private final C0018f f84f;
    private int f85g;
    private C0015c f86h;
    private boolean f87i;
    private boolean f88j;
    private C0025c f89k;

    /* renamed from: a.a.b.g.a */
    public static final class C0019a extends WeakReference<C0020g> {
        public final Object f78a;

        C0019a(C0020g c0020g, Object obj) {
            super(c0020g);
            this.f78a = obj;
        }
    }

    static {
        f79b = !C0020g.class.desiredAssertionStatus();
    }

    public C0020g(C0116j c0116j, C0102a c0102a, Object obj) {
        this.f82d = c0116j;
        this.f80a = c0102a;
        this.f84f = new C0018f(c0102a, m82f());
        this.f83e = obj;
    }

    private C0015c m78a(int i, int i2, int i3, boolean z) {
        C0015c c0015c;
        synchronized (this.f82d) {
            if (this.f87i) {
                throw new IllegalStateException("released");
            } else if (this.f89k != null) {
                throw new IllegalStateException("codec != null");
            } else if (this.f88j) {
                throw new IOException("Canceled");
            } else {
                c0015c = this.f86h;
                if (c0015c == null || c0015c.f60h) {
                    c0015c = C0010a.f46a.m31a(this.f82d, this.f80a, this);
                    if (c0015c != null) {
                        this.f86h = c0015c;
                    } else {
                        ab abVar;
                        ab abVar2 = this.f81c;
                        if (abVar2 == null) {
                            abVar2 = this.f84f.m77b();
                            synchronized (this.f82d) {
                                this.f81c = abVar2;
                                this.f85g = 0;
                            }
                            abVar = abVar2;
                        } else {
                            abVar = abVar2;
                        }
                        c0015c = new C0015c(abVar);
                        synchronized (this.f82d) {
                            m85a(c0015c);
                            C0010a.f46a.m37b(this.f82d, c0015c);
                            this.f86h = c0015c;
                            if (this.f88j) {
                                throw new IOException("Canceled");
                            }
                        }
                        c0015c.m53a(i, i2, i3, this.f80a.m449f(), z);
                        m82f().m61b(c0015c.m52a());
                    }
                }
            }
        }
        return c0015c;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private p000a.p001a.p003b.C0015c m79a(int r4, int r5, int r6, boolean r7, boolean r8) {
        /*
        r3 = this;
    L_0x0000:
        r0 = r3.m78a(r4, r5, r6, r7);
        r1 = r3.f82d;
        monitor-enter(r1);
        r2 = r0.f55c;	 Catch:{ all -> 0x0018 }
        if (r2 != 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x0018 }
    L_0x000c:
        return r0;
    L_0x000d:
        monitor-exit(r1);	 Catch:{ all -> 0x0018 }
        r1 = r0.m56a(r8);
        if (r1 != 0) goto L_0x000c;
    L_0x0014:
        r3.m90d();
        goto L_0x0000;
    L_0x0018:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0018 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.b.g.a(int, int, int, boolean, boolean):a.a.b.c");
    }

    private void m80a(boolean z, boolean z2, boolean z3) {
        C0015c c0015c = null;
        synchronized (this.f82d) {
            if (z3) {
                this.f89k = null;
            }
            if (z2) {
                this.f87i = true;
            }
            if (this.f86h != null) {
                if (z) {
                    this.f86h.f60h = true;
                }
                if (this.f89k == null && (this.f87i || this.f86h.f60h)) {
                    m81b(this.f86h);
                    if (this.f86h.f59g.isEmpty()) {
                        this.f86h.f61i = System.nanoTime();
                        if (C0010a.f46a.m36a(this.f82d, this.f86h)) {
                            c0015c = this.f86h;
                        }
                    }
                    this.f86h = null;
                }
            }
        }
        if (c0015c != null) {
            C0037c.m161a(c0015c.m57b());
        }
    }

    private void m81b(C0015c c0015c) {
        int size = c0015c.f59g.size();
        for (int i = 0; i < size; i++) {
            if (((Reference) c0015c.f59g.get(i)).get() == this) {
                c0015c.f59g.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    private C0016d m82f() {
        return C0010a.f46a.m32a(this.f82d);
    }

    public C0025c m83a() {
        C0025c c0025c;
        synchronized (this.f82d) {
            c0025c = this.f89k;
        }
        return c0025c;
    }

    public C0025c m84a(C0134u c0134u, boolean z) {
        int a = c0134u.m619a();
        int b = c0134u.m621b();
        int c = c0134u.m622c();
        try {
            C0025c c0055f;
            C0015c a2 = m79a(a, b, c, c0134u.m637r(), z);
            if (a2.f54b != null) {
                c0055f = new C0055f(c0134u, this, a2.f54b);
            } else {
                a2.m57b().setSoTimeout(b);
                a2.f56d.timeout().timeout((long) b, TimeUnit.MILLISECONDS);
                a2.f57e.timeout().timeout((long) c, TimeUnit.MILLISECONDS);
                c0055f = new C0045a(c0134u, this, a2.f56d, a2.f57e);
            }
            synchronized (this.f82d) {
                this.f89k = c0055f;
            }
            return c0055f;
        } catch (IOException e) {
            throw new C0017e(e);
        }
    }

    public void m85a(C0015c c0015c) {
        if (f79b || Thread.holdsLock(this.f82d)) {
            c0015c.f59g.add(new C0019a(this, this.f83e));
            return;
        }
        throw new AssertionError();
    }

    public void m86a(IOException iOException) {
        boolean z;
        synchronized (this.f82d) {
            if (iOException instanceof C0084o) {
                C0084o c0084o = (C0084o) iOException;
                if (c0084o.f329a == C0048b.REFUSED_STREAM) {
                    this.f85g++;
                }
                if (c0084o.f329a != C0048b.REFUSED_STREAM || this.f85g > 1) {
                    this.f81c = null;
                }
                z = false;
            } else {
                if (!(this.f86h == null || this.f86h.m59d()) || (iOException instanceof C0047a)) {
                    if (this.f86h.f55c == 0) {
                        if (!(this.f81c == null || iOException == null)) {
                            this.f84f.m75a(this.f81c, iOException);
                        }
                        this.f81c = null;
                    }
                }
                z = false;
            }
            z = true;
        }
        m80a(z, false, true);
    }

    public void m87a(boolean z, C0025c c0025c) {
        synchronized (this.f82d) {
            if (c0025c != null) {
                if (c0025c == this.f89k) {
                    if (!z) {
                        C0015c c0015c = this.f86h;
                        c0015c.f55c++;
                    }
                }
            }
            throw new IllegalStateException("expected " + this.f89k + " but was " + c0025c);
        }
        m80a(z, false, true);
    }

    public synchronized C0015c m88b() {
        return this.f86h;
    }

    public void m89c() {
        m80a(false, true, false);
    }

    public void m90d() {
        m80a(true, false, false);
    }

    public boolean m91e() {
        return this.f81c != null || this.f84f.m76a();
    }

    public String toString() {
        return this.f80a.toString();
    }
}
