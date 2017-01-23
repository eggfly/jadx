package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSize;
import com.facebook.ads.internal.p121f.C2422a;
import com.facebook.ads.internal.p121f.C2422a.C2318a;
import com.facebook.ads.internal.p123a.C2295a;
import com.facebook.ads.internal.p123a.C2296b;
import com.facebook.ads.internal.p125c.C2348d;
import com.facebook.ads.internal.util.C2489b;
import com.facebook.ads.internal.util.C2489b.C2487a;
import com.facebook.ads.internal.util.C2490c;
import com.facebook.ads.internal.util.C2494f;
import com.facebook.ads.internal.util.C2494f.C2325a;
import com.facebook.ads.internal.util.C2499h;
import com.taobao.accs.common.Constants;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.adapters.j */
public class C2321j extends BannerAdapter {
    private static final String f8021a;
    private C2422a f8022b;
    private C2331o f8023c;
    private BannerAdapterListener f8024d;
    private Map<String, Object> f8025e;
    private Context f8026f;
    private long f8027g;
    private C2487a f8028h;

    /* renamed from: com.facebook.ads.internal.adapters.j.1 */
    class C23191 implements C2318a {
        final /* synthetic */ C2329n f8018a;
        final /* synthetic */ C2321j f8019b;

        C23191(C2321j c2321j, C2329n c2329n) {
            this.f8019b = c2321j;
            this.f8018a = c2329n;
        }

        public void m8829a() {
            this.f8019b.f8023c.m8958c();
        }

        public void m8830a(int i) {
            if (i == 0 && this.f8019b.f8027g > 0 && this.f8019b.f8028h != null) {
                C2490c.m9456a(C2489b.m9451a(this.f8019b.f8027g, this.f8019b.f8028h, this.f8018a.m8948f()));
                this.f8019b.f8027g = 0;
                this.f8019b.f8028h = null;
            }
        }

        public void m8831a(String str) {
            if (this.f8019b.f8024d != null) {
                this.f8019b.f8024d.onBannerAdClicked(this.f8019b);
            }
            C2295a a = C2296b.m8708a(this.f8019b.f8026f, Uri.parse(str));
            if (a != null) {
                try {
                    this.f8019b.f8028h = a.m8705a();
                    this.f8019b.f8027g = System.currentTimeMillis();
                    a.m8707b();
                } catch (Throwable e) {
                    Log.e(C2321j.f8021a, "Error executing action", e);
                }
            }
        }

        public void m8832b() {
            if (this.f8019b.f8023c != null) {
                this.f8019b.f8023c.m8719a();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.adapters.j.2 */
    class C23202 extends C2268b {
        final /* synthetic */ C2321j f8020a;

        C23202(C2321j c2321j) {
            this.f8020a = c2321j;
        }

        public void m8833d() {
            if (this.f8020a.f8024d != null) {
                this.f8020a.f8024d.onBannerLoggingImpression(this.f8020a);
            }
        }
    }

    static {
        f8021a = C2321j.class.getSimpleName();
    }

    private void m8838a(C2348d c2348d) {
        this.f8027g = 0;
        this.f8028h = null;
        C2329n a = C2329n.m8937a((JSONObject) this.f8025e.get(Constants.KEY_DATA));
        if (C2494f.m9466a(this.f8026f, (C2325a) a)) {
            this.f8024d.onBannerError(this, AdError.NO_FILL);
            return;
        }
        this.f8022b = new C2422a(this.f8026f, new C23191(this, a), c2348d.m9051e());
        this.f8022b.m9276a(c2348d.m9052f(), c2348d.m9053g());
        this.f8023c = new C2331o(this.f8026f, this.f8022b, new C23202(this));
        this.f8023c.m8956a(a);
        this.f8022b.loadDataWithBaseURL(C2499h.m9489a(), a.m8942a(), "text/html", "utf-8", null);
        if (this.f8024d != null) {
            this.f8024d.onBannerAdLoaded(this, this.f8022b);
        }
    }

    public void loadBannerAd(Context context, AdSize adSize, BannerAdapterListener bannerAdapterListener, Map<String, Object> map) {
        this.f8026f = context;
        this.f8024d = bannerAdapterListener;
        this.f8025e = map;
        m8838a((C2348d) map.get("definition"));
    }

    public void onDestroy() {
        if (this.f8022b != null) {
            C2499h.m9493a(this.f8022b);
            this.f8022b.destroy();
            this.f8022b = null;
        }
    }
}
