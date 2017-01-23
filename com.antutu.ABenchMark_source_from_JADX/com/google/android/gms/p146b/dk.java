package com.google.android.gms.p146b;

import com.antutu.benchmark.modelreflact.TestResultModel;
import com.google.android.gms.ads.internal.C2968s;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONObject;

@gb
/* renamed from: com.google.android.gms.b.dk */
public final class dk {
    public final String f10635a;
    public final String f10636b;
    public final List<String> f10637c;
    public final String f10638d;
    public final String f10639e;
    public final List<String> f10640f;
    public final List<String> f10641g;
    public final String f10642h;
    public final List<String> f10643i;
    public final List<String> f10644j;
    public final String f10645k;
    public final String f10646l;
    public final String f10647m;
    public final List<String> f10648n;
    public final String f10649o;

    public dk(JSONObject jSONObject) {
        String str = null;
        this.f10636b = jSONObject.getString(AgooConstants.MESSAGE_ID);
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        List arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        this.f10637c = Collections.unmodifiableList(arrayList);
        this.f10638d = jSONObject.optString("allocation_id", null);
        this.f10640f = C2968s.m11538r().m12342a(jSONObject, "clickurl");
        this.f10641g = C2968s.m11538r().m12342a(jSONObject, "imp_urls");
        this.f10643i = C2968s.m11538r().m12342a(jSONObject, "video_start_urls");
        this.f10644j = C2968s.m11538r().m12342a(jSONObject, "video_complete_urls");
        JSONObject optJSONObject = jSONObject.optJSONObject(TestResultModel.TYPE_AD);
        this.f10635a = optJSONObject != null ? optJSONObject.toString() : null;
        JSONObject optJSONObject2 = jSONObject.optJSONObject(Constants.KEY_DATA);
        this.f10642h = optJSONObject2 != null ? optJSONObject2.toString() : null;
        this.f10639e = optJSONObject2 != null ? optJSONObject2.optString("class_name") : null;
        this.f10645k = jSONObject.optString("html_template", null);
        this.f10646l = jSONObject.optString("ad_base_url", null);
        optJSONObject = jSONObject.optJSONObject("assets");
        this.f10647m = optJSONObject != null ? optJSONObject.toString() : null;
        this.f10648n = C2968s.m11538r().m12342a(jSONObject, "template_ids");
        optJSONObject = jSONObject.optJSONObject("ad_loader_options");
        if (optJSONObject != null) {
            str = optJSONObject.toString();
        }
        this.f10649o = str;
    }
}
