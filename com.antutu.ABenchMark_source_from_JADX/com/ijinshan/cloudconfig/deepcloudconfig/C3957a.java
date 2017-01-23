package com.ijinshan.cloudconfig.deepcloudconfig;

import android.content.Context;
import android.text.TextUtils;
import com.ijinshan.cloudconfig.p188c.C3952a;
import com.ijinshan.cloudconfig.p189d.C3953a;
import com.taobao.accs.common.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.ijinshan.cloudconfig.deepcloudconfig.a */
public class C3957a {
    private static C3957a f13271a;
    private HashMap<Integer, HashMap<String, List<ConfigInfo>>> f13272b;
    private Context f13273c;
    private final Object f13274d;
    private List<String> f13275e;

    private C3957a() {
        this.f13274d = new Object();
        this.f13273c = C3952a.m16250d();
        this.f13272b = new HashMap();
        this.f13275e = new ArrayList();
    }

    public static C3957a m16278a() {
        if (f13271a == null) {
            synchronized (C3957a.class) {
                if (f13271a == null) {
                    f13271a = new C3957a();
                }
            }
        }
        return f13271a;
    }

    private String m16279c() {
        try {
            if (this.f13273c == null) {
                this.f13273c = C3952a.m16250d();
            }
            return new StringBuilder(String.valueOf(this.f13273c.getApplicationContext().getDir("deep_cloud_config", 0).getAbsolutePath())).append(File.separator).append("cloudmsgadv.json").toString();
        } catch (Exception e) {
            return BuildConfig.FLAVOR;
        }
    }

    public List<ConfigInfo> m16280a(Integer num, String str) {
        HashMap hashMap = (HashMap) this.f13272b.get(num);
        if (hashMap == null) {
            return null;
        }
        List<ConfigInfo> arrayList = new ArrayList();
        if (hashMap.get(str) != null) {
            arrayList.addAll((Collection) hashMap.get(str));
        }
        return (arrayList == null || arrayList.size() <= 0) ? null : arrayList;
    }

    public synchronized void m16281a(JSONObject jSONObject) {
        HashMap hashMap;
        if (jSONObject != null) {
            HashMap hashMap2;
            if (this.f13272b != null) {
                hashMap2 = new HashMap(this.f13272b);
                this.f13272b.clear();
            } else {
                hashMap2 = null;
            }
            try {
                this.f13275e.clear();
                JSONArray jSONArray = jSONObject.getJSONArray(Constants.KEY_DATA);
                if (jSONArray == null || jSONArray.length() < 1) {
                    hashMap = hashMap2;
                } else {
                    HashMap hashMap3;
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        CharSequence optString = jSONObject2.optString(AgooConstants.MESSAGE_ID, BuildConfig.FLAVOR);
                        if (!TextUtils.isEmpty(optString)) {
                            this.f13275e.add(optString);
                        }
                        hashMap = (HashMap) this.f13272b.get(Integer.valueOf(jSONObject2.optInt("func_type")));
                        hashMap3 = hashMap == null ? new HashMap() : hashMap;
                        List list = (List) hashMap3.get(jSONObject2.opt("section"));
                        if (list == null) {
                            list = new ArrayList();
                        }
                        ConfigInfo configInfo = new ConfigInfo();
                        configInfo.m16274a(jSONObject2.optInt("func_type"));
                        configInfo.m16276b(jSONObject2.optInt("priority"));
                        configInfo.m16275a(jSONObject2.optString("section"));
                        configInfo.m16277b(jSONObject2.get("key_value").toString());
                        list.add(configInfo);
                        hashMap3.put(jSONObject2.optString("section"), list);
                        this.f13272b.put(Integer.valueOf(jSONObject2.optInt("func_type")), hashMap3);
                    }
                    for (Integer num : this.f13272b.keySet()) {
                        hashMap3 = (HashMap) this.f13272b.get(num);
                        for (String str : hashMap3.keySet()) {
                            List list2 = (List) hashMap3.get(str);
                            if (list2.size() > 1) {
                                Collections.sort(list2);
                                hashMap3.put(str, list2);
                            }
                        }
                        this.f13272b.put(num, hashMap3);
                    }
                    hashMap = hashMap2;
                }
            } catch (Exception e) {
                if (hashMap2 != null) {
                    this.f13272b = hashMap2;
                    hashMap2.clear();
                    hashMap = null;
                } else {
                    hashMap = hashMap2;
                }
                C3961e.m16292a().m16304a(false);
            }
        } else {
            hashMap = null;
        }
        if (!(hashMap == null || jSONObject == null)) {
            hashMap.clear();
            C3958b.m16289a();
        }
    }

    public String m16282b(Integer num, String str) {
        List arrayList = new ArrayList();
        if (m16280a(num, str) != null) {
            arrayList.addAll(m16280a(num, str));
        }
        if (arrayList == null || arrayList.size() < 1) {
            return BuildConfig.FLAVOR;
        }
        ConfigInfo configInfo = (ConfigInfo) arrayList.get(0);
        return (configInfo == null || configInfo.m16273a() == null) ? BuildConfig.FLAVOR : configInfo.m16273a();
    }

    public void m16283b() {
        m16281a(C3953a.m16254a(m16279c()));
    }
}
