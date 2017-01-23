package com.igexin.push.p169f.p179a;

import com.igexin.p158b.p159a.p165d.C3665a;
import java.io.InputStream;

/* renamed from: com.igexin.push.f.a.b */
public abstract class C3836b extends C3665a {
    String f12878b;
    byte[] f12879c;
    InputStream f12880d;
    long f12881e;
    public boolean f12882f;

    public C3836b(String str) {
        this.f12878b = str;
    }

    public void m15797a(Exception exception) {
    }

    public void m15798a(byte[] bArr) {
        this.f12882f = false;
        if (bArr != null && bArr.length >= 7 && bArr[5] == 111 && bArr[6] == 107) {
            this.f12882f = true;
        }
    }

    public void m15799b(byte[] bArr) {
        this.f12879c = bArr;
    }

    public String m15800c() {
        return this.f12878b;
    }

    public byte[] m15801d() {
        return this.f12879c;
    }

    public InputStream m15802e() {
        return this.f12880d;
    }

    public long m15803f() {
        return this.f12881e;
    }
}
