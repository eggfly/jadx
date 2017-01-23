package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.C2772z;
import com.google.android.gms.ads.internal.client.aa;
import com.google.android.gms.ads.internal.client.ab.C2741a;
import com.google.android.gms.ads.internal.client.ag;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.p146b.bo;
import com.google.android.gms.p146b.bp;
import com.google.android.gms.p146b.bq;
import com.google.android.gms.p146b.br;
import com.google.android.gms.p146b.du;
import com.google.android.gms.p146b.gb;

@gb
/* renamed from: com.google.android.gms.ads.internal.k */
public class C2831k extends C2741a {
    private C2772z f9594a;
    private bo f9595b;
    private bp f9596c;
    private SimpleArrayMap<String, bq> f9597d;
    private SimpleArrayMap<String, br> f9598e;
    private NativeAdOptionsParcel f9599f;
    private ag f9600g;
    private final Context f9601h;
    private final du f9602i;
    private final String f9603j;
    private final VersionInfoParcel f9604k;
    private final C2795e f9605l;

    public C2831k(Context context, String str, du duVar, VersionInfoParcel versionInfoParcel, C2795e c2795e) {
        this.f9601h = context;
        this.f9603j = str;
        this.f9602i = duVar;
        this.f9604k = versionInfoParcel;
        this.f9598e = new SimpleArrayMap();
        this.f9597d = new SimpleArrayMap();
        this.f9605l = c2795e;
    }

    public aa m10961a() {
        return new C2830j(this.f9601h, this.f9603j, this.f9602i, this.f9604k, this.f9594a, this.f9595b, this.f9596c, this.f9598e, this.f9597d, this.f9599f, this.f9600g, this.f9605l);
    }

    public void m10962a(ag agVar) {
        this.f9600g = agVar;
    }

    public void m10963a(C2772z c2772z) {
        this.f9594a = c2772z;
    }

    public void m10964a(NativeAdOptionsParcel nativeAdOptionsParcel) {
        this.f9599f = nativeAdOptionsParcel;
    }

    public void m10965a(bo boVar) {
        this.f9595b = boVar;
    }

    public void m10966a(bp bpVar) {
        this.f9596c = bpVar;
    }

    public void m10967a(String str, br brVar, bq bqVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Custom template ID for native custom template ad is empty. Please provide a valid template id.");
        }
        this.f9598e.put(str, brVar);
        this.f9597d.put(str, bqVar);
    }
}
