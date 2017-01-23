package com.xiaomi.mistatistic.sdk.controller.asyncjobs;

import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.xiaomi.mistatistic.sdk.controller.C0555d.C0523a;
import com.xiaomi.mistatistic.sdk.controller.C0559f;
import com.xiaomi.mistatistic.sdk.controller.C0566h;
import com.xiaomi.mistatistic.sdk.controller.C0579l;
import com.xiaomi.mistatistic.sdk.data.StatEventPojo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.xiaomi.mistatistic.sdk.controller.asyncjobs.b */
public class C0545b implements C0523a {
    private static int f4691a;
    private long f4692b;
    private C0543a f4693c;
    private HashMap<String, JSONObject> f4694d;
    private HashMap<String, JSONObject> f4695e;
    private ArrayList<String> f4696f;
    private JSONObject f4697g;
    private long f4698h;

    /* renamed from: com.xiaomi.mistatistic.sdk.controller.asyncjobs.b.a */
    public interface C0543a {
        void m6328a(String str, long j, long j2, int i);
    }

    /* renamed from: com.xiaomi.mistatistic.sdk.controller.asyncjobs.b.b */
    public class C0544b {
        int f4686a;
        final /* synthetic */ C0545b f4687b;
        private JSONArray f4688c;
        private long f4689d;
        private long f4690e;

        public C0544b(C0545b c0545b, JSONArray jSONArray, long j, long j2, int i) {
            this.f4687b = c0545b;
            this.f4688c = jSONArray;
            this.f4689d = j;
            this.f4690e = j2;
            this.f4686a = i;
        }
    }

    static {
        f4691a = 0;
    }

    public C0545b(long j, C0543a c0543a) {
        this.f4694d = new HashMap();
        this.f4695e = new HashMap();
        this.f4696f = new ArrayList();
        this.f4697g = null;
        this.f4698h = System.currentTimeMillis();
        this.f4692b = j;
        this.f4693c = c0543a;
    }

    public void m6338a() {
        try {
            C0544b a = m6337a(Long.MAX_VALUE);
            if (a.f4688c != null) {
                this.f4693c.m6328a(a.f4688c.toString(), a.f4689d, a.f4690e, a.f4686a);
            } else {
                this.f4693c.m6328a("", a.f4689d, a.f4690e, a.f4686a);
            }
            if (a.f4686a >= 500) {
                C0566h.m6414a(String.format("Packing %d events over MAX_PACKING_EVENT %d", new Object[]{Integer.valueOf(a.f4686a), Integer.valueOf(500)}));
                if (f4691a < 50) {
                    new C0579l().m6470a();
                    f4691a++;
                    return;
                }
                C0566h.m6425d("Packing, exceeded MAX_UPLOAD_TIMES 50");
                return;
            }
            f4691a = 0;
        } catch (Throwable e) {
            C0566h.m6418a("remote data packing job execute exception:", e);
            this.f4693c.m6328a("", 0, 0, 0);
        }
    }

