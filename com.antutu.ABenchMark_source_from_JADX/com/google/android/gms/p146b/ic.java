package com.google.android.gms.p146b;

import com.google.android.gms.p146b.ib.C2915c;
import com.google.android.gms.p146b.ib.C2917a;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@gb
/* renamed from: com.google.android.gms.b.ic */
public class ic<T> implements ib<T> {
    protected int f10607a;
    protected final BlockingQueue<C3281a> f10608b;
    protected T f10609c;
    private final Object f10610d;

    /* renamed from: com.google.android.gms.b.ic.a */
    class C3281a {
        public final C2915c<T> f11402a;
        public final C2917a f11403b;
        final /* synthetic */ ic f11404c;

        public C3281a(ic icVar, C2915c<T> c2915c, C2917a c2917a) {
            this.f11404c = icVar;
            this.f11402a = c2915c;
            this.f11403b = c2917a;
        }
    }

    public ic() {
        this.f10610d = new Object();
        this.f10607a = 0;
        this.f10608b = new LinkedBlockingQueue();
    }

    public void m12251a(C2915c<T> c2915c, C2917a c2917a) {
        synchronized (this.f10610d) {
            if (this.f10607a == 1) {
                c2915c.m11322a(this.f10609c);
            } else if (this.f10607a == -1) {
                c2917a.m11325a();
            } else if (this.f10607a == 0) {
                this.f10608b.add(new C3281a(this, c2915c, c2917a));
            }
        }
    }

    public void m12252a(T t) {
        synchronized (this.f10610d) {
            if (this.f10607a != 0) {
                throw new UnsupportedOperationException();
            }
            this.f10609c = t;
            this.f10607a = 1;
            for (C3281a c3281a : this.f10608b) {
                c3281a.f11402a.m11322a(t);
            }
            this.f10608b.clear();
        }
    }

    public void m12253e() {
        synchronized (this.f10610d) {
            if (this.f10607a != 0) {
                throw new UnsupportedOperationException();
            }
            this.f10607a = -1;
            for (C3281a c3281a : this.f10608b) {
                c3281a.f11403b.m11325a();
            }
            this.f10608b.clear();
        }
    }

    public int m12254f() {
        return this.f10607a;
    }
}
