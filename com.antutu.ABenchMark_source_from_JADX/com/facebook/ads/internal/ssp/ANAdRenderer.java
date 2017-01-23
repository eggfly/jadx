package com.facebook.ads.internal.ssp;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.facebook.ads.AdSize;
import com.facebook.ads.internal.C2356d;
import com.facebook.ads.internal.C2409e;
import com.facebook.ads.internal.adapters.C2329n;
import com.facebook.ads.internal.p121f.C2450c;
import com.xiaomi.mipush.sdk.Constants;
import org.android.spdy.SpdyProtocol;
import org.json.JSONObject;

public class ANAdRenderer {

    /* renamed from: com.facebook.ads.internal.ssp.ANAdRenderer.1 */
    static /* synthetic */ class C24851 {
        static final /* synthetic */ int[] f8547a;

        static {
            f8547a = new int[AdSize.values().length];
            try {
                f8547a[AdSize.INTERSTITIAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f8547a[AdSize.RECTANGLE_HEIGHT_250.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f8547a[AdSize.BANNER_HEIGHT_90.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f8547a[AdSize.BANNER_HEIGHT_50.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public interface Listener {
        void onAdClick();

        void onAdClose();

        void onAdError(Throwable th);

        void onAdImpression();
    }

    public static String getSupportedCapabilities() {
        return TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, C2356d.f8237m);
    }

    public static int getTemplateID(int i, int i2) {
        AdSize fromWidthAndHeight = AdSize.fromWidthAndHeight(i, i2);
        if (fromWidthAndHeight == null) {
            return C2409e.UNKNOWN.m9262a();
        }
        switch (C24851.f8547a[fromWidthAndHeight.ordinal()]) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                return C2409e.WEBVIEW_INTERSTITIAL_UNKNOWN.m9262a();
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                return C2409e.WEBVIEW_BANNER_250.m9262a();
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                return C2409e.WEBVIEW_BANNER_90.m9262a();
            case SpdyProtocol.QUIC /*4*/:
                return C2409e.WEBVIEW_BANNER_50.m9262a();
            default:
                return C2409e.WEBVIEW_BANNER_LEGACY.m9262a();
        }
    }

    public static View renderAd(Context context, JSONObject jSONObject, int i, int i2, int i3, Listener listener) {
        try {
            return new C2450c(context, C2329n.m8937a(jSONObject), i3, listener);
        } catch (Throwable th) {
            listener.onAdError(th);
            return null;
        }
    }
}
