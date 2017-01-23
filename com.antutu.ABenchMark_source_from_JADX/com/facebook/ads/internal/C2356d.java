package com.facebook.ads.internal;

import org.json.JSONArray;

/* renamed from: com.facebook.ads.internal.d */
public enum C2356d {
    APP_AD(0),
    LINK_AD(1),
    APP_AD_V2(2),
    LINK_AD_V2(3),
    APP_ENGAGEMENT_AD(4),
    AD_CHOICES(5),
    JS_TRIGGER(6),
    JS_TRIGGER_NO_AUTO_IMP_LOGGING(7),
    VIDEO_AD(8),
    INLINE_VIDEO_AD(9),
    BANNER_TO_INTERSTITIAL(10),
    NATIVE_CLOSE_BUTTON(11);
    
    public static final C2356d[] f8237m;
    private static final String f8238o;
    private final int f8240n;

    static {
        f8237m = new C2356d[]{LINK_AD_V2, APP_ENGAGEMENT_AD, AD_CHOICES, JS_TRIGGER_NO_AUTO_IMP_LOGGING, NATIVE_CLOSE_BUTTON};
        JSONArray jSONArray = new JSONArray();
        C2356d[] c2356dArr = f8237m;
        int length = c2356dArr.length;
        int i;
        while (i < length) {
            jSONArray.put(c2356dArr[i].m9073a());
            i++;
        }
        f8238o = jSONArray.toString();
    }

    private C2356d(int i) {
        this.f8240n = i;
    }

    public static String m9072b() {
        return f8238o;
    }

    int m9073a() {
        return this.f8240n;
    }

    public String toString() {
        return String.valueOf(this.f8240n);
    }
}
