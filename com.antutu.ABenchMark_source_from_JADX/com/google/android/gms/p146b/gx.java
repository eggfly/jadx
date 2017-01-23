package com.google.android.gms.p146b;

import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.C2810h.C2804a;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

@gb
/* renamed from: com.google.android.gms.b.gx */
public class gx {
    public final String f11174A;
    public final C2804a f11175B;
    public boolean f11176C;
    public boolean f11177D;
    public final AdRequestParcel f11178a;
    public final ii f11179b;
    public final List<String> f11180c;
    public final int f11181d;
    public final List<String> f11182e;
    public final List<String> f11183f;
    public final int f11184g;
    public final long f11185h;
    public final String f11186i;
    public final JSONObject f11187j;
    public final boolean f11188k;
    public boolean f11189l;
    public final boolean f11190m;
    public final dk f11191n;
    public final dv f11192o;
    public final String f11193p;
    public final dl f11194q;
    public final dn f11195r;
    public final long f11196s;
    public final AdSizeParcel f11197t;
    public final long f11198u;
    public final RewardItemParcel f11199v;
    public final List<String> f11200w;
    public final List<String> f11201x;
    public final long f11202y;
    public final long f11203z;

    @gb
    /* renamed from: com.google.android.gms.b.gx.a */
    public static final class C3232a {
        public final AdRequestInfoParcel f11166a;
        public final AdResponseParcel f11167b;
        public final dl f11168c;
        public final AdSizeParcel f11169d;
        public final int f11170e;
        public final long f11171f;
        public final long f11172g;
        public final JSONObject f11173h;

        public C3232a(AdRequestInfoParcel adRequestInfoParcel, AdResponseParcel adResponseParcel, dl dlVar, AdSizeParcel adSizeParcel, int i, long j, long j2, JSONObject jSONObject) {
            this.f11166a = adRequestInfoParcel;
            this.f11167b = adResponseParcel;
            this.f11168c = dlVar;
            this.f11169d = adSizeParcel;
            this.f11170e = i;
            this.f11171f = j;
            this.f11172g = j2;
            this.f11173h = jSONObject;
        }
    }

    public gx(AdRequestParcel adRequestParcel, ii iiVar, List<String> list, int i, List<String> list2, List<String> list3, int i2, long j, String str, boolean z, dk dkVar, dv dvVar, String str2, dl dlVar, dn dnVar, long j2, AdSizeParcel adSizeParcel, long j3, long j4, long j5, String str3, JSONObject jSONObject, C2804a c2804a, RewardItemParcel rewardItemParcel, List<String> list4, List<String> list5, boolean z2) {
        this.f11176C = false;
        this.f11177D = false;
        this.f11178a = adRequestParcel;
        this.f11179b = iiVar;
        this.f11180c = gx.m12913a(list);
        this.f11181d = i;
        this.f11182e = gx.m12913a(list2);
        this.f11183f = gx.m12913a(list3);
        this.f11184g = i2;
        this.f11185h = j;
        this.f11186i = str;
        this.f11190m = z;
        this.f11191n = dkVar;
        this.f11192o = dvVar;
        this.f11193p = str2;
        this.f11194q = dlVar;
        this.f11195r = dnVar;
        this.f11196s = j2;
        this.f11197t = adSizeParcel;
        this.f11198u = j3;
        this.f11202y = j4;
        this.f11203z = j5;
        this.f11174A = str3;
        this.f11187j = jSONObject;
        this.f11175B = c2804a;
        this.f11199v = rewardItemParcel;
        this.f11200w = gx.m12913a(list4);
        this.f11201x = gx.m12913a(list5);
        this.f11188k = z2;
    }

    public gx(C3232a c3232a, ii iiVar, dk dkVar, dv dvVar, String str, dn dnVar, C2804a c2804a) {
        ii iiVar2 = iiVar;
        dk dkVar2 = dkVar;
        dv dvVar2 = dvVar;
        String str2 = str;
        dn dnVar2 = dnVar;
        C2804a c2804a2 = c2804a;
        this(c3232a.f11166a.f9853c, iiVar2, c3232a.f11167b.f9888d, c3232a.f11170e, c3232a.f11167b.f9890f, c3232a.f11167b.f9894j, c3232a.f11167b.f9896l, c3232a.f11167b.f9895k, c3232a.f11166a.f9859i, c3232a.f11167b.f9892h, dkVar2, dvVar2, str2, c3232a.f11168c, dnVar2, c3232a.f11167b.f9893i, c3232a.f11169d, c3232a.f11167b.f9891g, c3232a.f11171f, c3232a.f11172g, c3232a.f11167b.f9899o, c3232a.f11173h, c2804a2, c3232a.f11167b.f9880D, c3232a.f11167b.f9881E, c3232a.f11167b.f9881E, c3232a.f11167b.f9883G);
    }

    private static <T> List<T> m12913a(List<T> list) {
        return list == null ? null : Collections.unmodifiableList(list);
    }

    public boolean m12914a() {
        return (this.f11179b == null || this.f11179b.m13249l() == null) ? false : this.f11179b.m13249l().m13293b();
    }
}
