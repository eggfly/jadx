package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.umeng.message.MsgConstant;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.push.log.C4374e;
import com.xiaomi.push.log.C4375f;
import org.android.spdy.SpdyProtocol;

public class Logger {
    private static boolean sDisablePushLog;
    private static LoggerInterface sUserLogger;

    static {
        sDisablePushLog = false;
        sUserLogger = null;
    }

    public static void disablePushFileLog(Context context) {
        sDisablePushLog = true;
        setPushLog(context);
    }

    public static void enablePushFileLog(Context context) {
        sDisablePushLog = false;
        setPushLog(context);
    }

    private static boolean hasWritePermission(Context context) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), SpdyProtocol.SLIGHTSSL_0_RTT_MODE).requestedPermissions;
            if (strArr == null) {
                return false;
            }
            for (Object equals : strArr) {
                if (MsgConstant.PERMISSION_WRITE_EXTERNAL_STORAGE.equals(equals)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static void setLogger(Context context, LoggerInterface loggerInterface) {
        sUserLogger = loggerInterface;
        setPushLog(context);
    }

    private static void setPushLog(Context context) {
        Object obj = sUserLogger != null ? 1 : null;
        LoggerInterface c4375f = new C4375f(context);
        if (!sDisablePushLog && hasWritePermission(context) && obj != null) {
            C4302b.m17647a(new C4374e(sUserLogger, c4375f));
        } else if (!sDisablePushLog && hasWritePermission(context)) {
            C4302b.m17647a(c4375f);
        } else if (obj != null) {
            C4302b.m17647a(sUserLogger);
        } else {
            C4302b.m17647a(new C4374e(null, null));
        }
    }
}
