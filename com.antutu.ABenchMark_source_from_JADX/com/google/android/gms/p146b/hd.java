package com.google.android.gms.p146b;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.C2968s;
import com.xiaomi.mipush.sdk.Constants;
import java.math.BigInteger;
import java.util.Locale;

@gb
/* renamed from: com.google.android.gms.b.hd */
public final class hd {
    private static final Object f11265a;
    private static String f11266b;

    static {
        f11265a = new Object();
    }

    public static String m12977a() {
        String str;
        synchronized (f11265a) {
            str = f11266b;
        }
        return str;
    }

    public static String m12978a(Context context, String str, String str2) {
        String str3;
        synchronized (f11265a) {
            if (f11266b == null && !TextUtils.isEmpty(str)) {
                hd.m12979b(context, str, str2);
            }
            str3 = f11266b;
        }
        return str3;
    }

    private static void m12979b(Context context, String str, String str2) {
        try {
            ClassLoader classLoader = context.createPackageContext(str2, 3).getClassLoader();
            Class cls = Class.forName("com.google.ads.mediation.MediationAdapter", false, classLoader);
            BigInteger bigInteger = new BigInteger(new byte[1]);
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            BigInteger bigInteger2 = bigInteger;
            for (int i = 0; i < split.length; i++) {
                if (C2968s.m11525e().m13048a(classLoader, cls, split[i])) {
                    bigInteger2 = bigInteger2.setBit(i);
                }
            }
            f11266b = String.format(Locale.US, "%X", new Object[]{bigInteger2});
        } catch (Throwable th) {
            f11266b = NotificationCompatApi21.CATEGORY_ERROR;
        }
    }
}
