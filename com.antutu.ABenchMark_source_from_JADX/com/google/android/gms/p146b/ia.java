package com.google.android.gms.p146b;

import com.google.android.gms.ads.internal.util.client.C2971a;
import java.util.ArrayList;
import java.util.List;

@gb
/* renamed from: com.google.android.gms.b.ia */
class ia {
    private final Object f11398a;
    private final List<Runnable> f11399b;
    private final List<Runnable> f11400c;
    private boolean f11401d;

    public ia() {
        this.f11398a = new Object();
        this.f11399b = new ArrayList();
        this.f11400c = new ArrayList();
        this.f11401d = false;
    }

    private void m13196c(Runnable runnable) {
        hi.m13004a(runnable);
    }

    private void m13197d(Runnable runnable) {
        C2971a.f10085a.post(runnable);
    }

    public void m13198a() {
        synchronized (this.f11398a) {
            if (this.f11401d) {
                return;
            }
            for (Runnable c : this.f11399b) {
                m13196c(c);
            }
            for (Runnable c2 : this.f11400c) {
                m13197d(c2);
            }
            this.f11399b.clear();
            this.f11400c.clear();
            this.f11401d = true;
        }
    }

    public void m13199a(Runnable runnable) {
        synchronized (this.f11398a) {
            if (this.f11401d) {
                m13196c(runnable);
            } else {
                this.f11399b.add(runnable);
            }
        }
    }

    public void m13200b(Runnable runnable) {
        synchronized (this.f11398a) {
            if (this.f11401d) {
                m13197d(runnable);
            } else {
                this.f11400c.add(runnable);
            }
        }
    }
}
