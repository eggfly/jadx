package com.xiaomi.pushsdk;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.util.Log;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.mipush.sdk.Logger;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.List;

public class MiPushUtil {
    private static final String APP_ID = "2882303761517131325";
    private static final String APP_KEY = "5711713110325";
    public static final String TAG = "com.xiaomi.mipushsdk";

    /* renamed from: com.xiaomi.pushsdk.MiPushUtil.1 */
    static class C44581 implements LoggerInterface {
        C44581() {
        }

        public void log(String str) {
            Log.d(MiPushUtil.TAG, str);
        }

        public void log(String str, Throwable th) {
            Log.d(MiPushUtil.TAG, str, th);
        }

        public void setTag(String str) {
        }
    }

    public static void initMiPush(Context context, int i, String str) {
        if (shouldInit(context)) {
            MiPushClient.registerPush(context, APP_ID, APP_KEY);
        }
        Logger.setLogger(context, new C44581());
        setUserTag(context, i, str);
    }

    private static void setUserTag(Context context, int i, String str) {
        MiPushClient.subscribe(context, Build.BRAND, null);
        MiPushClient.subscribe(context, Build.MANUFACTURER, null);
        MiPushClient.subscribe(context, Build.MODEL, null);
        MiPushClient.subscribe(context, "Android " + VERSION.RELEASE, null);
        try {
            MiPushClient.subscribe(context, context.getResources().getConfiguration().locale.toString(), null);
        } catch (Exception e) {
        }
        MiPushClient.subscribe(context, String.valueOf(i), null);
        MiPushClient.subscribe(context, str, null);
    }

    private static boolean shouldInit(Context context) {
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        String packageName = context.getPackageName();
        int myPid = Process.myPid();
        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid && packageName.equals(runningAppProcessInfo.processName)) {
                return true;
            }
        }
        return false;
    }

    public static void unregisterMiPush(Context context) {
        MiPushClient.unregisterPush(context);
        Logger.disablePushFileLog(context);
    }
}
