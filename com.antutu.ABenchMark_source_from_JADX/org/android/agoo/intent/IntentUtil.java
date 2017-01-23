package org.android.agoo.intent;

import android.content.Context;
import android.content.Intent;
import com.taobao.accs.utl.ALog;

public final class IntentUtil {
    public static final String AGOO_COMMAND = "command";
    private static final String INTENT_FROM_AGOO_COMMAND = ".intent.action.COMMAND";
    private static final String INTENT_FROM_STARTACTIVITY_COMMAND = ".intent.action.startActivity.COMMAND";
    private static final String INTENT_FROM_THIRDPUSH_COMMAND = ".intent.thirdPush.action.COMMAND";
    private static final String TAG = "IntentUtil";

    public static final Intent createActivityIntent(Context context, String str, Intent intent) {
        Intent intent2;
        Throwable th;
        try {
            intent2 = new Intent();
            try {
                intent2.setAction(context.getPackageName() + INTENT_FROM_STARTACTIVITY_COMMAND);
                intent2.setPackage(context.getPackageName());
                intent2.setClassName(context, "com.taobao.agoo.AgooStartActivityService");
                intent2.putExtra(AGOO_COMMAND, str);
                intent2.putExtras(intent.getExtras());
            } catch (Throwable th2) {
                th = th2;
                ALog.m16905w(TAG, "createComandIntent", th, new Object[0]);
                return intent2;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            intent2 = null;
            th = th4;
            ALog.m16905w(TAG, "createComandIntent", th, new Object[0]);
            return intent2;
        }
        return intent2;
    }

    public static final Intent createComandIntent(Context context, String str) {
        Intent intent;
        Throwable th;
        try {
            intent = new Intent();
            try {
                intent.setAction(context.getPackageName() + INTENT_FROM_AGOO_COMMAND);
                intent.setPackage(context.getPackageName());
                intent.putExtra(AGOO_COMMAND, str);
            } catch (Throwable th2) {
                th = th2;
                ALog.m16905w(TAG, "createComandIntent", th, new Object[0]);
                return intent;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            intent = null;
            th = th4;
            ALog.m16905w(TAG, "createComandIntent", th, new Object[0]);
            return intent;
        }
        return intent;
    }

    public static final Intent createThirdpushComandIntent(Context context, String str) {
        Intent intent;
        Throwable th;
        try {
            intent = new Intent();
            try {
                intent.setAction(getThirdPushCommand(context));
                intent.setPackage(context.getPackageName());
                intent.putExtra(AGOO_COMMAND, str);
            } catch (Throwable th2) {
                th = th2;
                ALog.m16905w(TAG, "createComandIntent", th, new Object[0]);
                return intent;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            intent = null;
            th = th4;
            ALog.m16905w(TAG, "createComandIntent", th, new Object[0]);
            return intent;
        }
        return intent;
    }

    public static final String getAgooCommand(Context context) {
        if (context != null) {
            try {
                return context.getPackageName() + INTENT_FROM_AGOO_COMMAND;
            } catch (Throwable th) {
                ALog.m16905w(TAG, "getAgooCommand", th, new Object[0]);
            }
        }
        return null;
    }

    public static final String getThirdPushCommand(Context context) {
        if (context != null) {
            try {
                return context.getPackageName() + INTENT_FROM_THIRDPUSH_COMMAND;
            } catch (Throwable th) {
                ALog.m16905w(TAG, "getAgooCommand", th, new Object[0]);
            }
        }
        return null;
    }
}
