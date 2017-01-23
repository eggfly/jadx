package com.google.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.C2301a;
import com.google.android.gms.ads.C2710b;
import com.google.android.gms.ads.C2710b.C2699a;
import com.google.android.gms.ads.C2716c;
import com.google.android.gms.ads.C2716c.C2712a;
import com.google.android.gms.ads.C2719d;
import com.google.android.gms.ads.C2723e;
import com.google.android.gms.ads.C2725h;
import com.google.android.gms.ads.internal.client.C2646a;
import com.google.android.gms.ads.internal.client.C2784w;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.ads.mediation.C2633b.C2975a;
import com.google.android.gms.ads.mediation.C2635c;
import com.google.android.gms.ads.mediation.C2636g;
import com.google.android.gms.ads.mediation.C2642j;
import com.google.android.gms.ads.mediation.C2644k;
import com.google.android.gms.ads.mediation.C2974a;
import com.google.android.gms.ads.mediation.C2987d;
import com.google.android.gms.ads.mediation.C2988f;
import com.google.android.gms.ads.mediation.C2989h;
import com.google.android.gms.ads.mediation.C2990l;
import com.google.android.gms.ads.p124b.C2704b;
import com.google.android.gms.ads.p124b.C2705c;
import com.google.android.gms.ads.p124b.C2706d;
import com.google.android.gms.ads.p124b.C2706d.C2303a;
import com.google.android.gms.ads.p124b.C2708f;
import com.google.android.gms.ads.p124b.C2708f.C2305a;
import com.google.android.gms.ads.p149d.C2639b;
import com.google.android.gms.ads.p149d.C2718a;
import com.google.android.gms.ads.p149d.p150a.C2634a;
import com.google.android.gms.ads.p149d.p150a.C2717b;
import com.google.android.gms.p146b.gb;
import com.google.android.gms.p146b.iu;
import java.util.Date;
import java.util.Set;

@gb
/* renamed from: com.google.ads.mediation.a */
public abstract class C2638a implements C2634a, C2635c, C2636g, iu {
    protected C2723e f9172a;
    protected C2725h f9173b;
    final C2639b f9174c;
    private C2710b f9175d;
    private Context f9176e;
    private C2725h f9177f;
    private C2717b f9178g;
    private String f9179h;

    /* renamed from: com.google.ads.mediation.a.1 */
    class C26401 implements C2639b {
        final /* synthetic */ C2638a f9180a;

        C26401(C2638a c2638a) {
            this.f9180a = c2638a;
        }

        public void m10178a() {
            this.f9180a.f9178g.m10337b(this.f9180a);
        }

        public void m10179a(int i) {
            this.f9180a.f9178g.m10335a(this.f9180a, i);
        }

        public void m10180a(C2718a c2718a) {
            this.f9180a.f9178g.m10336a(this.f9180a, c2718a);
        }

        public void m10181b() {
            this.f9180a.f9178g.m10338c(this.f9180a);
        }

        public void m10182c() {
            this.f9180a.f9178g.m10339d(this.f9180a);
        }

        public void m10183d() {
            this.f9180a.f9178g.m10340e(this.f9180a);
            this.f9180a.f9177f = null;
        }

        public void m10184e() {
            this.f9180a.f9178g.m10341f(this.f9180a);
        }
    }

    /* renamed from: com.google.ads.mediation.a.a */
    static class C2643a extends C2642j {
        private final C2706d f9192d;

        public C2643a(C2706d c2706d) {
            this.f9192d = c2706d;
            m10195a(c2706d.m10293b().toString());
            m10196a(c2706d.m10294c());
            m10197b(c2706d.m10295d().toString());
            m10194a(c2706d.m10296e());
            m10198c(c2706d.m10297f().toString());
            m10193a(c2706d.m10298g().doubleValue());
            m10199d(c2706d.m10299h().toString());
            m10201e(c2706d.m10300i().toString());
            m10186a(true);
            m10189b(true);
        }

        public void m10209a(View view) {
            if (view instanceof C2705c) {
                ((C2705c) view).setNativeAd(this.f9192d);
            }
        }
    }

    /* renamed from: com.google.ads.mediation.a.b */
    static class C2645b extends C2644k {
        private final C2708f f9199d;

