package com.google.android.gms.p146b;

import com.google.android.gms.ads.internal.util.client.C2972b;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONObject;

@gb
/* renamed from: com.google.android.gms.b.cg */
public class cg implements cb {
    final HashMap<String, hw<JSONObject>> f10436a;

    public cg() {
        this.f10436a = new HashMap();
    }

    public Future<JSONObject> m12044a(String str) {
        Future hwVar = new hw();
        this.f10436a.put(str, hwVar);
        return hwVar;
    }

    public void m12045a(ii iiVar, Map<String, String> map) {
        m12046a((String) map.get("request_id"), (String) map.get("fetched_ad"));
    }

    public void m12046a(String str, String str2) {
        C2972b.m11576a("Received ad from the cache.");
        hw hwVar = (hw) this.f10436a.get(str);
        if (hwVar == null) {
            C2972b.m11579b("Could not find the ad request for the corresponding ad response.");
            return;
        }
        try {
            hwVar.m12217b(new JSONObject(str2));
        } catch (Throwable e) {
            C2972b.m11580b("Failed constructing JSON object from value passed from javascript", e);
            hwVar.m12217b(null);
        } finally {
            this.f10436a.remove(str);
        }
    }

    public void m12047b(String str) {
        hw hwVar = (hw) this.f10436a.get(str);
        if (hwVar == null) {
            C2972b.m11579b("Could not find the ad request for the corresponding ad response.");
            return;
        }
        if (!hwVar.isDone()) {
            hwVar.cancel(true);
        }
        this.f10436a.remove(str);
    }
}
