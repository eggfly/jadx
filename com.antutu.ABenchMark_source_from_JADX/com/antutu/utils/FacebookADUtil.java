package com.antutu.utils;

import android.content.Context;
import com.facebook.ads.AdError;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdsManager;
import com.facebook.ads.NativeAdsManager.Listener;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.List;

public class FacebookADUtil {
    private static List<NativeAd> ads;
    private static int nowPosition;

    /* renamed from: com.antutu.utils.FacebookADUtil.1 */
    static class C17931 implements Listener {
        final /* synthetic */ NativeAdsManager val$nam;

        C17931(NativeAdsManager nativeAdsManager) {
            this.val$nam = nativeAdsManager;
        }

        public void onAdError(AdError adError) {
            System.out.println(BuildConfig.FLAVOR);
        }

        public void onAdsLoaded() {
            int uniqueNativeAdCount = this.val$nam.getUniqueNativeAdCount();
            for (int i = 0; i < uniqueNativeAdCount; i++) {
                FacebookADUtil.ads.add(this.val$nam.nextNativeAd());
            }
        }
    }

    static {
        ads = new ArrayList();
        nowPosition = 0;
    }

    public static NativeAd getAds(Integer num) {
        return (num.intValue() > ads.size() + -1 || num.intValue() < 0) ? null : (NativeAd) ads.get(num.intValue());
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

    public static boolean hasAds() {
        return ads.size() > 0;
    }

    public static void initAds(Context context) {
        NativeAdsManager nativeAdsManager = new NativeAdsManager(context, "1403394553272360_1707992676145878", 15);
        nativeAdsManager.setListener(new C17931(nativeAdsManager));
        nativeAdsManager.loadAds();
    }
}
