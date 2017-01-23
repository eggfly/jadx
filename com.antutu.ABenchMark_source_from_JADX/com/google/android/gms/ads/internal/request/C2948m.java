package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.C0714a;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel.C2904a;
import com.google.android.gms.ads.internal.request.C2906a.C2731a;
import com.google.android.gms.ads.internal.util.client.C2971a;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.ads.p153c.C2715a;
import com.google.android.gms.ads.p153c.C2715a.C2713a;
import com.google.android.gms.common.C3385a;
import com.google.android.gms.common.C3454b;
import com.google.android.gms.p146b.aj;
import com.google.android.gms.p146b.aq;
import com.google.android.gms.p146b.cb;
import com.google.android.gms.p146b.cc;
import com.google.android.gms.p146b.cg;
import com.google.android.gms.p146b.da;
import com.google.android.gms.p146b.dd;
import com.google.android.gms.p146b.dd.C2944b;
import com.google.android.gms.p146b.dd.C3135d;
import com.google.android.gms.p146b.de;
import com.google.android.gms.p146b.gb;
import com.google.android.gms.p146b.ge;
import com.google.android.gms.p146b.gx.C3232a;
import com.google.android.gms.p146b.he;
import com.google.android.gms.p146b.ib.C2915c;
import com.google.android.gms.p146b.ib.C2917a;
import com.google.android.gms.p146b.ii;
import com.taobao.accs.common.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

@gb
/* renamed from: com.google.android.gms.ads.internal.request.m */
public class C2948m extends he {
    static final long f9991a;
    private static final Object f9992b;
    private static boolean f9993c;
    private static dd f9994d;
    private static cc f9995e;
    private static cg f9996f;
    private static cb f9997g;
    private final C2731a f9998h;
    private final C2904a f9999i;
    private final Object f10000j;
    private final Context f10001k;
    private C3135d f10002l;

    /* renamed from: com.google.android.gms.ads.internal.request.m.1 */
    class C29391 implements Runnable {
        final /* synthetic */ C3232a f9983a;
        final /* synthetic */ C2948m f9984b;

        C29391(C2948m c2948m, C3232a c3232a) {
            this.f9984b = c2948m;
            this.f9983a = c3232a;
        }

