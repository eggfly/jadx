package com.miui.support.internal.util;

import com.miui.support.util.Pools;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class SimpleNumberFormatter {
    private static Locale f2571a;
    private static char f2572b;

    static {
        f2571a = Locale.getDefault();
        f2572b = new DecimalFormatSymbols(f2571a).getZeroDigit();
    }

    public static String m4245a(int i) {
        return m4246a(-1, i);
    }

    public static String m4246a(int i, int i2) {
        char a = m4243a(Locale.getDefault());
        String b = m4247b(i, i2);
        if (a != '0') {
            return m4244a(a, b);
        }
        return b;
    }

    private static String m4247b(int i, int i2) {
        StringBuilder stringBuilder = (StringBuilder) Pools.m5430a().m5400b();
        if (i2 < 0) {
            i2 = -i2;
            i--;
            stringBuilder.append('-');
        }
        int length;
        if (i2 >= 10000) {
            String num = Integer.toString(i2);
            for (length = num.length(); length < i; length++) {
                stringBuilder.append('0');
            }
            stringBuilder.append(num);
        } else {
            if (i2 >= 1000) {
                length = 4;
            } else if (i2 >= 100) {
                length = 3;
            } else if (i2 >= 10) {
                length = 2;
            } else {
                length = 1;
            }
            while (length < i) {
                stringBuilder.append('0');
                length++;
            }
            stringBuilder.append(i2);
        }
        String stringBuilder2 = stringBuilder.toString();
        Pools.m5430a().m5401b(stringBuilder);
        return stringBuilder2;
    }

    private static String m4244a(char c, String str) {
        int length = str.length();
        int i = c - 48;
        StringBuilder stringBuilder = (StringBuilder) Pools.m5430a().m5400b();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt >= '0' && charAt <= '9') {
                charAt = (char) (charAt + i);
            }
            stringBuilder.append(charAt);
        }
        String stringBuilder2 = stringBuilder.toString();
        Pools.m5430a().m5401b(stringBuilder);
        return stringBuilder2;
    }

    private static char m4243a(Locale locale) {
        if (locale == null) {
            throw new NullPointerException("locale == null");
        }
        if (!locale.equals(f2571a)) {
            f2572b = new DecimalFormatSymbols(locale).getZeroDigit();
            f2571a = locale;
        }
        return f2572b;
    }
}
