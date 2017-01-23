package com.google.android.gms.analytics.internal;

public enum ad {
    NONE,
    GZIP;

    public static ad j6(String str) {
        return "GZIP".equalsIgnoreCase(str) ? GZIP : NONE;
    }
}
