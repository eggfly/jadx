package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.v4.util.SimpleArrayMap;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.C2805d;
import com.google.android.gms.ads.internal.formats.C2807e;
import com.google.android.gms.ads.internal.formats.C2809f;
import com.google.android.gms.ads.internal.formats.C2810h;
import com.google.android.gms.ads.internal.formats.C2810h.C2804a;
import com.google.android.gms.ads.internal.formats.C2812g;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.C3512u;
import com.google.android.gms.p146b.az;
import com.google.android.gms.p146b.bd;
import com.google.android.gms.p146b.bo;
import com.google.android.gms.p146b.bp;
import com.google.android.gms.p146b.bq;
import com.google.android.gms.p146b.br;
import com.google.android.gms.p146b.du;
import com.google.android.gms.p146b.dz;
import com.google.android.gms.p146b.ea;
import com.google.android.gms.p146b.fc;
import com.google.android.gms.p146b.gb;
import com.google.android.gms.p146b.gx;
import com.google.android.gms.p146b.gx.C3232a;
import com.google.android.gms.p146b.hj;
import java.util.List;

@gb
/* renamed from: com.google.android.gms.ads.internal.q */
public class C2900q extends C2737c {

    /* renamed from: com.google.android.gms.ads.internal.q.1 */
    class C28961 implements Runnable {
        final /* synthetic */ C3232a f9796a;
        final /* synthetic */ C2900q f9797b;

        C28961(C2900q c2900q, C3232a c3232a) {
            this.f9797b = c2900q;
            this.f9796a = c3232a;
        }

