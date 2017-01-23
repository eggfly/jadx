package com.umeng.analytics.social;

import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.umeng.analytics.social.d */
public class C4187d {
    private int f14054a;
    private String f14055b;
    private String f14056c;
    private Exception f14057d;

    public C4187d(int i) {
        this.f14054a = -1;
        this.f14055b = BuildConfig.FLAVOR;
        this.f14056c = BuildConfig.FLAVOR;
        this.f14057d = null;
        this.f14054a = i;
    }

    public C4187d(int i, Exception exception) {
        this.f14054a = -1;
        this.f14055b = BuildConfig.FLAVOR;
        this.f14056c = BuildConfig.FLAVOR;
        this.f14057d = null;
        this.f14054a = i;
        this.f14057d = exception;
    }

    public Exception m17067a() {
        return this.f14057d;
    }

    public void m17068a(int i) {
        this.f14054a = i;
    }

    public void m17069a(String str) {
        this.f14055b = str;
    }

    public int m17070b() {
        return this.f14054a;
    }

    public void m17071b(String str) {
        this.f14056c = str;
    }

    public String m17072c() {
        return this.f14055b;
    }

    public String m17073d() {
        return this.f14056c;
    }

    public String toString() {
        return "status=" + this.f14054a + "\r\n" + "msg:  " + this.f14055b + "\r\n" + "data:  " + this.f14056c;
    }
}
