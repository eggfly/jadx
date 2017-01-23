package com.google.android.gms.auth.api.signin.internal;

/* renamed from: com.google.android.gms.auth.api.signin.internal.a */
public class C3008a {
    static int f10175a;
    private int f10176b;

    static {
        f10175a = 31;
    }

    public C3008a() {
        this.f10176b = 1;
    }

    public int m11700a() {
        return this.f10176b;
    }

    public C3008a m11701a(Object obj) {
        this.f10176b = (obj == null ? 0 : obj.hashCode()) + (this.f10176b * f10175a);
        return this;
    }

    public C3008a m11702a(boolean z) {
        this.f10176b = (z ? 1 : 0) + (this.f10176b * f10175a);
        return this;
    }
}
