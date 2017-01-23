package com.facebook.ads;

public interface Ad {
    void destroy();

    String getPlacementId();

    void loadAd();
}
