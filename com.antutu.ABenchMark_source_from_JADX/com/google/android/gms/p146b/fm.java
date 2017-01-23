package com.google.android.gms.p146b;

import android.content.Context;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.common.internal.C3512u;
import com.google.android.gms.p146b.fq.C2732a;
import com.google.android.gms.p146b.gx.C3232a;
import com.google.android.gms.p146b.ij.C2813a;
import java.util.concurrent.atomic.AtomicBoolean;

@gb
/* renamed from: com.google.android.gms.b.fm */
public abstract class fm implements hl<Void>, C2813a {
    protected final C2732a f10915a;
    protected final Context f10916b;
    protected final ii f10917c;
    protected final C3232a f10918d;
    protected AdResponseParcel f10919e;
    protected final Object f10920f;
    private Runnable f10921g;
    private AtomicBoolean f10922h;

    /* renamed from: com.google.android.gms.b.fm.1 */
    class C32021 implements Runnable {
        final /* synthetic */ fm f10914a;

        C32021(fm fmVar) {
            this.f10914a = fmVar;
        }

        public void run() {
            if (this.f10914a.f10922h.get()) {
                C2972b.m11579b("Timed out waiting for WebView to finish loading.");
                this.f10914a.m12716d();
            }
        }
    }

    protected fm(Context context, C3232a c3232a, ii iiVar, C2732a c2732a) {
        this.f10920f = new Object();
        this.f10922h = new AtomicBoolean(true);
        this.f10916b = context;
        this.f10918d = c3232a;
        this.f10919e = this.f10918d.f11167b;
        this.f10917c = iiVar;
        this.f10915a = c2732a;
    }

    private gx m12710b(int i) {
        AdRequestInfoParcel adRequestInfoParcel = this.f10918d.f11166a;
        return new gx(adRequestInfoParcel.f9853c, this.f10917c, this.f10919e.f9888d, i, this.f10919e.f9890f, this.f10919e.f9894j, this.f10919e.f9896l, this.f10919e.f9895k, adRequestInfoParcel.f9859i, this.f10919e.f9892h, null, null, null, null, null, this.f10919e.f9893i, this.f10918d.f11169d, this.f10919e.f9891g, this.f10918d.f11171f, this.f10919e.f9898n, this.f10919e.f9899o, this.f10918d.f11173h, null, this.f10919e.f9880D, this.f10919e.f9881E, this.f10919e.f9882F, this.f10919e.f9883G);
    }

    public final Void m12711a() {
        C3512u.m14587b("Webview render task needs to be called on UI thread.");
        this.f10921g = new C32021(this);
        hj.f11297a.postDelayed(this.f10921g, ((Long) aq.ay.m11794c()).longValue());
        m12714b();
        return null;
    }

    protected void m12712a(int i) {
        if (i != -2) {
            this.f10919e = new AdResponseParcel(i, this.f10919e.f9895k);
        }
        this.f10917c.m13242e();
        this.f10915a.m10419b(m12710b(i));
    }

    public void m12713a(ii iiVar, boolean z) {
        C2972b.m11576a("WebView finished loading.");
        if (this.f10922h.getAndSet(false)) {
            m12712a(z ? m12715c() : -1);
            hj.f11297a.removeCallbacks(this.f10921g);
        }
    }

    protected abstract void m12714b();

    protected int m12715c() {
        return -2;
    }

    public void m12716d() {
        if (this.f10922h.getAndSet(false)) {
            this.f10917c.stopLoading();
            C2968s.m11527g().m13088a(this.f10917c);
            m12712a(-1);
            hj.f11297a.removeCallbacks(this.f10921g);
        }
    }

    public /* synthetic */ Object m12717e() {
        return m12711a();
    }
}
