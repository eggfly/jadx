package com.google.android.gms.p146b;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.facebook.ads.AdError;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.C2929k;
import com.google.android.gms.ads.internal.request.C2934j.C2936a;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.p146b.dd.C2944b;
import com.google.android.gms.p146b.dd.C3131c;
import com.google.android.gms.p146b.dd.C3135d;
import com.google.android.gms.p146b.gn.C3231a;
import com.google.android.gms.p146b.ib.C2915c;
import com.google.android.gms.p146b.ib.C2917a;
import com.google.android.gms.p146b.ij.C2813a;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

@gb
/* renamed from: com.google.android.gms.b.gd */
public final class gd extends C2936a {
    private static final Object f11048a;
    private static gd f11049b;
    private final Context f11050c;
    private final gc f11051d;
    private final aj f11052e;
    private final dd f11053f;

    /* renamed from: com.google.android.gms.b.gd.1 */
    static class C32181 implements Callable<Void> {
        final /* synthetic */ gc f11018a;
        final /* synthetic */ Context f11019b;
        final /* synthetic */ AdRequestInfoParcel f11020c;
        final /* synthetic */ Bundle f11021d;

        C32181(gc gcVar, Context context, AdRequestInfoParcel adRequestInfoParcel, Bundle bundle) {
            this.f11018a = gcVar;
            this.f11019b = context;
            this.f11020c = adRequestInfoParcel;
            this.f11021d = bundle;
        }

        public Void m12811a() {
            this.f11018a.f11017i.m12877a(this.f11019b, this.f11020c.f9857g.packageName, this.f11021d);
            return null;
        }

        public /* synthetic */ Object call() {
            return m12811a();
        }
    }

    /* renamed from: com.google.android.gms.b.gd.2 */
    static class C32212 implements Runnable {
        final /* synthetic */ dd f11025a;
        final /* synthetic */ gf f11026b;
        final /* synthetic */ az f11027c;
        final /* synthetic */ aw f11028d;
        final /* synthetic */ String f11029e;

        /* renamed from: com.google.android.gms.b.gd.2.1 */
        class C32191 implements C2915c<de> {
            final /* synthetic */ aw f11022a;
            final /* synthetic */ C32212 f11023b;

            C32191(C32212 c32212, aw awVar) {
                this.f11023b = c32212;
                this.f11022a = awVar;
            }

            public void m12812a(de deVar) {
                this.f11023b.f11027c.m11855a(this.f11022a, "jsf");
                this.f11023b.f11027c.m11856b();
                deVar.m12202a("/invalidRequest", this.f11023b.f11026b.f11059c);
                deVar.m12202a("/loadAdURL", this.f11023b.f11026b.f11060d);
                try {
                    deVar.m12203a("AFMA_buildAdURL", this.f11023b.f11029e);
                } catch (Throwable e) {
                    C2972b.m11580b("Error requesting an ad url", e);
                }
            }

            public /* synthetic */ void m12813a(Object obj) {
                m12812a((de) obj);
            }
        }

        /* renamed from: com.google.android.gms.b.gd.2.2 */
        class C32202 implements C2917a {
            final /* synthetic */ C32212 f11024a;

            C32202(C32212 c32212) {
                this.f11024a = c32212;
            }

            public void m12814a() {
            }
        }

        C32212(dd ddVar, gf gfVar, az azVar, aw awVar, String str) {
            this.f11025a = ddVar;
            this.f11026b = gfVar;
            this.f11027c = azVar;
            this.f11028d = awVar;
            this.f11029e = str;
        }

        public void run() {
            C3135d b = this.f11025a.m12279b();
            this.f11026b.m12844a(b);
            this.f11027c.m11855a(this.f11028d, "rwc");
            b.m12251a(new C32191(this, this.f11027c.m11849a()), new C32202(this));
        }
    }

    /* renamed from: com.google.android.gms.b.gd.3 */
    static class C32223 implements Runnable {
        final /* synthetic */ Context f11030a;
        final /* synthetic */ AdRequestInfoParcel f11031b;
        final /* synthetic */ gf f11032c;
        final /* synthetic */ az f11033d;
        final /* synthetic */ aw f11034e;
        final /* synthetic */ String f11035f;
        final /* synthetic */ aj f11036g;

