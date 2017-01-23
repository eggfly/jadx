package com.antutu.utils;

import android.content.Context;
import com.antutu.ABenchMark.C1082R;
import com.qq.p035e.ads.nativ.NativeAD;
import com.qq.p035e.ads.nativ.NativeAD.NativeAdListener;
import com.qq.p035e.ads.nativ.NativeADDataRef;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

public class GDTUtils {
    private static List<NativeADDataRef> ads;
    private static int nowPosition;

    /* renamed from: com.antutu.utils.GDTUtils.1 */
    static class C17941 implements NativeAdListener {
        C17941() {
        }

        public void onADError(NativeADDataRef nativeADDataRef, int i) {
        }

        public void onADLoaded(List<NativeADDataRef> list) {
            GDTUtils.ads.clear();
            GDTUtils.ads.addAll(list);
        }

        public void onADStatusChanged(NativeADDataRef nativeADDataRef) {
            if (nativeADDataRef != null) {
                MLog.m6865d("nativeADDataRef + getDownloadCount", BuildConfig.FLAVOR + nativeADDataRef.getDownloadCount());
            }
        }

        public void onNoAD(int i) {
            MLog.m6865d("onNoAD", i + BuildConfig.FLAVOR);
        }
    }

    static {
        ads = new ArrayList();
        nowPosition = 0;
    }

    public static NativeADDataRef getAds(int i) {
        return (i < 0 || i >= ads.size()) ? null : (NativeADDataRef) ads.get(i);
    }

    public static int getAdsPosition() {
        int size = ads.size();
        if (size <= 0) {
            return -1;
        }
        int i = nowPosition;
        nowPosition = i + 1;
        if (nowPosition < size) {
            return i;
        }
        nowPosition = 0;
        return i;
    }

    public static String getAppStatus(Context context, NativeADDataRef nativeADDataRef) {
        if (!nativeADDataRef.isAPP()) {
            return context.getString(C1082R.string.look_detail);
        }
        switch (nativeADDataRef.getAPPStatus()) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                return context.getString(C1082R.string.click_download);
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                return context.getString(C1082R.string.click_start);
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                return context.getString(C1082R.string.click_update);
            case SpdyProtocol.QUIC /*4*/:
                return context.getString(C1082R.string.downloading_arg, new Object[]{Integer.valueOf(nativeADDataRef.getProgress())});
            case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                return context.getString(C1082R.string.click_install);
            case SpdyProtocol.CUSTOM /*16*/:
                return context.getString(C1082R.string.download_failed);
            default:
                return context.getString(C1082R.string.look_detail);
        }
    }

    public static boolean hasAds() {
        return ads.size() > 0;
    }

    public static void initAds(Context context) {
        new NativeAD(context, "1105161001", "2010407994601022", new C17941()).loadAD(15);
    }
}
