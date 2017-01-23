package com.facebook.ads.internal.adapters;

import android.content.Context;
import com.facebook.ads.AdSize;
import com.facebook.ads.internal.server.AdPlacementType;
import java.util.Map;

public abstract class BannerAdapter implements AdAdapter {
    public final AdPlacementType getPlacementType() {
        return AdPlacementType.BANNER;
    }

    public abstract void loadBannerAd(Context context, AdSize adSize, BannerAdapterListener bannerAdapterListener, Map<String, Object> map);
}
