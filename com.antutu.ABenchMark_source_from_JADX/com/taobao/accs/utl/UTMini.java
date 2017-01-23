package com.taobao.accs.utl;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.p105c.p106a.p111c.C2101a;
import com.ut.mini.UTAnalytics;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.Map;
import java.util.Map.Entry;
import org.android.agoo.common.AgooConstants;

public final class UTMini implements UT {
    public static final int EVENTID_EXCPTION = 66003;
    public static final String PAGE_REQUEST_ERROR = "REQ_ERROR";
    private static final String TAG = "UTMini";
    private static UTMini instance;

    static {
        instance = new UTMini();
    }

    private String _convertStringAToKVSString(String... strArr) {
        int i = 0;
        if (strArr != null && strArr.length == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            while (i < strArr.length) {
                if (!TextUtils.isEmpty(strArr[i])) {
                    if (i2 != 0) {
                        stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    stringBuffer.append(strArr[i]);
                    i2 = 1;
                }
                i++;
            }
        }
        return stringBuffer.toString();
    }

    public static String convertObjectToString(Object obj) {
        return obj != null ? obj instanceof String ? ((String) obj).toString() : obj instanceof Integer ? BuildConfig.FLAVOR + ((Integer) obj).intValue() : obj instanceof Long ? BuildConfig.FLAVOR + ((Long) obj).longValue() : obj instanceof Double ? BuildConfig.FLAVOR + ((Double) obj).doubleValue() : obj instanceof Float ? BuildConfig.FLAVOR + ((Float) obj).floatValue() : obj instanceof Short ? BuildConfig.FLAVOR + ((Short) obj).shortValue() : obj instanceof Byte ? BuildConfig.FLAVOR + ((Byte) obj).byteValue() : obj instanceof Boolean ? ((Boolean) obj).toString() : obj instanceof Character ? ((Character) obj).toString() : obj.toString() : BuildConfig.FLAVOR;
    }

    public static String getCommitInfo(int i, String str, String str2, String str3, String str4) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("eventId=").append(i).append(";arg1=").append(str).append(";arg2=").append(str2).append(";arg3=").append(str3);
        if (str4 != null) {
            stringBuilder.append(";").append("args=").append(str4);
        }
        return stringBuilder.toString();
    }

    public static String getCommitInfo(int i, String str, String str2, String str3, Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("eventId=").append(i).append(";arg1=").append(str).append(";arg2=").append(str2).append(";arg3=").append(str3);
        if (map != null) {
            stringBuilder.append(";").append("args=").append(map.toString());
        }
        return stringBuilder.toString();
    }

    public static UTMini getInstance() {
        return instance;
    }

    private static String[] mapToArray(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return new String[0];
        }
        String[] strArr = new String[map.size()];
        int i = 0;
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if (str == null) {
                strArr[i] = BuildConfig.FLAVOR;
            } else {
                strArr[i] = str + "=" + str2;
            }
            i++;
        }
        return strArr;
    }

    public final void commitEvent(int i, String str, Object obj) {
        try {
            UTAnalytics.getInstance().getTracker(AgooConstants.MESSAGE_SOURCE_ACCS).send(new UTOriginalCustomHitBuilder(str, i, convertObjectToString(obj), null, null, null).build());
        } catch (Throwable th) {
            ALog.m16901d(TAG, "commitEvent fail " + th.toString(), new Object[0]);
        }
    }

    public final void commitEvent(int i, String str, Object obj, Object obj2) {
        try {
            UTAnalytics.getInstance().getTracker(AgooConstants.MESSAGE_SOURCE_ACCS).send(new UTOriginalCustomHitBuilder(str, i, convertObjectToString(obj), convertObjectToString(obj2), null, null).build());
        } catch (Throwable th) {
            ALog.m16901d(TAG, "commitEvent fail " + th.toString(), new Object[0]);
        }
    }

    public final void commitEvent(int i, String str, Object obj, Object obj2, Object obj3) {
        try {
            UTAnalytics.getInstance().getTracker(AgooConstants.MESSAGE_SOURCE_ACCS).send(new UTOriginalCustomHitBuilder(str, i, convertObjectToString(obj), convertObjectToString(obj2), convertObjectToString(obj3), null).build());
        } catch (Throwable th) {
            ALog.m16901d(TAG, "commitEvent fail " + th.toString(), new Object[0]);
        }
    }

    public final void commitEvent(int i, String str, Object obj, Object obj2, Object obj3, Map<String, String> map) {
        try {
            commitEvent(i, str, obj, obj2, obj3, mapToArray(map));
        } catch (Throwable th) {
            ALog.m16901d(TAG, "commitEvent fail " + th.toString(), new Object[0]);
        }
    }

    public final void commitEvent(int i, String str, Object obj, Object obj2, Object obj3, String... strArr) {
        try {
            UTOriginalCustomHitBuilder uTOriginalCustomHitBuilder = new UTOriginalCustomHitBuilder(str, i, convertObjectToString(obj), convertObjectToString(obj2), convertObjectToString(obj3), null);
            uTOriginalCustomHitBuilder.setProperty("_field_args", _convertStringAToKVSString(strArr));
            UTAnalytics.getInstance().getTracker(AgooConstants.MESSAGE_SOURCE_ACCS).send(uTOriginalCustomHitBuilder.build());
        } catch (Throwable th) {
            ALog.m16901d(TAG, "commitEvent fail " + th.toString(), new Object[0]);
        }
    }

    public final String getUtdId(Context context) {
        try {
            return C2101a.m7882a(context);
        } catch (Throwable th) {
            return null;
        }
    }

    public final void onCaughException(Throwable th) {
    }

    public final void start(Application application, String str, String str2, String str3) {
        try {
            UTAnalytics.getInstance().setAppApplicationInstance(application, new C4145i(this, str3, str));
            ALog.m16901d(TAG, "start success", new Object[0]);
        } catch (Throwable th) {
            ALog.m16902e(TAG, "start fail ", th, new Object[0]);
        }
    }

    public final void stop(Context context) {
    }
}
