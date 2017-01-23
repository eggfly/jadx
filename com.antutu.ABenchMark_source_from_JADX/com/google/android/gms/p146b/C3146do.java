package com.google.android.gms.p146b;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.p124b.C2704b;
import com.google.android.gms.ads.p124b.C2704b.C2703a;
import com.google.android.gms.p146b.dp.C3145a;
import com.google.android.gms.p146b.dy.C3143a;
import com.google.android.gms.p151a.C2690b;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@gb
/* renamed from: com.google.android.gms.b.do */
public final class C3146do implements C3145a {
    private final String f10669a;
    private final du f10670b;
    private final long f10671c;
    private final dl f10672d;
    private final dk f10673e;
    private final AdRequestParcel f10674f;
    private final AdSizeParcel f10675g;
    private final Context f10676h;
    private final Object f10677i;
    private final VersionInfoParcel f10678j;
    private final boolean f10679k;
    private final NativeAdOptionsParcel f10680l;
    private final List<String> f10681m;
    private final boolean f10682n;
    private dv f10683o;
    private int f10684p;
    private dy f10685q;

    /* renamed from: com.google.android.gms.b.do.1 */
    class C31421 implements Runnable {
        final /* synthetic */ dn f10666a;
        final /* synthetic */ C3146do f10667b;

        C31421(C3146do c3146do, dn dnVar) {
            this.f10667b = c3146do;
            this.f10666a = dnVar;
        }

        public void run() {
            synchronized (this.f10667b.f10677i) {
                if (this.f10667b.f10684p != -2) {
                    return;
                }
                this.f10667b.f10683o = this.f10667b.m12332d();
                if (this.f10667b.f10683o == null) {
                    this.f10667b.m12340a(4);
                } else if (!this.f10667b.m12334e() || this.f10667b.m12327b(1)) {
                    this.f10666a.m12305a(this.f10667b);
                    this.f10667b.m12320a(this.f10666a);
                } else {
                    C2972b.m11583d("Ignoring adapter " + this.f10667b.f10669a + " as delayed" + " impression is not supported");
                    this.f10667b.m12340a(2);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.b.do.2 */
    static class C31442 extends C3143a {
        final /* synthetic */ int f10668a;

        C31442(int i) {
            this.f10668a = i;
        }

        public int m12313a() {
            return this.f10668a;
        }
    }

    public C3146do(Context context, String str, du duVar, dl dlVar, dk dkVar, AdRequestParcel adRequestParcel, AdSizeParcel adSizeParcel, VersionInfoParcel versionInfoParcel, boolean z, boolean z2, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list) {
        this.f10677i = new Object();
        this.f10684p = -2;
        this.f10676h = context;
        this.f10670b = duVar;
        this.f10673e = dkVar;
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            this.f10669a = m12325b();
        } else {
            this.f10669a = str;
        }
        this.f10672d = dlVar;
        this.f10671c = dlVar.f10651b != -1 ? dlVar.f10651b : 10000;
        this.f10674f = adRequestParcel;
        this.f10675g = adSizeParcel;
        this.f10678j = versionInfoParcel;
        this.f10679k = z;
        this.f10682n = z2;
        this.f10680l = nativeAdOptionsParcel;
        this.f10681m = list;
    }

    private String m12318a(String str) {
        if (!(str == null || !m12334e() || m12327b(2))) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                jSONObject.remove("cpm_floor_cents");
                str = jSONObject.toString();
            } catch (JSONException e) {
                C2972b.m11583d("Could not remove field. Returning the original value");
            }
        }
        return str;
    }

    private void m12319a(long j, long j2, long j3, long j4) {
        while (this.f10684p == -2) {
            m12326b(j, j2, j3, j4);
        }
    }

    private void m12320a(dn dnVar) {
        if ("com.google.ads.mediation.AdUrlAdapter".equals(this.f10669a)) {
            Bundle bundle = this.f10674f.f9319m.getBundle(this.f10669a);
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString("sdk_less_network_id", this.f10673e.f10636b);
            this.f10674f.f9319m.putBundle(this.f10669a, bundle);
        }
        String a = m12318a(this.f10673e.f10642h);
        try {
            if (this.f10678j.f10083d < 4100000) {
                if (this.f10675g.f9329e) {
                    this.f10683o.m12369a(C2690b.m10262a(this.f10676h), this.f10674f, a, dnVar);
                } else {
                    this.f10683o.m12372a(C2690b.m10262a(this.f10676h), this.f10675g, this.f10674f, a, (dw) dnVar);
                }
            } else if (this.f10679k) {
                this.f10683o.m12371a(C2690b.m10262a(this.f10676h), this.f10674f, a, this.f10673e.f10635a, dnVar, this.f10680l, this.f10681m);
            } else if (this.f10675g.f9329e) {
                this.f10683o.m12370a(C2690b.m10262a(this.f10676h), this.f10674f, a, this.f10673e.f10635a, (dw) dnVar);
            } else if (!this.f10682n) {
                this.f10683o.m12373a(C2690b.m10262a(this.f10676h), this.f10675g, this.f10674f, a, this.f10673e.f10635a, dnVar);
            } else if (this.f10673e.f10645k != null) {
                this.f10683o.m12371a(C2690b.m10262a(this.f10676h), this.f10674f, a, this.f10673e.f10635a, dnVar, new NativeAdOptionsParcel(C3146do.m12324b(this.f10673e.f10649o)), this.f10673e.f10648n);
            } else {
                this.f10683o.m12373a(C2690b.m10262a(this.f10676h), this.f10675g, this.f10674f, a, this.f10673e.f10635a, dnVar);
            }
        } catch (Throwable e) {
            C2972b.m11584d("Could not request ad from mediation adapter.", e);
            m12340a(5);
        }
    }