    public C0544b m6337a(long j) {
        long j2;
        JSONArray jSONArray;
        long j3;
        JSONArray jSONArray2;
        JSONArray jSONArray3 = new JSONArray();
        long j4 = 0;
        long j5 = 0;
        C0559f c0559f = new C0559f();
        c0559f.m6385b();
        m6333b();
        this.f4698h = System.currentTimeMillis();
        List a = c0559f.m6379a(j);
        if (a != null) {
            try {
                if (a.size() > 0) {
                    C0566h.m6414a(String.format("Packing, get %d events from local DB", new Object[]{Integer.valueOf(a.size())}));
                    j2 = 0;
                    j4 = 0;
                    int i = 0;
                    while (i < a.size()) {
                        try {
                            StatEventPojo statEventPojo = (StatEventPojo) a.get(i);
                            C0566h.m6414a("Packing: " + statEventPojo.toString());
                            if (j2 == 0) {
                                j2 = statEventPojo.f4822b;
                                this.f4698h = j2;
                            }
                            j4 = statEventPojo.f4822b;
                            if (this.f4692b > 0 && this.f4698h - statEventPojo.f4822b > this.f4692b && this.f4697g != null) {
                                m6333b();
                                this.f4698h = statEventPojo.f4822b;
                            }
                            if (this.f4697g == null) {
                                this.f4697g = new JSONObject();
                                this.f4697g.put("endTS", statEventPojo.f4822b);
                                this.f4697g.put("content", new JSONArray());
                                jSONArray3.put(this.f4697g);
                            }
                            if ("mistat_session".equals(statEventPojo.f4821a)) {
                                m6332a(statEventPojo);
                            } else if ("mistat_pv".equals(statEventPojo.f4821a)) {
                                m6334b(statEventPojo);
                            } else if ("mistat_pt".equals(statEventPojo.f4821a)) {
                                m6335c(statEventPojo);
                            } else {
                                m6336d(statEventPojo);
                            }
                            this.f4697g.put("startTS", statEventPojo.f4822b);
                            i++;
                        } catch (SQLiteException e) {
                            Throwable e2 = e;
                            long j6 = j4;
                            j4 = j2;
                            j2 = j6;
                        }
                    }
                    C0566h.m6414a("Packing complete, total " + a.size() + " records were packed and to be uploaded");
                    j5 = j4;
                    j4 = j2;
                    jSONArray = jSONArray3;
                    j3 = j4;
                    jSONArray2 = jSONArray;
                    j2 = j5;
                    return new C0544b(this, jSONArray2, j2, j3, 0);
                }
            } catch (Throwable e3) {
                Throwable th = e3;
                j2 = 0;
                e2 = th;
                C0566h.m6418a("packing exception:", e2);
                jSONArray2 = jSONArray3;
                j3 = j4;
                return new C0544b(this, jSONArray2, j2, j3, 0);
            }
        }
        C0566h.m6414a("No data available to be packed");
        jSONArray = null;
        j3 = j4;
        jSONArray2 = jSONArray;
        j2 = j5;
        return new C0544b(this, jSONArray2, j2, j3, 0);
    }

    private void m6333b() {
        this.f4697g = null;
        this.f4694d.clear();
        this.f4696f.clear();
        this.f4695e.clear();
    }

    private void m6332a(StatEventPojo statEventPojo) {
        JSONObject jSONObject = (JSONObject) this.f4694d.get("mistat_session");
        if (jSONObject == null) {
            JSONArray jSONArray = new JSONArray();
            jSONObject = new JSONObject();
            jSONObject.put("category", "mistat_session");
            jSONObject.put("values", jSONArray);
            this.f4694d.put("mistat_session", jSONObject);
            this.f4697g.getJSONArray("content").put(jSONObject);
        }
        JSONObject jSONObject2 = new JSONObject();
        String[] split = statEventPojo.f4825e.split(",");
        long parseLong = Long.parseLong(split[0]);
        long parseLong2 = Long.parseLong(split[1]);
        jSONObject2.put("start", parseLong);
        jSONObject2.put("end", parseLong2);
        jSONObject2.put("env", statEventPojo.f4826f);
        jSONObject.getJSONArray("values").put(jSONObject2);
    }

