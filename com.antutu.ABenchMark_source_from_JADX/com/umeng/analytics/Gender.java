package com.umeng.analytics;

import java.util.Locale;
import org.android.spdy.SpdyProtocol;
import p023b.p024a.ab;

public enum Gender {
    Male(1) {
        public String toString() {
            return String.format(Locale.US, "Male:%d", new Object[]{Integer.valueOf(this.value)});
        }
    },
    Female(2) {
        public String toString() {
            return String.format(Locale.US, "Female:%d", new Object[]{Integer.valueOf(this.value)});
        }
    },
    Unknown(0) {
        public String toString() {
            return String.format(Locale.US, "Unknown:%d", new Object[]{Integer.valueOf(this.value)});
        }
    };
    
    public int value;

    /* renamed from: com.umeng.analytics.Gender.4 */
    static /* synthetic */ class C41554 {
        static final /* synthetic */ int[] f13933a;

        static {
            f13933a = new int[Gender.values().length];
            try {
                f13933a[Gender.Male.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f13933a[Gender.Female.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f13933a[Gender.Unknown.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private Gender(int i) {
        this.value = i;
    }

    public static Gender getGender(int i) {
        switch (i) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                return Male;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                return Female;
            default:
                return Unknown;
        }
    }

    public static ab transGender(Gender gender) {
        switch (C41554.f13933a[gender.ordinal()]) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                return ab.MALE;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                return ab.FEMALE;
            default:
                return ab.UNKNOWN;
        }
    }

    public int value() {
        return this.value;
    }
}
