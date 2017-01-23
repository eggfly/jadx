package com.antutu.utils;

import java.text.DecimalFormat;

public class StringUtil {
    public static String formatTempToC(double d) {
        return new DecimalFormat("#.#").format(d) + "\u2103";
    }

    public static String formatTempToCAndF(double d) {
        return formatTempToC(d) + "/" + formatTempToF(d);
    }

    public static String formatTempToF(double d) {
        return new DecimalFormat("#.#").format(32.0d + (1.8d * d)) + "\u2109";
    }
}
