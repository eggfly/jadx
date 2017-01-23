package com.miui.support.internal.log.appender.rolling;

import com.miui.support.internal.log.appender.FileManager;

public class RollingFileManager extends FileManager {
    private RolloverStrategy f2523d;

    public RollingFileManager(String str, String str2) {
        super(str, str2);
    }

    public synchronized void m4205a(RolloverStrategy rolloverStrategy) {
        this.f2523d = rolloverStrategy;
    }
}
