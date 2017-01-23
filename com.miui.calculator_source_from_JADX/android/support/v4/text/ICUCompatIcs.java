package android.support.v4.text;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.Locale;

class ICUCompatIcs {
    private static Method f681a;
    private static Method f682b;

    ICUCompatIcs() {
    }

    static {
        try {
            Class cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                f681a = cls.getMethod("getScript", new Class[]{String.class});
                f682b = cls.getMethod("addLikelySubtags", new Class[]{String.class});
            }
        } catch (Throwable e) {
            f681a = null;
            f682b = null;
            Log.w("ICUCompatIcs", e);
        }
    }

    public static String m1042a(Locale locale) {
        String b = m1043b(locale);
        if (b != null) {
            return m1041a(b);
        }
        return null;
    }

    private static String m1041a(String str) {
        try {
            if (f681a != null) {
                return (String) f681a.invoke(null, new Object[]{str});
            }
        } catch (Throwable e) {
            Log.w("ICUCompatIcs", e);
        } catch (Throwable e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return null;
    }

    private static String m1043b(Locale locale) {
        String locale2 = locale.toString();
        try {
            if (f682b != null) {
                return (String) f682b.invoke(null, new Object[]{locale2});
            }
        } catch (Throwable e) {
            Log.w("ICUCompatIcs", e);
        } catch (Throwable e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return locale2;
    }
}
