package com.google.analytics.tracking.android;

class Hit {
    private final long mHitId;
    private String mHitString;
    private final long mHitTime;
    private String mHitUrl;

    Hit(String str, long j, long j2) {
        this.mHitString = str;
        this.mHitId = j;
        this.mHitTime = j2;
    }

    long getHitId() {
        return this.mHitId;
    }

    String getHitParams() {
        return this.mHitString;
    }

    long getHitTime() {
        return this.mHitTime;
    }

    String getHitUrl() {
        return this.mHitUrl;
    }

    void setHitString(String str) {
        this.mHitString = str;
    }

    void setHitUrl(String str) {
        this.mHitUrl = str;
    }
}
