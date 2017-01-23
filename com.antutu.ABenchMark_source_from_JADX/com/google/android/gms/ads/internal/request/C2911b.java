package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel.C2904a;
import com.google.android.gms.ads.internal.request.C2906a.C2731a;
import com.google.android.gms.ads.internal.request.C2914c.C2910a;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.p146b.C3326k;
import com.google.android.gms.p146b.aq;
import com.google.android.gms.p146b.dl;
import com.google.android.gms.p146b.gb;
import com.google.android.gms.p146b.gx.C3232a;
import com.google.android.gms.p146b.he;
import com.google.android.gms.p146b.hi;
import com.google.android.gms.p146b.hj;
import com.google.android.gms.p146b.hl;
import com.google.android.gms.p146b.ib;
import com.google.android.gms.p146b.ic;
import org.json.JSONException;
import org.json.JSONObject;

@gb
/* renamed from: com.google.android.gms.ads.internal.request.b */
public class C2911b extends he implements C2910a {
    hl f9928a;
    AdResponseParcel f9929b;
    dl f9930c;
    private final C2731a f9931d;
    private final C2904a f9932e;
    private final Object f9933f;
    private final Context f9934g;
    private final C3326k f9935h;
    private AdRequestInfoParcel f9936i;
    private Runnable f9937j;

    /* renamed from: com.google.android.gms.ads.internal.request.b.1 */
    class C29071 implements Runnable {
        final /* synthetic */ C2911b f9924a;

        C29071(C2911b c2911b) {
            this.f9924a = c2911b;
        }

