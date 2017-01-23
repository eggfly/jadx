package com.facebook.ads.internal.adapters;

import com.facebook.ads.AdError;

public interface InterstitialAdapterListener {
    void onInterstitialAdClicked(InterstitialAdapter interstitialAdapter, String str, boolean z);

    void onInterstitialAdDismissed(InterstitialAdapter interstitialAdapter);

    void onInterstitialAdDisplayed(InterstitialAdapter interstitialAdapter);

    void onInterstitialAdLoaded(InterstitialAdapter interstitialAdapter);

    void onInterstitialError(InterstitialAdapter interstitialAdapter, AdError adError);

    void onInterstitialLoggingImpression(InterstitialAdapter interstitialAdapter);
}
