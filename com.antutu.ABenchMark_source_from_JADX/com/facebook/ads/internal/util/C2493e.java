package com.facebook.ads.internal.util;

import java.util.Locale;

/* renamed from: com.facebook.ads.internal.util.e */
public enum C2493e {
    NONE,
    INSTALLED,
    NOT_INSTALLED;

    public static C2493e m9464a(String str) {
        if (C2510r.m9516a(str)) {
            return NONE;
        }
        try {
            return C2493e.valueOf(str.toUpperCase(Locale.US));
        } catch (IllegalArgumentException e) {
            return NONE;
        }
    }
}
