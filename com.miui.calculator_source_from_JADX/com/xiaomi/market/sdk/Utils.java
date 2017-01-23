package com.xiaomi.market.sdk;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.util.Log;
import java.io.File;

public class Utils {
    static boolean f4609a;
    static boolean f4610b;

    static {
        f4609a = new File("/sdcard/com.xiaomi.market.sdk/sdk_debug").exists();
        f4610b = new File("/sdcard/com.xiaomi.market.sdk/sdk_staging").exists();
    }

    static boolean m6201a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            int applicationEnabledSetting = context.getPackageManager().getApplicationEnabledSetting("com.xiaomi.market");
            if (applicationEnabledSetting == 0 || applicationEnabledSetting == 1) {
                return true;
            }
            return false;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    static boolean m6200a() {
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            return ((String) cls.getDeclaredMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{"ro.build.characteristics"})).contains("tablet");
        } catch (Throwable e) {
            Log.e("MarketSdkUtils", e.getMessage(), e);
            return false;
        }
    }

    public static String m6199a(long j, Context context) {
        if (context == null) {
            return "";
        }
        if (j < 0) {
            return "";
        }
        String format;
        int a;
        if (j > 1000000) {
            format = String.format("%.1f", new Object[]{Double.valueOf((((double) j) * 1.0d) / 1000000.0d)});
            a = m6198a(context.getPackageName(), "string", "xiaomi_megabytes_unit");
        } else if (j > 1000) {
            format = String.format("%.1f", new Object[]{Double.valueOf((((double) j) * 1.0d) / 1000.0d)});
            a = m6198a(context.getPackageName(), "string", "xiaomi_kilobytes_unit");
        } else {
            format = String.valueOf(j);
            a = m6198a(context.getPackageName(), "string", "xiaomi_bytes_unit");
        }
        return context.getString(a, new Object[]{format});
    }

    static boolean m6203b(Context context) {
        if (context == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        boolean z = activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
        return z;
    }

    static boolean m6204c(Context context) {
        if (context == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        boolean z = activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
        return z;
    }

    static boolean m6202a(boolean z) {
        String externalStorageState = Environment.getExternalStorageState();
        if ("mounted".equals(externalStorageState)) {
            return true;
        }
        if (!"mounted_ro".equals(externalStorageState) || z) {
            return false;
        }
        return true;
    }

    static int m6198a(String str, String str2, String str3) {
        int i = 0;
        try {
            Class[] classes = Class.forName(str + ".R").getClasses();
            Class cls = null;
            for (int i2 = 0; i2 < classes.length; i2++) {
                if (classes[i2].getName().split("\\$")[1].equals(str2)) {
                    cls = classes[i2];
                    break;
                }
            }
            if (cls == null) {
                if (f4609a) {
                    Log.d("MarketSdkUtils", "[get resource id] : return id from R$class");
                }
                cls = Class.forName(str + ".R$" + str2);
            }
            if (cls != null) {
                i = cls.getField(str3).getInt(cls);
            }
        } catch (Exception e) {
            Log.e("MarketSdkUtils", "[get resource id] : id = " + 0 + "\nerror: " + e.toString());
        }
        if (f4609a) {
            Log.d("MarketSdkUtils", "[get resource id] : id = " + i);
        }
        return i;
    }
}
