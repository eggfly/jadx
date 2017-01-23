package com.facebook.ads.internal.p126d;

import com.facebook.ads.internal.adapters.C2313g;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.facebook.ads.internal.d.a */
public class C2355a {
    private static final String[] f8222a;
    private static final String[] f8223b;
    private static final String[] f8224c;

    /* renamed from: com.facebook.ads.internal.d.a.1 */
    static /* synthetic */ class C23541 {
        static final /* synthetic */ int[] f8221a;

        static {
            f8221a = new int[C2313g.values().length];
            try {
                f8221a[C2313g.AN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f8221a[C2313g.YAHOO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f8221a[C2313g.INMOBI.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f8221a[C2313g.ADMOB.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    static {
        f8222a = new String[]{"com.flurry.android.FlurryAgent", "com.flurry.android.ads.FlurryAdErrorType", "com.flurry.android.ads.FlurryAdNative", "com.flurry.android.ads.FlurryAdNativeAsset", "com.flurry.android.ads.FlurryAdNativeListener"};
        f8223b = new String[]{"com.inmobi.ads.InMobiNative", "com.inmobi.sdk.InMobiSdk"};
        f8224c = new String[]{"com.google.android.gms.ads.formats.NativeAdView"};
    }

    public static boolean m9069a(C2313g c2313g) {
        switch (C23541.f8221a[c2313g.ordinal()]) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                return true;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                return C2355a.m9071a(f8222a);
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                return C2355a.m9071a(f8223b);
            case SpdyProtocol.QUIC /*4*/:
                return C2355a.m9071a(f8224c);
            default:
                return false;
        }
    }

    private static boolean m9070a(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean m9071a(String[] strArr) {
        if (strArr == null) {
            return false;
        }
        for (String a : strArr) {
            if (!C2355a.m9070a(a)) {
                return false;
            }
        }
        return true;
    }
}
