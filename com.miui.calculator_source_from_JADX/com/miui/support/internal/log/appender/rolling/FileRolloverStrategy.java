package com.miui.support.internal.log.appender.rolling;

public class FileRolloverStrategy implements RolloverStrategy {
    private int f2521a;
    private long f2522b;

    public FileRolloverStrategy() {
        this.f2521a = 1;
        this.f2522b = 1048576;
    }

    public void m4203a(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("index can't be less than 1: " + i);
        }
        this.f2521a = i;
    }

    public void m4204b(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("size can't be less than 1: " + i);
        }
        this.f2522b = (long) i;
    }
}
