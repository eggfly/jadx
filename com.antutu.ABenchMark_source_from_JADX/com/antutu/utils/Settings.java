package com.antutu.utils;

import android.content.SharedPreferences;
import com.antutu.benchmark.ABenchmarkApplication;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;

public class Settings {
    private static String ABENCHMARK_PREFERENCE = null;
    private static final String ACCOUNT_MODEL_JSON = "user_info_json";
    private static final String KEY_LOGIN_NAMES = "login_names";
    private static final String LOG_IN_LATEST_USER_NAME = "LogInLatestUserName";
    private static final String NOTIFY_JSON = "notify_json";
    private static SharedPreferences spinstance;

    static {
        ABENCHMARK_PREFERENCE = "abench_preference";
        spinstance = null;
    }

    public static String deleteLoginName(String str) {
        String replaceAll = getLoginNames().replaceAll(str + Constants.ACCEPT_TIME_SEPARATOR_SP, BuildConfig.FLAVOR);
        getSharedPreferences().edit().putString(KEY_LOGIN_NAMES, replaceAll).commit();
        return replaceAll;
    }

    public static String getAccountModelJson() {
        return getSharedPreferences().getString(ACCOUNT_MODEL_JSON, BuildConfig.FLAVOR);
    }

    public static String getLastNotifyJson() {
        return getSharedPreferences().getString(NOTIFY_JSON, BuildConfig.FLAVOR);
    }

    public static String getLatestUserName() {
        return getSharedPreferences().getString(LOG_IN_LATEST_USER_NAME, BuildConfig.FLAVOR);
    }

    public static String getLoginNames() {
        return getSharedPreferences().getString(KEY_LOGIN_NAMES, BuildConfig.FLAVOR);
    }

    public static String getRecentLoginName() {
        String loginNames = getLoginNames();
        if (loginNames != null && loginNames.length() > 0) {
            for (String loginNames2 : loginNames2.trim().split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                if (loginNames2.length() > 0) {
                    return loginNames2;
                }
            }
        }
        return BuildConfig.FLAVOR;
    }

    public static SharedPreferences getSharedPreferences() {
        if (spinstance == null) {
            spinstance = ABenchmarkApplication.getContext().getSharedPreferences(ABENCHMARK_PREFERENCE, 0);
        }
        return spinstance;
    }

    public static void saveLoginName(String str) {
        String loginNames = getLoginNames();
        ArrayList arrayList = new ArrayList();
        if (loginNames != null && loginNames.length() > 0) {
            for (String str2 : loginNames.trim().split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                if (!str2.equals(str) && str2.length() > 0) {
                    arrayList.add(str2);
                }
            }
        }
        arrayList.add(0, str);
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append((String) it.next()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        getSharedPreferences().edit().putString(KEY_LOGIN_NAMES, stringBuffer.toString()).commit();
    }

    public static void setAccountModelJson(String str) {
        getSharedPreferences().edit().putString(ACCOUNT_MODEL_JSON, str).commit();
    }

    public static void setLastNotifyJson(String str) {
        getSharedPreferences().edit().putString(NOTIFY_JSON, str).commit();
    }

    public static void setLastestUserName(String str) {
        getSharedPreferences().edit().putString(LOG_IN_LATEST_USER_NAME, str).commit();
    }
}
