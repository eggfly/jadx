package com.google.android.gms.p146b;

import android.os.Bundle;
import com.google.android.gms.ads.internal.formats.C2799a;
import com.google.android.gms.ads.internal.formats.C2807e;
import com.google.android.gms.ads.internal.formats.C2810h.C2804a;
import com.google.android.gms.p146b.fv.C3216a;
import com.umeng.analytics.C4156a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import org.json.JSONObject;

@gb
/* renamed from: com.google.android.gms.b.fx */
public class fx implements C3216a<C2807e> {
    private final boolean f11002a;
    private final boolean f11003b;

    public fx(boolean z, boolean z2) {
        this.f11002a = z;
        this.f11003b = z2;
    }

    public /* synthetic */ C2804a m12795a(fv fvVar, JSONObject jSONObject) {
        return m12796b(fvVar, jSONObject);
    }

    public C2807e m12796b(fv fvVar, JSONObject jSONObject) {
        List<hz> a = fvVar.m12787a(jSONObject, "images", true, this.f11002a, this.f11003b);
        Future a2 = fvVar.m12786a(jSONObject, "secondary_image", false, this.f11002a);
        Future b = fvVar.m12791b(jSONObject);
        List arrayList = new ArrayList();
        for (hz hzVar : a) {
            arrayList.add(hzVar.get());
        }
        return new C2807e(jSONObject.getString("headline"), arrayList, jSONObject.getString(C4156a.f13961w), (bf) a2.get(), jSONObject.getString("call_to_action"), jSONObject.getString("advertiser"), (C2799a) b.get(), new Bundle());
    }
}