        public void run() {
            this.f9984b.f9998h.m10417a(this.f9983a);
            if (this.f9984b.f10002l != null) {
                this.f9984b.f10002l.m12256a();
                this.f9984b.f10002l = null;
            }
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.request.m.2 */
    class C29422 implements Runnable {
        final /* synthetic */ JSONObject f9987a;
        final /* synthetic */ String f9988b;
        final /* synthetic */ C2948m f9989c;

        /* renamed from: com.google.android.gms.ads.internal.request.m.2.1 */
        class C29401 implements C2915c<de> {
            final /* synthetic */ C29422 f9985a;

            C29401(C29422 c29422) {
                this.f9985a = c29422;
            }

            public void m11426a(de deVar) {
                try {
                    deVar.m12204a("AFMA_getAdapterLessMediationAd", this.f9985a.f9987a);
                } catch (Throwable e) {
                    C2972b.m11580b("Error requesting an ad url", e);
                    C2948m.f9996f.m12047b(this.f9985a.f9988b);
                }
            }

            public /* synthetic */ void m11427a(Object obj) {
                m11426a((de) obj);
            }
        }

        /* renamed from: com.google.android.gms.ads.internal.request.m.2.2 */
        class C29412 implements C2917a {
            final /* synthetic */ C29422 f9986a;

            C29412(C29422 c29422) {
                this.f9986a = c29422;
            }

            public void m11428a() {
                C2948m.f9996f.m12047b(this.f9986a.f9988b);
            }
        }

        C29422(C2948m c2948m, JSONObject jSONObject, String str) {
            this.f9989c = c2948m;
            this.f9987a = jSONObject;
            this.f9988b = str;
        }

        public void run() {
            this.f9989c.f10002l = C2948m.f9994d.m12279b();
            this.f9989c.f10002l.m12251a(new C29401(this), new C29412(this));
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.request.m.3 */
    class C29433 implements Runnable {
        final /* synthetic */ C2948m f9990a;

        C29433(C2948m c2948m) {
            this.f9990a = c2948m;
        }

        public void run() {
            if (this.f9990a.f10002l != null) {
                this.f9990a.f10002l.m12256a();
                this.f9990a.f10002l = null;
            }
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.request.m.a */
    public static class C2945a implements C2944b<da> {
        public void m11430a(da daVar) {
            C2948m.m11441b(daVar);
        }

        public /* synthetic */ void m11431a(Object obj) {
            m11430a((da) obj);
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.request.m.b */
    public static class C2946b implements C2944b<da> {
        public void m11432a(da daVar) {
            C2948m.m11439a(daVar);
        }

        public /* synthetic */ void m11433a(Object obj) {
            m11432a((da) obj);
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.request.m.c */
    public static class C2947c implements cb {
        public void m11434a(ii iiVar, Map<String, String> map) {
            String str = (String) map.get("request_id");
            C2972b.m11583d("Invalid request: " + ((String) map.get("errors")));
            C2948m.f9996f.m12047b(str);
        }
    }

    static {
        f9991a = TimeUnit.SECONDS.toMillis(10);
        f9992b = new Object();
        f9993c = false;
        f9994d = null;
        f9995e = null;
        f9996f = null;
        f9997g = null;
    }

    public C2948m(Context context, C2904a c2904a, C2731a c2731a) {
        super(true);
        this.f10000j = new Object();
        this.f9998h = c2731a;
        this.f10001k = context;
        this.f9999i = c2904a;
        synchronized (f9992b) {
            if (!f9993c) {
                f9996f = new cg();
                f9995e = new cc(context.getApplicationContext(), c2904a.f9827j);
                f9997g = new C2947c();
                f9994d = new dd(this.f10001k.getApplicationContext(), this.f9999i.f9827j, (String) aq.f10288b.m11794c(), new C2946b(), new C2945a());
                f9993c = true;
            }
        }
    }

    private AdResponseParcel m11435a(AdRequestInfoParcel adRequestInfoParcel) {
        String uuid = UUID.randomUUID().toString();
        JSONObject a = m11438a(adRequestInfoParcel, uuid);
        if (a == null) {
            return new AdResponseParcel(0);
        }
        long b = C2968s.m11529i().m13544b();
        Future a2 = f9996f.m12044a(uuid);
        C2971a.f10085a.post(new C29422(this, a, uuid));
        try {
            JSONObject jSONObject = (JSONObject) a2.get(f9991a - (C2968s.m11529i().m13544b() - b), TimeUnit.MILLISECONDS);
            if (jSONObject == null) {
                return new AdResponseParcel(-1);
            }
            AdResponseParcel a3 = ge.m12826a(this.f10001k, adRequestInfoParcel, jSONObject.toString());
            return (a3.f9889e == -3 || !TextUtils.isEmpty(a3.f9887c)) ? a3 : new AdResponseParcel(3);
        } catch (CancellationException e) {
            return new AdResponseParcel(-1);
        } catch (InterruptedException e2) {
            return new AdResponseParcel(-1);
        } catch (TimeoutException e3) {
            return new AdResponseParcel(2);
        } catch (ExecutionException e4) {
            return new AdResponseParcel(0);
        }
    }

    private JSONObject m11438a(AdRequestInfoParcel adRequestInfoParcel, String str) {
        Throwable e;
        Object obj;
        JSONObject jSONObject = null;
        Bundle bundle = adRequestInfoParcel.f9853c.f9309c.getBundle("sdk_less_server_data");
        String string = adRequestInfoParcel.f9853c.f9309c.getString("sdk_less_network_id");
        if (bundle != null) {
            JSONObject a = ge.m12831a(this.f10001k, adRequestInfoParcel, C2968s.m11531k().m12897a(this.f10001k), jSONObject, jSONObject, new aj((String) aq.f10288b.m11794c()), jSONObject, jSONObject, new ArrayList(), jSONObject);
            if (a != null) {
                C2713a b;
                Map hashMap;
                try {
                    b = C2715a.m10326b(this.f10001k);
                } catch (IOException e2) {
                    e = e2;
                    C2972b.m11584d("Cannot get advertising id info", e);
                    obj = jSONObject;
                    hashMap = new HashMap();
                    hashMap.put("request_id", str);
                    hashMap.put("network_id", string);
                    hashMap.put("request_param", a);
                    hashMap.put(Constants.KEY_DATA, bundle);
                    if (b != null) {
                        hashMap.put("adid", b.m10319a());
                        hashMap.put(C0714a.LATITUDE, Integer.valueOf(b.m10320b() ? 0 : 1));
                    }
                    jSONObject = C2968s.m11525e().m13030a(hashMap);
                    return jSONObject;
                } catch (IllegalStateException e3) {
                    e = e3;
                    C2972b.m11584d("Cannot get advertising id info", e);
                    obj = jSONObject;
                    hashMap = new HashMap();
                    hashMap.put("request_id", str);
                    hashMap.put("network_id", string);
                    hashMap.put("request_param", a);
                    hashMap.put(Constants.KEY_DATA, bundle);
                    if (b != null) {
                        hashMap.put("adid", b.m10319a());
                        if (b.m10320b()) {
                        }
                        hashMap.put(C0714a.LATITUDE, Integer.valueOf(b.m10320b() ? 0 : 1));
                    }
                    jSONObject = C2968s.m11525e().m13030a(hashMap);
                    return jSONObject;
                } catch (C3385a e4) {
                    e = e4;
                    C2972b.m11584d("Cannot get advertising id info", e);
                    obj = jSONObject;
                    hashMap = new HashMap();
                    hashMap.put("request_id", str);
                    hashMap.put("network_id", string);
                    hashMap.put("request_param", a);
                    hashMap.put(Constants.KEY_DATA, bundle);
                    if (b != null) {
                        hashMap.put("adid", b.m10319a());
                        if (b.m10320b()) {
                        }
                        hashMap.put(C0714a.LATITUDE, Integer.valueOf(b.m10320b() ? 0 : 1));
                    }
                    jSONObject = C2968s.m11525e().m13030a(hashMap);
                    return jSONObject;
                } catch (C3454b e5) {
                    e = e5;
                    C2972b.m11584d("Cannot get advertising id info", e);
                    obj = jSONObject;
                    hashMap = new HashMap();
                    hashMap.put("request_id", str);
                    hashMap.put("network_id", string);
                    hashMap.put("request_param", a);
                    hashMap.put(Constants.KEY_DATA, bundle);
                    if (b != null) {
                        hashMap.put("adid", b.m10319a());
                        if (b.m10320b()) {
                        }
                        hashMap.put(C0714a.LATITUDE, Integer.valueOf(b.m10320b() ? 0 : 1));
                    }
                    jSONObject = C2968s.m11525e().m13030a(hashMap);
                    return jSONObject;
                }
                hashMap = new HashMap();
                hashMap.put("request_id", str);
                hashMap.put("network_id", string);
                hashMap.put("request_param", a);
                hashMap.put(Constants.KEY_DATA, bundle);
                if (b != null) {
                    hashMap.put("adid", b.m10319a());
                    if (b.m10320b()) {
                    }
                    hashMap.put(C0714a.LATITUDE, Integer.valueOf(b.m10320b() ? 0 : 1));
                }
                try {
                    jSONObject = C2968s.m11525e().m13030a(hashMap);
                } catch (JSONException e6) {
                }
            }
        }
        return jSONObject;
    }

    protected static void m11439a(da daVar) {
        daVar.m12202a("/loadAd", f9996f);
        daVar.m12202a("/fetchHttpRequest", f9995e);
        daVar.m12202a("/invalidRequest", f9997g);
    }

    protected static void m11441b(da daVar) {
        daVar.m12205b("/loadAd", f9996f);
        daVar.m12205b("/fetchHttpRequest", f9995e);
        daVar.m12205b("/invalidRequest", f9997g);
    }

    public void m11444a() {
        C2972b.m11576a("SdkLessAdLoaderBackgroundTask started.");
        AdRequestInfoParcel adRequestInfoParcel = new AdRequestInfoParcel(this.f9999i, null, -1);
        AdResponseParcel a = m11435a(adRequestInfoParcel);
        AdSizeParcel adSizeParcel = null;
        C2971a.f10085a.post(new C29391(this, new C3232a(adRequestInfoParcel, a, null, adSizeParcel, a.f9889e, C2968s.m11529i().m13544b(), a.f9898n, null)));
    }

    public void m11445b() {
        synchronized (this.f10000j) {
            C2971a.f10085a.post(new C29433(this));
        }
    }
}
