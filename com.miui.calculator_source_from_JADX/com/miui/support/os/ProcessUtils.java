package com.miui.support.os;

import android.util.Log;
import java.util.Locale;

public class ProcessUtils {
    protected ProcessUtils() {
        throw new InstantiationException("Cannot instantiate utility class");
    }

    public static String m5186a(int i) {
        String format = String.format(Locale.US, "/proc/%d/cmdline", new Object[]{Integer.valueOf(i)});
        try {
            String c = FileUtils.m5184c(format);
            if (c != null) {
                int indexOf = c.indexOf(0);
                if (indexOf >= 0) {
                    return c.substring(0, indexOf);
                }
                return c;
            }
        } catch (Throwable e) {
            Log.e("ProcessUtils", "Fail to read cmdline: " + format, e);
        }
        return null;
    }
}
