package com.facebook.ads.internal.p125c;

import com.facebook.ads.internal.C2409e;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.facebook.ads.internal.c.b */
public enum C2346b {
    UNKNOWN,
    BANNER,
    INTERSTITIAL,
    NATIVE;

    /* renamed from: com.facebook.ads.internal.c.b.1 */
    static /* synthetic */ class C23451 {
        static final /* synthetic */ int[] f8163a;

        static {
            f8163a = new int[C2409e.values().length];
            try {
                f8163a[C2409e.NATIVE_UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f8163a[C2409e.WEBVIEW_BANNER_50.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f8163a[C2409e.WEBVIEW_BANNER_90.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f8163a[C2409e.WEBVIEW_BANNER_LEGACY.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f8163a[C2409e.WEBVIEW_BANNER_250.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f8163a[C2409e.WEBVIEW_INTERSTITIAL_HORIZONTAL.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f8163a[C2409e.WEBVIEW_INTERSTITIAL_VERTICAL.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f8163a[C2409e.WEBVIEW_INTERSTITIAL_TABLET.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f8163a[C2409e.WEBVIEW_INTERSTITIAL_UNKNOWN.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    public static C2346b m9040a(C2409e c2409e) {
        switch (C23451.f8163a[c2409e.ordinal()]) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                return NATIVE;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
            case SpdyProtocol.QUIC /*4*/:
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                return BANNER;
            case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
            case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
            case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
            case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                return INTERSTITIAL;
            default:
                return UNKNOWN;
        }
    }
}
