package com.google.analytics.tracking.android;

import com.google.analytics.tracking.android.MetaModel.MetaInfo;
import com.umeng.message.util.HttpRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class HitBuilder {
    HitBuilder() {
    }

    static String encode(String str) {
        try {
            return URLEncoder.encode(str, HttpRequest.f14548a);
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError("URL encoding failed for: " + str);
        }
    }

    static Map<String, String> generateHitParams(MetaModel metaModel, Map<String, String> map) {
        Map<String, String> hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            MetaInfo metaInfo = metaModel.getMetaInfo((String) entry.getKey());
            if (metaInfo != null) {
                String urlParam = metaInfo.getUrlParam((String) entry.getKey());
                if (urlParam != null) {
                    String str = (String) entry.getValue();
                    if (metaInfo.getFormatter() != null) {
                        str = metaInfo.getFormatter().format(str);
                    }
                    if (!(str == null || str.equals(metaInfo.getDefaultValue()))) {
                        hashMap.put(urlParam, str);
                    }
                }
            }
        }
        return hashMap;
    }

    static String postProcessHit(Hit hit, long j) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(hit.getHitParams());
        if (hit.getHitTime() > 0) {
            long hitTime = j - hit.getHitTime();
            if (hitTime >= 0) {
                stringBuilder.append("&").append(ModelFields.QUEUE_TIME).append("=").append(hitTime);
            }
        }
        stringBuilder.append("&").append(ModelFields.CACHE_BUSTER).append("=").append(hit.getHitId());
        return stringBuilder.toString();
    }
}
