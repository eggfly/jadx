package com.cmcm.p074a.p075a.p115d;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/* renamed from: com.cmcm.a.a.d.w */
class C2183w extends GZIPOutputStream {
    private int f7574a;

    private C2183w(OutputStream outputStream) {
        super(outputStream);
    }

    public static C2183w m8214a(File file) {
        return new C2183w(new FileOutputStream(file));
    }

    public int m8215a() {
        return this.f7574a;
    }

    public void m8216a(String str) {
        byte[] bytes = str.getBytes();
        write(bytes, 0, bytes.length);
    }

    public void write(byte[] bArr, int i, int i2) {
        this.f7574a += i2;
        super.write(bArr, i, i2);
    }
}