        public void run() {
            this.f9797b.m10484b(new gx(this.f9796a, null, null, null, null, null, null));
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.q.2 */
    class C28972 implements Runnable {
        final /* synthetic */ C2805d f9798a;
        final /* synthetic */ C2900q f9799b;

        C28972(C2900q c2900q, C2805d c2805d) {
            this.f9799b = c2900q;
            this.f9798a = c2805d;
        }

        public void run() {
            try {
                this.f9799b.f.f10072s.m11940a(this.f9798a);
            } catch (Throwable e) {
                C2972b.m11584d("Could not call OnAppInstallAdLoadedListener.onAppInstallAdLoaded().", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.q.3 */
    class C28983 implements Runnable {
        final /* synthetic */ C2807e f9800a;
        final /* synthetic */ C2900q f9801b;

        C28983(C2900q c2900q, C2807e c2807e) {
            this.f9801b = c2900q;
            this.f9800a = c2807e;
        }

        public void run() {
            try {
                this.f9801b.f.f10073t.m11943a(this.f9800a);
            } catch (Throwable e) {
                C2972b.m11584d("Could not call OnContentAdLoadedListener.onContentAdLoaded().", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.q.4 */
    class C28994 implements Runnable {
        final /* synthetic */ String f9802a;
        final /* synthetic */ gx f9803b;
        final /* synthetic */ C2900q f9804c;

        C28994(C2900q c2900q, String str, gx gxVar) {
            this.f9804c = c2900q;
            this.f9802a = str;
            this.f9803b = gxVar;
        }

        public void run() {
            try {
                ((br) this.f9804c.f.f10075v.get(this.f9802a)).m11949a((C2809f) this.f9803b.f11175B);
            } catch (Throwable e) {
                C2972b.m11584d("Could not call onCustomTemplateAdLoadedListener.onCustomTemplateAdLoaded().", e);
            }
        }
    }

    public C2900q(Context context, C2795e c2795e, AdSizeParcel adSizeParcel, String str, du duVar, VersionInfoParcel versionInfoParcel) {
        super(context, adSizeParcel, str, duVar, versionInfoParcel, c2795e);
    }

    private static C2805d m11266a(dz dzVar) {
        return new C2805d(dzVar.m12417a(), dzVar.m12419b(), dzVar.m12421c(), dzVar.m12422d() != null ? dzVar.m12422d() : null, dzVar.m12423e(), dzVar.m12424f(), dzVar.m12425g(), dzVar.m12426h(), null, dzVar.m12430l());
    }

    private static C2807e m11267a(ea eaVar) {
        return new C2807e(eaVar.m12450a(), eaVar.m12452b(), eaVar.m12454c(), eaVar.m12455d() != null ? eaVar.m12455d() : null, eaVar.m12456e(), eaVar.m12457f(), null, eaVar.m12461j());
    }

    private void m11268a(C2805d c2805d) {
        hj.f11297a.post(new C28972(this, c2805d));
    }

    private void m11269a(C2807e c2807e) {
        hj.f11297a.post(new C28983(this, c2807e));
    }

    private void m11270a(gx gxVar, String str) {
        hj.f11297a.post(new C28994(this, str, gxVar));
    }

    public void m11271a(SimpleArrayMap<String, br> simpleArrayMap) {
        C3512u.m14587b("setOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        this.f.f10075v = simpleArrayMap;
    }

    public void m11272a(NativeAdOptionsParcel nativeAdOptionsParcel) {
        C3512u.m14587b("setNativeAdOptions must be called on the main UI thread.");
        this.f.f10076w = nativeAdOptionsParcel;
    }

    public void m11273a(C2810h c2810h) {
        if (this.f.f10063j.f11187j != null) {
            C2968s.m11528h().m12954k().m13876a(this.f.f10062i, this.f.f10063j, c2810h);
        }
    }

    public void m11274a(bd bdVar) {
        throw new IllegalStateException("CustomRendering is NOT supported by NativeAdManager.");
    }

    public void m11275a(bo boVar) {
        C3512u.m14587b("setOnAppInstallAdLoadedListener must be called on the main UI thread.");
        this.f.f10072s = boVar;
    }

    public void m11276a(bp bpVar) {
        C3512u.m14587b("setOnContentAdLoadedListener must be called on the main UI thread.");
        this.f.f10073t = bpVar;
    }

    public void m11277a(fc fcVar) {
        throw new IllegalStateException("In App Purchase is NOT supported by NativeAdManager.");
    }

    public void m11278a(C3232a c3232a, az azVar) {
        if (c3232a.f11169d != null) {
            this.f.f10062i = c3232a.f11169d;
        }
        if (c3232a.f11170e != -2) {
            hj.f11297a.post(new C28961(this, c3232a));
            return;
        }
        this.f.f10043D = 0;
        this.f.f10061h = C2968s.m11524d().m12741a(this.f.f10056c, this, c3232a, this.f.f10057d, null, this.j, this, azVar);
        C2972b.m11576a("AdRenderer: " + this.f.f10061h.getClass().getName());
    }

    public void m11279a(List<String> list) {
        C3512u.m14587b("setNativeTemplates must be called on the main UI thread.");
        this.f.f10079z = list;
    }

    protected boolean m11280a(AdRequestParcel adRequestParcel, gx gxVar, boolean z) {
        return this.e.m11297d();
    }

    protected boolean m11281a(gx gxVar, gx gxVar2) {
        m11279a(null);
        if (this.f.m11553e()) {
            if (gxVar2.f11190m) {
                try {
                    dz h = gxVar2.f11192o.m12382h();
                    ea i = gxVar2.f11192o.m12383i();
                    if (h != null) {
                        C2805d a = C2900q.m11266a(h);
                        a.m10809a(new C2812g(this.f.f10056c, this, this.f.f10057d, h));
                        m11268a(a);
                    } else if (i != null) {
                        C2807e a2 = C2900q.m11267a(i);
                        a2.m10834a(new C2812g(this.f.f10056c, this, this.f.f10057d, i));
                        m11269a(a2);
                    } else {
                        C2972b.m11583d("No matching mapper for retrieved native ad template.");
                        m10424a(0);
                        return false;
                    }
                } catch (Throwable e) {
                    C2972b.m11584d("Failed to get native ad mapper", e);
                }
            } else {
                C2804a c2804a = gxVar2.f11175B;
                if ((c2804a instanceof C2807e) && this.f.f10073t != null) {
                    m11269a((C2807e) gxVar2.f11175B);
                } else if ((c2804a instanceof C2805d) && this.f.f10072s != null) {
                    m11268a((C2805d) gxVar2.f11175B);
                } else if (!(c2804a instanceof C2809f) || this.f.f10075v == null || this.f.f10075v.get(((C2809f) c2804a).m10860k()) == null) {
                    C2972b.m11583d("No matching listener for retrieved native ad template.");
                    m10424a(0);
                    return false;
                } else {
                    m11270a(gxVar2, ((C2809f) c2804a).m10860k());
                }
            }
            return super.m10483a(gxVar, gxVar2);
        }
        throw new IllegalStateException("Native ad DOES NOT have custom rendering mode.");
    }

    public void m11282b(SimpleArrayMap<String, bq> simpleArrayMap) {
        C3512u.m14587b("setOnCustomClickListener must be called on the main UI thread.");
        this.f.f10074u = simpleArrayMap;
    }

    public bq m11283c(String str) {
        C3512u.m14587b("getOnCustomClickListener must be called on the main UI thread.");
        return (bq) this.f.f10074u.get(str);
    }

    public void m11284d() {
        throw new IllegalStateException("Native Ad DOES NOT support pause().");
    }

    public void m11285e() {
        throw new IllegalStateException("Native Ad DOES NOT support resume().");
    }

    public void m11286f() {
        throw new IllegalStateException("Interstitial is NOT supported by NativeAdManager.");
    }

    public SimpleArrayMap<String, br> m11287z() {
        C3512u.m14587b("getOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        return this.f.f10075v;
    }
}
