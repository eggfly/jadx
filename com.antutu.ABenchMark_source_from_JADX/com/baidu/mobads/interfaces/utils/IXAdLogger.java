package com.baidu.mobads.interfaces.utils;

public interface IXAdLogger {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final String TAG = "BaiduXAdSDK";
    public static final int UNLOGGABLE = -1;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;

    int m7392d(String str);

    int m7393d(String str, String str2);

    int m7394d(String str, Throwable th);

    int m7395d(Throwable th);

    int m7396d(Object... objArr);

    int m7397e(String str);

    int m7398e(String str, Throwable th);

    int m7399e(Throwable th);

    int m7400e(Object... objArr);

    int m7401i(String str);

    int m7402i(String str, String str2);

    int m7403i(String str, Throwable th);

    int m7404i(Object... objArr);

    boolean isLoggable(int i);

    boolean isLoggable(String str, int i);

    int m7405w(String str);

    int m7406w(String str, Throwable th);

    int m7407w(Throwable th);

    int m7408w(Object... objArr);
}
