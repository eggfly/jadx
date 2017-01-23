package com.antutu.redacc.p067f;

import java.text.DecimalFormat;

/* renamed from: com.antutu.redacc.f.n */
public class C1757n {
    public static String m6764a(int i, boolean z) {
        return new DecimalFormat(z ? "00.0" : "#0.0").format((double) (0.1f * ((float) i)));
    }
}
