package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import com.facebook.ads.AdError;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAd.Image;
import com.facebook.ads.NativeAd.Rating;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.internal.extra.AdExtras;
import com.facebook.ads.internal.p123a.C2295a;
import com.facebook.ads.internal.p123a.C2296b;
import com.facebook.ads.internal.util.C2489b;
import com.facebook.ads.internal.util.C2489b.C2487a;
import com.facebook.ads.internal.util.C2490c;
import com.facebook.ads.internal.util.C2493e;
import com.facebook.ads.internal.util.C2494f;
import com.facebook.ads.internal.util.C2494f.C2325a;
import com.facebook.ads.internal.util.C2498g;
import com.facebook.ads.internal.util.C2507o;
import com.igexin.download.Downloads;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.C4156a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.adapters.l */
public class C2326l extends C2307r implements C2325a {
    private static final String f8043a;
    private String f8044A;
    private int f8045B;
    private String f8046C;
    private String f8047D;
    private Image f8048E;
    private String f8049F;
    private String f8050G;
    private AdExtras f8051H;
    private NativeAdViewAttributes f8052I;
    private List<NativeAd> f8053J;
    private boolean f8054K;
    private boolean f8055L;
    private boolean f8056M;
    private boolean f8057N;
    private boolean f8058O;
    private long f8059P;
    private C2487a f8060Q;
    private Context f8061b;
    private C2288s f8062c;
    private Uri f8063d;
    private String f8064e;
    private String f8065f;
    private String f8066g;
    private String f8067h;
    private String f8068i;
    private Image f8069j;
    private Image f8070k;
    private Rating f8071l;
    private String f8072m;
    private String f8073n;
    private String f8074o;
    private String f8075p;
    private C2493e f8076q;
    private String f8077r;
    private Collection<String> f8078s;
    private boolean f8079t;
    private boolean f8080u;
    private boolean f8081v;
    private int f8082w;
    private int f8083x;
    private int f8084y;
    private int f8085z;

    /* renamed from: com.facebook.ads.internal.adapters.l.1 */
    class C23241 implements Runnable {
        final /* synthetic */ Map f8040a;
        final /* synthetic */ Map f8041b;
        final /* synthetic */ C2326l f8042c;

        C23241(C2326l c2326l, Map map, Map map2) {
            this.f8042c = c2326l;
            this.f8040a = map;
            this.f8041b = map2;
        }

        public void run() {
            new C2507o(this.f8040a, this.f8041b).execute(new String[]{this.f8042c.f8073n});
        }
    }

    static {
        f8043a = C2326l.class.getSimpleName();
    }

    public C2326l() {
        this.f8059P = 0;
        this.f8060Q = null;
    }

    private boolean m8848F() {
        return this.f8064e != null && this.f8064e.length() > 0 && this.f8067h != null && this.f8067h.length() > 0 && ((this.f8069j != null || this.f8054K) && this.f8070k != null);
    }

    private void m8849G() {
        if (!this.f8058O) {
            new C2507o().execute(new String[]{this.f8075p});
            this.f8058O = true;
        }
    }

    private void m8851a(Context context, JSONObject jSONObject) {
        this.f8061b = context;
        this.f8054K = true;
        m8865a(jSONObject);
    }

    private void m8852a(String str, Map<String, String> map, Map<String, Object> map2) {
        if (map2.containsKey(str)) {
            map.put(str, String.valueOf(map2.get(str)));
        }
    }

    private void m8853a(Map<String, String> map, Map<String, Object> map2) {
        m8852a("nti", (Map) map, (Map) map2);
        m8852a("nhs", (Map) map, (Map) map2);
        m8852a("nmv", (Map) map, (Map) map2);
    }

    private Map<String, String> m8854c(Map<String, Object> map) {
        Map<String, String> hashMap = new HashMap();
        if (map.containsKey("view")) {
            hashMap.put("view", String.valueOf(map.get("view")));
        }
        if (map.containsKey("snapshot")) {
            hashMap.put("snapshot", String.valueOf(map.get("snapshot")));
        }
        return hashMap;
    }

    public AdExtras m8855A() {
        return !m8867b() ? null : this.f8051H;
    }

    public List<NativeAd> m8856B() {
        return !m8867b() ? null : this.f8053J;
    }

    public C2493e m8857C() {
        return this.f8076q;
    }

