package com.google.android.gms.p146b;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import org.json.JSONObject;

@gb
/* renamed from: com.google.android.gms.b.s */
public final class C3365s {
    private final String f11733a;
    private final JSONObject f11734b;
    private final String f11735c;
    private final String f11736d;
    private final boolean f11737e;
    private final boolean f11738f;

    public C3365s(String str, VersionInfoParcel versionInfoParcel, String str2, JSONObject jSONObject, boolean z, boolean z2) {
        this.f11736d = versionInfoParcel.f10081b;
        this.f11734b = jSONObject;
        this.f11735c = str;
        this.f11733a = str2;
        this.f11737e = z;
        this.f11738f = z2;
    }

    public String m13866a() {
        return this.f11733a;
    }

    public String m13867b() {
        return this.f11736d;
    }

    public JSONObject m13868c() {
        return this.f11734b;
    }

    public String m13869d() {
        return this.f11735c;
    }

    public boolean m13870e() {
        return this.f11737e;
    }

    public boolean m13871f() {
        return this.f11738f;
    }
}
