package com.igexin.p158b.p159a.p161b.p162a.p163a;

import java.io.BufferedOutputStream;
import java.io.OutputStream;

/* renamed from: com.igexin.b.a.b.a.a.n */
public class C3681n {
    private BufferedOutputStream f12403a;

    public C3681n(OutputStream outputStream) {
        this.f12403a = new BufferedOutputStream(outputStream);
    }

    public void m15039a() {
        this.f12403a.close();
    }

    public void m15040a(byte[] bArr) {
        this.f12403a.write(bArr, 0, bArr.length);
        this.f12403a.flush();
    }
}
