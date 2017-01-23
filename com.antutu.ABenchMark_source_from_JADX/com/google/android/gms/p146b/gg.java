package com.google.android.gms.p146b;

import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@gb
/* renamed from: com.google.android.gms.b.gg */
public final class gg {
    private String f11065a;
    private String f11066b;
    private String f11067c;
    private List<String> f11068d;
    private String f11069e;
    private String f11070f;
    private List<String> f11071g;
    private long f11072h;
    private boolean f11073i;
    private final long f11074j;
    private List<String> f11075k;
    private long f11076l;
    private int f11077m;
    private boolean f11078n;
    private boolean f11079o;
    private boolean f11080p;
    private boolean f11081q;
    private int f11082r;
    private String f11083s;
    private boolean f11084t;
    private boolean f11085u;
    private RewardItemParcel f11086v;
    private List<String> f11087w;
    private List<String> f11088x;
    private boolean f11089y;
    private final AdRequestInfoParcel f11090z;

    public gg(AdRequestInfoParcel adRequestInfoParcel) {
        this.f11072h = -1;
        this.f11073i = false;
        this.f11074j = -1;
        this.f11076l = -1;
        this.f11077m = -1;
        this.f11078n = false;
        this.f11079o = false;
        this.f11080p = false;
        this.f11081q = true;
        this.f11082r = 0;
        this.f11083s = BuildConfig.FLAVOR;
        this.f11084t = false;
        this.f11085u = false;
        this.f11089y = false;
        this.f11090z = adRequestInfoParcel;
    }

    static String m12848a(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        return (list == null || list.isEmpty()) ? null : (String) list.get(0);
    }

    static long m12849b(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        if (!(list == null || list.isEmpty())) {
            String str2 = (String) list.get(0);
            try {
                return (long) (Float.parseFloat(str2) * 1000.0f);
            } catch (NumberFormatException e) {
                C2972b.m11583d("Could not parse float from " + str + " header: " + str2);
            }
        }
        return -1;
    }

    private void m12850b(Map<String, List<String>> map) {
        this.f11065a = gg.m12848a(map, "X-Afma-Ad-Size");
    }

    static List<String> m12851c(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        if (!(list == null || list.isEmpty())) {
            String str2 = (String) list.get(0);
            if (str2 != null) {
                return Arrays.asList(str2.trim().split("\\s+"));
            }
        }
        return null;
    }

    private void m12852c(Map<String, List<String>> map) {
        List c = gg.m12851c(map, "X-Afma-Click-Tracking-Urls");
        if (c != null) {
            this.f11068d = c;
        }
    }

    private void m12853d(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Debug-Dialog");
        if (list != null && !list.isEmpty()) {
            this.f11069e = (String) list.get(0);
        }
    }

    private boolean m12854d(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        return (list == null || list.isEmpty() || !Boolean.valueOf((String) list.get(0)).booleanValue()) ? false : true;
    }

    private void m12855e(Map<String, List<String>> map) {
        List c = gg.m12851c(map, "X-Afma-Tracking-Urls");
        if (c != null) {
            this.f11071g = c;
        }
    }

    private void m12856f(Map<String, List<String>> map) {
        long b = gg.m12849b(map, "X-Afma-Interstitial-Timeout");
        if (b != -1) {
            this.f11072h = b;
        }
    }

    private void m12857g(Map<String, List<String>> map) {
        this.f11070f = gg.m12848a(map, "X-Afma-ActiveView");
    }

    private void m12858h(Map<String, List<String>> map) {
        this.f11079o = "native".equals(gg.m12848a(map, "X-Afma-Ad-Format"));
    }

    private void m12859i(Map<String, List<String>> map) {
        this.f11078n |= m12854d(map, "X-Afma-Custom-Rendering-Allowed");
    }

    private void m12860j(Map<String, List<String>> map) {
        this.f11073i |= m12854d(map, "X-Afma-Mediation");
    }

    private void m12861k(Map<String, List<String>> map) {
        List c = gg.m12851c(map, "X-Afma-Manual-Tracking-Urls");
        if (c != null) {
            this.f11075k = c;
        }
    }

