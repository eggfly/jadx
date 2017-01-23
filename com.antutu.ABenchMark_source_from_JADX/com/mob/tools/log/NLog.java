package com.mob.tools.log;

import android.content.Context;
import android.util.Log;
import java.util.HashMap;

public abstract class NLog {
    private static HashMap<String, NLog> loggers;
    private static LogPrinter printer;

    /* renamed from: com.mob.tools.log.NLog.1 */
    static class C40151 extends NLog {
        final /* synthetic */ String val$sdkTag;

        C40151(String str) {
            this.val$sdkTag = str;
        }

        protected String getSDKTag() {
            return this.val$sdkTag;
        }
    }

    static {
        loggers = new HashMap();
        printer = new LogPrinter();
        MobUncaughtExceptionHandler.register();
    }

    public NLog() {
        loggers.put(getSDKTag(), this);
        if (loggers.size() == 1) {
            loggers.put("__FIRST__", this);
        }
    }

    protected static final NLog getInstanceForSDK(String str, boolean z) {
        NLog nLog = (NLog) loggers.get(str);
        if (nLog == null) {
            nLog = (NLog) loggers.get("__FIRST__");
        }
        return (nLog == null && z) ? new C40151(str) : nLog;
    }

    public static void setCollector(String str, LogCollector logCollector) {
        printer.setCollector(str, logCollector);
    }

    public static void setContext(Context context) {
        if (context != null) {
            printer.setContext(context);
            NativeErrorHandler.prepare(context);
        }
    }

    public final int crash(Throwable th) {
        return printer.println(getSDKTag(), 6, 1, Log.getStackTraceString(th));
    }

    public final int m4375d(Object obj, Object... objArr) {
        String obj2 = obj.toString();
        if (objArr.length > 0) {
            obj2 = String.format(obj2, objArr);
        }
        return printer.println(getSDKTag(), 3, 0, obj2);
    }

    public final int m4376d(Throwable th) {
        return printer.println(getSDKTag(), 3, 0, Log.getStackTraceString(th));
    }

    public final int m4377d(Throwable th, Object obj, Object... objArr) {
        String obj2 = obj.toString();
        StringBuilder stringBuilder = new StringBuilder();
        if (objArr.length > 0) {
            obj2 = String.format(obj2, objArr);
        }
        return printer.println(getSDKTag(), 3, 0, stringBuilder.append(obj2).append('\n').append(Log.getStackTraceString(th)).toString());
    }

    public final int m4378e(Object obj, Object... objArr) {
        String obj2 = obj.toString();
        if (objArr.length > 0) {
            obj2 = String.format(obj2, objArr);
        }
        return printer.println(getSDKTag(), 6, 0, obj2);
    }

    public final int m4379e(Throwable th) {
        return printer.println(getSDKTag(), 6, 0, Log.getStackTraceString(th));
    }

    public final int m4380e(Throwable th, Object obj, Object... objArr) {
        String obj2 = obj.toString();
        StringBuilder stringBuilder = new StringBuilder();
        if (objArr.length > 0) {
            obj2 = String.format(obj2, objArr);
        }
        return printer.println(getSDKTag(), 6, 0, stringBuilder.append(obj2).append('\n').append(Log.getStackTraceString(th)).toString());
    }

    protected abstract String getSDKTag();

    public final int m4381i(Object obj, Object... objArr) {
        String obj2 = obj.toString();
        if (objArr.length > 0) {
            obj2 = String.format(obj2, objArr);
        }
        return printer.println(getSDKTag(), 4, 0, obj2);
    }

    public final int m4382i(Throwable th) {
        return printer.println(getSDKTag(), 4, 0, Log.getStackTraceString(th));
    }

    public final int m4383i(Throwable th, Object obj, Object... objArr) {
        String obj2 = obj.toString();
        StringBuilder stringBuilder = new StringBuilder();
        if (objArr.length > 0) {
            obj2 = String.format(obj2, objArr);
        }
        return printer.println(getSDKTag(), 4, 0, stringBuilder.append(obj2).append('\n').append(Log.getStackTraceString(th)).toString());
    }

    public final void nativeCrashLog(String str) {
        printer.nativeCrashLog(getSDKTag(), str);
    }

    public final int m4384v(Object obj, Object... objArr) {
        String obj2 = obj.toString();
        if (objArr.length > 0) {
            obj2 = String.format(obj2, objArr);
        }
        return printer.println(getSDKTag(), 2, 0, obj2);
    }

    public final int m4385v(Throwable th) {
        return printer.println(getSDKTag(), 2, 0, Log.getStackTraceString(th));
    }

    public final int m4386v(Throwable th, Object obj, Object... objArr) {
        String obj2 = obj.toString();
        StringBuilder stringBuilder = new StringBuilder();
        if (objArr.length > 0) {
            obj2 = String.format(obj2, objArr);
        }
        return printer.println(getSDKTag(), 2, 0, stringBuilder.append(obj2).append('\n').append(Log.getStackTraceString(th)).toString());
    }

    public final int m4387w(Object obj, Object... objArr) {
        String obj2 = obj.toString();
        if (objArr.length > 0) {
            obj2 = String.format(obj2, objArr);
        }
        return printer.println(getSDKTag(), 5, 0, obj2);
    }

    public final int m4388w(Throwable th) {
        return printer.println(getSDKTag(), 5, 0, Log.getStackTraceString(th));
    }

    public final int m4389w(Throwable th, Object obj, Object... objArr) {
        String obj2 = obj.toString();
        StringBuilder stringBuilder = new StringBuilder();
        if (objArr.length > 0) {
            obj2 = String.format(obj2, objArr);
        }
        return printer.println(getSDKTag(), 5, 0, stringBuilder.append(obj2).append('\n').append(Log.getStackTraceString(th)).toString());
    }
}
