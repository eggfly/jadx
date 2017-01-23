package com.facebook.ads.internal.util;

import com.facebook.ads.internal.server.AdPlacementType;
import com.taobao.accs.common.Constants;
import com.umeng.message.proguard.C4233j;
import com.umeng.message.proguard.C4239k;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.util.b */
public class C2489b {
    public static String f8566a;
    private String f8567b;
    private Map<String, Object> f8568c;
    private int f8569d;
    private String f8570e;

    /* renamed from: com.facebook.ads.internal.util.b.a */
    public enum C2487a {
        OPEN_STORE(0),
        OPEN_LINK(1),
        XOUT(2),
        OPEN_URL(3),
        SHOW_INTERSTITIAL(4);
        
        int f8562f;

        private C2487a(int i) {
            this.f8562f = i;
        }
    }

    /* renamed from: com.facebook.ads.internal.util.b.b */
    public enum C2488b {
        LOADING_AD(0);
        
        int f8565b;

        private C2488b(int i) {
            this.f8565b = i;
        }
    }

    static {
        f8566a = null;
    }

    public C2489b(String str, Map<String, Object> map, int i, String str2) {
        this.f8567b = str;
        this.f8568c = map;
        this.f8569d = i;
        this.f8570e = str2;
    }

    public static C2489b m9451a(long j, C2487a c2487a, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        Map hashMap = new HashMap();
        hashMap.put(C4239k.f14432k, String.valueOf(currentTimeMillis - j));
        hashMap.put("AdAction", String.valueOf(c2487a.f8562f));
        return new C2489b("bounceback", hashMap, (int) (currentTimeMillis / 1000), str);
    }

    public static C2489b m9452a(C2488b c2488b, AdPlacementType adPlacementType, long j, String str) {
        Map hashMap = new HashMap();
        hashMap.put("LatencyType", String.valueOf(c2488b.f8565b));
        hashMap.put("AdPlacementType", adPlacementType.toString());
        hashMap.put(C4239k.f14432k, String.valueOf(j));
        String str2 = "latency";
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (str == null) {
            str = f8566a;
        }
        return new C2489b(str2, hashMap, currentTimeMillis, str);
    }

    public static C2489b m9453a(Throwable th, String str) {
        Map hashMap = new HashMap();
        hashMap.put("ex", th.getClass().getSimpleName());
        hashMap.put("ex_msg", th.getMessage());
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        String str2 = C4233j.f14375B;
        if (str == null) {
            str = f8566a;
        }
        return new C2489b(str2, hashMap, currentTimeMillis, str);
    }

    public JSONObject m9454a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.f8567b);
            jSONObject.put(Constants.KEY_DATA, new JSONObject(this.f8568c));
            jSONObject.put(C4233j.f14377D, this.f8569d);
            jSONObject.put("request_id", this.f8570e);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
