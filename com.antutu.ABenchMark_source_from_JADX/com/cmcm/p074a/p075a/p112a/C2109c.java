package com.cmcm.p074a.p075a.p112a;

import android.os.Handler;

/* renamed from: com.cmcm.a.a.a.c */
public class C2109c {
    private Handler f7417a;
    private int f7418b;
    private int f7419c;
    private Runnable f7420d;
    private long f7421e;
    private Runnable f7422f;

    public C2109c() {
        this(Integer.MAX_VALUE, new Handler());
    }

    public C2109c(int i) {
        this(i, new Handler());
    }

    public C2109c(int i, Handler handler) {
        this.f7418b = Math.max(1, i);
        this.f7417a = handler;
    }

    public C2109c(Handler handler) {
        this(Integer.MAX_VALUE, handler);
    }

    static /* synthetic */ int m7944b(C2109c c2109c) {
        int i = c2109c.f7419c + 1;
        c2109c.f7419c = i;
        return i;
    }

    public void m7950a(long j) {
        this.f7421e = j;
    }

    public void m7951a(Runnable runnable, long j) {
        if (runnable == null) {
            throw new RuntimeException("invalid parameters");
        }
        m7953b();
        this.f7420d = runnable;
        this.f7419c = 0;
        m7950a(j);
        if (this.f7422f == null) {
            this.f7422f = new C2110d(this);
        }
        this.f7417a.postDelayed(this.f7422f, this.f7421e);
    }

    public boolean m7952a() {
        return this.f7420d != null;
    }

    public void m7953b() {
        if (m7952a()) {
            this.f7420d = null;
            this.f7417a.removeCallbacks(this.f7422f);
        }
    }
}
