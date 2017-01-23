package com.qq.p035e.ads.banner;

import com.qq.p035e.comm.util.GDTLogger;

/* renamed from: com.qq.e.ads.banner.AbstractBannerADListener */
public abstract class AbstractBannerADListener implements BannerADListener {
    public void onADClicked() {
        GDTLogger.m16602i("On BannerAD Clicked");
    }

    public void onADCloseOverlay() {
        GDTLogger.m16602i("On BannerAD AdCloseOverlay");
    }

    public void onADClosed() {
        GDTLogger.m16602i("On BannerAD Closed");
    }

    public void onADExposure() {
        GDTLogger.m16602i("On BannerAD Exposured");
    }

    public void onADLeftApplication() {
        GDTLogger.m16602i("On BannerAD AdLeftApplication");
    }

    public void onADOpenOverlay() {
        GDTLogger.m16602i("On BannerAD AdOpenOverlay");
    }
}
