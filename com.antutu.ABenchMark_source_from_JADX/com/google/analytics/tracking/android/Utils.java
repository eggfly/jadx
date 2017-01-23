package com.google.analytics.tracking.android;

import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

class Utils {
    private static final char[] HEXBYTES;

    static {
        HEXBYTES = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    Utils() {
    }

    public static String filterCampaign(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.contains("?")) {
            str = str.split("[\\?]")[1];
        }
        if (str.contains("%3D")) {
            try {
                str = URLDecoder.decode(str, HttpRequest.f14548a);
            } catch (UnsupportedEncodingException e) {
                return null;
            }
        } else if (!str.contains("=")) {
            return null;
        }
        Map parseURLParameters = parseURLParameters(str);
        String[] strArr = new String[]{ModelFields.DCLID, "utm_source", ModelFields.GCLID, "utm_campaign", "utm_medium", "utm_term", "utm_content", "utm_id", ModelFields.GMOB_T};
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            if (!TextUtils.isEmpty((CharSequence) parseURLParameters.get(strArr[i]))) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append("&");
                }
                stringBuilder.append(strArr[i]).append("=").append((String) parseURLParameters.get(strArr[i]));
            }
        }
        return stringBuilder.toString();
    }

    static int fromHexDigit(char c) {
        int i = c - 48;
        return i > 9 ? i - 7 : i;
    }

    static String getLanguage(Locale locale) {
        if (locale == null || TextUtils.isEmpty(locale.getLanguage())) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(locale.getLanguage().toLowerCase());
        if (!TextUtils.isEmpty(locale.getCountry())) {
            stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(locale.getCountry().toLowerCase());
        }
        return stringBuilder.toString();
    }

    static String getSlottedModelField(String str, int i) {
        return str + "*" + i;
    }

    static byte[] hexDecode(String str) {
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) ((fromHexDigit(str.charAt(i * 2)) << 4) | fromHexDigit(str.charAt((i * 2) + 1)));
        }
        return bArr;
    }

    static String hexEncode(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & MotionEventCompat.ACTION_MASK;
            cArr[i * 2] = HEXBYTES[i2 >> 4];
            cArr[(i * 2) + 1] = HEXBYTES[i2 & 15];
        }
        return new String(cArr);
    }

    public static Map<String, String> parseURLParameters(String str) {
        Map<String, String> hashMap = new HashMap();
        for (String split : str.split("&")) {
            String[] split2 = split.split("=");
            if (split2.length > 1) {
                hashMap.put(split2[0], split2[1]);
            } else if (split2.length == 1 && split2[0].length() != 0) {
                hashMap.put(split2[0], null);
            }
        }
        return hashMap;
    }

    public static boolean safeParseBoolean(String str) {
        return Boolean.parseBoolean(str);
    }

    public static double safeParseDouble(String str) {
        double d = 0.0d;
        if (str != null) {
            try {
                d = Double.parseDouble(str);
            } catch (NumberFormatException e) {
            }
        }
        return d;
    }

    public static long safeParseLong(String str) {
        long j = 0;
        if (str != null) {
            try {
                j = Long.parseLong(str);
            } catch (NumberFormatException e) {
            }
        }
        return j;
    }
}
