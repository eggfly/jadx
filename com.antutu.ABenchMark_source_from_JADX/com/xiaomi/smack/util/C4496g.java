package com.xiaomi.smack.util;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.string.C4326a;
import java.util.Random;

/* renamed from: com.xiaomi.smack.util.g */
public class C4496g {
    private static final char[] f15459a;
    private static final char[] f15460b;
    private static final char[] f15461c;
    private static final char[] f15462d;
    private static final char[] f15463e;
    private static Random f15464f;
    private static char[] f15465g;

    static {
        f15459a = "&quot;".toCharArray();
        f15460b = "&apos;".toCharArray();
        f15461c = "&amp;".toCharArray();
        f15462d = "&lt;".toCharArray();
        f15463e = "&gt;".toCharArray();
        f15464f = new Random();
        f15465g = "0123456789abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    }

    public static String m18646a(int i) {
        if (i < 1) {
            return null;
        }
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < cArr.length; i2++) {
            cArr[i2] = f15465g[f15464f.nextInt(71)];
        }
        return new String(cArr);
    }

    public static String m18647a(String str) {
        int i = 0;
        if (str == null) {
            return null;
        }
        char[] toCharArray = str.toCharArray();
        int length = toCharArray.length;
        StringBuilder stringBuilder = new StringBuilder((int) (((double) length) * 1.3d));
        int i2 = 0;
        while (i2 < length) {
            char c = toCharArray[i2];
            if (c <= '>') {
                if (c == '<') {
                    if (i2 > i) {
                        stringBuilder.append(toCharArray, i, i2 - i);
                    }
                    i = i2 + 1;
                    stringBuilder.append(f15462d);
                } else if (c == '>') {
                    if (i2 > i) {
                        stringBuilder.append(toCharArray, i, i2 - i);
                    }
                    i = i2 + 1;
                    stringBuilder.append(f15463e);
                } else if (c == '&') {
                    if (i2 > i) {
                        stringBuilder.append(toCharArray, i, i2 - i);
                    }
                    if (length <= i2 + 5 || toCharArray[i2 + 1] != '#' || !Character.isDigit(toCharArray[i2 + 2]) || !Character.isDigit(toCharArray[i2 + 3]) || !Character.isDigit(toCharArray[i2 + 4]) || toCharArray[i2 + 5] != ';') {
                        i = i2 + 1;
                        stringBuilder.append(f15461c);
                    }
                } else if (c == '\"') {
                    if (i2 > i) {
                        stringBuilder.append(toCharArray, i, i2 - i);
                    }
                    i = i2 + 1;
                    stringBuilder.append(f15459a);
                } else if (c == '\'') {
                    if (i2 > i) {
                        stringBuilder.append(toCharArray, i, i2 - i);
                    }
                    i = i2 + 1;
                    stringBuilder.append(f15460b);
                }
            }
            i2++;
        }
        if (i == 0) {
            return str;
        }
        if (i2 > i) {
            stringBuilder.append(toCharArray, i, i2 - i);
        }
        return stringBuilder.toString();
    }

    public static final String m18648a(String str, String str2, String str3) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(str2, 0);
        if (indexOf < 0) {
            return str;
        }
        char[] toCharArray = str.toCharArray();
        char[] toCharArray2 = str3.toCharArray();
        int length = str2.length();
        StringBuilder stringBuilder = new StringBuilder(toCharArray.length);
        stringBuilder.append(toCharArray, 0, indexOf).append(toCharArray2);
        indexOf += length;
        int i = indexOf;
        while (true) {
            i = str.indexOf(str2, i);
            if (i > 0) {
                stringBuilder.append(toCharArray, indexOf, i - indexOf).append(toCharArray2);
                indexOf = i + length;
                i = indexOf;
            } else {
                stringBuilder.append(toCharArray, indexOf, toCharArray.length - indexOf);
                return stringBuilder.toString();
            }
        }
    }

    public static String m18649a(byte[] bArr) {
        return String.valueOf(C4326a.m17734a(bArr));
    }

    public static boolean m18650a(char c) {
        return (c >= ' ' && c <= '\ud7ff') || ((c >= '\ue000' && c <= '\ufffd') || ((c >= '\u0000' && c <= '\uffff') || c == '\t' || c == '\n' || c == '\r'));
    }

    public static final String m18651b(String str) {
        return C4496g.m18648a(C4496g.m18648a(C4496g.m18648a(C4496g.m18648a(C4496g.m18648a(str, "&lt;", "<"), "&gt;", ">"), "&quot;", "\""), "&apos;", "'"), "&amp;", "&");
    }

    public static String m18652c(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (C4496g.m18650a(charAt)) {
                stringBuilder.append(charAt);
            }
        }
        return stringBuilder.toString();
    }
}
