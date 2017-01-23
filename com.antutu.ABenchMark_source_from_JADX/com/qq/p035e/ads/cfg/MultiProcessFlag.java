package com.qq.p035e.ads.cfg;

import com.qq.p035e.comm.util.GDTLogger;

/* renamed from: com.qq.e.ads.cfg.MultiProcessFlag */
public class MultiProcessFlag {
    private static boolean f13409a;
    private static boolean f13410b;

    public static boolean isMultiProcess() {
        return f13409a;
    }

    public static void setMultiProcess(boolean z) {
        if (f13410b) {
            GDTLogger.m16603w("MultiProcessFlag has already be setted,reset will not take any effect");
            return;
        }
        f13410b = true;
        f13409a = z;
    }
}
