package com.google.android.gms.p146b;

import android.content.Context;
import com.google.android.gms.ads.internal.C2733b;
import com.google.android.gms.ads.internal.C2900q;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.p146b.gx.C3232a;

@gb
/* renamed from: com.google.android.gms.b.fq */
public class fq {

    /* renamed from: com.google.android.gms.b.fq.a */
    public interface C2732a {
        void m10419b(gx gxVar);
    }

    public hl m12741a(Context context, C2733b c2733b, C3232a c3232a, C3326k c3326k, ii iiVar, du duVar, C2732a c2732a, az azVar) {
        hl ftVar;
        AdResponseParcel adResponseParcel = c3232a.f11167b;
        if (adResponseParcel.f9892h) {
            ftVar = new ft(context, c3232a, duVar, c2732a, azVar, iiVar);
        } else if (!adResponseParcel.f9904t) {
            ftVar = adResponseParcel.f9900p ? new fo(context, c3232a, iiVar, c2732a) : (((Boolean) aq.f10281U.m11794c()).booleanValue() && jq.m13572e() && !jq.m13574g() && iiVar.m13248k().f9329e) ? new fs(context, c3232a, iiVar, c2732a) : new fr(context, c3232a, iiVar, c2732a);
        } else if (c2733b instanceof C2900q) {
            ftVar = new fu(context, (C2900q) c2733b, new db(), c3232a, c3326k, c2732a);
        } else {
            throw new IllegalArgumentException("Invalid NativeAdManager type. Found: " + (c2733b != null ? c2733b.getClass().getName() : "null") + "; Required: NativeAdManager.");
        }
        C2972b.m11576a("AdRenderer: " + ftVar.getClass().getName());
        ftVar.m10969e();
        return ftVar;
    }
}