    private static C2704b m12324b(String str) {
        C2703a c2703a = new C2703a();
        if (str == null) {
            return c2703a.m10283a();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            c2703a.m10284b(jSONObject.optBoolean("multiple_images", false));
            c2703a.m10282a(jSONObject.optBoolean("only_urls", false));
            c2703a.m10281a(C3146do.m12328c(jSONObject.optString("native_image_orientation", "any")));
        } catch (Throwable e) {
            C2972b.m11584d("Exception occurred when creating native ad options", e);
        }
        return c2703a.m10283a();
    }

    private String m12325b() {
        try {
            if (!TextUtils.isEmpty(this.f10673e.f10639e)) {
                return this.f10670b.m12358b(this.f10673e.f10639e) ? "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter" : "com.google.ads.mediation.customevent.CustomEventAdapter";
            }
        } catch (RemoteException e) {
            C2972b.m11583d("Fail to determine the custom event's version, assuming the old one.");
        }
        return "com.google.ads.mediation.customevent.CustomEventAdapter";
    }

    private void m12326b(long j, long j2, long j3, long j4) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j5 = j2 - (elapsedRealtime - j);
        elapsedRealtime = j4 - (elapsedRealtime - j3);
        if (j5 <= 0 || elapsedRealtime <= 0) {
            C2972b.m11581c("Timed out waiting for adapter.");
            this.f10684p = 3;
            return;
        }
        try {
            this.f10677i.wait(Math.min(j5, elapsedRealtime));
        } catch (InterruptedException e) {
            this.f10684p = -1;
        }
    }

    private boolean m12327b(int i) {
        try {
            Bundle l = this.f10679k ? this.f10683o.m12386l() : this.f10675g.f9329e ? this.f10683o.m12385k() : this.f10683o.m12384j();
            if (l == null) {
                return false;
            }
            return (l.getInt("capabilities", 0) & i) == i;
        } catch (RemoteException e) {
            C2972b.m11583d("Could not get adapter info. Returning false");
            return false;
        }
    }

    private static int m12328c(String str) {
        return "landscape".equals(str) ? 2 : "portrait".equals(str) ? 1 : 0;
    }

    private dy m12330c() {
        if (this.f10684p != 0 || !m12334e()) {
            return null;
        }
        try {
            if (!(!m12327b(4) || this.f10685q == null || this.f10685q.m12311a() == 0)) {
                return this.f10685q;
            }
        } catch (RemoteException e) {
            C2972b.m11583d("Could not get cpm value from MediationResponseMetadata");
        }
        return C3146do.m12331c(m12336f());
    }

    private static dy m12331c(int i) {
        return new C31442(i);
    }

    private dv m12332d() {
        C2972b.m11581c("Instantiating mediation adapter: " + this.f10669a);
        if (((Boolean) aq.av.m11794c()).booleanValue() && "com.google.ads.mediation.admob.AdMobAdapter".equals(this.f10669a)) {
            return new ec(new AdMobAdapter());
        }
        if (((Boolean) aq.aw.m11794c()).booleanValue() && "com.google.ads.mediation.AdUrlAdapter".equals(this.f10669a)) {
            return new ec(new AdUrlAdapter());
        }
        try {
            return this.f10670b.m12357a(this.f10669a);
        } catch (Throwable e) {
            C2972b.m11577a("Could not instantiate mediation adapter: " + this.f10669a, e);
            return null;
        }
    }

    private boolean m12334e() {
        return this.f10672d.f10659j != -1;
    }

    private int m12336f() {
        if (this.f10673e.f10642h == null) {
            return 0;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.f10673e.f10642h);
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(this.f10669a)) {
                return jSONObject.optInt("cpm_cents", 0);
            }
            int optInt = m12327b(2) ? jSONObject.optInt("cpm_floor_cents", 0) : 0;
            return optInt == 0 ? jSONObject.optInt("penalized_average_cpm_cents", 0) : optInt;
        } catch (JSONException e) {
            C2972b.m11583d("Could not convert to json. Returning 0");
            return 0;
        }
    }

    public dp m12338a(long j, long j2) {
        dp dpVar;
        synchronized (this.f10677i) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            dn dnVar = new dn();
            hj.f11297a.post(new C31421(this, dnVar));
            m12319a(elapsedRealtime, this.f10671c, j, j2);
            dpVar = new dp(this.f10673e, this.f10683o, this.f10669a, dnVar, this.f10684p, m12330c());
        }
        return dpVar;
    }

    public void m12339a() {
        synchronized (this.f10677i) {
            try {
                if (this.f10683o != null) {
                    this.f10683o.m12377c();
                }
            } catch (Throwable e) {
                C2972b.m11584d("Could not destroy mediation adapter.", e);
            }
            this.f10684p = -1;
            this.f10677i.notify();
        }
    }

    public void m12340a(int i) {
        synchronized (this.f10677i) {
            this.f10684p = i;
            this.f10677i.notify();
        }
    }

    public void m12341a(int i, dy dyVar) {
        synchronized (this.f10677i) {
            this.f10684p = i;
            this.f10685q = dyVar;
            this.f10677i.notify();
        }
    }
}
