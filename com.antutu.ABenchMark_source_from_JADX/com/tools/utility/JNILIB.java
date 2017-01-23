package com.tools.utility;

import android.content.Context;

public class JNILIB {
    static {
        System.loadLibrary("tools");
    }

    public static native byte[] getBytes(String str, String str2);

    public static native String getData(String str, String str2);

    public static native String getKey(Context context, String str);

    public static native String getString(String str, String str2);
}
