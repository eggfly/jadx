package com.google.android.gms.p146b;

import java.util.concurrent.Future;

@gb
/* renamed from: com.google.android.gms.b.he */
public abstract class he implements hl<Future> {
    private final Runnable f9606a;
    private volatile Thread f9607b;
    private boolean f9608c;

    /* renamed from: com.google.android.gms.b.he.1 */
    class C32361 implements Runnable {
        final /* synthetic */ he f11267a;

        C32361(he heVar) {
            this.f11267a = heVar;
        }

        public final void run() {
            this.f11267a.f9607b = Thread.currentThread();
            this.f11267a.m10971a();
        }
    }

    public he() {
        this.f9606a = new C32361(this);
        this.f9608c = false;
    }

    public he(boolean z) {
        this.f9606a = new C32361(this);
        this.f9608c = z;
    }

    public abstract void m10971a();

    public abstract void m10972b();

    public final void m10973d() {
        m10972b();
        if (this.f9607b != null) {
            this.f9607b.interrupt();
        }
    }

    public /* synthetic */ Object m10974e() {
        return m10975g();
    }

    public final Future m10975g() {
        return this.f9608c ? hi.m13003a(1, this.f9606a) : hi.m13004a(this.f9606a);
    }
}
