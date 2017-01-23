package com.baidu.mobads.interfaces.feeds;

import java.util.HashMap;
import java.util.Map;

public interface IXAdFeedsRequestParameters {
    String getAdPlacementId();

    int getAdsType();

    Map<String, String> getExtras();

    String getKeywords();

    boolean isConfirmDownloading();

    HashMap<String, Object> toHashMap();
}
