package com.google.android.gms.p146b;

import com.xiaomi.mipush.sdk.Constants;

/* renamed from: com.google.android.gms.b.jd */
public final class jd {
    public static void m13532a(StringBuilder stringBuilder, double[] dArr) {
        int length = dArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            stringBuilder.append(Double.toString(dArr[i]));
        }
    }

    public static void m13533a(StringBuilder stringBuilder, float[] fArr) {
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            stringBuilder.append(Float.toString(fArr[i]));
        }
    }

    public static void m13534a(StringBuilder stringBuilder, int[] iArr) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            stringBuilder.append(Integer.toString(iArr[i]));
        }
    }

    public static void m13535a(StringBuilder stringBuilder, long[] jArr) {
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            stringBuilder.append(Long.toString(jArr[i]));
        }
    }

    public static <T> void m13536a(StringBuilder stringBuilder, T[] tArr) {
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            stringBuilder.append(tArr[i].toString());
        }
    }

    public static void m13537a(StringBuilder stringBuilder, String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            stringBuilder.append("\"").append(strArr[i]).append("\"");
        }
    }

    public static void m13538a(StringBuilder stringBuilder, boolean[] zArr) {
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            stringBuilder.append(Boolean.toString(zArr[i]));
        }
    }
}
