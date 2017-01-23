package com.facebook.ads.internal.adapters;

import com.facebook.ads.internal.p126d.C2355a;
import com.facebook.ads.internal.server.AdPlacementType;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.facebook.ads.internal.adapters.h */
public enum C2314h {
    ANBANNER(C2321j.class, C2313g.AN, AdPlacementType.BANNER),
    ANINTERSTITIAL(C2323k.class, C2313g.AN, AdPlacementType.INTERSTITIAL),
    ADMOBNATIVE(C2308d.class, C2313g.ADMOB, AdPlacementType.NATIVE),
    ANNATIVE(C2326l.class, C2313g.AN, AdPlacementType.NATIVE),
    INMOBINATIVE(C2333p.class, C2313g.INMOBI, AdPlacementType.NATIVE),
    YAHOONATIVE(C2328m.class, C2313g.YAHOO, AdPlacementType.NATIVE);
    
    private static List<C2314h> f8006k;
    public Class<?> f8008g;
    public String f8009h;
    public C2313g f8010i;
    public AdPlacementType f8011j;

    private C2314h(Class<?> cls, C2313g c2313g, AdPlacementType adPlacementType) {
        this.f8008g = cls;
        this.f8010i = c2313g;
        this.f8011j = adPlacementType;
    }

    public static List<C2314h> m8819a() {
        if (f8006k == null) {
            synchronized (C2314h.class) {
                f8006k = new ArrayList();
                f8006k.add(ANBANNER);
                f8006k.add(ANINTERSTITIAL);
                f8006k.add(ANNATIVE);
                if (C2355a.m9069a(C2313g.YAHOO)) {
                    f8006k.add(YAHOONATIVE);
                }
                if (C2355a.m9069a(C2313g.INMOBI)) {
                    f8006k.add(INMOBINATIVE);
                }
                if (C2355a.m9069a(C2313g.ADMOB)) {
                    f8006k.add(ADMOBNATIVE);
                }
            }
        }
        return f8006k;
    }
}
