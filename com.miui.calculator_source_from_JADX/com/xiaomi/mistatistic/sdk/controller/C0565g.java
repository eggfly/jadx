package com.xiaomi.mistatistic.sdk.controller;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.xiaomi.mistatistic.sdk.BuildSetting;
import com.xiaomi.mistatistic.sdk.controller.C0555d.C0523a;
import com.xiaomi.mistatistic.sdk.controller.C0571j.C0530b;
import com.xiaomi.mistatistic.sdk.controller.asyncjobs.C0542a;
import com.xiaomi.mistatistic.sdk.data.HttpEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.xiaomi.mistatistic.sdk.controller.g */
public class C0565g {
    private static C0565g f4739a;
    private HttpEventFilter f4740b;
    private List<HttpEvent> f4741c;
    private Handler f4742d;

    /* renamed from: com.xiaomi.mistatistic.sdk.controller.g.1 */
    class C05601 implements HttpEventFilter {
        final /* synthetic */ C0565g f4733a;

        C05601(C0565g c0565g) {
            this.f4733a = c0565g;
        }

        public HttpEvent m6394a(HttpEvent httpEvent) {
            Object a = httpEvent.m6544a();
            if (TextUtils.isEmpty(a)) {
                return null;
            }
            httpEvent.m6546a(a.split("\\?")[0]);
            return httpEvent;
        }
    }

    /* renamed from: com.xiaomi.mistatistic.sdk.controller.g.2 */
    class C05642 extends Handler {
        final /* synthetic */ C0565g f4738a;

        /* renamed from: com.xiaomi.mistatistic.sdk.controller.g.2.1 */
        class C05631 implements C0523a {
            final /* synthetic */ C05642 f4737a;

            /* renamed from: com.xiaomi.mistatistic.sdk.controller.g.2.1.1 */
            class C05611 implements C0530b {
                final /* synthetic */ List f4734a;
                final /* synthetic */ C05631 f4735b;

                C05611(C05631 c05631, List list) {
                    this.f4735b = c05631;
                    this.f4734a = list;
                }

                public void m6395a(String str) {
                    Object obj = null;
                    C0566h.m6414a("http data complete, result=" + str);
                    try {
                        if (!TextUtils.isEmpty(str)) {
                            JSONObject jSONObject = new JSONObject(str);
                            if ("ok".equals(jSONObject.getString("status"))) {
                                this.f4735b.f4737a.f4738a.m6406a(jSONObject);
                                obj = 1;
                            }
                        }
                        if (obj != null) {
                            synchronized (this.f4735b.f4737a.f4738a.f4741c) {
                                C0566h.m6414a("upload success, synchronizing remove http events " + this.f4734a.size());
                                this.f4735b.f4737a.f4738a.f4741c.removeAll(this.f4734a);
                            }
                        }
                    } catch (Throwable e) {
                        C0566h.m6418a("upload events response exception:", e);
                    }
                }
            }

            /* renamed from: com.xiaomi.mistatistic.sdk.controller.g.2.1.2 */
            class C05622 implements C0530b {
                final /* synthetic */ C05631 f4736a;

                C05622(C05631 c05631) {
                    this.f4736a = c05631;
                }

                public void m6396a(String str) {
                    C0566h.m6414a("upload empty http events result:" + str);
                }
            }

            C05631(C05642 c05642) {
                this.f4737a = c05642;
            }

            public void m6397a() {
                if (this.f4737a.f4738a.m6408c()) {
                    try {
                        List b = this.f4737a.f4738a.m6407b();
                        int size = b.size();
                        for (int i = 0; i < size; i += 30) {
                            List subList;
                            if (i + 30 >= size) {
                                subList = b.subList(i, size);
                            } else {
                                subList = b.subList(i, i + 30);
                            }
                            this.f4737a.f4738a.m6401a(subList, new C05611(this, subList));
                        }
                    } catch (Throwable e) {
                        C0566h.m6418a("", e);
                    } catch (Throwable e2) {
                        C0566h.m6418a("", e2);
                    }
                } else if (this.f4737a.f4738a.m6409d()) {
                    try {
                        this.f4737a.f4738a.m6405a(new JSONArray().toString(), new C05622(this));
                    } catch (Throwable e22) {
                        C0566h.m6418a("", e22);
                    } catch (Throwable e222) {
                        C0566h.m6418a("", e222);
                    }
                }
            }
        }

