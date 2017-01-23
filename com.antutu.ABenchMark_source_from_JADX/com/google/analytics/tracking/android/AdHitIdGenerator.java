package com.google.analytics.tracking.android;

import com.google.android.gms.common.util.VisibleForTesting;

class AdHitIdGenerator {
    private boolean mAdMobSdkInstalled;

    AdHitIdGenerator() {
        try {
            this.mAdMobSdkInstalled = Class.forName("com.google.ads.a") != null;
        } catch (ClassNotFoundException e) {
            this.mAdMobSdkInstalled = false;
        }
    }

    @VisibleForTesting
    AdHitIdGenerator(boolean z) {
        this.mAdMobSdkInstalled = z;
    }

    int getAdHitId() {
        return !this.mAdMobSdkInstalled ? 0 : AdMobInfo.getInstance().generateAdHitId();
    }
}
