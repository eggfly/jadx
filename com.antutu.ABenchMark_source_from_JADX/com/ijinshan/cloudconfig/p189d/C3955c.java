package com.ijinshan.cloudconfig.p189d;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import anet.channel.security.ISecurity;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.BufferedReader;
import java.io.FileReader;
import java.security.MessageDigest;
import java.util.Locale;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.ijinshan.cloudconfig.d.c */
public class C3955c {
    private static String f13265a;
    private static Object f13266b;

    static {
        f13265a = BuildConfig.FLAVOR;
        f13266b = new Object();
    }

    public static int m16259a(long j) {
        return Math.round(((float) j) / 1048576.0f);
    }

    public static long m16260a() {
        long j = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), SpdyProtocol.SLIGHTSSL_1_RTT_MODE);
            String[] split = bufferedReader.readLine().split("\\s+");
            if (split.length == 3) {
                j = (long) (Integer.valueOf(split[1]).intValue() * IXAdIOUtils.BUFFER_SIZE);
            }
            bufferedReader.close();
        } catch (Exception e) {
        }
        return j;
    }

    public static String m16261a(Context context) {
        Locale locale = null;
        Resources resources = context.getResources();
        if (resources != null) {
            Configuration configuration = resources.getConfiguration();
            if (configuration != null) {
                locale = configuration.locale;
            }
            if (locale == null) {
                locale = Locale.getDefault();
            }
        } else {
            locale = Locale.getDefault();
        }
        return locale.getLanguage();
    }

    public static String m16262a(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(ISecurity.SIGN_ALGORITHM_MD5);
            instance.update(str.getBytes());
            return C3955c.m16263a(instance.digest());
        } catch (Exception e) {
            return null;
        }
    }

    public static String m16263a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        String str = "0123456789abcdef";
        int length = bArr.length;
        StringBuilder stringBuilder = new StringBuilder(length * 2);
        for (int i = 0; i < length; i++) {
            stringBuilder.append("0123456789abcdef".charAt((bArr[i] & 240) >>> 4));
            stringBuilder.append("0123456789abcdef".charAt(bArr[i] & 15));
        }
        return stringBuilder.toString();
    }

    public static String m16264b(Context context) {
        Locale locale = null;
        Resources resources = context.getResources();
        if (resources != null) {
            Configuration configuration = resources.getConfiguration();
            if (configuration != null) {
                locale = configuration.locale;
            }
            if (locale == null) {
                locale = Locale.getDefault();
            }
        } else {
            locale = Locale.getDefault();
        }
        return locale.getCountry();
    }

    public static String m16265c(Context context) {
        if (context == null) {
            return BuildConfig.FLAVOR;
        }
        CharSequence simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
        if (simOperator == null || simOperator.length() < 3) {
            return BuildConfig.FLAVOR;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(simOperator, 0, 3);
        return stringBuilder.toString();
    }

    public static String m16266d(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return new StringBuilder(String.valueOf(String.valueOf(displayMetrics.heightPixels))).append("*").append(String.valueOf(displayMetrics.widthPixels)).toString();
        } catch (Exception e) {
            return "Unknown";
        }
    }

    @SuppressLint({"NewApi"})
    public static long m16267e(Context context) {
        if (VERSION.SDK_INT < 16) {
            return C3955c.m16260a();
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        MemoryInfo memoryInfo = new MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    public static String m16268f(Context context) {
        return new ComponentName(context, context.getClass()).getPackageName();
    }

    public static String m16269g(Context context) {
        if (TextUtils.isEmpty(f13265a)) {
            synchronized (f13266b) {
                if (TextUtils.isEmpty(f13265a)) {
                    String str = BuildConfig.FLAVOR;
                    try {
                        Object string = System.getString(context.getContentResolver(), "android_id");
                        if (!TextUtils.isEmpty(string)) {
                            f13265a = string;
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
        return f13265a;
    }
}
