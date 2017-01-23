package com.taobao.accs.utl;

import android.text.TextUtils;
import android.util.Log;
import com.taobao.tlog.adapter.AdapterForTLog;
import com.xiaomi.pushsdk.BuildConfig;

public class ALog {
    private static Object LOG_BREAK;
    private static boolean isPrintLog;
    private static boolean isUseTlog;
    private static String preTag;

    public enum Level {
        V,
        D,
        I,
        W,
        E,
        L
    }

    static {
        preTag = "accs.";
        LOG_BREAK = "|";
        isPrintLog = true;
        isUseTlog = true;
    }

    static String buildLogMsg(String str, String str2, Object... objArr) {
        int i = 0;
        if (str == null && str2 == null && objArr == null) {
            return BuildConfig.FLAVOR;
        }
        StringBuilder stringBuilder = new StringBuilder();
        try {
            if (!TextUtils.isEmpty(str2)) {
                stringBuilder.append(LOG_BREAK).append(String.format("[seq:%s]", new Object[]{str2}));
            }
            if (str != null) {
                stringBuilder.append(" ").append(str);
            }
            if (objArr != null) {
                while (i + 1 < objArr.length) {
                    stringBuilder.append(" ");
                    Object obj = objArr[i];
                    i++;
                    stringBuilder.append(formatKv(obj, objArr[i]));
                    i++;
                }
                if (i > 0 && i == objArr.length - 1) {
                    stringBuilder.append(" ");
                    stringBuilder.append(objArr[i]);
                }
            }
            return stringBuilder.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return BuildConfig.FLAVOR;
        }
    }

    private static String buildLogTag() {
        return preTag;
    }

    private static String buildLogTag(String str) {
        return preTag + str;
    }

    public static void m16901d(String str, String str2, Object... objArr) {
        d1(str, str2, null, objArr);
    }

    public static void d1(String str, String str2, String str3, Object... objArr) {
        if (!isPrintLog(Level.D)) {
            return;
        }
        if (isUseTlog) {
            AdapterForTLog.logd(buildLogTag(str), buildLogMsg(str2, str3, objArr));
        } else {
            Log.d(buildLogTag(str), buildLogMsg(str2, str3, objArr));
        }
    }

    public static void m16902e(String str, String str2, Throwable th, Object... objArr) {
        e1(str, str2, null, th, objArr);
    }

    public static void m16903e(String str, String str2, Object... objArr) {
        e1(str, str2, null, objArr);
    }

    public static void e1(String str, String str2, String str3, Throwable th, Object... objArr) {
        if (!isPrintLog(Level.E)) {
            return;
        }
        if (isUseTlog) {
            AdapterForTLog.loge(buildLogTag(str), buildLogMsg(str2, str3, objArr), th);
        } else {
            Log.e(buildLogTag(str), buildLogMsg(str2, str3, objArr), th);
        }
    }

    public static void e1(String str, String str2, String str3, Object... objArr) {
        if (!isPrintLog(Level.E)) {
            return;
        }
        if (isUseTlog) {
            AdapterForTLog.loge(buildLogTag(str), buildLogMsg(str2, str3, objArr));
        } else {
            Log.e(buildLogTag(str), buildLogMsg(str2, str3, objArr));
        }
    }

    private static String formatKv(Object obj, Object obj2) {
        StringBuilder stringBuilder = new StringBuilder();
        if (obj == null) {
            obj = BuildConfig.FLAVOR;
        }
        stringBuilder = stringBuilder.append(obj).append(":");
        if (obj2 == null) {
            obj2 = BuildConfig.FLAVOR;
        }
        return stringBuilder.append(obj2).toString();
    }

    public static void m16904i(String str, String str2, Object... objArr) {
        i1(str, str2, null, objArr);
    }

    public static void i1(String str, String str2, String str3, Object... objArr) {
        if (!isPrintLog(Level.I)) {
            return;
        }
        if (isUseTlog) {
            AdapterForTLog.logi(buildLogTag(str), buildLogMsg(str2, str3, objArr));
        } else {
            Log.i(buildLogTag(str), buildLogMsg(str2, str3, objArr));
        }
    }

    public static void initALog(String str, int i) {
        preTag = str;
    }

    @Deprecated
    public static boolean isPrintLog() {
        return false;
    }

    public static boolean isPrintLog(Level level) {
        if (!isPrintLog) {
            return false;
        }
        if (!isUseTlog) {
            return true;
        }
        Level level2 = Level.L;
        try {
            level2 = Level.valueOf(AdapterForTLog.getLogLevel());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return level.ordinal() >= level2.ordinal();
    }

    @Deprecated
    public static void setEnableTLog(boolean z) {
        isUseTlog = z;
    }

    public static void setPrintLog(boolean z) {
        isPrintLog = z;
    }

    public static void setUseTlog(boolean z) {
        isUseTlog = z;
    }

    public static void m16905w(String str, String str2, Throwable th, Object... objArr) {
        w1(str, str2, null, th, objArr);
    }

    public static void m16906w(String str, String str2, Object... objArr) {
        m16905w(str, str2, null, objArr);
    }

    public static void w1(String str, String str2, String str3, Throwable th, Object... objArr) {
        if (!isPrintLog(Level.W)) {
            return;
        }
        if (isUseTlog) {
            AdapterForTLog.logw(buildLogTag(str), buildLogMsg(str2, str3, objArr), th);
        } else {
            Log.w(buildLogTag(str), buildLogMsg(str2, str3, objArr), th);
        }
    }

    public static void w1(String str, String str2, String str3, Object... objArr) {
        if (!isPrintLog(Level.W)) {
            return;
        }
        if (isUseTlog) {
            AdapterForTLog.logw(buildLogTag(str), buildLogMsg(str2, str3, objArr));
        } else {
            Log.w(buildLogTag(str), buildLogMsg(str2, str3, objArr));
        }
    }
}
