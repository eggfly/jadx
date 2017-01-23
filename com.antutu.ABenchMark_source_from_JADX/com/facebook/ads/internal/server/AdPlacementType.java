package com.facebook.ads.internal.server;

import com.facebook.ads.internal.util.C2510r;
import com.taobao.accs.utl.UtilityImpl;
import java.util.Locale;

public enum AdPlacementType {
    UNKNOWN(UtilityImpl.NET_TYPE_UNKNOWN),
    BANNER("banner"),
    INTERSTITIAL("interstitial"),
    NATIVE("native");
    
    private String f8523a;

    private AdPlacementType(String str) {
        this.f8523a = str;
    }

    public static AdPlacementType fromString(String str) {
        if (C2510r.m9516a(str)) {
            return UNKNOWN;
        }
        try {
            return valueOf(str.toUpperCase(Locale.US));
        } catch (Exception e) {
            return UNKNOWN;
        }
    }

    public String toString() {
        return this.f8523a;
    }
}
