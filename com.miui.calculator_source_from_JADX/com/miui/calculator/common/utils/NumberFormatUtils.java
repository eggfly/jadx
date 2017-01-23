package com.miui.calculator.common.utils;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.DateUtils;
import com.miui.calculator.CalculatorApplication;
import com.miui.support.internal.C0264R;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatUtils {
    private static final int[] f1550a;
    private static final int[] f1551b;
    private static final int[] f1552c;
    private static final int[] f1553d;
    private static NumberFormat f1554e;
    private static DecimalFormat f1555f;

    static {
        f1550a = new int[]{C0264R.string.word_figure_number_0, C0264R.string.word_figure_number_1, C0264R.string.word_figure_number_2, C0264R.string.word_figure_number_3, C0264R.string.word_figure_number_4, C0264R.string.word_figure_number_5, C0264R.string.word_figure_number_6, C0264R.string.word_figure_number_7, C0264R.string.word_figure_number_8, C0264R.string.word_figure_number_9};
        f1551b = new int[]{-1, C0264R.string.word_figure_unit_shi, C0264R.string.word_figure_unit_bai, C0264R.string.word_figure_unit_qian};
        f1552c = new int[]{-1, C0264R.string.word_figure_big_unit_wan, C0264R.string.word_figure_big_unit_yi, C0264R.string.word_figure_big_unit_zhao};
        f1553d = new int[]{C0264R.string.word_figure_big_unit_jiao, C0264R.string.word_figure_big_unit_fen};
        f1554e = NumberFormat.getNumberInstance(Locale.ENGLISH);
        f1555f = new DecimalFormat("", new DecimalFormatSymbols(Locale.ENGLISH));
    }

    public static String m2874a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int a = m2869a(0, str);
        int i = 0;
        while (a != -1) {
            stringBuilder.append(str.subSequence(i, a));
            String b = m2878b(a, str);
            if (b.length() > 20) {
                i = b.length() - 20;
                b = b.substring(0, 20);
            } else {
                i = 0;
            }
            Object c = m2883c(b);
            if (c.startsWith("0") || TextUtils.isEmpty(c)) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append(c);
            }
            int length = (b.length() + a) + i;
            a = m2869a(length, str);
            i = length;
        }
        stringBuilder.append(str.substring(i));
        return stringBuilder.toString();
    }

    public static String m2880b(String str) {
        return str.replaceAll(String.valueOf(','), "");
    }

    private static int m2869a(int i, String str) {
        if (i < str.length()) {
            int i2 = i;
            while (i2 < str.length()) {
                char charAt = str.charAt(i2);
                if (Character.isDigit(charAt)) {
                    return i2;
                }
                if (charAt == 'e') {
                    if ((i2 == i || Character.isDigit(str.charAt(i2 - 1))) && i2 < str.length() - 1) {
                        charAt = str.charAt(i2 + 1);
                        if (charAt == '\u2212' || Character.isDigit(charAt)) {
                            i2++;
                        }
                        i2++;
                        while (i2 < str.length() && Character.isDigit(str.charAt(i2))) {
                            i2++;
                        }
                    }
                } else if (charAt == '.') {
                    i2++;
                    while (i2 < str.length() && Character.isDigit(str.charAt(i2))) {
                        i2++;
                    }
                }
                i2++;
            }
        }
        return -1;
    }

    private static String m2878b(int i, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        if (i < str.length()) {
            while (i < str.length()) {
                char charAt = str.charAt(i);
                if (!Character.isDigit(charAt) && '.' != charAt) {
                    break;
                }
                stringBuilder.append(charAt);
                i++;
            }
        }
        return stringBuilder.toString();
    }

    public static String m2883c(String str) {
        int i = 1;
        double d = 0.0d;
        try {
            d = Double.parseDouble(str);
        } catch (Exception e) {
            i = 0;
        }
        if (i == 0) {
            return str;
        }
        i = str.indexOf(46);
        int indexOf = str.indexOf(101);
        if (i == -1 || indexOf != -1) {
            return m2870a(d);
        }
        return m2873a(Long.parseLong(str.substring(0, i))) + str.substring(i);
    }

    public static String m2873a(long j) {
        return f1554e.format(j);
    }

    public static String m2870a(double d) {
        return f1554e.format(d);
    }

    public static String m2871a(double d, int i) {
        return m2870a(CalculatorUtils.m2813a(m2885d(d, i)));
    }

    public static String m2876b(double d) {
        String str;
        StringBuilder append = new StringBuilder().append(m2870a(Double.valueOf(CalculatorUtils.m2813a(m2885d(d, 2))).doubleValue()));
        if (CalculatorUtils.m2821b()) {
            str = "";
        } else {
            str = " " + CalculatorApplication.m2559b().getResources().getString(C0264R.string.unit_yuan);
        }
        return append.append(str).toString();
    }

    public static String m2881c(double d) {
        Context b = CalculatorApplication.m2559b();
        if (d >= 10000.0d && !CalculatorUtils.m2821b()) {
            return m2885d(d / 10000.0d, 2) + " " + b.getResources().getString(C0264R.string.unit_myriads);
        }
        String str;
        StringBuilder append = new StringBuilder().append(m2885d(d, 2));
        if (CalculatorUtils.m2821b()) {
            str = "";
        } else {
            str = " " + b.getResources().getString(C0264R.string.unit_yuan);
        }
        return append.append(str).toString();
    }

    public static String m2884d(double d) {
        return m2871a(d, 2);
    }

    public static String m2877b(double d, int i) {
        StringBuilder stringBuilder = new StringBuilder("0.");
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append("0");
        }
        f1555f.applyPattern(stringBuilder.toString());
        f1555f.setRoundingMode(RoundingMode.FLOOR);
        return f1555f.format(d);
    }

    public static String m2882c(double d, int i) {
        StringBuilder stringBuilder = new StringBuilder("0.");
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append("#");
        }
        f1555f.applyPattern(stringBuilder.toString());
        f1555f.setRoundingMode(RoundingMode.FLOOR);
        return f1555f.format(d);
    }

    public static String m2885d(double d, int i) {
        StringBuilder stringBuilder = new StringBuilder("#.");
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append("#");
        }
        f1555f.applyPattern(stringBuilder.toString());
        return f1555f.format(d);
    }

    public static String m2886d(String str) {
        String str2 = null;
        if (str == null) {
            return null;
        }
        String replaceAll = str.replaceAll(String.valueOf(','), "");
        int indexOf = replaceAll.indexOf(46);
        if (indexOf != -1) {
            str2 = replaceAll.substring(indexOf + 1);
            replaceAll = replaceAll.substring(0, indexOf);
        }
        return m2875a(replaceAll, str2);
    }

    private static String m2875a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i;
        int i2;
        int i3;
        String replaceAll = str.replaceAll(String.valueOf(','), "");
        for (i = 0; i < replaceAll.length(); i++) {
            if (!Character.isDigit(replaceAll.charAt(i))) {
                return null;
            }
        }
        if (str2 != null) {
            for (i = 0; i < str2.length(); i++) {
                if (!Character.isDigit(str2.charAt(i))) {
                    return null;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        String str3 = replaceAll;
        while (str3.charAt(0) == '0' && str3.length() > 1) {
            str3 = str3.substring(1);
        }
        if ("0".equals(str3)) {
            stringBuilder.append(m2872a(f1550a[0]));
        } else {
            int length = str3.length() - 1;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            i2 = 1;
            i3 = 0;
            while (length >= 0) {
                if (i4 >= f1552c.length) {
                    return null;
                }
                int i7;
                int parseInt = Integer.parseInt(String.valueOf(str3.charAt(length)));
                if (parseInt != 0 || r5 == 0) {
                    stringBuilder.insert(0, m2872a(f1550a[parseInt]));
                    i3++;
                    if (parseInt != 0) {
                        String a = m2872a(f1551b[i5]);
                        stringBuilder.insert(1, a);
                        i3 += a.length();
                        i6 = 1;
                        i2 = 0;
                    } else {
                        if (i5 == 0) {
                            i3--;
                        }
                        i2 = 1;
                    }
                }
                if ((i5 == f1551b.length - 1 || length == 0) && i6 != 0) {
                    stringBuilder.insert(i3, m2872a(f1552c[i4]));
                    i3 = 0;
                }
                i5++;
                if (i5 >= f1551b.length) {
                    i6 = i4 + 1;
                    i4 = 0;
                    i5 = 0;
                } else {
                    i7 = i4;
                    i4 = i5;
                    i5 = i6;
                    i6 = i7;
                }
                length--;
                i7 = i6;
                i6 = i5;
                i5 = i4;
                i4 = i7;
            }
        }
        stringBuilder.append(m2872a((int) C0264R.string.word_figure_yuan));
        CharSequence stringBuilder2 = new StringBuilder();
        if (!TextUtils.isEmpty(str2)) {
            i3 = 0;
            for (i = 0; i < Math.min(str2.length(), 2); i++) {
                i2 = Integer.parseInt(String.valueOf(str2.charAt(i)));
                if (i2 != 0) {
                    if (i3 != 0) {
                        stringBuilder2.append(m2872a(f1550a[0]));
                    }
                    stringBuilder2.append(m2872a(f1550a[i2]));
                    stringBuilder2.append(m2872a(f1553d[i]));
                    i3 = 0;
                } else {
                    i3 = 1;
                }
            }
        }
        if (stringBuilder2.length() > 0) {
            stringBuilder.append(stringBuilder2);
        } else {
            stringBuilder.append(m2872a((int) C0264R.string.word_figure_zheng));
        }
        return stringBuilder.toString();
    }

    private static String m2872a(int i) {
        if (i <= 0) {
            return "";
        }
        return CalculatorApplication.m2559b().getString(i);
    }

    public static String m2879b(long j) {
        return DateUtils.formatDateTime(CalculatorApplication.m2559b(), j, 20);
    }
}
