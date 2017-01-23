package android.support.v4.text;

import android.os.Build.VERSION;
import java.util.Locale;

public class ICUCompat {
    private static final ICUCompatImpl f679a;

    interface ICUCompatImpl {
        String m1035a(Locale locale);
    }

    static class ICUCompatImplBase implements ICUCompatImpl {
        ICUCompatImplBase() {
        }

        public String m1036a(Locale locale) {
            return null;
        }
    }

    static class ICUCompatImplIcs implements ICUCompatImpl {
        ICUCompatImplIcs() {
        }

        public String m1037a(Locale locale) {
            return ICUCompatIcs.m1042a(locale);
        }
    }

    static class ICUCompatImplLollipop implements ICUCompatImpl {
        ICUCompatImplLollipop() {
        }

        public String m1038a(Locale locale) {
            return ICUCompatApi23.m1040a(locale);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f679a = new ICUCompatImplLollipop();
        } else if (i >= 14) {
            f679a = new ICUCompatImplIcs();
        } else {
            f679a = new ICUCompatImplBase();
        }
    }

    public static String m1039a(Locale locale) {
        return f679a.m1035a(locale);
    }
}
