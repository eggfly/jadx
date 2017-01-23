package anet.channel.util;

import android.text.TextUtils;
import android.util.Log;
import com.antutu.redacc.C1692R;
import com.taobao.tlog.adapter.AdapterForTLog;
import com.xiaomi.pushsdk.BuildConfig;

public class ALog {
    private static Object LOG_BREAK;
    private static boolean isPrintLog;
    private static boolean isUseTlog;

    /* renamed from: anet.channel.util.ALog.a */
    public static class C0735a {
        public static final int f2421D = 1;
        public static final int f2422E = 4;
        public static final int f2423I = 2;
        public static final int f2424L = 5;
        public static final int f2425V = 0;
        public static final int f2426W = 3;

        public static int m2959a(String str) {
            switch (str.charAt(f2425V)) {
                case C1692R.styleable.AppCompatTheme_searchViewStyle /*68*/:
                    return f2421D;
                case C1692R.styleable.AppCompatTheme_listPreferredItemHeight /*69*/:
                    return f2422E;
                case C1692R.styleable.AppCompatTheme_listPreferredItemPaddingRight /*73*/:
                    return f2423I;
                case C1692R.styleable.AppCompatTheme_colorControlActivated /*86*/:
                    return f2425V;
                case C1692R.styleable.AppCompatTheme_colorControlHighlight /*87*/:
                    return f2426W;
                default:
                    return f2424L;
            }
        }
    }

    static {
        LOG_BREAK = "|";
        isPrintLog = true;
        isUseTlog = true;
    }

    static String buildLogMsg(String str, String str2, Object... objArr) {
        if (str == null && str2 == null && objArr == null) {
            return BuildConfig.FLAVOR;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(str2)) {
            stringBuilder.append(LOG_BREAK).append("[seq:").append(str2).append("]");
        }
        if (str != null) {
            stringBuilder.append(" ").append(str);
        }
        if (objArr != null) {
            int i = 0;
            while (i + 1 < objArr.length) {
                stringBuilder.append(" ").append(objArr[i] != null ? objArr[i] : BuildConfig.FLAVOR).append(":").append(objArr[i + 1] != null ? objArr[i + 1] : BuildConfig.FLAVOR);
                i += 2;
            }
            if (i < objArr.length) {
                stringBuilder.append(" ");
                stringBuilder.append(objArr[i]);
            }
        }
        return stringBuilder.toString();
    }

    private static String buildLogTag(String str) {
        return str;
    }

    public static void m2960d(String str, String str2, String str3, Object... objArr) {
        if (!isPrintLog(1)) {
            return;
        }
        if (isUseTlog) {
            AdapterForTLog.logd(buildLogTag(str), buildLogMsg(str2, str3, objArr));
        } else {
            Log.d(buildLogTag(str), buildLogMsg(str2, str3, objArr));
        }
    }

    public static void m2961e(String str, String str2, String str3, Throwable th, Object... objArr) {
        if (!isPrintLog(4)) {
            return;
        }
        if (isUseTlog) {
            AdapterForTLog.loge(buildLogTag(str), buildLogMsg(str2, str3, objArr), th);
        } else {
            Log.e(buildLogTag(str), buildLogMsg(str2, str3, objArr), th);
        }
    }

    public static void m2962e(String str, String str2, String str3, Object... objArr) {
        if (!isPrintLog(4)) {
            return;
        }
        if (isUseTlog) {
            AdapterForTLog.loge(buildLogTag(str), buildLogMsg(str2, str3, objArr));
        } else {
            Log.e(buildLogTag(str), buildLogMsg(str2, str3, objArr));
        }
    }

    public static void m2963i(String str, String str2, String str3, Object... objArr) {
        if (!isPrintLog(2)) {
            return;
        }
        if (isUseTlog) {
            AdapterForTLog.logi(buildLogTag(str), buildLogMsg(str2, str3, objArr));
        } else {
            Log.i(buildLogTag(str), buildLogMsg(str2, str3, objArr));
        }
    }

    @Deprecated
    public static boolean isPrintLog() {
        return false;
    }

    public static boolean isPrintLog(int i) {
        return !isPrintLog ? false : !isUseTlog || i >= C0735a.m2959a(AdapterForTLog.getLogLevel());
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

    public static void m2964w(String str, String str2, String str3, Throwable th, Object... objArr) {
        if (!isPrintLog(3)) {
            return;
        }
        if (isUseTlog) {
            AdapterForTLog.logw(buildLogTag(str), buildLogMsg(str2, str3, objArr), th);
        } else {
            Log.w(buildLogTag(str), buildLogMsg(str2, str3, objArr), th);
        }
    }

    public static void m2965w(String str, String str2, String str3, Object... objArr) {
        if (!isPrintLog(3)) {
            return;
        }
        if (isUseTlog) {
            AdapterForTLog.logw(buildLogTag(str), buildLogMsg(str2, str3, objArr));
        } else {
            Log.w(buildLogTag(str), buildLogMsg(str2, str3, objArr));
        }
    }
}
