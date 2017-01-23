package com.xiaomi.mistatistic.sdk.controller.asyncjobs;

import android.text.TextUtils;
import com.xiaomi.mistatistic.sdk.BuildSetting;
import com.xiaomi.mistatistic.sdk.controller.C0549b;
import com.xiaomi.mistatistic.sdk.controller.C0551c;
import com.xiaomi.mistatistic.sdk.controller.C0555d.C0523a;
import com.xiaomi.mistatistic.sdk.controller.C0557e;
import com.xiaomi.mistatistic.sdk.controller.C0566h;
import com.xiaomi.mistatistic.sdk.controller.C0571j;
import com.xiaomi.mistatistic.sdk.controller.C0571j.C0530b;
import com.xiaomi.mistatistic.sdk.controller.C0579l;
import com.xiaomi.mistatistic.sdk.controller.C0588o;
import com.xiaomi.mistatistic.sdk.controller.C0596p;
import com.xiaomi.mistatistic.sdk.controller.C0597q;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* renamed from: com.xiaomi.mistatistic.sdk.controller.asyncjobs.c */
public class C0548c implements C0523a {
    private C0547a f4700a;
    private String f4701b;
    private int f4702c;

    /* renamed from: com.xiaomi.mistatistic.sdk.controller.asyncjobs.c.1 */
    class C05461 implements C0530b {
        final /* synthetic */ C0548c f4699a;

        C05461(C0548c c0548c) {
            this.f4699a = c0548c;
        }

        public void m6339a(String str) {
            boolean z = false;
            try {
                z = this.f4699a.m6345a(str);
            } catch (Throwable e) {
                C0566h.m6418a("Upload MiStat data failed: ", e);
            }
            this.f4699a.f4700a.m6340a(z);
        }
    }

    /* renamed from: com.xiaomi.mistatistic.sdk.controller.asyncjobs.c.a */
    public interface C0547a {
        void m6340a(boolean z);
    }

    public C0548c(String str, C0547a c0547a, int i) {
        this.f4700a = c0547a;
        this.f4701b = str;
        this.f4702c = i;
    }

    public void m6346a() {
        try {
            int g = C0596p.m6514a().m6523g();
            long f = C0596p.m6514a().m6522f();
            Map treeMap = new TreeMap();
            treeMap.put("app_id", C0551c.m6354b());
            treeMap.put("app_key", C0551c.m6355c());
            treeMap.put("device_id", new C0557e().m6372a());
            treeMap.put("channel", C0551c.m6356d());
            treeMap.put("policy", String.valueOf(g));
            treeMap.put("interval", String.valueOf(f));
            C0566h.m6414a(String.format("upload policy:%d, upload interval:%d, mistat upload version:%d, upload %d events.", new Object[]{Integer.valueOf(g), Long.valueOf(f), Integer.valueOf(3), Integer.valueOf(this.f4702c)}));
            CharSequence e = C0551c.m6357e();
            if (!TextUtils.isEmpty(e)) {
                treeMap.put("version", e);
            }
            C0566h.m6419b("raw upload content:" + this.f4701b);
            treeMap.put("stat_value", C0549b.m6347a(this.f4701b, m6342a(C0551c.m6354b(), C0551c.m6355c(), new C0557e().m6372a())));
            treeMap.put("mistatv", String.valueOf(3));
            treeMap.put("size", String.valueOf(this.f4702c));
            C0571j.m6434a(BuildSetting.m6240a() ? "http://10.235.124.13:8097/mistats" : "http://data.mistat.xiaomi.com/mistats/v2", treeMap, new C05461(this));
        } catch (Exception e2) {
            C0566h.m6426d("RDUJ", "RemoteDataUploadJob exception: " + e2.getMessage());
            this.f4700a.m6340a(false);
        }
    }

    private boolean m6345a(String str) {
        C0566h.m6424c("RDUJ", "Upload complete, result: " + (str == null ? "" : str.trim()));
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("status");
                m6343a(jSONObject);
                if ("ok".equals(string)) {
                    if ("test ok".equals(jSONObject.optString("reason"))) {
                        C0588o.m6492a().m6499c();
                        C0566h.m6414a("test ok, enable shake detector");
                    } else {
                        C0588o.m6492a().m6500d();
                        C0566h.m6414a("test not ok, disable shake detector");
                    }
                    return true;
                }
                C0566h.m6423c("result status isn't ok, " + string);
            } catch (Throwable e) {
                C0566h.m6418a("parseUploadingResult exception ", e);
            }
        }
        return false;
    }

    private void m6343a(JSONObject jSONObject) {
        if (jSONObject.has("data")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            if (jSONObject2.has("delay")) {
                C0579l.m6458a(jSONObject2.getLong("delay"));
            }
        }
    }

    private String m6342a(String str, String str2, String str3) {
        return C0597q.m6531b(String.format("seed:%s-%s-%s", new Object[]{str, str2, str3})).substring(0, 16);
    }
}
