package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.i;

public class u {
    public static final String DW;
    public static final String j6;

    static {
        j6 = String.valueOf(i.DW / 1000).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
        String str = "ma";
        String valueOf = String.valueOf(j6);
        DW = valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
    }
}
