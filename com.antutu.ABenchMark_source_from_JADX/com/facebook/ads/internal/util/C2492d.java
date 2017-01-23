package com.facebook.ads.internal.util;

import com.facebook.ads.internal.p125c.C2346b;
import com.facebook.ads.internal.p125c.C2350e;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.facebook.ads.internal.util.d */
public class C2492d {
    private static Map<String, Long> f8573a;
    private static Map<String, Long> f8574b;
    private static Map<String, String> f8575c;

    /* renamed from: com.facebook.ads.internal.util.d.1 */
    static /* synthetic */ class C24911 {
        static final /* synthetic */ int[] f8572a;

        static {
            f8572a = new int[C2346b.values().length];
            try {
                f8572a[C2346b.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f8572a[C2346b.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f8572a[C2346b.NATIVE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f8572a[C2346b.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    static {
        f8573a = new ConcurrentHashMap();
        f8574b = new ConcurrentHashMap();
        f8575c = new ConcurrentHashMap();
    }

    private static long m9457a(String str, C2346b c2346b) {
        if (f8573a.containsKey(str)) {
            return ((Long) f8573a.get(str)).longValue();
        }
        switch (C24911.f8572a[c2346b.ordinal()]) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                return 15000;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                return -1000;
            default:
                return -1000;
        }
    }

    public static void m9458a(long j, C2350e c2350e) {
        f8573a.put(C2492d.m9463d(c2350e), Long.valueOf(j));
    }

    public static void m9459a(String str, C2350e c2350e) {
        f8575c.put(C2492d.m9463d(c2350e), str);
    }

    public static boolean m9460a(C2350e c2350e) {
        String d = C2492d.m9463d(c2350e);
        if (!f8574b.containsKey(d)) {
            return false;
        }
        return System.currentTimeMillis() - ((Long) f8574b.get(d)).longValue() < C2492d.m9457a(d, c2350e.m9060b());
    }

    public static void m9461b(C2350e c2350e) {
        f8574b.put(C2492d.m9463d(c2350e), Long.valueOf(System.currentTimeMillis()));
    }

    public static String m9462c(C2350e c2350e) {
        return (String) f8575c.get(C2492d.m9463d(c2350e));
    }

    private static String m9463d(C2350e c2350e) {
        int i = 0;
        String str = "%s:%s:%s:%d:%d:%d";
        Object[] objArr = new Object[6];
        objArr[0] = c2350e.m9059a();
        objArr[1] = c2350e.m9060b();
        objArr[2] = c2350e.f8190e;
        objArr[3] = Integer.valueOf(c2350e.m9061c() == null ? 0 : c2350e.m9061c().getHeight());
        if (c2350e.m9061c() != null) {
            i = c2350e.m9061c().getWidth();
        }
        objArr[4] = Integer.valueOf(i);
        objArr[5] = Integer.valueOf(c2350e.m9062d());
        return String.format(str, objArr);
    }
}
