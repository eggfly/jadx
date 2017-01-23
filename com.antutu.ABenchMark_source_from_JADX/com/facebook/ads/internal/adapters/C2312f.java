package com.facebook.ads.internal.adapters;

import com.facebook.ads.internal.server.AdPlacementType;
import com.facebook.ads.internal.util.C2511s;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.facebook.ads.internal.adapters.f */
public class C2312f {
    private static final Set<C2314h> f7992a;
    private static final Map<AdPlacementType, String> f7993b;

    /* renamed from: com.facebook.ads.internal.adapters.f.1 */
    static /* synthetic */ class C23111 {
        static final /* synthetic */ int[] f7991a;

        static {
            f7991a = new int[AdPlacementType.values().length];
            try {
                f7991a[AdPlacementType.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f7991a[AdPlacementType.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f7991a[AdPlacementType.NATIVE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    static {
        f7992a = new HashSet();
        f7993b = new ConcurrentHashMap();
        for (C2314h c2314h : C2314h.m8819a()) {
            Class cls;
            switch (C23111.f7991a[c2314h.f8011j.ordinal()]) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    cls = BannerAdapter.class;
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    cls = InterstitialAdapter.class;
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    cls = C2307r.class;
                    break;
                default:
                    cls = null;
                    break;
            }
            if (cls != null) {
                Class cls2 = c2314h.f8008g;
                if (cls2 == null) {
                    try {
                        cls2 = Class.forName(c2314h.f8009h);
                    } catch (ClassNotFoundException e) {
                    }
                }
                if (cls2 != null && cls.isAssignableFrom(cls2)) {
                    f7992a.add(c2314h);
                }
            }
        }
    }

    public static AdAdapter m8814a(C2313g c2313g, AdPlacementType adPlacementType) {
        try {
            C2314h b = C2312f.m8817b(c2313g, adPlacementType);
            if (b != null && f7992a.contains(b)) {
                Class cls = b.f8008g;
                if (cls == null) {
                    cls = Class.forName(b.f8009h);
                }
                return (AdAdapter) cls.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static AdAdapter m8815a(String str, AdPlacementType adPlacementType) {
        return C2312f.m8814a(C2313g.m8818a(str), adPlacementType);
    }

    public static String m8816a(AdPlacementType adPlacementType) {
        if (f7993b.containsKey(adPlacementType)) {
            return (String) f7993b.get(adPlacementType);
        }
        Set hashSet = new HashSet();
        for (C2314h c2314h : f7992a) {
            if (c2314h.f8011j == adPlacementType) {
                hashSet.add(c2314h.f8010i.toString());
            }
        }
        String a = C2511s.m9518a(hashSet, Constants.ACCEPT_TIME_SEPARATOR_SP);
        f7993b.put(adPlacementType, a);
        return a;
    }

    private static C2314h m8817b(C2313g c2313g, AdPlacementType adPlacementType) {
        for (C2314h c2314h : f7992a) {
            if (c2314h.f8010i == c2313g && c2314h.f8011j == adPlacementType) {
                return c2314h;
            }
        }
        return null;
    }
}