        C05642(C0565g c0565g, Looper looper) {
            this.f4738a = c0565g;
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1023:
                    C0555d.m6364b().m6365a(new C05631(this));
                default:
            }
        }
    }

    static {
        f4739a = new C0565g();
    }

    public static C0565g m6398a() {
        return f4739a;
    }

    private C0565g() {
        this.f4741c = new LinkedList();
        this.f4742d = new C05642(this, Looper.getMainLooper());
        this.f4740b = new C05601(this);
    }

    public List<HttpEvent> m6407b() {
        List linkedList;
        synchronized (this.f4741c) {
            linkedList = new LinkedList(this.f4741c);
        }
        return linkedList;
    }

    public boolean m6408c() {
        if (System.currentTimeMillis() <= C0573k.m6444a(C0551c.m6352a(), "rt_ban_time", 0) || Math.random() * 10000.0d > ((double) C0573k.m6443a(C0551c.m6352a(), "rt_upload_rate", 10000))) {
            return false;
        }
        return true;
    }

    public boolean m6409d() {
        return System.currentTimeMillis() - C0573k.m6444a(C0551c.m6352a(), "rt_update_time", 0) > 86400000;
    }

    public void m6404a(HttpEvent httpEvent) {
        Context a = C0551c.m6352a();
        if (a == null) {
            C0566h.m6414a("add http event without initialization.");
        } else if (BuildSetting.m6241a(a)) {
            C0566h.m6414a("disabled the http event upload");
        } else if (!m6402a(httpEvent.m6544a()) || BuildSetting.m6242b()) {
            if (!(this.f4740b == null || httpEvent.m6544a().equals(m6403f()))) {
                httpEvent = this.f4740b.m6291a(httpEvent);
            }
            if (httpEvent != null && !TextUtils.isEmpty(httpEvent.m6544a())) {
                synchronized (this.f4741c) {
                    this.f4741c.add(httpEvent);
                    if (this.f4741c.size() > 100) {
                        this.f4741c.remove(0);
                    }
                }
                if (!this.f4742d.hasMessages(1023) && !httpEvent.m6544a().equals(m6403f())) {
                    C0542a.m6320b();
                    this.f4742d.sendEmptyMessageDelayed(1023, m6410e());
                }
            }
        }
    }

    public long m6410e() {
        return C0573k.m6444a(C0551c.m6352a(), "rt_upload_delay", 300000);
    }

    private String m6403f() {
        return BuildSetting.m6240a() ? "http://10.99.168.145:8097/realtime_network" : "https://data.mistat.xiaomi.com/realtime_network";
    }

    private boolean m6402a(String str) {
        if (str.equals(m6403f()) || str.equals("https://data.mistat.xiaomi.com/micrash") || str.equals("https://data.mistat.xiaomi.com/mistats") || str.equals("http://data.mistat.xiaomi.com/mistats/v2") || str.equals("http://abtest.mistat.xiaomi.com/experiments")) {
            return true;
        }
        return false;
    }

    private void m6401a(List<HttpEvent> list, C0530b c0530b) {
        Map hashMap = new HashMap();
        for (HttpEvent httpEvent : list) {
            CharSequence a = httpEvent.m6544a();
            if (!TextUtils.isEmpty(a)) {
                if (hashMap.containsKey(a)) {
                    ((List) hashMap.get(a)).add(httpEvent);
                } else {
                    hashMap.put(a, new ArrayList());
                    ((List) hashMap.get(a)).add(httpEvent);
                }
            }
        }
        if (!hashMap.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (String str : hashMap.keySet()) {
                JSONArray jSONArray2 = new JSONArray();
                for (HttpEvent c : (List) hashMap.get(str)) {
                    jSONArray2.put(c.m6549c());
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str);
                jSONObject.put("data", jSONArray2);
                jSONArray.put(jSONObject);
            }
            m6405a(jSONArray.toString(), c0530b);
        }
    }

    public void m6405a(String str, C0530b c0530b) {
        Map treeMap = new TreeMap();
        treeMap.put("app_id", C0551c.m6354b());
        treeMap.put("app_package", C0551c.m6359g());
        treeMap.put("app_key", C0551c.m6355c());
        treeMap.put("device_uuid", C0557e.m6368a(C0551c.m6352a()));
        treeMap.put("device_os", "android" + VERSION.SDK_INT);
        treeMap.put("device_model", Build.MODEL);
        treeMap.put("app_version", C0551c.m6357e());
        treeMap.put("app_channel", C0551c.m6356d());
        treeMap.put("time", String.valueOf(System.currentTimeMillis()));
        treeMap.put("net_value", str);
        C0571j.m6434a(m6403f(), treeMap, c0530b);
    }

    public void m6406a(JSONObject jSONObject) {
        if (jSONObject.has("data")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            int optInt = jSONObject2.optInt("sample_rate", 10000);
            int optInt2 = jSONObject2.optInt("delay", 300000);
            long optLong = jSONObject2.optLong("ban_time", 0);
            C0573k.m6450b(C0551c.m6352a(), "rt_upload_rate", optInt);
            C0573k.m6451b(C0551c.m6352a(), "rt_upload_delay", (long) optInt2);
            C0573k.m6451b(C0551c.m6352a(), "rt_ban_time", optLong);
            C0573k.m6451b(C0551c.m6352a(), "rt_update_time", System.currentTimeMillis());
        }
    }
}