    private void m12862l(Map<String, List<String>> map) {
        long b = gg.m12849b(map, "X-Afma-Refresh-Rate");
        if (b != -1) {
            this.f11076l = b;
        }
    }

    private void m12863m(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Orientation");
        if (list != null && !list.isEmpty()) {
            String str = (String) list.get(0);
            if ("portrait".equalsIgnoreCase(str)) {
                this.f11077m = C2968s.m11527g().m13089b();
            } else if ("landscape".equalsIgnoreCase(str)) {
                this.f11077m = C2968s.m11527g().m13075a();
            }
        }
    }

    private void m12864n(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Use-HTTPS");
        if (list != null && !list.isEmpty()) {
            this.f11080p = Boolean.valueOf((String) list.get(0)).booleanValue();
        }
    }

    private void m12865o(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Content-Url-Opted-Out");
        if (list != null && !list.isEmpty()) {
            this.f11081q = Boolean.valueOf((String) list.get(0)).booleanValue();
        }
    }

    private void m12866p(Map<String, List<String>> map) {
        List<String> c = gg.m12851c(map, "X-Afma-OAuth-Token-Status");
        this.f11082r = 0;
        if (c != null) {
            for (String str : c) {
                if ("Clear".equalsIgnoreCase(str)) {
                    this.f11082r = 1;
                    return;
                } else if ("No-Op".equalsIgnoreCase(str)) {
                    this.f11082r = 0;
                    return;
                }
            }
        }
    }

    private void m12867q(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Gws-Query-Id");
        if (list != null && !list.isEmpty()) {
            this.f11083s = (String) list.get(0);
        }
    }

    private void m12868r(Map<String, List<String>> map) {
        String a = gg.m12848a(map, "X-Afma-Fluid");
        if (a != null && a.equals("height")) {
            this.f11084t = true;
        }
    }

    private void m12869s(Map<String, List<String>> map) {
        this.f11085u = "native_express".equals(gg.m12848a(map, "X-Afma-Ad-Format"));
    }

    private void m12870t(Map<String, List<String>> map) {
        this.f11086v = RewardItemParcel.m11486a(gg.m12848a(map, "X-Afma-Rewards"));
    }

    private void m12871u(Map<String, List<String>> map) {
        if (this.f11087w == null) {
            this.f11087w = gg.m12851c(map, "X-Afma-Reward-Video-Start-Urls");
        }
    }

    private void m12872v(Map<String, List<String>> map) {
        if (this.f11088x == null) {
            this.f11088x = gg.m12851c(map, "X-Afma-Reward-Video-Complete-Urls");
        }
    }

    private void m12873w(Map<String, List<String>> map) {
        this.f11089y |= m12854d(map, "X-Afma-Use-Displayed-Impression");
    }

    public AdResponseParcel m12874a(long j) {
        return new AdResponseParcel(this.f11090z, this.f11066b, this.f11067c, this.f11068d, this.f11071g, this.f11072h, this.f11073i, -1, this.f11075k, this.f11076l, this.f11077m, this.f11065a, j, this.f11069e, this.f11070f, this.f11078n, this.f11079o, this.f11080p, this.f11081q, false, this.f11082r, this.f11083s, this.f11084t, this.f11085u, this.f11086v, this.f11087w, this.f11088x, this.f11089y);
    }

    public void m12875a(String str, Map<String, List<String>> map, String str2) {
        this.f11066b = str;
        this.f11067c = str2;
        m12876a((Map) map);
    }

    public void m12876a(Map<String, List<String>> map) {
        m12850b(map);
        m12852c(map);
        m12853d(map);
        m12855e(map);
        m12856f(map);
        m12860j(map);
        m12861k(map);
        m12862l(map);
        m12863m(map);
        m12857g(map);
        m12864n(map);
        m12859i(map);
        m12858h(map);
        m12865o(map);
        m12866p(map);
        m12867q(map);
        m12868r(map);
        m12869s(map);
        m12870t(map);
        m12871u(map);
        m12872v(map);
        m12873w(map);
    }
}
