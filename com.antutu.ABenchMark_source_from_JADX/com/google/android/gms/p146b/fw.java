package com.google.android.gms.p146b;

import android.os.Bundle;
import com.google.android.gms.ads.internal.formats.C2799a;
import com.google.android.gms.ads.internal.formats.C2805d;
import com.google.android.gms.ads.internal.formats.C2810h.C2804a;
import com.google.android.gms.p146b.fv.C3216a;
import com.umeng.analytics.C4156a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import org.json.JSONObject;

@gb
/* renamed from: com.google.android.gms.b.fw */
public class fw implements C3216a<C2805d> {
    private final boolean f11000a;
    private final boolean f11001b;

    public fw(boolean z, boolean z2) {
        this.f11000a = z;
        this.f11001b = z2;
    }

    public /* synthetic */ C2804a m12793a(fv fvVar, JSONObject jSONObject) {
        return m12794b(fvVar, jSONObject);
    }

    public C2805d m12794b(fv fvVar, JSONObject jSONObject) {
        List<hz> a = fvVar.m12787a(jSONObject, "images", true, this.f11000a, this.f11001b);
        Future a2 = fvVar.m12786a(jSONObject, "app_icon", true, this.f11000a);
        Future b = fvVar.m12791b(jSONObject);
        List arrayList = new ArrayList();
        for (hz hzVar : a) {
            arrayList.add(hzVar.get());
        }
        return new C2805d(jSONObject.getString("headline"), arrayList, jSONObject.getString(C4156a.f13961w), (bf) a2.get(), jSONObject.getString("call_to_action"), jSONObject.optDouble("rating", -1.0d), jSONObject.optString("store"), jSONObject.optString("price"), (C2799a) b.get(), new Bundle());
    }
}
