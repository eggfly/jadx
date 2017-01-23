package com.mob.tools.log;

import android.util.Log;
import com.mob.tools.MobLog;
import java.lang.Thread.UncaughtExceptionHandler;

public class MobUncaughtExceptionHandler implements UncaughtExceptionHandler {
    private static boolean disable;
    private static boolean isDebug;
    private static UncaughtExceptionHandler oriHandler;

    static {
        isDebug = false;
    }

    public static void closeLog() {
        isDebug = false;
    }

    public static void disable() {
        disable = true;
    }

    public static void openLog() {
        isDebug = true;
    }

    public static void register() {
        if (!disable) {
            oriHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(new MobUncaughtExceptionHandler());
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (isDebug) {
            Log.wtf("MobUncaughtExceptionHandler", th);
        }
        MobLog.getInstance().crash(th);
        if (oriHandler != null) {
            oriHandler.uncaughtException(thread, th);
        }
    }
}
