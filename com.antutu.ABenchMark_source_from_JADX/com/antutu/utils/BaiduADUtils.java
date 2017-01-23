package com.antutu.utils;

import android.content.Context;
import com.antutu.ABenchMark.C1082R;
import com.baidu.BaiduMSSP;
import com.baidu.mobad.feeds.BaiduNative;
import com.baidu.mobad.feeds.BaiduNative.BaiduNativeNetworkListener;
import com.baidu.mobad.feeds.NativeErrorCode;
import com.baidu.mobad.feeds.NativeResponse;
import com.baidu.mobad.feeds.RequestParameters.Builder;
import java.util.ArrayList;
import java.util.List;

public class BaiduADUtils {
    private static List<NativeResponse> ads;
    private static int nowPosition;

    /* renamed from: com.antutu.utils.BaiduADUtils.1 */
    static class C17851 implements BaiduNativeNetworkListener {
        C17851() {
        }

        public void onNativeFail(NativeErrorCode nativeErrorCode) {
            MLog.m6865d("Martin baidu ad", "onNativeFail reason:" + nativeErrorCode.name());
        }

        public void onNativeLoad(List<NativeResponse> list) {
            if (list != null && list.size() > 0) {
                BaiduADUtils.ads.clear();
                BaiduADUtils.ads.addAll(list);
            }
        }
    }

    static {
        ads = new ArrayList();
        nowPosition = 0;
    }

    public static NativeResponse getAds(int i) {
        return (i < 0 || i >= ads.size()) ? null : (NativeResponse) ads.get(i);
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

    public static String getAppStatus(Context context, NativeResponse nativeResponse) {
        int i = nativeResponse.isDownloadApp() ? C1082R.string.download_baidu_ad : C1082R.string.look_baidu_ad;
        if (nativeResponse.isDownloadApp() && Methods.hasInstalled(nativeResponse.getAppPackage())) {
            i = C1082R.string.open;
        }
        return context.getString(i);
    }

    public static boolean hasAds() {
        return ads.size() > 0;
    }

    public static void initAds(Context context) {
        new BaiduNative(context, BaiduMSSP.AD_PLACE_ID, new C17851()).makeRequest(new Builder().confirmDownloading(true).build());
    }
}