        C32223(Context context, AdRequestInfoParcel adRequestInfoParcel, gf gfVar, az azVar, aw awVar, String str, aj ajVar) {
            this.f11030a = context;
            this.f11031b = adRequestInfoParcel;
            this.f11032c = gfVar;
            this.f11033d = azVar;
            this.f11034e = awVar;
            this.f11035f = str;
            this.f11036g = ajVar;
        }

        public void run() {
            ii a = C2968s.m11526f().m13299a(this.f11030a, new AdSizeParcel(), false, false, null, this.f11031b.f9861k);
            if (C2968s.m11528h().m12955l()) {
                a.m13241d(true);
            }
            a.m13222a().setWillNotDraw(true);
            this.f11032c.m12845a(a);
            this.f11033d.m11855a(this.f11034e, "rwc");
            C2813a a2 = gd.m12823b(this.f11035f, this.f11033d, this.f11033d.m11849a());
            ij l = a.m13249l();
            l.m13287a("/invalidRequest", this.f11032c.f11059c);
            l.m13287a("/loadAdURL", this.f11032c.f11060d);
            l.m13287a("/log", ca.f10408i);
            l.m13285a(a2);
            C2972b.m11576a("Loading the JS library.");
            a.loadUrl(this.f11036g.m11782a());
        }
    }

    /* renamed from: com.google.android.gms.b.gd.4 */
    static class C32234 implements Runnable {
        final /* synthetic */ gc f11037a;
        final /* synthetic */ Context f11038b;
        final /* synthetic */ gf f11039c;
        final /* synthetic */ AdRequestInfoParcel f11040d;

        C32234(gc gcVar, Context context, gf gfVar, AdRequestInfoParcel adRequestInfoParcel) {
            this.f11037a = gcVar;
            this.f11038b = context;
            this.f11039c = gfVar;
            this.f11040d = adRequestInfoParcel;
        }

        public void run() {
            this.f11037a.f11011c.m12898a(this.f11038b, this.f11039c, this.f11040d.f9861k);
        }
    }

    /* renamed from: com.google.android.gms.b.gd.5 */
    static class C32245 implements C2813a {
        final /* synthetic */ az f11041a;
        final /* synthetic */ aw f11042b;
        final /* synthetic */ String f11043c;

        C32245(az azVar, aw awVar, String str) {
            this.f11041a = azVar;
            this.f11042b = awVar;
            this.f11043c = str;
        }

        public void m12815a(ii iiVar, boolean z) {
            this.f11041a.m11855a(this.f11042b, "jsf");
            this.f11041a.m11856b();
            iiVar.m13229a("AFMA_buildAdURL", this.f11043c);
        }
    }

    /* renamed from: com.google.android.gms.b.gd.6 */
    class C32256 implements C2944b<da> {
        final /* synthetic */ gd f11044a;

        C32256(gd gdVar) {
            this.f11044a = gdVar;
        }

        public void m12816a(da daVar) {
            daVar.m12202a("/log", ca.f10408i);
        }

        public /* synthetic */ void m12817a(Object obj) {
            m12816a((da) obj);
        }
    }

    /* renamed from: com.google.android.gms.b.gd.7 */
    class C32267 implements Runnable {
        final /* synthetic */ AdRequestInfoParcel f11045a;
        final /* synthetic */ C2929k f11046b;
        final /* synthetic */ gd f11047c;

        C32267(gd gdVar, AdRequestInfoParcel adRequestInfoParcel, C2929k c2929k) {
            this.f11047c = gdVar;
            this.f11045a = adRequestInfoParcel;
            this.f11046b = c2929k;
        }

        public void run() {
            AdResponseParcel a;
            try {
                a = this.f11047c.m12824a(this.f11045a);
            } catch (Throwable e) {
                C2968s.m11528h().m12941a(e, true);
                C2972b.m11584d("Could not fetch ad response due to an Exception.", e);
                a = null;
            }
            if (a == null) {
                a = new AdResponseParcel(0);
            }
            try {
                this.f11046b.m11408a(a);
            } catch (Throwable e2) {
                C2972b.m11584d("Fail to forward ad response.", e2);
            }
        }
    }

    static {
        f11048a = new Object();
    }

