package com.google.android.gms.p146b;

import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.util.client.C2972b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@gb
/* renamed from: com.google.android.gms.b.dl */
public final class dl {
    public final List<dk> f10650a;
    public final long f10651b;
    public final List<String> f10652c;
    public final List<String> f10653d;
    public final List<String> f10654e;
    public final String f10655f;
    public final long f10656g;
    public final String f10657h;
    public final int f10658i;
    public final int f10659j;
    public final long f10660k;
    public int f10661l;
    public int f10662m;

    public dl(String str) {
        JSONObject jSONObject = new JSONObject(str);
        if (C2972b.m11578a(2)) {
            hf.m12982e("Mediation Response JSON: " + jSONObject.toString(2));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        List arrayList = new ArrayList(jSONArray.length());
        int i = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            dk dkVar = new dk(jSONArray.getJSONObject(i2));
            arrayList.add(dkVar);
            if (i < 0 && m12293a(dkVar)) {
                i = i2;
            }
        }
        this.f10661l = i;
        this.f10662m = jSONArray.length();
        this.f10650a = Collections.unmodifiableList(arrayList);
        this.f10655f = jSONObject.getString("qdata");
        this.f10659j = jSONObject.optInt("fs_model_type", -1);
        this.f10660k = jSONObject.optLong("timeout_ms", -1);
        JSONObject optJSONObject = jSONObject.optJSONObject("settings");
        if (optJSONObject != null) {
            this.f10651b = optJSONObject.optLong("ad_network_timeout_millis", -1);
            this.f10652c = C2968s.m11538r().m12342a(optJSONObject, "click_urls");
            this.f10653d = C2968s.m11538r().m12342a(optJSONObject, "imp_urls");
            this.f10654e = C2968s.m11538r().m12342a(optJSONObject, "nofill_urls");
            long optLong = optJSONObject.optLong("refresh", -1);
            this.f10656g = optLong > 0 ? optLong * 1000 : -1;
            RewardItemParcel a = RewardItemParcel.m11487a(optJSONObject.optJSONArray("rewards"));
            if (a == null) {
                this.f10657h = null;
                this.f10658i = 0;
                return;
            }
            this.f10657h = a.f10012b;
            this.f10658i = a.f10013c;
            return;
        }
        this.f10651b = -1;
        this.f10652c = null;
        this.f10653d = null;
        this.f10654e = null;
        this.f10656g = -1;
        this.f10657h = null;
        this.f10658i = 0;
    }

    private boolean m12293a(dk dkVar) {
        for (String equals : dkVar.f10637c) {
            if (equals.equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                return true;
            }
        }
        return false;
    }
}
