package com.igexin.p158b.p159a.p161b.p162a.p163a;

import java.io.BufferedInputStream;
import java.io.InputStream;

/* renamed from: com.igexin.b.a.b.a.a.m */
public class C3680m {
    BufferedInputStream f12402a;

    public C3680m(InputStream inputStream) {
        this.f12402a = new BufferedInputStream(inputStream);
    }

    public int m15037a(byte[] bArr) {
        return this.f12402a.read(bArr);
    }

    public void m15038a() {
        this.f12402a.close();
    }
}
