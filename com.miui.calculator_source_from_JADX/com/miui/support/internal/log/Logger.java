package com.miui.support.internal.log;

import com.miui.support.internal.log.appender.Appender;
import java.util.concurrent.CopyOnWriteArrayList;

public class Logger {
    private String f2506a;
    private Level f2507b;
    private CopyOnWriteArrayList<Appender> f2508c;

    public Logger(String str) {
        this.f2506a = str;
        this.f2507b = Level.VERBOSE;
        this.f2508c = new CopyOnWriteArrayList();
    }

    public void m4192a(Level level) {
        this.f2507b = level;
    }

    public void m4193a(Appender appender) {
        if (appender == null) {
            throw new IllegalArgumentException("Appender not allowed to be null");
        }
        this.f2508c.addIfAbsent(appender);
    }
}
