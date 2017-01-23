package com.miui.support.internal.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassTransformer {
    private static final Pattern f2545a;
    private static final Pattern f2546b;

    static {
        f2545a = Pattern.compile("^miui\\.*");
        f2546b = Pattern.compile("^com.miui.internal\\.*");
    }

    private ClassTransformer() {
    }

    public static String m4218a(String str) {
        Matcher matcher = f2545a.matcher(str);
        if (matcher.find()) {
            return matcher.replaceFirst("com.miui.support.");
        }
        matcher = f2546b.matcher(str);
        if (matcher.find()) {
            return matcher.replaceFirst("com.miui.support.internal.");
        }
        return str;
    }
}
