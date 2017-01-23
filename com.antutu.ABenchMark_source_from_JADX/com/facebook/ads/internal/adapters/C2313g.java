package com.facebook.ads.internal.adapters;

import com.facebook.ads.internal.util.C2510r;
import java.util.Locale;

/* renamed from: com.facebook.ads.internal.adapters.g */
public enum C2313g {
    UNKNOWN,
    AN,
    ADMOB,
    INMOBI,
    YAHOO;

    public static C2313g m8818a(String str) {
        if (C2510r.m9516a(str)) {
            return UNKNOWN;
        }
        try {
            return (C2313g) Enum.valueOf(C2313g.class, str.toUpperCase(Locale.getDefault()));
        } catch (Exception e) {
            return UNKNOWN;
        }
    }
}
