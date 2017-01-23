package com.facebook.ads;

public abstract class AbstractAdListener implements AdListener, ImpressionListener, InterstitialAdListener {
    public void onAdClicked(Ad ad) {
    }

    public void onAdLoaded(Ad ad) {
    }

    public void onError(Ad ad, AdError adError) {
    }

    public void onInterstitialDismissed(Ad ad) {
    }

    public void onInterstitialDisplayed(Ad ad) {
    }

    public void onLoggingImpression(Ad ad) {
    }
}
