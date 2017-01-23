package com.facebook.ads;

import android.content.Context;
import android.view.View;
import com.facebook.ads.internal.C2253a;
import com.facebook.ads.internal.C2343b;
import com.facebook.ads.internal.C2353c;
import com.facebook.ads.internal.DisplayAdController;
import com.facebook.ads.internal.server.AdPlacementType;
import com.facebook.ads.internal.util.C2498g;

public class InterstitialAd implements Ad {
    private static final C2353c f7778a;
    private final Context f7779b;
    private final String f7780c;
    private DisplayAdController f7781d;
    private boolean f7782e;
    private boolean f7783f;
    private InterstitialAdListener f7784g;
    private ImpressionListener f7785h;

    /* renamed from: com.facebook.ads.InterstitialAd.1 */
    class C22551 extends C2253a {
        final /* synthetic */ InterstitialAd f7777a;

        C22551(InterstitialAd interstitialAd) {
            this.f7777a = interstitialAd;
        }

        public void m8537a() {
            this.f7777a.f7782e = true;
            if (this.f7777a.f7784g != null) {
                this.f7777a.f7784g.onAdLoaded(this.f7777a);
            }
        }

        public void m8538a(View view) {
        }

        public void m8539a(C2343b c2343b) {
            if (this.f7777a.f7784g != null) {
                this.f7777a.f7784g.onError(this.f7777a, c2343b.m9036b());
            }
        }

        public void m8540b() {
            if (this.f7777a.f7784g != null) {
                this.f7777a.f7784g.onAdClicked(this.f7777a);
            }
        }

        public void m8541c() {
            if (this.f7777a.f7785h != null) {
                this.f7777a.f7785h.onLoggingImpression(this.f7777a);
            }
            if ((this.f7777a.f7784g instanceof ImpressionListener) && this.f7777a.f7784g != this.f7777a.f7785h) {
                ((ImpressionListener) this.f7777a.f7784g).onLoggingImpression(this.f7777a);
            }
        }

        public void m8542d() {
            if (this.f7777a.f7784g != null) {
                this.f7777a.f7784g.onInterstitialDisplayed(this.f7777a);
            }
        }

        public void m8543e() {
            this.f7777a.f7783f = false;
            if (this.f7777a.f7781d != null) {
                this.f7777a.f7781d.m8700d();
                this.f7777a.f7781d = null;
            }
            if (this.f7777a.f7784g != null) {
                this.f7777a.f7784g.onInterstitialDismissed(this.f7777a);
            }
        }
    }

    static {
        f7778a = C2353c.ADS;
    }

    public InterstitialAd(Context context, String str) {
        this.f7779b = context;
        this.f7780c = str;
    }

    public void destroy() {
        if (this.f7781d != null) {
            this.f7781d.m8700d();
            this.f7781d = null;
        }
    }

    public String getPlacementId() {
        return this.f7780c;
    }

    public boolean isAdLoaded() {
        return this.f7782e;
    }

    public void loadAd() {
        this.f7782e = false;
        if (this.f7783f) {
            throw new IllegalStateException("InterstitialAd cannot be loaded while being displayed. Make sure your adapter calls adapterListener.onInterstitialDismissed().");
        }
        if (this.f7781d != null) {
            this.f7781d.m8700d();
            this.f7781d = null;
        }
        AdSize adSize = AdSize.INTERSTITIAL;
        this.f7781d = new DisplayAdController(this.f7779b, this.f7780c, C2498g.m9468a(AdSize.INTERSTITIAL), AdPlacementType.INTERSTITIAL, adSize, f7778a, 1, true);
        this.f7781d.m8695a(new C22551(this));
        this.f7781d.m8698b();
    }

    public void setAdListener(InterstitialAdListener interstitialAdListener) {
        this.f7784g = interstitialAdListener;
    }

    @Deprecated
    public void setImpressionListener(ImpressionListener impressionListener) {
        this.f7785h = impressionListener;
    }

    public boolean show() {
        if (this.f7782e) {
            this.f7781d.m8699c();
            this.f7783f = true;
            this.f7782e = false;
            return true;
        } else if (this.f7784g == null) {
            return false;
        } else {
            this.f7784g.onError(this, AdError.INTERNAL_ERROR);
            return false;
        }
    }
}
