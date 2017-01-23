package com.google.analytics.tracking.android;

import java.util.Map;
import java.util.Random;

class AdMobInfo {
    private static final AdMobInfo INSTANCE;
    private int mAdHitId;
    private Random mRandom;

    enum AdMobKey {
        CLIENT_ID_KEY("ga_cid"),
        HIT_ID_KEY("ga_hid"),
        PROPERTY_ID_KEY("ga_wpids"),
        VISITOR_ID_KEY("ga_uid");
        
        private String mBowParameter;

        private AdMobKey(String str) {
            this.mBowParameter = str;
        }

        String getBowParameter() {
            return this.mBowParameter;
        }
    }

    static {
        INSTANCE = new AdMobInfo();
    }

    AdMobInfo() {
        this.mRandom = new Random();
    }

    static AdMobInfo getInstance() {
        return INSTANCE;
    }

    int generateAdHitId() {
        this.mAdHitId = this.mRandom.nextInt(2147483646) + 1;
        return this.mAdHitId;
    }

    int getAdHitId() {
        return this.mAdHitId;
    }

    Map<String, String> getJoinIds() {
        return null;
    }

    void setAdHitId(int i) {
        this.mAdHitId = i;
    }
}
