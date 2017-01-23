package com.google.android.gms.ads.internal;

import android.os.Handler;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.p146b.gb;
import com.google.android.gms.p146b.hj;
import java.lang.ref.WeakReference;

@gb
/* renamed from: com.google.android.gms.ads.internal.r */
public class C2903r {
    private final C2902a f9808a;
    private final Runnable f9809b;
    private AdRequestParcel f9810c;
    private boolean f9811d;
    private boolean f9812e;
    private long f9813f;

    /* renamed from: com.google.android.gms.ads.internal.r.1 */
    class C29011 implements Runnable {
        final /* synthetic */ WeakReference f9805a;
        final /* synthetic */ C2903r f9806b;

        C29011(C2903r c2903r, WeakReference weakReference) {
            this.f9806b = c2903r;
            this.f9805a = weakReference;
        }

        public void run() {
            this.f9806b.f9811d = false;
            C2733b c2733b = (C2733b) this.f9805a.get();
            if (c2733b != null) {
                c2733b.m10450c(this.f9806b.f9810c);
            }
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.r.a */
    public static class C2902a {
        private final Handler f9807a;

        public C2902a(Handler handler) {
            this.f9807a = handler;
        }

        public void m11288a(Runnable runnable) {
            this.f9807a.removeCallbacks(runnable);
        }

        public boolean m11289a(Runnable runnable, long j) {
            return this.f9807a.postDelayed(runnable, j);
        }
    }

    public C2903r(C2733b c2733b) {
        this(c2733b, new C2902a(hj.f11297a));
    }

    C2903r(C2733b c2733b, C2902a c2902a) {
        this.f9811d = false;
        this.f9812e = false;
        this.f9813f = 0;
        this.f9808a = c2902a;
        this.f9809b = new C29011(this, new WeakReference(c2733b));
    }

    public void m11292a() {
        this.f9811d = false;
        this.f9808a.m11288a(this.f9809b);
    }

    public void m11293a(AdRequestParcel adRequestParcel) {
        m11294a(adRequestParcel, 60000);
    }

    public void m11294a(AdRequestParcel adRequestParcel, long j) {
        if (this.f9811d) {
            C2972b.m11583d("An ad refresh is already scheduled.");
            return;
        }
        this.f9810c = adRequestParcel;
        this.f9811d = true;
        this.f9813f = j;
        if (!this.f9812e) {
            C2972b.m11581c("Scheduling ad refresh " + j + " milliseconds from now.");
            this.f9808a.m11289a(this.f9809b, j);
        }
    }

    public void m11295b() {
        this.f9812e = true;
        if (this.f9811d) {
            this.f9808a.m11288a(this.f9809b);
        }
    }

    public void m11296c() {
        this.f9812e = false;
        if (this.f9811d) {
            this.f9811d = false;
            m11294a(this.f9810c, this.f9813f);
        }
    }

    public boolean m11297d() {
        return this.f9811d;
    }
}
