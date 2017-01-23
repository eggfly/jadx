package org.android.agoo.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import com.umeng.analytics.C4156a;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: org.android.agoo.common.b */
public class C4575b {
    public static final String AGOO_CLEAR_TIME = "agoo_clear_time";
    public static final String AGOO_ENABLE_DAEMONSERVER = "agoo_enable_daemonserver";
    public static final String AGOO_UNREPORT_TIMES = "agoo_UnReport_times";
    public static final String KEY_DEVICE_TOKEN = "deviceId";
    public static final String PREFERENCES = "Agoo_AppStore";
    public static final String PROPERTY_AGOO_SERVICE_MODE = "agoo_service_mode";
    public static final String PROPERTY_APP_KEY = "app_key";
    public static final String PROPERTY_APP_VERSION = "app_version";
    public static final String PROPERTY_DEVICE_TOKEN = "app_device_token";
    public static final String PROPERTY_PUSH_USER_TOKEN = "app_push_user_token";
    public static final String PROPERTY_TT_ID = "app_tt_id";
    public static final String TAG = "Config";
    private static String f16399a;

    static {
        f16399a = null;
    }

    public static void m19239a(Context context, int i) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCES, 4);
            Editor edit = sharedPreferences.edit();
            edit.putInt(AGOO_UNREPORT_TIMES, sharedPreferences.getInt(AGOO_UNREPORT_TIMES, 0) + i);
            edit.apply();
        } catch (Throwable th) {
        }
    }

    public static void m19240a(Context context, long j) {
        try {
            Editor edit = context.getSharedPreferences(PREFERENCES, 4).edit();
            edit.putLong(AGOO_CLEAR_TIME, j);
            edit.apply();
        } catch (Throwable th) {
        }
    }

    public static void m19241a(Context context, String str) {
        ALog.m16904i(TAG, "setDeviceToken", Constants.EXTRA_KEY_TOKEN, str);
        if (!TextUtils.isEmpty(str)) {
            f16399a = str;
            try {
                Editor edit = context.getSharedPreferences(PREFERENCES, 4).edit();
                edit.putString(KEY_DEVICE_TOKEN, str);
                edit.apply();
            } catch (Throwable th) {
                ALog.m16902e(TAG, "setDeviceToken", th, new Object[0]);
            }
        }
    }

    public static void m19242a(Context context, String str, String str2) {
        try {
            Editor edit = context.getSharedPreferences(PREFERENCES, 4).edit();
            if (!TextUtils.isEmpty(str)) {
                edit.putString(PROPERTY_APP_KEY, str);
            }
            if (!TextUtils.isEmpty(str2)) {
                edit.putString(PROPERTY_TT_ID, str2);
            }
            edit.apply();
        } catch (Throwable th) {
        }
    }

    public static void m19243a(Context context, boolean z) {
        try {
            Editor edit = context.getSharedPreferences(PREFERENCES, 4).edit();
            edit.putBoolean(AGOO_ENABLE_DAEMONSERVER, z);
            edit.apply();
        } catch (Throwable th) {
        }
    }

    public static boolean m19244a(Context context) {
        try {
            return context.getSharedPreferences(PREFERENCES, 4).getInt(AGOO_UNREPORT_TIMES, 0) > 0;
        } catch (Throwable th) {
            return false;
        }
    }

    public static void m19245b(Context context) {
        try {
            Editor edit = context.getSharedPreferences(PREFERENCES, 4).edit();
            edit.putInt(AGOO_UNREPORT_TIMES, 0);
            edit.apply();
        } catch (Throwable th) {
        }
    }

    public static void m19246b(Context context, String str) {
        try {
            Editor edit = context.getSharedPreferences(PREFERENCES, 4).edit();
            if (!TextUtils.isEmpty(str)) {
                edit.putString(PROPERTY_PUSH_USER_TOKEN, str);
            }
            edit.apply();
        } catch (Throwable th) {
        }
    }

    public static boolean m19247b(Context context, long j) {
        try {
            long j2 = context.getSharedPreferences(PREFERENCES, 4).getLong(AGOO_CLEAR_TIME, 0);
            ALog.m16901d("isClearTime", "now=" + j + ",now - lastTime=" + (j - j2) + ",istrue=" + (j - j2 > C4156a.f13948j), new Object[0]);
            return j != 0 && j - j2 > C4156a.f13948j;
        } catch (Throwable th) {
            return false;
        }
    }

    public static int m19248c(Context context) {
        int i = 0;
        try {
            i = context.getSharedPreferences(PREFERENCES, 4).getInt(AGOO_UNREPORT_TIMES, 0);
        } catch (Throwable th) {
        }
        return i;
    }

    public static boolean m19249d(Context context) {
        boolean z = false;
        try {
            z = context.getSharedPreferences(PREFERENCES, 4).getBoolean(AGOO_ENABLE_DAEMONSERVER, true);
        } catch (Throwable th) {
        }
        return z;
    }

    public static String m19250e(Context context) {
        String str = f16399a;
        try {
            str = context.getSharedPreferences(PREFERENCES, 4).getString(KEY_DEVICE_TOKEN, f16399a);
        } catch (Throwable th) {
            ALog.m16902e(TAG, "getDeviceToken", th, new Object[0]);
        }
        ALog.m16904i(TAG, "getDeviceToken", Constants.EXTRA_KEY_TOKEN, str);
        return str;
    }

    public static String m19251f(Context context) {
        String str = null;
        try {
            str = context.getSharedPreferences(PREFERENCES, 4).getString(PROPERTY_PUSH_USER_TOKEN, BuildConfig.FLAVOR);
        } catch (Throwable th) {
        }
        return str;
    }
}
