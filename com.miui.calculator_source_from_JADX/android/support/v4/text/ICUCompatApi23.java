package android.support.v4.text;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.Locale;

public class ICUCompatApi23 {
    private static Method f680a;

    static {
        try {
            f680a = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[]{Locale.class});
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public static String m1040a(Locale locale) {
        try {
            return ((Locale) f680a.invoke(null, new Object[]{locale})).getScript();
        } catch (Throwable e) {
            Log.w("ICUCompatIcs", e);
            return locale.getScript();
        } catch (Throwable e2) {
            Log.w("ICUCompatIcs", e2);
            return locale.getScript();
        }
    }
}
