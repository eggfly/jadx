package com.aide.engine.service;

import android.content.Context;

public class Native {
    public static Native j6;

    public native int a(int i, int i2);

    public native boolean b(int i, int i2);

    public native int c(int i);

    public native int d(int i);

    public native void init(Context context);

    public native boolean isX86();

    static {
        j6 = new Native();
        System.loadLibrary("AIDE");
    }

    private Native() {
    }
}