    public String m8858D() {
        return this.f8077r;
    }

    public Collection<String> m8859E() {
        return this.f8078s;
    }

    public void m8860a() {
    }

    public void m8861a(int i) {
        if (m8867b() && i == 0 && this.f8059P > 0 && this.f8060Q != null) {
            C2490c.m9456a(C2489b.m9451a(this.f8059P, this.f8060Q, this.f8050G));
            this.f8059P = 0;
            this.f8060Q = null;
        }
    }

    public void m8862a(Context context, C2288s c2288s, Map<String, Object> map) {
        this.f8061b = context;
        this.f8062c = c2288s;
        m8865a((JSONObject) map.get(Constants.KEY_DATA));
        if (C2494f.m9466a(context, (C2325a) this)) {
            c2288s.m8648a(this, AdError.NO_FILL);
            return;
        }
        if (c2288s != null) {
            c2288s.m8647a(this);
        }
        C2489b.f8566a = this.f8050G;
    }

    public void m8863a(View view, List<View> list) {
    }

    public void m8864a(Map<String, Object> map) {
        if (m8867b() && !this.f8057N) {
            if (this.f8062c != null) {
                this.f8062c.m8649b(this);
            }
            Map hashMap = new HashMap();
            if (map != null) {
                m8852a("mil", hashMap, (Map) map);
                m8853a(hashMap, (Map) map);
            }
            new C2507o(hashMap).execute(new String[]{this.f8072m});
            if (m8870e() || m8869d()) {
                try {
                    new Handler().postDelayed(new C23241(this, hashMap, m8854c(map)), (long) (this.f8082w * AdError.NETWORK_ERROR_CODE));
                } catch (Exception e) {
                }
            }
            this.f8057N = true;
        }
    }

