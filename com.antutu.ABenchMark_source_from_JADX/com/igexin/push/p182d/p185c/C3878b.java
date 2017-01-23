package com.igexin.push.p182d.p185c;

import com.igexin.p158b.p159a.p161b.C3687f;
import com.igexin.push.util.EncryptUtils;

/* renamed from: com.igexin.push.d.c.b */
public class C3878b {
    public int f13044a;
    public byte f13045b;
    public byte f13046c;
    public byte f13047d;
    public byte[] f13048e;
    public int f13049f;
    public byte f13050g;

    public void m15955a(byte[] bArr) {
        if (bArr == null) {
            this.f13044a = 0;
            return;
        }
        this.f13048e = bArr;
        this.f13044a = bArr.length;
    }

    public byte[] m15956a() {
        if (this.f13048e == null) {
            return null;
        }
        byte[] bArr = new byte[(this.f13044a + 11)];
        int a = C3687f.m15074a(EncryptUtils.getPacketId(), bArr, 0);
        a += C3687f.m15074a((int) (System.currentTimeMillis() / 1000), bArr, a);
        a += C3687f.m15084b(this.f13044a, bArr, a);
        C3687f.m15077a(this.f13048e, 0, bArr, a + C3687f.m15088c(this.f13045b, bArr, a), this.f13048e.length);
        return bArr;
    }
}
