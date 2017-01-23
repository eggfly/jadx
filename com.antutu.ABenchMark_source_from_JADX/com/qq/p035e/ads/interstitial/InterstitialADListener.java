package com.qq.p035e.ads.interstitial;

/* renamed from: com.qq.e.ads.interstitial.InterstitialADListener */
public interface InterstitialADListener {
    void onADClicked();

    void onADClosed();

    void onADExposure();

    void onADLeftApplication();

    void onADOpened();

    void onADReceive();

    void onNoAD(int i);
}
