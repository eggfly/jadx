package com.igexin.push.core.bean;

import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.igexin.push.core.bean.l */
public class C3832l extends BaseAction {
    private String f12861a;
    private String f12862b;
    private String f12863c;
    private String f12864d;

    public C3832l() {
        this.f12861a = BuildConfig.FLAVOR;
        this.f12862b = BuildConfig.FLAVOR;
        this.f12863c = BuildConfig.FLAVOR;
        this.f12864d = "false";
    }

    public String m15764a() {
        return this.f12861a;
    }

    public void m15765a(String str) {
        this.f12861a = str;
    }

    public String m15766b() {
        return this.f12862b;
    }

    public void m15767b(String str) {
        this.f12862b = str;
    }

    public String m15768c() {
        return this.f12863c;
    }

    public void m15769c(String str) {
        this.f12863c = str;
    }

    public String m15770d() {
        return this.f12864d;
    }

    public void m15771d(String str) {
        this.f12864d = str;
    }
}
