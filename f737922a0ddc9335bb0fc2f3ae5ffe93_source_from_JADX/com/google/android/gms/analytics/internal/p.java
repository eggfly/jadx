package com.google.android.gms.analytics.internal;

import afw;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.internal.fv;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class p {
    private static final char[] j6;

    static {
        j6 = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public static MessageDigest DW(String str) {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                if (instance != null) {
                    return instance;
                }
                i++;
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return null;
    }

    public static void DW(Map<String, String> map, String str, String str2) {
        if (str2 != null && TextUtils.isEmpty((CharSequence) map.get(str))) {
            map.put(str, str2);
        }
    }

    public static int FH(String str) {
        int i = 1;
        if (!TextUtils.isEmpty(str)) {
            i = 0;
            for (int length = str.length() - 1; length >= 0; length--) {
                char charAt = str.charAt(length);
                i = (((i << 6) & 268435455) + charAt) + (charAt << 14);
                int i2 = 266338304 & i;
                if (i2 != 0) {
                    i ^= i2 >> 21;
                }
            }
        }
        return i;
    }

    public static boolean Hw(String str) {
        return TextUtils.isEmpty(str) || !str.startsWith("http:");
    }

    public static double j6(String str, double d) {
        if (str != null) {
            try {
                d = Double.parseDouble(str);
            } catch (NumberFormatException e) {
            }
        }
        return d;
    }

    public static long j6(String str) {
        long j = 0;
        if (str != null) {
            try {
                j = Long.parseLong(str);
            } catch (NumberFormatException e) {
            }
        }
        return j;
    }

    public static fv j6(g gVar, String str) {
        b.j6((Object) gVar);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        try {
            String str2 = "?";
            String valueOf = String.valueOf(str);
            Map j6 = afw.j6(new URI(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2)), "UTF-8");
            fv fvVar = new fv();
            fvVar.v5((String) j6.get("utm_content"));
            fvVar.FH((String) j6.get("utm_medium"));
            fvVar.j6((String) j6.get("utm_campaign"));
            fvVar.DW((String) j6.get("utm_source"));
            fvVar.Hw((String) j6.get("utm_term"));
            fvVar.Zo((String) j6.get("utm_id"));
            fvVar.VH((String) j6.get("anid"));
            fvVar.gn((String) j6.get("gclid"));
            fvVar.u7((String) j6.get("dclid"));
            fvVar.tp((String) j6.get("aclid"));
            return fvVar;
        } catch (URISyntaxException e) {
            gVar.Hw("No valid campaign data found", e);
            return null;
        }
    }

    public static String j6(Locale locale) {
        if (locale == null) {
            return null;
        }
        Object language = locale.getLanguage();
        if (TextUtils.isEmpty(language)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(language.toLowerCase());
        if (!TextUtils.isEmpty(locale.getCountry())) {
            stringBuilder.append("-").append(locale.getCountry().toLowerCase());
        }
        return stringBuilder.toString();
    }

    public static String j6(boolean z) {
        return z ? "1" : "0";
    }

    public static void j6(Map<String, String> map, String str, String str2) {
        if (str2 != null && !map.containsKey(str)) {
            map.put(str, str2);
        }
    }

    public static void j6(Map<String, String> map, String str, Map<String, String> map2) {
        j6((Map) map, str, (String) map2.get(str));
    }

    public static void j6(Map<String, String> map, String str, boolean z) {
        if (!map.containsKey(str)) {
            map.put(str, z ? "1" : "0");
        }
    }

    public static boolean j6(double d, String str) {
        return d > 0.0d && d < 100.0d && ((double) (FH(str) % 10000)) >= 100.0d * d;
    }

    public static boolean j6(Context context, String str) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, str), 4);
            if (serviceInfo != null && serviceInfo.enabled) {
                return true;
            }
        } catch (NameNotFoundException e) {
        }
        return false;
    }

    public static boolean j6(Context context, String str, boolean z) {
        try {
            ActivityInfo receiverInfo = context.getPackageManager().getReceiverInfo(new ComponentName(context, str), 2);
            if (receiverInfo != null && receiverInfo.enabled && (!z || receiverInfo.exported)) {
                return true;
            }
        } catch (NameNotFoundException e) {
        }
        return false;
    }

    public static boolean j6(String str, boolean z) {
        return str != null ? (str.equalsIgnoreCase("true") || str.equalsIgnoreCase("yes") || str.equalsIgnoreCase("1")) ? true : (str.equalsIgnoreCase("false") || str.equalsIgnoreCase("no") || str.equalsIgnoreCase("0")) ? false : z : z;
    }
}
