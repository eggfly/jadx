import com.aide.licensing.c.a;

/* synthetic */ class oa$2 {
    static final /* synthetic */ int[] j6;

    static {
        j6 = new int[a.values().length];
        try {
            j6[a.LICENSED.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            j6[a.IN_GRACE_PERIOD.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            j6[a.OVER_GRACE_PERIOD.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            j6[a.NOT_LICENSED.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            j6[a.TEMPORARY_ERROR.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
    }
}
