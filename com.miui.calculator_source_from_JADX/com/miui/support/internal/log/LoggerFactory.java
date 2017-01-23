package com.miui.support.internal.log;

import android.util.Log;
import com.miui.support.internal.log.appender.Appender;
import com.miui.support.internal.log.appender.FileAppender;
import com.miui.support.internal.log.appender.FileManager;
import com.miui.support.internal.log.appender.LogcatAppender;
import com.miui.support.internal.log.appender.rolling.FileRolloverStrategy;
import com.miui.support.internal.log.appender.rolling.RollingFileManager;
import com.miui.support.internal.log.appender.rolling.RolloverStrategy;
import com.miui.support.internal.log.format.SimpleFormatter;
import com.miui.support.internal.log.receiver.DynamicDumpReceiver;
import com.miui.support.internal.log.util.Config;
import com.miui.support.internal.util.DeviceHelper;
import com.miui.support.util.AppConstants;

public class LoggerFactory {
    public static Logger m4194a() {
        Logger logger = new Logger(Config.f2543b);
        logger.m4193a(new LogcatAppender());
        if (DeviceHelper.f2558j) {
            logger.m4192a(Level.VERBOSE);
        } else {
            logger.m4192a(Level.INFO);
        }
        return logger;
    }

    public static Logger m4196b() {
        String a = Config.m4211a();
        if (a == null) {
            Log.e("LoggerFactory", "Fail to create default logger, log dir is null");
            throw new IllegalStateException("Can't create default file logger");
        }
        m4197c();
        return m4195a(a, Config.f2543b);
    }

    public static Logger m4195a(String str, String str2) {
        Logger logger = new Logger(str2);
        Appender fileAppender = new FileAppender();
        fileAppender.m4200a(new SimpleFormatter());
        RolloverStrategy fileRolloverStrategy = new FileRolloverStrategy();
        fileRolloverStrategy.m4203a(4);
        fileRolloverStrategy.m4204b(1048576);
        FileManager rollingFileManager = new RollingFileManager(str, str2);
        rollingFileManager.m4205a(fileRolloverStrategy);
        fileAppender.m4199a(rollingFileManager);
        logger.m4193a(fileAppender);
        if (DeviceHelper.f2558j) {
            logger.m4192a(Level.VERBOSE);
        } else {
            logger.m4192a(Level.INFO);
        }
        return logger;
    }

    private static void m4197c() {
        new DynamicDumpReceiver().m4210a(AppConstants.m4227a());
    }
}
