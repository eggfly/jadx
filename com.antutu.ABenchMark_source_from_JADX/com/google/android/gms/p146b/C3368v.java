package com.google.android.gms.p146b;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import org.json.JSONObject;

@gb
/* renamed from: com.google.android.gms.b.v */
public class C3368v extends C3364q {
    private final de f11745d;

    public C3368v(Context context, AdSizeParcel adSizeParcel, gx gxVar, VersionInfoParcel versionInfoParcel, C3359y c3359y, de deVar) {
        super(context, adSizeParcel, gxVar, versionInfoParcel, c3359y);
        this.f11745d = deVar;
        m13842a(this.f11745d);
        m13840a();
        m13851b(false);
        C2972b.m11576a("Tracking ad unit: " + this.b.m13869d());
    }

    protected void m13884b(JSONObject jSONObject) {
        this.f11745d.m12204a("AFMA_updateActiveView", jSONObject);
    }

    protected void m13885c() {
        synchronized (this.a) {
            super.m13852c();
            m13849b(this.f11745d);
        }
    }

    public void m13886d() {
        m13885c();
    }

    protected boolean m13887j() {
        return true;
    }
}
