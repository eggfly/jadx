package com.google.android.gms.p146b;

import com.google.ads.C2631a.C2622a;
import com.google.ads.C2631a.C2623b;
import com.google.ads.C2632b;
import com.google.ads.mediation.C2650b;
import com.google.android.gms.ads.C2726i;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import java.util.Date;
import java.util.HashSet;
import org.android.spdy.SpdyProtocol;

@gb
/* renamed from: com.google.android.gms.b.ej */
public final class ej {

    /* renamed from: com.google.android.gms.b.ej.1 */
    static /* synthetic */ class C31641 {
        static final /* synthetic */ int[] f10758a;
        static final /* synthetic */ int[] f10759b;

        static {
            f10759b = new int[C2622a.values().length];
            try {
                f10759b[C2622a.INTERNAL_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f10759b[C2622a.INVALID_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f10759b[C2622a.NETWORK_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f10759b[C2622a.NO_FILL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            f10758a = new int[C2623b.values().length];
            try {
                f10758a[C2623b.FEMALE.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f10758a[C2623b.MALE.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f10758a[C2623b.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public static int m12582a(C2622a c2622a) {
        switch (C31641.f10759b[c2622a.ordinal()]) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                return 1;
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                return 2;
            case SpdyProtocol.QUIC /*4*/:
                return 3;
            default:
                return 0;
        }
    }

    public static C2623b m12583a(int i) {
        switch (i) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                return C2623b.MALE;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                return C2623b.FEMALE;
            default:
                return C2623b.UNKNOWN;
        }
    }

    public static C2632b m12584a(AdSizeParcel adSizeParcel) {
        int i = 0;
        C2632b[] c2632bArr = new C2632b[]{C2632b.f9165a, C2632b.f9166b, C2632b.f9167c, C2632b.f9168d, C2632b.f9169e, C2632b.f9170f};
        while (i < c2632bArr.length) {
            if (c2632bArr[i].m10135a() == adSizeParcel.f9330f && c2632bArr[i].m10136b() == adSizeParcel.f9327c) {
                return c2632bArr[i];
            }
            i++;
        }
        return new C2632b(C2726i.m10380a(adSizeParcel.f9330f, adSizeParcel.f9327c, adSizeParcel.f9326b));
    }

    public static C2650b m12585a(AdRequestParcel adRequestParcel) {
        return new C2650b(new Date(adRequestParcel.f9308b), ej.m12583a(adRequestParcel.f9310d), adRequestParcel.f9311e != null ? new HashSet(adRequestParcel.f9311e) : null, adRequestParcel.f9312f, adRequestParcel.f9317k);
    }
}
