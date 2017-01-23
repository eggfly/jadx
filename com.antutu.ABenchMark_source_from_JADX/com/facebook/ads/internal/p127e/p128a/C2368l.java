package com.facebook.ads.internal.p127e.p128a;

import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.facebook.ads.internal.e.a.l */
public abstract class C2368l {
    protected String f8256a;
    protected C2370j f8257b;
    protected String f8258c;
    protected byte[] f8259d;

    public C2368l(String str, C2374o c2374o) {
        this.f8256a = BuildConfig.FLAVOR;
        if (str != null) {
            this.f8256a = str;
        }
        if (c2374o != null) {
            this.f8256a += "?" + c2374o.m9140a();
        }
    }

    public String m9126a() {
        return this.f8256a;
    }

    public C2370j m9127b() {
        return this.f8257b;
    }

    public String m9128c() {
        return this.f8258c;
    }

    public byte[] m9129d() {
        return this.f8259d;
    }
}