    gd(Context context, aj ajVar, gc gcVar) {
        this.f11050c = context;
        this.f11051d = gcVar;
        this.f11052e = ajVar;
        this.f11053f = new dd(context.getApplicationContext() != null ? context.getApplicationContext() : context, new VersionInfoParcel(8487000, 8487000, true), ajVar.m11782a(), new C32256(this), new C3131c());
    }

    private static AdResponseParcel m12818a(Context context, dd ddVar, aj ajVar, gc gcVar, AdRequestInfoParcel adRequestInfoParcel) {
        Bundle bundle;
        Future future;
        Throwable e;
        C2972b.m11576a("Starting ad request from service.");
        aq.m11814a(context);
        az azVar = new az(((Boolean) aq.f10267G.m11794c()).booleanValue(), "load_ad", adRequestInfoParcel.f9854d.f9326b);
        if (adRequestInfoParcel.f9851a > 10 && adRequestInfoParcel.f9845B != -1) {
            azVar.m11855a(azVar.m11850a(adRequestInfoParcel.f9845B), "cts");
        }
        aw a = azVar.m11849a();
        Bundle bundle2 = (adRequestInfoParcel.f9851a < 4 || adRequestInfoParcel.f9865o == null) ? null : adRequestInfoParcel.f9865o;
        if (!((Boolean) aq.f10276P.m11794c()).booleanValue() || gcVar.f11017i == null) {
            bundle = bundle2;
            future = null;
        } else {
            if (bundle2 == null && ((Boolean) aq.f10277Q.m11794c()).booleanValue()) {
                hf.m12982e("contentInfo is not present, but we'll still launch the app index task");
                bundle2 = new Bundle();
            }
            if (bundle2 != null) {
                bundle = bundle2;
                future = hi.m13005a(new C32181(gcVar, context, adRequestInfoParcel, bundle2));
            } else {
                bundle = bundle2;
                future = null;
            }
        }
        gcVar.f11012d.m12288a();
        gj a2 = C2968s.m11531k().m12897a(context);
        if (a2.f11139m == -1) {
            C2972b.m11576a("Device is offline.");
            return new AdResponseParcel(2);
        }
        String uuid = adRequestInfoParcel.f9851a >= 7 ? adRequestInfoParcel.f9873w : UUID.randomUUID().toString();
        gf gfVar = new gf(uuid, adRequestInfoParcel.f9856f.packageName);
        if (adRequestInfoParcel.f9853c.f9309c != null) {
            String string = adRequestInfoParcel.f9853c.f9309c.getString("_ad");
            if (string != null) {
                return ge.m12826a(context, adRequestInfoParcel, string);
            }
        }
        Location a3 = gcVar.f11012d.m12287a(250);
        String a4 = gcVar.f11013e.m12656a(context, adRequestInfoParcel.f9855e, adRequestInfoParcel.f9857g.packageName);
        List a5 = gcVar.f11010b.m11783a(adRequestInfoParcel);
        String a6 = gcVar.f11014f.m12911a(adRequestInfoParcel);
        C3231a a7 = gcVar.f11015g.m12902a(context);
        if (future != null) {
            try {
                hf.m12982e("Waiting for app index fetching task.");
                future.get(((Long) aq.f10278R.m11794c()).longValue(), TimeUnit.MILLISECONDS);
                hf.m12982e("App index fetching task completed.");
            } catch (ExecutionException e2) {
                e = e2;
                C2972b.m11584d("Failed to fetch app index signal", e);
            } catch (InterruptedException e3) {
                e = e3;
                C2972b.m11584d("Failed to fetch app index signal", e);
            } catch (TimeoutException e4) {
                C2972b.m11576a("Timed out waiting for app index fetching task");
            }
        }
        JSONObject a8 = ge.m12831a(context, adRequestInfoParcel, a2, a7, a3, ajVar, a4, a6, a5, bundle);
        if (adRequestInfoParcel.f9851a < 7) {
            try {
                a8.put("request_id", uuid);
            } catch (JSONException e5) {
            }
        }
        if (a8 == null) {
            return new AdResponseParcel(0);
        }
        String jSONObject = a8.toString();
        azVar.m11855a(a, "arc");
        aw a9 = azVar.m11849a();
        if (((Boolean) aq.f10289c.m11794c()).booleanValue()) {
            hj.f11297a.post(new C32212(ddVar, gfVar, azVar, a9, jSONObject));
        } else {
            hj.f11297a.post(new C32223(context, adRequestInfoParcel, gfVar, azVar, a9, jSONObject, ajVar));
        }
        AdResponseParcel adResponseParcel;
        try {
            gi giVar = (gi) gfVar.m12846b().get(10, TimeUnit.SECONDS);
            if (giVar == null) {
                adResponseParcel = new AdResponseParcel(0);
                return adResponseParcel;
            } else if (giVar.m12880a() != -2) {
                adResponseParcel = new AdResponseParcel(giVar.m12880a());
                hj.f11297a.post(new C32234(gcVar, context, gfVar, adRequestInfoParcel));
                return adResponseParcel;
            } else {
                if (azVar.m11859e() != null) {
                    azVar.m11855a(azVar.m11859e(), "rur");
                }
                String str = null;
                if (giVar.m12886f()) {
                    str = gcVar.f11009a.m12909a(adRequestInfoParcel.f9857g.packageName);
                }
                adResponseParcel = gd.m12819a(adRequestInfoParcel, context, adRequestInfoParcel.f9861k.f10081b, giVar.m12884d(), str, giVar.m12888h() ? a4 : null, giVar, azVar, gcVar);
                if (adResponseParcel.f9908x == 1) {
                    gcVar.f11013e.m12657a(context, adRequestInfoParcel.f9857g.packageName);
                }
                azVar.m11855a(a, "tts");
                adResponseParcel.f9910z = azVar.m11857c();
                hj.f11297a.post(new C32234(gcVar, context, gfVar, adRequestInfoParcel));
                return adResponseParcel;
            }
        } catch (Exception e6) {
            adResponseParcel = new AdResponseParcel(0);
            return adResponseParcel;
        } finally {
            hj.f11297a.post(new C32234(gcVar, context, gfVar, adRequestInfoParcel));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.ads.internal.request.AdResponseParcel m12819a(com.google.android.gms.ads.internal.request.AdRequestInfoParcel r13, android.content.Context r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, com.google.android.gms.p146b.gi r19, com.google.android.gms.p146b.az r20, com.google.android.gms.p146b.gc r21) {
        /*
        if (r20 == 0) goto L_0x00f6;
    L_0x0002:
        r2 = r20.m11849a();
        r3 = r2;
    L_0x0007:
        r8 = new com.google.android.gms.b.gg;	 Catch:{ IOException -> 0x010e }
        r8.<init>(r13);	 Catch:{ IOException -> 0x010e }
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x010e }
        r2.<init>();	 Catch:{ IOException -> 0x010e }
        r4 = "AdRequestServiceImpl: Sending request: ";
        r2 = r2.append(r4);	 Catch:{ IOException -> 0x010e }
        r0 = r16;
        r2 = r2.append(r0);	 Catch:{ IOException -> 0x010e }
        r2 = r2.toString();	 Catch:{ IOException -> 0x010e }
        com.google.android.gms.ads.internal.util.client.C2972b.m11576a(r2);	 Catch:{ IOException -> 0x010e }
        r4 = new java.net.URL;	 Catch:{ IOException -> 0x010e }
        r0 = r16;
        r4.<init>(r0);	 Catch:{ IOException -> 0x010e }
        r2 = 0;
        r5 = com.google.android.gms.ads.internal.C2968s.m11529i();	 Catch:{ IOException -> 0x010e }
        r10 = r5.m13544b();	 Catch:{ IOException -> 0x010e }
        r6 = r2;
        r7 = r4;
    L_0x0036:
        if (r21 == 0) goto L_0x003f;
    L_0x0038:
        r0 = r21;
        r2 = r0.f11016h;	 Catch:{ IOException -> 0x010e }
        r2.m12900a();	 Catch:{ IOException -> 0x010e }
    L_0x003f:
        r2 = r7.openConnection();	 Catch:{ IOException -> 0x010e }
        r2 = (java.net.HttpURLConnection) r2;	 Catch:{ IOException -> 0x010e }
        r4 = com.google.android.gms.ads.internal.C2968s.m11525e();	 Catch:{ all -> 0x0100 }
        r5 = 0;
        r4.m13039a(r14, r15, r5, r2);	 Catch:{ all -> 0x0100 }
        r4 = android.text.TextUtils.isEmpty(r17);	 Catch:{ all -> 0x0100 }
        if (r4 != 0) goto L_0x005a;
    L_0x0053:
        r4 = "x-afma-drt-cookie";
        r0 = r17;
        r2.addRequestProperty(r4, r0);	 Catch:{ all -> 0x0100 }
    L_0x005a:
        r4 = android.text.TextUtils.isEmpty(r18);	 Catch:{ all -> 0x0100 }
        if (r4 != 0) goto L_0x007a;
    L_0x0060:
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0100 }
        r4.<init>();	 Catch:{ all -> 0x0100 }
        r5 = "Bearer ";
        r4 = r4.append(r5);	 Catch:{ all -> 0x0100 }
        r0 = r18;
        r4 = r4.append(r0);	 Catch:{ all -> 0x0100 }
        r4 = r4.toString();	 Catch:{ all -> 0x0100 }
        r5 = "Authorization";
        r2.addRequestProperty(r5, r4);	 Catch:{ all -> 0x0100 }
    L_0x007a:
        if (r19 == 0) goto L_0x00a6;
    L_0x007c:
        r4 = r19.m12883c();	 Catch:{ all -> 0x0100 }
        r4 = android.text.TextUtils.isEmpty(r4);	 Catch:{ all -> 0x0100 }
        if (r4 != 0) goto L_0x00a6;
    L_0x0086:
        r4 = 1;
        r2.setDoOutput(r4);	 Catch:{ all -> 0x0100 }
        r4 = r19.m12883c();	 Catch:{ all -> 0x0100 }
        r9 = r4.getBytes();	 Catch:{ all -> 0x0100 }
        r4 = r9.length;	 Catch:{ all -> 0x0100 }
        r2.setFixedLengthStreamingMode(r4);	 Catch:{ all -> 0x0100 }
        r5 = 0;
        r4 = new java.io.BufferedOutputStream;	 Catch:{ all -> 0x00fa }
        r12 = r2.getOutputStream();	 Catch:{ all -> 0x00fa }
        r4.<init>(r12);	 Catch:{ all -> 0x00fa }
        r4.write(r9);	 Catch:{ all -> 0x01d0 }
        com.google.android.gms.p146b.jm.m13561a(r4);	 Catch:{ all -> 0x0100 }
    L_0x00a6:
        r9 = r2.getResponseCode();	 Catch:{ all -> 0x0100 }
        r12 = r2.getHeaderFields();	 Catch:{ all -> 0x0100 }
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r9 < r4) goto L_0x0136;
    L_0x00b2:
        r4 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r9 >= r4) goto L_0x0136;
    L_0x00b6:
        r6 = r7.toString();	 Catch:{ all -> 0x0100 }
        r5 = 0;
        r4 = new java.io.InputStreamReader;	 Catch:{ all -> 0x0130 }
        r7 = r2.getInputStream();	 Catch:{ all -> 0x0130 }
        r4.<init>(r7);	 Catch:{ all -> 0x0130 }
        r5 = com.google.android.gms.ads.internal.C2968s.m11525e();	 Catch:{ all -> 0x01cd }
        r5 = r5.m13026a(r4);	 Catch:{ all -> 0x01cd }
        com.google.android.gms.p146b.jm.m13561a(r4);	 Catch:{ all -> 0x0100 }
        com.google.android.gms.p146b.gd.m12822a(r6, r12, r5, r9);	 Catch:{ all -> 0x0100 }
        r8.m12875a(r6, r12, r5);	 Catch:{ all -> 0x0100 }
        if (r20 == 0) goto L_0x00e4;
    L_0x00d7:
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ all -> 0x0100 }
        r5 = 0;
        r6 = "ufe";
        r4[r5] = r6;	 Catch:{ all -> 0x0100 }
        r0 = r20;
        r0.m11855a(r3, r4);	 Catch:{ all -> 0x0100 }
    L_0x00e4:
        r3 = r8.m12874a(r10);	 Catch:{ all -> 0x0100 }
        r2.disconnect();	 Catch:{ IOException -> 0x010e }
        if (r21 == 0) goto L_0x00f4;
    L_0x00ed:
        r0 = r21;
        r2 = r0.f11016h;	 Catch:{ IOException -> 0x010e }
        r2.m12901b();	 Catch:{ IOException -> 0x010e }
    L_0x00f4:
        r2 = r3;
    L_0x00f5:
        return r2;
    L_0x00f6:
        r2 = 0;
        r3 = r2;
        goto L_0x0007;
    L_0x00fa:
        r3 = move-exception;
        r4 = r5;
    L_0x00fc:
        com.google.android.gms.p146b.jm.m13561a(r4);	 Catch:{ all -> 0x0100 }
        throw r3;	 Catch:{ all -> 0x0100 }
    L_0x0100:
        r3 = move-exception;
        r2.disconnect();	 Catch:{ IOException -> 0x010e }
        if (r21 == 0) goto L_0x010d;
    L_0x0106:
        r0 = r21;
        r2 = r0.f11016h;	 Catch:{ IOException -> 0x010e }
        r2.m12901b();	 Catch:{ IOException -> 0x010e }
    L_0x010d:
        throw r3;	 Catch:{ IOException -> 0x010e }
    L_0x010e:
        r2 = move-exception;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Error while connecting to ad server: ";
        r3 = r3.append(r4);
        r2 = r2.getMessage();
        r2 = r3.append(r2);
        r2 = r2.toString();
        com.google.android.gms.ads.internal.util.client.C2972b.m11583d(r2);
        r2 = new com.google.android.gms.ads.internal.request.AdResponseParcel;
        r3 = 2;
        r2.<init>(r3);
        goto L_0x00f5;
    L_0x0130:
        r3 = move-exception;
        r4 = r5;
    L_0x0132:
        com.google.android.gms.p146b.jm.m13561a(r4);	 Catch:{ all -> 0x0100 }
        throw r3;	 Catch:{ all -> 0x0100 }
    L_0x0136:
        r4 = r7.toString();	 Catch:{ all -> 0x0100 }
        r5 = 0;
        com.google.android.gms.p146b.gd.m12822a(r4, r12, r5, r9);	 Catch:{ all -> 0x0100 }
        r4 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r9 < r4) goto L_0x018f;
    L_0x0142:
        r4 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r9 >= r4) goto L_0x018f;
    L_0x0146:
        r4 = "Location";
        r4 = r2.getHeaderField(r4);	 Catch:{ all -> 0x0100 }
        r5 = android.text.TextUtils.isEmpty(r4);	 Catch:{ all -> 0x0100 }
        if (r5 == 0) goto L_0x016b;
    L_0x0152:
        r3 = "No location header to follow redirect.";
        com.google.android.gms.ads.internal.util.client.C2972b.m11583d(r3);	 Catch:{ all -> 0x0100 }
        r3 = new com.google.android.gms.ads.internal.request.AdResponseParcel;	 Catch:{ all -> 0x0100 }
        r4 = 0;
        r3.<init>(r4);	 Catch:{ all -> 0x0100 }
        r2.disconnect();	 Catch:{ IOException -> 0x010e }
        if (r21 == 0) goto L_0x0169;
    L_0x0162:
        r0 = r21;
        r2 = r0.f11016h;	 Catch:{ IOException -> 0x010e }
        r2.m12901b();	 Catch:{ IOException -> 0x010e }
    L_0x0169:
        r2 = r3;
        goto L_0x00f5;
    L_0x016b:
        r5 = new java.net.URL;	 Catch:{ all -> 0x0100 }
        r5.<init>(r4);	 Catch:{ all -> 0x0100 }
        r4 = r6 + 1;
        r6 = 5;
        if (r4 <= r6) goto L_0x01ba;
    L_0x0175:
        r3 = "Too many redirects.";
        com.google.android.gms.ads.internal.util.client.C2972b.m11583d(r3);	 Catch:{ all -> 0x0100 }
        r3 = new com.google.android.gms.ads.internal.request.AdResponseParcel;	 Catch:{ all -> 0x0100 }
        r4 = 0;
        r3.<init>(r4);	 Catch:{ all -> 0x0100 }
        r2.disconnect();	 Catch:{ IOException -> 0x010e }
        if (r21 == 0) goto L_0x018c;
    L_0x0185:
        r0 = r21;
        r2 = r0.f11016h;	 Catch:{ IOException -> 0x010e }
        r2.m12901b();	 Catch:{ IOException -> 0x010e }
    L_0x018c:
        r2 = r3;
        goto L_0x00f5;
    L_0x018f:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0100 }
        r3.<init>();	 Catch:{ all -> 0x0100 }
        r4 = "Received error HTTP response code: ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x0100 }
        r3 = r3.append(r9);	 Catch:{ all -> 0x0100 }
        r3 = r3.toString();	 Catch:{ all -> 0x0100 }
        com.google.android.gms.ads.internal.util.client.C2972b.m11583d(r3);	 Catch:{ all -> 0x0100 }
        r3 = new com.google.android.gms.ads.internal.request.AdResponseParcel;	 Catch:{ all -> 0x0100 }
        r4 = 0;
        r3.<init>(r4);	 Catch:{ all -> 0x0100 }
        r2.disconnect();	 Catch:{ IOException -> 0x010e }
        if (r21 == 0) goto L_0x01b7;
    L_0x01b0:
        r0 = r21;
        r2 = r0.f11016h;	 Catch:{ IOException -> 0x010e }
        r2.m12901b();	 Catch:{ IOException -> 0x010e }
    L_0x01b7:
        r2 = r3;
        goto L_0x00f5;
    L_0x01ba:
        r8.m12876a(r12);	 Catch:{ all -> 0x0100 }
        r2.disconnect();	 Catch:{ IOException -> 0x010e }
        if (r21 == 0) goto L_0x01c9;
    L_0x01c2:
        r0 = r21;
        r2 = r0.f11016h;	 Catch:{ IOException -> 0x010e }
        r2.m12901b();	 Catch:{ IOException -> 0x010e }
    L_0x01c9:
        r6 = r4;
        r7 = r5;
        goto L_0x0036;
    L_0x01cd:
        r3 = move-exception;
        goto L_0x0132;
    L_0x01d0:
        r3 = move-exception;
        goto L_0x00fc;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.gd.a(com.google.android.gms.ads.internal.request.AdRequestInfoParcel, android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.google.android.gms.b.gi, com.google.android.gms.b.az, com.google.android.gms.b.gc):com.google.android.gms.ads.internal.request.AdResponseParcel");
    }

    public static gd m12820a(Context context, aj ajVar, gc gcVar) {
        gd gdVar;
        synchronized (f11048a) {
            if (f11049b == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                f11049b = new gd(context, ajVar, gcVar);
            }
            gdVar = f11049b;
        }
        return gdVar;
    }

    private static void m12822a(String str, Map<String, List<String>> map, String str2, int i) {
        if (C2972b.m11578a(2)) {
            hf.m12982e("Http Response: {\n  URL:\n    " + str + "\n  Headers:");
            if (map != null) {
                for (String str3 : map.keySet()) {
                    hf.m12982e("    " + str3 + ":");
                    for (String str32 : (List) map.get(str32)) {
                        hf.m12982e("      " + str32);
                    }
                }
            }
            hf.m12982e("  Body:");
            if (str2 != null) {
                for (int i2 = 0; i2 < Math.min(str2.length(), 100000); i2 += AdError.NETWORK_ERROR_CODE) {
                    hf.m12982e(str2.substring(i2, Math.min(str2.length(), i2 + AdError.NETWORK_ERROR_CODE)));
                }
            } else {
                hf.m12982e("    null");
            }
            hf.m12982e("  Response Code:\n    " + i + "\n}");
        }
    }

    private static C2813a m12823b(String str, az azVar, aw awVar) {
        return new C32245(azVar, awVar, str);
    }

    public AdResponseParcel m12824a(AdRequestInfoParcel adRequestInfoParcel) {
        return gd.m12818a(this.f11050c, this.f11053f, this.f11052e, this.f11051d, adRequestInfoParcel);
    }

    public void m12825a(AdRequestInfoParcel adRequestInfoParcel, C2929k c2929k) {
        C2968s.m11528h().m12935a(this.f11050c, adRequestInfoParcel.f9861k);
        hi.m13004a(new C32267(this, adRequestInfoParcel, c2929k));
    }
}
