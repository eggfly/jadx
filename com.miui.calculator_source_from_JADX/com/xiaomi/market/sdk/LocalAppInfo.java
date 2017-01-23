package com.xiaomi.market.sdk;

public class LocalAppInfo {
    public String f4593a;
    public String f4594b;
    public int f4595c;
    public String f4596d;
    public String f4597e;
    public String f4598f;
    public String f4599g;
    public boolean f4600h;

    private LocalAppInfo() {
        this.f4593a = "";
        this.f4594b = "";
        this.f4595c = 0;
        this.f4596d = "";
        this.f4597e = "";
        this.f4598f = "";
        this.f4599g = "";
        this.f4600h = false;
    }

    public static LocalAppInfo m6191a(String str) {
        LocalAppInfo localAppInfo = new LocalAppInfo();
        localAppInfo.f4593a = str;
        return localAppInfo;
    }
}
