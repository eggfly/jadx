package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.facebook.ads.AdError;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAd.Image;
import com.facebook.ads.NativeAd.Rating;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.internal.extra.AdExtras;
import com.flurry.android.FlurryAgent;
import com.flurry.android.ads.FlurryAdErrorType;
import com.flurry.android.ads.FlurryAdNative;
import com.flurry.android.ads.FlurryAdNativeAsset;
import com.flurry.android.ads.FlurryAdNativeListener;
import com.taobao.accs.common.Constants;
import java.util.List;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.adapters.m */
public class C2328m extends C2307r {
    private static final String f8088a;
    private static volatile boolean f8089b;
    private C2288s f8090c;
    private FlurryAdNative f8091d;
    private boolean f8092e;
    private String f8093f;
    private String f8094g;
    private String f8095h;
    private String f8096i;
    private String f8097j;
    private Image f8098k;
    private Image f8099l;
    private Image f8100m;

    /* renamed from: com.facebook.ads.internal.adapters.m.1 */
    class C23271 implements FlurryAdNativeListener {
        final /* synthetic */ C2288s f8086a;
        final /* synthetic */ C2328m f8087b;

        C23271(C2328m c2328m, C2288s c2288s) {
            this.f8087b = c2328m;
            this.f8086a = c2288s;
        }

        public void onAppExit(FlurryAdNative flurryAdNative) {
        }

        public void onClicked(FlurryAdNative flurryAdNative) {
            this.f8086a.m8650c(this.f8087b);
        }

        public void onCloseFullscreen(FlurryAdNative flurryAdNative) {
        }

        public void onCollapsed(FlurryAdNative flurryAdNative) {
        }

        public void onError(FlurryAdNative flurryAdNative, FlurryAdErrorType flurryAdErrorType, int i) {
            Log.i(C2328m.f8088a, "error type: " + flurryAdErrorType.toString());
            Log.i(C2328m.f8088a, "ad native: " + flurryAdNative.toString());
            Log.i(C2328m.f8088a, "error code: " + i);
            this.f8087b.f8090c.m8648a(this.f8087b, AdError.NO_FILL);
        }

        public void onExpanded(FlurryAdNative flurryAdNative) {
        }

        public void onFetched(FlurryAdNative flurryAdNative) {
            Log.d(C2328m.f8088a, "Flurry ad Loaded");
            for (FlurryAdNativeAsset flurryAdNativeAsset : flurryAdNative.getAssetList()) {
                Log.d(C2328m.f8088a, flurryAdNativeAsset.getName() + " (" + flurryAdNativeAsset.getType().toString() + "): " + flurryAdNativeAsset.getValue());
            }
            this.f8087b.f8092e = true;
            FlurryAdNativeAsset flurryAdNativeAsset2 = flurryAdNative.getAsset("headline");
            if (flurryAdNativeAsset2 != null) {
                this.f8087b.f8093f = flurryAdNativeAsset2.getValue();
            }
            flurryAdNativeAsset2 = flurryAdNative.getAsset("summary");
            if (flurryAdNativeAsset2 != null) {
                this.f8087b.f8094g = flurryAdNativeAsset2.getValue();
            }
            flurryAdNativeAsset2 = flurryAdNative.getAsset(AgooConstants.MESSAGE_FROM_PKG);
            if (flurryAdNativeAsset2 != null) {
                this.f8087b.f8095h = flurryAdNativeAsset2.getValue();
            }
            flurryAdNativeAsset2 = flurryAdNative.getAsset("appCategory");
            if (flurryAdNativeAsset2 != null) {
                this.f8087b.f8097j = flurryAdNativeAsset2.getValue();
            }
            flurryAdNativeAsset2 = flurryAdNative.getAsset("callToAction");
            if (flurryAdNativeAsset2 != null) {
                this.f8087b.f8096i = flurryAdNativeAsset2.getValue();
            } else if (flurryAdNative.getAsset("appRating") != null) {
                this.f8087b.f8096i = "Install Now";
            } else {
                this.f8087b.f8096i = "Learn More";
            }
            flurryAdNativeAsset2 = flurryAdNative.getAsset("secImage");
            if (flurryAdNativeAsset2 != null) {
                this.f8087b.f8098k = new Image(flurryAdNativeAsset2.getValue(), 82, 82);
            }
            flurryAdNativeAsset2 = flurryAdNative.getAsset("secHqImage");
            if (flurryAdNativeAsset2 != null) {
                this.f8087b.f8099l = new Image(flurryAdNativeAsset2.getValue(), 1200, 627);
            }
            flurryAdNativeAsset2 = flurryAdNative.getAsset("secBrandingLogo");
            if (flurryAdNativeAsset2 != null) {
                this.f8087b.f8100m = new Image(flurryAdNativeAsset2.getValue(), 20, 20);
            }
            this.f8087b.f8090c.m8647a(this.f8087b);
        }

