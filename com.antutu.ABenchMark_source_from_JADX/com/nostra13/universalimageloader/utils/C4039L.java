package com.nostra13.universalimageloader.utils;

import android.util.Log;
import com.nostra13.universalimageloader.core.ImageLoader;

/* renamed from: com.nostra13.universalimageloader.utils.L */
public final class C4039L {
    private static final String LOG_FORMAT = "%1$s\n%2$s";
    private static volatile boolean writeDebugLogs;
    private static volatile boolean writeLogs;

    static {
        writeDebugLogs = false;
        writeLogs = true;
    }

    private C4039L() {
    }

    public static void m16504d(String str, Object... objArr) {
        if (writeDebugLogs) {
            C4039L.log(3, null, str, objArr);
        }
    }

    @Deprecated
    public static void disableLogging() {
        C4039L.writeLogs(false);
    }

    public static void m16505e(String str, Object... objArr) {
        C4039L.log(6, null, str, objArr);
    }

    public static void m16506e(Throwable th) {
        C4039L.log(6, th, null, new Object[0]);
    }

    public static void m16507e(Throwable th, String str, Object... objArr) {
        C4039L.log(6, th, str, objArr);
    }

    @Deprecated
    public static void enableLogging() {
        C4039L.writeLogs(true);
    }

    public static void m16508i(String str, Object... objArr) {
        C4039L.log(4, null, str, objArr);
    }

    private static void log(int i, Throwable th, String str, Object... objArr) {
        if (writeLogs) {
            String format = objArr.length > 0 ? String.format(str, objArr) : str;
            if (th != null) {
                if (format == null) {
                    format = th.getMessage();
                }
                String stackTraceString = Log.getStackTraceString(th);
                format = String.format(LOG_FORMAT, new Object[]{format, stackTraceString});
            }
            Log.println(i, ImageLoader.TAG, format);
        }
    }

    public static void m16509w(String str, Object... objArr) {
        C4039L.log(5, null, str, objArr);
    }

    public static void writeDebugLogs(boolean z) {
        writeDebugLogs = z;
    }

    public static void writeLogs(boolean z) {
        writeLogs = z;
    }
}
