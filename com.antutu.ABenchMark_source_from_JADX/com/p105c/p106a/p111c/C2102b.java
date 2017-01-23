package com.p105c.p106a.p111c;

import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.c.a.c.b */
public class C2102b {
    private String f7381a;
    private String f7382b;
    private String f7383c;
    private String f7384d;
    private long f7385e;
    private long f7386f;

    public C2102b() {
        this.f7381a = BuildConfig.FLAVOR;
        this.f7382b = BuildConfig.FLAVOR;
        this.f7383c = BuildConfig.FLAVOR;
        this.f7384d = BuildConfig.FLAVOR;
        this.f7385e = 0;
        this.f7386f = 0;
    }

    long m7883a() {
        return this.f7385e;
    }

    void m7884a(long j) {
        this.f7386f = j;
    }

    void m7885a(String str) {
        this.f7381a = str;
    }

    public String m7886b() {
        return this.f7381a;
    }

    void m7887b(long j) {
        this.f7385e = j;
    }

    void m7888b(String str) {
        this.f7382b = str;
    }

    public String m7889c() {
        return this.f7382b;
    }

    void m7890c(String str) {
        this.f7383c = str;
    }

    public String m7891d() {
        return this.f7383c;
    }

    void m7892d(String str) {
        this.f7384d = str;
    }

    public String m7893e() {
        return this.f7384d;
    }
}
