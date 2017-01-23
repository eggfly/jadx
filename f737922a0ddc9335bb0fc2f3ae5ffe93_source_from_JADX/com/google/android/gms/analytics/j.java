package com.google.android.gms.analytics;

import com.google.android.gms.analytics.internal.f;

public final class j {
    public static String DW(int i) {
        return j6("cd", i);
    }

    public static String FH(int i) {
        return j6("cm", i);
    }

    public static String Hw(int i) {
        return j6("&pr", i);
    }

    public static String VH(int i) {
        return j6("promo", i);
    }

    public static String Zo(int i) {
        return j6("&promo", i);
    }

    public static String gn(int i) {
        return j6("pi", i);
    }

    public static String j6(int i) {
        return j6("&cd", i);
    }

    private static String j6(String str, int i) {
        if (i >= 1) {
            return new StringBuilder(String.valueOf(str).length() + 11).append(str).append(i).toString();
        }
        f.j6("index out of range for prefix", str);
        return "";
    }

    public static String tp(int i) {
        return j6("il", i);
    }

    public static String u7(int i) {
        return j6("&il", i);
    }

    public static String v5(int i) {
        return j6("pr", i);
    }
}
