package com.qq.p035e.ads.interstitial;

import com.qq.p035e.comm.util.GDTLogger;

/* renamed from: com.qq.e.ads.interstitial.AbstractInterstitialADListener */
public abstract class AbstractInterstitialADListener implements InterstitialADListener {
    public void onADClicked() {
        GDTLogger.m16602i("ON InterstitialAD Clicked");
    }

    public void onADClosed() {
        GDTLogger.m16602i("ON InterstitialAD Closed");
    }

    public void onADExposure() {
        GDTLogger.m16602i("ON InterstitialAD Exposure");
    }

    public void onADLeftApplication() {
        GDTLogger.m16602i("ON InterstitialAD LeftApplication");
    }

    public void onADOpened() {
        GDTLogger.m16602i("ON InterstitialAD Opened");
    }
}