        public C2645b(C2708f c2708f) {
            this.f9199d = c2708f;
            m10211a(c2708f.m10301b().toString());
            m10212a(c2708f.m10302c());
            m10213b(c2708f.m10303d().toString());
            m10210a(c2708f.m10304e());
            m10214c(c2708f.m10305f().toString());
            m10215d(c2708f.m10306g().toString());
            m10186a(true);
            m10189b(true);
        }

        public void m10222a(View view) {
            if (view instanceof C2705c) {
                ((C2705c) view).setNativeAd(this.f9199d);
            }
        }
    }

    /* renamed from: com.google.ads.mediation.a.c */
    static final class C2647c extends C2301a implements C2646a {
        final C2638a f9200a;
        final C2987d f9201b;

        public C2647c(C2638a c2638a, C2987d c2987d) {
            this.f9200a = c2638a;
            this.f9201b = c2987d;
        }

        public void m10224a() {
            this.f9201b.m11620e(this.f9200a);
        }

        public void onAdClosed() {
            this.f9201b.m11618c(this.f9200a);
        }

        public void onAdFailedToLoad(int i) {
            this.f9201b.m11616a(this.f9200a, i);
        }

        public void onAdLeftApplication() {
            this.f9201b.m11619d(this.f9200a);
        }

        public void onAdLoaded() {
            this.f9201b.m11615a(this.f9200a);
        }

        public void onAdOpened() {
            this.f9201b.m11617b(this.f9200a);
        }
    }

    /* renamed from: com.google.ads.mediation.a.d */
    static final class C2648d extends C2301a implements C2646a {
        final C2638a f9202a;
        final C2988f f9203b;

        public C2648d(C2638a c2638a, C2988f c2988f) {
            this.f9202a = c2638a;
            this.f9203b = c2988f;
        }

        public void m10225a() {
            this.f9203b.m11626e(this.f9202a);
        }

        public void onAdClosed() {
            this.f9203b.m11624c(this.f9202a);
        }

        public void onAdFailedToLoad(int i) {
            this.f9203b.m11622a(this.f9202a, i);
        }

        public void onAdLeftApplication() {
            this.f9203b.m11625d(this.f9202a);
        }

        public void onAdLoaded() {
            this.f9203b.m11621a(this.f9202a);
        }

        public void onAdOpened() {
            this.f9203b.m11623b(this.f9202a);
        }
    }

    /* renamed from: com.google.ads.mediation.a.e */
    static final class C2649e extends C2301a implements C2303a, C2305a, C2646a {
        final C2638a f9204a;
        final C2989h f9205b;

        public C2649e(C2638a c2638a, C2989h c2989h) {
            this.f9204a = c2638a;
            this.f9205b = c2989h;
        }

        public void m10226a() {
            this.f9205b.m11632d(this.f9204a);
        }

        public void onAdClosed() {
            this.f9205b.m11630b(this.f9204a);
        }

        public void onAdFailedToLoad(int i) {
            this.f9205b.m11628a(this.f9204a, i);
        }

        public void onAdLeftApplication() {
            this.f9205b.m11631c(this.f9204a);
        }

        public void onAdLoaded() {
        }

        public void onAdOpened() {
            this.f9205b.m11627a(this.f9204a);
        }

        public void onAppInstallAdLoaded(C2706d c2706d) {
            this.f9205b.m11629a(this.f9204a, new C2643a(c2706d));
        }

        public void onContentAdLoaded(C2708f c2708f) {
            this.f9205b.m11629a(this.f9204a, new C2645b(c2708f));
        }
    }

    public C2638a() {
        this.f9174c = new C26401(this);
    }

    protected abstract Bundle m10152a(Bundle bundle, Bundle bundle2);

    C2699a m10153a(Context context, String str) {
        return new C2699a(context, str);
    }