        public void run() {
            synchronized (this.f9924a.f9933f) {
                if (this.f9924a.f9928a == null) {
                    return;
                }
                this.f9924a.m11314b();
                this.f9924a.m11306a(2, "Timed out waiting for ad response.");
            }
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.request.b.2 */
    class C29082 implements Runnable {
        final /* synthetic */ ib f9925a;
        final /* synthetic */ C2911b f9926b;

        C29082(C2911b c2911b, ib ibVar) {
            this.f9926b = c2911b;
            this.f9925a = ibVar;
        }

        public void run() {
            synchronized (this.f9926b.f9933f) {
                this.f9926b.f9928a = this.f9926b.m11311a(this.f9926b.f9932e.f9827j, this.f9925a);
                if (this.f9926b.f9928a == null) {
                    this.f9926b.m11306a(0, "Could not start the ad request service.");
                    hj.f11297a.removeCallbacks(this.f9926b.f9937j);
                }
            }
        }
    }

    @gb
    /* renamed from: com.google.android.gms.ads.internal.request.b.a */
    static final class C2909a extends Exception {
        private final int f9927a;

        public C2909a(String str, int i) {
            super(str);
            this.f9927a = i;
        }

        public int m11303a() {
            return this.f9927a;
        }
    }

    public C2911b(Context context, C2904a c2904a, C3326k c3326k, C2731a c2731a) {
        this.f9933f = new Object();
        this.f9931d = c2731a;
        this.f9934g = context;
        this.f9932e = c2904a;
        this.f9935h = c3326k;
    }

    private void m11306a(int i, String str) {
        if (i == 3 || i == -1) {
            C2972b.m11581c(str);
        } else {
            C2972b.m11583d(str);
        }
        if (this.f9929b == null) {
            this.f9929b = new AdResponseParcel(i);
        } else {
            this.f9929b = new AdResponseParcel(i, this.f9929b.f9895k);
        }
        this.f9931d.m10417a(new C3232a(this.f9936i != null ? this.f9936i : new AdRequestInfoParcel(this.f9932e, null, -1), this.f9929b, this.f9930c, null, i, -1, this.f9929b.f9898n, null));
    }

    protected AdSizeParcel m11310a(AdRequestInfoParcel adRequestInfoParcel) {
        if (this.f9929b.f9897m == null) {
            throw new C2909a("The ad response must specify one of the supported ad sizes.", 0);
        }
        String[] split = this.f9929b.f9897m.split("x");
        if (split.length != 2) {
            throw new C2909a("Invalid ad size format from the ad response: " + this.f9929b.f9897m, 0);
        }
        try {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            for (AdSizeParcel adSizeParcel : adRequestInfoParcel.f9854d.f9332h) {
                float f = this.f9934g.getResources().getDisplayMetrics().density;
                int i = adSizeParcel.f9330f == -1 ? (int) (((float) adSizeParcel.f9331g) / f) : adSizeParcel.f9330f;
                int i2 = adSizeParcel.f9327c == -2 ? (int) (((float) adSizeParcel.f9328d) / f) : adSizeParcel.f9327c;
                if (parseInt == i && parseInt2 == i2) {
                    return new AdSizeParcel(adSizeParcel, adRequestInfoParcel.f9854d.f9332h);
                }
            }
            throw new C2909a("The ad size from the ad response was not one of the requested sizes: " + this.f9929b.f9897m, 0);
        } catch (NumberFormatException e) {
            throw new C2909a("Invalid ad size number from the ad response: " + this.f9929b.f9897m, 0);
        }
    }

    hl m11311a(VersionInfoParcel versionInfoParcel, ib<AdRequestInfoParcel> ibVar) {
        return C2914c.m11318a(this.f9934g, versionInfoParcel, ibVar, this);
    }

    public void m11312a() {
        C2972b.m11576a("AdLoaderBackgroundTask started.");
        this.f9937j = new C29071(this);
        hj.f11297a.postDelayed(this.f9937j, ((Long) aq.ax.m11794c()).longValue());
        ib icVar = new ic();
        long b = C2968s.m11529i().m13544b();
        hi.m13004a(new C29082(this, icVar));
        this.f9936i = new AdRequestInfoParcel(this.f9932e, this.f9935h.m13586a().m10932a(this.f9934g), b);
        icVar.m12250a(this.f9936i);
    }

    public void m11313a(AdResponseParcel adResponseParcel) {
        C2972b.m11576a("Received ad response.");
        this.f9929b = adResponseParcel;
        long b = C2968s.m11529i().m13544b();
        synchronized (this.f9933f) {
            this.f9928a = null;
        }
        try {
            if (this.f9929b.f9889e == -2 || this.f9929b.f9889e == -3) {
                JSONObject jSONObject;
                m11315c();
                AdSizeParcel a = this.f9936i.f9854d.f9332h != null ? m11310a(this.f9936i) : null;
                C2968s.m11528h().m12943a(this.f9929b.f9906v);
                if (!TextUtils.isEmpty(this.f9929b.f9902r)) {
                    try {
                        jSONObject = new JSONObject(this.f9929b.f9902r);
                    } catch (Throwable e) {
                        C2972b.m11580b("Error parsing the JSON for Active View.", e);
                    }
                    this.f9931d.m10417a(new C3232a(this.f9936i, this.f9929b, this.f9930c, a, -2, b, this.f9929b.f9898n, jSONObject));
                    hj.f11297a.removeCallbacks(this.f9937j);
                    return;
                }
                jSONObject = null;
                this.f9931d.m10417a(new C3232a(this.f9936i, this.f9929b, this.f9930c, a, -2, b, this.f9929b.f9898n, jSONObject));
                hj.f11297a.removeCallbacks(this.f9937j);
                return;
            }
            throw new C2909a("There was a problem getting an ad response. ErrorCode: " + this.f9929b.f9889e, this.f9929b.f9889e);
        } catch (C2909a e2) {
            m11306a(e2.m11303a(), e2.getMessage());
            hj.f11297a.removeCallbacks(this.f9937j);
        }
    }

    public void m11314b() {
        synchronized (this.f9933f) {
            if (this.f9928a != null) {
                this.f9928a.m10968d();
            }
        }
    }

    protected void m11315c() {
        if (this.f9929b.f9889e != -3) {
            if (TextUtils.isEmpty(this.f9929b.f9887c)) {
                throw new C2909a("No fill from ad server.", 3);
            }
            C2968s.m11528h().m12933a(this.f9934g, this.f9929b.f9905u);
            if (this.f9929b.f9892h) {
                try {
                    this.f9930c = new dl(this.f9929b.f9887c);
                } catch (JSONException e) {
                    throw new C2909a("Could not parse mediation config: " + this.f9929b.f9887c, 0);
                }
            }
        }
    }
}
