package com.miui.calculator.common.utils;

import java.util.Locale;
import java.util.regex.Pattern;
import org.javia.arity.miui.Symbols;

public class Calculator {
    private static Calculator f1520a;
    private Symbols f1521b;

    public static Calculator m2801a() {
        if (f1520a == null) {
            f1520a = new Calculator();
        }
        return f1520a;
    }

    private Calculator() {
        this.f1521b = new Symbols();
    }

    public String m2810a(String str) {
        return m2811a(str, false);
    }

    public String m2811a(String str, boolean z) {
        return m2812a(str, z, "NaN");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String m2812a(java.lang.String r8, boolean r9, java.lang.String r10) {
        /*
        r7 = this;
        r6 = 48;
        r0 = r8.trim();
        r1 = "";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0013;
    L_0x000e:
        r0 = java.lang.String.valueOf(r6);
    L_0x0012:
        return r0;
    L_0x0013:
        r1 = com.miui.calculator.common.utils.NumberFormatUtils.m2880b(r8);
        r0 = r1.length();
    L_0x001b:
        if (r0 <= 0) goto L_0x0033;
    L_0x001d:
        r2 = r0 + -1;
        r2 = r1.charAt(r2);
        r2 = m2803a(r2);
        if (r2 == 0) goto L_0x0033;
    L_0x0029:
        r2 = 0;
        r3 = r0 + -1;
        r1 = r1.substring(r2, r3);
        r0 = r0 + -1;
        goto L_0x001b;
    L_0x0033:
        r0 = 176; // 0xb0 float:2.47E-43 double:8.7E-322;
        r0 = java.lang.String.valueOf(r0);
        r2 = " deg ";
        r0 = r1.replace(r0, r2);
        r1 = r7.m2809e(r0);
        if (r1 == 0) goto L_0x0048;
    L_0x0045:
        r0 = "error";
        goto L_0x0012;
    L_0x0048:
        r1 = r7.f1521b;	 Catch:{ SyntaxException -> 0x008f }
        r2 = r1.m6762a(r0);	 Catch:{ SyntaxException -> 0x008f }
        r0 = 9;
        r1 = r0;
        r0 = r10;
    L_0x0052:
        r4 = 6;
        if (r1 <= r4) goto L_0x0069;
    L_0x0055:
        r0 = r7.m2802a(r2, r1);	 Catch:{ SyntaxException -> 0x009a }
        r4 = r0.length();	 Catch:{ SyntaxException -> 0x009a }
        r5 = 15;
        if (r4 < r5) goto L_0x0069;
    L_0x0061:
        r4 = "Infinity";
        r4 = r4.equals(r0);	 Catch:{ SyntaxException -> 0x009a }
        if (r4 == 0) goto L_0x008c;
    L_0x0069:
        r1 = 45;
        r2 = 8722; // 0x2212 float:1.2222E-41 double:4.309E-320;
        r0 = r0.replace(r1, r2);
        r1 = "Infinity";
        r2 = "\u221e";
        r0 = r0.replace(r1, r2);
        if (r9 == 0) goto L_0x007f;
    L_0x007b:
        r0 = com.miui.calculator.common.utils.NumberFormatUtils.m2874a(r0);
    L_0x007f:
        r1 = "\u22120";
        r1 = android.text.TextUtils.equals(r1, r0);
        if (r1 == 0) goto L_0x0012;
    L_0x0087:
        r0 = java.lang.String.valueOf(r6);
        goto L_0x0012;
    L_0x008c:
        r1 = r1 + -1;
        goto L_0x0052;
    L_0x008f:
        r0 = move-exception;
        r1 = r0;
        r0 = r10;
    L_0x0092:
        r2 = "Calculator:Calculator";
        r3 = "SyntaxException";
        android.util.Log.e(r2, r3, r1);
        goto L_0x0069;
    L_0x009a:
        r1 = move-exception;
        goto L_0x0092;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.calculator.common.utils.Calculator.a(java.lang.String, boolean, java.lang.String):java.lang.String");
    }

    private String m2802a(double d, int i) {
        String trim = String.format(Locale.US, "%15." + i + "g", new Object[]{Double.valueOf(d)}).trim();
        if (trim.equals("NaN")) {
            return trim;
        }
        String substring;
        String str = null;
        int indexOf = trim.indexOf(101);
        if (indexOf != -1) {
            substring = trim.substring(0, indexOf);
            str = trim.substring(indexOf + 1);
            if (str.startsWith("+")) {
                str = str.substring(1);
            }
            str = String.valueOf(Integer.parseInt(str));
        } else {
            substring = trim;
        }
        int indexOf2 = substring.indexOf(46);
        if (indexOf2 == -1) {
            indexOf2 = substring.indexOf(44);
        }
        if (indexOf2 != -1) {
            while (substring.length() > 0 && substring.endsWith(String.valueOf('0'))) {
                substring = substring.substring(0, substring.length() - 1);
            }
            if (substring.length() == indexOf2 + 1) {
                trim = substring.substring(0, substring.length() - 1);
                if (str == null) {
                    return trim + 'e' + str;
                }
                return trim;
            }
        }
        trim = substring;
        if (str == null) {
            return trim;
        }
        return trim + 'e' + str;
    }

    public static boolean m2803a(char c) {
        return c == '+' || c == '\u2212' || c == '\u00d7' || c == '\u00f7' || c == '-' || c == '*' || c == '/' || c == '+';
    }

    public static boolean m2804b(char c) {
        return m2803a(c) || c == '!' || c == '^' || c == '\u221a';
    }

    public static boolean m2805b(String str) {
        return "ln".equals(str) || "lg".equals(str) || m2807c(str);
    }

    public static boolean m2807c(String str) {
        return "sin".equals(str) || "cos".equals(str) || "tan".equals(str);
    }

    public static boolean m2806c(char c) {
        return Character.isDigit(c) || c == '.' || c == '\u03c0' || c == 'e' || c == '!' || c == '^' || c == '\u221a';
    }

    public static boolean m2808d(String str) {
        int length = str.length();
        if (length < 2 || '\u00f7' != str.charAt(0) || str.charAt(1) != '0') {
            return false;
        }
        int indexOf = str.indexOf(46);
        if (indexOf == -1) {
            return true;
        }
        for (indexOf++; indexOf < length; indexOf++) {
            if (str.charAt(indexOf) != '0') {
                indexOf = 1;
                break;
            }
        }
        boolean z = false;
        if (indexOf == 0) {
            return true;
        }
        return false;
    }

    private boolean m2809e(String str) {
        return Pattern.compile("[0-9|e]{0,}\u03c0{1,}[0-9|e]{0,}").matcher(str).matches() && !str.equals("\u03c0");
    }
}
