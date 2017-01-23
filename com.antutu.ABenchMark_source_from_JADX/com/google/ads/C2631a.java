package com.google.ads;

import com.google.android.gms.ads.C2716c;

@Deprecated
/* renamed from: com.google.ads.a */
public final class C2631a {
    public static final String f9164a;

    /* renamed from: com.google.ads.a.a */
    public enum C2622a {
        INVALID_REQUEST("Invalid Ad request."),
        NO_FILL("Ad request successful, but no ad returned due to lack of ad inventory."),
        NETWORK_ERROR("A network error occurred."),
        INTERNAL_ERROR("There was an internal error.");
        
        private final String f9103e;

        private C2622a(String str) {
            this.f9103e = str;
        }

        public String toString() {
            return this.f9103e;
        }
    }

    /* renamed from: com.google.ads.a.b */
    public enum C2623b {
        UNKNOWN,
        MALE,
        FEMALE
    }

    static {
        f9164a = C2716c.f9255a;
    }

    private C2631a() {
    }
}
