package com.facebook.ads;

import android.content.Context;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.C2253a;
import com.facebook.ads.internal.C2343b;
import com.facebook.ads.internal.C2353c;
import com.facebook.ads.internal.DisplayAdController;
import com.facebook.ads.internal.p121f.C2422a;
import com.facebook.ads.internal.server.AdPlacementType;
import com.facebook.ads.internal.util.C2498g;

public class AdView extends RelativeLayout implements Ad {
    private static final C2353c f7768a;
    private final DisplayMetrics f7769b;
    private final AdSize f7770c;
    private final String f7771d;
    private DisplayAdController f7772e;
    private AdListener f7773f;
    private ImpressionListener f7774g;
    private View f7775h;
    private volatile boolean f7776i;

    /* renamed from: com.facebook.ads.AdView.1 */
    class C22541 extends C2253a {
        final /* synthetic */ AdView f7767a;

        C22541(AdView adView) {
            this.f7767a = adView;
        }

        public void m8525a() {
            if (this.f7767a.f7772e != null) {
                this.f7767a.f7772e.m8699c();
            }
        }

        public void m8526a(View view) {
            if (view == null) {
                throw new IllegalStateException("Cannot present null view");
            }
            this.f7767a.f7775h = view;
            this.f7767a.removeAllViews();
            this.f7767a.addView(this.f7767a.f7775h);
            if (this.f7767a.f7775h instanceof C2422a) {
                C2498g.m9478a(this.f7767a.f7769b, this.f7767a.f7775h, this.f7767a.f7770c);
            }
            if (this.f7767a.f7773f != null) {
                this.f7767a.f7773f.onAdLoaded(this.f7767a);
            }
        }

        public void m8527a(C2343b c2343b) {
            if (this.f7767a.f7773f != null) {
                this.f7767a.f7773f.onError(this.f7767a, c2343b.m9036b());
            }
        }

        public void m8528b() {
            if (this.f7767a.f7773f != null) {
                this.f7767a.f7773f.onAdClicked(this.f7767a);
            }
        }

        public void m8529c() {
            if (this.f7767a.f7774g != null) {
                this.f7767a.f7774g.onLoggingImpression(this.f7767a);
            }
            if ((this.f7767a.f7773f instanceof ImpressionListener) && this.f7767a.f7773f != this.f7767a.f7774g) {
                ((ImpressionListener) this.f7767a.f7773f).onLoggingImpression(this.f7767a);
            }
        }
    }

    static {
        f7768a = C2353c.ADS;
    }

    public AdView(Context context, String str, AdSize adSize) {
        super(context);
        if (adSize == null || adSize == AdSize.INTERSTITIAL) {
            throw new IllegalArgumentException("adSize");
        }
        this.f7769b = getContext().getResources().getDisplayMetrics();
        this.f7770c = adSize;
        this.f7771d = str;
        this.f7772e = new DisplayAdController(context, str, C2498g.m9468a(adSize), AdPlacementType.BANNER, adSize, f7768a, 1, false);
        this.f7772e.m8695a(new C22541(this));
    }

    public void destroy() {
        if (this.f7772e != null) {
            this.f7772e.m8700d();
            this.f7772e = null;
        }
        removeAllViews();
        this.f7775h = null;
    }

    public void disableAutoRefresh() {
        if (this.f7772e != null) {
            this.f7772e.m8704h();
        }
    }

    public String getPlacementId() {
        return this.f7771d;
    }

    public void loadAd() {
        if (!this.f7776i) {
            this.f7772e.m8698b();
            this.f7776i = true;
        } else if (this.f7772e != null) {
            this.f7772e.m8703g();
        }
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f7775h != null) {
            C2498g.m9478a(this.f7769b, this.f7775h, this.f7770c);
        }
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.f7772e != null) {
            if (i == 0) {
                this.f7772e.m8702f();
            } else if (i == 8) {
                this.f7772e.m8701e();
            }
        }
    }

    public void setAdListener(AdListener adListener) {
        this.f7773f = adListener;
    }

    @Deprecated
    public void setImpressionListener(ImpressionListener impressionListener) {
        this.f7774g = impressionListener;
    }
}
