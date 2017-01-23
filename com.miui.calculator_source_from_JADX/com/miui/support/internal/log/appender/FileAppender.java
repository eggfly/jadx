package com.miui.support.internal.log.appender;

import com.miui.support.internal.log.format.Formatter;

public class FileAppender implements Appender {
    private Formatter f2509a;
    private FileManager f2510b;

    public void m4200a(Formatter formatter) {
        this.f2509a = formatter;
    }

    public void m4199a(FileManager fileManager) {
        if (this.f2510b != fileManager) {
            m4198a();
            this.f2510b = fileManager;
        }
    }

    public void m4198a() {
        if (this.f2510b != null) {
            this.f2510b.m4201a();
            this.f2510b = null;
        }
    }
}
