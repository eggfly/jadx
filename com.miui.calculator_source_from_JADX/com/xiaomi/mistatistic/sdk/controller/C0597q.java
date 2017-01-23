package com.xiaomi.mistatistic.sdk.controller;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Enumeration;

/* renamed from: com.xiaomi.mistatistic.sdk.controller.q */
public class C0597q {
    public static byte[] m6528a(String str) {
        if (str == null) {
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            return str.getBytes();
        }
    }

    public static String m6531b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(C0597q.m6528a(str));
            BigInteger bigInteger = new BigInteger(1, instance.digest());
            return String.format("%1$032X", new Object[]{bigInteger});
        } catch (NoSuchAlgorithmException e) {
            return str;
        }
    }

    public static String m6533c(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA1");
            instance.update(C0597q.m6528a(str));
            BigInteger bigInteger = new BigInteger(1, instance.digest());
            return String.format("%1$032X", new Object[]{bigInteger});
        } catch (NoSuchAlgorithmException e) {
            return str;
        }
    }

    public static boolean m6527a(Context context) {
        boolean z;
        Throwable th;
        try {
            z = false;
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                try {
                    if (runningAppProcessInfo.importance == 100 || runningAppProcessInfo.importance == 125) {
                        for (String equals : runningAppProcessInfo.pkgList) {
                            if (equals.equals(context.getPackageName())) {
                                C0566h.m6420b("U", "importance " + runningAppProcessInfo.importance);
                                z = true;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            C0566h.m6422b("U", "%s foreground running %s", context.getPackageName(), Boolean.valueOf(z));
        } catch (Throwable th3) {
            th = th3;
            z = false;
            C0566h.m6418a("isForegroundRunning exception ", th);
            return z;
        }
        return z;
    }

    public static boolean m6525a(long j) {
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        long timeInMillis = instance.getTimeInMillis();
        long j2 = 86400000 + timeInMillis;
        if (timeInMillis > j || j >= j2) {
            return false;
        }
        return true;
    }

    public static boolean m6526a(long j, long j2) {
        return Math.abs(System.currentTimeMillis() - j) > j2;
    }

    private static String m6529b() {
        String str = "";
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = (NetworkInterface) networkInterfaces.nextElement();
                byte[] hardwareAddress = networkInterface.getHardwareAddress();
                if (!(hardwareAddress == null || hardwareAddress.length == 0)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i = 0; i < length; i++) {
                        stringBuilder.append(String.format("%02x:", new Object[]{Byte.valueOf(hardwareAddress[i])}));
                    }
                    if (stringBuilder.length() > 0) {
                        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                    }
                    String stringBuilder2 = stringBuilder.toString();
                    if ("wlan0".equals(networkInterface.getName())) {
                        return stringBuilder2;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String m6530b(Context context) {
        String b;
        String str = "";
        if (VERSION.SDK_INT >= 23) {
            b = C0597q.m6529b();
        } else {
            b = str;
        }
        if (TextUtils.isEmpty(b)) {
            try {
                b = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(b)) {
            return b;
        }
        return C0597q.m6531b(b);
    }

    public static String m6532c(Context context) {
        String str = null;
        try {
            str = Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable th) {
            C0566h.m6416a("U", "getAndroidId exception: ", th);
        }
        return str;
    }

    public static String m6524a() {
        if (VERSION.SDK_INT > 8) {
            return Build.SERIAL;
        }
        return null;
    }

    public static boolean m6534d(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 0);
            return true;
        } catch (Throwable e) {
            C0566h.m6421b("U", "cannot get pkginfo com.xiaomi.xmsf, not miui.", e);
            return false;
        }
    }

    public static boolean m6535e(Context context) {
        String packageName = context.getPackageName();
        if (packageName.contains("miui") || packageName.contains("xiaomi")) {
            return true;
        }
        boolean z;
        if ((context.getApplicationInfo().flags & 1) != 0) {
            z = true;
        } else {
            z = false;
        }
        C0566h.m6422b("U", "the pkg %s is sys app %s", packageName, Boolean.valueOf(z));
        return z;
    }

    public static String m6536f(Context context) {
        if (!C0597q.m6534d(context)) {
            return null;
        }
        String str = "com.miui.support.telephony.TelephonyManager";
        try {
            Class cls = Class.forName("com.miui.support.telephony.TelephonyManager");
            Method declaredMethod = cls.getDeclaredMethod("getDefault", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (invoke != null) {
                Method declaredMethod2 = cls.getDeclaredMethod("getMiuiDeviceId", new Class[0]);
                declaredMethod2.setAccessible(true);
                Object invoke2 = declaredMethod2.invoke(invoke, new Object[0]);
                if (invoke2 != null && (invoke2 instanceof String)) {
                    str = (String) String.class.cast(invoke2);
                    return str;
                }
            }
            str = null;
            return str;
        } catch (Throwable e) {
            C0566h.m6418a("getMiuiImei exception: ", e);
            return null;
        }
    }
}