        public void onImpressionLogged(FlurryAdNative flurryAdNative) {
            this.f8086a.m8649b(this.f8087b);
        }

        public void onShowFullscreen(FlurryAdNative flurryAdNative) {
        }
    }

    static {
        f8088a = C2328m.class.getSimpleName();
    }

    public AdExtras m8903A() {
        return null;
    }

    public List<NativeAd> m8904B() {
        return null;
    }

    public void m8905a() {
        if (this.f8091d != null) {
            this.f8091d.removeTrackingView();
        }
    }

    public void m8906a(int i) {
    }

    public void m8907a(Context context, C2288s c2288s, Map<String, Object> map) {
        JSONObject jSONObject = (JSONObject) map.get(Constants.KEY_DATA);
        String optString = jSONObject.optString("api_key");
        String optString2 = jSONObject.optString("placement_id");
        synchronized (C2328m.class) {
            if (!f8089b) {
                Log.d(f8088a, "initializing flurry");
                f8089b = true;
                FlurryAgent.setLogEnabled(true);
                FlurryAgent.init(context, optString);
            }
        }
        this.f8090c = c2288s;
        this.f8091d = new FlurryAdNative(context, optString2);
        this.f8091d.setListener(new C23271(this, c2288s));
        this.f8091d.fetchAd();
    }

    public void m8908a(View view, List<View> list) {
        if (this.f8091d != null) {
            this.f8091d.setTrackingView(view);
        }
    }

    public void m8909a(Map<String, Object> map) {
    }

    public void m8910b(Map<String, Object> map) {
    }

    public boolean m8911b() {
        return this.f8092e;
    }

    public boolean m8912c() {
        return false;
    }

    public boolean m8913d() {
        return false;
    }

    public boolean m8914e() {
        return false;
    }

    public boolean m8915f() {
        return false;
    }

    public boolean m8916g() {
        return true;
    }

    public int m8917h() {
        return 0;
    }

    public int m8918i() {
        return 0;
    }

    public int m8919j() {
        return 0;
    }

    public Image m8920k() {
        return this.f8098k;
    }

    public Image m8921l() {
        return this.f8099l;
    }

    public NativeAdViewAttributes m8922m() {
        return null;
    }

    public String m8923n() {
        return this.f8093f;
    }

    public String m8924o() {
        return this.f8095h;
    }

    public void onDestroy() {
        m8905a();
        this.f8090c = null;
        if (this.f8091d != null) {
            this.f8091d.destroy();
            this.f8091d = null;
        }
    }

    public String m8925p() {
        return this.f8094g;
    }

    public String m8926q() {
        return this.f8096i;
    }

    public String m8927r() {
        return this.f8097j;
    }

    public Rating m8928s() {
        return null;
    }

    public Image m8929t() {
        return this.f8100m;
    }

    public String m8930u() {
        return null;
    }

    public String m8931v() {
        return "Ad";
    }

    public String m8932w() {
        return null;
    }

    public int m8933x() {
        return 0;
    }

    public String m8934y() {
        return null;
    }

    public String m8935z() {
        return null;
    }
}
