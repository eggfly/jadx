package com.baidu.mobad.feeds;

import com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters;
import com.igexin.download.Downloads;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class RequestParameters implements IXAdFeedsRequestParameters {
    public static final int ADS_TYPE_DOWNLOAD = 2;
    public static final int ADS_TYPE_OPENPAGE = 1;
    public static final int MAX_ASSETS_RESERVED = 15;
    public static final String TAG = "RequestParameters";
    private final String f6498a;
    private int f6499b;
    private boolean f6500c;
    private Map<String, String> f6501d;
    private int f6502e;
    private int f6503f;
    protected String mPlacementId;

    public static class Builder {
        private String f6492a;
        private Map<String, String> f6493b;
        private int f6494c;
        private boolean f6495d;
        private int f6496e;
        private int f6497f;

        public Builder() {
            this.f6493b = new HashMap();
            this.f6494c = 3;
            this.f6495d = false;
            this.f6496e = 640;
            this.f6497f = 480;
        }

        public final Builder addExtra(String str, String str2) {
            this.f6493b.put(str, str2);
            return this;
        }

        public final RequestParameters build() {
            return new RequestParameters();
        }

        public final Builder confirmDownloading(boolean z) {
            this.f6495d = z;
            return this;
        }

        public final Builder setHeight(int i) {
            this.f6497f = i;
            return this;
        }

        public final Builder setWidth(int i) {
            this.f6496e = i;
            return this;
        }
    }

    private RequestParameters(Builder builder) {
        this.f6502e = 0;
        this.f6503f = 0;
        this.f6498a = builder.f6492a;
        this.f6499b = builder.f6494c;
        this.f6502e = builder.f6496e;
        this.f6503f = builder.f6497f;
        this.f6500c = builder.f6495d;
        setExtras(builder.f6493b);
    }

    public String getAdPlacementId() {
        return this.mPlacementId;
    }

    public int getAdsType() {
        return this.f6499b;
    }

    public Map<String, String> getExtras() {
        return this.f6501d;
    }

    public int getHeight() {
        return this.f6503f;
    }

    public final String getKeywords() {
        return this.f6498a;
    }

    public int getWidth() {
        return this.f6502e;
    }

    public boolean isConfirmDownloading() {
        return this.f6500c;
    }

    public void setAdsType(int i) {
        this.f6499b = i;
    }

    public void setExtras(Map<String, String> map) {
        this.f6501d = map;
    }

    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> hashMap = new HashMap();
        hashMap.put("mKeywords", this.f6498a);
        hashMap.put("adsType", Integer.valueOf(this.f6499b));
        hashMap.put("confirmDownloading", Boolean.valueOf(this.f6500c));
        HashMap hashMap2 = new HashMap();
        if (this.f6501d != null) {
            for (Entry entry : this.f6501d.entrySet()) {
                hashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        hashMap.put(Downloads.COLUMN_EXTRAS, hashMap2);
        return hashMap;
    }
}
