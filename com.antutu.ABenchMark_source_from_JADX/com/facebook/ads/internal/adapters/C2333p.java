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
import com.igexin.download.Downloads;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiNative;
import com.inmobi.ads.InMobiNative.NativeAdListener;
import com.inmobi.sdk.InMobiSdk;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.adapters.p */
public class C2333p extends C2307r {
    private static final String f8117a;
    private static final Long f8118b;
    private C2288s f8119c;
    private InMobiNative f8120d;
    private boolean f8121e;
    private View f8122f;
    private String f8123g;
    private String f8124h;
    private String f8125i;
    private Rating f8126j;
    private Image f8127k;
    private Image f8128l;

    /* renamed from: com.facebook.ads.internal.adapters.p.1 */
    class C23321 implements NativeAdListener {
        final /* synthetic */ C2333p f8116a;

        C23321(C2333p c2333p) {
            this.f8116a = c2333p;
        }

        public void onAdDismissed(InMobiNative inMobiNative) {
        }

        public void onAdDisplayed(InMobiNative inMobiNative) {
            this.f8116a.f8119c.m8649b(this.f8116a);
        }

        public void onAdLoadFailed(InMobiNative inMobiNative, InMobiAdRequestStatus inMobiAdRequestStatus) {
            Log.d(C2333p.f8117a, "load failed");
            this.f8116a.f8119c.m8648a(this.f8116a, AdError.NO_FILL);
        }

        public void onAdLoadSucceeded(InMobiNative inMobiNative) {
            Log.d(C2333p.f8117a, "load success");
            try {
                JSONObject jSONObject = new JSONObject((String) inMobiNative.getAdContent());
                this.f8116a.f8123g = jSONObject.optString(Downloads.COLUMN_TITLE);
                this.f8116a.f8124h = jSONObject.optString(Downloads.COLUMN_DESCRIPTION);
                this.f8116a.f8125i = jSONObject.optString("cta");
                JSONObject optJSONObject = jSONObject.optJSONObject("icon");
                int optInt = optJSONObject.optInt("width");
                int optInt2 = optJSONObject.optInt("height");
                this.f8116a.f8127k = new Image(optJSONObject.optString("url"), optInt, optInt2);
                optJSONObject = jSONObject.optJSONObject("screenshots");
                optInt = optJSONObject.optInt("width");
                optInt2 = optJSONObject.optInt("height");
                this.f8116a.f8128l = new Image(optJSONObject.optString("url"), optInt, optInt2);
                try {
                    this.f8116a.f8126j = new Rating(Double.parseDouble(jSONObject.optString("rating")), 5.0d);
                } catch (Exception e) {
                }
                this.f8116a.f8121e = true;
                if (this.f8116a.f8122f != null) {
                    this.f8116a.f8120d;
                    InMobiNative.bind(this.f8116a.f8122f, inMobiNative);
                }
                this.f8116a.f8119c.m8647a(this.f8116a);
            } catch (JSONException e2) {
                this.f8116a.f8119c.m8648a(this.f8116a, AdError.INTERNAL_ERROR);
            }
        }

        public void onUserLeftApplication(InMobiNative inMobiNative) {
        }
    }

    static {
        f8117a = C2333p.class.getSimpleName();
        f8118b = Long.valueOf(1449842381437L);
    }

    public AdExtras m8971A() {
        return null;
    }

    public List<NativeAd> m8972B() {
        return null;
    }

    public void m8973a() {
        if (m8979b()) {
            InMobiNative inMobiNative = this.f8120d;
            InMobiNative.unbind(this.f8122f);
        }
        this.f8122f = null;
    }

    public void m8974a(int i) {
    }

    public void m8975a(Context context, C2288s c2288s, Map<String, Object> map) {
        Log.d(f8117a, "loading");
        this.f8119c = c2288s;
        InMobiSdk.init(context, "48a89ae0099a4d1ba71359c5e5e81323");
        this.f8120d = new InMobiNative(f8118b.longValue(), new C23321(this));
        this.f8120d.load();
    }

    public void m8976a(View view, List<View> list) {
        this.f8122f = view;
        if (m8979b()) {
            InMobiNative inMobiNative = this.f8120d;
            InMobiNative.bind(this.f8122f, this.f8120d);
        }
    }

    public void m8977a(Map<String, Object> map) {
    }

    public void m8978b(Map<String, Object> map) {
        if (m8979b()) {
            this.f8119c.m8650c(this);
            this.f8120d.reportAdClickAndOpenLandingPage(null);
        }
    }

    public boolean m8979b() {
        return this.f8120d != null && this.f8121e;
    }

    public boolean m8980c() {
        return false;
    }

    public boolean m8981d() {
        return false;
    }

    public boolean m8982e() {
        return false;
    }

    public boolean m8983f() {
        return false;
    }

    public boolean m8984g() {
        return true;
    }

    public int m8985h() {
        return 0;
    }

    public int m8986i() {
        return 0;
    }

    public int m8987j() {
        return 0;
    }

    public Image m8988k() {
        return this.f8127k;
    }

    public Image m8989l() {
        return this.f8128l;
    }

    public NativeAdViewAttributes m8990m() {
        return null;
    }

    public String m8991n() {
        return this.f8123g;
    }

    public String m8992o() {
        return null;
    }

    public void onDestroy() {
        m8973a();
        this.f8120d = null;
    }

    public String m8993p() {
        return this.f8124h;
    }

    public String m8994q() {
        return this.f8125i;
    }

    public String m8995r() {
        return null;
    }

    public Rating m8996s() {
        return null;
    }

    public Image m8997t() {
        return null;
    }

    public String m8998u() {
        return null;
    }

    public String m8999v() {
        return "Ad";
    }

    public String m9000w() {
        return null;
    }

    public int m9001x() {
        return 0;
    }

    public String m9002y() {
        return null;
    }

    public String m9003z() {
        return null;
    }
}
