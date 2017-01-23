package com.cmcm.p074a.p075a.p112a;

import android.os.Build.VERSION;

/* renamed from: com.cmcm.a.a.a.f */
public class C2112f implements C2111e {
    private boolean f7424a;
    private boolean f7425b;
    private C2109c f7426c;
    private String f7427d;
    private C2111e f7428e;

    public C2112f() {
        if (C2126s.m8036a(1)) {
            this.f7424a = true;
            this.f7425b = false;
        } else if (m7958c()) {
            this.f7424a = true;
            this.f7425b = true;
        } else {
            this.f7424a = false;
            this.f7425b = false;
        }
    }

    private boolean m7958c() {
        try {
            return VERSION.SDK_INT < 21;
        } catch (NoSuchFieldError e) {
            return false;
        }
    }

    public void m7959a() {
        C2126s.m8033a(null);
        if (this.f7426c != null) {
            this.f7426c.m7953b();
        }
    }

    public void m7960a(C2111e c2111e) {
        if (c2111e == null) {
            throw new AssertionError();
        }
        this.f7428e = c2111e;
        C2126s.m8033a((C2111e) this);
        if (this.f7425b) {
            this.f7426c = new C2109c();
            this.f7426c.m7951a(new C2113g(this), 1000);
        }
    }

    public void m7961a(String str, String str2) {
        this.f7428e.m7954a(str, str2);
    }

    public boolean m7962b() {
        return this.f7424a;
    }
}