    C2716c m10154a(Context context, C2974a c2974a, Bundle bundle, Bundle bundle2) {
        C2712a c2712a = new C2712a();
        Date a = c2974a.m11588a();
        if (a != null) {
            c2712a.m10314a(a);
        }
        int b = c2974a.m11589b();
        if (b != 0) {
            c2712a.m10310a(b);
        }
        Set<String> c = c2974a.m11590c();
        if (c != null) {
            for (String a2 : c) {
                c2712a.m10313a(a2);
            }
        }
        Location d = c2974a.m11591d();
        if (d != null) {
            c2712a.m10311a(d);
        }
        if (c2974a.m11593f()) {
            c2712a.m10317b(C2784w.m10741a().m11562a(context));
        }
        if (c2974a.m11592e() != -1) {
            c2712a.m10315a(c2974a.m11592e() == 1);
        }
        c2712a.m10318b(c2974a.m11594g());
        c2712a.m10312a(AdMobAdapter.class, m10152a(bundle, bundle2));
        return c2712a.m10316a();
    }

    public String m10155a(Bundle bundle) {
        return bundle.getString("pubid");
    }

    public void m10156a() {
        if (this.f9172a != null) {
            this.f9172a.m10371c();
            this.f9172a = null;
        }
        if (this.f9173b != null) {
            this.f9173b = null;
        }
        if (this.f9175d != null) {
            this.f9175d = null;
        }
        if (this.f9177f != null) {
            this.f9177f = null;
        }
    }

    public void m10157a(Context context, C2974a c2974a, String str, C2717b c2717b, Bundle bundle, Bundle bundle2) {
        this.f9176e = context.getApplicationContext();
        this.f9179h = str;
        this.f9178g = c2717b;
        this.f9178g.m10334a(this);
    }

    public void m10158a(Context context, C2987d c2987d, Bundle bundle, C2719d c2719d, C2974a c2974a, Bundle bundle2) {
        this.f9172a = new C2723e(context);
        this.f9172a.setAdSize(new C2719d(c2719d.m10346b(), c2719d.m10344a()));
        this.f9172a.setAdUnitId(m10155a(bundle));
        this.f9172a.setAdListener(new C2647c(this, c2987d));
        this.f9172a.m10369a(m10154a(context, c2974a, bundle2, bundle));
    }

    public void m10159a(Context context, C2988f c2988f, Bundle bundle, C2974a c2974a, Bundle bundle2) {
        this.f9173b = new C2725h(context);
        this.f9173b.m10377a(m10155a(bundle));
        this.f9173b.m10374a(new C2648d(this, c2988f));
        this.f9173b.m10375a(m10154a(context, c2974a, bundle2, bundle));
    }

    public void m10160a(Context context, C2989h c2989h, Bundle bundle, C2990l c2990l, Bundle bundle2) {
        C2305a c2649e = new C2649e(this, c2989h);
        C2699a a = m10153a(context, bundle.getString("pubid")).m10269a((C2301a) c2649e);
        C2704b h = c2990l.m11633h();
        if (h != null) {
            a.m10270a(h);
        }
        if (c2990l.m11634i()) {
            a.m10271a((C2303a) c2649e);
        }
        if (c2990l.m11635j()) {
            a.m10272a(c2649e);
        }
        this.f9175d = a.m10273a();
        this.f9175d.m10308a(m10154a(context, c2990l, bundle2, bundle));
    }

    public void m10161a(C2974a c2974a, Bundle bundle, Bundle bundle2) {
        if (this.f9176e == null || this.f9178g == null) {
            C2972b.m11579b("AdMobAdapter.loadAd called before initialize.");
            return;
        }
        this.f9177f = new C2725h(this.f9176e);
        this.f9177f.m10378a(true);
        this.f9177f.m10377a(m10155a(bundle));
        this.f9177f.m10376a(this.f9174c);
        this.f9177f.m10379b(this.f9179h);
        this.f9177f.m10375a(m10154a(this.f9176e, c2974a, bundle2, bundle));
    }

    public void m10162b() {
        if (this.f9172a != null) {
            this.f9172a.m10370b();
        }
    }

    public void m10163c() {
        if (this.f9172a != null) {
            this.f9172a.m10368a();
        }
    }

    public View m10164d() {
        return this.f9172a;
    }

    public void m10165e() {
        this.f9173b.m10373a();
    }

    public Bundle m10166f() {
        return new C2975a().m11596a(1).m11595a();
    }

    public void m10167g() {
        this.f9177f.m10373a();
    }

    public boolean m10168h() {
        return this.f9178g != null;
    }
}