    public void m8865a(JSONObject jSONObject) {
        JSONArray jSONArray = null;
        if (this.f8055L) {
            throw new IllegalStateException("Adapter already loaded data");
        } else if (jSONObject != null) {
            this.f8063d = Uri.parse(jSONObject.optString("fbad_command"));
            this.f8064e = jSONObject.optString(Downloads.COLUMN_TITLE);
            this.f8065f = jSONObject.optString("subtitle");
            this.f8066g = jSONObject.optString(C4156a.f13961w);
            this.f8067h = jSONObject.optString("call_to_action");
            this.f8068i = jSONObject.optString("social_context");
            this.f8069j = Image.fromJSONObject(jSONObject.optJSONObject("icon"));
            this.f8070k = Image.fromJSONObject(jSONObject.optJSONObject("image"));
            this.f8071l = Rating.fromJSONObject(jSONObject.optJSONObject("star_rating"));
            this.f8072m = jSONObject.optString("impression_report_url");
            this.f8073n = jSONObject.optString("native_view_report_url");
            this.f8074o = jSONObject.optString("click_report_url");
            this.f8075p = jSONObject.optString("used_report_url");
            this.f8051H = new AdExtras().setIsOrganic(jSONObject.optBoolean("is_organic", false));
            this.f8079t = jSONObject.optBoolean("manual_imp");
            this.f8080u = jSONObject.optBoolean("enable_view_log");
            this.f8081v = jSONObject.optBoolean("enable_snapshot_log");
            this.f8082w = jSONObject.optInt("snapshot_log_delay_second", 4);
            this.f8083x = jSONObject.optInt("snapshot_compress_quality", 0);
            this.f8084y = jSONObject.optInt("viewability_check_initial_delay", 0);
            this.f8085z = jSONObject.optInt("viewability_check_interval", AdError.NETWORK_ERROR_CODE);
            JSONObject optJSONObject = jSONObject.optJSONObject("ad_choices_icon");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("native_ui_config");
            this.f8052I = optJSONObject2 == null ? null : new NativeAdViewAttributes(optJSONObject2);
            if (optJSONObject != null) {
                this.f8048E = Image.fromJSONObject(optJSONObject);
            }
            this.f8049F = jSONObject.optString("ad_choices_link_url");
            this.f8050G = jSONObject.optString("request_id");
            this.f8076q = C2493e.m9464a(jSONObject.optString("invalidation_behavior"));
            this.f8077r = jSONObject.optString("invalidation_report_url");
            try {
                jSONArray = new JSONArray(jSONObject.optString("detection_strings"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.f8078s = C2494f.m9465a(jSONArray);
            this.f8044A = jSONObject.optString("video_url");
            this.f8045B = jSONObject.optInt("video_play_report_seconds", 10) * AdError.NETWORK_ERROR_CODE;
            this.f8046C = jSONObject.optString("video_play_report_url");
            this.f8047D = jSONObject.optString("video_time_report_url");
            try {
                jSONArray = jSONObject.optJSONArray("carousel");
                if (jSONArray != null && jSONArray.length() > 0) {
                    List arrayList = new ArrayList(jSONArray.length());
                    for (int i = 0; i < jSONArray.length(); i++) {
                        C2307r c2326l = new C2326l();
                        c2326l.m8851a(this.f8061b, jSONArray.getJSONObject(i));
                        arrayList.add(new NativeAd(this.f8061b, c2326l, null));
                    }
                    this.f8053J = arrayList;
                }
            } catch (Throwable e2) {
                Log.e(f8043a, "Unable to parse carousel data.", e2);
            }
            this.f8055L = true;
            this.f8056M = m8848F();
        }
    }

    public void m8866b(Map<String, Object> map) {
        if (m8867b()) {
            Map hashMap = new HashMap();
            if (map != null) {
                m8852a("mil", hashMap, (Map) map);
                m8853a(hashMap, (Map) map);
                hashMap.put("touch", C2498g.m9472a((Map) map));
            }
            new C2507o(hashMap).execute(new String[]{this.f8074o});
            C2498g.m9477a(this.f8061b, "Click logged");
            if (this.f8062c != null) {
                this.f8062c.m8650c(this);
            }
            C2295a a = C2296b.m8708a(this.f8061b, this.f8063d);
            if (a != null) {
                try {
                    this.f8059P = System.currentTimeMillis();
                    this.f8060Q = a.m8705a();
                    a.m8707b();
                } catch (Throwable e) {
                    Log.e(f8043a, "Error executing action", e);
                }
            }
        }
    }

    public boolean m8867b() {
        return this.f8055L && this.f8056M;
    }

    public boolean m8868c() {
        return m8867b() && this.f8079t;
    }

    public boolean m8869d() {
        return m8867b() && this.f8081v;
    }

    public boolean m8870e() {
        return m8867b() && this.f8080u;
    }

    public boolean m8871f() {
        return m8867b() && this.f8052I != null;
    }

    public boolean m8872g() {
        return true;
    }

    public int m8873h() {
        return (this.f8083x < 0 || this.f8083x > 100) ? 0 : this.f8083x;
    }

    public int m8874i() {
        return this.f8084y;
    }

    public int m8875j() {
        return this.f8085z;
    }

    public Image m8876k() {
        return !m8867b() ? null : this.f8069j;
    }

    public Image m8877l() {
        return !m8867b() ? null : this.f8070k;
    }

    public NativeAdViewAttributes m8878m() {
        return !m8867b() ? null : this.f8052I;
    }

    public String m8879n() {
        if (!m8867b()) {
            return null;
        }
        m8849G();
        return this.f8064e;
    }

    public String m8880o() {
        if (!m8867b()) {
            return null;
        }
        m8849G();
        return this.f8065f;
    }

    public void onDestroy() {
    }

    public String m8881p() {
        if (!m8867b()) {
            return null;
        }
        m8849G();
        return this.f8066g;
    }

    public String m8882q() {
        if (!m8867b()) {
            return null;
        }
        m8849G();
        return this.f8067h;
    }

    public String m8883r() {
        if (!m8867b()) {
            return null;
        }
        m8849G();
        return this.f8068i;
    }

    public Rating m8884s() {
        if (!m8867b()) {
            return null;
        }
        m8849G();
        return this.f8071l;
    }

    public Image m8885t() {
        return !m8867b() ? null : this.f8048E;
    }

    public String m8886u() {
        return !m8867b() ? null : this.f8049F;
    }

    public String m8887v() {
        return !m8867b() ? null : "AdChoices";
    }

    public String m8888w() {
        return !m8867b() ? null : this.f8044A;
    }

    public int m8889x() {
        return this.f8045B;
    }

    public String m8890y() {
        return !m8867b() ? null : this.f8046C;
    }

    public String m8891z() {
        return !m8867b() ? null : this.f8047D;
    }
}
