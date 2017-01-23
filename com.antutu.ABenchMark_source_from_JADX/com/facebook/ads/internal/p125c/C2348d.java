package com.facebook.ads.internal.p125c;

import com.facebook.ads.AdError;
import com.facebook.ads.internal.server.AdPlacementType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.c.d */
public class C2348d {
    private static final AdPlacementType f8173k;
    protected AdPlacementType f8174a;
    protected int f8175b;
    protected int f8176c;
    protected int f8177d;
    protected int f8178e;
    protected int f8179f;
    protected int f8180g;
    protected boolean f8181h;
    public int f8182i;
    public int f8183j;
    private int f8184l;

    static {
        f8173k = AdPlacementType.UNKNOWN;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private C2348d(java.util.Map<java.lang.String, java.lang.String> r8) {
        /*
        r7 = this;
        r4 = 1;
        r3 = -1;
        r2 = 0;
        r7.<init>();
        r0 = f8173k;
        r7.f8174a = r0;
        r7.f8175b = r4;
        r7.f8177d = r2;
        r0 = 20;
        r7.f8178e = r0;
        r7.f8179f = r2;
        r0 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r7.f8180g = r0;
        r0 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r7.f8184l = r0;
        r7.f8181h = r2;
        r7.f8182i = r3;
        r7.f8183j = r3;
        r0 = r8.entrySet();
        r5 = r0.iterator();
    L_0x002a:
        r0 = r5.hasNext();
        if (r0 == 0) goto L_0x0157;
    L_0x0030:
        r0 = r5.next();
        r0 = (java.util.Map.Entry) r0;
        r1 = r0.getKey();
        r1 = (java.lang.String) r1;
        r6 = r1.hashCode();
        switch(r6) {
            case -1561601017: goto L_0x007d;
            case -856794442: goto L_0x00b0;
            case -726276175: goto L_0x00bb;
            case -553208868: goto L_0x0087;
            case 3575610: goto L_0x0055;
            case 664421755: goto L_0x0069;
            case 700812481: goto L_0x005f;
            case 1085444827: goto L_0x0073;
            case 1183549815: goto L_0x00a5;
            case 1503616961: goto L_0x009b;
            case 2002133996: goto L_0x0091;
            default: goto L_0x0043;
        };
    L_0x0043:
        r1 = r3;
    L_0x0044:
        switch(r1) {
            case 0: goto L_0x0048;
            case 1: goto L_0x00c7;
            case 2: goto L_0x00d5;
            case 3: goto L_0x00e3;
            case 4: goto L_0x00f1;
            case 5: goto L_0x00ff;
            case 6: goto L_0x0111;
            case 7: goto L_0x011f;
            case 8: goto L_0x012d;
            case 9: goto L_0x013b;
            case 10: goto L_0x0149;
            default: goto L_0x0047;
        };
    L_0x0047:
        goto L_0x002a;
    L_0x0048:
        r0 = r0.getValue();
        r0 = (java.lang.String) r0;
        r0 = com.facebook.ads.internal.server.AdPlacementType.fromString(r0);
        r7.f8174a = r0;
        goto L_0x002a;
    L_0x0055:
        r6 = "type";
        r1 = r1.equals(r6);
        if (r1 == 0) goto L_0x0043;
    L_0x005d:
        r1 = r2;
        goto L_0x0044;
    L_0x005f:
        r6 = "min_viewability_percentage";
        r1 = r1.equals(r6);
        if (r1 == 0) goto L_0x0043;
    L_0x0067:
        r1 = r4;
        goto L_0x0044;
    L_0x0069:
        r6 = "min_viewability_duration";
        r1 = r1.equals(r6);
        if (r1 == 0) goto L_0x0043;
    L_0x0071:
        r1 = 2;
        goto L_0x0044;
    L_0x0073:
        r6 = "refresh";
        r1 = r1.equals(r6);
        if (r1 == 0) goto L_0x0043;
    L_0x007b:
        r1 = 3;
        goto L_0x0044;
    L_0x007d:
        r6 = "refresh_threshold";
        r1 = r1.equals(r6);
        if (r1 == 0) goto L_0x0043;
    L_0x0085:
        r1 = 4;
        goto L_0x0044;
    L_0x0087:
        r6 = "cacheable";
        r1 = r1.equals(r6);
        if (r1 == 0) goto L_0x0043;
    L_0x008f:
        r1 = 5;
        goto L_0x0044;
    L_0x0091:
        r6 = "placement_width";
        r1 = r1.equals(r6);
        if (r1 == 0) goto L_0x0043;
    L_0x0099:
        r1 = 6;
        goto L_0x0044;
    L_0x009b:
        r6 = "placement_height";
        r1 = r1.equals(r6);
        if (r1 == 0) goto L_0x0043;
    L_0x00a3:
        r1 = 7;
        goto L_0x0044;
    L_0x00a5:
        r6 = "viewability_check_initial_delay";
        r1 = r1.equals(r6);
        if (r1 == 0) goto L_0x0043;
    L_0x00ad:
        r1 = 8;
        goto L_0x0044;
    L_0x00b0:
        r6 = "viewability_check_interval";
        r1 = r1.equals(r6);
        if (r1 == 0) goto L_0x0043;
    L_0x00b8:
        r1 = 9;
        goto L_0x0044;
    L_0x00bb:
        r6 = "request_timeout";
        r1 = r1.equals(r6);
        if (r1 == 0) goto L_0x0043;
    L_0x00c3:
        r1 = 10;
        goto L_0x0044;
    L_0x00c7:
        r0 = r0.getValue();
        r0 = (java.lang.String) r0;
        r0 = java.lang.Integer.parseInt(r0);
        r7.f8175b = r0;
        goto L_0x002a;
    L_0x00d5:
        r0 = r0.getValue();
        r0 = (java.lang.String) r0;
        r0 = java.lang.Integer.parseInt(r0);
        r7.f8176c = r0;
        goto L_0x002a;
    L_0x00e3:
        r0 = r0.getValue();
        r0 = (java.lang.String) r0;
        r0 = java.lang.Integer.parseInt(r0);
        r7.f8177d = r0;
        goto L_0x002a;
    L_0x00f1:
        r0 = r0.getValue();
        r0 = (java.lang.String) r0;
        r0 = java.lang.Integer.parseInt(r0);
        r7.f8178e = r0;
        goto L_0x002a;
    L_0x00ff:
        r0 = r0.getValue();
        r0 = (java.lang.String) r0;
        r0 = java.lang.Boolean.valueOf(r0);
        r0 = r0.booleanValue();
        r7.f8181h = r0;
        goto L_0x002a;
    L_0x0111:
        r0 = r0.getValue();
        r0 = (java.lang.String) r0;
        r0 = java.lang.Integer.parseInt(r0);
        r7.f8182i = r0;
        goto L_0x002a;
    L_0x011f:
        r0 = r0.getValue();
        r0 = (java.lang.String) r0;
        r0 = java.lang.Integer.parseInt(r0);
        r7.f8183j = r0;
        goto L_0x002a;
    L_0x012d:
        r0 = r0.getValue();
        r0 = (java.lang.String) r0;
        r0 = java.lang.Integer.parseInt(r0);
        r7.f8179f = r0;
        goto L_0x002a;
    L_0x013b:
        r0 = r0.getValue();
        r0 = (java.lang.String) r0;
        r0 = java.lang.Integer.parseInt(r0);
        r7.f8180g = r0;
        goto L_0x002a;
    L_0x0149:
        r0 = r0.getValue();
        r0 = (java.lang.String) r0;
        r0 = java.lang.Integer.parseInt(r0);
        r7.f8184l = r0;
        goto L_0x002a;
    L_0x0157:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.c.d.<init>(java.util.Map):void");
    }

    public static C2348d m9046a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Iterator keys = jSONObject.keys();
        Map hashMap = new HashMap();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            hashMap.put(str, String.valueOf(jSONObject.opt(str)));
        }
        return new C2348d(hashMap);
    }

    public AdPlacementType m9047a() {
        return this.f8174a;
    }

    public long m9048b() {
        return (long) (this.f8177d * AdError.NETWORK_ERROR_CODE);
    }

    public long m9049c() {
        return (long) (this.f8178e * AdError.NETWORK_ERROR_CODE);
    }

    public boolean m9050d() {
        return this.f8181h;
    }

    public int m9051e() {
        return this.f8175b;
    }

    public int m9052f() {
        return this.f8179f;
    }

    public int m9053g() {
        return this.f8180g;
    }

    public int m9054h() {
        return this.f8184l;
    }
}
