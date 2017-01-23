package com.google.android.gms.p146b;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.umeng.analytics.C4156a;
import com.umeng.message.MsgConstant;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.BufferedOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@gb
/* renamed from: com.google.android.gms.b.cc */
public class cc implements cb {
    private final Context f10433a;
    private final VersionInfoParcel f10434b;

    /* renamed from: com.google.android.gms.b.cc.1 */
    class C30681 implements Runnable {
        final /* synthetic */ Map f10416a;
        final /* synthetic */ ii f10417b;
        final /* synthetic */ cc f10418c;

        /* renamed from: com.google.android.gms.b.cc.1.1 */
        class C30671 implements Runnable {
            final /* synthetic */ JSONObject f10414a;
            final /* synthetic */ C30681 f10415b;

            C30671(C30681 c30681, JSONObject jSONObject) {
                this.f10415b = c30681;
                this.f10414a = jSONObject;
            }

            public void run() {
                this.f10415b.f10417b.m12206b("fetchHttpRequestCompleted", this.f10414a);
                C2972b.m11576a("Dispatched http response.");
            }
        }

        C30681(cc ccVar, Map map, ii iiVar) {
            this.f10418c = ccVar;
            this.f10416a = map;
            this.f10417b = iiVar;
        }

        public void run() {
            C2972b.m11576a("Received Http request.");
            JSONObject a = this.f10418c.m12041a((String) this.f10416a.get("http_request"));
            if (a == null) {
                C2972b.m11579b("Response should not be null.");
            } else {
                hj.f11297a.post(new C30671(this, a));
            }
        }
    }

    @gb
    /* renamed from: com.google.android.gms.b.cc.a */
    static class C3069a {
        private final String f10419a;
        private final String f10420b;

        public C3069a(String str, String str2) {
            this.f10419a = str;
            this.f10420b = str2;
        }

        public String m12025a() {
            return this.f10419a;
        }

        public String m12026b() {
            return this.f10420b;
        }
    }

    @gb
    /* renamed from: com.google.android.gms.b.cc.b */
    static class C3070b {
        private final String f10421a;
        private final URL f10422b;
        private final ArrayList<C3069a> f10423c;
        private final String f10424d;

        public C3070b(String str, URL url, ArrayList<C3069a> arrayList, String str2) {
            this.f10421a = str;
            this.f10422b = url;
            if (arrayList == null) {
                this.f10423c = new ArrayList();
            } else {
                this.f10423c = arrayList;
            }
            this.f10424d = str2;
        }

        public String m12027a() {
            return this.f10421a;
        }

        public URL m12028b() {
            return this.f10422b;
        }

        public ArrayList<C3069a> m12029c() {
            return this.f10423c;
        }

        public String m12030d() {
            return this.f10424d;
        }
    }

    @gb
    /* renamed from: com.google.android.gms.b.cc.c */
    class C3071c {
        final /* synthetic */ cc f10425a;
        private final C3072d f10426b;
        private final boolean f10427c;
        private final String f10428d;

        public C3071c(cc ccVar, boolean z, C3072d c3072d, String str) {
            this.f10425a = ccVar;
            this.f10427c = z;
            this.f10426b = c3072d;
            this.f10428d = str;
        }

        public String m12031a() {
            return this.f10428d;
        }

        public C3072d m12032b() {
            return this.f10426b;
        }

        public boolean m12033c() {
            return this.f10427c;
        }
    }

    @gb
    /* renamed from: com.google.android.gms.b.cc.d */
    static class C3072d {
        private final String f10429a;
        private final int f10430b;
        private final List<C3069a> f10431c;
        private final String f10432d;

        public C3072d(String str, int i, List<C3069a> list, String str2) {
            this.f10429a = str;
            this.f10430b = i;
            if (list == null) {
                this.f10431c = new ArrayList();
            } else {
                this.f10431c = list;
            }
            this.f10432d = str2;
        }

        public String m12034a() {
            return this.f10429a;
        }

        public int m12035b() {
            return this.f10430b;
        }

        public Iterable<C3069a> m12036c() {
            return this.f10431c;
        }

        public String m12037d() {
            return this.f10432d;
        }
    }

    public cc(Context context, VersionInfoParcel versionInfoParcel) {
        this.f10433a = context;
        this.f10434b = versionInfoParcel;
    }

