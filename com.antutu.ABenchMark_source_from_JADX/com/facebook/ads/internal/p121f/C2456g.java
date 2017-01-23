package com.facebook.ads.internal.p121f;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.ads.InterstitialAdActivity;
import com.facebook.ads.internal.adapters.C2268b;
import com.facebook.ads.internal.adapters.C2329n;
import com.facebook.ads.internal.adapters.C2331o;
import com.facebook.ads.internal.p121f.C2422a.C2318a;
import com.facebook.ads.internal.p121f.C2455i.C2257a;
import com.facebook.ads.internal.p123a.C2295a;
import com.facebook.ads.internal.p123a.C2296b;
import com.facebook.ads.internal.util.C2489b;
import com.facebook.ads.internal.util.C2489b.C2487a;
import com.facebook.ads.internal.util.C2490c;
import com.facebook.ads.internal.util.C2499h;

/* renamed from: com.facebook.ads.internal.f.g */
public class C2456g implements C2455i {
    private static final String f8468a;
    private C2257a f8469b;
    private C2422a f8470c;
    private C2329n f8471d;
    private C2331o f8472e;
    private long f8473f;
    private long f8474g;
    private C2487a f8475h;

    /* renamed from: com.facebook.ads.internal.f.g.1 */
    class C24531 implements C2318a {
        final /* synthetic */ InterstitialAdActivity f8465a;
        final /* synthetic */ C2456g f8466b;

        C24531(C2456g c2456g, InterstitialAdActivity interstitialAdActivity) {
            this.f8466b = c2456g;
            this.f8465a = interstitialAdActivity;
        }

        public void m9349a() {
            this.f8466b.f8472e.m8958c();
        }

        public void m9350a(int i) {
        }

        public void m9351a(String str) {
            Uri parse = Uri.parse(str);
            if ("fbad".equals(parse.getScheme()) && "close".equals(parse.getAuthority())) {
                this.f8465a.finish();
                return;
            }
            this.f8466b.f8469b.m8551a("com.facebook.ads.interstitial.clicked");
            C2295a a = C2296b.m8708a(this.f8465a, parse);
            if (a != null) {
                try {
                    this.f8466b.f8475h = a.m8705a();
                    this.f8466b.f8474g = System.currentTimeMillis();
                    a.m8707b();
                } catch (Throwable e) {
                    Log.e(C2456g.f8468a, "Error executing action", e);
                }
            }
        }

        public void m9352b() {
            this.f8466b.f8472e.m8719a();
        }
    }

    /* renamed from: com.facebook.ads.internal.f.g.2 */
    class C24542 extends C2268b {
        final /* synthetic */ C2456g f8467a;

        C24542(C2456g c2456g) {
            this.f8467a = c2456g;
        }

        public void m9353d() {
            this.f8467a.f8469b.m8551a("com.facebook.ads.interstitial.impression.logged");
        }
    }

    static {
        f8468a = C2456g.class.getSimpleName();
    }

    public C2456g(InterstitialAdActivity interstitialAdActivity, C2257a c2257a) {
        this.f8469b = c2257a;
        this.f8473f = System.currentTimeMillis();
        this.f8470c = new C2422a(interstitialAdActivity, new C24531(this, interstitialAdActivity), 1);
        this.f8470c.setId(100001);
        this.f8470c.setLayoutParams(new LayoutParams(-1, -1));
        this.f8472e = new C2331o(interstitialAdActivity, this.f8470c, new C24542(this));
        this.f8472e.m8959d();
        c2257a.m8550a(this.f8470c);
    }

    public void m9364a() {
        if (this.f8470c != null) {
            this.f8470c.onPause();
        }
    }

    public void m9365a(Intent intent, Bundle bundle) {
        if (bundle == null || !bundle.containsKey("dataModel")) {
            this.f8471d = C2329n.m8938b(intent);
            if (this.f8471d != null) {
                this.f8472e.m8956a(this.f8471d);
                this.f8470c.loadDataWithBaseURL(C2499h.m9489a(), this.f8471d.m8942a(), "text/html", "utf-8", null);
                this.f8470c.m9276a(this.f8471d.m8949g(), this.f8471d.m8950h());
                return;
            }
            return;
        }
        this.f8471d = C2329n.m8936a(bundle.getBundle("dataModel"));
        if (this.f8471d != null) {
            this.f8470c.loadDataWithBaseURL(C2499h.m9489a(), this.f8471d.m8942a(), "text/html", "utf-8", null);
            this.f8470c.m9276a(this.f8471d.m8949g(), this.f8471d.m8950h());
        }
    }

    public void m9366a(Bundle bundle) {
        if (this.f8471d != null) {
            bundle.putBundle("dataModel", this.f8471d.m8951i());
        }
    }

    public void m9367b() {
        if (!(this.f8474g <= 0 || this.f8475h == null || this.f8471d == null)) {
            C2490c.m9456a(C2489b.m9451a(this.f8474g, this.f8475h, this.f8471d.m8948f()));
        }
        if (this.f8470c != null) {
            this.f8470c.onResume();
        }
    }

    public void m9368c() {
        if (this.f8471d != null) {
            C2490c.m9456a(C2489b.m9451a(this.f8473f, C2487a.XOUT, this.f8471d.m8948f()));
        }
        if (this.f8470c != null) {
            C2499h.m9493a(this.f8470c);
            this.f8470c.destroy();
            this.f8470c = null;
        }
    }
}
