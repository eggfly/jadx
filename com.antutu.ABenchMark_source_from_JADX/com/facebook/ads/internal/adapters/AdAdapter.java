package com.facebook.ads.internal.adapters;

import com.facebook.ads.internal.server.AdPlacementType;

public interface AdAdapter {
    AdPlacementType getPlacementType();

    void onDestroy();
}