    protected C3070b m12038a(JSONObject jSONObject) {
        URL url;
        String optString = jSONObject.optString("http_request_id");
        String optString2 = jSONObject.optString("url");
        String optString3 = jSONObject.optString("post_body", null);
        try {
            url = new URL(optString2);
        } catch (Throwable e) {
            C2972b.m11580b("Error constructing http request.", e);
            url = null;
        }
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("headers");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(new C3069a(optJSONObject.optString("key"), optJSONObject.optString("value")));
            }
        }
        return new C3070b(optString, url, arrayList, optString3);
    }

    protected C3071c m12039a(C3070b c3070b) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) c3070b.m12028b().openConnection();
            C2968s.m11525e().m13039a(this.f10433a, this.f10434b.f10081b, false, httpURLConnection);
            Iterator it = c3070b.m12029c().iterator();
            while (it.hasNext()) {
                C3069a c3069a = (C3069a) it.next();
                httpURLConnection.addRequestProperty(c3069a.m12025a(), c3069a.m12026b());
            }
            if (!TextUtils.isEmpty(c3070b.m12030d())) {
                httpURLConnection.setDoOutput(true);
                byte[] bytes = c3070b.m12030d().getBytes();
                httpURLConnection.setFixedLengthStreamingMode(bytes.length);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                bufferedOutputStream.write(bytes);
                bufferedOutputStream.close();
            }
            List arrayList = new ArrayList();
            if (httpURLConnection.getHeaderFields() != null) {
                for (Entry entry : httpURLConnection.getHeaderFields().entrySet()) {
                    for (String c3069a2 : (List) entry.getValue()) {
                        arrayList.add(new C3069a((String) entry.getKey(), c3069a2));
                    }
                }
            }
            return new C3071c(this, true, new C3072d(c3070b.m12027a(), httpURLConnection.getResponseCode(), arrayList, C2968s.m11525e().m13026a(new InputStreamReader(httpURLConnection.getInputStream()))), null);
        } catch (Exception e) {
            return new C3071c(this, false, null, e.toString());
        }
    }

    protected JSONObject m12040a(C3072d c3072d) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("http_request_id", c3072d.m12034a());
            if (c3072d.m12037d() != null) {
                jSONObject.put(C4156a.f13961w, c3072d.m12037d());
            }
            JSONArray jSONArray = new JSONArray();
            for (C3069a c3069a : c3072d.m12036c()) {
                jSONArray.put(new JSONObject().put("key", c3069a.m12025a()).put("value", c3069a.m12026b()));
            }
            jSONObject.put("headers", jSONArray);
            jSONObject.put("response_code", c3072d.m12035b());
        } catch (Throwable e) {
            C2972b.m11580b("Error constructing JSON for http response.", e);
        }
        return jSONObject;
    }

    public JSONObject m12041a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject();
            Object obj = BuildConfig.FLAVOR;
            try {
                obj = jSONObject.optString("http_request_id");
                C3071c a = m12039a(m12038a(jSONObject));
                if (a.m12033c()) {
                    jSONObject2.put("response", m12040a(a.m12032b()));
                    jSONObject2.put(MsgConstant.KEY_SUCCESS, true);
                    return jSONObject2;
                }
                jSONObject2.put("response", new JSONObject().put("http_request_id", obj));
                jSONObject2.put(MsgConstant.KEY_SUCCESS, false);
                jSONObject2.put("reason", a.m12031a());
                return jSONObject2;
            } catch (Exception e) {
                try {
                    jSONObject2.put("response", new JSONObject().put("http_request_id", obj));
                    jSONObject2.put(MsgConstant.KEY_SUCCESS, false);
                    jSONObject2.put("reason", e.toString());
                    return jSONObject2;
                } catch (JSONException e2) {
                    return jSONObject2;
                }
            }
        } catch (JSONException e3) {
            C2972b.m11579b("The request is not a valid JSON.");
            try {
                return new JSONObject().put(MsgConstant.KEY_SUCCESS, false);
            } catch (JSONException e4) {
                return new JSONObject();
            }
        }
    }

    public void m12042a(ii iiVar, Map<String, String> map) {
        hi.m13004a(new C30681(this, map, iiVar));
    }
}