    private void m6334b(StatEventPojo statEventPojo) {
        JSONObject jSONObject = (JSONObject) this.f4694d.get("mistat_pv");
        if (jSONObject == null) {
            jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            jSONObject.put("category", "mistat_pv");
            jSONObject.put("values", jSONArray);
            jSONObject.put("source", jSONArray2);
            this.f4694d.put("mistat_pv", jSONObject);
            this.f4697g.getJSONArray("content").put(jSONObject);
        }
        String[] split = statEventPojo.f4825e.trim().split(",");
        String[] strArr = new String[split.length];
        for (int i = 0; i < split.length; i++) {
            int indexOf = this.f4696f.indexOf(split[i]);
            if (indexOf >= 0) {
                strArr[i] = String.valueOf(indexOf + 1);
            } else {
                strArr[i] = String.valueOf(this.f4696f.size() + 1);
                this.f4696f.add(split[i]);
            }
        }
        jSONObject.getJSONArray("values").put(TextUtils.join(",", strArr));
        jSONObject.put("index", TextUtils.join(",", this.f4696f));
        if (TextUtils.isEmpty(statEventPojo.f4826f)) {
            jSONObject.getJSONArray("source").put("");
        } else {
            jSONObject.getJSONArray("source").put(statEventPojo.f4826f);
        }
    }

    private void m6335c(StatEventPojo statEventPojo) {
        JSONObject jSONObject = (JSONObject) this.f4694d.get("mistat_pt");
        if (jSONObject == null) {
            jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONObject.put("category", "mistat_pt");
            jSONObject.put("values", jSONArray);
            this.f4694d.put("mistat_pt", jSONObject);
            this.f4697g.getJSONArray("content").put(jSONObject);
        }
        JSONArray jSONArray2 = jSONObject.getJSONArray("values");
        for (int i = 0; i < jSONArray2.length(); i++) {
            JSONObject jSONObject2 = jSONArray2.getJSONObject(i);
            if (TextUtils.equals(jSONObject2.getString("key"), statEventPojo.f4823c)) {
                jSONObject2.put("value", jSONObject2.getString("value") + "," + statEventPojo.f4825e);
                return;
            }
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("key", statEventPojo.f4823c);
        jSONObject3.put("value", statEventPojo.f4825e);
        jSONObject.getJSONArray("values").put(jSONObject3);
    }

    private void m6336d(StatEventPojo statEventPojo) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = (JSONObject) this.f4694d.get(statEventPojo.f4821a);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONObject2.put("category", statEventPojo.f4821a);
            jSONObject2.put("values", jSONArray);
            this.f4694d.put(statEventPojo.f4821a, jSONObject2);
            this.f4697g.getJSONArray("content").put(jSONObject2);
            jSONObject = jSONObject2;
        } else {
            jSONObject = jSONObject2;
        }
        if ("event".equals(statEventPojo.f4824d) && TextUtils.isEmpty(statEventPojo.f4826f)) {
            jSONObject2 = (JSONObject) this.f4695e.get(statEventPojo.f4823c);
            if (jSONObject2 != null) {
                jSONObject2.put("value", jSONObject2.getLong("value") + Long.parseLong(statEventPojo.f4825e));
                return;
            }
            jSONObject2 = new JSONObject();
            jSONObject2.put("key", statEventPojo.f4823c);
            jSONObject2.put("type", statEventPojo.f4824d);
            jSONObject2.put("value", Long.parseLong(statEventPojo.f4825e));
            jSONObject.getJSONArray("values").put(jSONObject2);
            this.f4695e.put(statEventPojo.f4823c, jSONObject2);
        } else if ("mistat_extra".equals(statEventPojo.f4821a)) {
            jSONObject.getJSONArray("values").put(statEventPojo.f4825e);
        } else {
            jSONObject2 = new JSONObject();
            jSONObject2.put("key", statEventPojo.f4823c);
            jSONObject2.put("type", statEventPojo.f4824d);
            if ("count".equals(statEventPojo.f4824d) || "numeric".equals(statEventPojo.f4824d)) {
                jSONObject2.put("value", Long.parseLong(statEventPojo.f4825e));
            } else {
                jSONObject2.put("value", statEventPojo.f4825e);
            }
            if (!TextUtils.isEmpty(statEventPojo.f4826f)) {
                jSONObject2.put("params", new JSONObject(statEventPojo.f4826f));
            }
            jSONObject.getJSONArray("values").put(jSONObject2);
        }
    }
}
