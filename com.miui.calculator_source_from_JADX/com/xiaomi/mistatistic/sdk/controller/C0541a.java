package com.xiaomi.mistatistic.sdk.controller;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.xiaomi.mistatistic.sdk.controller.C0571j.C0530b;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.xiaomi.mistatistic.sdk.controller.a */
public class C0541a {
    private static final ExecutorService f4683a;
    private static int f4684b;

    /* renamed from: com.xiaomi.mistatistic.sdk.controller.a.1 */
    class C05401 implements Runnable {
        final /* synthetic */ Context f4681a;
        final /* synthetic */ C0541a f4682b;

        /* renamed from: com.xiaomi.mistatistic.sdk.controller.a.1.1 */
        class C05391 implements C0530b {
            final /* synthetic */ C05401 f4680a;

            C05391(C05401 c05401) {
                this.f4680a = c05401;
            }

            public void m6308a(String str) {
                this.f4680a.f4682b.m6315a(str, this.f4680a.f4681a);
            }
        }

        public void run() {
            C0541a.m6316b(this.f4681a, new C05391(this));
        }
    }

    static {
        f4683a = Executors.newCachedThreadPool();
        f4684b = 0;
    }

    private void m6315a(String str, Context context) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.getInt("errorCode") != 0 || TextUtils.isEmpty(str)) {
                C0566h.m6415a("ABTEST", "Error to getServiceDate the error:" + jSONObject.getInt("errorCode"));
                m6312a(context, 0);
                return;
            }
            C0566h.m6420b("ABTEST", "\u83b7\u53d6\u6570\u636e\u89e3\u6790JSON");
            JSONArray jSONArray = jSONObject.getJSONArray("result");
            m6312a(context, System.currentTimeMillis());
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                int i2 = jSONObject2.getInt("experiment_id");
                int i3 = jSONObject2.getInt("status");
                Boolean valueOf = Boolean.valueOf(jSONObject2.getBoolean("isAbTest"));
                m6309a(context, i2, i3);
                m6310a(context, i2, valueOf);
                jSONObject2 = jSONObject2.optJSONObject("content");
                if (jSONObject2 != null && jSONObject2.length() > 0) {
                    Iterator keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String obj = keys.next().toString();
                        m6311a(context, i2, obj, jSONObject2.getString(obj));
                    }
                }
            }
        } catch (Throwable e) {
            C0566h.m6416a("ABTEST", "Error to getControlVarValue the exception ", e);
        }
    }

    private void m6312a(Context context, long j) {
        Editor edit = context.getSharedPreferences("mistat_metrics", 0).edit();
        edit.putLong("deploy_last_time", j);
        edit.apply();
    }

    private void m6309a(Context context, int i, int i2) {
        Editor edit = context.getSharedPreferences("mistat_metrics", 0).edit();
        edit.putInt(i + "-" + "status", i2);
        edit.apply();
    }

    private void m6310a(Context context, int i, Boolean bool) {
        Editor edit = context.getSharedPreferences("mistat_metrics", 0).edit();
        edit.putBoolean(i + "-" + "isAbTest", bool.booleanValue());
        edit.apply();
    }

    private void m6311a(Context context, int i, String str, String str2) {
        Editor edit = context.getSharedPreferences("mistat_metrics", 0).edit();
        edit.putString(i + "-" + str, str2);
        edit.apply();
    }

    private static void m6316b(Context context, C0530b c0530b) {
        Map treeMap = new TreeMap();
        treeMap.put("app_id", C0551c.m6354b());
        treeMap.put("device_id", C0557e.m6368a(context));
        treeMap.put("package_name", context.getPackageName());
        C0566h.m6415a("ABTEST", "ServiceData the papameters: " + treeMap);
        try {
            C0571j.m6433a(context, "http://abtest.mistat.xiaomi.com/experiments", treeMap, c0530b);
        } catch (Throwable e) {
            f4684b++;
            C0566h.m6416a("ABTEST", " retry " + f4684b + ", Error to getServiceDate the exception ", e);
            if (f4684b < 3) {
                C0541a.m6316b(context, c0530b);
            } else {
                f4684b = 0;
            }
        }
    }
}
