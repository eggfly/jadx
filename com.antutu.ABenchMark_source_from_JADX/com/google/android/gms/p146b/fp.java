package com.google.android.gms.p146b;

import android.content.Context;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.p146b.fq.C2732a;
import com.google.android.gms.p146b.gx.C3232a;

@gb
/* renamed from: com.google.android.gms.b.fp */
public abstract class fp extends he {
    protected final C2732a f10940a;
    protected final Context f10941b;
    protected final Object f10942c;
    protected final Object f10943d;
    protected final C3232a f10944e;
    protected AdResponseParcel f10945f;

    /* renamed from: com.google.android.gms.b.fp.1 */
    class C32041 implements Runnable {
        final /* synthetic */ fp f10936a;

        C32041(fp fpVar) {
            this.f10936a = fpVar;
        }

        public void run() {
            this.f10936a.m12740b();
        }
    }

    /* renamed from: com.google.android.gms.b.fp.2 */
    class C32052 implements Runnable {
        final /* synthetic */ gx f10937a;
        final /* synthetic */ fp f10938b;

        C32052(fp fpVar, gx gxVar) {
            this.f10938b = fpVar;
            this.f10937a = gxVar;
        }

        public void run() {
            synchronized (this.f10938b.f10942c) {
                this.f10938b.m12739a(this.f10937a);
            }
        }
    }

    /* renamed from: com.google.android.gms.b.fp.a */
    protected static final class C3206a extends Exception {
        private final int f10939a;

        public C3206a(String str, int i) {
            super(str);
            this.f10939a = i;
        }

        public int m12735a() {
            return this.f10939a;
        }
    }

    protected fp(Context context, C3232a c3232a, C2732a c2732a) {
        super(true);
        this.f10942c = new Object();
        this.f10943d = new Object();
        this.f10941b = context;
        this.f10944e = c3232a;
        this.f10945f = c3232a.f11167b;
        this.f10940a = c2732a;
    }

    protected abstract gx m12736a(int i);

    public void m12737a() {
        int a;
        synchronized (this.f10942c) {
            C2972b.m11576a("AdRendererBackgroundTask started.");
            int i = this.f10944e.f11170e;
            try {
                m12738a(SystemClock.elapsedRealtime());
            } catch (C3206a e) {
                a = e.m12735a();
                if (a == 3 || a == -1) {
                    C2972b.m11581c(e.getMessage());
                } else {
                    C2972b.m11583d(e.getMessage());
                }
                if (this.f10945f == null) {
                    this.f10945f = new AdResponseParcel(a);
                } else {
                    this.f10945f = new AdResponseParcel(a, this.f10945f.f9895k);
                }
                hj.f11297a.post(new C32041(this));
                i = a;
            }
            hj.f11297a.post(new C32052(this, m12736a(i)));
        }
    }

    protected abstract void m12738a(long j);

    protected void m12739a(gx gxVar) {
        this.f10940a.m10419b(gxVar);
    }

    public void m12740b() {
    }
}
