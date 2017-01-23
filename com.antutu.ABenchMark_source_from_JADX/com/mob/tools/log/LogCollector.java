package com.mob.tools.log;

public interface LogCollector {
    public static final int LEVEL_CRASH = 1;
    public static final int LEVEL_NATIVE = 2;
    public static final int LEVEL_NORMAL = 0;

    void log(String str, int i, int i2, String str2, String str3);
}
